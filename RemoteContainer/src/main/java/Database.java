import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Database {
	String directory = System.getProperty("user.dir") + File.separator + "Database";
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public void createDatabaseStructure() {
		String clientsFolder = directory + File.separator + "Clients";
		String containersFolder = directory + File.separator + "Containers";
		String journeysFolder = directory + File.separator + "Journeys";
		
		new File(this.directory).mkdirs();
		new File(clientsFolder).mkdirs();
		new File(containersFolder).mkdirs();
		new File(journeysFolder).mkdirs();
	}
	
	public void createFile(ArchivableObject object, String folderName, String fileName) {
		String path = directory + File.separator + folderName + File.separator + fileName;
		
		try {
	        FileWriter file = new FileWriter(path);
	        gson.toJson(object, file);
	        file.close();
	        
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}
	
	public ArchivableObject readFile(ArchivableObject object, String filePath) {
		String path = directory + File.separator + filePath;
		
        try (Reader reader = new FileReader(path)) {
        	object = gson.fromJson(reader, object.getClass());
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return object;
	}
	
	public void updateFile(ArchivableObject object) {
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
