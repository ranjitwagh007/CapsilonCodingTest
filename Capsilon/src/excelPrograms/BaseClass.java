package excelPrograms;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class BaseClass {
	
	static File file;
	static FileInputStream inputStream;
	static HSSFWorkbook workbook;
	static Sheet sheet;
	static Document document;
	public static void readExcel() throws IOException
	{
		 file = new File("E:\\Eclipse projects\\Capsilon\\Resources\\Student_Result5.xls");
		 inputStream = new FileInputStream(file);
		 workbook = new HSSFWorkbook(inputStream);
		 sheet = workbook.getSheet("Sheet1");
	}
	
	public static void readXml() throws ParserConfigurationException, SAXException, IOException
	{
		file = new File("E:\\Eclipse projects\\Capsilon\\Resources\\Professionals.xml");
		DocumentBuilderFactory dbBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuiler = dbBuilderFactory.newDocumentBuilder();
		 document = dbBuiler.parse(file);
		document.getDocumentElement().normalize();
	}
	

}
