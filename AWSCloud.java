package PackageService;

import java.util.Scanner;

public class AWSCloud implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your AWS cloud solution (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους AWS Cloud λύσης
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== AWS CLOUD SOLUTION ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 8);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος AWS Cloud λύσης
        double base_cost = 1100.00;
        double extra_cost = 0;

        // 1. Περιβάλλον (Dev, Staging, Production)
        if (valid_description.contains("production")) {
            extra_cost += 720;
        }
        if (valid_description.contains("staging") || valid_description.contains("test")) {
            extra_cost += 480;
        }
        if (valid_description.contains("dev") || valid_description.contains("development")) {
            extra_cost += 380;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε production + staging
        if (!valid_description.contains("production") && !valid_description.contains("staging") && 
            !valid_description.contains("test") && !valid_description.contains("dev") && !valid_description.contains("development")) {
            extra_cost += 720 + 480; // production + staging
        }

        // 2. Υπολογιστική Ισχύς (EC2, Lambda, ECS)
        if (valid_description.contains("ec2")) {
            extra_cost += 680;
            if (valid_description.contains("t3") || valid_description.contains("t4")) {
                extra_cost += 220;
            }
            if (valid_description.contains("m5") || valid_description.contains("c5") || valid_description.contains("compute")) {
                extra_cost += 420;
            }
        }
        if (valid_description.contains("lambda") || valid_description.contains("serverless")) {
            extra_cost += 580;
            if (valid_description.contains("api gateway")) {
                extra_cost += 360;
            }
        }
        if (valid_description.contains("ecs") || valid_description.contains("fargate") || valid_description.contains("container")) {
            extra_cost += 780;
        }

        // 3. Αποθήκευση (S3, EBS, EFS)
        if (valid_description.contains("s3")) {
            extra_cost += 420;
            if (valid_description.contains("glacier") || valid_description.contains("archive")) {
                extra_cost += 180;
            }
            if (valid_description.contains("intelligent-tiering")) {
                extra_cost += 260;
            }
        }
        if (valid_description.contains("ebs")) {
            extra_cost += 340;
        }
        if (valid_description.contains("efs") || valid_description.contains("file system")) {
            extra_cost += 580;
        }

        // 4. Βάση Δεδομένων (RDS, DynamoDB, Aurora)
        if (valid_description.contains("rds") || valid_description.contains("mysql") || 
            valid_description.contains("postgres") || valid_description.contains("sql server")) {
            extra_cost += 820;
            if (valid_description.contains("multi-az") || valid_description.contains("high availability")) {
                extra_cost += 520;
            }
        }
        if (valid_description.contains("dynamodb") || valid_description.contains("nosql")) {
            extra_cost += 720;
        }
        if (valid_description.contains("aurora")) {
            extra_cost += 980;
        }

        // 5. Δικτύωση (VPC, Load Balancer, CloudFront)
        if (valid_description.contains("vpc") || valid_description.contains("subnet") || valid_description.contains("security group")) {
            extra_cost += 480;
        }
        if (valid_description.contains("elb") || valid_description.contains("alb") || valid_description.contains("nlb")) {
            extra_cost += 520;
        }
        if (valid_description.contains("cloudfront") || valid_description.contains("cdn")) {
            extra_cost += 680;
        }

        // 6. Ασφάλεια (IAM, WAF, Shield, KMS)
        if (valid_description.contains("iam") || valid_description.contains("role") || valid_description.contains("policy")) {
            extra_cost += 380;
        }
        if (valid_description.contains("waf") || valid_description.contains("firewall")) {
            extra_cost += 620;
        }
        if (valid_description.contains("shield") || valid_description.contains("ddos")) {
            extra_cost += 780;
        }
        if (valid_description.contains("kms") || valid_description.contains("encryption")) {
            extra_cost += 420;
        }

        // 7. Monitoring & Logging (CloudWatch, X-Ray)
        if (valid_description.contains("cloudwatch") || valid_description.contains("metric") || valid_description.contains("alarm")) {
            extra_cost += 460;
        }
        if (valid_description.contains("x-ray") || valid_description.contains("tracing")) {
            extra_cost += 380;
        }
        if (valid_description.contains("logs") || valid_description.contains("log group")) {
            extra_cost += 320;
        }

        // 8. CI/CD (CodePipeline, CodeBuild, CodeDeploy)
        if (valid_description.contains("pipeline") || valid_description.contains("ci/cd") || valid_description.contains("deployment")) {
            extra_cost += 720;
            if (valid_description.contains("codebuild") || valid_description.contains("build")) {
                extra_cost += 340;
            }
            if (valid_description.contains("codedeploy")) {
                extra_cost += 380;
            }
        }

        // 9. Backup & Disaster Recovery
        if (valid_description.contains("backup") || valid_description.contains("snapshot") || 
            valid_description.contains("disaster") || valid_description.contains("recovery")) {
            extra_cost += 580;
        }

        // 10. Auto Scaling
        if (valid_description.contains("auto scaling") || valid_description.contains("scale")) {
            extra_cost += 520;
        }

        // 11. Serverless Architecture
        if (valid_description.contains("serverless") || valid_description.contains("lambda") || 
            valid_description.contains("api gateway") || valid_description.contains("dynamodb")) {
            extra_cost += 920;
        }

        // 12. Data Transfer / Bandwidth
        if (valid_description.contains("bandwidth") || valid_description.contains("traffic") || 
            valid_description.contains("gb") || valid_description.contains("transfer")) {
            extra_cost += 410;
        }

        // 13. Multi-Region Deployment
        if (valid_description.contains("multi-region") || valid_description.contains("global") || 
            valid_description.contains("replication")) {
            extra_cost += 1100;
        }

        // 14. Cost Optimization (Savings Plans, Reserved Instances)
        if (valid_description.contains("savings") || valid_description.contains("reserved") || 
            valid_description.contains("cost optimization")) {
            extra_cost += 480;
        }

        // 15. DevOps Automation (Terraform, CloudFormation)
        if (valid_description.contains("terraform") || valid_description.contains("cloudformation") || 
            valid_description.contains("iac") || valid_description.contains("infrastructure as code")) {
            extra_cost += 850;
        }

        // 16. API Gateway
        if (valid_description.contains("api gateway") || valid_description.contains("rest api")) {
            extra_cost += 620;
        }

        // 17. Cognito (Authentication)
        if (valid_description.contains("cognito") || valid_description.contains("auth") || 
            valid_description.contains("oauth") || valid_description.contains("sso")) {
            extra_cost += 580;
        }

        // 18. Migration Services (DMS, Snowball)
        if (valid_description.contains("migration") || valid_description.contains("dms") || 
            valid_description.contains("snowball") || valid_description.contains("transfer")) {
            extra_cost += 980;
        }

        // Συνολικό κόστος
        double total_cost = base_cost + extra_cost;

        return (total_cost);
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

    // Γενική μέθοδος μέτρησης
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
