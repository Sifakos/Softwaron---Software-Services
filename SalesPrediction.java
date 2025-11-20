package PackageService;

import java.util.Scanner;

public class SalesPrediction implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your sales prediction system (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους Sales Prediction
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== SALES PREDICTION ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 13);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος Sales Prediction
        double base_cost = 1300.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, API, Dashboard, Mobile)
        if (valid_description.contains("web")) {
            extra_cost += 520;
        }
        if (valid_description.contains("api") || valid_description.contains("integration")) {
            extra_cost += 780;
        }
        if (valid_description.contains("dashboard") || valid_description.contains("visualization")) {
            extra_cost += 680;
        }
        if (valid_description.contains("mobile") || valid_description.contains("android") || valid_description.contains("ios")) {
            extra_cost += 850;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε web + dashboard + API
        if (!valid_description.contains("web") && !valid_description.contains("api") && 
            !valid_description.contains("dashboard") && !valid_description.contains("mobile") && 
            !valid_description.contains("android") && !valid_description.contains("ios")) {
            extra_cost += 520 + 680 + 780; // web + dashboard + API
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 130 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. Μοντέλο Πρόβλεψης (Time Series, Regression, ML, Deep Learning)
        if (valid_description.contains("time series") || valid_description.contains("arima") || valid_description.contains("prophet")) {
            extra_cost += 920;
        }
        if (valid_description.contains("regression") || valid_description.contains("linear") || valid_description.contains("logistic")) {
            extra_cost += 780;
        }
        if (valid_description.contains("machine learning") || valid_description.contains("ml") || 
            valid_description.contains("random forest") || valid_description.contains("xgboost")) {
            extra_cost += 1100;
        }
        if (valid_description.contains("deep learning") || valid_description.contains("neural") || 
            valid_description.contains("lstm") || valid_description.contains("rnn")) {
            extra_cost += 1450;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε ML (XGBoost)
        if (!valid_description.contains("time series") && !valid_description.contains("regression") && 
            !valid_description.contains("machine learning") && !valid_description.contains("deep learning") && 
            !valid_description.contains("arima") && !valid_description.contains("prophet") && 
            !valid_description.contains("xgboost") && !valid_description.contains("lstm")) {
            extra_cost += 1100; // ML by default
        }

        // 4. Χρονικός Ορίζοντας Πρόβλεψης
        if (valid_description.contains("daily")) {
            extra_cost += 420;
        }
        if (valid_description.contains("weekly")) {
            extra_cost += 380;
        }
        if (valid_description.contains("monthly")) {
            extra_cost += 340;
        }
        if (valid_description.contains("quarterly") || valid_description.contains("yearly")) {
            extra_cost += 520;
        }

        // 5. Αριθμός Προϊόντων / SKUs
        int sku_count = CountOccurrences(valid_description, "product") + CountOccurrences(valid_description, "sku") + CountOccurrences(valid_description, "item");
        if (sku_count > 0) {
            extra_cost += 25 * Math.min(sku_count * 10, 5000); // max $5,000 για 500+ SKUs
        } else {
            extra_cost += 500; // default 20 SKUs
        }

        // 6. Πηγές Δεδομένων
        if (valid_description.contains("crm") || valid_description.contains("salesforce") || valid_description.contains("hubspot")) {
            extra_cost += 720;
        }
        if (valid_description.contains("erp") || valid_description.contains("sap") || valid_description.contains("dynamics")) {
            extra_cost += 820;
        }
        if (valid_description.contains("ecommerce") || valid_description.contains("shopify") || valid_description.contains("woocommerce")) {
            extra_cost += 680;
        }
        if (valid_description.contains("pos") || valid_description.contains("point of sale")) {
            extra_cost += 620;
        }
        if (valid_description.contains("csv") || valid_description.contains("excel") || valid_description.contains("file")) {
            extra_cost += 320;
        }

        // 7. Εξωτερικά Δεδομένα (Weather, Holidays, Events)
        if (valid_description.contains("weather") || valid_description.contains("temperature")) {
            extra_cost += 580;
        }
        if (valid_description.contains("holiday") || valid_description.contains("event") || valid_description.contains("season")) {
            extra_cost += 420;
        }

        // 8. What-If Scenarios / Simulation
        if (valid_description.contains("what-if") || valid_description.contains("scenario") || 
            valid_description.contains("simulation") || valid_description.contains("forecast")) {
            extra_cost += 980;
        }

        // 9. Αυτόματη Επαναεκπαίδευση (Retraining)
        if (valid_description.contains("retrain") || valid_description.contains("auto") || 
            valid_description.contains("daily") || valid_description.contains("weekly")) {
            extra_cost += 780;
        }

        // 10. Ακρίβεια & Confidence Intervals
        if (valid_description.contains("confidence") || valid_description.contains("interval") || 
            valid_description.contains("accuracy") || valid_description.contains("mape")) {
            extra_cost += 520;
        }

        // 11. Ειδοποιήσεις / Alerts
        if (valid_description.contains("alert") || valid_description.contains("notification") || 
            valid_description.contains("email") || valid_description.contains("slack")) {
            extra_cost += 420;
        }

        // 12. Εξαγωγή Προβλέψεων (CSV, API, Dashboard)
        if (valid_description.contains("export") || valid_description.contains("download") || valid_description.contains("report")) {
            extra_cost += 380;
        }

        // 13. Real-time Prediction
        if (valid_description.contains("real-time") || valid_description.contains("live") || valid_description.contains("instant")) {
            extra_cost += 1100;
        }

        // 14. Multi-Store / Multi-Channel
        if (valid_description.contains("multi-store") || valid_description.contains("channel") || 
            valid_description.contains("online") && valid_description.contains("offline")) {
            extra_cost += 820;
        }

        // 15. Demand Forecasting by Region
        if (valid_description.contains("region") || valid_description.contains("location") || 
            valid_description.contains("city") || valid_description.contains("country")) {
            extra_cost += 680;
        }

        // 16. Custom Features / Seasonality
        if (valid_description.contains("custom") || valid_description.contains("feature") || 
            valid_description.contains("promotion") || valid_description.contains("discount")) {
            extra_cost += 920;
        }

        // 17. GDPR / Data Privacy
        if (valid_description.contains("gdpr") || valid_description.contains("privacy") || 
            valid_description.contains("anonymize") || valid_description.contains("secure")) {
            extra_cost += 480;
        }

        // 18. Admin Panel / User Roles
        if (valid_description.contains("admin") || valid_description.contains("dashboard") || 
            valid_description.contains("role") || valid_description.contains("team")) {
            extra_cost += 720;
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
        return counter;
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
        return add_to_cart;
    }
}
