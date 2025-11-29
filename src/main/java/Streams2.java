import java.util.function.Consumer;
import java.util.stream.Stream;

/**
This file demonstrates the evolution of writing a Consumer in Java,
showing how modern Java features can drastically reduce boilerplate code.

1. The Old Way: Anonymous Inner Class
Before Java 8, if you wanted to pass a behavior to a method, you had to
create an instance of an anonymous inner class that implemented an interface.
It's verbose and clunky.

    Consumer<Integer> consumer = new Consumer<Integer>() {
        @Override
        public void accept(Integer s) {
            System.out.println(s);
        }
    };

2. The New Way: Lambda Expression
Java 8 introduced lambda expressions, a way to create anonymous functions.
This is much more concise. The compiler infers the type of 's'.

    Consumer<Integer> consumer = (s) -> System.out.println(s);

3. The Best Way: Method Reference
When your lambda expression simply calls an existing method, you can use a
method reference for even cleaner code. `System.out::println` is a reference
to the `println` method on the `System.out` object. This is the most
declarative and readable form. It reduces the boilerplate code.

    Consumer<Integer> consumer = System.out::println;

By using a method reference directly in the stream forEach method, you can
reduce multiple lines of code into a single, expressive statement.
*/
public class Streams2 {
    public static void main(String[] args) {

        // The stream is created and a method reference is passed to forEach.
        // This is the most concise and readable version of the code.
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .forEach(System.out::println);
    }
}
