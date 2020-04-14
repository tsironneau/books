package chapter7;

/**
 * <b>Item 48 : Use caution when making streams parallel</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>Stream.iterate or intermediate operation limit </li>
 *     <li>Parallelizing a stream can lead to poor performance, incorrect result and unpredicted behaviours</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li>Only when it is really needed for optimization</li>
 *     <li>Only when we have ensured that our code remains correct in parallel execution</li>
 *     <li>Only when we have tested that performances are really increased by parallelization</li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>The best terminal operation for parallelization is reduction</li>
 *     <li>collect terminal operation (mutable reductions) is costly for parallelization</li>
 * </ul>
 */
public class Item48_UseCautionWhenMakingStreamsParallel {




}
