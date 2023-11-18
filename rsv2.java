class Product {
    private String productName;
    private double unitPrice;
    private double gstPercentage;
    private int quantity;

    // Constructor
    public Product(String productName, double unitPrice, double gstPercentage, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.gstPercentage = gstPercentage;
        this.quantity = quantity;
    }

    // Method to calculate total cost for a product
    public double calculateTotalCost() {
        double costWithoutGST = unitPrice * quantity;
        double totalGST = (costWithoutGST * gstPercentage) / 100;
        return costWithoutGST + totalGST;
    }

    // Getters
    public double getGSTAmount() {
        return (unitPrice * quantity * gstPercentage) / 100;
    }

    public String getProductName() {
        return productName;
    }
}

public class Basket {
    public static void main(String[] args) {
        
        Product leatherWallet = new Product("Leather wallet", 1100, 18, 1);
        Product umbrella = new Product("Umbrella", 900, 12, 4);
        Product cigarette = new Product("Cigarette", 200, 28, 3);
        Product honey = new Product("Honey", 100, 0, 2);

        
        Product[] products = {leatherWallet, umbrella, cigarette, honey};

        
        Product maxGSTProduct = getMaxGSTProduct(products);
        System.out.println("Product with maximum GST amount: " + maxGSTProduct.getProductNumber
        
        double totalAmountToPay = calculateTotalAmount(products);
        System.out.println("Total amount to be paid: Rs. " + totalAmountToPay);
    }

    
    private static Product getMaxGSTProduct(Product[] products) {
        Product maxGSTProduct = null;
        double maxGSTAmount = Double.MIN_VALUE;

        for (Product product : products) {
            double currentGST = product.getGSTAmount();
            if (currentGST > maxGSTAmount) {
                maxGSTAmount = currentGST;
                maxGSTProduct = product;
            }
        }
        return maxGSTProduct;
    }

    
    private static double calculateTotalAmount(Product[] products) {
        double totalAmount = 0;

        for (Product product : products) {
            totalAmount += product.calculateTotalCost();
        }
        return totalAmount;
    }
}