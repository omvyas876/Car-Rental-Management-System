import java.io.FileWriter;
import javax.swing.*;

public class ExportHistoryFrame {

    public static void exportHistory() {

        try {

            FileWriter writer =
                    new FileWriter("../data/RentalHistory.txt");

            writer.write(
                    "===== RENTAL HISTORY =====\n\n");

            for (Rental rental :
                    DataStore.rentalSystem.getRentals()) {

                writer.write(
                        "Customer : "
                        + rental.getCustomer().getName()
                        + "\n");

                writer.write(
                        "Car : "
                        + rental.getCar().getBrand()
                        + " "
                        + rental.getCar().getModel()
                        + "\n");

                writer.write(
                        "Days : "
                        + rental.getDays()
                        + "\n");

                writer.write(
                        "------------------------\n");
            }

            writer.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Rental History Exported Successfully!\nSaved in data/RentalHistory.txt"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );

            e.printStackTrace();
        }
    }
}