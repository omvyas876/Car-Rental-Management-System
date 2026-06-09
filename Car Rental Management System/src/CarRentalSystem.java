import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {

        List<Car> loadedCars =
                SaveData.loadCars();

        if (loadedCars != null) {

            cars = loadedCars;

        } else {

            cars = new ArrayList<>();
        }

        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {

        cars.add(car);

        SaveData.saveCars(cars);
    }

    public void addCustomer(Customer customer) {

        customers.add(customer);
    }

    public List<Car> getCars() {

        return cars;
    }

    public List<Rental> getRentals() {

        return rentals;
    }

    public void rentCar(Car car,
                        Customer customer,
                        int days) {

        if (car.isAvailable()) {

            car.rent();

            rentals.add(
                    new Rental(
                            car,
                            customer,
                            days));

            SaveData.saveCars(cars);

        } else {

            System.out.println(
                    "Car is not available.");
        }
    }

    public void returnCar(Car car) {

        car.returnCar();

        Rental rentalToRemove = null;

        for (Rental rental : rentals) {

            if (rental.getCar() == car) {

                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {

            rentals.remove(
                    rentalToRemove);
        }

        SaveData.saveCars(cars);
    }

    public void deleteCar(Car car) {

        cars.remove(car);

        SaveData.saveCars(cars);
    }
}