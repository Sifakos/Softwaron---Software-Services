package PackageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

    private double cart_cost;

    // Custom Software Developement Υπηρεσίες
    List<WebsiteOrder> website_service_order = new ArrayList<>();
    List<ApplicationOrder> application_service_order = new ArrayList<>();
    List<APIIntegrationOrder> api_integration_serice_order = new ArrayList<>();

    // Υπηρεσίες SaaS
    List<AppointmentManagementOrder> appointment_management_service_order = new ArrayList<>();
    List<InvoiceSoftwareOrder> invoice_software_service_order = new ArrayList<>();
    List<HRToolsOrder> hr_tools_service_order = new ArrayList<>();
    List<ELearningOrder> elearning_service_order = new ArrayList<>();

    // Υπηρεσίες DevOps & Cloud
    List<AWSCloudOrder> aws_cloud_service_order = new ArrayList<>();
    List<CICDOrder> ci_cd_service_order = new ArrayList<>();
    List<KubernetesDockerOrder> k8s_docker_service_order = new ArrayList<>();

    // Υπηρεσίες AI & Automation
    List<ChatbotOrder> chatbot_service_order = new ArrayList<>();
    List<AIInvoiceAnalysisOrder> ai_invoice_service_order = new ArrayList<>();
    List<SalesPredictionOrder> sales_prediction_service_order = new ArrayList<>();
    List<RPAOrder> rpa_service_order = new ArrayList<>();

    public void AddOrderLine(String description, double price, int service_id) {

        if (service_id == 1) {
            website_service_order.add(new WebsiteOrder(description, price));
        } else if (service_id == 2) {
            application_service_order.add(new ApplicationOrder(description, price));
        } else if (service_id == 3) {
            api_integration_serice_order.add(new APIIntegrationOrder(description, price));
        } else if (service_id == 4) {
            appointment_management_service_order.add(new AppointmentManagementOrder(description, price));
        } else if (service_id == 5) {
            invoice_software_service_order.add(new InvoiceSoftwareOrder(description, price));
        } else if (service_id == 6) {
            hr_tools_service_order.add(new HRToolsOrder(description, price));
        } else if (service_id == 7) {
            elearning_service_order.add(new ELearningOrder(description, price));
        } else if (service_id == 8) {
            aws_cloud_service_order.add(new AWSCloudOrder(description, price));
        } else if (service_id == 9) {
            ci_cd_service_order.add(new CICDOrder(description, price));
        } else if (service_id == 10) {
            k8s_docker_service_order.add(new KubernetesDockerOrder(description, price));
        } else if (service_id == 11) {
            chatbot_service_order.add(new ChatbotOrder(description, price));
        } else if (service_id == 12) {
            ai_invoice_service_order.add(new AIInvoiceAnalysisOrder(description, price));
        } else if (service_id == 13) {
            sales_prediction_service_order.add(new SalesPredictionOrder(description, price));
        } else if (service_id == 14) {
            rpa_service_order.add(new RPAOrder(description, price));
        }
        this.cart_cost += price;
    }

    public void ViewCart() {

    // Έλεγχος άδειου καλαθιού
    if (this.website_service_order.isEmpty() && 
        this.application_service_order.isEmpty() && 
        this.api_integration_serice_order.isEmpty() && 
        this.appointment_management_service_order.isEmpty() && 
        this.invoice_software_service_order.isEmpty() && 
        this.hr_tools_service_order.isEmpty() && 
        this.elearning_service_order.isEmpty() && 
        this.aws_cloud_service_order.isEmpty() && 
        this.ci_cd_service_order.isEmpty() && 
        this.k8s_docker_service_order.isEmpty() && 
        this.chatbot_service_order.isEmpty() && 
        this.ai_invoice_service_order.isEmpty() && 
        this.sales_prediction_service_order.isEmpty() && 
        this.rpa_service_order.isEmpty()) {
            System.out.println("Your cart is empty");
    } else {
        
        // Συνολική αξία καλαθιού
        System.out.println("=== CART COST ===");
        System.out.println("$" + this.cart_cost);

        // Προβολή παραγγελιών ιστοσελίδας
        if (!this.website_service_order.isEmpty()) {
            System.out.println("=== WEBSITE ORDERS ===");
            for (int i = 0; i < this.website_service_order.size(); i++) {
                System.out.println("Website Order No." + (i + 1) + " $" + this.website_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών εφαρμογών
        if (!this.application_service_order.isEmpty()) {
            System.out.println("=== APPLICATION ORDERS ===");
            for (int i = 0; i < this.application_service_order.size(); i++) {
                System.out.println("Application Order No." + (i + 1) + " $" + this.application_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών API Integration
        if (!this.api_integration_serice_order.isEmpty()) {
            System.out.println("=== API INTEGRATION ORDERS ===");
            for (int i = 0; i < this.api_integration_serice_order.size(); i++) {
                System.out.println("API Integration Order No." + (i + 1) + " $" + this.api_integration_serice_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών Appointment Management
        if (!this.appointment_management_service_order.isEmpty()) {
            System.out.println("=== APPOINTMENT MANAGEMENT ORDERS ===");
            for (int i = 0; i < this.appointment_management_service_order.size(); i++) {
                System.out.println("Appointment Management Order No." + (i + 1) + " $" + this.appointment_management_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών Invoice Software
        if (!this.invoice_software_service_order.isEmpty()) {
            System.out.println("=== INVOICE SOFTWARE ORDERS ===");
            for (int i = 0; i < this.invoice_software_service_order.size(); i++) {
                System.out.println("Invoice Software Order No." + (i + 1) + " $" + this.invoice_software_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών HR Tools
        if (!this.hr_tools_service_order.isEmpty()) {
            System.out.println("=== HR TOOLS ORDERS ===");
            for (int i = 0; i < this.hr_tools_service_order.size(); i++) {
                System.out.println("HR Tools Order No." + (i + 1) + " $" + this.hr_tools_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών E-Learning
        if (!this.elearning_service_order.isEmpty()) {
            System.out.println("=== E-LEARNING ORDERS ===");
            for (int i = 0; i < this.elearning_service_order.size(); i++) {
                System.out.println("E-Learning Order No." + (i + 1) + " $" + this.elearning_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών AWS Cloud
        if (!this.aws_cloud_service_order.isEmpty()) {
            System.out.println("=== AWS CLOUD ORDERS ===");
            for (int i = 0; i < this.aws_cloud_service_order.size(); i++) {
                System.out.println("AWS Cloud Order No." + (i + 1) + " $" + this.aws_cloud_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών CI/CD
        if (!this.ci_cd_service_order.isEmpty()) {
            System.out.println("=== CI/CD ORDERS ===");
            for (int i = 0; i < this.ci_cd_service_order.size(); i++) {
                System.out.println("CI/CD Order No." + (i + 1) + " $" + this.ci_cd_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών Kubernetes/Docker
        if (!this.k8s_docker_service_order.isEmpty()) {
            System.out.println("=== K (KUBERNETES/DOCKER ORDERS) ===");
            for (int i = 0; i < this.k8s_docker_service_order.size(); i++) {
                System.out.println("Kubernetes/Docker Order No." + (i + 1) + " $" + this.k8s_docker_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών Chatbot
        if (!this.chatbot_service_order.isEmpty()) {
            System.out.println("=== CHATBOT ORDERS ===");
            for (int i = 0; i < this.chatbot_service_order.size(); i++) {
                System.out.println("Chatbot Order No." + (i + 1) + " $" + this.chatbot_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών AI Invoice Analysis
        if (!this.ai_invoice_service_order.isEmpty()) {
            System.out.println("=== AI INVOICE ANALYSIS ORDERS ===");
            for (int i = 0; i < this.ai_invoice_service_order.size(); i++) {
                System.out.println("AI Invoice Analysis Order No." + (i + 1) + " $" + this.ai_invoice_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών Sales Prediction
        if (!this.sales_prediction_service_order.isEmpty()) {
            System.out.println("=== SALES PREDICTION ORDERS ===");
            for (int i = 0; i < this.sales_prediction_service_order.size(); i++) {
                System.out.println("Sales Prediction Order No." + (i + 1) + " $" + this.sales_prediction_service_order.get(i).GetOrderPrice());
            }
        }

        // Προβολή παραγγελιών RPA
        if (!this.rpa_service_order.isEmpty()) {
            System.out.println("=== RPA ORDERS ===");
            for (int i = 0; i < this.rpa_service_order.size(); i++) {
                System.out.println("RPA Order No." + (i + 1) + " $" + this.rpa_service_order.get(i).GetOrderPrice());
            }
        }
    }
}

    public void DeleteSoftwareService(Scanner scanner) throws InvalidSoftwareSection, InvalidCustomSoftwareDevelopementService, InvalidSaasDevelopementService, InvalidDevOpsCloudDevelopementService, InvalidAIAutomationService, InvalidSoftwareOrderNumber{

        System.out.println("Custom Software Developement (1) | Saas Products (2) | DevOps & Cloud Services (3) | AI & Automation (4) | Shopping Cart (5) | Exit (6)");
        System.out.print("Select software section (1-5): ");
        int software_section = scanner.nextInt();
        // Επιλογή κατηγορίας υπηρεσιών λογισμικού
        while (software_section != 5) {
            if (software_section < 1 || software_section > 5) {
                throw new InvalidSoftwareSection("We're sorry but you have input an invalid software section");
            } else {
                if (software_section == 1) {
                    System.out.println("Websites (1) | Applications (2) | API Integrations (3) | Exit (4)");
                    System.out.print("Select custom software developement service (1-3): ");
                    int custom_software_developement_service = scanner.nextInt();
                    // Επιλογή υπηρεσίας προσαρμοσμένου λογισμικού
                    while (custom_software_developement_service != 4) {
                        if (custom_software_developement_service < 1 || custom_software_developement_service > 4) {
                            throw new InvalidCustomSoftwareDevelopementService("We're sorry but you have input an invalid custom software developement service");
                        } else {
                            if (custom_software_developement_service == 1) {
                                // Προβολή παραγγελιών ιστοσελίδας
                                System.out.println("=== WEBSITE ORDERS ===");
                                for (int i = 0; i < this.website_service_order.size(); i ++) {
                                    System.out.println("Website Order No." + (i + 1) + "$"+ this.website_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter website number (1 -" + this.website_service_order.size()+"): ");
                                int website_order_number = scanner.nextInt();
                                if (website_order_number < 1 || website_order_number > this.website_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid website order number");
                                } else {
                                    this.cart_cost -= website_service_order.get(website_order_number - 1).GetOrderPrice();
                                    website_service_order.remove(website_order_number - 1);
                                }
                            } else if (custom_software_developement_service == 2) {
                                // Προβολή παραγγελιών εφαρμογών
                                System.out.println("=== APPLICATION ORDERS ===");
                                for (int i = 0; i < this.application_service_order.size(); i ++) {
                                    System.out.println("Application Order No." + (i + 1) + "$"+ this.application_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter application number (1 -" + this.application_service_order.size()+"): ");
                                int application_order_number = scanner.nextInt();
                                if (application_order_number < 1 || application_order_number > this.application_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid application order number");
                                } else {
                                    this.cart_cost -= application_service_order.get(application_order_number - 1).GetOrderPrice();
                                    application_service_order.remove(application_order_number - 1);
                                }
                            } else if (custom_software_developement_service == 3) {
                                // Προβολή παραγγελιών API Integration
                                System.out.println("=== API INTEGRATION ORDERS ===");
                                for (int i = 0; i < this.api_integration_serice_order.size(); i ++) {
                                    System.out.println("API Integration Order No." + (i + 1) + "$"+ this.api_integration_serice_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter API integration number (1 -" + this.api_integration_serice_order.size()+"): ");
                                int api_integration_order_number = scanner.nextInt();
                                if (api_integration_order_number < 1 || api_integration_order_number > this.api_integration_serice_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid API integration order number");
                                } else {
                                    this.cart_cost -= api_integration_serice_order.get(api_integration_order_number - 1).GetOrderPrice();
                                    api_integration_serice_order.remove(api_integration_order_number - 1);
                                }
                            }
                        }
                        System.out.println("Websites (1) | Applications (2) | API Integrations (3) | Exit (4)");
                        System.out.print("Select custom software developement service (1-3): ");
                        custom_software_developement_service = scanner.nextInt();
                    }
                } else if (software_section == 2) {
                    System.out.println("Appointment Management (1) | Invoice Software (2) | HR Tools (3) | E-Learning (4) | Exit (5)");
                    System.out.print("Select Saas developement service (1-4): ");
                    int saas_developement_service = scanner.nextInt();
                    // Επιλογή υπηρεσίας SaaS
                    while (saas_developement_service != 5) {
                        if (saas_developement_service < 1 || saas_developement_service > 5) {
                            throw new InvalidSaasDevelopementService("We're sorry but you have input an invalid Saas developement service");
                        } else {
                            if (saas_developement_service == 1) {
                                // Προβολή παραγγελιών Appointment Management
                                System.out.println("=== APPOINTMENT MANAGEMENT ORDERS ===");
                                for (int i = 0; i < this.appointment_management_service_order.size(); i ++) {
                                    System.out.println("Appointment Management Order No." + (i + 1) + "$"+ this.appointment_management_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter appointment management number (1 -" + this.appointment_management_service_order.size()+"): ");
                                int appointment_management_order_number = scanner.nextInt();
                                if (appointment_management_order_number < 1 || appointment_management_order_number > this.appointment_management_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid appointment management order number");
                                } else {
                                    this.cart_cost -= appointment_management_service_order.get(appointment_management_order_number - 1).GetOrderPrice();
                                    appointment_management_service_order.remove(appointment_management_order_number - 1);
                                }
                            } else if (saas_developement_service == 2) {
                                // Προβολή παραγγελιών Invoice Software
                                System.out.println("=== INVOICE SOFTWARE ORDERS ===");
                                for (int i = 0; i < this.invoice_software_service_order.size(); i ++) {
                                    System.out.println("Invoice Software Order No." + (i + 1) + "$"+ this.invoice_software_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter invoice software number (1 -" + this.invoice_software_service_order.size()+"): ");
                                int invoice_software_order_number = scanner.nextInt();
                                if (invoice_software_order_number < 1 || invoice_software_order_number > this.invoice_software_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid invoice software order number");
                                } else {
                                    this.cart_cost -= invoice_software_service_order.get(invoice_software_order_number - 1).GetOrderPrice();
                                    invoice_software_service_order.remove(invoice_software_order_number - 1);
                                }
                            } else if (saas_developement_service == 3) {
                                // Προβολή παραγγελιών HR Tools
                                System.out.println("=== HR TOOLS ORDERS ===");
                                for (int i = 0; i < this.hr_tools_service_order.size(); i ++) {
                                    System.out.println("HR Tools Order No." + (i + 1) + "$"+ this.hr_tools_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter HR tools number (1 -" + this.hr_tools_service_order.size()+"): ");
                                int hr_tools_order_number = scanner.nextInt();
                                if (hr_tools_order_number < 1 || hr_tools_order_number > this.hr_tools_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid HR tools order number");
                                } else {
                                    this.cart_cost -= hr_tools_service_order.get(hr_tools_order_number - 1).GetOrderPrice();
                                    hr_tools_service_order.remove(hr_tools_order_number - 1);
                                }
                            } else if (saas_developement_service == 4) {
                                // Προβολή παραγγελιών E-Learning
                                System.out.println("=== E-LEARNING ORDERS ===");
                                for (int i = 0; i < this.elearning_service_order.size(); i ++) {
                                    System.out.println("E-Learning Order No." + (i + 1) + "$"+ this.elearning_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter e-learning number (1 -" + this.elearning_service_order.size()+"): ");
                                int elearning_order_number = scanner.nextInt();
                                if (elearning_order_number < 1 || elearning_order_number > this.elearning_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid e-learning order number");
                                } else {
                                    this.cart_cost -= elearning_service_order.get(elearning_order_number - 1).GetOrderPrice();
                                    elearning_service_order.remove(elearning_order_number - 1);
                                }
                            }
                        }
                        System.out.println("Appointment Management (1) | Invoice Software (2) | HR Tools (3) | E-Learning (4) | Exit (5)");
                        System.out.print("Select Saas developement service (1-4): ");
                        saas_developement_service = scanner.nextInt();
                    }
                } else if (software_section == 3) {
                    System.out.println("AWS/Azure/Google Cloud (1) | CI/CD Pipelines (2) | Kubernetes & Docker (3) | Exit (4)");
                    System.out.print("Select DevOps & Cloud developement service (1-3): ");
                    int devops_cloud_developement_service = scanner.nextInt();
                    // Επιλογή υπηρεσίας DevOps & Cloud
                    while (devops_cloud_developement_service != 4) {
                        if (devops_cloud_developement_service < 1 || devops_cloud_developement_service > 4) {
                            throw new InvalidDevOpsCloudDevelopementService("We're sorry but you have input an invalid DevOps & Cloud developement service");
                        } else {
                            if (devops_cloud_developement_service == 1) {
                                // Προβολή παραγγελιών AWS Cloud
                                System.out.println("=== AWS CLOUD ORDERS ===");
                                for (int i = 0; i < this.aws_cloud_service_order.size(); i ++) {
                                    System.out.println("AWS Cloud Order No." + (i + 1) + "$"+ this.aws_cloud_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter AWS cloud number (1 -" + this.aws_cloud_service_order.size()+"): ");
                                int aws_cloud_order_number = scanner.nextInt();
                                if (aws_cloud_order_number < 1 || aws_cloud_order_number > this.aws_cloud_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid AWS cloud order number");
                                } else {
                                    this.cart_cost -= aws_cloud_service_order.get(aws_cloud_order_number - 1).GetOrderPrice();
                                    aws_cloud_service_order.remove(aws_cloud_order_number - 1);
                                }
                            } else if (devops_cloud_developement_service == 2) {
                                // Προβολή παραγγελιών CI/CD
                                System.out.println("=== CI/CD ORDERS ===");
                                for (int i = 0; i < this.ci_cd_service_order.size(); i ++) {
                                    System.out.println("CI/CD Order No." + (i + 1) + "$"+ this.ci_cd_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter CI/CD number (1 -" + this.ci_cd_service_order.size()+"): ");
                                int ci_cd_order_number = scanner.nextInt();
                                if (ci_cd_order_number < 1 || ci_cd_order_number > this.ci_cd_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid CI/CD order number");
                                } else {
                                    this.cart_cost -= ci_cd_service_order.get(ci_cd_order_number - 1).GetOrderPrice();
                                    ci_cd_service_order.remove(ci_cd_order_number - 1);
                                }
                            } else if (devops_cloud_developement_service == 3) {
                                // Προβολή παραγγελιών Kubernetes/Docker
                                System.out.println("=== KUBERNETES/DOCKER ORDERS ===");
                                for (int i = 0; i < this.k8s_docker_service_order.size(); i ++) {
                                    System.out.println("Kubernetes/Docker Order No." + (i + 1) + "$"+ this.k8s_docker_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter Kubernetes/Docker number (1 -" + this.k8s_docker_service_order.size()+"): ");
                                int k8s_docker_order_number = scanner.nextInt();
                                if (k8s_docker_order_number < 1 || k8s_docker_order_number > this.k8s_docker_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid Kubernetes/Docker order number");
                                } else {
                                    this.cart_cost -= k8s_docker_service_order.get(k8s_docker_order_number - 1).GetOrderPrice();
                                    k8s_docker_service_order.remove(k8s_docker_order_number - 1);
                                }
                            }
                        }
                        System.out.println("AWS/Azure/Google Cloud (1) | CI/CD Pipelines (2) | Kubernetes & Docker (3) | Exit (4)");
                        System.out.print("Select DevOps & Cloud developement service (1-3): ");
                        devops_cloud_developement_service = scanner.nextInt();
                    }
                } else if (software_section == 4) {
                    System.out.println("Chatbots (1) | AI Invoice Analysis (2) | Sales Predictions (3) | RPA (4) | Exit (5)");
                    System.out.print("Select AI & Automation service (1-4): ");
                    int ai_automation_service = scanner.nextInt();
                    // Επιλογή υπηρεσίας AI & Automation
                    while (ai_automation_service != 5) {
                        if (ai_automation_service < 1 || ai_automation_service > 5) {
                            throw new InvalidAIAutomationService("We're sorry but you have input an invalid AI & Automation service");
                        } else {
                            if (ai_automation_service == 1) {
                                // Προβολή παραγγελιών Chatbot
                                System.out.println("=== CHATBOT ORDERS ===");
                                for (int i = 0; i < this.chatbot_service_order.size(); i ++) {
                                    System.out.println("Chatbot Order No." + (i + 1) + "$"+ this.chatbot_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter chatbot number (1 -" + this.chatbot_service_order.size()+"): ");
                                int chatbot_order_number = scanner.nextInt();
                                if (chatbot_order_number < 1 || chatbot_order_number > this.chatbot_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid chatbot order number");
                                } else {
                                    this.cart_cost -= chatbot_service_order.get(chatbot_order_number - 1).GetOrderPrice();
                                    chatbot_service_order.remove(chatbot_order_number - 1);
                                }
                            } else if (ai_automation_service == 2) {
                                // Προβολή παραγγελιών AI Invoice Analysis
                                System.out.println("=== AI INVOICE ANALYSIS ORDERS ===");
                                for (int i = 0; i < this.ai_invoice_service_order.size(); i ++) {
                                    System.out.println("AI Invoice Analysis Order No." + (i + 1) + "$"+ this.ai_invoice_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter AI invoice analysis number (1 -" + this.ai_invoice_service_order.size()+"): ");
                                int ai_invoice_order_number = scanner.nextInt();
                                if (ai_invoice_order_number < 1 || ai_invoice_order_number > this.ai_invoice_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid AI invoice analysis order number");
                                } else {
                                    this.cart_cost -= ai_invoice_service_order.get(ai_invoice_order_number - 1).GetOrderPrice();
                                    ai_invoice_service_order.remove(ai_invoice_order_number - 1);
                                }
                            } else if (ai_automation_service == 3) {
                                // Προβολή παραγγελιών Sales Prediction
                                System.out.println("=== SALES PREDICTION ORDERS ===");
                                for (int i = 0; i < this.sales_prediction_service_order.size(); i ++) {
                                    System.out.println("Sales Prediction Order No." + (i + 1) + "$"+ this.sales_prediction_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter sales prediction number (1 -" + this.sales_prediction_service_order.size()+"): ");
                                int sales_prediction_order_number = scanner.nextInt();
                                if (sales_prediction_order_number < 1 || sales_prediction_order_number > this.sales_prediction_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid sales prediction order number");
                                } else {
                                    this.cart_cost -= sales_prediction_service_order.get(sales_prediction_order_number - 1).GetOrderPrice();
                                    sales_prediction_service_order.remove(sales_prediction_order_number - 1);
                                }
                            } else if (ai_automation_service == 4) {
                                // Προβολή παραγγελιών RPA
                                System.out.println("=== RPA ORDERS ===");
                                for (int i = 0; i < this.rpa_service_order.size(); i ++) {
                                    System.out.println("RPA Order No." + (i + 1) + "$"+ this.rpa_service_order.get(i).GetOrderPrice());
                                }
                                System.out.print("Enter RPA number (1 -" + this.rpa_service_order.size()+"): ");
                                int rpa_order_number = scanner.nextInt();
                                if (rpa_order_number < 1 || rpa_order_number > this.rpa_service_order.size()) {
                                    throw new InvalidSoftwareOrderNumber("We're sorry but you have input an invalid RPA order number");
                                } else {
                                    this.cart_cost -= rpa_service_order.get(rpa_order_number - 1).GetOrderPrice();
                                    rpa_service_order.remove(rpa_order_number - 1);
                                }
                            }
                        }
                        System.out.println("Chatbots (1) | AI Invoice Analysis (2) | Sales Predictions (3) | RPA (4) | Exit (5)");
                        System.out.print("Select AI & Automation service (1-4): ");
                        ai_automation_service = scanner.nextInt();
                    }
                }
            }
            System.out.println("Custom Software Developement (1) | Saas Products (2) | DevOps & Cloud Services (3) | AI & Automation (4) | Shopping Cart (5) | Exit (6)");
            System.out.print("Select software section (1-5): ");
            software_section = scanner.nextInt();
        }
    }

    public void BuyCart(Scanner scanner, Client client_data) throws InvalidBuyCartAnswer {

        System.out.print("Purchase cart (YES/NO): ");
        String submit_purchase = scanner.nextLine();
        if ((!submit_purchase.equals("Yes") || !submit_purchase.equals("YES")) || (!submit_purchase.equals("No") || !submit_purchase.equals("NO"))) {
            throw new InvalidBuyCartAnswer("We're sorry, but you have input an invalid answer");
        } else {
            if (submit_purchase.equals("Yes") || submit_purchase.equals("YES")) {
                if (client_data.GetBankingData().GetBankBalance() < this.cart_cost) {
                    System.out.println("Low balance - Invalid cart purchase");
                } else if (client_data.GetBankingData().GetBankBalance() >= this.cart_cost) {
                    double order_cost = this.cart_cost;
                    client_data.GetBankingData().UpdateBalance(order_cost); // Ενημέρωση τραπεζικολυ λογαριασμού
                    CreateInvoice(client_data); // Έκδοση τιμολογίου
                    ClearCart(); // Καθαρισμός καλαθιού
                }
            } else if (submit_purchase.equals("No") || submit_purchase.equals("NO")) {
                ClearCart(); // Καθαρισμός καλαθιού
            }
        }
    }

    public void ClearCart() {

        this.cart_cost = 0;

        this.website_service_order.clear();
        this.application_service_order.clear();
        this.api_integration_serice_order.clear();
        this.appointment_management_service_order.clear();
        this.invoice_software_service_order.clear();
        this.hr_tools_service_order.clear();
        this.elearning_service_order.clear();
        this.aws_cloud_service_order.clear();
        this.ci_cd_service_order.clear();
        this.k8s_docker_service_order.clear();
        this.chatbot_service_order.clear();
        this.ai_invoice_service_order.clear();
        this.sales_prediction_service_order.clear();
        this.rpa_service_order.clear();
    }

    public void CreateInvoice(Client client_data) {

        System.out.println("================ INVOICE ================");
        System.out.println("Client Name: " + client_data.GetPersonalData().GetName()); 
        System.out.println("Client Email: " + client_data.GetPersonalData().GetEMail()); 
        System.out.println("Date: " + new java.util.Date());
        System.out.println("----------------------------------------");
        double total_order_amount = 0.0;

        // Παραγγελίες ιστοσελίδων
        if (!this.website_service_order.isEmpty()) {
            System.out.println("=== WEBSITE ORDERS ===");
            for (int i = 0; i < this.website_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + website_service_order.get(i).GetOrderDescription() + " - $" + website_service_order.get(i).GetOrderPrice());
                total_order_amount += website_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες εφαρμογών
        if (!this.application_service_order.isEmpty()) {
            System.out.println("=== APPLICATION ORDERS ===");
            for (int i = 0; i < this.application_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + application_service_order.get(i).GetOrderDescription() + " - $" + application_service_order.get(i).GetOrderPrice());
                total_order_amount += application_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες API Integration
        if (!this.api_integration_serice_order.isEmpty()) {
            System.out.println("=== API INTEGRATION ORDERS ===");
            for (int i = 0; i < this.api_integration_serice_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + api_integration_serice_order.get(i).GetOrderDescription() + " - $" + api_integration_serice_order.get(i).GetOrderPrice());
                total_order_amount += api_integration_serice_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες Appointment Management
        if (!this.appointment_management_service_order.isEmpty()) {
            System.out.println("=== APPOINTMENT MANAGEMENT ORDERS ===");
            for (int i = 0; i < this.appointment_management_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + appointment_management_service_order.get(i).GetOrderDescription() + " - $" + appointment_management_service_order.get(i).GetOrderPrice());
                total_order_amount += appointment_management_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες Invoice Software
        if (!this.invoice_software_service_order.isEmpty()) {
            System.out.println("=== INVOICE SOFTWARE ORDERS ===");
            for (int i = 0; i < this.invoice_software_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + invoice_software_service_order.get(i).GetOrderDescription() + " - $" + invoice_software_service_order.get(i).GetOrderPrice());
                total_order_amount += invoice_software_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες HR Tools
        if (!this.hr_tools_service_order.isEmpty()) {
            System.out.println("=== HR TOOLS ORDERS ===");
            for (int i = 0; i < this.hr_tools_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + hr_tools_service_order.get(i).GetOrderDescription() + " - $" + hr_tools_service_order.get(i).GetOrderPrice());
                total_order_amount += hr_tools_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες E-Learning
        if (!this.elearning_service_order.isEmpty()) {
            System.out.println("=== E-LEARNING ORDERS ===");
            for (int i = 0; i < this.elearning_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + elearning_service_order.get(i).GetOrderDescription() + " - $" + elearning_service_order.get(i).GetOrderPrice());
                total_order_amount += elearning_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες AWS Cloud
        if (!this.aws_cloud_service_order.isEmpty()) {
            System.out.println("=== AWS CLOUD ORDERS ===");
            for (int i = 0; i < this.aws_cloud_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + aws_cloud_service_order.get(i).GetOrderDescription() + " - $" + aws_cloud_service_order.get(i).GetOrderPrice());
                total_order_amount += aws_cloud_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες CI/CD
        if (!this.ci_cd_service_order.isEmpty()) {
            System.out.println("=== CI/CD ORDERS ===");
            for (int i = 0; i < this.ci_cd_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + ci_cd_service_order.get(i).GetOrderDescription() + " - $" + ci_cd_service_order.get(i).GetOrderPrice());
                total_order_amount += ci_cd_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες Kubernetes/Docker
        if (!this.k8s_docker_service_order.isEmpty()) {
            System.out.println("=== KUBERNETES/DOCKER ORDERS ===");
            for (int i = 0; i < this.k8s_docker_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + k8s_docker_service_order.get(i).GetOrderDescription() + " - $" + k8s_docker_service_order.get(i).GetOrderPrice());
                total_order_amount += k8s_docker_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες Chatbot
        if (!this.chatbot_service_order.isEmpty()) {
            System.out.println("=== CHATBOT ORDERS ===");
            for (int i = 0; i < this.chatbot_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + chatbot_service_order.get(i).GetOrderDescription() + " - $" + chatbot_service_order.get(i).GetOrderPrice());
                total_order_amount += chatbot_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες AI Invoice Analysis
        if (!this.ai_invoice_service_order.isEmpty()) {
            System.out.println("=== AI INVOICE ANALYSIS ORDERS ===");
            for (int i = 0; i < this.ai_invoice_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + ai_invoice_service_order.get(i).GetOrderDescription() + " - $" + ai_invoice_service_order.get(i).GetOrderPrice());
                total_order_amount += ai_invoice_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες Sales Prediction
        if (!this.sales_prediction_service_order.isEmpty()) {
            System.out.println("=== SALES PREDICTION ORDERS ===");
            for (int i = 0; i < this.sales_prediction_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + sales_prediction_service_order.get(i).GetOrderDescription() + " - $" + sales_prediction_service_order.get(i).GetOrderPrice());
                total_order_amount += sales_prediction_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        // Παραγγελίες RPA
        if (!this.rpa_service_order.isEmpty()) {
            System.out.println("=== RPA ORDERS ===");
            for (int i = 0; i < this.rpa_service_order.size(); i++) {
                System.out.println("Order No." + (i + 1) + ": " + rpa_service_order.get(i).GetOrderDescription() + " - $" + rpa_service_order.get(i).GetOrderPrice());
                total_order_amount += rpa_service_order.get(i).GetOrderPrice();
            }
            System.out.println("----------------------------------------");
        }

        System.out.println("Total Amount: $" + total_order_amount);
        System.out.println("Thank you for your purchase!");
        System.out.println("========================================");
    }
}
