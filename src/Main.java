import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int quantityFloor;
        ArrayList<Floor> floors = new ArrayList<Floor>();
        Random random = new Random();
        quantityFloor = random.nextInt(16)+4;

        for (int i = 1; i <= quantityFloor; i++)
        {
            Floor flor = new Floor(i,quantityFloor);
            floors.add(flor);
            flor.createRandomPerson();
        }

        Elevator elevator = new Elevator(floors);
        Printer.print(elevator);
        elevator.startMoving();

    }
}
