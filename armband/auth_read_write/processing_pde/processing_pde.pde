import processing.net.*;

import processing.serial.*;
import java.net.*;
import java.io.*;

Serial myPort;
String rfidID;
String wholeString;

void setup() {
  String portName = Serial.list()[1];
  printArray(Serial.list());

  myPort = new Serial(this, portName, 115200);
  size(200, 200);
  background(0);
}

void draw() {
  // Value changed here
  if (myPort.available() > 0) {
    rfidID = myPort.readStringUntil('\n');
  }
  myPort.write("\n");
  if(true){
    try {
      println("ID = " + rfidID);
      PrintWriter writer = new PrintWriter("/Users/Manav/Documents/codeforgood_part2/team-3/armband/auth_read_write/processing_pde/id.txt", "UTF-8");
      writer.println(rfidID);
      writer.close();
      
      
    } catch (UnsupportedEncodingException e) {
      println("UEE");
    } catch (IOException e) {
      println("IO");
    } catch(NumberFormatException e) {
      println("No");
    } finally {
        println("works!");
      }
      
      
    
    // Runs Java program to push the changed text file to the website
    try {
  //    run("javac Main.java");
      run("java -classpath /Users/Manav/Documents/codeforgood_part2/team-3/armband/auth_read_write/processing_pde  Main");
      
    } catch (Exception e) {
      println("Exception");
    }
  }
  
  delay(1000);

}

void printLines(String name, InputStream ins) throws Exception {
  String line = null;
  BufferedReader in = new BufferedReader(new InputStreamReader(ins));
  while ((line = in.readLine()) != null) {
    System.out.println(name + " " + line);
  }
}

void run(String command) throws Exception {
  Process pro = Runtime.getRuntime().exec(command);
  printLines(command + " stdout:", pro.getInputStream());
  printLines(command + " stderr:", pro.getErrorStream());
  pro.waitFor();
  println(command + " exitValue() " + pro.exitValue());
}