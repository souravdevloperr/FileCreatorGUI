import java.io.FileWriter;
import java.io.IOException;

public class PythonFileCreator {

    public void createPythonFile(String fileName) {
        // Construct the file name with .py extension
        String pythonFileName = fileName + ".py";

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(pythonFileName);

            // Write the default Python code template
            writer.write("def main():\n");
            writer.write("    print(\"Hello, world!\")\n");
            writer.write("\n");
            writer.write("if __name__ == \"__main__\":\n");
            writer.write("    main()\n");

            // Close the FileWriter
            writer.close();

            System.out.println("Python file '" + pythonFileName + "' created successfully.");

            // Open the file in Visual Studio Code
            openInVSCode(pythonFileName);
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    private void openInVSCode(String fileName) {
        try {
            ProcessBuilder pb;
            if (System.getProperty("os.name").startsWith("Windows")) {
                pb = new ProcessBuilder("cmd", "/c", "code", fileName);
            } else {
                pb = new ProcessBuilder("code", fileName);
            }
            pb.start();
            System.out.println("Opened in Visual Studio Code.");
        } catch (IOException e) {
            System.out.println("An error occurred while opening in VS Code: " + e.getMessage());
        }
    }

    // Example usage in a main method or another class
    public static void main(String[] args) {
        PythonFileCreator creator = new PythonFileCreator();
        creator.createPythonFile("MyScript");  // Example: Create a Python file named "MyScript.py"
    }
}
