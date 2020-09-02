package rcoem;
import java.util.ArrayList;
import java.util.Iterator;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.Socket;
import java.io.InputStream;
import java.io.EOFException;

public class ConcreteNotifier implements INotifier{
	private ArrayList<IObserver> _list = new ArrayList<IObserver>();
	
	public void register(IObserver obs){
		_list.add(obs);
	}

	public void remove(IObserver obs){}

	public void process(){

		try{
			ServerSocket serverSocket = new ServerSocket(8999);
			while(true){
				try{
					Socket socket = serverSocket.accept();
            		InputStream stream = socket.getInputStream();
            		DataInputStream dataIn = new DataInputStream(stream);
            	
					String message = dataIn.readUTF();
					System.out.println("Message:" + message);

					dataIn.close();
					socket.close();

					Iterator<IObserver> itr = _list.iterator();
					while(itr.hasNext()){
						IObserver obs = itr.next();
						obs.update(message);
					}
				}
				catch(EOFException e){
					e.printStackTrace();
				}
			}
		}
		catch(UnknownHostException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
