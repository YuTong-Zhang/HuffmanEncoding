import java.util.HashMap;

/**
 * Created by juliazhang on 10/7/17.
 */
public class Main {
    public static void main(String[] args){
        ParseFile parser = new ParseFile();
        HashMap<Character,Integer> characterFrequencyMap = parser.decode("test.txt");
        MinHeap minHeap = new MinHeap(characterFrequencyMap);
        HuffmanTree huffmanTree = new HuffmanTree(minHeap);
        huffmanTree.getCodeMap();
        huffmanTree.printCode(huffmanTree.huffmanTree);
        characterFrequencyObj HT = huffmanTree.getHuffmanTree();
        HuffmanTreeEncode encoder = new HuffmanTreeEncode(HT);
        encoder.encode("test.txt","finished.txt");
        huffmanTree.printTree(huffmanTree.huffmanTree);
        HuffmanTreeDecode decoder = new HuffmanTreeDecode(HT);
        decoder.decode("decoded.txt","finished.txt");
    }
}
