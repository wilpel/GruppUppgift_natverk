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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.java_websocket.WebSocket;

public class Application {
   
    public static   Connection con;
  public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException{
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      con = DriverManager.getConnection("jdbc:mysql://db.cu7kdxmko67m.eu-central-1.rds.amazonaws.com:3306/IoT", "IoT", "gummianka");
      
     new WebsocketServer().start();
     
     while(true){
         
         for(WebSocket s : WebsocketServer.conns){
         
             s.send("Data: "+getData());
             
         }
         
         Thread.sleep(1000);
     }
      
  }
  
  public static float getData() throws ClassNotFoundException, SQLException{
        String maxSalary;

  
    PreparedStatement st = con.prepareStatement("SELECT * FROM sys.Table ORDER BY id DESC LIMIT 1");
    ResultSet r1=st.executeQuery();

     if(r1.next()) {

           return r1.getFloat("data");
      }else{
         return 0;
     }

   

  }
}