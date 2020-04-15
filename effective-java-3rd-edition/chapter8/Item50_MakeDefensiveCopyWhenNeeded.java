package chapter8;

/**
 * <b>Item 50 : Make defensive copy when needed</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>We must make it sure to keep classes invariant </li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>When the cost of making defensive copies is heavy, AND the client is trusted</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>Defensive copies are made before checking parameter validity</li>
 *     <li>Do not use the <code>clone()</code> method to make defensive copies, for non-final class you can make copies of untrusted subclasses</li>
 *     <li>Return defensive copies of mutable parameters</li>
 *     <li>When we use immutable objects as components we are safe</li>
 * </ul>
 */
public class Item50_MakeDefensiveCopyWhenNeeded {

}
