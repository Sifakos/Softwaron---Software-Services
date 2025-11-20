package PackageService;

import java.util.Scanner;

public class AppointmentManagement implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your appointment management system (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας SaaS
        } else {
            // Υπολογισμός κόστους υπηρεσίας διαχείρισης ραντεβού
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== APPOINTMENT MANAGEMENT ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 4);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος συστήματος διαχείρισης ραντεβού
        double base_cost = 900.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, Mobile, Desktop)
        if (valid_description.contains("web")) {
            extra_cost += 450;
        }
        if (valid_description.contains("mobile") || valid_description.contains("android") || valid_description.contains("ios")) {
            extra_cost += 680;
        }
        if (valid_description.contains("desktop") || valid_description.contains("windows") || valid_description.contains("mac")) {
            extra_cost += 520;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε web + mobile
        if (!valid_description.contains("web") && !valid_description.contains("mobile") && 
            !valid_description.contains("android") && !valid_description.contains("ios") && 
            !valid_description.contains("desktop") && !valid_description.contains("windows") && !valid_description.contains("mac")) {
            extra_cost += 450 + 680; // web + mobile
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 95 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. Διαθεσιμότητα σε πραγματικό χρόνο
        if (valid_description.contains("real-time") || valid_description.contains("live") || valid_description.contains("availability")) {
            extra_cost += 780;
        }

        // 4. Ειδοποιήσεις (Email / SMS / Push)
        if (valid_description.contains("notification") || valid_description.contains("reminder") || 
            valid_description.contains("email") || valid_description.contains("sms") || valid_description.contains("push")) {
            extra_cost += 380;
            if (valid_description.contains("sms")) {
                extra_cost += 220;
            }
            if (valid_description.contains("email")) {
                extra_cost += 140;
            }
        }

        // 5. Ημερολόγιο / Χρονοδιάγραμμα
        if (valid_description.contains("calendar") || valid_description.contains("schedule") || valid_description.contains("time slot")) {
            extra_cost += 540;
            if (valid_description.contains("recurring") || valid_description.contains("repeat")) {
                extra_cost += 280;
            }
        }

        // 6. Διαχείριση πελατών (CRM)
        if (valid_description.contains("client") || valid_description.contains("customer") || valid_description.contains("crm")) {
            extra_cost += 620;
            if (valid_description.contains("history") || valid_description.contains("notes")) {
                extra_cost += 190;
            }
        }

        // 7. Διαχείριση προσωπικού / παρόχων
        if (valid_description.contains("staff") || valid_description.contains("provider") || valid_description.contains("employee")) {
            extra_cost += 490;
            if (valid_description.contains("role") || valid_description.contains("permission")) {
                extra_cost += 160;
            }
        }

        // 8. Πληρωμές (Online / POS)
        if (valid_description.contains("payment") || valid_description.contains("stripe") || 
            valid_description.contains("paypal") || valid_description.contains("deposit") || valid_description.contains("pos")) {
            extra_cost += 580;
            if (valid_description.contains("deposit") || valid_description.contains("prepayment")) {
                extra_cost += 240;
            }
        }

        // 9. Ακυρώσεις / Επαναπρογραμματισμός
        if (valid_description.contains("cancel") || valid_description.contains("reschedule") || valid_description.contains("cancellation")) {
            extra_cost += 320;
            if (valid_description.contains("refund") || valid_description.contains("policy")) {
                extra_cost += 180;
            }
        }

        // 10. Αναφορές / Στατιστικά
        if (valid_description.contains("report") || valid_description.contains("analytics") || 
            valid_description.contains("statistics") || valid_description.contains("dashboard")) {
            extra_cost += 410;
        }

        // 11. Συγχρονισμός με Google Calendar / Outlook
        if (valid_description.contains("google calendar") || valid_description.contains("outlook") || 
            valid_description.contains("ical") || valid_description.contains("sync")) {
            extra_cost += 460;
        }

        // 12. Αυτόματες υπενθυμίσεις
        if (valid_description.contains("reminder") || valid_description.contains("follow-up") || valid_description.contains("automated")) {
            extra_cost += 290;
        }

        // 13. Διαχείριση ουράς αναμονής
        if (valid_description.contains("waitlist") || valid_description.contains("queue") || valid_description.contains("waiting")) {
            extra_cost += 360;
        }

        // 14. Φόρμες κράτησης (Custom fields)
        if (valid_description.contains("form") || valid_description.contains("field") || valid_description.contains("custom")) {
            extra_cost += 310;
        }

        // 15. Admin Panel
        if (valid_description.contains("admin") || valid_description.contains("dashboard") || valid_description.contains("διαχείριση")) {
            extra_cost += 850;
        }

        // 16. Mobile App για πελάτες
        if (valid_description.contains("app") || valid_description.contains("mobile app") || valid_description.contains("client app")) {
            extra_cost += 1100;
        }

        // 17. API για τρίτες εφαρμογές
        if (valid_description.contains("api") || valid_description.contains("integration") || valid_description.contains("webhook")) {
            extra_cost += 720;
        }

        // 18. GDPR / Ασφάλεια δεδομένων
        if (valid_description.contains("gdpr") || valid_description.contains("privacy") || valid_description.contains("data protection")) {
            extra_cost += 390;
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

    public boolean AddCart(Scanner scanner) throws InvalidAddCartAnswer {

        boolean add_to_cart = false;
        System.out.print("Add order to your cart (YES/NO): ");
        String submit_order = scanner.nextLine();
        if ((!submit_order.equals("Yes") && !submit_order.equals("YES")) && (!submit_order.equals("No") && !submit_order.equals("NO"))) {
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
