import java.io.*;
import java.net.*;
import java.util.Random;

class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(() -> {
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

                    output.println("Choose odd or even");
                    String clientChoice = input.readLine();
                    int serverNumber = new Random().nextInt(100);
                    String result = (serverNumber % 2 == 0 && clientChoice.equals("even")) || (serverNumber % 2 != 0 && clientChoice.equals("odd")) ? "win" : "lose";

                    output.println("Server number is " + serverNumber + ". You " + result + "!");
                } catch (IOException e) {
                    System.out.println("Oops: " + e.getMessage());
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // Oh, well!
                    }
                }
            }).start();
        }
    }
}
