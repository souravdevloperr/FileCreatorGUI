import java.io.FileWriter;
import java.io.IOException;

public class CFileCreator {

    public void createCFile(String fileName) {
        // Construct the file name with .c extension
        String cFileName = fileName + ".c";

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(cFileName);

            // Write the default C code template
            writer.write("#include <stdio.h>\n\n");
            writer.write("int main() {\n");
            writer.write("    printf(\"Hello, world!\\n\");\n");
            writer.write("    return 0;\n");
            writer.write("}\n");

            // Close the FileWriter
            writer.close();

            System.out.println("C file '" + cFileName + "' created successfully.");

            // Open the file in Visual Studio Code
            openInVSCode(cFileName);
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
        CFileCreator creator = new CFileCreator();
        creator.createCFile("MyProgram");  // Example: Create a C file named "MyProgram.c"
    }
}
