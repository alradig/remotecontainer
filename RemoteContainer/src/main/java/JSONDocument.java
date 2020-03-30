import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class JSONDocument {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public void createDocument(ArchivableObject object) {
		String objectClass = object.getClass().getName();
		
		try {
	         FileWriter file = new FileWriter("/Users/alradig/Desktop/"+objectClass+".json");
	         gson.toJson(object, file);
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}
	
}
