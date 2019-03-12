package userHystory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UserHistoryWriter {
    private static final String History="History";
    public void UserHistoryWriter(String username, String userFrom, String msg) throws IOException {
        //String fileName = "D:/java/gb_Java_core. Профессиональный уровень/Практика/GB_Java_core3/3 Средства ввода-вывода/History/" + username + ".txt";
        File file = new File(History,username+ ".txt");
        if (file.exists() == false) {
            file.createNewFile();
        }
        Path p= Paths.get(file.toString());
        try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
            writer.append(userFrom + "|" + msg);
            writer.append( "\n");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}