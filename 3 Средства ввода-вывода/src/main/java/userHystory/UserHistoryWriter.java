package userHystory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UserHistoryWriter {

    public UserHistoryWriter(String userTo, String username, String msg) throws IOException {
        String fileName = "D:/java/gb_Java_core. Профессиональный уровень/Практика/GB_Java_core3/3 Средства ввода-вывода/History/" + userTo + ".txt";
        File file = new File(fileName);
        if (file.exists() == false) {
            file.createNewFile();
        }
        Path p= Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
                writer.append(username + "\n" + msg + "\n");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
