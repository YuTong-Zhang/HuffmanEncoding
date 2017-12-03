import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by juliazhang on 10/20/17.
 */
public class HuffmanTreeEncode {
    characterFrequencyObj huffmanTree;

    public HuffmanTreeEncode(characterFrequencyObj huffmanTree){
        this.huffmanTree = huffmanTree;
    }

    public void encode(String filename,String encodedfilename){
        try {
            StringBuilder totalSB = new StringBuilder();
            Scanner fileReader = new Scanner(new FileReader(filename));
            String line;
            while(fileReader.hasNextLine()){
                line = fileReader.nextLine();
                System.out.println("line: " + line);
                char[] myChar = line.toCharArray();
                for(char item:myChar){
                    StringBuilder codeSB = new StringBuilder();
                    System.out.println("Character: " + item);
                    String code = findCode(huffmanTree,item,codeSB);
                    totalSB.append(code);
                }
            }
            Writer wr = new FileWriter(encodedfilename);
            System.out.println(totalSB.toString());
            wr.write(totalSB.toString());
            wr.flush();
            wr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String findCode(characterFrequencyObj huffmanTree, char character, StringBuilder code){
        System.out.println("Looking at: " + huffmanTree.character + " " + huffmanTree.frequency);
        System.out.println("State of code: " + code.toString());
        if (huffmanTree.character == character) {
            System.out.println("Matches! " + huffmanTree.character + " " + huffmanTree.frequency);
            System.out.println("State of code: " + code.toString());
            return code.toString();
        }
        if(huffmanTree.left != null && huffmanTree.right != null) {
            System.out.println("State of code1: " + code.toString());
            code.append(huffmanTree.left.code);
            System.out.println("State of code2: " + code.toString());
            String left = findCode(huffmanTree.left, character, code);
            System.out.println("State of code3: " + code.toString());
            code.deleteCharAt(code.length() - 1);
            System.out.println("State of code4: " + code.toString());
            code.append(huffmanTree.right.code);
            System.out.println("State of code5: " + code.toString());
            String right = findCode(huffmanTree.right, character, code);
            System.out.println("State of code6: " + code.toString());
            code.deleteCharAt(code.length() - 1);
            System.out.println("State of code7: " + code.toString());
            if(left != ""){
                System.out.println("LEFT: " + huffmanTree.character + " " + huffmanTree.frequency + " " + code.toString());
                return left;
            }else if(right != ""){
                System.out.println("RIGHT: " + huffmanTree.character + " " + huffmanTree.frequency + " " + code.toString());
                return right;
            }
        }
        return "";
    }
}

