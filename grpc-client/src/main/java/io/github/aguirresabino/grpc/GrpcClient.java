package io.github.aguirresabino.grpc;

import io.github.aguirresabino.grpc.HelloRequest;
import io.github.aguirresabino.grpc.HelloResponse;
import io.github.aguirresabino.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.logging.Logger;

public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Aguirre")
                .setLastName("Sabino")
                .build());

        logger.info("[GRPC CLIENT] Resposta recebida: " + helloResponse);

        channel.shutdown();
    }

}
