
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
/**
 *A Stream is a sequence of elements from a source that supports aggregate operations. They were introduced in Java 8.
 *Here's a breakdown of the problems they solve and why you might need them:
 *1.  **Functional-Style Operations: ** Streams allow you to use a functional approach to process collections of data. Instead of writing loops to iterate over elements, you can use methods like `map`, `filter`, `reduce`, and `forEach`. This makes your code more declarative, concise, and often easier to read.

 *2.  **Lazy Evaluation: ** Stream operations are lazy. This means that intermediate operations (like `map` or `filter`) are not executed until a terminal operation (like `forEach` or `collect`) is called. This allows the stream pipeline to be optimized. For example, if you have a `filter` followed by a `map`, the `map` operation will only be performed on the elements that pass the filter.

 *3.  **Parallelism: ** Streams can be easily parallelized by calling the `parallel()` method. This can lead to significant performance improvements for large data sets on multi-core processors, without you having to write complex multi-threading code.

 *4.  **No Data Storage: ** A stream is not a data structure that stores elements. It just conveys elements from a source through a pipeline of computational steps.

 *5.  **Consumable: ** The elements of a stream are only visited once during the life of a stream. Like an `Iterator`, a new stream must be generated to revisit the same elements of the source.

 *In short, you should use Streams when you want to perform SQL-like operations on your data, in a more expressive and efficient way than traditional loops. They are a powerful tool for processing data in modern Java.
 */
//Streams is basically a flow of data (it would be any number of data)
public class Streams1 {
    public static void main(String[] args) {

        //legacy method of creating a supplier which is Functional interface of only get method whenever the stream is asked for data
        Supplier<String> supplier = new Supplier<String>() {
            int count = 0;
            @Override
            public String get() {
                return "Hello " + count++;
            }
        };

        //legacy method of creating a consumer which is Functional interface of only accept method whenever the stream is asked to consume data
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Stream<String> stream = Stream.generate(supplier);  //This is the data source where the stream is flowing from
        stream.forEach(consumer); //This is the terminal operation of which the stream has to be run to consume the data of which the parameters is asking for the consumer
    }
}
