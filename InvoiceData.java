package PackageService;

import java.util.Scanner;

public class InvoiceData {
    
    private long social_security_number; // Αριθμός κοινωνικής ασφάλισης πελάτη
    private String delivery_address; // Διεύθυνση παράδοης παραγγελίας

    // Συναρτήσεις Setter - Getter
    public void SetSocialSecurityNumber(long social_security_number) {

        this.social_security_number = social_security_number;
    }

    public long GetSocialSecurityNumber() {

        return (this.social_security_number);
    }

    public void SetDeliveryAddress(String delivery_address) {

        this.delivery_address = delivery_address;
    }

    public String GetDeliveryAddress() {

        return (this.delivery_address);
    }

    // Επικύρωση SSN 
    public long ValidateSocialSecurityNumber(Scanner scanner) {

        long input_ssn;
        boolean valid_ssn = false;
        do {
            System.out.print("Social Security Number: ");
            input_ssn = scanner.nextLong();
            if (input_ssn >= 100000000 && input_ssn <= 999999999) {
                valid_ssn = true;
            } else if (input_ssn < 100000000 || input_ssn > 999999999){
                valid_ssn = false;
            }
            if (valid_ssn == false) {
                System.out.println("Invalid SSN");
            }
        } while (valid_ssn == false);
        return (input_ssn);
    }

    // Επικύρωση διεύθυνσης παράδοσης
    public String ValidateDeliveryAddress(Scanner scanner) {

        String input_delivery_address;
        boolean valid_delivery_address = false;
        do {
            System.out.print("Delivery Address: ");
            input_delivery_address = scanner.nextLine().trim();
            if (input_delivery_address.length() >= 5 && input_delivery_address.matches(".*[A-Za-z].*") && input_delivery_address.matches(".*\\d.*")) {
                valid_delivery_address = true;
            } else if (input_delivery_address.length() < 5 && !input_delivery_address.matches(".*[A-Za-z].*") && !input_delivery_address.matches(".*\\d.*")){
                valid_delivery_address = false;
            }
            if (valid_delivery_address == false) {
                System.out.println("Invalid delivery address");
            }
        } while (valid_delivery_address == false);
        return (input_delivery_address);
    }
}
