import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by juliazhang on 10/7/17.
 */
public class HuffmanTree {
    characterFrequencyObj huffmanTree;
    HashMap<Character,String> characterCodeMap= new HashMap<>();

    public HuffmanTree(MinHeap minHeap){
        while(minHeap.size() > 1){
            characterFrequencyObj min1 = minHeap.pop();
            characterFrequencyObj min2 = minHeap.pop();
            int newNodeFrequency = min1.frequency + min2.frequency;
            characterFrequencyObj obj = new characterFrequencyObj('\u0000',newNodeFrequency,min1,min2);
            minHeap.add(obj);
        }
        huffmanTree = minHeap.pop();
    }

    public void getCodeMap(){
        StringBuilder code = new StringBuilder();
//        labelTree(huffmanTree,code);
        labelTree(huffmanTree);
//        return characterCodeMap;
    }

    public void labelTree(characterFrequencyObj huffmanTree){
        if(huffmanTree.left != null){
            huffmanTree.left.code = 0;
            labelTree(huffmanTree.left);
        }
        if(huffmanTree.right != null){
            huffmanTree.right.code = 1;
            labelTree(huffmanTree.right);
        }
    }

    public characterFrequencyObj getHuffmanTree(){
        return huffmanTree;
    }

    public void printTree(characterFrequencyObj huffmanTree){
        if(huffmanTree.left != null || huffmanTree.right != null){
            System.out.println("Character: " + huffmanTree.character + " Frequency: " + huffmanTree.frequency);
            if(huffmanTree.left != null && huffmanTree.right != null){
                printTree(huffmanTree.left);
                printTree(huffmanTree.right);
            }
            else if(huffmanTree.left != null){
                printTree(huffmanTree.left);
            }
            else{
                printTree(huffmanTree.right);
            }
        }
        else{
            System.out.println("Character: " + huffmanTree.character + " Frequency: " + huffmanTree.frequency);
        }
    }

    public void printCode(characterFrequencyObj huffmanTree){
        if(huffmanTree.left != null || huffmanTree.right != null){
            System.out.println("Character: " + huffmanTree.character + " Code: " + huffmanTree.code);
            if(huffmanTree.left != null && huffmanTree.right != null){
                printCode(huffmanTree.left);
                printCode(huffmanTree.right);
            }
            else if(huffmanTree.left != null){
                printCode(huffmanTree.left);
            }
            else{
                printCode(huffmanTree.right);
            }
        }
        else{
            System.out.println("Character: " + huffmanTree.character + " Code: " + huffmanTree.code);
        }
    }
}
