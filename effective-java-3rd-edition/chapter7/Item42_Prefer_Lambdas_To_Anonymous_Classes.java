package chapter7;

import java.util.function.BiFunction;

/**
 * <b>Item 42 : Prefer Lambdas to anonymous classes</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>More concise then anonymous classes</li>
 *     <li>Easier way to represent small function objects</li>
 *     <li>Opens the door to functional programming</li>
 * </ul>
 * <p>Why not ?</p>
 * <ul>
 *     <li>When lambdas body is not small (3 lines is a good maximum)</li>
 *     <li>If we need to access to the object inside the body (with this.)</li>
 * </ul>
 */
public class Item42_Prefer_Lambdas_To_Anonymous_Classes {

    enum BooleanOperations {
        OR((x,y) -> x || y),
        AND((x,y) -> x && y)
        ;

        private final BiFunction<Boolean, Boolean, Boolean> op;

        BooleanOperations(BiFunction<Boolean, Boolean, Boolean> op) {
            this.op = op;
        }

        boolean apply(boolean x, boolean y){
            return op.apply(x, y);
        }
    }


}
