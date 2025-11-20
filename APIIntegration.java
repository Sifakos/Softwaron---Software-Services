package PackageService;

import java.util.Scanner;

public class APIIntegration implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your API integrations (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους υπηρεσίας API Integration
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== API INTEGRATION ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order == true) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 3);
            } else if (submit_service_order == false) {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής παραγγελίας σε πεζά γράμματα
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος API Integration
        double api_base_cost = 800.00;
        double api_extra_cost = 0;

        // 1. Τύπος API (REST, GraphQL, SOAP)
        if (valid_description.contains("rest") || valid_description.contains("restful")) {
            api_extra_cost += 650;
        }
        if (valid_description.contains("graphql")) {
            api_extra_cost += 850;
        }
        if (valid_description.contains("soap")) {
            api_extra_cost += 720;
        }
        // Αν δεν αναφέρεται τύπος, υποθέτουμε REST
        if (!valid_description.contains("rest") && !valid_description.contains("graphql") && !valid_description.contains("soap")) {
            api_extra_cost += 650; // REST by default
        }

        // 2. Αριθμός Endpoints
        int endpoints_count = 0;
        if (valid_description.contains("endpoint")) {
            endpoints_count = Math.max(endpoints_count, CountOccurrences(valid_description, "endpoint"));
        }
        if (valid_description.contains("route")) {
            endpoints_count = Math.max(endpoints_count, CountOccurrences(valid_description, "route"));
        }
        if (valid_description.contains("url")) {
            endpoints_count = Math.max(endpoints_count, CountOccurrences(valid_description, "url"));
        }
        if (endpoints_count > 0) {
            api_extra_cost += 120 * endpoints_count; // 120$ ανά endpoint
        } else {
            api_extra_cost += 120 * 5; // default 5 endpoints
        }

        // 3. Αυθεντικοποίηση (Authentication)
        if (valid_description.contains("auth") || valid_description.contains("authentication") || 
            valid_description.contains("token") || valid_description.contains("jwt") || valid_description.contains("oauth")) {
            api_extra_cost += 480;
            if (valid_description.contains("oauth2") || valid_description.contains("openid")) {
                api_extra_cost += 320; // επιπλέον για OAuth2
            }
        }

        // 4. Rate Limiting / Throttling
        if (valid_description.contains("rate limit") || valid_description.contains("throttling") || 
            valid_description.contains("quota") || valid_description.contains("limit")) {
            api_extra_cost += 340;
        }

        // 5. Pagination
        if (valid_description.contains("pagination") || valid_description.contains("page") || 
            valid_description.contains("offset") || valid_description.contains("limit")) {
            api_extra_cost += 220;
        }

        // 6. Filtering & Sorting
        if (valid_description.contains("filter") || valid_description.contains("sort") || 
            valid_description.contains("search") || valid_description.contains("query")) {
            api_extra_cost += 290;
        }

        // 7. Caching (Redis, Memcached)
        if (valid_description.contains("cache") || valid_description.contains("redis") || 
            valid_description.contains("memcached") || valid_description.contains("cdn")) {
            api_extra_cost += 410;
        }

        // 8. Webhooks
        if (valid_description.contains("webhook") || valid_description.contains("callback") || valid_description.contains("event")) {
            int webhook_count = CountOccurrences(valid_description, "webhook");
            webhook_count = Math.max(webhook_count, CountOccurrences(valid_description, "callback"));
            api_extra_cost += 380 * Math.max(1, webhook_count);
        }

        // 9. API Documentation (Swagger, Postman)
        if (valid_description.contains("documentation") || valid_description.contains("swagger") || 
            valid_description.contains("openapi") || valid_description.contains("postman")) {
            api_extra_cost += 320;
        }

        // 10. Versioning
        if (valid_description.contains("version") || valid_description.contains("v1") || 
            valid_description.contains("v2") || valid_description.contains("api version")) {
            api_extra_cost += 190;
        }

        // 11. Error Handling & Logging
        if (valid_description.contains("error") || valid_description.contains("log") || 
            valid_description.contains("monitoring") || valid_description.contains("sentry")) {
            api_extra_cost += 260;
        }

        // 12. CORS Support
        if (valid_description.contains("cors") || valid_description.contains("cross-origin")) {
            api_extra_cost += 140;
        }

        // 13. File Uploads / Downloads
        if (valid_description.contains("upload") || valid_description.contains("download") || 
            valid_description.contains("file") || valid_description.contains("s3") || valid_description.contains("storage")) {
            api_extra_cost += 520;
        }

        // 14. Real-time (WebSockets, Server-Sent Events)
        if (valid_description.contains("websocket") || valid_description.contains("sse") || 
            valid_description.contains("real-time") || valid_description.contains("socket")) {
            api_extra_cost += 980;
        }

        // 15. Database Integration
        if (valid_description.contains("database") || valid_description.contains("sql") || 
            valid_description.contains("mysql") || valid_description.contains("postgres") || 
            valid_description.contains("mongodb") || valid_description.contains("firebase")) {
            api_extra_cost += 680;
        }

        // 16. Testing (Unit, Integration, Load)
        if (valid_description.contains("test") || valid_description.contains("testing") || 
            valid_description.contains("postman") || valid_description.contains("jmeter")) {
            api_extra_cost += 590;
        }

        // 17. Deployment (Docker, Kubernetes, Cloud)
        if (valid_description.contains("docker") || valid_description.contains("kubernetes") || 
            valid_description.contains("aws") || valid_description.contains("gcp") || 
            valid_description.contains("azure") || valid_description.contains("deploy")) {
            api_extra_cost += 720;
        }

        // 18. Monitoring & Analytics
        if (valid_description.contains("monitoring") || valid_description.contains("analytics") || 
            valid_description.contains("new relic") || valid_description.contains("datadog")) {
            api_extra_cost += 430;
        }

        // Συνολικό κόστος API Integration
        double api_total_cost = api_base_cost + api_extra_cost;

        return (api_total_cost);
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
