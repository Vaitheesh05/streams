import java.util.stream.Stream;

/**
 * STATELESS vs STATEFUL operations in Java Streams
 * ------------------------------------------------
 *
 * 1) Stateless operations:
 *    - Examples: filter(), map(), peek(), flatMap()
 *    - These process each element independently.
 *    - They do NOT need to remember previous elements.
 *    - Order of processing is the same as the input order
 *      (in a sequential stream).
 *
 * 2) Stateful operations:
 *    - Examples: sorted(), distinct(), limit(), skip()
 *    - These MUST look at multiple elements at once.
 *      e.g., sort needs all elements to determine order.
 *    - They may buffer, reorder, or delay output.
 *
 * 3) Using peek() to debug:
 *    - peek() is stateless and only observes the element.
 *    - First peek shows original encounter order.
 *    - After filter (stateless) — order remains same.
 *    - After sorted (stateful) — order changes.
 *
 * 4) Why this is important:
 *    - Stateless operations → fast, low memory, predictable.
 *    - Stateful operations → may require internal buffering.
 *
 * This stream example demonstrates the difference clearly.
 */
public class Streams4 {
    public static void main(String[] args) {
        //Here the stream of an element is processing one by one
        //Because the filter is an intermediate stateless operation that doesn't maintain the state
//        Stream.of(1,2,3,4,5,6,7,8,9,10)
//                .peek(num -> {
//                    System.out.println("peek element from the stream "+num);
//                })
//                .filter(num -> num % 2 ==0)
//                .peek(num -> {
//                    System.out.println("Filter done for the element " + num);
//                })
//                .forEach(n -> System.out.println("Final output: " + n));


        //Here the sorted function is a stateful intermediate operation that maintains a state
        //sorted method which has memory internally
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .peek(num -> {                                          //stateless
                    System.out.println("peek element from the stream " + num);
                })
                .filter(num -> num % 2 ==0)                             //stateless
                .peek(num -> {                                          //stateless
                    System.out.println("Filter done for the element " + num);
                })
                .sorted()                                                      //stateful
                .peek(num -> {                                          //stateful debug
                    System.out.println("Sorted done for the element " + num);
                })
                .forEach(n -> System.out.println("Final output: " + n));



    }
}
