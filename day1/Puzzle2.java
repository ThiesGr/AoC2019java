package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle2 {
    static int calculateFuel(int mass){
        var fuel = mass / 3 - 2;
        if (fuel <= 0) {
            return 0;
        }
        else {
            return fuel + calculateFuel(fuel);
        }
    }
    public static void main(String[] args) {
        var path = Paths.get("day1", "input.txt");

        try (var stream = Files.lines(path)) {
            var result = stream.mapToInt(s -> Integer.parseInt(s)).
                map(i -> calculateFuel(i)).sum();
            System.out.println(result);
        }
        catch(IOException e) {
            System.out.format("Error reading file: %s", e.toString());
        }
    }
}
