package lambdaPractical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 48500),
                new Car("Toyota", "Corolla", "Black", 16200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Mitsubishi", "Lancer", "White", 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );

      // using Functional interface
        Function<Car, String> priceAndCOlor = (c) -> "price = " + c.getPrice() + ", color = "  + c.getColor();
        String stringCar = priceAndCOlor.apply(cars.get(0));
        System.out.println(stringCar);

        /**
         *   using anonymous class
         *         printCars(cars, new CarCondition() {
         *             @Override
         *             public boolean test(Car c) {
         *                 return c.getPrice() >= 18000 && c.getPrice() <= 22000;
         *             }
         *         });
         *
         *         printCars(cars, new CarCondition() {
         *             @Override
         *             public boolean test(Car c) {
         *                 return c.getColor().equals("Blue");
         *             }
         *         });
         */

    //using lambda
    printCars (cars, (c) -> c.getPrice() >= 22000 && c.getPrice() <= 49000);
    printCars (cars, (c) -> c.getColor().equals("White"));

    }

    //use lambda
    public static void printCars(List<Car> cars, Predicate<Car> predicate) {
        for(Car c: cars) {
            if (predicate.test(c)) {
                c.printCar();
            }
        }
    }
    @FunctionalInterface
    interface Condition<T> {
        public boolean test(T t);
    }

//Old implementation
    public static void printCarsPriceRAnge(List<Car> cars, int low, int high){
        for(Car c: cars){
            if(low <= c.getPrice() && c.getPrice() <= high){
                c.printCar();
            }
        }
    }

    public static void printCarByColor(List<Car> cars, String color){
        for (Car c: cars) {
            if(c.getColor().equals(color)){
                c.printCar();
            }
        }

    }
}
