import Adapter.TableAdapter;
import Adapter.WordsArray;
import Proxy.Proxy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TableAdapter tableAdapter = new TableAdapter(2, 3);
        WordsArray wordsArray = new WordsArray(new String[]{"1", "2", "3", "4", "5", "6"});
        tableAdapter.adaptWordsArray(wordsArray);
        System.out.println(tableAdapter);

        Proxy proxy = new Proxy();
        Integer result = proxy.request("Hello, world!");
        System.out.println(result);
        proxy.request("Hello, world!");
        System.out.println(result);
    }
}