import java.awt.*;
import javax.swing.*;

public class SearchCarFrame extends JFrame {

    public SearchCarFrame() {

        setTitle("Search Car");
        setSize(400,250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,2,10,10));

        JTextField searchField = new JTextField();

        JButton searchBtn =
                new JButton("Search");

        JTextArea resultArea =
                new JTextArea();

        panel.add(new JLabel("Enter Car ID"));
        panel.add(searchField);

        panel.add(new JLabel(""));
        panel.add(searchBtn);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        searchBtn.addActionListener(e -> {

            String carId =
                    searchField.getText();

            boolean found = false;

            for (Car car :
                    DataStore.rentalSystem.getCars()) {

                if (car.getCarId().equalsIgnoreCase(carId)) {

                    resultArea.setText(
                            "Car ID: " + car.getCarId() +
                            "\nBrand: " + car.getBrand() +
                            "\nModel: " + car.getModel() +
                            "\nPrice: " + car.getBasePricePerDay() +
                            "\nAvailable: " +
                            (car.isAvailable() ? "Yes" : "No")
                    );

                    found = true;
                    break;
                }
            }

            if (!found) {

                resultArea.setText(
                        "Car not found!"
                );
            }
        });

        setVisible(true);
    }
}