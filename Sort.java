import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {
    private List<String> list;

    public Sort(String inputFile, String outputFile) {
        list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.sort(Comparator.comparingInt(String::length));

        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (String line : list) {
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };

    }
}

