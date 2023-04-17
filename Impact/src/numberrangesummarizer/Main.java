package numberrangesummarizer;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers (separated by commas): ");
        String input = scanner.nextLine();

        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        Collection<Integer> numbers = summarizer.collect(input);
        String summary = summarizer.summarizeCollection(numbers);

        System.out.println(summary);
    }

}
