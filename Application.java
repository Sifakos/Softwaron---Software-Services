package PackageService;

import java.util.Scanner;

public class Application implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your application (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους υπηρεσίας εφαρμογής
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== APPLICATION ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order == true) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 2);
            } else if (submit_service_order == false) {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής παραγγελίας σε πεζά γράμματα
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος εφαρμογής
        double app_base_cost = 1200.00;
        double app_extra_cost = 0;

        // 1. Πλατφόρμα (Android, iOS, Cross-Platform)
        if (valid_description.contains("android")) {
            app_extra_cost += 850;
        }
        if (valid_description.contains("ios")) {
            app_extra_cost += 950;
        }
        if (valid_description.contains("cross-platform") || valid_description.contains("flutter") || 
            valid_description.contains("react native") || valid_description.contains("xamarin")) {
            app_extra_cost += 1100;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε cross-platform
        if (!valid_description.contains("android") && !valid_description.contains("ios") && 
            !valid_description.contains("cross-platform") && !valid_description.contains("flutter") && 
            !valid_description.contains("react native") && !valid_description.contains("xamarin")) {
            app_extra_cost += 1100; // cross-platform by default
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            app_extra_cost += 120 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. Push Notifications
        if (valid_description.contains("push notification") || valid_description.contains("notifications") || 
            valid_description.contains("firebase") || valid_description.contains("onesignal")) {
            app_extra_cost += 380;
        }

        // 4. Offline Λειτουργία
        if (valid_description.contains("offline") || valid_description.contains("cache") || valid_description.contains("local storage")) {
            app_extra_cost += 720;
        }

        // 5. GPS / Χάρτες
        if (valid_description.contains("gps") || valid_description.contains("location") || 
            valid_description.contains("maps") || valid_description.contains("google maps")) {
            app_extra_cost += 580;
        }

        // 6. Κάμερα / Φωτογραφίες
        if (valid_description.contains("camera") || valid_description.contains("photo") || valid_description.contains("gallery")) {
            app_extra_cost += 420;
        }

        // 7. Πληρωμές In-App
        if (valid_description.contains("payment") || valid_description.contains("stripe") || 
            valid_description.contains("paypal") || valid_description.contains("in-app purchase") || 
            valid_description.contains("google pay") || valid_description.contains("apple pay")) {
            app_extra_cost += 680;
        }

        // 8. Social Login
        if (valid_description.contains("social login") || valid_description.contains("google login") || 
            valid_description.contains("facebook login") || valid_description.contains("oauth")) {
            app_extra_cost += 340;
        }

        // 9. User Accounts / Authentication
        if (valid_description.contains("login") || valid_description.contains("register") || 
            valid_description.contains("account") || valid_description.contains("firebase auth")) {
            app_extra_cost += 790;
        }

        // 10. Real-time Chat
        if (valid_description.contains("chat") || valid_description.contains("messaging") || 
            valid_description.contains("firebase") || valid_description.contains("socket")) {
            app_extra_cost += 980;
        }

        // 11. API Integration
        if (valid_description.contains("api") || valid_description.contains("integration") || valid_description.contains("rest") || valid_description.contains("graphql")) {
            app_extra_cost += 920;
        }

        // 12. Admin Panel (Web-based)
        if (valid_description.contains("admin") || valid_description.contains("dashboard") || valid_description.contains("διαχείριση")) {
            app_extra_cost += 1100;
        }

        // 13. Analytics
        if (valid_description.contains("analytics") || valid_description.contains("firebase analytics") || 
            valid_description.contains("mixpanel") || valid_description.contains("amplitude")) {
            app_extra_cost += 260;
        }

        // 14. App Store Optimization (ASO)
        if (valid_description.contains("aso") || valid_description.contains("app store") || valid_description.contains("play store") || valid_description.contains("optimization")) {
            app_extra_cost += 490;
        }

        // 15. Custom UI/UX Design
        if (valid_description.contains("design") || valid_description.contains("ui") || valid_description.contains("ux") || 
            valid_description.contains("figma") || valid_description.contains("sketch") || valid_description.contains("prototype")) {
            app_extra_cost += 1350;
        }

        // 16. Testing & QA
        if (valid_description.contains("testing") || valid_description.contains("qa") || valid_description.contains("bug") || valid_description.contains("test")) {
            app_extra_cost += 780;
        }

        // 17. Deployment & Publishing
        if (valid_description.contains("publish") || valid_description.contains("deployment") || 
            valid_description.contains("app store") || valid_description.contains("google play") || valid_description.contains("release")) {
            app_extra_cost += 450;
        }

        // 18. Συντήρηση / Updates (1 έτος)
        if (valid_description.contains("maintenance") || valid_description.contains("support") || valid_description.contains("updates")) {
            app_extra_cost += 890;
        }

        // Συνολικό κόστος εφαρμογής
        double app_total_cost = app_base_cost + app_extra_cost;

        return (app_total_cost);
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
