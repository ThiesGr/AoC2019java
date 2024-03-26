package day2;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.regex.Pattern;

class Puzzle2 {
    public static void main(String[] args) {
        var path = Paths.get("day2", "input.txt");

        try {
            var programString = Files.readString(path);
            var program_ = Pattern.compile(",").
                    splitAsStream(programString).
                    mapToInt(s -> Integer.parseInt(s)).toArray();

            for (var noun = 0 ; noun < 100 ; noun++) {
                for(var verb = 0 ; verb < 100 ; verb++) {
                    var program  = program_.clone();

                    program[1] = noun;
                    program[2] = verb;
        
                    for (int counter = 0; program[counter] != 99 ; counter += 4) {
                        program[program[counter+3]] = switch(program[counter]) {
                            case 1 -> program[program[counter+1]] + program[program[counter+2]];
                            case 2 -> program[program[counter+1]] * program[program[counter+2]];
                            default -> throw new IllegalStateException("Invalid opcode");
                        };
                    }
                    if (program[0] == 19690720) {
                        System.out.format("result: %d noun: %d verb: %d%n", 100 * noun + verb, noun, verb);
                    }
                }
            }
        }
        catch(IOException e) {
            System.out.format("Error reading file: %s", e.toString());
        }
    }
}