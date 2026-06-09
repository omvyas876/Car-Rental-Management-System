import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    JTextField username;
    JPasswordField password;

    public LoginFrame() {

        setTitle("Car Rental Login");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,10,10));

        panel.add(new JLabel("Username"));
        username = new JTextField();
        panel.add(username);

        panel.add(new JLabel("Password"));
        password = new JPasswordField();
        panel.add(password);

        JButton loginBtn = new JButton("Login");
        panel.add(loginBtn);

        add(panel);

        loginBtn.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String user = username.getText();
        String pass = new String(password.getPassword());

        if(user.equals("admin") && pass.equals("admin123")) {

            JOptionPane.showMessageDialog(this,"Login Successful");

            dispose();

            new DashboardFrame();

        } else {

            JOptionPane.showMessageDialog(this,"Invalid Credentials");
        }
    }
}