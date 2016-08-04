import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * Calculate Fibonacci numbers using {@link java.util.Map#computeIfAbsent(Object, Function)}.
 *
 * @author codingever
 */
public class FibonacciMap {
    public static void main(String[] args) {
        final int n = 80;
        fibMap(n);
        /* 0 -> 0
        * 1 -> 1
        * 2 -> 1
        * 3 -> 2
        * 4 -> 3
        * 5 -> 5
        * */
    }

    private static void fibMap(int n) {
        final Map<Integer, Long> map = new HashMap<>();
        LongStream.generate(() -> map.computeIfAbsent(
            map.size(), index -> map.getOrDefault(index - 1, 0L) + map.getOrDefault(index - 2, index.longValue())
        )).limit(n).forEach(System.out::println);
    }
}
