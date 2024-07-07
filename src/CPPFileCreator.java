import java.io.FileWriter;
import java.io.IOException;

public class CPPFileCreator {

    public void createCPPFile(String fileName) {
        // Construct the file name with .cpp extension
        String cppFileName = fileName + ".cpp";

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(cppFileName);

            // Write the default C++ code template
            writer.write("#include <iostream>\n\n");
            writer.write("using namespace std;\n\n"); // Fixed placement of using namespace std;
            writer.write("int main() {\n");
            writer.write("    cout << \"Hello, world!\" << endl;\n");
            writer.write("    return 0;\n");
            writer.write("}\n"); // Added closing brace for main function

            // Close the FileWriter
            writer.close();

            System.out.println("C++ file '" + cppFileName + "' created successfully.");

            // Open the file in Visual Studio Code
            openInVSCode(cppFileName);
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
        CPPFileCreator creator = new CPPFileCreator();
        creator.createCPPFile("MyProgram");  // Example: Create a C++ file named "MyProgram.cpp"
    }
}
