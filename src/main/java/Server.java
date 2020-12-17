import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    // Blocking вариант был выбран в связи с тем, что до получения искомого значения работа программы должна останавливаться
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(23456);

        try (Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            int n = Integer.parseInt(in.readLine());
            int f = calculateFibonacci(n);
            out.printf("искомое число Фибоначчи под номером %d -> %d\n", n, f);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static int calculateFibonacci(int n) {
        int a = 0;
        int b = 1;
        int f = 0;
        for (int i = 1; i < (n - 1); i++) {
            f = a + b;
            a = b;
            b = f;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        } else {
            return f;
        }
    }
}
