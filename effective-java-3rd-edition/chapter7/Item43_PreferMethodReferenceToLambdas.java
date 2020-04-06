package chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Item 43 : Prefer method reference to lambdas</p>
 * <p>Why ?</p>
 * <ul>
 *     <li>Even more succinct than lambdas</li>
 *     <li>Can eliminate parameters declaration boilerplate</li>
 *     <li></li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>When lambdas are shorter and clearer, when the method called is in the same class</li>
 * </ul>
 */
public class Item43_PreferMethodReferenceToLambdas {

    private void useOfMethodReference(){
        final Map<String, Integer> map = new HashMap<>();
        map.merge("key", 1, (x,y) -> x + y);
        map.merge("key", 1, Integer::sum);
    }

}
