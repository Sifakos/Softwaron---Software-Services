package PackageService;

import java.util.Scanner;

public class KubernetesDocker implements iSoftwareService {

    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer {

        System.out.println("Please, tell us about the functionality of your Kubernetes & Docker solution (Type 'Exit' to return back): ");
        String software_service_description = scanner.nextLine();
        if (software_service_description.equals("Exit")) {
            return; // Επιστροφή στην επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
        } else {
            // Υπολογισμός κόστους Kubernetes & Docker λύσης
            double software_service_cost = GenerateSoftwareServiceCost(software_service_description);
            System.out.println("=== KUBERNETES & DOCKER SOLUTION ORDER COST ===");
            System.out.println("$" + software_service_cost);
            boolean submit_service_order = AddCart(scanner);
            if (submit_service_order) {
                shopping_cart.AddOrderLine(software_service_description, software_service_cost, 10);
            } else {
                System.out.println("Your order has been cancelled successfully");
            }
        }
    }

    public double GenerateSoftwareServiceCost(String description) {

        // Μετατροπή της περιγραφής σε πεζά
        String valid_description = description.toLowerCase();

        // Αρχικό κόστος Kubernetes & Docker λύσης
        double base_cost = 1200.00;
        double extra_cost = 0;

        // 1. Τύπος Cluster (EKS, GKE, AKS, Self-managed)
        if (valid_description.contains("eks") || valid_description.contains("aws")) {
            extra_cost += 980;
        }
        if (valid_description.contains("gke") || valid_description.contains("google")) {
            extra_cost += 920;
        }
        if (valid_description.contains("aks") || valid_description.contains("azure")) {
            extra_cost += 950;
        }
        if (valid_description.contains("self-managed") || valid_description.contains("on-premise") || 
            valid_description.contains("k3s") || valid_description.contains("microk8s")) {
            extra_cost += 1100;
        }
        // Αν δεν αναφέρεται τίποτα, υποθέτουμε EKS
        if (!valid_description.contains("eks") && !valid_description.contains("gke") && 
            !valid_description.contains("aks") && !valid_description.contains("self-managed") && 
            !valid_description.contains("k3s") && !valid_description.contains("microk8s")) {
            extra_cost += 980; // EKS by default
        }

        // 2. Αριθμός Nodes / Workers
        int node_count = CountOccurrences(valid_description, "node") + CountOccurrences(valid_description, "worker");
        if (node_count > 0) {
            extra_cost += 240 * Math.min(node_count, 20); // max 20 nodes
        } else {
            extra_cost += 720; // default 3 nodes
        }

        // 3. Container Registry (ECR, GCR, ACR, Docker Hub, Harbor)
        if (valid_description.contains("ecr")) {
            extra_cost += 380;
        }
        if (valid_description.contains("gcr") || valid_description.contains("artifact registry")) {
            extra_cost += 360;
        }
        if (valid_description.contains("acr")) {
            extra_cost += 390;
        }
        if (valid_description.contains("harbor") || valid_description.contains("self-hosted")) {
            extra_cost += 580;
        }
        if (valid_description.contains("docker hub") || valid_description.contains("dockerhub")) {
            extra_cost += 220;
        }

        // 4. CI/CD Integration
        if (valid_description.contains("ci/cd") || valid_description.contains("pipeline") || 
            valid_description.contains("github actions") || valid_description.contains("gitlab")) {
            extra_cost += 780;
        }

        // 5. Helm Charts
        if (valid_description.contains("helm") || valid_description.contains("chart") || valid_description.contains("package")) {
            extra_cost += 520;
            int helm_count = CountOccurrences(valid_description, "helm");
            if (helm_count > 1) {
                extra_cost += 120 * (helm_count - 1);
            }
        }

        // 6. Ingress Controller (NGINX, Traefik, ALB)
        if (valid_description.contains("ingress") || valid_description.contains("nginx") || 
            valid_description.contains("traefik") || valid_description.contains("alb")) {
            extra_cost += 620;
            if (valid_description.contains("ssl") || valid_description.contains("https") || valid_description.contains("letsencrypt")) {
                extra_cost += 280;
            }
        }

        // 7. Service Mesh (Istio, Linkerd)
        if (valid_description.contains("istio") || valid_description.contains("linkerd") || valid_description.contains("service mesh")) {
            extra_cost += 1100;
        }

        // 8. Monitoring (Prometheus, Grafana, CloudWatch)
        if (valid_description.contains("prometheus") || valid_description.contains("grafana") || 
            valid_description.contains("cloudwatch") || valid_description.contains("monitoring")) {
            extra_cost += 720;
            if (valid_description.contains("alert") || valid_description.contains("notification")) {
                extra_cost += 320;
            }
        }

        // 9. Logging (EFK, Loki, CloudWatch Logs)
        if (valid_description.contains("efk") || valid_description.contains("elasticsearch") || 
            valid_description.contains("fluentd") || valid_description.contains("kibana") || 
            valid_description.contains("loki") || valid_description.contains("logs")) {
            extra_cost += 680;
        }

        // 10. Auto Scaling (HPA, Cluster Autoscaler)
        if (valid_description.contains("hpa") || valid_description.contains("horizontal") || 
            valid_description.contains("cluster autoscaler") || valid_description.contains("scale")) {
            extra_cost += 580;
        }

        // 11. Persistent Storage (EBS, EFS, PVC)
        if (valid_description.contains("pvc") || valid_description.contains("persistent") || 
            valid_description.contains("ebs") || valid_description.contains("efs") || valid_description.contains("storage")) {
            extra_cost += 620;
        }

        // 12. Networking (Calico, Cilium, VPC CNI)
        if (valid_description.contains("calico") || valid_description.contains("cilium") || 
            valid_description.contains("cni") || valid_description.contains("network policy")) {
            extra_cost += 720;
        }

        // 13. Security (OPA, Gatekeeper, Pod Security)
        if (valid_description.contains("opa") || valid_description.contains("gatekeeper") || 
            valid_description.contains("pod security") || valid_description.contains("rbac")) {
            extra_cost += 820;
        }

        // 14. Multi-Tenancy / Namespaces
        if (valid_description.contains("multi-tenant") || valid_description.contains("namespace") || 
            valid_description.contains("tenant") || valid_description.contains("isolation")) {
            extra_cost += 680;
        }

        // 15. Backup & Restore (Velero)
        if (valid_description.contains("velero") || valid_description.contains("backup") || 
            valid_description.contains("restore") || valid_description.contains("disaster")) {
            extra_cost += 750;
        }

        // 16. GitOps (ArgoCD, Flux)
        if (valid_description.contains("argocd") || valid_description.contains("flux") || 
            valid_description.contains("gitops") || valid_description.contains("declarative")) {
            extra_cost += 920;
        }

        // 17. Custom Docker Images
        if (valid_description.contains("dockerfile") || valid_description.contains("custom image") || 
            valid_description.contains("build") || valid_description.contains("image")) {
            extra_cost += 480;
            int image_count = CountOccurrences(valid_description, "image") + CountOccurrences(valid_description, "dockerfile");
            if (image_count > 1) {
                extra_cost += 150 * (image_count - 1);
            }
        }

        // 18. High Availability / Multi-AZ
        if (valid_description.contains("high availability") || valid_description.contains("multi-az") || 
            valid_description.contains("ha") || valid_description.contains("redundancy")) {
            extra_cost += 1100;
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