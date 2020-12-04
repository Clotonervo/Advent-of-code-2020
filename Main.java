public class Main {

    public static void main(String args[]) {
        System.out.println("Starting Advent of Code...");
        System.out.println("Solutions:");
        DayClassFactory dayClassFactory = new DayClassFactory();

        for(int i = 1; i < 25; i++){
            Day day = dayClassFactory.getDay(i);
            System.out.print("Day" + i + ": " + day.solve());
            System.out.print(", Part 2 - " + day.solvePartTwo());
            System.out.println();
        }

    }
} 