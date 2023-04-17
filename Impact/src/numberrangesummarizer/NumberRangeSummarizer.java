package numberrangesummarizer;
import java.util.Collection;

public interface NumberRangeSummarizer {
    // Collect the input
    Collection<Integer> collect(String input);

    // Get the summarized string
    String summarizeCollection(Collection<Integer> input);
}
