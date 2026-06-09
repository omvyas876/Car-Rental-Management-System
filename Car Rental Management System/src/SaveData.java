import java.io.*;
import java.util.List;

public class SaveData {

    private static final String FILE_NAME = "../data/cars.dat";

    public static void saveCars(List<Car> cars) {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME));

            out.writeObject(cars);

            out.close();

            System.out.println("Cars Saved Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Car> loadCars() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME));

            List<Car> cars =
                    (List<Car>) in.readObject();

            in.close();

            return cars;

        } catch (Exception e) {

            return null;
        }
    }
}