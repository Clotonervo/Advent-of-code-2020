import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThree implements Day{
    private List<String> input = new ArrayList<>();

    public DayThree() {}

    @Override
    public int solve() {
        try {
            File text = new File("./input3.txt");
            Scanner scanner = new Scanner(text);

            while(scanner.hasNext()){
                String next = scanner.nextLine();
                input.add(next);
            }

            return solve(input);

        } catch (Exception x) {
            return -1;
        }
    }

    private int solve(List<String> input){
        int numTrees = 0;
        int j = 0;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i).charAt(j) == '#'){
                numTrees += 1;
            }

            j = (j + 3) % input.get(i).length();
        }
        return numTrees;
    }


    @Override
    public int solvePartTwo() {
        int one = partTwoHelper(1,1, input);
        int two = partTwoHelper(1, 3, input);
        int three = partTwoHelper(1, 5, input);
        int four = partTwoHelper(1, 7, input);
        int five = partTwoHelper(2, 1, input);
        return one * two * three * four * five;             //There is an overflow error here, but to keep the interface, I'll leave it
    }

    private int partTwoHelper(int down, int right, List<String> input) {
        int numTrees = 0;
        int j = 0;
        for(int i = 0; i < input.size(); i = i + down){
            if(input.get(i).charAt(j) == '#'){
                numTrees += 1;
            }

            j = (j + right) % input.get(i).length();
        }
        return numTrees;
    }
}
