class Customer {
    private int customerID;
    private String name;
    private String address;
    private Meter meter;

    public Customer(int customerID, String name, String address) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.meter = new Meter();
    }

    public void submitReading(int currentReading) {
        meter.submitReading(currentReading);
    }

    public double calculateBill(double ratePerUnit) {
        return meter.calculateUsage() * ratePerUnit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + "\nName: " + name + "\nAddress: " + address;
    }
}

class Meter {
    private int currentReading;
    private int previousReading;

    public void submitReading(int currentReading) {
        previousReading = this.currentReading;
        this.currentReading = currentReading;
    }

    public int calculateUsage() {
        return currentReading - previousReading;
    }
}

class ElectricityBill {
    private Customer customer;
    private double ratePerUnit;

    public ElectricityBill(Customer customer, double ratePerUnit) {
        this.customer = customer;
        this.ratePerUnit = ratePerUnit;
    }

    public double calculateTotalCost() {
        return customer.calculateBill(ratePerUnit);
    }
}

class Payment {
    private Customer customer;
    private double amount;

    public Payment(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public void processPayment() {
        // Add payment processing logic here, e.g., update balance, record payment, etc.
    }
}

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "John Doe", "123 Main St");
        Customer customer2 = new Customer(2, "Alice Smith", "456 Elm St");

        customer1.submitReading(1000);
        customer2.submitReading(800);

        double ratePerUnit = 0.12;

        ElectricityBill bill1 = new ElectricityBill(customer1, ratePerUnit);
        ElectricityBill bill2 = new ElectricityBill(customer2, ratePerUnit);

        System.out.println(customer1);
        System.out.println("Total Cost for " + customer1.getName() + ": $" + bill1.calculateTotalCost());

        System.out.println(customer2);
        System.out.println("Total Cost for " + customer2.getName() + ": $" + bill2.calculateTotalCost());

        Payment payment1 = new Payment(customer1, 120.0);
        payment1.processPayment();

        Payment payment2 = new Payment(customer2, 90.0);
        payment2.processPayment();
    }
}