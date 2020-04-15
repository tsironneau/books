package chapter8;

import java.util.Objects;

/**
 * <b>Item 49 : Check parameters for validity</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>To detect errors when they occur</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>If the validity check is too expensive/impractical</li>
 *     <li>It the validity check is made implicitly in the process</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>Since Java 7 : Objects.requireNonNull</li>
 *     <li>Since Java 9 : Objects.check*Index</li>
 *     <li>assert can be used in non-public methods, assuming that public methods correctly check their parameters</li>
 *     <li>Don't add to much restrictions on parameters, and keep methods as general as possible</li>
 * </ul>
 */
public class Item49_CheckParametersForValidity {

    public static void main(String[] args) {
        final String obj = "object non-null";
        String aString;
        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj, "error message");
        Objects.requireNonNull(obj, () -> "message from a supplier");
        aString = Objects.requireNonNullElse(obj, "default object");
        aString = Objects.requireNonNullElseGet(obj, () -> "default from supplier");

        final int index = 1;
        final int length = 5;
        final int toIndex = 4;
        final int size = 2;
        Objects.checkIndex(index, length);
        Objects.checkFromToIndex(index, toIndex, length);
        Objects.checkFromIndexSize(index, size, length);
    }
}
