import java.io.File;
import java.util.*;

public class DayOne implements Day {
    private List<Integer> input = new ArrayList<>();

    public DayOne() { }

    public int solve() {
        try {
            File text = new File("./input1.txt");
            Scanner scanner = new Scanner(text);

            while(scanner.hasNext()){
                int next = scanner.nextInt();
                input.add(next);
            }

            return solve(input);

        } catch (Exception x) {
            return -1;
        }
    }

    private int solve(List<Integer> input) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < input.size(); i++){
            if(map.containsKey(input.get(i))){
                return map.get(input.get(i)) * input.get(i);
            }
            else {
                map.put(2020 - input.get(i), input.get(i));
            }
        }

        return 0;
    }

    public int solvePartTwo() {
        return solvePartTwo(input);
    }

    private int solvePartTwo(List<Integer> input) {
        for(int i = 0; i < input.size(); i++){
            int result = partTwoHelper(i + 1, 2020 - input.get(i), input);
            if(result != -1){
                return result * input.get(i);
            }
        }

        return 0;
    }

    private int partTwoHelper(int start, int sum, List<Integer> input){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = start; i < input.size(); i++){
            if(map.containsKey(input.get(i))){
                return map.get(input.get(i)) * input.get(i);
            }
            else {
                map.put(sum - input.get(i), input.get(i));
            }
        }

        return -1;
    }

}
