import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileCreatorGUI extends JFrame implements ActionListener {

    private JLabel welcomeLabel;
    private JLabel languageLabel;
    private JTextField fileNameTextField;
    private JButton createButton;
    private JRadioButton pythonRadioButton, javaRadioButton, cppRadioButton, cRadioButton;
    private ButtonGroup languageGroup;

    public FileCreatorGUI() {
        // Set up the JFrame
        setTitle("DIU Programmer");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Load the icon from resources
        ImageIcon icon = new ImageIcon(FileCreatorGUI.class.getResource("/resources/logo.png"));
        setIconImage(icon.getImage());  // Set the icon for JFrame

        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon(FileCreatorGUI.class.getResource("/resources/backGround.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage();

        // Create a JPanel with a background image
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Initialize components
        welcomeLabel = new JLabel("Welcome DIU Programmers.", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(41, 128, 185));
        welcomeLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setOpaque(false);  // Make panel transparent
        welcomePanel.add(welcomeLabel);

        languageLabel = new JLabel("Select your programming language:");
        languageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        languageLabel.setForeground(new Color(44, 62, 80));

        JPanel languagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        languagePanel.setOpaque(false);  // Make panel transparent
        languagePanel.add(languageLabel);

        // Radio buttons for language selection
        javaRadioButton = new JRadioButton("Java");
        pythonRadioButton = new JRadioButton("Python");
        cppRadioButton = new JRadioButton("C++");
        cRadioButton = new JRadioButton("C");

        // Customize radio buttons
        Font radioButtonFont = new Font("Arial", Font.PLAIN, 14);
        javaRadioButton.setFont(radioButtonFont);
        pythonRadioButton.setFont(radioButtonFont);
        cppRadioButton.setFont(radioButtonFont);
        cRadioButton.setFont(radioButtonFont);

        // Button group for radio buttons
        languageGroup = new ButtonGroup();
        languageGroup.add(javaRadioButton);
        languageGroup.add(pythonRadioButton);
        languageGroup.add(cppRadioButton);
        languageGroup.add(cRadioButton);

        // Default selection for radio buttons
        javaRadioButton.setSelected(true);

        JPanel radioPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        radioPanel.setOpaque(false);  // Make panel transparent
        radioPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        radioPanel.add(javaRadioButton);
        radioPanel.add(pythonRadioButton);
        radioPanel.add(cppRadioButton);
        radioPanel.add(cRadioButton);

        fileNameTextField = new JTextField();
        fileNameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        fileNameTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        createButton = new JButton("Create File");
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBackground(new Color(52, 152, 219));
        createButton.setForeground(Color.WHITE);
        createButton.setFocusPainted(false);
        createButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        createButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 0, 10));
        inputPanel.setOpaque(false);  // Make panel transparent
        inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        inputPanel.add(languagePanel);
        inputPanel.add(radioPanel);
        inputPanel.add(fileNameTextField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);  // Make panel transparent
        buttonPanel.add(createButton);

        mainPanel.add(welcomePanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Display the JFrame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String fileName = fileNameTextField.getText().trim();
            if (fileName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a file name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String selectedLanguage = "";
            if (javaRadioButton.isSelected()) {
                selectedLanguage = "Java";
            } else if (pythonRadioButton.isSelected()) {
                selectedLanguage = "Python";
            } else if (cppRadioButton.isSelected()) {
                selectedLanguage = "C++";
            } else if (cRadioButton.isSelected()) {
                selectedLanguage = "C";
            }

            switch (selectedLanguage) {
                case "Java":
                    JavaFileCreator javaCreator = new JavaFileCreator();
                    javaCreator.createJavaFile(fileName);
                    break;
                case "Python":
                    PythonFileCreator pythonCreator = new PythonFileCreator();
                    pythonCreator.createPythonFile(fileName);
                    break;
                case "C++":
                    CPPFileCreator cppCreator = new CPPFileCreator();
                    cppCreator.createCPPFile(fileName);
                    break;
                case "C":
                    CFileCreator cCreator = new CFileCreator();
                    cCreator.createCFile(fileName);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid programming language selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Use FlatLaf to set a modern look and feel
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        // Use SwingUtilities.invokeLater to run the GUI in the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileCreatorGUI();
            }
        });
    }
}
