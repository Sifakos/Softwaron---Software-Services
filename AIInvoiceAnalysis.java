package PackageService;

import java.util.Scanner;

public class AIInvoiceAnalysis implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your AI invoice analysis system (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους AI Invoice Analysis
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== AI INVOICE ANALYSIS ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 12);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος AI Invoice Analysis
        double base_cost = 1100.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Web, Desktop, API, Mobile)
        if (valid_description.contains("web")) {
            extra_cost += 480;
        }
        if (valid_description.contains("desktop") || valid_description.contains("windows") || valid_description.contains("mac")) {
            extra_cost += 680;
        }
        if (valid_description.contains("api") || valid_description.contains("integration")) {
            extra_cost += 780;
        }
        if (valid_description.contains("mobile") || valid_description.contains("android") || valid_description.contains("ios")) {
            extra_cost += 850;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε web + API
        if (!valid_description.contains("web") && !valid_description.contains("desktop") && 
            !valid_description.contains("api") && !valid_description.contains("mobile") && 
            !valid_description.contains("android") && !valid_description.contains("ios")) {
            extra_cost += 480 + 780; // web + API
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 120 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. OCR Engine (Tesseract, AWS Textract, Google Vision)
        if (valid_description.contains("ocr") || valid_description.contains("extract")) {
            extra_cost += 920;
            if (valid_description.contains("textract") || valid_description.contains("aws")) {
                extra_cost += 680;
            }
            if (valid_description.contains("vision") || valid_description.contains("google")) {
                extra_cost += 720;
            }
            if (valid_description.contains("tesseract") || valid_description.contains("open source")) {
                extra_cost += 420;
            }
        }

        // 4. Τύποι Τιμολογίων (PDF, Image, Scanned, Digital)
        if (valid_description.contains("pdf")) {
            extra_cost += 380;
        }
        if (valid_description.contains("image") || valid_description.contains("jpg") || valid_description.contains("png")) {
            extra_cost += 420;
        }
        if (valid_description.contains("scanned") || valid_description.contains("handwritten")) {
            extra_cost += 680;
        }
        if (valid_description.contains("digital") || valid_description.contains("xml") || valid_description.contains("edi")) {
            extra_cost += 520;
        }

        // 5. Εξαγωγή Πεδίων (ΑΦΜ, Ποσό, Ημερομηνία, Προμηθευτής, κλπ)
        if (valid_description.contains("vat") || valid_description.contains("afm") || valid_description.contains("tax id")) {
            extra_cost += 320;
        }
        if (valid_description.contains("amount") || valid_description.contains("total") || valid_description.contains("price")) {
            extra_cost += 340;
        }
        if (valid_description.contains("date") || valid_description.contains("ημερομηνία")) {
            extra_cost += 260;
        }
        if (valid_description.contains("supplier") || valid_description.contains("vendor") || valid_description.contains("company")) {
            extra_cost += 360;
        }
        if (valid_description.contains("line item") || valid_description.contains("product") || valid_description.contains("description")) {
            extra_cost += 580;
        }

        // 6. Αυτόματη Ταξινόμηση / Κατηγοριοποίηση
        if (valid_description.contains("categorization") || valid_description.contains("category") || 
            valid_description.contains("expense") || valid_description.contains("type")) {
            extra_cost += 620;
        }

        // 7. Έλεγχος Απάτης / Fraud Detection
        if (valid_description.contains("fraud") || valid_description.contains("anomaly") || 
            valid_description.contains("duplicate") || valid_description.contains("validation")) {
            extra_cost += 980;
        }

        // 8. Ενσωμάτωση με Λογιστική (QuickBooks, Xero, SAP)
        if (valid_description.contains("quickbooks") || valid_description.contains("xero") || 
            valid_description.contains("sap") || valid_description.contains("accounting")) {
            extra_cost += 820;
        }

        // 9. Αναφορές / Analytics
        if (valid_description.contains("report") || valid_description.contains("analytics") || 
            valid_description.contains("dashboard") || valid_description.contains("spending")) {
            extra_cost += 580;
        }

        // 10. Αριθμός Τιμολογίων / Μέγεθος
        int invoice_count = CountOccurrences(valid_description, "invoice") + CountOccurrences(valid_description, "document");
        if (invoice_count > 0) {
            extra_cost += 15 * Math.min(invoice_count * 100, 10000); // max $10,000 για 1M τιμολόγια
        } else {
            extra_cost += 1500; // default 100 τιμολόγια
        }

        // 11. Real-time Processing
        if (valid_description.contains("real-time") || valid_description.contains("live") || valid_description.contains("instant")) {
            extra_cost += 720;
        }

        // 12. Approval Workflow
        if (valid_description.contains("approval") || valid_description.contains("workflow") || 
            valid_description.contains("review") || valid_description.contains("manager")) {
            extra_cost += 680;
        }

        // 13. Export Formats (CSV, JSON, XML)
        if (valid_description.contains("csv") || valid_description.contains("json") || 
            valid_description.contains("xml") || valid_description.contains("export")) {
            extra_cost += 380;
        }

        // 14. Multi-Company Support
        if (valid_description.contains("multi-company") || valid_description.contains("tenant") || valid_description.contains("branch")) {
            extra_cost += 620;
        }

        // 15. Mobile Capture (Camera Upload)
        if (valid_description.contains("mobile") || valid_description.contains("camera") || 
            valid_description.contains("upload") || valid_description.contains("scan")) {
            extra_cost += 580;
        }

        // 16. Custom Training / Fine-tuning
        if (valid_description.contains("training") || valid_description.contains("custom") || 
            valid_description.contains("template") || valid_description.contains("fine-tune")) {
            extra_cost += 1100;
        }

        // 17. GDPR / Data Security
        if (valid_description.contains("gdpr") || valid_description.contains("encryption") || 
            valid_description.contains("secure") || valid_description.contains("privacy")) {
            extra_cost += 480;
        }

        // 18. Admin Panel / User Roles
        if (valid_description.contains("admin") || valid_description.contains("dashboard") || 
            valid_description.contains("role") || valid_description.contains("user")) {
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
