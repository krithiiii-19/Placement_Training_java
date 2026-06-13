package demo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        API api = new API();
        
        while (true) {
            System.out.println("\n1. Add New Customer");
            System.out.println("2. Fetch Customers Sharing a DOB");
            System.out.println("Any other number to exit");
            System.out.print("Choice: ");
            
            if (!scanner.hasNextInt()) break;
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            if (choice == 1) {
                System.out.print("Enter ID (e.g., C1): ");
                String id = scanner.nextLine();
                
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter DOB (YYYY-MM-DD): ");
                String dob = scanner.nextLine();
                
                System.out.print("Enter Contact Number: ");
                long contact = scanner.nextLong();
                
                api.addCustomer(id, name, dob, contact);
                
            } else if (choice == 2) {
                api.fetchCustomersWithSharedDOB();
                
            } else {
                break;
            }
        }
        scanner.close();
        System.out.println("Exiting...");
    }
}