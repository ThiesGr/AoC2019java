package day2;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.regex.Pattern;

class Puzzle1 {
    public static void main(String[] args) {
        var path = Paths.get("day2", "input.txt");

        try {
            var programString = Files.readString(path);
            var program = Pattern.compile(",").
                    splitAsStream(programString).
                    mapToInt(s -> Integer.parseInt(s)).toArray();

            program[1] = 12;
            program[2] = 2;

            for (int counter = 0; program[counter] != 99 ; counter += 4) {
                program[program[counter+3]] = switch(program[counter]) {
                    case 1 -> program[program[counter+1]] + program[program[counter+2]];
                    case 2 -> program[program[counter+1]] * program[program[counter+2]];
                    default -> throw new IllegalStateException("Invalid opcode");
                };
            }

            System.out.println(program[0]);
        }
        catch(IOException e) {
            System.out.format("Error reading file: %s", e.toString());
        }
    }
}