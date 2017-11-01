import java.util.*;

/**
 * Created by juliazhang on 10/7/17.
 */
public class MinHeap {
    PriorityQueue<characterFrequencyObj> minHeap;

    public MinHeap(HashMap<Character,Integer> characterFrequencyMap) {
        minHeap = createHeap(characterFrequencyMap);
    }

    public PriorityQueue<characterFrequencyObj> createHeap(HashMap<Character,Integer> characterFrequencyMap){
        Comparator<characterFrequencyObj> valueComparator = new Comparator<characterFrequencyObj>(){
            @Override
            public int compare(characterFrequencyObj e1,characterFrequencyObj e2) {
                if(e1.frequency < e2.frequency){
                    return -1;
                }
                return 1;
            }
        };
        PriorityQueue<characterFrequencyObj> minHeap = new PriorityQueue<characterFrequencyObj>(valueComparator);
        for(char character:characterFrequencyMap.keySet()){
            characterFrequencyObj obj = new characterFrequencyObj(character,characterFrequencyMap.get(character));
            minHeap.add(obj);
        }
        return minHeap;
    }

    public void add(characterFrequencyObj obj){
        minHeap.add(obj);
    }

    public characterFrequencyObj pop(){
        return minHeap.poll();
    }

    public int size(){
        return minHeap.size();
    }
}
