package PackageService;

import java.util.Scanner;

public class Website implements iSoftwareService {
    
    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your website (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστοφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους υπηρεσίας ιστοσελίδας
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== WEBSITE ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order == true) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 1);
            } else if (submit_service_order == false) {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής παραγγελίας σε πεζά γράμματα
        String valid_description = description.toLowerCase();

        // Αρχικό - Επιπλέον κόστος ιστοσελίδας
        double website_base_cost = 500.00;
        double website_extra_cost = 0;

        // 1. Responsive Design
        if (valid_description.contains("responsive design") || valid_description.contains("responsive")) {
            if (valid_description.contains("mobile")) {
                website_extra_cost += 640;
            }
            if (valid_description.contains("tablet")) {
                website_extra_cost += 640;
            }
            if (valid_description.contains("desktop")) {
                website_extra_cost += 320;
            }
            // Αν δεν αναφερθεί συγκεκριμένη συσκευή, υποθέτουμε full responsive
            if (!valid_description.contains("mobile") && !valid_description.contains("tablet") && !valid_description.contains("desktop")) {
                website_extra_cost += 640 + 640 + 320; // full responsive
            }
        }

        // 2. Πολυγλωσσία
        if (valid_description.contains("language") || valid_description.contains("multilingual") || valid_description.contains("polyglossia")) {
            int languages_counter = CountLanguages(valid_description, "language");
            languages_counter = Math.max(languages_counter, CountLanguages(valid_description, "english"));
            website_extra_cost += 85 * Math.max(1, languages_counter); // τουλάχιστον 1 γλώσσα
        }

        // 3. SEO-Friendly URLs
        if (valid_description.contains("seo-friendly urls") || valid_description.contains("seo friendly urls") || 
            valid_description.contains("seo urls") || valid_description.contains("clean urls")) {
            website_extra_cost += 140;
        }

        // 4. Γρήγορη φόρτιση (<2s σε 3G)
        if (valid_description.contains("fast loading") || valid_description.contains("fast load") || valid_description.contains("performance") || valid_description.contains("page speed")) {
            website_extra_cost += 750;
        }

        // 5. SSL Πιστοποιητικό
        if (valid_description.contains("ssl certificate") || valid_description.contains("ssl certification") || valid_description.contains("https") || valid_description.contains("secure")) {
            website_extra_cost += 440;
        }

        // 6. GDPR Συμμόρφωση
        if (valid_description.contains("gdpr compliance") || valid_description.contains("gdpr")) {
            if (valid_description.contains("cookie banner") || valid_description.contains("cookies") || valid_description.contains("consent")) {
                website_extra_cost += 610;
            }
            if (valid_description.contains("privacy policy") || valid_description.contains("data protection")) {
                website_extra_cost += 380;
            }
            // Αν δεν αναφέρεται τίποτα συγκεκριμένο, προσθέτουμε και τα δύο
            if (!valid_description.contains("cookie") && !valid_description.contains("privacy")) {
                website_extra_cost += 610 + 380;
            }
        }

        // 7. E-shop Λειτουργίες
        if (valid_description.contains("e-shop") || valid_description.contains("eshop") || valid_description.contains("online store")) {
            website_extra_cost += 1200; // Βασικό E-Shop
            if (valid_description.contains("cart") || valid_description.contains("καλάθι")) {
                website_extra_cost += 180;
            }
            if (valid_description.contains("checkout") || valid_description.contains("πληρωμή")) {
                website_extra_cost += 320;
            }
            if (valid_description.contains("payment") || valid_description.contains("stripe") || valid_description.contains("paypal") || valid_description.contains("viva")) {
                website_extra_cost += 450;
            }
            if (valid_description.contains("shipping") || valid_description.contains("μεταφορικά") || valid_description.contains("courier")) {
                website_extra_cost += 280;
            }
        }

        // 8. Blog / CMS
        if (valid_description.contains("blog") || valid_description.contains("άρθρα") || valid_description.contains("cms")) {
            website_extra_cost += 580;
            if (valid_description.contains("comments") || valid_description.contains("σχόλια")) {
                website_extra_cost += 220;
            }
            if (valid_description.contains("categories") || valid_description.contains("tags")) {
                website_extra_cost += 120;
            }
        }

        // 9. Admin Panel
        if (valid_description.contains("admin") || valid_description.contains("dashboard") || valid_description.contains("διαχείριση")) {
            website_extra_cost += 900;
        }

        // 10. Φόρμες Επικοινωνίας
        if (valid_description.contains("contact form") || valid_description.contains("φόρμα") || valid_description.contains("email")) {
            website_extra_cost += 180;
            if (valid_description.contains("captcha") || valid_description.contains("spam")) {
                website_extra_cost += 90;
            }
        } 

        // 11. Newsletter
        if (valid_description.contains("newsletter") || valid_description.contains("mailchimp") || valid_description.contains("klaviyo")) {
            website_extra_cost += 260;
        }

        // 12. Social Media Integration
        if (valid_description.contains("social") || valid_description.contains("facebook") || valid_description.contains("instagram") || valid_description.contains("share") || valid_description.contains("login")) {
            website_extra_cost += 190;
        }

        // 13. Analytics
        if (valid_description.contains("analytics") || valid_description.contains("google analytics") || valid_description.contains("pixel")) {
            website_extra_cost += 150;
        }

        // 14. Live Chat
        if (valid_description.contains("chat") || valid_description.contains("tawk") || valid_description.contains("intercom")) {
            website_extra_cost += 210;
        }

        // 15. Custom Design (UI/UX)
        if (valid_description.contains("design") || valid_description.contains("ui") || valid_description.contains("ux") || valid_description.contains("figma") || valid_description.contains("mockup")) {
            website_extra_cost += 1100;
        }

        // 16. API Integration
        if (valid_description.contains("api") || valid_description.contains("integration") || valid_description.contains("external")) {
            website_extra_cost += 850;
        }

        // 17. Search Functionality
        if (valid_description.contains("search") || valid_description.contains("αναζήτηση") || valid_description.contains("filter")) {
            website_extra_cost += 340;
        }

        // 18. User Accounts / Login
        if (valid_description.contains("login") || valid_description.contains("account") || valid_description.contains("register")) {
            website_extra_cost += 680;
        }

        // Συνολικό κόστος ιστοσελίδας
        double website_total_cost = website_base_cost + website_extra_cost;

        return (website_total_cost);
    }

    // Βοηθητική μέθοδος για μέτρηση εμφανίσεων λέξης
    public int CountLanguages(String text, String word) {
        int counter = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            counter ++;
            index += word.length();
        }
        return (counter);
    }

    public boolean AddCart(Scanner scanner) throws InvalidAddCartAnswer{

        boolean add_to_cart = false;
        System.out.print("Add order to your cart (YES/NO): ");
        String submit_order = scanner.nextLine();
        if ((!submit_order.equals("Yes") || !submit_order.equals("YES")) || (!submit_order.equals("No") || !submit_order.equals("NO"))) {
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
