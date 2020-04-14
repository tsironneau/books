package chapter7;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * <b>Item 47 : Prefer Collection to Stream as return type</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>Stream does not extends Iterable and then are not compatible with foreach loop</li>
 *     <li>Collection provides a stream() method therefore it is usable in both context of iteration and stream</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>If we know that the returned element will be used only in stream context</li>
 *     <li>When the sequence of elements is very large</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>If in a future version of Java, Stream implements Iterable then we should feel free to return Stream</li>
 * </ul>
 */
public class Item47_PreferCollectionToStreamAsReturnType {

    public static void main(String[] args) {
        //Need a cast to compile because type inference doesn't work here
        //Although Stream has a iterator() method, it doesn't extends Iterable.
        for (ProcessHandle processHandle : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {

        }
    }

    //Adapter for Stream to Iterable (doesn't not exists in JDK)
    private static <E> Iterable<E> iterableOf(final Stream<E> stream){
        return stream::iterator;
    }

    //Adapter from Iterable to Stream
    private static <E> Stream<E> streamOf(final Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator(), false);
    }

}
