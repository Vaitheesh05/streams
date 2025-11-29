import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
This file demonstrates the power of Java Streams for processing collections,
contrasting the modern, functional approach with the traditional imperative loop.

The goal is to filter an array of integers and print only the numbers greater than 5.

1. The Traditional Way (Imperative):
You would use a for-each loop and an if-statement. This code is explicit about *how* to iterate
and filter, mixing the "what" with the "how".

   for(Integer i : numbers){
       if(i > 5){
           System.out.println(i);
       }
   }

2. The Streams Way (Declarative):
This approach focuses on *what* you want to achieve, not how.

   a. Create a Stream: `Arrays.stream(numbers)` converts the array into a stream, which is a
      sequence of elements that can be processed.

   b. Intermediate Operation (`filter`): `filter()` is a lazy operation that creates a new stream
      containing only the elements that satisfy a given condition (a `Predicate`). In the verbose
      form, this is an anonymous inner class. The stream is not processed yet.

         .filter(new Predicate<Integer>() {
             @Override
             public boolean test(Integer integer) {
                 return integer > 5;
             }
         });

   c. Terminal Operation (`forEach`): `forEach()` is a terminal operation that triggers the
      processing of the stream and consumes its elements. It executes an action for each element.
      After this, the stream cannot be reused.

         .forEach(System.out::println);

3. The Concise Streams Way:
By using a lambda expression for the predicate (`number -> number > 5`), the entire operation
becomes a single, highly readable chain of method calls. This is the preferred modern approach.

   Arrays.stream(numbers)
         .filter(number -> number > 5)
         .forEach(System.out::println);
*/
public class Streams3 {
    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};

        // The modern, concise, and declarative way using a stream pipeline.
        Arrays.stream(numbers)
                .filter(number -> number > 5) // Intermediate operation: filters elements
                .forEach(System.out::println); // Terminal operation: consumes elements
    }
}
