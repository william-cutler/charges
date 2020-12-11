package charges.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/** A collection of functional utility methods that operate on a generic Java list. */
public class ListUtil {

  /**
   * Returns whether at least one element in the list satisfies the given condition. Returns false
   * if given an empty list.
   *
   * @param list the collection of elements upon which the condition is tested.
   * @param condition the predicate used to test the elements of the list
   * @param <K> the type of elements in the list and type of argument to predicates.
   * @return whether at least one element in the list satisfies the given condition.
   */
  public static <K> boolean ormap(List<K> list, Predicate<K> condition)
      throws IllegalArgumentException {
    if (list == null || condition == null) {
      throw new IllegalArgumentException("Neither list nor condition can be null.");
    }
    for (K element : list) {
      if (condition.test(element)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns whether no elements in the list fail the given condition. Returns true if given an
   * empty list.
   *
   * @param list the collection of elements upon which the condition is tested.
   * @param condition the predicate used to test the elements of the list
   * @param <K> the type of elements in the list and type of argument to predicates.
   * @return whether no elements in the list fail to satisfy the given condition.
   */
  public static <K> boolean andmap(List<K> list, Predicate<K> condition)
      throws IllegalArgumentException {
    if (list == null || condition == null) {
      throw new IllegalArgumentException("Neither list nor condition can be null.");
    }
    for (K element : list) {
      if (!condition.test(element)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns a list where each element in the original list is mapped according to the given
   * function to an element in the new list. Order is maintained.
   *
   * @param list the initial list to map.
   * @param func the mapping function.
   * @param <T> the type of the original list.
   * @param <R> the type of the resulting list.
   * @return the mapped list.
   * @throws IllegalArgumentException if either the list or the function is null.
   */
  public static <T, R> List<R> map(List<T> list, Function<T, R> func)
      throws IllegalArgumentException {
    List<R> result = new ArrayList<>();
    if (list == null || func == null) {
      throw new IllegalArgumentException("Neither list nor condition can be null.");
    }
    for (T element : list) {
      result.add(func.apply(element));
    }
    return result;
  }

  /**
   * Returns the maximal value in the list according to the comparator.
   *
   * @param list the list of elements.
   * @param comp the comparator.
   * @param <T> the type of elements in the list.
   * @return the element that gives the maximum value, or null if this list is empty.
   */
  public static <T> T max(List<T> list, Comparator<T> comp) {
    if (list == null || comp == null) {
      throw new IllegalArgumentException("Neither list nor comparator can be null.");
    }
    if (list.size() == 0) {
      return null;
    } else {
      T max = list.get(0);
      for (T element : list) {
        if (comp.compare(element, max) > 0) {
          max = element;
        }
      }
      return max;
    }
  }

  public static <T> int indexSatisfying(List<T> list, Predicate<T> pred) {
    for(int index = 0; index < list.size(); index += 1) {
      if(pred.test(list.get(index))) {
        return index;
      }
    }
    return -1;
  }

  public static <T> T elementSatisfying(List<T> list, Predicate<T> pred) {
    int index = indexSatisfying(list, pred);
    if(index < 0) {
      return null;
    } else {
      return list.get(index);
    }
  }
}
