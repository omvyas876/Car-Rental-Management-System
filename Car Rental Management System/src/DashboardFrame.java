import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Car Rental Management System");
        setSize(1300, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(33, 33, 33));

        JLabel systemTitle =
                new JLabel("Car Rental Management System");

        systemTitle.setForeground(Color.WHITE);

        systemTitle.setFont(
                new Font("Segoe UI",
                        Font.BOLD,
                        24));

        JLabel dateLabel = new JLabel();

        dateLabel.setForeground(Color.WHITE);

        dateLabel.setFont(
                new Font("Segoe UI",
                        Font.PLAIN,
                        16));

        Timer timer = new Timer(1000, e -> {

            dateLabel.setText(
                    LocalDate.now()
                            + "  |  "
                            + LocalTime.now().withNano(0));

        });

        timer.start();

        headerPanel.add(
                systemTitle,
                BorderLayout.WEST);

        headerPanel.add(
                dateLabel,
                BorderLayout.EAST);

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();

        sidebar.setLayout(
                new GridLayout(9, 1, 10, 10));

        sidebar.setPreferredSize(
                new Dimension(250, 0));

        sidebar.setBackground(
                new Color(13, 71, 161));

        JLabel logo =
                new JLabel(
                        "CAR RENTAL",
                        JLabel.CENTER);

        logo.setForeground(Color.WHITE);

        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22));

        JButton rentBtn = new JButton("Rent Car");
        JButton returnBtn = new JButton("Return Car");
        JButton viewBtn = new JButton("View Cars");
        JButton historyBtn = new JButton("Rental History");
        JButton addCarBtn = new JButton("Add Car");
        JButton searchBtn = new JButton("Search Car");
        JButton statsBtn = new JButton("Statistics");
        JButton deleteBtn = new JButton("Delete Car");

        JButton[] buttons = {
                rentBtn,
                returnBtn,
                viewBtn,
                historyBtn,
                addCarBtn,
                searchBtn,
                statsBtn,
                deleteBtn
        };

        for (JButton btn : buttons) {

            btn.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            16));

            btn.setBackground(
                    new Color(25, 118, 210));

            btn.setForeground(Color.WHITE);

            btn.setBorderPainted(false);

            btn.setFocusPainted(false);

            btn.setCursor(
                    new Cursor(
                            Cursor.HAND_CURSOR));
        }

        rentBtn.addActionListener(e -> new RentCarFrame());
        returnBtn.addActionListener(e -> new ReturnCarFrame());
        viewBtn.addActionListener(e -> new ViewCarsFrame());
        historyBtn.addActionListener(e -> new RentalHistoryFrame());
        addCarBtn.addActionListener(e -> new AddCarFrame());
        searchBtn.addActionListener(e -> new SearchCarFrame());
        statsBtn.addActionListener(e -> new StatisticsFrame());
        deleteBtn.addActionListener(e -> new DeleteCarFrame());

        sidebar.add(logo);
        sidebar.add(rentBtn);
        sidebar.add(returnBtn);
        sidebar.add(viewBtn);
        sidebar.add(historyBtn);
        sidebar.add(addCarBtn);
        sidebar.add(searchBtn);
        sidebar.add(statsBtn);
        sidebar.add(deleteBtn);

        // ================= CENTER PANEL =================

        JPanel centerPanel =
                new JPanel(
                        new GridLayout(
                                2, 2, 30, 30));

        centerPanel.setBackground(
                new Color(245, 245, 245));

        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 30, 30, 30));

        int totalCars =
                DataStore.rentalSystem.getCars().size();

        int availableCars = 0;

        for (Car car :
                DataStore.rentalSystem.getCars()) {

            if (car.isAvailable()) {
                availableCars++;
            }
        }

        int rentedCars =
                totalCars - availableCars;

        JLabel totalCard =
                new JLabel(
                        "Total Cars : " + totalCars,
                        JLabel.CENTER);

        JLabel availableCard =
                new JLabel(
                        "Available Cars : " + availableCars,
                        JLabel.CENTER);

        JLabel rentedCard =
                new JLabel(
                        "Rented Cars : " + rentedCars,
                        JLabel.CENTER);

        JLabel welcomeCard =
                new JLabel(
                        "Welcome Admin",
                        JLabel.CENTER);

        totalCard.setOpaque(true);
        totalCard.setBackground(
                new Color(25, 118, 210));

        availableCard.setOpaque(true);
        availableCard.setBackground(
                new Color(56, 142, 60));

        rentedCard.setOpaque(true);
        rentedCard.setBackground(
                new Color(245, 124, 0));

        welcomeCard.setOpaque(true);
        welcomeCard.setBackground(
                new Color(123, 31, 162));

        JLabel[] cards = {
                totalCard,
                availableCard,
                rentedCard,
                welcomeCard
        };

        for (JLabel card : cards) {

            card.setForeground(Color.WHITE);

            card.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            24));

            card.setBorder(
                    BorderFactory.createEmptyBorder(
                            30, 30, 30, 30));
        }

        centerPanel.add(totalCard);
        centerPanel.add(availableCard);
        centerPanel.add(rentedCard);
        centerPanel.add(welcomeCard);

        // ================= FOOTER =================

        JPanel footerPanel =
                new JPanel();

        footerPanel.setBackground(
                new Color(33, 33, 33));

        JLabel developerLabel =
                new JLabel(
                        "Developed by Om Vyas");

        developerLabel.setForeground(
                Color.WHITE);

        footerPanel.add(
                developerLabel);

        // ================= ADD COMPONENTS =================

        add(headerPanel, BorderLayout.NORTH);
        add(sidebar, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}