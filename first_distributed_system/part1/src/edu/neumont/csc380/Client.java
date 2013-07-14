package edu.neumont.csc380;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
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
            Class c = Class.forName("edu.neumont.csc380.MathLogic");
            Method[] methods = c.getDeclaredMethods();
            for(int i = 1; i < methods.length+1; i++)
                System.out.println("["+i+"] "+ methods[i-1].getName());
            int input =  scan.nextInt();
            scan.nextLine();

            if(input != 0 && input <= methods.length){
                System.out.println("Enter numbers to calculate separated by a space");
                numbers = scan.nextLine();
            } else{
                System.out.println("Please enter numbers 1 - "+methods.length);
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

