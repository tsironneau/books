package chapter8;

/**
 * <b>Item 52 : Use overloading judiciously</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>Avoid overloaded methods with the same number of parameters</li>
 *     <li>To avoid confusing method, ie : remove() method from collection with an Integer collection</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>When parameters types are radically different, no parameters can be cast to both parameter types</li>
 *     <li>When overloaded methods do the same things (one method call the other)</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>Different functional interfaces are not radically different</li>
 * </ul>
 */
public class Item52_UseOverloadingJudiciously {
}
