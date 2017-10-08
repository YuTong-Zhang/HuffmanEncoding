import java.util.*;

/**
 * Created by juliazhang on 10/7/17.
 */
public class MinHeap {
    public MinHeap(HashMap<Character,Integer> characterFrequencyMap){
        LinkedHashMap<Character,Integer> sortedCharacterFrequencyMap = sort(characterFrequencyMap);
        Set<Character> keySet = sortedCharacterFrequencyMap.keySet();
        for(char character:sortedCharacterFrequencyMap.keySet()){

        }
    }

    public LinkedHashMap<Character,Integer> sort(HashMap<Character,Integer> characterFrequencyMap){
        Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> e1,Map.Entry<Character, Integer> e2) {
                if(e1.getValue() < e2.getValue()){
                    return e1.getValue();
                }
                return e2.getValue();
            }
        };
        Set<Map.Entry<Character, Integer>> CFMapEntries = characterFrequencyMap.entrySet();
        List<Map.Entry<Character, Integer>> CFMapList = new ArrayList<Map.Entry<Character, Integer>>(CFMapEntries);
        Collections.sort(CFMapList,valueComparator);
        LinkedHashMap<Character, Integer> sortedCharacterFrequencyMap = new LinkedHashMap<Character, Integer>();
        for(Map.Entry<Character, Integer> entry : CFMapList){
            sortedCharacterFrequencyMap.put(entry.getKey(), entry.getValue());
        }
        return sortedCharacterFrequencyMap;
    }
}
