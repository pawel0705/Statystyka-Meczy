package pl.polsl.lab3.pawel.salicki.tcpNetwork;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import pl.polsl.lab3.pawel.salicki.model.Database;

/**
 * Class with server communication protocol
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class ServerTCP {

    /**
     * Server database.
     */
    private static Database database;

    /**
     * Server port.
     */
    private static int PORT;

    /**
     * Server socket.
     */
    private final ServerSocket serverSocket;

    /**
     * The constructor creates a server object. Creates a server socket.
     *
     * @throws IOException bad port exception
     */
    public ServerTCP() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    /**
     * The main server method. Reads the port from the properties file.
     *
     * @param args the initial run arguments are not used
     */
    public static void main(String args[]) {
        Socket socket;
        ServerTCP server = null;

        Properties serverConfiguration = new Properties();

        System.out.print("Configure new port (create new .properties file)? (y/n): ");

        String userAnswer = "";
        try {
            do {
                userAnswer = new BufferedReader(new InputStreamReader(System.in)).readLine();
                userAnswer = userAnswer.toUpperCase();
            } while (!userAnswer.equals("Y") && !userAnswer.equals("N"));

            if (userAnswer.equals("Y")) {
                System.out.print("Please enter new port: ");
                PORT = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                serverConfiguration.setProperty("PORT", Integer.toString(PORT));
                try (FileOutputStream out = new FileOutputStream(".properties")) {
                    serverConfiguration.store(out, "--Configuration--");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                try (FileInputStream in = new FileInputStream(".properties")) {
                    serverConfiguration.load(in);
                    PORT = Integer.parseInt(serverConfiguration.getProperty("PORT"));
                    System.out.println("Your port is " + PORT);
                } catch (IOException e) {
                    System.err.println("An error occurred while reading PORT. Your port is 8888");
                    PORT = 8888;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while entering arguments. Please restart application.");
        }

        try {
            server = new ServerTCP();
            System.out.println();
            System.out.println("Server started...");

            while (true) {
                socket = server.serverSocket.accept();
                new Thread(new SingleService(socket, database)).start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                server.serverSocket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
