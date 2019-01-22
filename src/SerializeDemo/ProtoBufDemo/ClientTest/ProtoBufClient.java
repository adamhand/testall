package SerializeDemo.ProtoBufDemo.ClientTest;

import SerializeDemo.ProtoBufDemo.ProtoBuf.UserProto;

import java.io.IOException;
import java.net.Socket;

public class ProtoBufClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);

        UserProto.User.Builder user = UserProto.User.newBuilder();
        UserProto.Address.Builder address = UserProto.Address.newBuilder();

        address.setCountry("China").setCity("hangzhou");
        user.setName("张三").setGender("male").setAge(21).setAddr(address);

        byte[] messageBody = user.build().toByteArray();
        int headLen = 1;
        byte[] message = new byte[headLen + messageBody.length];
        message[0] = (byte)messageBody.length;
        System.arraycopy(messageBody, 0, message, 1, messageBody.length);
        System.out.println("message length: "+ message.length);

        socket.getOutputStream().write(message);
    }
}
