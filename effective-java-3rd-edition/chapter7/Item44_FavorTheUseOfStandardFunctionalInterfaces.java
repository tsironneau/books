package chapter7;

import java.util.function.*;

/**
 * <b>Item 44 : Favor the use of standard functional interfaces</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>Makes API easier to learn</li>
 *     <li>Provides interoperability</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>When the interface will be commonly used and will benefit to have a descriptive name</li>
 *     <li>When the interface has a strong contract associated (like Comparator)</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>Always use @FunctionalInterface annotation on functional interfaces</li>
 * </ul>
 */
public class Item44_FavorTheUseOfStandardFunctionalInterfaces {

    private void sixBasicTypes(){
        unaryOperator(String::trim, "  string with spaces before and after    ");
        binaryOperator(String::concat, "Hello ", "BinaryOperator !");
        predicate(s -> s.equals("Hello Predicate"), "Hello Predicate");
        function(String::length, "String with size equals to 29");
        supplier(() -> "Hello Supplier");
        consumer(System.out::println, "Hello Consumer");
    }

    private void unaryOperator(UnaryOperator<String> unaryOperator, String s){
        System.out.println(unaryOperator.apply(s));
    }

    private void binaryOperator(BinaryOperator<String> binaryOperator, String s1, String s2) {
        System.out.println(binaryOperator.apply(s1,s2));
    }

    private void predicate(Predicate<String> predicate, String s){
        System.out.println(predicate.test(s));
    }

    private void function(Function<String, Integer> function, String s){
        System.out.println(function.apply(s));
    }

    private void supplier(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    private void consumer(Consumer<String> consumer, String s) {
        consumer.accept(s);
    }

    public static void main(String[] args) {
        new Item44_FavorTheUseOfStandardFunctionalInterfaces().sixBasicTypes();
    }

}
