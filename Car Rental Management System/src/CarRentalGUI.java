import java.awt.*;
import javax.swing.*;

public class CarRentalGUI extends JFrame {

    public CarRentalGUI() {

        setTitle("Car Rental System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("CAR RENTAL SYSTEM", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JButton rentButton = new JButton("Rent Car");
        JButton returnButton = new JButton("Return Car");
        JButton exitButton = new JButton("Exit");

        // Rent Car Button
        rentButton.addActionListener(e -> {

            String name = JOptionPane.showInputDialog(
                    this,
                    "Enter Customer Name:");

            if (name == null || name.isEmpty())
                return;

            String[] cars = {
                    "C001 - Toyota Camry",
                    "C002 - Honda Accord",
                    "C003 - Mahindra Thar"
            };

            String selectedCar = (String) JOptionPane.showInputDialog(
                    this,
                    "Select a Car",
                    "Rent Car",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    cars,
                    cars[0]);

            if (selectedCar == null)
                return;

            String days = JOptionPane.showInputDialog(
                    this,
                    "Enter Rental Days:");

            if (days == null || days.isEmpty())
                return;

            JOptionPane.showMessageDialog(
                    this,
                    "Customer: " + name +
                    "\nCar: " + selectedCar +
                    "\nRental Days: " + days +
                    "\n\nCar Rented Successfully!");
        });

        // Return Car Button
        returnButton.addActionListener(e -> {

            String carId = JOptionPane.showInputDialog(
                    this,
                    "Enter Car ID to Return:");

            if (carId == null || carId.isEmpty())
                return;

            JOptionPane.showMessageDialog(
                    this,
                    "Car " + carId + " Returned Successfully!");
        });

        // Exit Button
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rentButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(exitButton);

        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarRentalGUI());
    }
}