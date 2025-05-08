import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class FurnitureWorld extends JFrame {
    public FurnitureWorld() {
        setTitle("Welcome to Furniture World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 600));

        // Create and add top panel for "Welcome to Furniture World" text
        JPanel topPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to Furniture World");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(welcomeLabel);
        add(topPanel, BorderLayout.NORTH);

        // Create and add right panel for buttons
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(230, 230, 230));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add padding
        rightPanel.setPreferredSize(new Dimension(200, getHeight())); // Fixed width

        // Add vertical glue for spacing between buttons and description panel
        rightPanel.add(Box.createVerticalGlue());

        // Create and add main buttons (New Customer Registration, Create New Model, Previous Models) to the right panel

       // addButton("Create New Model", rightPanel, CreateNewModel.class);
       // addButton("Previous Models", rightPanel, PreviousModels.class);

        // Add vertical strut for additional spacing between buttons
        rightPanel.add(Box.createVerticalStrut(20));

        // Add buttons for other classes
        addButton("Login", rightPanel, LoginFrame.class);
        addButton("New Customer Registration", rightPanel, CustomerRegistrationForm.class);
        addButton("New Chair", rightPanel, ChairRenderer.class);
        addButton("New Table", rightPanel, BoxTable.class);
        addButton("Round Table", rightPanel, RoundTable.class);
        addButton("Stool ", rightPanel, StoolRenderer.class);
        addButton("Dinner Table", rightPanel, TableRenderer.class);
        addButton("Designer Sign Up Form", rightPanel, SignUpForm.class);
        //addButton("Sign Up Success Message", rightPanel, SignUpSuccessMessage.class);

        // Add vertical strut for additional spacing between buttons
        rightPanel.add(Box.createVerticalStrut(20));

        // Create and add additional buttons (About Us, Contact Details, User Manual) to the right panel
       // addButton("About Us", rightPanel, AboutUs.class);
        //addButton("Contact Details", rightPanel, ContactDetails.class);
        //addButton("User Manual", rightPanel, UserManual.class);

        add(rightPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Helper method to create customized buttons
    private void addButton(String buttonText, JPanel panel, Class<?> clazz) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(200, 50)); // Set button size
        button.setMaximumSize(new Dimension(200, 50)); // Set maximum size
        button.setBackground(new Color(52, 152, 219)); // Custom color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new RoundedBorder(10)); // Custom rounded border
        button.setFocusPainted(false); // Remove focus border
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button text
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFrame frame = new JFrame(clazz.getSimpleName());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(800, 600);
                    frame.setLocationRelativeTo(null);

                    JComponent component = (JComponent) clazz.getDeclaredConstructor().newInstance();
                    frame.getContentPane().add(component);

                    frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(button);

        // Add vertical strut for spacing between buttons
        panel.add(Box.createVerticalStrut(10));
    }

    // Custom border for rounded edges
    static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.BLACK); // Set border color
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FurnitureWorld();
            }
        });
    }
}
