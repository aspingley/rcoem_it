import rcoem.RcoemReader;
import rcoem.RcoemSaxXMLReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


class RcoemFactory{
		public enum ReaderType{SAX, DOM4J;}

		public RcoemReader createReader(ReaderType type){
				RcoemReader myReader = null;

				if (type.equals(RcoemFactory.ReaderType.SAX)){
						myReader = new RcoemSaxXMLReader();
				}
				else if(type.equals(RcoemFactory.ReaderType.DOM4J)){
						//[TODO] add implementation of DOM4J based XML reader
				}

				return myReader;
		}
}

public class RcoemMainReader{
		public static void main(String args[]) throws FileNotFoundException {
				File xmlFile = new File(args[1]);

				RcoemReader myReader = null; // variable of the interface
				RcoemFactory factory = new RcoemFactory();					

				if (args[0].equals("Sax")){
						myReader = factory.createReader(RcoemFactory.ReaderType.SAX);
				}
				else if (args[0].equals("Dom4j")){
						myReader = factory.createReader(RcoemFactory.ReaderType.DOM4J);
				}

				if (myReader != null){
						myReader.setInputStream(new FileInputStream(xmlFile));
						boolean status = myReader.initialize();
						System.out.println("Status = " + status);
						if (status){
								myReader.print();
						}
				} 
		}
}