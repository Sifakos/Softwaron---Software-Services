package PackageService;

import java.util.Scanner;

public class RPA implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your RPA (Robotic Process Automation) solution (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους RPA
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== RPA ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 14);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος RPA
        double base_cost = 1400.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, Desktop, API, Orchestrator)
        if (valid_description.contains("web") || valid_description.contains("browser")) {
            extra_cost += 680;
        }
        if (valid_description.contains("desktop") || valid_description.contains("windows") || valid_description.contains("citrix")) {
            extra_cost += 820;
        }
        if (valid_description.contains("api") || valid_description.contains("integration")) {
            extra_cost += 780;
        }
        if (valid_description.contains("orchestrator") || valid_description.contains("central") || valid_description.contains("management")) {
            extra_cost += 1100;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε desktop + orchestrator
        if (!valid_description.contains("web") && !valid_description.contains("desktop") && 
            !valid_description.contains("api") && !valid_description.contains("orchestrator") && 
            !valid_description.contains("windows") && !valid_description.contains("citrix")) {
            extra_cost += 820 + 1100; // desktop + orchestrator
        }

        // 2. Αριθμός Bots / Processes
        int bot_count = CountOccurrences(valid_description, "bot") + CountOccurrences(valid_description, "process") + CountOccurrences(valid_description, "automation");
        if (bot_count > 0) {
            extra_cost += 320 * Math.min(bot_count, 15); // max 15 bots
        } else {
            extra_cost += 960; // default 3 bots
        }

        // 3. Είδος Αυτοματισμού
        if (valid_description.contains("data entry") || valid_description.contains("form") || valid_description.contains("copy")) {
            extra_cost += 520;
        }
        if (valid_description.contains("invoice") || valid_description.contains("billing") || valid_description.contains("ap")) {
            extra_cost += 780;
        }
        if (valid_description.contains("report") || valid_description.contains("excel") || valid_description.contains("pdf")) {
            extra_cost += 620;
        }
        if (valid_description.contains("email") || valid_description.contains("outlook") || valid_description.contains("gmail")) {
            extra_cost += 580;
        }
        if (valid_description.contains("erp") || valid_description.contains("sap") || valid_description.contains("dynamics")) {
            extra_cost += 1100;
        }
        if (valid_description.contains("crm") || valid_description.contains("salesforce") || valid_description.contains("hubspot")) {
            extra_cost += 920;
        }

        // 4. Σύνθετες Λογικές (IF, Loops, Exception Handling)
        if (valid_description.contains("if") || valid_description.contains("condition") || 
            valid_description.contains("loop") || valid_description.contains("exception") || 
            valid_description.contains("error")) {
            extra_cost += 720;
        }

        // 5. OCR / Image Recognition
        if (valid_description.contains("ocr") || valid_description.contains("image") || 
            valid_description.contains("scan") || valid_description.contains("screenshot")) {
            extra_cost += 850;
        }

        // 6. Web Scraping
        if (valid_description.contains("scrape") || valid_description.contains("crawl") || 
            valid_description.contains("data extraction") || valid_description.contains("website")) {
            extra_cost += 780;
        }

        // 7. Database Interaction (SQL, NoSQL)
        if (valid_description.contains("database") || valid_description.contains("sql") || 
            valid_description.contains("mysql") || valid_description.contains("oracle") || 
            valid_description.contains("mongodb")) {
            extra_cost += 680;
        }

        // 8. File Handling (CSV, Excel, PDF, XML)
        if (valid_description.contains("csv") || valid_description.contains("excel") || 
            valid_description.contains("pdf") || valid_description.contains("xml")) {
            extra_cost += 420;
        }

        // 9. Scheduling (Daily, Weekly, Trigger-based)
        if (valid_description.contains("schedule") || valid_description.contains("daily") || 
            valid_description.contains("weekly") || valid_description.contains("trigger")) {
            extra_cost += 520;
        }

        // 10. Monitoring & Logging
        if (valid_description.contains("monitor") || valid_description.contains("log") || 
            valid_description.contains("alert") || valid_description.contains("dashboard")) {
            extra_cost += 620;
        }

        // 11. Human-in-the-Loop / Approval
        if (valid_description.contains("approval") || valid_description.contains("human") || 
            valid_description.contains("review") || valid_description.contains("manual")) {
            extra_cost += 680;
        }

        // 12. Attended vs Unattended Bots
        if (valid_description.contains("attended") || valid_description.contains("user")) {
            extra_cost += 820;
        }
        if (valid_description.contains("unattended") || valid_description.contains("server")) {
            extra_cost += 980;
        }

        // 13. Cloud vs On-Premise
        if (valid_description.contains("cloud") || valid_description.contains("saas") || valid_description.contains("aws")) {
            extra_cost += 720;
        }
        if (valid_description.contains("on-premise") || valid_description.contains("self-hosted")) {
            extra_cost += 1100;
        }

        // 14. Security (Encryption, Credentials, RBAC)
        if (valid_description.contains("encryption") || valid_description.contains("credential") || 
            valid_description.contains("vault") || valid_description.contains("rbac") || 
            valid_description.contains("secure")) {
            extra_cost += 780;
        }

        // 15. Scalability / High Volume
        if (valid_description.contains("high volume") || valid_description.contains("thousand") || 
            valid_description.contains("scale") || valid_description.contains("parallel")) {
            extra_cost += 920;
        }

        // 16. AI/ML Integration (Prediction, Classification)
        if (valid_description.contains("ai") || valid_description.contains("machine learning") || 
            valid_description.contains("predict") || valid_description.contains("classification")) {
            extra_cost += 1350;
        }

        // 17. Multi-Tenant / Multi-Department
        if (valid_description.contains("multi-tenant") || valid_description.contains("department") || 
            valid_description.contains("team") || valid_description.contains("isolated")) {
            extra_cost += 820;
        }

        // 18. Admin Panel / Bot Management
        if (valid_description.contains("admin") || valid_description.contains("orchestrator") || 
            valid_description.contains("control") || valid_description.contains("deploy")) {
            extra_cost += 980;
        }

        // Συνολικό κόστος
        double total_cost = base_cost + extra_cost;

        return (total_cost);
    }

    // Βοηθητική μέθοδος για μέτρηση εμφανίσεων λέξης
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