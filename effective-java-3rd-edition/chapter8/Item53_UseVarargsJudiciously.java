package chapter8;

/**
 * <b>Item 53 : Use varargs judiciously</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>Do not use varargs for methods that requires one or more arguments, instead declare a method with two parameters:
 *     the first, then the varargs</li>
 *     <li>Take care if performances are needed, varargs creates and initialize an array</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li></li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li></li>
 * </ul>
 */
public class Item53_UseVarargsJudiciously {

    private void oneOrMoreArguments(int firstArg, int... remainingArgs){}

    private void forPerformancePurpose(int withOneArg){}

    private void forPerformancePurpose(int withOneArg, int withTwoArgs){}

    private void forPerformancePurpose(int withOneArg, int withTwoArgs, int... withMOreArgs){}

}
