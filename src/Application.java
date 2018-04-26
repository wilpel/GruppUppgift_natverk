import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.java_websocket.WebSocket;

public class Application {
   
  public static void main(String[] args) throws IOException, InterruptedException{
      
     new WebsocketServer().start();
     
     while(true){
         
         for(WebSocket s : WebsocketServer.conns){
         
             s.send("Data: "+new Random().nextFloat());
             
         }
         
         Thread.sleep(1000);
     }
      
  }
}