import java.net.Socket;
import java.io.IOException;
import java.io.DataOutputStream;
import java.util.Scanner;

public class SocketClient{

		public static void main(String args[]){
				try{
						while(true){	
								Socket s = new Socket("127.0.0.1", 8999);
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
								System.out.print("Enter message (QUIT to end): ");
								Scanner scanner = new Scanner(System.in);
								String message = scanner.nextLine();
								if(message.equals("QUIT")){
										dout.close();  
										s.close();
										break;  
								}
								dout.writeUTF(message);  
								dout.flush();  
								dout.close();  
								s.close();  
						}	
				}
				catch(IOException e){
						e.printStackTrace();
				}
		}
}
