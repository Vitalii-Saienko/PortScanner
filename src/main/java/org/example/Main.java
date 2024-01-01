package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private static final int THREADS = 100;
    private static final int TIMEOUT = 100;
    private static final int MIN_PORT_NUMBER = 0;
    private static final int MAX_PORT_NUMBER = 65535;

    public static void main(String[] args) {
        Main.scan();
    }

    private static void scan() {
        String host = getHostFromUser();

        System.out.println("Scanning ports:");
        try (ExecutorService executorService = Executors.newFixedThreadPool(THREADS)) {

            for (int i = MIN_PORT_NUMBER; i <= MAX_PORT_NUMBER; i++) {
                final int port = i;
                executorService.execute(() -> {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);

                    try (Socket socket = new Socket()) {
                        socket.connect(inetSocketAddress, TIMEOUT);
                        System.out.printf("Host %s, port %d opened%n", host, port);
                    } catch (IOException ignored) {
                    }
                });
            }

            executorService.shutdown();

        }

        System.out.println("Finished.");
    }

    private static String getHostFromUser() {
        String host;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter localhost or http address to check open hosts in format: yourwebpage.com");
            host = scanner.nextLine();
            while (!(host.equals("localhost") || WebAddressValidator.isValidDomain(host))) {
                System.out.println("Invalid domain. Try again:");
                host = scanner.nextLine();
            }
        }
        return host;
    }
}