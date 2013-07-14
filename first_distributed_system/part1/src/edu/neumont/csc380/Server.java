package edu.neumont.csc380;

import edu.neumont.csc380.ClientThread;
import edu.neumont.csc380.MathLogic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
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
        ServerSocket server = null;
        try{
            while(true){
                server = new ServerSocket(30000);
                System.out.println("Connecting to client...");
                Socket client = server.accept();
                ClientThread ct = new ClientThread(client);
                ct.start();

                Class c = Class.forName("edu.neumont.csc380.MathLogic");
                Method[] methods = c.getDeclaredMethods();

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String numbers = in.readLine();
                String input = in.readLine();
                String[] splitNumbers = numbers.split(" ");

                Object[] inputs = new Object[splitNumbers.length];
                  for(int i = 0; i <splitNumbers.length; i++)
                  {
                    inputs[i] = Integer.valueOf(splitNumbers[i]);
                  }

                Object reflect = c.getConstructor().newInstance();
                Method meth;
                int value = Integer.valueOf(input);
                for(int i = 0; i < methods.length; i++){
                    if(methods[value-1].equals(methods[i])){
                       meth = methods[i];
                       out.println(meth.invoke(reflect, inputs));
                    }
                }

                out.close();
                in.close();
                client.close();
                server.close();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
