package Adapter;

public class WordsArray {
    private String[] words;

    public WordsArray(String[] words) {
        this.words = words;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public int length() {
        return words.length;
    }
}
