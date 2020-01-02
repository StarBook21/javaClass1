import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class WordFind{
  public static void main(String args[]) throws FileNotFoundException{
    String targetString = args[0];
    String fileName = args[1];
    File file = new File(fileName);
    Scanner input = new Scanner(file);
    int lineNum = 0;
    while(input.hasNext()){
      String readIn = input.nextLine();
      lineNum++;
      if(readIn.contains(targetString)){
        int first = readIn.indexOf(targetString);
        int last = first;
        System.out.println(lineNum + " : " + first + " " + readIn);
        while(last != readIn.lastIndexOf(targetString)){
          System.out.println(lineNum + " : " + readIn.indexOf(targetString, last+1) + " " + readIn);
          last = readIn.indexOf(targetString, last+1);
      }
    }
  }
    System.out.println("End program");
}
}
