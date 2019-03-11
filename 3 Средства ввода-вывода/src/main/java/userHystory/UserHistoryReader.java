package userHystory;

import java.io.*;
import java.nio.charset.Charset;

public class UserHistoryReader {

    public UserHistoryReader(String fileName) throws IOException {
        fileName = "D:/java/gb_Java_core. Профессиональный уровень/Практика/GB_Java_core3/3 Средства ввода-вывода/History/"+fileName + ".txt";
        printByRandomAcessFile(new File(fileName));
    }

    private static void printByRandomAcessFile(File file) throws FileNotFoundException, IOException{
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        int lines = 0;
        StringBuilder builder = new StringBuilder();
        long length = file.length();
        length=length-2;
        randomAccessFile.seek(length);
        for(long seek = length; seek >= 0; --seek){
            randomAccessFile.seek(seek);
            char c = (char)randomAccessFile.read();
            builder.append(c);
            if(c == '\n'){
                builder = builder.reverse();
                System.out.print(builder.toString());
                lines++;
                builder = null;
                builder = new StringBuilder();
                if (lines == 100){
                    break;
                }
            }

        }
    }
}
