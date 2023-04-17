package numberrangesummarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Ignore non-numeric values
            }
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input.isEmpty()) {
            return "";
        }

        List<Integer> sorted = new ArrayList<>(input);
        Collections.sort(sorted);

        StringBuilder summary = new StringBuilder();
        int start = sorted.get(0);
        int prev = start;
        for (int i = 1; i < sorted.size(); i++) {
            int current = sorted.get(i);
            if (current - prev > 1) {
                if (start == prev) {
                    summary.append(start).append(", ");
                } else {
                    summary.append(start).append("-").append(prev).append(", ");
                }
                start = current;
            }
            prev = current;
        }
        if (start == prev) {
            summary.append(start);
        } else {
            summary.append(start).append("-").append(prev);
        }

        return summary.toString();
    }
}
