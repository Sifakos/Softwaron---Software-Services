package PackageService;

import java.util.Scanner;

public class BankingData {

    private String credit_card_number; // Αριθμός πιστωτικής κάρτας πελάτη
    private int cvv; // CVV πελάτη
    private String expiration_date; // Ημερομηνία Λήξης κάρτας πελάτη
    private double bank_balance = 345812.94;

    // Συναρτήσεις Setter - Getter
    public void SetCreditCardNumber(String credit_card_number) {

        this.credit_card_number = credit_card_number;
    }

    public String GetCreditCardNumber() {

        return (this.credit_card_number);
    }

    public void SetCVV(int cvv) {

        this.cvv = cvv;
    }

    public int GetCVV() {

        return (this.cvv);
    }

    public void SetExpirationDate(String expiration_date) {

        this.expiration_date = expiration_date;
    }

    public String GetExpirationDate() {

        return (this.expiration_date);
    }

    public double GetBankBalance() {

        return (this.bank_balance);
    }

    // Επικύρωση αριθμού πιστωτικής κάρτας 
    public String ValidateCreditCardNumber(Scanner scanner) {
        
        String input_credit_card;
        boolean valid_credit_card = false;
        do {
            System.out.print("Credit Card Number: ");
            input_credit_card = scanner.nextLine().replaceAll("\\s+", ""); 
            if (input_credit_card.matches("\\d{16}")) {
                valid_credit_card = true;
            } else if (!input_credit_card.matches("\\d{16}")) {
                valid_credit_card = false;
            }
            if (valid_credit_card == false) {
                System.out.println("Invalid credit card number");
            }
        } while (valid_credit_card = false);
        return (input_credit_card);
    }

    // Επικύρωση CVV 
    public int ValidateCVV(Scanner scanner) {

        int input_cvv;
        boolean valid_cvv = false;
        do {
            System.out.print("CVV: ");
            input_cvv = scanner.nextInt();
            if (cvv >= 100 && cvv <= 999) {
                valid_cvv = true;
            } else if (cvv < 100 || cvv > 999) {
                valid_cvv = false;
            }
            if (valid_cvv == false) {
                System.out.println("Invalid CVV");
            }
        } while (valid_cvv == false);
        return (input_cvv);
    }

    // Επικύρωση ημερομηνίας λήξης (MM/YY)
    public String ValidateExpirationDate(Scanner scanner) {

        String input_expiration_date;
        boolean valid_expiration_date = false;
        do {
            System.out.print("Expiration Date (MM/YY): ");
            input_expiration_date = scanner.nextLine().trim();
            if (input_expiration_date.matches("(0[1-9]|1[0-2])\\/([0-9]{2})")) {
                valid_expiration_date = true;
            } else if (!input_expiration_date.matches("(0[1-9]|1[0-2])\\/([0-9]{2})")) {
                valid_expiration_date = false;
            }
            if (valid_expiration_date == false) {
                System.out.print("Invalid expiration date");
            }
        } while (valid_expiration_date == false);
        return (input_expiration_date);
    }

    public void UpdateBalance(double cart_cost) {

        this.bank_balance -= cart_cost;
    }
}
