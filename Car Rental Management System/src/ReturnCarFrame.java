import java.awt.*;
import javax.swing.*;

public class ReturnCarFrame extends JFrame {

    public ReturnCarFrame() {

        setTitle("Return Car");
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        JTextField carIdField = new JTextField();

        JButton returnBtn =
                new JButton("Return Car");

        panel.add(new JLabel("Enter Car ID"));
        panel.add(carIdField);

        panel.add(new JLabel(""));
        panel.add(returnBtn);

        add(panel);

        returnBtn.addActionListener(e -> {

            String carId = carIdField.getText();

            Car carToReturn = null;

            for (Car car : DataStore.rentalSystem.getCars()) {

                if (car.getCarId().equalsIgnoreCase(carId)) {
                    carToReturn = car;
                    break;
                }
            }

            if (carToReturn == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Car ID not found!"
                );

                return;
            }

            if (carToReturn.isAvailable()) {

                JOptionPane.showMessageDialog(
                        this,
                        "This car is already available."
                );

                return;
            }

            DataStore.rentalSystem.returnCar(carToReturn);

            JOptionPane.showMessageDialog(
                    this,
                    "Car " + carId +
                    " returned successfully!"
            );
        });

        setVisible(true);
    }
}