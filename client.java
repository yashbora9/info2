import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        new Thread(() -> {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true) {
                    String serverResponse = input.readLine();
                    System.out.println(serverResponse);
                    if (serverResponse.contains("win") || serverResponse.contains("lose")) {
                        break;
                    }
                }
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

        while (true) {
            System.out.println("> ");
            String command = keyboard.readLine();
            output.println(command);
        }
    }
}

