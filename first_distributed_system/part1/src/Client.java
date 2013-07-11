import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 7/9/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String[] args) {
        new Client().run();
    }

    public void run(){
        Scanner scan = new Scanner(System.in);
        String numbers = null;

        try{
            System.out.println("[1] Add \n[2] Subtract");
            int input =  scan.nextInt();
            scan.nextLine();

            switch(input){
                case 1:
                    System.out.println("Enter two numbers to add, separated by a space");
                    numbers = scan.nextLine();
                    break;
                case 2:
                    System.out.println("Enter two numbers to subtract, separated by a space");
                    numbers = scan.nextLine();
                    break;
                default:
                    System.out.println("Please enter numbers 1 or 2");
                    break;
            }

            Socket server = new Socket("localhost", 30000);
            OutputStream serverOut = server.getOutputStream();
            InputStream serverIn = server.getInputStream();

            PrintWriter serverWrite = new PrintWriter(serverOut, true);
            serverWrite.println(numbers);
            serverWrite.println(input);
            server.shutdownOutput();

            Scanner serverScan = new Scanner(serverIn);
            serverScan.useDelimiter("$");
            String resp = serverScan.next();

            System.out.println(resp);
            server.shutdownInput();
            server.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

