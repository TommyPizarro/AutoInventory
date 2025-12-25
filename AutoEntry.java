import java.util.ArrayList;

public class AutoEntry {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    
    private static ArrayList<AutoEntry> unitLedger = new ArrayList<>();

    public AutoEntry() {
        try {
            make = "";
            model = "";
            color = "";
            year = 0;
            mileage = 0;
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong while creating the default vehicle.");
        }
    }

    // Parameterized constructor
    public AutoEntry(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
        } catch (Exception e) {
            System.out.println("Something didn't go quite right while setting up the vehicle.");
        }
    }

    // Add a new vehicle
    public String registerVehicle(AutoEntry entry) {
        try {
            unitLedger.add(entry);
            return "Great news - the vehicle has been added to the inventory.";
        } catch (Exception e) {
            return "Uh-oh… something prevented the vehicle from being added.";
        }
    }

    // List vehicle information
    public String[] showVehicleDetails() {
        try {
            String[] info = new String[5];
            info[0] = "Make: " + make;
            info[1] = "Model: " + model;
            info[2] = "Color: " + color;
            info[3] = "Year: " + year;
            info[4] = "Mileage: " + mileage;
            return info;
        } catch (Exception e) {
            return new String[]{"I wasn't able to load the vehicle details."};
        }
    }

    // Remove a vehicle
    public String deleteVehicle(int slot) {
        try {
            if (slot >= 0 && slot < unitLedger.size()) {
                unitLedger.remove(slot);
                return "The vehicle has been removed from the inventory.";
            } else {
                return "That position doesn't exist in the inventory, so nothing was removed.";
            }
        } catch (Exception e) {
            return "Something unexpected happened while trying to remove the vehicle.";
        }
    }

    // Update vehicle attributes
    public String updateVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "The vehicle details have been updated.";
        } catch (Exception e) {
            return "Oh no! I wasn't able to update the vehicle information.";
        }
    }

    public static ArrayList<AutoEntry> getUnitLedger() {
        return unitLedger;
    }
}