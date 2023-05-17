
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }

    public boolean add(LicensePlate lp, String owner) {
        if (this.registry.containsKey(lp)) {
            return false;
        } else {
            this.registry.put(lp, owner);
        }
        return true;
    }

    public String get(LicensePlate lp) {
        return this.registry.get(lp);
    }

    public boolean remove(LicensePlate lp) {
        if (this.registry.containsKey(lp)) {
            this.registry.remove(lp);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate lp : this.registry.keySet()) {
            System.out.println(lp);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (String owner : this.registry.values()) {
            if (!(owners.contains(owner))) {
                owners.add(owner);
                System.out.println(owner);
            }
        }
    }
}
