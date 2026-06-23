import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SchoolResultPortal {

    public static void generateReportCard(String sourceFile, String reportFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile, true))) {

            String line;
            writer.write("--- New Report Card Entry ---\n");
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    double total = 0;
                    int count = 0;
                    
                    for (int i = 1; i < parts.length; i++) {
                        total += Double.parseDouble(parts[i].trim());
                        count++;
                    }
                    
                    double average = count > 0 ? total / count : 0;
                    writer.write(String.format("Student: %s | Average: %.2f\n", name, average));
                }
            }
            writer.write("\n");
            System.out.println("Results successfully appended to report card.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: The source student record file was not found.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Format error found within the marks data.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateReportCard("students.txt", "report_cards.txt");
    }
}