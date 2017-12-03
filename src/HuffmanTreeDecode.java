import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
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
            Scanner fileReader = new Scanner(new FileReader(encodedfilename));
            String line;
            HashMap<Character,Integer> characterIntegerHashMap = new HashMap<>();
            int count = 0;
            while(fileReader.hasNextLine()){
                line = fileReader.nextLine();
                char[] myChar = line.toCharArray();
                StringBuilder decodedString = new StringBuilder();
                decodeResult result = new decodeResult();
                result.setCharacter('\u0000');
                result.setPointer(0);
                while(result.getPointer() != myChar.length) {
                    result = decodeLine(myChar, huffmanTree, result.getPointer());
                    System.out.println("raw system pointer: " + result.getPointer());
                    System.out.println("system pointer: " + result.getPointer());
                    decodedString.append(result.getCharacter());
                }
//                System.out.println(decodedString);
                Writer wr = new FileWriter(decodedfilename);
                wr.write(decodedString.toString());
                wr.write(System.getProperty( "line.separator" ));
                wr.flush();
                wr.close();
                count = count + 1;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public decodeResult decodeLine(char[] myChar, characterFrequencyObj htree, int pointer){
        System.out.println("pointer: " + pointer);
        int item = Character.getNumericValue(myChar[pointer]);
        System.out.println("value: "+ item);
        if(item == 1){
            pointer = pointer + 1;
            if(htree.right.character != '\u0000'){
                System.out.println(htree.right.character);
                decodeResult result = new decodeResult();
                result.setCharacter(htree.right.character);
                result.setPointer(pointer);
                return result;
            }
            else{
                System.out.println("null");
                return decodeLine(myChar,htree.right,pointer);
            }
        }else{
            pointer = pointer + 1;
            if(htree.left.character != '\u0000'){
                System.out.println(htree.left.character);
                decodeResult result = new decodeResult();
                result.setCharacter(htree.left.character);
                result.setPointer(pointer);
                return result;
            }
            else{
                System.out.println("null");
                return decodeLine(myChar,htree.left,pointer);
            }
        }
    }

    public void decodeLine(char[] myChar, StringBuilder decodedString, characterFrequencyObj htree, characterFrequencyObj treePointer, int pointer){
        characterFrequencyObj tree;
//        System.out.println("Decoded string: "+ decodedString.toString());
        if(myChar.length == pointer){
            return;
        }
        int item = Character.getNumericValue(myChar[pointer]);
        if(treePointer == null){
            tree = htree;
        }
        else{
            tree = treePointer;
        }
//        System.out.println("pointer: "+ pointer);
//        System.out.println("item: "+ item);
//        System.out.println("char val: "+ myChar[pointer]);
        if(item == 1){
            pointer = pointer + 1;
//            System.out.println("char: " + tree.right.character);
            if(tree.right.character != '\u0000'){
//                System.out.println("DOes not == null");
                decodedString.append(tree.right.character);
                decodeLine(myChar,decodedString,htree,null,pointer);
            }
            else{
//                System.out.println("null");
                decodeLine(myChar,decodedString,htree,tree.right,pointer);
            }
        }else{
            pointer = pointer + 1;
//            System.out.println("char: " + tree.right.character);
            if(tree.left.character != '\u0000'){
//                System.out.println("DOes not == null");
                decodedString.append(tree.left.character);
                decodeLine(myChar,decodedString,htree,null,pointer);
            }
            else{
//                System.out.println("null");
                decodeLine(myChar,decodedString,htree,tree.left,pointer);
            }
        }
    }

}
