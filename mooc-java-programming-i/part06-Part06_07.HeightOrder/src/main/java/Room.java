
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Room {

    private ArrayList<Person> capacity;

    public Room() {
        this.capacity = new ArrayList<>();
    }

    public void add(Person person) {
        this.capacity.add(person);
    }

    public boolean isEmpty() {
        return this.capacity.isEmpty();
    }

    public ArrayList<Person> getPersons() {
        return this.capacity;
    }

    public Person shortest() {
        if (this.capacity.isEmpty()) {
            return null;
        }
        Person shortest = this.capacity.get(0);
        for (Person person : capacity) {
            if (shortest.getHeight() > person.getHeight()) {
                shortest = person;
            }
        }
        return shortest;
    }

    public Person take() {
        if (this.capacity.isEmpty()) {
            return null;
        }
        int index = 0;
        Person shortest = this.shortest();
        for (int i = 0; i < this.capacity.size(); i++) {
            if (this.capacity.get(i).equals(shortest)) {
                index = i;
            }
        }
        return this.capacity.remove(index);        
//        this.persons.remove(shortest);
//        return shortest;
    }
}
