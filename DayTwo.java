import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DayTwo implements Day {
    class Input {
        public int lowerBound;
        public int upperBound;
        public char character;
        public String password;

        public Input(int lowerBound, int upperBound, char character, String password) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.character = character;
            this.password = password;
        }
    }

    private List<Input> inputList = new ArrayList<>();

    public DayTwo() { }

    public int solve() {
        try {
            File text = new File("./input2.txt");
            Scanner scanner = new Scanner(text);

            while(scanner.hasNext()){
                String bounds = scanner.next();
                int splitter = bounds.indexOf('-');
                int lower = Integer.parseInt(bounds.substring(0,splitter));
                int upper = Integer.parseInt(bounds.substring(splitter+1));
                char character = scanner.next().charAt(0);
                String password = scanner.next();
                inputList.add(new Input(lower, upper, character, password));
            }

            return solve(inputList);

        } catch (Exception x) {
            x.printStackTrace();
            return -1;
        }
    }

    private int solve(List<Input> inputList) {
        int validPasswords = 0;

        for (Input input: inputList) {
            String password = input.password;
            int occurances = 0;

            for(int i = 0; i < password.length(); i++){
                if(password.charAt(i) == input.character){
                    occurances++;
                }
            }

            if (occurances <= input.upperBound && occurances >= input.lowerBound){
                validPasswords++;
            }

        }
        return validPasswords;
    }

    public int solvePartTwo() {
        return solvePartTwo(inputList);
    }

    private int solvePartTwo(List<Input> inputList) {
        int validPasswords = 0;

        for (Input input: inputList) {
            String password = input.password;

            char lower = password.charAt(input.lowerBound - 1);
            char upper = password.charAt(input.upperBound - 1);

            if (lower == input.character && upper != input.character){
                validPasswords++;
            }
            else if (lower != input.character && upper == input.character){
                validPasswords++;
            }
        }
        return validPasswords;
    }

}
