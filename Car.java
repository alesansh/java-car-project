public class Car {
    private String model;
    private int year;
    private double price;

    // Constructor calling setter methods for validation
    public Car(String model, int year, double price) {
        setModel(model);
        setYear(year);
        setPrice(price);
    }

    // Getter and setter for model with validation
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty or null");
        }
        this.model = model;
    }

    // Getter and setter for year with validation
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        if (year < 1886 || year > currentYear) { // First car invented in 1886
            throw new IllegalArgumentException("Year must be between 1886 and " + currentYear);
        }
        this.year = year;
    }

    // Getter and setter for price with validation
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        try {
            Car myCar = new Car("Toyota", 2020, 25000);
            System.out.println("Car created: " + myCar.getModel() + ", " + myCar.getYear() + ", $" + myCar.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
