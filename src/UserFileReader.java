import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;

public class UserFileReader {
    public static void main(String[] args) {
        String inputFile = "D:\\GoIT\\file.txt";
        String outputFile = "user.json";

        List<User> users = readUserFromFile(inputFile);
        writeUsersToJsonFile(users, outputFile);

        System.out.println("Дані успішно збережені в " + outputFile);
    }

    public static List<User> readUserFromFile(String filePath) {
        List<User> users = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeUsersToJsonFile(List<User> users, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(filePath), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
