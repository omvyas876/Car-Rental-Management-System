import java.awt.*;
import javax.swing.*;

public class AddCarFrame extends JFrame {

    public AddCarFrame() {

        setTitle("Add New Car");
        setSize(400,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));

        JTextField idField = new JTextField();
        JTextField brandField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField priceField = new JTextField();

        JButton addBtn = new JButton("Add Car");

        panel.add(new JLabel("Car ID"));
        panel.add(idField);

        panel.add(new JLabel("Brand"));
        panel.add(brandField);

        panel.add(new JLabel("Model"));
        panel.add(modelField);

        panel.add(new JLabel("Price Per Day"));
        panel.add(priceField);

        panel.add(new JLabel(""));
        panel.add(addBtn);

        add(panel);

        addBtn.addActionListener(e -> {

            try {

                String id = idField.getText();
                String brand = brandField.getText();
                String model = modelField.getText();

                double price =
                        Double.parseDouble(priceField.getText());

                Car newCar =
                        new Car(id, brand, model, price);

                DataStore.rentalSystem.addCar(newCar);

                JOptionPane.showMessageDialog(
                        this,
                        "Car Added Successfully!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Input!"
                );
            }
        });

        setVisible(true);
    }
}