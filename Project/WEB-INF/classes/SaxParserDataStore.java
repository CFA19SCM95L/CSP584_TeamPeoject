
// /*********


// http://www.saxproject.org/

// SAX is the Simple API for XML, originally a Java-only API. 
// The current version is SAX 2.0.1, and there are versions for several programming language environments other than Java. 

// The following URL from Oracle is the JAVA documentation for the API

// https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html


// *********/
// import org.xml.sax.InputSource;

// import java.io.IOException;
// import java.text.ParseException;
// import java.util.*;
// import  java.io.StringReader;
// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.parsers.SAXParser;
// import javax.xml.parsers.SAXParserFactory;

// import org.xml.sax.Attributes;
// import org.xml.sax.SAXException;
// import org.xml.sax.helpers.DefaultHandler;


// ////////////////////////////////////////////////////////////

// /**************

// SAX parser use callback function  to notify client object of the XML document structure. 
// You should extend DefaultHandler and override the method when parsin the XML document

// ***************/

// ////////////////////////////////////////////////////////////

// public class SaxParserDataStore extends DefaultHandler {

	
// 	Tv tv;
// 	SoundSystem soundSystem; 
// 	Phone phone;
// 	Laptop laptop;
// 	VoiceAssistant voiceAssistant;
// 	WearableTechnology wearableTechnology;
// 	Accessory accessory;
// 	static HashMap<String,Tv> tvs;
//     static HashMap<String,SoundSystem> soundSystems;
// 	static HashMap<String,Phone> phones;
// 	static HashMap<String,Laptop> laptops;
//     static HashMap<String,VoiceAssistant> voiceAssistants;
// 	static HashMap<String,WearableTechnology> wearableTechnologies;
// 	static HashMap<String,Accessory> accessories;
//     String consoleXmlFileName;
// 	HashMap<String,String> accessoryHashMap;
//     String elementValueRead;
// 	String currentElement="";
// 	int i = 0;

// 	boolean sql = false;
// 	static HashMap<String,Product> products;

//     public SaxParserDataStore()
// 	{
// 	}


// 	public SaxParserDataStore(String consoleXmlFileName) {
// 		this.consoleXmlFileName = consoleXmlFileName;

// 		products = MySqlDataStoreUtilities.selectProduct();




// 		HashMap<String, ArrayList<Review>> hm = MongoDBDataStoreUtilities.selectReview();
// 		int size = 0;
// 		for (Map.Entry<String, ArrayList<Review>> entry: hm.entrySet()) {
// 			size+= entry.getValue().size();
// 		}

// 		if (products.size() > 0){

// 			sql = true;
// 			parseDocument();
// 			storeProduct(products);

// 		} else {

// 			MySqlDataStoreUtilities.createTable();

// 			parseDocument();
// 			insertDefaultData();



// 		}
// 		if (size == 0) {
// 			insertReviewData();

// 		}
// 	}

// 	private void storeProduct(Map<String, Product> products) {


// 	}
//    //parse the xml using sax parser to get the data
//     private void parseDocument() 
// 	{
//         SAXParserFactory factory = SAXParserFactory.newInstance();
//         try 
// 		{
// 	    SAXParser parser = factory.newSAXParser();
// 	    parser.parse(consoleXmlFileName, this);
//         } catch (ParserConfigurationException e) {
//             System.out.println("ParserConfig error");
//         } catch (SAXException e) {
//             System.out.println("SAXException : xml not well formed");
//         } catch (IOException e) {
//             System.out.println("IO error");
//         }
// 	}

   

// ////////////////////////////////////////////////////////////

// /*************

// There are a number of methods to override in SAX handler  when parsing your XML document :

//     Group 1. startDocument() and endDocument() :  Methods that are called at the start and end of an XML document. 
//     Group 2. startElement() and endElement() :  Methods that are called  at the start and end of a document element.  
//     Group 3. characters() : Method that is called with the text content in between the start and end tags of an XML document element.


// There are few other methods that you could use for notification for different purposes, check the API at the following URL:

// https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html

// ***************/

// ////////////////////////////////////////////////////////////
	
// 	// when xml start element is parsed store the id into respective hashmap for console,games etc 
//     @Override
//     public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {


// 	}


// 	// when xml end element is parsed store the data into respective hashmap for console,games etc respectively
//     @Override
//     public void endElement(String str1, String str2, String element) throws SAXException {


// 	}
// 	//get each element in xml tag
//     @Override
//     public void characters(char[] content, int begin, int end) throws SAXException {
//         elementValueRead = new String(content, begin, end);
//     }


//     /////////////////////////////////////////
//     // 	     Kick-Start SAX in main       //
//     ////////////////////////////////////////
	
// 	//call the constructor to parse the xml and get product details
//  	public static void addHashmap() {
// 		String TOMCAT_HOME = System.getProperty("catalina.home");	
// 		new SaxParserDataStore(TOMCAT_HOME+"\\webapps\\Project");
// 	} 
	

// 	private void insertReviewData() {
// 		ArrayList<String> v = new ArrayList<>();
// 		v.add("Google Pixel4");
// 		v.add("1");
// 		v.add("user1");
// 		v.add("Yes");
// 		v.add("18");
// 		v.add("Male");
// 		v.add("Student");
// 		v.add("10");
// 		v.add("10/27");
// 		v.add("Great product");
// 		List<String> s = MySqlDataStoreUtilities.getParam(v.get(0), v.get(1) , v.get(2));
// 		String message =MongoDBDataStoreUtilities.insertReview(v.get(0), s.get(0), s.get(1), v.get(1), s.get(4), s.get(5), s.get(6), v.get(3), s.get(2), s.get(3), v.get(2), v.get(4), v.get(5),v.get(6), v.get(7) ,v.get(8), v.get(9));



// 	}
// 	private void insertDefaultData() {
// 		System.out.println("insertDefaultData");
// 		MySqlDataStoreUtilities.insertStore();
// 		MySqlDataStoreUtilities.insertUser("user1", "user1", "customer", 0);




// 		MySqlDataStoreUtilities.insertOrder("user1","name1", "25910 Celtic Terrace Dr", "Katy", "TX", "77494", "1323,3532,5645,1313", "10/1", "10/16", "Google Pixel4", 1, 70, 10, 750.99, "1");

// 		System.out.println("insertDefaultData: End");





// 	}


// }
