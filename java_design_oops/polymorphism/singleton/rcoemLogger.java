import java.io.IOException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.*; 

public class rcoemLogger{
		public static void main(String args[]){
				//Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
				Logger LOGGER = Logger.getLogger(rcoemLogger.class.getName());
				//LOGGER.setLevel(Level.FINEST); 
				//LOGGER.log(Level.FINE, "My first Log Message"); 
				//LOGGER.log(Level.FINER, "My first Log Message"); 
				//LOGGER.log(Level.FINEST, "My first Log Message"); 
				//LOGGER.log(Level.SEVERE, "My first Log Message"); 
				//LOGGER.log(Level.WARNING, "My first Log Message"); 
				//LOGGER.log(Level.INFO, "My first Log Message"); 
				//LOGGER.log(Level.ALL, "My first Log Message");
				//LOGGER.severe("Info Log");
				//LOGGER.warning("Info Log");
				//LOGGER.info("Info Log");
				//LOGGER.finest("Really not important");

				try{	
						FileHandler fHandler 
								= new FileHandler("logs.txt"); 
						ConsoleHandler handler 
								= new ConsoleHandler(); 
						//handler.setFormatter(new SimpleFormatter()); 
						LOGGER.addHandler(handler); 
						LOGGER.addHandler(fHandler); 
						LOGGER.setLevel(Level.WARNING);
						LOGGER.warning("qwerty message"); 
				}
				catch (IOException e){
						e.printStackTrace();
				}		

		}
}