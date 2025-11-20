package PackageService;

import java.util.Scanner;

public class Client {

    private PersonalData personal_data; // Προσοωπικά στοιχεία πελάτη
    private BankingData banking_data; // Τραπεζικά στοιχεία πελάτη
    private InvoiceData invoice_data; // Τιμολογιακά στοιχεία πελάτη


    // Συναρτήσεις Setter - Getter
    public void SetPersonalData(PersonalData personal_data) {

        this.personal_data = personal_data;
    }

    public PersonalData GetPersonalData() {

        return (this.personal_data);
    }

    public void SetBankingData(BankingData banking_data) {

        this.banking_data = banking_data;
    }

    public BankingData GetBankingData() {

        return (this.banking_data);
    }

    public void SetInvoiceData(InvoiceData invoice_data) {

        this.invoice_data = invoice_data;
    }

    public InvoiceData GetInvoiceData() {

        return (this.invoice_data);
    }

    public void PurchaseDetails(Scanner scanner) {
        
        // Ονοματεπώνυμο πελάτη
        String name = personal_data.ValidateName(scanner);
        personal_data.SetName(name);

        // E-Mail πελάτη
        String email = personal_data.ValidateEMail(scanner);
        personal_data.SetEMail(email);

        // Τηλέφωνο επικοινωνίας πελάτη
        long phone_number = personal_data.ValidatePhoneNumber(scanner);
        personal_data.SetPhoneNumber(phone_number);

        // Αριθμός πιστωτικής κάρτας πελάτη
        String credit_card = banking_data.ValidateCreditCardNumber(scanner);
        banking_data.SetCreditCardNumber(credit_card);

        // Αριθμός CVV πελάτη
        int cvv = banking_data.ValidateCVV(scanner);
        banking_data.SetCVV(cvv);

        // Ημερομηνία λήξης πιστωτικής κάρτας πελάτη
        String expIration_date = banking_data.ValidateExpirationDate(scanner);
        banking_data.SetExpirationDate(expIration_date);

        // Αριθμός κοινωβνικής ασφάλισης πελάτη
        long ssn = invoice_data.ValidateSocialSecurityNumber(scanner);
        invoice_data.SetSocialSecurityNumber(ssn);

        // Διεύθυνσης παράδοσης παραγγελίας
        String delivery_address = invoice_data.ValidateDeliveryAddress(scanner);
        invoice_data.SetDeliveryAddress(delivery_address);
    }
}