package leetcode;

import structure.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyy on 3/22/17.
 */



public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words){
        List<String> res = new ArrayList<>();
        if(words==null || words.length==0)
            return res;
        TrieNode root = new TrieNode();
        for(String word : words){
            addWord(root,word);    //construct the dictionary
        }
        for(String word : words){
            if(word.length()==0)
                continue;
            if(dfsWordSearch(root,word,0,0))
                res.add(word);
        }
        return res;

    }

    private void addWord(TrieNode root, String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.next[c-'a']==null)
                cur.next[c-'a'] = new TrieNode();
            cur = cur.next[c-'a'];
        }
        cur.isEnd=true;

    }

    private boolean dfsWordSearch(TrieNode root, String word, int index, int count){
        TrieNode cur = root;
        for(int i=index;i<word.length();i++){
            if(cur.next[word.charAt(i)-'a']==null)
                return false;
            if(cur.next[word.charAt(i)-'a'].isEnd){
                if(i==word.length()-1)
                    return count>=1;
                if(dfsWordSearch(root,word,i+1,count+1))
                    return true;
            }
            cur = cur.next[word.charAt(i)-'a'];
        }
        return false;
    }


}