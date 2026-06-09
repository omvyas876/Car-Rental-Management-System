public class DataStore {

    public static CarRentalSystem rentalSystem =
            new CarRentalSystem();

    static {

        rentalSystem.addCar(
                new Car("C001","Toyota","Camry",60));

        rentalSystem.addCar(
                new Car("C002","Honda","Accord",70));

        rentalSystem.addCar(
                new Car("C003","Mahindra","Thar",150));
    }
}