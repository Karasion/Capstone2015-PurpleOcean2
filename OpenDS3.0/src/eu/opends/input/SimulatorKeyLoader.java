package eu.opends.input;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

public class SimulatorKeyLoader {
	
	public void parser() throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();

		// handler generation
		ContentHandler contentHandler = new SimulatorKeyHendler();

		// enroll handler 
		reader.setContentHandler(contentHandler);

		// parsing start
		reader.parse("assets/Key/SimulatorKey.xml");


//		for(Key key : KeyMapping.getSimulatorActionKeyMappingList())
//			printKeyMapping(key);
	}

	public static void printKeyMapping(Key keyMapping)
	{
		System.out.println("<ActionName>" + keyMapping.getID()+"</ActionName>");
		for(int i = 0; i < keyMapping.getDefaultKeys().length; i++){
			System.out.println("<KeyCode>" + keyMapping.getDefaultKeys()[i]+"</KeyCode>");
		}
		System.out.println("<Description>" + keyMapping.getDescription()+"</Description>");
	}
}
