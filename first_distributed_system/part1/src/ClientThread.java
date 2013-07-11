import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 7/11/13
 * Time: 12:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClientThread extends Thread{

    Socket s;

    public ClientThread(Socket s){
        this.s = s;
    }
}
