import javax.swing.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame() {

        setTitle("Dashboard Statistics");
        setSize(400,250);
        setLocationRelativeTo(null);

        int totalCars =
                DataStore.rentalSystem.getCars().size();

        int availableCars = 0;

        for (Car car : DataStore.rentalSystem.getCars()) {

            if (car.isAvailable()) {
                availableCars++;
            }
        }

        int rentedCars =
                totalCars - availableCars;

        JTextArea area = new JTextArea();

        area.setEditable(false);

        area.setText(
                "Total Cars: " + totalCars +
                "\nAvailable Cars: " + availableCars +
                "\nRented Cars: " + rentedCars
        );

        add(area);

        setVisible(true);
    }
}