package PackageService;

import java.util.Scanner;

public class InvoiceSoftware implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your invoice software (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους υπηρεσίας λογισμικού τιμολογίων
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== INVOICE SOFTWARE ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 5);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος λογισμικού τιμολογίων
        double base_cost = 750.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, Desktop, Mobile)
        if (valid_description.contains("web")) {
            extra_cost += 420;
        }
        if (valid_description.contains("desktop") || valid_description.contains("windows") || valid_description.contains("mac")) {
            extra_cost += 580;
        }
        if (valid_description.contains("mobile") || valid_description.contains("android") || valid_description.contains("ios")) {
            extra_cost += 680;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε web
        if (!valid_description.contains("web") && !valid_description.contains("desktop") && 
            !valid_description.contains("mobile") && !valid_description.contains("android") && !valid_description.contains("ios")) {
            extra_cost += 420; // web by default
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 90 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. Αυτόματη δημιουργία τιμολογίων
        if (valid_description.contains("automatic") || valid_description.contains("auto generate") || valid_description.contains("template")) {
            extra_cost += 480;
        }

        // 4. Αριθμός τιμολογίων / πελάτες
        int clients_count = CountOccurrences(valid_description, "client") + CountOccurrences(valid_description, "customer");
        if (clients_count > 0) {
            extra_cost += 15 * clients_count; // 15$ ανά πελάτη
        } else {
            extra_cost += 150; // default 10 πελάτες
        }

        // 5. ΦΠΑ / Φόροι (VAT, Tax)
        if (valid_description.contains("vat") || valid_description.contains("tax") || valid_description.contains("gst") || valid_description.contains("φόρος")) {
            extra_cost += 320;
            if (valid_description.contains("eu") || valid_description.contains("europe") || valid_description.contains("greece")) {
                extra_cost += 180; // EU VAT compliance
            }
        }

        // 6. Πληρωμές (Online / Bank)
        if (valid_description.contains("payment") || valid_description.contains("stripe") || 
            valid_description.contains("paypal") || valid_description.contains("bank") || valid_description.contains("credit card")) {
            extra_cost += 550;
            if (valid_description.contains("recurring") || valid_description.contains("subscription")) {
                extra_cost += 290;
            }
        }

        // 7. Αποστολή τιμολογίων (Email / PDF)
        if (valid_description.contains("email") || valid_description.contains("pdf") || valid_description.contains("send") || valid_description.contains("export")) {
            extra_cost += 260;
            if (valid_description.contains("signed") || valid_description.contains("digital signature")) {
                extra_cost += 190;
            }
        }

        // 8. Ειδοποιήσεις ληξιπρόθεσμων
        if (valid_description.contains("reminder") || valid_description.contains("overdue") || valid_description.contains("notification")) {
            extra_cost += 340;
        }

        // 9. Αναφορές / Στατιστικά
        if (valid_description.contains("report") || valid_description.contains("analytics") || 
            valid_description.contains("dashboard") || valid_description.contains("revenue")) {
            extra_cost += 410;
        }

        // 10. Διαχείριση πελατών (CRM)
        if (valid_description.contains("crm") || valid_description.contains("client management") || valid_description.contains("contact")) {
            extra_cost += 520;
        }

        // 11. Προσαρμοσμένα πεδία / Σειρές
        if (valid_description.contains("custom field") || valid_description.contains("item") || valid_description.contains("product")) {
            extra_cost += 280;
        }

        // 12. Πολυνομισματικότητα
        if (valid_description.contains("currency") || valid_description.contains("multi-currency") || valid_description.contains("euro") || valid_description.contains("dollar")) {
            extra_cost += 220;
        }

        // 13. Ενσωμάτωση λογιστικής (QuickBooks, Xero)
        if (valid_description.contains("quickbooks") || valid_description.contains("xero") || 
            valid_description.contains("sap") || valid_description.contains("accounting")) {
            extra_cost += 680;
        }

        // 14. Barcode / QR Code
        if (valid_description.contains("barcode") || valid_description.contains("qr") || valid_description.contains("scan")) {
            extra_cost += 310;
        }

        // 15. Mobile App για τιμολόγηση
        if (valid_description.contains("mobile app") || valid_description.contains("field service") || valid_description.contains("on-site")) {
            extra_cost += 920;
        }

        // 16. API / Webhooks
        if (valid_description.contains("api") || valid_description.contains("webhook") || valid_description.contains("integration")) {
            extra_cost += 590;
        }

        // 17. GDPR / Ασφάλεια
        if (valid_description.contains("gdpr") || valid_description.contains("encryption") || valid_description.contains("secure")) {
            extra_cost += 360;
        }

        // 18. Admin Panel / Πολλαπλοί χρήστες
        if (valid_description.contains("admin") || valid_description.contains("multi-user") || valid_description.contains("role")) {
            extra_cost += 780;
        }

        // Συνολικό κόστος
        double total_cost = base_cost + extra_cost;

        return (total_cost);
    }

    // Βοηθητική μέθοδος για μέτρηση εμφανίσεων λέξης
    public int CountLanguages(String text, String word) {
        int counter = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            counter++;
            index += word.length();
        }
        return (counter);
    }

    // Βοηθητική μέθοδος για γενική μέτρηση
    public int CountOccurrences(String text, String word) {
        int counter = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            counter++;
            index += word.length();
        }
        return (counter);
    }

    public boolean AddCart(Scanner scanner) throws InvalidAddCartAnswer {

        boolean add_to_cart = false;
        System.out.print("Add order to your cart (YES/NO): ");
        String submit_order = scanner.nextLine();
        if ((!submit_order.equals("Yes") && !submit_order.equals("YES")) && 
            (!submit_order.equals("No") && !submit_order.equals("NO"))) {
            throw new InvalidAddCartAnswer("We're sorry, but you have input an invalid answer");
        } else {
            if (submit_order.equals("Yes") || submit_order.equals("YES")) {
                add_to_cart = true;
            } else if (submit_order.equals("No") || submit_order.equals("NO")) {
                add_to_cart = false;
            }
        }
        return (add_to_cart);
    }
}
