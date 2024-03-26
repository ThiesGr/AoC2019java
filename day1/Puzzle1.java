package day1;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

class Puzzle1 {
    public static void main(String[] args) {
        var path = Paths.get("day1", "input.txt");

        try (var stream = Files.lines(path)) {
            var result = stream.mapToInt(s -> Integer.parseInt(s)).
                map(i -> i / 3 - 2).sum();
            System.out.println(result);
        }
        catch(IOException e) {
            System.out.format("Error reading file: %s", e.toString());
        }
    }
}