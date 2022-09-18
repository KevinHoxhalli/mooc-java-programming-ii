
import java.util.ArrayList;
import java.util.HashMap;


public class VehicleRegistry {
    private HashMap<LicensePlate, String> owners;

    public VehicleRegistry() {
        this.owners = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if(this.owners.containsKey(licensePlate)) {
            return false;
        }
        this.owners.put(licensePlate,owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate) {
        return this.owners.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if(!this.owners.containsKey(licensePlate)) {
            return false;
        }
        this.owners.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates() {
        for(LicensePlate lic: this.owners.keySet()) {
            System.out.println(lic);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owner = new ArrayList<>();
        for(String own: this.owners.values()) {
            if(!owner.contains(own)) {
                owner.add(own);
                System.out.println(own);
            }
        }
        
    }
    
}
