package chapter8;

import java.util.Optional;

/**
 * <b>Item 55 : Return optionals judiciously</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>To ensure the client does something about the case of an empty value return</li>
 *     <li></li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>When a collections is returned -> prefer an empty collection</li>
 *     <li>When a boxed primitive is returned -> prefer OptionalInt, OptionalLong, OptionalDouble </li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>Using if(Optional.isPresent()) is bad smell, prefer use of orElse, orElseThrow...</li>
 * </ul>
 */
public class Item55_ReturnOptionalsJudiciously {

    private void test(){
        Optional<String> s = Optional.of("aString");
        s.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("String not present")
        );

        System.out.println(s.orElseThrow());
    }

}
