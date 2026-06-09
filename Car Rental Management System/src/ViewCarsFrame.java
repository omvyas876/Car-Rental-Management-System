import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewCarsFrame extends JFrame {

    public ViewCarsFrame() {

        setTitle("Available Cars");
        setSize(700, 400);
        setLocationRelativeTo(null);

        String[] columns = {
                "Car ID",
                "Brand",
                "Model",
                "Price Per Day",
                "Available"
        };

        Object[][] data =
                new Object[DataStore.rentalSystem.getCars().size()][5];

        int i = 0;

        for (Car car : DataStore.rentalSystem.getCars()) {

            data[i][0] = car.getCarId();
            data[i][1] = car.getBrand();
            data[i][2] = car.getModel();
            data[i][3] = car.getBasePricePerDay();
            data[i][4] = car.isAvailable() ? "Yes" : "No";

            i++;
        }

        JTable table = new JTable(
                new DefaultTableModel(data, columns));

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane);

        setVisible(true);
    }
}