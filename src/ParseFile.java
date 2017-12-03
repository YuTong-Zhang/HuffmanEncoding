import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by juliazhang on 10/20/17.
 */
public class ParseFile {

    public HashMap<Character,Integer> decode(String filename){
        HashMap<Character,Integer> characterIntegerHashMap = new HashMap<>();
        try {
            Scanner fileReader = new Scanner(new FileReader(filename));
            String line;
            while(fileReader.hasNextLine()){
                line = fileReader.nextLine();
                char[] myChar = line.toCharArray();
                for(char item:myChar){
                    if (!characterIntegerHashMap.containsKey(item)){
                        characterIntegerHashMap.put(item,1);
                    }
                    else{
                        int value = characterIntegerHashMap.get(item);
                        characterIntegerHashMap.put(item,value+1);
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return characterIntegerHashMap;
    }
}
