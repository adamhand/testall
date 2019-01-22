package SerializeDemo.ProtoBufDemo.ServerTest;

import SerializeDemo.ProtoBufDemo.ProtoBuf.UserProto;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtoBufServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket socket = serverSocket.accept();
            byte[] data = new byte[1024];

            socket.getInputStream().read(data);
            int dataBodyLen = data[0];
            System.out.println("data body length: "+ dataBodyLen);

            byte[] dataBody = new byte[dataBodyLen];
            System.arraycopy(data, 1, dataBody, 0, dataBodyLen);


            UserProto.User user = UserProto.User.parseFrom(dataBody);

            System.out.println("received : ");
            System.out.println(user.getName()+" "+user.getGender()+" "+user.getAge()+ " "+user.getAddr());
        }
    }
}
