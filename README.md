The DIU Programmer - File Creation GUI is a desktop application developed using Java Swing. The primary purpose of this application is to facilitate programmers in creating template files for different programming languages quickly and efficiently.

Features:

User-Friendly Interface:

A welcoming interface with a modern look and feel.
Custom icons and background images to enhance the visual appeal.
Language Selection:

Provides options to create files in four popular programming languages: Java, Python, C++, and C.
Radio buttons to select the desired programming language.
File Creation:

Input field to enter the name of the file to be created.
A "Create File" button to generate the file in the selected programming language.
Error handling to ensure a valid file name is entered before file creation.
Backend Logic:

Implements action listeners to handle user interactions.
Uses specific file creator classes (e.g., JavaFileCreator, PythonFileCreator, etc.) to generate template files for the selected programming language.
Modern Look and Feel:

Integrates FlatLaf for a modern and clean user interface appearance.
Components:

Main JFrame (FileCreatorGUI): The primary window of the application, which includes all UI elements.
Labels and Panels: For displaying text and organizing the layout.
Text Field (JTextField): For user input of the file name.
Buttons (JButton): For triggering file creation.
Radio Buttons (JRadioButton): For language selection, grouped using ButtonGroup.
Usage:

Users launch the application and are greeted with a welcome message.
They select their preferred programming language and enter the desired file name.
Upon clicking the "Create File" button, the application generates the appropriate template file.
Technical Requirements:

Java Development Kit (JDK)
Java Swing library
FlatLaf library for modern UI
Execution:

The main method initializes the FlatLaf look and feel and runs the GUI on the Event Dispatch Thread (EDT) for thread safety.
Future Enhancements:

Adding more programming languages.
Customizable templates for each language.
Integration with version control systems like Git.
