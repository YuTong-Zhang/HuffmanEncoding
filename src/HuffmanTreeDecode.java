import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by juliazhang on 10/20/17.
 */
public class HuffmanTreeDecode {
    characterFrequencyObj huffmanTree;

    public HuffmanTreeDecode(characterFrequencyObj huffmanTree){
        this.huffmanTree = huffmanTree;
    }

    public void decode(String decodedfilename,String encodedfilename){
        try {
            Scanner fileReader = new Scanner(encodedfilename);
            String line;
            while(fileReader.hasNextLine()){
                line = fileReader.nextLine();
                line.nextChar();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
