class WordDictionary {
    
    class Trie{
        Trie[] children;
        boolean isEnd;
        public Trie(){
            this.children = new Trie[26];
        }
    }
    
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new Trie();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, Trie n){
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j = 0; j < 26; j++){
                    Trie t = n.children[j];
                    String w = word.substring(i+1, word.length());
                    if(n.children[j] != null){
                        if(search(w, n.children[j])){
                            return true;
                        }
                    }
                }
                return false;
            }
            if(n.children[c-'a'] == null){
                return false;
            }
            n = n.children[c-'a'];
        }
        return n.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */