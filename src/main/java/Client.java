import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 23456);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите номер искомого числа Фибоначчи: ");
            int n = scanner.nextInt();
            out.println(n);

            System.out.print("Ответ от сервера: " + in.readLine());
            System.out.println();
        }
    }

}
