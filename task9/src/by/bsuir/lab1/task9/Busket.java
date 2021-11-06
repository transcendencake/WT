package by.bsuir.lab1.task9;

import java.util.ArrayList;
import java.util.List;

public class Busket {
    private List<Ball> balls;

    public Busket(){
        balls = new ArrayList<Ball>();
    }

    public void Add(Ball ball) {
        this.balls.add(ball);
    }

    public void Remove(Ball ball) {
        this.balls.remove(ball);
    }

    public int GetBallsWithSpecificColorCount(Color color) {
        int count = 0;
        for (Ball ball : this.balls) {
            if (ball.getColor() == color) {
                count++;
            }
        }
        return count;
    }

    public double GetTotalWeight() {
        double weight = 0;
        for (Ball ball : this.balls) {
            weight += ball.getWeight();
        }
        return weight;
    }
}
