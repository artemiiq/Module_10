import java.io.*;
import java.util.regex.*;

public class PhoneNumberValidator {
    public static void main(String[] args) {
        String fileName = "D:\\file.txt";
        validator(fileName);
    }

    public static void validator(String fileName) {
        String regex = "^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
