package by.bsuir.lab1.task9;
// task 10 done
// task 11 done
public class Main {

    public static void main(String[] args) {
        var busket = new Busket();
        int blueBallsCount = 9;
        int notBlueBallsCount = 11;
        for (int i = 0; i < blueBallsCount; i++) {
            busket.Add(new Ball(Color.BLUE));
        }

        for (int i = 0; i < notBlueBallsCount; i++) {
            busket.Add(new Ball(Color.NOT_BLUE));
        }

        System.out.println("Busket is filled");
        System.out.println("Total weight is " + busket.GetTotalWeight());
        System.out.println("There are " + busket.GetBallsWithSpecificColorCount(Color.BLUE) + " blue balls");
    }
}
