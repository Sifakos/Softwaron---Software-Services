package PackageService;

public class AppointmentManagementOrder {
    
    private String order_description;
    private double order_price;

    // Δομητής
    public AppointmentManagementOrder(String order_description, double order_price) {
        this.order_description = order_description;
        this.order_price = order_price;
    }

    // Συναρτήσεις Getter
    public String GetOrderDescription() {

        return (this.order_description);
    }

    public double GetOrderPrice() {

        return (this.order_price);
    }
}
