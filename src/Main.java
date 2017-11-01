import java.util.HashMap;

/**
 * Created by juliazhang on 10/7/17.
 */
public class Main {
    public static void main(String[] args){
        HashMap<Character,Integer> characterFrequencyMap = new HashMap<>();
        characterFrequencyMap.put('a',5);
        characterFrequencyMap.put('b',10);
        characterFrequencyMap.put('c',8);
        MinHeap minHeap = new MinHeap(characterFrequencyMap);
        HuffmanTreeEncode huffmanTree = new HuffmanTreeEncode(minHeap);
        huffmanTree.printTree(huffmanTree.huffmanTree);
        huffmanTree.getCodeMap();
        huffmanTree.printCode(huffmanTree.huffmanTree);
    }
}
