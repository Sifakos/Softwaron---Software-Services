package PackageService;

import java.util.Scanner;

public class ELearning implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your e-learning platform (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους πλατφόρμας e-learning
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== E-LEARNING PLATFORM ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 7);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος e-learning πλατφόρμας
        double base_cost = 950.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, Mobile, Desktop)
        if (valid_description.contains("web")) {
            extra_cost += 480;
        }
        if (valid_description.contains("mobile") || valid_description.contains("android") || valid_description.contains("ios")) {
            extra_cost += 780;
        }
        if (valid_description.contains("desktop") || valid_description.contains("windows") || valid_description.contains("mac")) {
            extra_cost += 620;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε web + mobile
        if (!valid_description.contains("web") && !valid_description.contains("mobile") && 
            !valid_description.contains("android") && !valid_description.contains("ios") && 
            !valid_description.contains("desktop") && !valid_description.contains("windows") && !valid_description.contains("mac")) {
            extra_cost += 480 + 780; // web + mobile
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 110 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. Διαχείριση μαθημάτων (LMS Core)
        if (valid_description.contains("course") || valid_description.contains("lesson") || valid_description.contains("module") || valid_description.contains("lms")) {
            extra_cost += 720;
            if (valid_description.contains("drip") || valid_description.contains("sequential")) {
                extra_cost += 320; // Drip content
            }
        }

        // 4. Βίντεο / Multimedia
        if (valid_description.contains("video") || valid_description.contains("stream") || valid_description.contains("vimeo") || valid_description.contains("youtube")) {
            extra_cost += 580;
            if (valid_description.contains("live") || valid_description.contains("webinar") || valid_description.contains("zoom")) {
                extra_cost += 480; // Live classes
            }
        }

        // 5. Κουίζ / Αξιολογήσεις
        if (valid_description.contains("quiz") || valid_description.contains("test") || valid_description.contains("exam") || valid_description.contains("assessment")) {
            extra_cost += 460;
            if (valid_description.contains("random") || valid_description.contains("pool") || valid_description.contains("timer")) {
                extra_cost += 240;
            }
        }

        // 6. Πιστοποιητικά
        if (valid_description.contains("certificate") || valid_description.contains("completion") || valid_description.contains("badge")) {
            extra_cost += 380;
            if (valid_description.contains("pdf") || valid_description.contains("download") || valid_description.contains("share")) {
                extra_cost += 160;
            }
        }

        // 7. Φόρουμ / Συζητήσεις
        if (valid_description.contains("forum") || valid_description.contains("discussion") || valid_description.contains("comment")) {
            extra_cost += 340;
        }

        // 8. Αναφορές / Analytics
        if (valid_description.contains("report") || valid_description.contains("analytics") || 
            valid_description.contains("progress") || valid_description.contains("completion rate")) {
            extra_cost += 520;
        }

        // 9. Διαχείριση χρηστών / Ρόλοι
        if (valid_description.contains("student") || valid_description.contains("instructor") || 
            valid_description.contains("admin") || valid_description.contains("role")) {
            extra_cost += 620;
            int user_count = CountOccurrences(valid_description, "student") + CountOccurrences(valid_description, "user");
            if (user_count > 0) {
                extra_cost += 8 * Math.min(user_count * 100, 4000); // max $4000 για 500+ χρήστες
            } else {
                extra_cost += 800; // default 100 χρήστες
            }
        }

        // 10. Πληρωμές / Συνδρομές
        if (valid_description.contains("payment") || valid_description.contains("stripe") || 
            valid_description.contains("paypal") || valid_description.contains("subscription")) {
            extra_cost += 680;
            if (valid_description.contains("recurring") || valid_description.contains("monthly")) {
                extra_cost += 320;
            }
        }

        // 11. SCORM / xAPI Compliance
        if (valid_description.contains("scorm") || valid_description.contains("xapi") || valid_description.contains("tin can")) {
            extra_cost += 590;
        }

        // 12. Gamification
        if (valid_description.contains("gamification") || valid_description.contains("points") || 
            valid_description.contains("leaderboard") || valid_description.contains("badge")) {
            extra_cost += 480;
        }

        // 13. Mobile App (iOS/Android)
        if (valid_description.contains("mobile app") || valid_description.contains("offline")) {
            extra_cost += 1100;
            if (valid_description.contains("offline") || valid_description.contains("download")) {
                extra_cost += 420;
            }
        }

        // 14. Ενσωμάτωση με Zoom / Google Meet
        if (valid_description.contains("zoom") || valid_description.contains("meet") || valid_description.contains("webinar")) {
            extra_cost += 540;
        }

        // 15. White-label / Branding
        if (valid_description.contains("white label") || valid_description.contains("branding") || 
            valid_description.contains("custom domain") || valid_description.contains("logo")) {
            extra_cost += 720;
        }

        // 16. API / Webhooks
        if (valid_description.contains("api") || valid_description.contains("webhook") || valid_description.contains("integration")) {
            extra_cost += 650;
        }

        // 17. GDPR / Ασφάλεια
        if (valid_description.contains("gdpr") || valid_description.contains("privacy") || valid_description.contains("secure")) {
            extra_cost += 410;
        }

        // 18. Admin Dashboard
        if (valid_description.contains("dashboard") || valid_description.contains("admin panel") || valid_description.contains("manage")) {
            extra_cost += 850;
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
