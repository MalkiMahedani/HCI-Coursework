import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the content
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // Create a panel for the form
        JPanel formPanel = new JPanel(new GridLayout(2, 1, 20, 20));

        // Create username components
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        // Create password components
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // Add username and password panels to the form panel
        formPanel.add(usernamePanel);
        formPanel.add(passwordPanel);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        // Add form panel and button panel to the content panel
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add content panel to the frame
        add(contentPanel);

        // Customize button colors
        loginButton.setBackground(new Color(0, 150, 136)); // Teal color
        loginButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(244, 67, 54)); // Red color
        signUpButton.setForeground(Color.WHITE);

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle login logic here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Dummy check, replace with actual login logic
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                    // Open FurnitureWorld window on successful login
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new FurnitureWorld();
                        }
                    });
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the sign-up form
                new SignUpForm();
            }
        });

        // Set frame visibility
        pack(); // pack the frame to ensure components are sized properly
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame();
            }
        });
    }
}
