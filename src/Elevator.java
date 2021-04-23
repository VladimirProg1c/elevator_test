import java.util.ArrayList;
import java.util.Iterator;

public class Elevator {
    private int numberFlor = 1;
    private int maxFlor = 1;
    private boolean isDown = false;
    private ArrayList<Floor> floors;
    private ArrayList<Integer> passengers = new ArrayList<>();

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public int getNumberFlor() {
        return numberFlor;
    }

    public Elevator(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public void startMoving() {
        while (true) {
            comeOut();
            comeIn();
            Printer.print(this);
            if (maxFlor == numberFlor) {
                if (passengers.isEmpty()) {
                    int changeFloor = findСall();
                    if (changeFloor == 0) {
                        System.out.println("Конец");
                        break;
                    } else {
                        numberFlor = numberFlor + changeFloor;
                        maxFlor = numberFlor;
                        if (changeFloor > 0) {
                            isDown = false;
                        } else {
                            isDown = true;
                        }
                        continue;
                    }
                } else {
                    isDown = !isDown;
                }
            }

            if (isDown) {
                numberFlor--;
            } else {
                numberFlor++;
            }


        }
    }

    private int findСall() {

        int nearestDown = 0;
        int nearestUp = 0;

        if (numberFlor < floors.size()) {
            for (int i = numberFlor - 1; i < floors.size(); i++) {
                if (!floors.get(i).getPersons().isEmpty()) {
                    nearestUp = i + 1 - numberFlor;
                    break;
                }
            }
        }
        if (numberFlor > 1) {
            for (int i = numberFlor - 1; i >= 0; i--) {
                if (!floors.get(i).getPersons().isEmpty()) {
                    nearestDown = i + 1 - numberFlor;
                    break;
                }
            }
        }

        if(nearestDown==0){
            return nearestUp;
        }
        if(nearestUp==0){
            return nearestDown;
        }
        return(Math.abs(nearestUp) > Math.abs(nearestDown))?nearestDown:nearestUp;

    }

    public void comeOut() {

        Iterator<Integer> iterator = passengers.iterator();
        while (iterator.hasNext()) {

            Integer pass = iterator.next();
            if (pass.equals(numberFlor)) {
                iterator.remove();
            }
        }
    }

    public void comeIn() {

        while (passengers.size() < 5) {
            Floor floor = floors.get(numberFlor - 1);
            int currentPerson = floor.getPassengers(isDown, this);
            if (currentPerson > 0) {
                passengers.add(currentPerson);
                if ((currentPerson > maxFlor) & (isDown == false) | (currentPerson < maxFlor) & (isDown == true)) {
                    maxFlor = currentPerson;
                }
            } else break;
        }
    }

    public ArrayList<Integer> getPassengers() {
        return passengers;
    }

    public void setDown(boolean down) {
        isDown = down;
    }
}
