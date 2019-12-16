
import java.io.*;

public class AnagramDecoder {
    public static StringTable test = new StringTable();

    public static void main(String[] args){

        readFile(args[0]);

        System.out.println("unscrambling...");

        unscramble("", args[1]);

    }

    public static String unscramble(String prefix, String letters) {

        if(letters.length()== 0 && test.contains((prefix))){

            System.out.println("possible word: " + prefix);

        }
        if(letters.length()==0) return prefix;
        else{

            //take first letter of letters and add to prefix
                unscramble(prefix+letters.charAt(0), letters.substring(1,letters.length()));

           //take middle letters
            for(int i = 1; i<letters.length()-1; i++){
                //System.out.println("-----debug--");
                unscramble(prefix+letters.charAt(i),letters.substring(0,i)+letters.substring(i+1));
            }

            //take last letter of letters and add to prefix
                unscramble(prefix+letters.charAt(letters.length()-1),letters.substring(0,letters.length()-1));

        }

        return "";
    }

    public static void readFile(String fileName){

        // Open the file
        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                //System.out.println(strLine);
                test.insert(strLine);

               // System.out.println(test.contains(strLine));
                if(!test.contains(strLine)) System.out.println(strLine);
            }

//Close the input stream
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
 //       catch (FileNotFoundException e){
   //         System.out.println("FILE NOT FOUND");
     //   }
    }

}
