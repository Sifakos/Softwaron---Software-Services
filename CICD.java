package PackageService;

import java.util.Scanner;

public class CICD implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your CI/CD pipeline (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους CI/CD pipeline
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== CI/CD PIPELINE ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 9);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος CI/CD pipeline
        double base_cost = 800.00;
        double extra_cost = 0;

        // 1. Πλατφόρμα CI/CD
        if (valid_description.contains("jenkins")) {
            extra_cost += 680;
            if (valid_description.contains("self-hosted") || valid_description.contains("on-premise")) {
                extra_cost += 420;
            }
        }
        if (valid_description.contains("gitlab ci") || valid_description.contains("gitlab")) {
            extra_cost += 720;
        }
        if (valid_description.contains("github actions") || valid_description.contains("github")) {
            extra_cost += 580;
        }
        if (valid_description.contains("circleci") || valid_description.contains("circle")) {
            extra_cost += 650;
        }
        if (valid_description.contains("azure devops") || valid_description.contains("azure pipelines")) {
            extra_cost += 780;
        }
        if (valid_description.contains("aws codepipeline") || valid_description.contains("codepipeline")) {
            extra_cost += 820;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε GitHub Actions
        if (!valid_description.contains("jenkins") && !valid_description.contains("gitlab") && 
            !valid_description.contains("github") && !valid_description.contains("circleci") && 
            !valid_description.contains("azure") && !valid_description.contains("aws")) {
            extra_cost += 580; // GitHub Actions by default
        }

        // 2. Αριθμός Pipelines / Projects
        int pipeline_count = CountOccurrences(valid_description, "pipeline") + CountOccurrences(valid_description, "project");
        if (pipeline_count > 0) {
            extra_cost += 180 * Math.min(pipeline_count, 10); // max 10 pipelines
        } else {
            extra_cost += 360; // default 2 pipelines
        }

        // 3. Build Agents / Runners
        if (valid_description.contains("runner") || valid_description.contains("agent") || valid_description.contains("build")) {
            extra_cost += 420;
            if (valid_description.contains("self-hosted") || valid_description.contains("on-premise")) {
                extra_cost += 380;
            }
        }

        // 4. Testing Integration
        if (valid_description.contains("test") || valid_description.contains("unit") || 
            valid_description.contains("integration") || valid_description.contains("e2e")) {
            extra_cost += 520;
            if (valid_description.contains("parallel") || valid_description.contains("matrix")) {
                extra_cost += 290;
            }
        }

        // 5. Code Quality (SonarQube, CodeQL)
        if (valid_description.contains("sonarqube") || valid_description.contains("codeql") || 
            valid_description.contains("lint") || valid_description.contains("quality")) {
            extra_cost += 480;
        }

        // 6. Artifact Management (Nexus, Artifactory, S3)
        if (valid_description.contains("artifact") || valid_description.contains("nexus") || 
            valid_description.contains("artifactory") || valid_description.contains("package")) {
            extra_cost += 460;
        }

        // 7. Deployment Targets
        if (valid_description.contains("kubernetes") || valid_description.contains("k8s") || valid_description.contains("eks")) {
            extra_cost += 920;
        }
        if (valid_description.contains("docker") || valid_description.contains("container")) {
            extra_cost += 580;
        }
        if (valid_description.contains("aws") || valid_description.contains("ec2") || valid_description.contains("lambda")) {
            extra_cost += 680;
        }
        if (valid_description.contains("heroku") || valid_description.contains("vercel") || valid_description.contains("netlify")) {
            extra_cost += 420;
        }

        // 8. Environment Management (Dev, Staging, Prod)
        if (valid_description.contains("production") || valid_description.contains("prod")) {
            extra_cost += 520;
        }
        if (valid_description.contains("staging") || valid_description.contains("test")) {
            extra_cost += 380;
        }
        if (valid_description.contains("dev") || valid_description.contains("development")) {
            extra_cost += 320;
        }

        // 9. Secrets Management (Vault, AWS Secrets Manager)
        if (valid_description.contains("secret") || valid_description.contains("vault") || 
            valid_description.contains("parameter store") || valid_description.contains("env")) {
            extra_cost += 480;
        }

        // 10. Notifications (Slack, Email, Teams)
        if (valid_description.contains("slack") || valid_description.contains("email") || 
            valid_description.contains("teams") || valid_description.contains("notification")) {
            extra_cost += 320;
        }

        // 11. Rollback / Blue-Green / Canary
        if (valid_description.contains("rollback") || valid_description.contains("blue-green") || 
            valid_description.contains("canary") || valid_description.contains("zero-downtime")) {
            extra_cost += 720;
        }

        // 12. Infrastructure as Code (Terraform, CloudFormation)
        if (valid_description.contains("terraform") || valid_description.contains("cloudformation") || 
            valid_description.contains("iac") || valid_description.contains("pulumi")) {
            extra_cost += 850;
        }

        // 13. Monitoring Integration (Datadog, New Relic)
        if (valid_description.contains("datadog") || valid_description.contains("new relic") || 
            valid_description.contains("prometheus") || valid_description.contains("grafana")) {
            extra_cost += 580;
        }

        // 14. Security Scanning (SAST, DAST)
        if (valid_description.contains("sast") || valid_description.contains("dast") || 
            valid_description.contains("security") || valid_description.contains("scan")) {
            extra_cost += 680;
        }

        // 15. Multi-Branch / PR Workflow
        if (valid_description.contains("pull request") || valid_description.contains("pr") || 
            valid_description.contains("branch") || valid_description.contains("merge")) {
            extra_cost += 410;
        }

        // 16. Caching (Build Cache)
        if (valid_description.contains("cache") || valid_description.contains("speed") || valid_description.contains("faster")) {
            extra_cost += 360;
        }

        // 17. Scheduled Pipelines
        if (valid_description.contains("schedule") || valid_description.contains("cron") || valid_description.contains("nightly")) {
            extra_cost += 290;
        }

        // 18. Approval Gates
        if (valid_description.contains("approval") || valid_description.contains("manual") || 
            valid_description.contains("gate") || valid_description.contains("review")) {
            extra_cost += 450;
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
