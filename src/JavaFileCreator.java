import java.io.FileWriter;
import java.io.IOException;

public class JavaFileCreator {

    public void createJavaFile(String fileName) {
        // Construct the file name with .java extension
        String javaFileName = fileName + ".java";

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(javaFileName);

            // Write the default Java class template
            writer.write("public class " + fileName + " {\n");
            writer.write("    public static void main(String[] args) {\n");
            writer.write("        // Your code here\n");
            writer.write("    }\n");
            writer.write("}\n");

            // Close the FileWriter
            writer.close();

            System.out.println("Java file '" + javaFileName + "' created successfully.");

            // Open the file in Visual Studio Code
            openInVSCode(javaFileName);
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
        JavaFileCreator creator = new JavaFileCreator();
        creator.createJavaFile("MyClass");  // Example: Create a Java file named "MyClass.java"
    }
}
