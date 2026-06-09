public class Main {

    public static void main(String[] args) {

        if (DataStore.rentalSystem.getCars().isEmpty()) {

            DataStore.rentalSystem.addCar(
                    new Car(
                            "C001",
                            "Toyota",
                            "Camry",
                            60));

            DataStore.rentalSystem.addCar(
                    new Car(
                            "C002",
                            "Honda",
                            "Accord",
                            70));

            DataStore.rentalSystem.addCar(
                    new Car(
                            "C003",
                            "Mahindra",
                            "Thar",
                            150));
        }

        new LoginFrame();
    }
}