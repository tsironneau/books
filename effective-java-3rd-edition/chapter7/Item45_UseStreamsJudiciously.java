package chapter7;

/**
 * <b>Item 45 : Use streams judiciously</b>
 * <p>Why ?</p>
 * <ul>
 *     To do some operations on a sequence of elements like
 *     <li>Transform</li>
 *     <li>Filter</li>
 *     <li>Combine</li>
 *     <li>Accumulate, group</li>
 *     <li>Search</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>Overuse of stream can make programs hard to read and maintain</li>
 *     <li>When we need specificity of code blocks like modify a local variable or return/break/continue</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>When there is no explicit type declared a descriptive naming of the lambdas parameter is essential for readability</li>
 *     <li>Helper methods are essentials for readability of streams pipelines</li>
 *     <li>Refrain from using stream to process chars</li>
 *     <li>Refactor loops to streams when it makes sense</li>
 * </ul>
 */
public class Item45_UseStreamsJudiciously {

    public static void main(String[] args) {
        refrainFromUsingCharStreams();
    }

    private static void refrainFromUsingCharStreams() {
        "Hello".chars().forEach(System.out::print);// prints 72101108108111, chars() returns an IntStream
    }

}
