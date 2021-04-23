import java.util.ArrayList;

public class Printer {

    public static int step;

    public static void print(Elevator elevator){
        step++;
        System.out.println("Step"+step);

        elevator.getPassengers().toString();

        ArrayList<Floor> floors = elevator.getFloors();
        for (int i = floors.size()-1; i>=0; i--){

            String currentFloorStr;
            if (elevator.getNumberFlor()-1==(i)){
                currentFloorStr = floors.get(i).numberFlor+"|["+ elevator.getPassengers().toString() + "]|"+ floors.get(i).getPersons().toString();
            }
            else
            {
                currentFloorStr = floors.get(i).numberFlor+"|[000000]|"+ floors.get(i).getPersons().toString();
            }

            System.out.println(currentFloorStr);


        }
        //System.out.println("|[00000]|");


    }

}
