package SerializeDemo.GrpcTest;

import Proxy.StaticProxy.HelloImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloWorldServer {
    private int port = 50051;
    private Server server;

    private void start(){
        server = ServerBuilder.forPort(port)
                                .addService(new )
    }

    private class GreeterImpl extends
}
