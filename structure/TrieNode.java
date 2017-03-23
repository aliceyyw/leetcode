package structure;

/**
 * Created by wyy on 3/17/17.
 */
public class TrieNode {
    public TrieNode[] next;    // capacity: R = the total number of symbols
    public boolean isEnd;
    public TrieNode(){
        next = new TrieNode[26];
        isEnd = false;
    }
    
}
