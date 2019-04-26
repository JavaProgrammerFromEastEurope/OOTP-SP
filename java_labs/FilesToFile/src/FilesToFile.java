import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesToFile {
	
	 private static String readFile(String filePath){
	        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
	            String file = "", line;
	            while((line = reader.readLine())!= null){
	                file +=  line+"\n";
	            }
	            return file;
	        }
	        catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return null;
	       
	    }
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        String file1 = readFile("F1.txt");
	        String file2 = readFile("F2.txt");
	        try(FileWriter writer = new FileWriter("F3.txt",false)){
	            writer.write(file1+"\t"+file2);
	           
	        }
	        catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

}
