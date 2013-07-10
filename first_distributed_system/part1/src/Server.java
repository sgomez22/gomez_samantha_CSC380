import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 7/9/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {

    public static void main(String[] args) {
        MathLogic mathlogic = new MathLogic();
        try{
            ServerSocket server = new ServerSocket(30000);
            System.out.println("Connecting to client...");
            Socket client = server.accept();

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String numbers = in.readLine();
            String input = in.readLine();
            String[] splitNumbers = numbers.split(" ");
            int a = Integer.valueOf(splitNumbers[0]);
            int b = Integer.valueOf(splitNumbers[1]);
            int value = Integer.valueOf(input);

            if(value == 1){
                out.println(mathlogic.add(a, b));
            } else if(value == 2){
                out.println(mathlogic.subtract(a, b));
            }

            out.close();
            in.close();
            client.close();
            server.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
