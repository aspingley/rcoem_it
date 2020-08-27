package rcoem;

import java.util.ArrayList;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import rcoem.RcoemEmployee;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

class UserParserHandler extends DefaultHandler{

		//This is the list which shall be populated while parsing the XML.
		private ArrayList<RcoemEmployee> employeeList = new ArrayList<RcoemEmployee>();

		//As we complete one user block in XML, we will push the User instance in employeeList
		private Stack<RcoemEmployee> employeeStack = new Stack<RcoemEmployee>();

		private String currentElement;

		public void startDocument() throws SAXException
		{
				//System.out.println("start of the document   : ");
		}

		public void endDocument() throws SAXException
		{
				//System.out.println("end of the document document     : ");
		}

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
				currentElement = qName;

				//If this is start of 'user' element then prepare a new User instance and push it in object stack
				if ("employee".equals(qName))
				{
						//New User instance
						RcoemEmployee employee = new RcoemEmployee();

						//     //Set all required attributes in any XML element here itself
						if(attributes != null && attributes.getLength() == 1)
						{
								employee.setId(attributes.getValue(0));
						}
						this.employeeStack.push(employee);
				}
		}

		public void endElement(String uri, String localName, String qName) throws SAXException
		{
				//User instance has been constructed so pop it from object stack and push in employeeList
				if ("employee".equals(qName))
				{
						//RcoemEmployee object = this.employeeStack.pop();
						this.employeeList.add(this.employeeStack.pop());
				}
		}

		/**
		 * This will be called everytime parser encounter a value node
		 * */
		public void characters(char[] ch, int start, int length) throws SAXException
		{
				//System.out.println("characters");
				String value = new String(ch, start, length).trim();

				if (value.length() == 0)
				{
						return; // ignore white space
				}

				if ("name".equals(currentElement))
				{
						RcoemEmployee employee = this.employeeStack.peek();
						employee.setName(value);
				}
				else if ("title".equals(currentElement))
				{
						RcoemEmployee employee = this.employeeStack.peek();
						employee.setTitle(value);
				}
		}

		//Accessor for employeeList object
		public ArrayList<RcoemEmployee> getEmployees()
		{
				return employeeList;
		}

}

// RcoemSaxXMLReader is the concrete class that composes DefaultHandler of SAX Parser
public class RcoemSaxXMLReader implements RcoemReader {

		private boolean _status;
		private InputStream _inStream;
		private UserParserHandler _handler;

		public void print(){
				if(_handler != null){
						ArrayList<RcoemEmployee> list = _handler.getEmployees();
						for(int i = 0; i < list.size(); i++) { 
								RcoemEmployee em = list.get(i);  
								System.out.print("Name: " + em.getName() + "\tId: " + em.getId() + "\tTitle: " + em.getTitle() + "\n");
						}  
				}
		}

		public boolean initialize(){
				try{
						InputSource source = new InputSource(_inStream);
						SAXParserFactory parserFactory = SAXParserFactory.newInstance();
						SAXParser parser = parserFactory.newSAXParser();
						XMLReader xmlReader = parser.getXMLReader();
						_handler = new UserParserHandler();		
						xmlReader.setContentHandler(_handler);		
						xmlReader.parse(source);
						_status = true;
				}
				catch (SAXException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				} catch (ParserConfigurationException e){
						e.printStackTrace();
				}finally {
				}
				return _status;	
		}

		public void setInputStream(InputStream in){
				_inStream = in;
		}
}
