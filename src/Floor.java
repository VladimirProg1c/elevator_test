import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Floor {
    public final int numberFlor;
    public final int quantityFlor;
    private ArrayList<Integer> persons = new ArrayList<>();

    public Floor(int numberFlor, int quantityFlor) {
        this.numberFlor = numberFlor;
        this.quantityFlor = quantityFlor;
    }

    public void setPersons(ArrayList<Integer> persons) {
        this.persons = persons;
    }

    public ArrayList<Integer> getPersons() {
        return persons;
    }

    public Integer getPassengers(boolean isDown, Elevator elevator) {
        int down=0;
        int up=0;
        if (elevator.getPassengers().isEmpty()){
            for (int i = 0; i < persons.size(); i++)
            {
                if (persons.get(i) > numberFlor)
                {
                    up++;
                }
                else
                    {
                    down++;
                }
            }
            if(down>up)
            {
                elevator.setDown(true);
                isDown = true;
            }
            else
                {
                elevator.setDown(false);
                isDown = false;
            }
        }

        Iterator<Integer> iterator = persons.iterator();
        while (iterator.hasNext())
        {
            int currentPerson = iterator.next();
            if ((currentPerson > numberFlor) & (isDown == false) | (currentPerson < numberFlor) & (isDown == true))  {
                iterator.remove();
                return currentPerson;
            }
        }
        return 0;
    }

    public void createRandomPerson() {

        Random random = new Random();
        int quantityRandomPerson = random.nextInt(11);
        for (int i = 0; i < quantityRandomPerson; i++) {
            int destinationFlor = random.nextInt(quantityFlor + 1);
            if (destinationFlor == numberFlor|destinationFlor<1) {
                continue;
            }
            persons.add(destinationFlor);
        }
    }
}
