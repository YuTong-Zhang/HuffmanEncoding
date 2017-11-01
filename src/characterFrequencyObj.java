/**
 * Created by juliazhang on 10/8/17.
 */
public class characterFrequencyObj {
    char character;
    int frequency;
    characterFrequencyObj left;
    characterFrequencyObj right;
    int code;
    public characterFrequencyObj(char character, int frequency){
        this.character = character;
        this.frequency = frequency;
        left = null;
        right = null;
    }
    public characterFrequencyObj(char character, int frequency,characterFrequencyObj left, characterFrequencyObj right){
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
