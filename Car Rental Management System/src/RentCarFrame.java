import java.awt.*;
import javax.swing.*;

public class RentCarFrame extends JFrame {

    public RentCarFrame() {

        setTitle("Rent Car");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField nameField = new JTextField();

        String[] cars =
                new String[DataStore.rentalSystem.getCars().size()];

        int i = 0;

        for (Car car : DataStore.rentalSystem.getCars()) {

            cars[i] =
                    car.getCarId() + " - " +
                    car.getBrand() + " " +
                    car.getModel();

            i++;
        }

        JComboBox<String> carBox =
                new JComboBox<>(cars);

        JTextField daysField =
                new JTextField();

        JButton rentButton =
                new JButton("Confirm Rental");

        panel.add(new JLabel("Customer Name"));
        panel.add(nameField);

        panel.add(new JLabel("Select Car"));
        panel.add(carBox);

        panel.add(new JLabel("Rental Days"));
        panel.add(daysField);

        panel.add(new JLabel(""));
        panel.add(rentButton);

        add(panel);

        rentButton.addActionListener(e -> {

            try {

                String customerName =
                        nameField.getText();

                int rentalDays =
                        Integer.parseInt(daysField.getText());

                String selected =
                        carBox.getSelectedItem().toString();

                String carId =
                        selected.split(" - ")[0];

                Car selectedCar = null;

                for (Car car : DataStore.rentalSystem.getCars()) {

                    if (car.getCarId().equals(carId)) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar == null) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Car not found!"
                    );

                    return;
                }

                Customer customer =
                        new Customer(
                                "CUS" + System.currentTimeMillis(),
                                customerName
                        );

                DataStore.rentalSystem.addCustomer(customer);

                DataStore.rentalSystem.rentCar(
                        selectedCar,
                        customer,
                        rentalDays
                );

                double totalPrice =
                        selectedCar.calculatePrice(rentalDays);

                JOptionPane.showMessageDialog(
                        this,
                        "Customer: " + customerName +
                        "\nCar: " + selectedCar.getBrand() +
                        " " + selectedCar.getModel() +
                        "\nDays: " + rentalDays +
                        "\nTotal Price: $" + totalPrice +
                        "\n\nCar Booked Successfully!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid details."
                );
            }
        });

        setVisible(true);
    }
}