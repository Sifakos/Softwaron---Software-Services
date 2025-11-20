package PackageService;

import java.util.Scanner;

public class Chatbot implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your chatbot (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους chatbot
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== CHATBOT ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 11);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος chatbot
        double base_cost = 700.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα (Website, Facebook, WhatsApp, Telegram, Slack)
        if (valid_description.contains("website") || valid_description.contains("web")) {
            extra_cost += 420;
        }
        if (valid_description.contains("facebook") || valid_description.contains("messenger")) {
            extra_cost += 380;
        }
        if (valid_description.contains("whatsapp")) {
            extra_cost += 580;
        }
        if (valid_description.contains("telegram")) {
            extra_cost += 360;
        }
        if (valid_description.contains("slack")) {
            extra_cost += 320;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε website
        if (!valid_description.contains("website") && !valid_description.contains("web") && 
            !valid_description.contains("facebook") && !valid_description.contains("whatsapp") && 
            !valid_description.contains("telegram") && !valid_description.contains("slack")) {
            extra_cost += 420; // website by default
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            extra_cost += 95 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. AI / NLP Engine
        if (valid_description.contains("ai") || valid_description.contains("nlp") || 
            valid_description.contains("dialogflow") || valid_description.contains("watson") || 
            valid_description.contains("rasa") || valid_description.contains("botpress")) {
            extra_cost += 920;
            if (valid_description.contains("custom nlu") || valid_description.contains("training")) {
                extra_cost += 680; // Custom training data
            }
        }

        // 4. Ενσωμάτωση με CRM / Backend
        if (valid_description.contains("crm") || valid_description.contains("salesforce") || 
            valid_description.contains("hubspot") || valid_description.contains("zoho") || 
            valid_description.contains("api") || valid_description.contains("integration")) {
            extra_cost += 720;
        }

        // 5. Live Chat Handover
        if (valid_description.contains("human") || valid_description.contains("agent") || 
            valid_description.contains("handover") || valid_description.contains("live")) {
            extra_cost += 480;
        }

        // 6. Πληρωμές
        if (valid_description.contains("payment") || valid_description.contains("stripe") || 
            valid_description.contains("paypal") || valid_description.contains("order")) {
            extra_cost += 620;
        }

        // 7. Κράτηση / Ραντεβού
        if (valid_description.contains("appointment") || valid_description.contains("booking") || 
            valid_description.contains("schedule") || valid_description.contains("calendar")) {
            extra_cost += 540;
        }

        // 8. Προτάσεις / Upsell
        if (valid_description.contains("recommend") || valid_description.contains("upsell") || 
            valid_description.contains("product") || valid_description.contains("suggestion")) {
            extra_cost += 420;
        }

        // 9. Συλλογή Leads
        if (valid_description.contains("lead") || valid_description.contains("email") || 
            valid_description.contains("phone") || valid_description.contains("capture")) {
            extra_cost += 360;
        }

        // 10. Analytics & Reports
        if (valid_description.contains("analytics") || valid_description.contains("report") || 
            valid_description.contains("dashboard") || valid_description.contains("conversion")) {
            extra_cost += 460;
        }

        // 11. Voice Support
        if (valid_description.contains("voice") || valid_description.contains("call") || 
            valid_description.contains("twilio") || valid_description.contains("speech")) {
            extra_cost += 780;
        }

        // 12. Rich Media (Images, Buttons, Carousels)
        if (valid_description.contains("image") || valid_description.contains("button") || 
            valid_description.contains("carousel") || valid_description.contains("card")) {
            extra_cost += 340;
        }

        // 13. 24/7 Availability
        if (valid_description.contains("24/7") || valid_description.contains("always") || valid_description.contains("nonstop")) {
            extra_cost += 290;
        }

        // 14. GDPR / Data Privacy
        if (valid_description.contains("gdpr") || valid_description.contains("privacy") || 
            valid_description.contains("secure") || valid_description.contains("encryption")) {
            extra_cost += 380;
        }

        // 15. Custom UI / Branding
        if (valid_description.contains("branding") || valid_description.contains("logo") || 
            valid_description.contains("color") || valid_description.contains("design")) {
            extra_cost += 520;
        }

        // 16. Sentiment Analysis
        if (valid_description.contains("sentiment") || valid_description.contains("emotion") || 
            valid_description.contains("mood") || valid_description.contains("feedback")) {
            extra_cost += 580;
        }

        // 17. Multi-Channel Orchestration
        if (valid_description.contains("multi-channel") || valid_description.contains("omnichannel") || 
            valid_description.contains("all platforms")) {
            extra_cost += 850;
        }

        // 18. Admin Panel / Dashboard
        if (valid_description.contains("admin") || valid_description.contains("dashboard") || 
            valid_description.contains("manage") || valid_description.contains("control")) {
            extra_cost += 680;
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
