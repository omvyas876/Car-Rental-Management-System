import java.awt.*;
import javax.swing.*;

public class DeleteCarFrame extends JFrame {

    public DeleteCarFrame() {

        setTitle("Delete Car");
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        JTextField carIdField = new JTextField();

        JButton deleteBtn =
                new JButton("Delete Car");

        panel.add(new JLabel("Enter Car ID"));
        panel.add(carIdField);

        panel.add(new JLabel(""));
        panel.add(deleteBtn);

        add(panel);

        deleteBtn.addActionListener(e -> {

            String carId =
                    carIdField.getText();

            Car carToDelete = null;

            for (Car car :
                    DataStore.rentalSystem.getCars()) {

                if (car.getCarId().equalsIgnoreCase(carId)) {

                    carToDelete = car;
                    break;
                }
            }

            if (carToDelete != null) {

                DataStore.rentalSystem
                        .deleteCar(carToDelete);

                JOptionPane.showMessageDialog(
                        this,
                        "Car Deleted Successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Car Not Found!"
                );
            }
        });

        setVisible(true);
    }
}