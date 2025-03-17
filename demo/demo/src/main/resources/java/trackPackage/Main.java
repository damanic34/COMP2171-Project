package java.trackPackage;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PackageTracker packageTracker = new PackageTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Package Tracker Menu ===");
            System.out.println("1. Add a new package");
            System.out.println("2. Update package status");
            System.out.println("3. View package details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a new package
                    try {
                        System.out.print("Enter tracking number: ");
                        String trackingNumber = scanner.nextLine();

                        System.out.print("Enter origin: ");
                        String origin = scanner.nextLine();

                        System.out.print("Enter destination: ");
                        String destination = scanner.nextLine();

                        System.out.print("Enter status: ");
                        String status = scanner.nextLine();

                        System.out.print("Enter weight (lb): ");
                        double weight = scanner.nextDouble();

                        System.out.print("Enter delivery days from now: ");
                        int daysToDelivery = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter package description: ");
                        String description = scanner.nextLine();

                        packageTracker.addPackage(
                            trackingNumber,
                            origin,
                            destination,
                            status,
                            weight,
                            daysToDelivery, LocalDateTime.now().plusDays(daysToDelivery),
                            description
                        );
                        System.out.println("Package added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Update package status
                    try {
                        System.out.print("Enter tracking number: ");
                        String trackingNumber = scanner.nextLine();

                        System.out.print("Enter new status: ");
                        String newStatus = scanner.nextLine();

                        packageTracker.updateStatus(trackingNumber, newStatus);
                        System.out.println("Package status updated successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // View package details
                    try {
                        System.out.print("Enter tracking number: ");
                        String trackingNumber = scanner.nextLine();

                        packageTracker.viewPackageDetails(trackingNumber);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}