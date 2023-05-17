
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Employees {

    public List<Person> persons;

    public Employees() {
        this.persons = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.persons.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        Iterator<Person> iterator = peopleToAdd.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    public void print() {
        Iterator<Person> iterator = this.persons.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void print(Education level) {
        Iterator<Person> iterator = this.persons.iterator();
        while (iterator.hasNext()) {
            Person currentPerson = iterator.next(); // Each call returns current object and advances the pointer
            if (currentPerson.getEducation() == level) { // Internally each value is converted to an int corresponding its order within the enum
                System.out.println(currentPerson);
            }
        }
    }

    public void fire(Education level) {
        Iterator<Person> iterator = this.persons.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == level) {
                iterator.remove();
            }
//            // This triggers java.util.ConcurrentModificationException
//            Person currentPerson = iterator.next();
//            if (currentPerson.getEducation() == level) {
//                this.persons.remove(currentPerson);
//            }
        }
    }
}
