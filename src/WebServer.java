package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;

/**
 * WebServer Object.
 *
 * WebServer represents a server that serves up web content through its
 * ServerSocket. Listens indefinitely for new client connections and creates
 * a new thread to handle client requests.
 *
 * @author Maurice Harris 1000882916
 *
 */
public class WebServer {

    /**
     * Creates the ServerSocket and listens for client connections, creates a
     * separate thread to handle each client request.
     *
     * @param args an array of arguments to be used in the
     *
     *
     */
    private static boolean stopServer = false;
    public static void main(String[] args) throws Exception {

        // Create ServerSocket on LocalHost, port 8000
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Listening for connections on port 8000...\r\n");

        // Listen for new client connections
        boolean set = true;
        while(!stopServer) {

            // Accept new client connection
            Socket connectionSocket = serverSocket.accept();

            // Create new thread to handle client request
            Thread connectionThread = new Thread(new Connection(connectionSocket));

            // Start the connection thread
            connectionThread.start();
            
            System.out.println("New connection on port 8000...\r\n");
           
            Thread.sleep(2000);
            
            
            stopServer = true;
            break;

        }
        // serverSocket.close();
        // System.exit(0);
    }
}
