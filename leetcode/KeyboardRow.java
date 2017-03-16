package leetcode;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wyy on 2/8/17.
 */
public class KeyboardRow {
    private ArrayList<String> allwords;
    private char row1[] = {'e','i','o','p','q','r','t','u','w','y'};
    private char row2[] = {'a','d','f','g','h','j','k','l','s'};
    private char row3[] = {'b','c','m','n','v','x','z'};

    private String[] keyboard ={"eiopqrtuwy","adfghjkls","bcmnvxz"};

    public KeyboardRow(String[] x){
        allwords = new ArrayList<String>();
        for(String e:x){
            allwords.add(e);
        }
    }

    private boolean isOneRow(String word){
        boolean result = true;
        char first = Character.toLowerCase(word.charAt(0));   //first是大写,先转成小写
        int row=0;
        if(Arrays.binarySearch(keyboard[0].toCharArray(),first)>=0)
            row=0;
        else if(Arrays.binarySearch(keyboard[1].toCharArray(),first)>=0)
            row=1;
        else if(Arrays.binarySearch(keyboard[2].toCharArray(),first)>=0)
            row=2;
        for(int i=1;i<word.length();i++){
            if(Arrays.binarySearch(keyboard[row].toCharArray(),Character.toLowerCase(word.charAt(i)))<0){
                return false;
            }
        }
        return result;
    }

    public String[] findWords() {
        ArrayList<String> result = new ArrayList<String>();

        for(String word:allwords){
            if(isOneRow(word))
                result.add(word);
        }
        String[] finallist = new String[result.size()];
        finallist = result.toArray(finallist);

        return finallist;
    }

}