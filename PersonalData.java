package PackageService;

import java.util.Scanner;

public class PersonalData {

    private String name; // Ονοματεπώνυμο πελάτη
    private String email; // E-Mail επικοινωνίας πελάτη
    private long phone_number; // Τηλέφωνο επικοινωνίας πελάτη

    // Συναρτήσεις Setter - Getter
    public void SetName(String name) {

        this.name = name;
    }

    public String GetName() {

        return (this.name);
    }

    public void SetEMail(String email) {

        this.email = email;
    }

    public String GetEMail() {

        return (this.email);
    }

    public void SetPhoneNumber(long phone_number) {

        this.phone_number = phone_number;
    }

    public long GetPhoneNumber() {

        return (this.phone_number);
    }


    // Εγκυρότητα ονόματος πελάτη
    public String ValidateName(Scanner scanner) {

        String input_name;
        boolean valid_name = false; 
        do {
            System.out.print("Username: ");
            input_name = scanner.nextLine();
            if (input_name.matches("^[A-Za-zÀ-ÿ][A-Za-zÀ-ÿ'\\-]*(\\s+[A-Za-zÀ-ÿ][A-Za-zÀ-ÿ'\\-]*)+$")) {
                valid_name = true;
            } else if (!input_name.matches("^[A-Za-zÀ-ÿ][A-Za-zÀ-ÿ'\\-]*(\\s+[A-Za-zÀ-ÿ][A-Za-zÀ-ÿ'\\-]*)+$")) {
                valid_name = false;
            }
            if (valid_name == false) {
                System.out.println("Invalid name");
            }
        } while (valid_name == false);
        return (input_name);
    }


    // Εγκυρότητα email πελάτη
    public String ValidateEMail(Scanner scanner) {

        String input_email;
        boolean valid_email = false; 
        do {
            System.out.print("E-Mail: ");
            input_email = scanner.nextLine();
            if (input_email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                valid_email = true;
            } else if (!input_email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                valid_email = false;
            }
            if (valid_email == false) {
                System.out.println("Invalid e-mail");
            }
        } while (valid_email == false);
        return (input_email);
    }

    // Εγκυρότητα τηλεφώνου επικοινωνίας
    public long ValidatePhoneNumber(Scanner scanner) {

        long input_phone_number;
        boolean valid_phone_number = false;
        do {
            System.out.print("Phone number: ");
            input_phone_number = scanner.nextLong();
            if (input_phone_number > 100000000) {
                valid_phone_number = true;
            } else if (input_phone_number < 100000000) {
                valid_phone_number = false;
            }
            if (valid_phone_number == false) {
                System.out.println("Invalid phone number");
            }
        } while (valid_phone_number == false);
        return (input_phone_number);
    }
    
}
