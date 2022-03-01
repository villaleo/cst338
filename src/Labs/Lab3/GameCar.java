package Labs.Lab3;

import java.util.Scanner;

public class GameCar {
    private String name;
    private String color;
    private int currentPosition;

    public GameCar() {
        this.name = null;
        this.color = null;
        this.currentPosition = 0;
    }

    public GameCar(String name, String color, int currentPosition) {
        this.name = name;
        this.color = color;
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void getCarInfo() {
        var buffer = new Scanner(System.in);
        System.out.print("Enter the car name: ");
        name = buffer.nextLine();
        System.out.print("Enter the color: ");
        color = buffer.nextLine();
        System.out.print("Enter the starting position: ");
        currentPosition = buffer.nextInt();
        buffer.close();
    }

    void moveForward(int distance) {
        currentPosition += distance;
    }

    void moveBackward(int distance) {
        currentPosition -= distance;
    }

    void race(GameCar anotherCar) {
        var tie = this.equals(anotherCar);
        var winner = this.currentPosition > anotherCar.currentPosition? this : anotherCar;
        System.out.print(tie? "Tie: " : winner.name + " Win: ");

        System.out.print(name + " (" + currentPosition + ")");
        System.out.print(" vs. ");
        System.out.println(anotherCar.name + " (" + anotherCar.currentPosition + ")");
    }

    public boolean equals(GameCar other) {
        return other != null && other.currentPosition == this.currentPosition;
    }

    @Override
    public String toString() {
        return "Car Information: " + name + " (" + color + ") Current Position: " + currentPosition;
    }

    public void setCar(String name, String color, int currentPosition) {
        setName(name);
        setColor(color);
        setCurrentPosition(currentPosition);
    }
}
