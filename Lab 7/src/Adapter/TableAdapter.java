package Adapter;

public class TableAdapter extends Table {
    public TableAdapter(int rows, int cols) {
        super(rows, cols);
    }

    public void adaptWordsArray(WordsArray wordsArray) {
        int M = getRows(), N = getCols();
        if (wordsArray.length() == M * N) {
            String[] words = wordsArray.getWords();
            for (int i = 0; i < M; ++i) {
                for (int j = 0; j < N; ++j) {
                    setField(i, j, words[i * N + j]);
                }
            }
        }
    }
}
