package io.github.aguirresabino.grpc;

import io.github.aguirresabino.grpc.services.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class GrpcServer {

    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new HelloServiceImpl())
                .build();

        logger.info("[GRPC SERVER] Iniciando servidor");
        server.start();
        logger.info("[GRPC SERVER] Servidor iniciado");
        server.awaitTermination();
    }
}
