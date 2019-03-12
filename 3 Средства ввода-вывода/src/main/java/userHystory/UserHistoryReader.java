package userHystory;

import swing.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserHistoryReader {
    private static final String History="History";
    private static final Pattern UserHistory =Pattern.compile("(\\n)(.*)\\|(.*)");
    private static File file;
    public UserHistoryReader(String fileName) throws IOException {

        //fileName = "D:/java/gb_Java_core. Профессиональный уровень/Практика/GB_Java_core3/3 Средства ввода-вывода/History/"+fileName + ".txt";
        file=new File(History,fileName+ ".txt");
    }

    public List<Message> printByRandomAcessFile() throws FileNotFoundException, IOException{

        List<String> list=new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        int lines = 0;
        StringBuilder builder = new StringBuilder();
        long length = file.length();
        length=length-1;
        randomAccessFile.seek(length);
        for(long seek = length; seek >= 0; --seek){
            randomAccessFile.seek(seek);
            char c = (char)randomAccessFile.read();
            builder.append(c);
            if(c == '\n'){
                builder = builder.reverse();
                list.add(builder.toString());
                lines++;
                builder = null;
                builder = new StringBuilder();
                if (lines == 100){
                    break;
                }
            }

        }
        List<Message> messages=list.stream()
                .map(record ->{
                            Matcher matcher = UserHistory.matcher(record);
                            if (matcher.matches()){
                                String rfomUser =matcher.group(2);
                                String text=matcher.group(3);
                                return new Message(rfomUser,null,text);
                            }
                            return new Message(null,null,null);
                        }
                ).collect(Collectors.toList());
        Collections.reverse(messages);
        return messages;
    }

}