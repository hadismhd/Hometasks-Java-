import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    private static void saveCarsToFile(Car[] cars, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Car car : cars) {
                writer.write(car.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Car ID:"  + id + ", Make: " + make + ", Model: " + model + ", Year of Manufacture: " + yearOfManufacture + ", Color: " + color + ", Price:"  + price + ", Registration Number: " + registrationNumber;
    }

    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car(1,"BMW","ix", 2020, "Black", 69905.0, "kJK125");
        cars[1] = new Car(2, "Peugeot", "207", 2006, "Blue", 5000.0, "XAQ963");
        cars[2] = new Car(3, "Toyota", "Camry", 2018, "Red", 26400.0, "TRW476");
        cars[3] = new Car(4, "BMW", "i7", 2023, "Silver", 70000.0, "GPI700");
        cars[4] = new Car(1,"JEEP","Cherokee.", 2015, "Black", 40000.0, "UFT087");

        int year = 2020;
        double specifiedPrice = 67000.0;
        Car[] carsByYearAndPrice = Arrays.stream(cars)
                .filter(car -> car.getYearOfManufacture() == year && car.getPrice() > specifiedPrice)
                .toArray(Car[]::new);
        saveCarsToFile(carsByYearAndPrice, "cars_year_and_price.txt");

        String model = "207";
        int yearsInUse = 13;
        Car[] carsByModelAndYears = Arrays.stream(cars)
                .filter(car -> car.getModel().equals(model) && (2021 - car.getYearOfManufacture()) > yearsInUse)
                .toArray(Car[]::new);
        saveCarsToFile(carsByModelAndYears, "cars_model_and_year.txt");

        String brand = "Toyota";
        Car[] carsByBrand = Arrays.stream(cars)
                .filter(car -> car.getMake().equals(brand))
                .toArray(Car[]::new);

        saveCarsToFile(carsByBrand, "cars_brand.txt");
    }
}
