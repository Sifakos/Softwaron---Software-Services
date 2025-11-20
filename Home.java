package PackageService;

import java.util.Scanner;

public class Home {
    
    public static void main(String[] args) throws InvalidSoftwareSection, InvalidCustomSoftwareDevelopementService, InvalidSaasDevelopementService, InvalidDevOpsCloudDevelopementService, InvalidAIAutomationService, InvalidAddCartAnswer, InvalidShoppingCartSection, InvalidSoftwareOrderNumber, InvalidBuyCartAnswer {

        Scanner scanner = new Scanner(System.in);

        Client client_data = new Client(); // Στοιχεία πελάτη
        Cart shopping_cart = new Cart(); // Καλάθι παραγγελιών

        // Custom Software Developement Υπηρεσίες
        Website website_service = new Website(); 
        Application application_service = new Application(); 
        APIIntegration api_integrations_service = new APIIntegration(); 
        
        // Υπηρεσίες SaaS
        AppointmentManagement appointment_management_service = new AppointmentManagement(); 
        InvoiceSoftware invoice_software_service = new InvoiceSoftware(); 
        HRTools hr_tools_service = new HRTools(); 
        ELearning elearning_service = new ELearning(); 

        // Υπηρεσίες DevOps & Cloud
        AWSCloud aws_cloud_service = new AWSCloud(); 
        CICD ci_cd_service = new CICD(); 
        KubernetesDocker k8s_docker_service = new KubernetesDocker(); 

        // Υπηρεσίες AI & Automation
        Chatbot chatbot_service = new Chatbot(); // Αντικείμενο της κλάσης Chatbot
        AIInvoiceAnalysis ai_invoice_service = new AIInvoiceAnalysis(); 
        SalesPrediction sales_prediction_service = new SalesPrediction(); 
        RPA rpa_service = new RPA(); 

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
                                website_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας ιστοσελίδας
                            } else if (custom_software_developement_service == 2) {
                                application_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας εφαρμογής
                            } else if (custom_software_developement_service == 3) {
                                api_integrations_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας API ενσωμάτωσης
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
                    // Επιλογή υπηρεσίας προιόντος - λογισμικού
                    while (saas_developement_service != 4) {
                        if (saas_developement_service < 1 || saas_developement_service > 4) {
                            throw new InvalidSaasDevelopementService("We're sorry but you have input an invalid Saas developement service");
                        } else {
                            if (saas_developement_service == 1) {
                                appointment_management_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας διαχείρησης ραντεβού
                            } else if (saas_developement_service == 2) {
                                invoice_software_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας λογισμικού έκδοσης τιμολογίου
                            } else if (saas_developement_service == 3) {
                                hr_tools_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας ανθρώπινων πόρων
                            } else if (saas_developement_service == 4) {
                                elearning_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας e-learning
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
                                aws_cloud_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας AWS
                            } else if (devops_cloud_developement_service == 2) {
                                ci_cd_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας CI - CD
                            } else if (devops_cloud_developement_service == 3) {
                                k8s_docker_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας Kubernetes & Docker
                            } 
                        }
                        System.out.println("AWS/Azure/Google Cloud (1) | CI/CD Pipelines (2) | Kubernetes & Docker (3) | Exit (4)");
                        System.out.print("Select DevOps & Cloud developement service (1-3): ");
                        devops_cloud_developement_service = scanner.nextInt();
                    }
                } else if (software_section == 4) {
                    System.out.println("Chatbots (1) | AI Invoice Analysis (2) | Sales Predictions (3) | RPA (4) | Exit (5)");
                    System.out.print("Select AI & Automation service (1-3): ");
                    int ai_automation_service = scanner.nextInt();
                    // Επιλογή υπηρεσίας DevOps & Cloud
                    while (ai_automation_service != 4) {
                        if (ai_automation_service < 1 || ai_automation_service > 4) {
                            throw new InvalidAIAutomationService("We're sorry but you have input an invalid AI & Automation service");
                        } else {
                            if (ai_automation_service == 1) {
                                chatbot_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας chatbot
                            } else if (ai_automation_service == 2) {
                                ai_invoice_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας δημιουργίας απόδειξης
                            } else if (ai_automation_service == 3) {
                                sales_prediction_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας πρόβληψης πωλήσεων
                            } else if (ai_automation_service == 4) {
                                rpa_service.SoftwareOrderProcess(scanner, shopping_cart); // Παραγγελία υπηρεσίας RPA
                            }
                        }
                        System.out.println("Chatbots (1) | AI Invoice Analysis (2) | Sales Predictions (3) | RPA (4) | Exit (5)");
                        System.out.print("Select AI & Automation service (1-3): ");
                        ai_automation_service = scanner.nextInt();
                    }
                } else if (software_section == 5) {
                    System.out.println("View Cart (1) | Buy Cart (2) | Delete Software Service (3) | Exit (4)");
                    System.out.print("Select cart section (1-3): ");
                    int shopping_cart_section = scanner.nextInt();
                    // Επιλογή κατηγορίας καλαθιού
                    while (shopping_cart_section != 4) {
                        if (shopping_cart_section < 1 || shopping_cart_section > 4) {
                            throw new InvalidShoppingCartSection("We're sorry but you have input an invalid shopping cart section");
                        } else {
                            if (shopping_cart_section == 1) {
                                shopping_cart.ViewCart(); // Προβολή καλαθιού
                            } else if (shopping_cart_section == 2) {
                                client_data.PurchaseDetails(scanner); // Στοιχεία πληρωμής
                                shopping_cart.BuyCart(scanner, client_data); // Αγορά καλαθιού
                            } else if (shopping_cart_section == 3) {
                                shopping_cart.DeleteSoftwareService(scanner); // Διαγραφή υπηρεσίας από το καλάθι
                            } 
                        }
                        System.out.println("View Cart (1) | Buy Cart (2) | Delete Software Service (3) | Exit (4)");
                        System.out.print("Select cart section (1-3): ");
                        shopping_cart_section = scanner.nextInt();
                    }
                }
            }
            System.out.println("Custom Software Developement (1) | Saas Products (2) | DevOps & Cloud Services (3) | AI & Automation (4) | Shopping Cart (5) | Exit (6)");
            System.out.print("Select software section (1-5): ");
            software_section = scanner.nextInt();
        }
    }
}