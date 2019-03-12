import userHystory.UserHistoryWriter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientHandler {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);
    private static final String MESSAGE_SEND_PATTERN = "/w %s %s";
    private static final String USER_LIST_PATTERN = "/userlist %s";


    private final Thread handleThread;
    private final DataInputStream inp;
    private final DataOutputStream out;
    private final ChatServer server;
    private final String username;
    private final Socket socket;

    public ClientHandler(String username, Socket socket, ChatServer server) throws IOException {
        this.username = username;
        this.socket = socket;
        this.server = server;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());



        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = inp.readUTF();
                        System.out.printf("Message from user %s: %s%n", username, msg);
                        Matcher matcher = MESSAGE_PATTERN.matcher(msg);
                        if (matcher.matches()) {
                            String userTo = matcher.group(1);
                            String message = matcher.group(2);
                            server.sendMessage(userTo, username, message);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("Client %s disconnected%n", username);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        server.unsubscribeClient(ClientHandler.this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        handleThread.start();
    }

    public void sendMessage(String username1,String userTo, String msg) throws IOException {


        out.writeUTF(String.format(MESSAGE_SEND_PATTERN, userTo, msg));
    }

    public void sendUserList(List msg) throws IOException {
        ArrayList<String > arrayList=new ArrayList<>(msg);
        String msg1="";
        for (int i = 0; i < msg.size(); i++) {
            msg1=msg1+((ClientHandler) msg.get(i)).username+":USER:";
        }
        out.writeUTF(String.format(USER_LIST_PATTERN, msg1));
    }

    public String getUsername() {
        return username;
    }
}
