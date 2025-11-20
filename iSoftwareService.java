package PackageService;

import java.util.Scanner;

public interface iSoftwareService {
    
    public void SoftwareOrderProcess(Scanner scanner, Cart shopping_cart) throws InvalidAddCartAnswer; // Αγορά υπηρεσίας λογισμικού

    public double GenerateSoftwareServiceCost(String description); // Υπολογισμός κόστους υπηρεσίας λογισμικού
}
