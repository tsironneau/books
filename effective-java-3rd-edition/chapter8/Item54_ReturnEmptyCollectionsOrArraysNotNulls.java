package chapter8;

import java.util.*;

/**
 * <b>Item 54 : Return empty collections or arrays, not nulls</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>Returning null is error prone, the client has to think of the null check</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li></li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>Avoid empty collection creation using Collection.emptyList/Set/Map()</li>
 *     <li>Do not preallocate array for List.toArray(T[])</li>
 * </ul>
 */
public class Item54_ReturnEmptyCollectionsOrArraysNotNulls {

    public static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];

    private Collection<Integer> neverReturnNullCollection(){
        final Map<Integer, String> emptyMap = Collections.emptyMap();
        final Set<Long> emptySet = Collections.emptySet();
        final List<Integer> emptyList = Collections.emptyList();
        return emptyList;
    }

    private void doNotPreallocateArray(){
        List<Integer> integerList = new ArrayList<>();
        integerList.toArray(EMPTY_INTEGER_ARRAY);//if the array is too small, another will be created
    }

}
