package userHystory;

import swing.Message;

import org.apache.commons.lang3.ArrayUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class userHistoryReader {
    private static final String History = "History";
    private static final Pattern UserHistory = Pattern.compile("(\\w+)\\|(.*)");
    private static File file;

    public userHistoryReader(String fileName) {

    file = new File(History, fileName + ".txt");
    }

    public List<Message> printByRandomAcessFile() throws FileNotFoundException, IOException {
        List<String> history = new ArrayList<>();
        List<Byte> list = new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        int lines = 100;
        long length = file.length() - 1;
        List<Byte> bytes = new LinkedList<>();
        for (int seek = 0; length >= 0 && seek < lines; length--) {
            randomAccessFile.seek(length);

            int chr = randomAccessFile.read();
            if (chr == '\n') {
                if (bytes.size() > 1) {
                    Collections.reverse(bytes);
                    byte[] record = ArrayUtils.toPrimitive(bytes.toArray(new Byte[0]));
                    history.add(new java.lang.String(record).replace("\r", ""));
                    bytes.clear();
                }
                seek++;
            } else {
                bytes.add((byte) chr);
            }
        }
        List<Message> messages = history.stream()
                .map(record -> {
                            Matcher matcher = UserHistory.matcher(record);
                            if (matcher.matches()) {
                                String rfomUser = matcher.group(1);
                                String text = matcher.group(2);
                                return new Message(rfomUser, null, text);
                            }
                            return new Message(null, null, null);
                        }
                ).collect(Collectors.toList());
        Collections.reverse(messages);
        return messages;
    }

}