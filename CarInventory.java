import java.io.FileWriter;
import java.util.Scanner;

public class CarInventory {

    public static void main(String[] args) {

        try {
            Scanner inputGate = new Scanner(System.in);

            // First vehicle: 2009 Honda Element 
            AutoEntry firstCar = new AutoEntry("Honda", "Element", "Red", 2009, 2023);

            // Add it to inventory
            System.out.println(firstCar.registerVehicle(firstCar));


            System.out.println("\nHere's the information for the current vehicle:");
            String[] details = firstCar.showVehicleDetails();
            for (String line : details) {
                System.out.println(line);
            }

            // Remove vehicle
            System.out.println("\nRemoving vehicle...");
            String removeMsg = firstCar.deleteVehicle(0);
            System.out.println(removeMsg);

            // Second vehicle: 2023 Kia Telluride
            AutoEntry secondCar = new AutoEntry("Kia", "Telluride", "Green", 2023, 12500);
            String addMsg = secondCar.registerVehicle(secondCar);
            System.out.println(addMsg);

            // List new vehicle info
            System.out.println("\nHere's the information for the new vehicle:");
            String[] newDetails = secondCar.showVehicleDetails();
            for (String line : newDetails) {
                System.out.println(line);
            }

            // Update the vehicle to a Black Ferrari
            System.out.println("\nUpdating vehicle...");
            String updateMsg = secondCar.updateVehicle("Ferrari", "Roma", "Black", 2024, 1000);
            System.out.println(updateMsg);

            // Print updated info
            System.out.println("\nHere's the updated vehicle information:");
            String[] updatedDetails = secondCar.showVehicleDetails();
            for (String line : updatedDetails) {
                System.out.println(line);
            }

            // Ask user if they want to print to file
            System.out.print("\nWould you like to save this information to a file? (Y/N): ");
            String response = inputGate.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                try {
                    FileWriter filePen = new FileWriter("C:\\Temp\\Autos.txt");
                    for (String line : updatedDetails) {
                        filePen.write(line + "\n");
                    }
                    filePen.close();
                    System.out.println("Your vehicle information has been saved to C:\\Temp\\Autos.txt.");
                } catch (Exception e) {
                    System.out.println("Uh-oh... I couldn't save the file. Please check the folder and try again.");
                }
            } else {
                System.out.println("Alright, the information won't be saved to a file.");
            }

            inputGate.close();

        } catch (Exception e) {
            System.out.println("Something unexpected happened while running the program.");
        }
    }
}