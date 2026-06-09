import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RentalHistoryFrame extends JFrame {

    public RentalHistoryFrame() {

        setTitle("Rental History");
        setSize(700, 400);
        setLocationRelativeTo(null);

        String[] columns = {
                "Customer",
                "Car",
                "Days"
        };

        Object[][] data =
                new Object[
                        DataStore.rentalSystem
                                .getRentals().size()
                        ][3];

        int i = 0;

        for (Rental rental :
                DataStore.rentalSystem.getRentals()) {

            data[i][0] =
                    rental.getCustomer().getName();

            data[i][1] =
                    rental.getCar().getBrand()
                    + " "
                    + rental.getCar().getModel();

            data[i][2] =
                    rental.getDays();

            i++;
        }

        JTable table =
                new JTable(
                        new DefaultTableModel(
                                data,
                                columns
                        ));

        JScrollPane scrollPane =
                new JScrollPane(table);

        JButton exportBtn =
                new JButton("Export History");

        exportBtn.addActionListener(e -> {

            ExportHistoryFrame.exportHistory();

        });

        add(scrollPane, BorderLayout.CENTER);
        add(exportBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}