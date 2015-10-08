package eu.opends.input;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SimulatorKeyHendler implements ContentHandler {
	final int ActionKey = 0;
	final int AnalogKey = 1;
	int keyType;
	String elementName;
	static Key key = new Key();
	static ArrayList<String> stringList = new ArrayList<String>();
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String content;
		if(elementName.equals("ActionKey")){
			keyType = ActionKey;
		} else if(elementName.equals("AnalogKey")){
			keyType = AnalogKey;
		} else if(elementName.equals("ActionName")) {
			content = new String(ch, start, length);
			//	      System.out.println("element: " + elementName + ", content: " +content);
			key.setID(content);
		} else if(elementName.equals("KeyCode")) {
			content = new String(ch, start, length);
			//	      System.out.println("element: " + elementName + ", content: " +content);
			stringList.add(content);
		} else if (elementName.equals("Description")) {
			Key assignKey = new Key();
			String[] KeyCodes = new String[stringList.size()];

			for(int i = 0; i < stringList.size(); i++){
				KeyCodes[i] = stringList.get(i);
			}
			stringList.clear();

			content = new String(ch, start, length);
			//	      System.out.println("element: " + elementName + ", content: " +content);
			key.setDescription(content);

			assignKey.setID(key.getID());
			assignKey.setDefaultKeys(KeyCodes);
			assignKey.setDescription(key.getDescription());
			//	      System.out.println("ActionName: " + key.getID() + ", KeyCode: " + key.getDescription());

			if(keyType == ActionKey)
				KeyMapping.setSimulatorActionKeyMappingList(assignKey);
			else
				KeyMapping.setSimulatorAnalogKeyMappingList(assignKey);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		elementName="";

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts)
			throws SAXException {
		// TODO Auto-generated method stub
		elementName = qName;

	}

	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub

	}
}
