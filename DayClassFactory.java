public class DayClassFactory {

    public DayClassFactory() {}

    public Day getDay(int number){
        switch (number){
            case 1:
                return new DayOne();
            case 2:
                return new DayTwo();
            case 3:
                return new DayThree();
            case 4:
                return new DayFour();
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                return new DefaultDay();
        }


        return new DayTwo();
    }
}
