package Week4;

import java.io.*;

class TrieNode {
    private TrieNode[] links;
    private boolean isTerminal;
    public TrieNode () {
        links = new TrieNode[26];
        isTerminal = false;
    }
    public boolean isPresent(char ch) {
        return links[ch - 'a'] != null;
    }
    public boolean isTerminal() {
        return isTerminal;
    }
    public void makeItTerminal() {
        isTerminal = true;
    }
    public TrieNode getNode(char ch) {
        return links[ch - 'a'];
    }
    public void setTrie(char ch, TrieNode child) {
        links[ch-'a'] = child;
    }
}

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.isPresent(ch)) {
                temp.setTrie(ch, new TrieNode());
            }
            temp = temp.getNode(ch);
        }
        temp.makeItTerminal();
    }

    public boolean search(String word) {
        TrieNode temp = root;
        if (temp == null) {
            return false;
        }
        for (char ch : word.toCharArray()) {
            if (!temp.isPresent(ch)) {
                return false;
            }
            temp = temp.getNode(ch);
        }
        return temp.isTerminal();
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (!temp.isPresent(ch)) {
                return false;
            }
            temp = temp.getNode(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("");
        boolean param_2 = obj.search("");
        boolean param_3 = obj.startsWith("");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */