package PackageService;

import java.util.Scanner;

public class HRTools implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your HR tools (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους υπηρεσίας HR Tools
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== HR TOOLS ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 6);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος HR Tools
        double base_cost = 850.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, Mobile, Desktop)
        if (valid_description.contains("web")) {
            extra_cost += 450;
        }
        if (valid_description.contains("desktop") || valid_description.contains("windows") || valid_description.contains("mac")) {
            extra_cost += 620;
        }
        if (valid_description.contains("mobile") || valid_description.contains("android") || valid_description.contains("ios")) {
            extra_cost += 750;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε web
        if (!valid_description.contains("web") && !valid_description.contains("desktop") && 
            !valid_description.contains("mobile") && !valid_description.contains("android") && !valid_description.contains("ios")) {
            extra_cost += 450; // web by default
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 100 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. Διαχείριση υπαλλήλων (Employee Database)
        if (valid_description.contains("employee") || valid_description.contains("staff") || valid_description.contains("hr database")) {
            extra_cost += 580;
            int employees_count = CountOccurrences(valid_description, "employee") + CountOccurrences(valid_description, "staff");
            if (employees_count > 0) {
                extra_cost += 10 * Math.min(employees_count * 50, 5000); // max $5000 for 500+ employees
            } else {
                extra_cost += 500; // default 50 employees
            }
        }

        // 4. Payroll / Μισθοδοσία
        if (valid_description.contains("payroll") || valid_description.contains("salary") || valid_description.contains("μισθός") || valid_description.contains("wage")) {
            extra_cost += 920;
            if (valid_description.contains("tax") || valid_description.contains("vat") || valid_description.contains("irs")) {
                extra_cost += 380; // Tax compliance
            }
        }

        // 5. Recruitment / Προσλήψεις
        if (valid_description.contains("recruitment") || valid_description.contains("hiring") || valid_description.contains("job") || valid_description.contains("cv")) {
            extra_cost += 680;
            if (valid_description.contains("ats") || valid_description.contains("applicant tracking")) {
                extra_cost += 450;
            }
        }

        // 6. Performance Reviews / Αξιολογήσεις
        if (valid_description.contains("performance") || valid_description.contains("review") || valid_description.contains("evaluation") || valid_description.contains("kpi")) {
            extra_cost += 520;
            if (valid_description.contains("360") || valid_description.contains("feedback")) {
                extra_cost += 290;
            }
        }

        // 7. Attendance / Παρακολούθηση Ωρών
        if (valid_description.contains("attendance") || valid_description.contains("timesheet") || valid_description.contains("clock") || valid_description.contains("shift")) {
            extra_cost += 480;
            if (valid_description.contains("gps") || valid_description.contains("geofence")) {
                extra_cost += 320; // Location-based tracking
            }
        }

        // 8. Leave Management / Άδειες
        if (valid_description.contains("leave") || valid_description.contains("vacation") || valid_description.contains("sick") || valid_description.contains("holiday")) {
            extra_cost += 410;
            if (valid_description.contains("approval") || valid_description.contains("workflow")) {
                extra_cost += 220;
            }
        }

        // 9. Training / Εκπαίδευση
        if (valid_description.contains("training") || valid_description.contains("course") || valid_description.contains("lms") || valid_description.contains("e-learning")) {
            extra_cost += 650;
        }

        // 10. Onboarding / Εισαγωγή Νέων
        if (valid_description.contains("onboarding") || valid_description.contains("new hire") || valid_description.contains("induction")) {
            extra_cost += 380;
        }

        // 11. Benefits Management / Παροχές
        if (valid_description.contains("benefits") || valid_description.contains("insurance") || valid_description.contains("pension")) {
            extra_cost += 450;
        }

        // 12. Compliance / Συμμόρφωση (GDPR, Labor Laws)
        if (valid_description.contains("gdpr") || valid_description.contains("compliance") || valid_description.contains("labor") || valid_description.contains("regulation")) {
            extra_cost += 520;
        }

        // 13. Analytics / Reports
        if (valid_description.contains("analytics") || valid_description.contains("report") || valid_description.contains("dashboard") || valid_description.contains("turnover")) {
            extra_cost += 580;
        }

        // 14. Employee Self-Service Portal
        if (valid_description.contains("self-service") || valid_description.contains("portal") || valid_description.contains("employee app")) {
            extra_cost += 720;
        }

        // 15. Communication / Chat
        if (valid_description.contains("chat") || valid_description.contains("team") || valid_description.contains("slack") || valid_description.contains("microsoft teams")) {
            extra_cost += 340;
        }

        // 16. API Integrations (Payroll, ERP)
        if (valid_description.contains("api") || valid_description.contains("integration") || valid_description.contains("erp") || valid_description.contains("sap")) {
            extra_cost += 680;
        }

        // 17. Mobile App
        if (valid_description.contains("mobile app") || valid_description.contains("hr app")) {
            extra_cost += 950;
        }

        // 18. Multi-Company Support
        if (valid_description.contains("multi-company") || valid_description.contains("multi-tenant") || valid_description.contains("group")) {
            extra_cost += 490;
        }

        // Συνολικό κόστος
        double total_cost = base_cost + extra_cost;

        return (total_cost);
    }

    // Βοηθητική μέθοδος για μέτρηση εμφανίσεων λέξης (γλώσσες)
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
