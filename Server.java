import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
       int nbr=0;
       try{
       nbr=Integer.prseInt(str);
       }catch(Exception e);{
       System.out.println("vous n'avez pas entré un entier");
       }
       for(int i=2;i<nbr;i++){
       if(Premier(i))
       System.out.println(i);
       }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
    static boolean Premier(int n)
    {
      boolean result;
       result=true;
        int i=2;
       while(i<=n/2 && result){
        if(n%2==0)
        result=false;
        i++;
        }
        return(result);
        }

}
