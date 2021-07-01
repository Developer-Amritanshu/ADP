import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileWriter;

class TaskManager{
  public static void main(String[] args) {
    try {
      
      // FileWriter to write in file
      FileWriter myWriter = new FileWriter("filename.txt");
      
      // Creating New File
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }

      // to store the name of process
      String line;
      
      // get all the process
      Process p = Runtime.getRuntime().exec
      (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
      
      // Buffer reader to read input from process -> p
      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
      
      while ((line = input.readLine()) != null) {
        myWriter.write(line+"\n"); 
      }
      
      input.close();
      myWriter.close();
  
    } catch (Exception err) {
      err.printStackTrace();
  }
  }
}