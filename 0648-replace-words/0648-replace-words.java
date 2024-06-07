class Solution {
    class Trie{
        Trie[] child;
        boolean isWord;

        public Trie(){
            this.child = new Trie[26];
            this.isWord = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Trie root = new Trie();
        // add dictionary in Trie
        for(String str : dictionary){
            Trie node = root;
            for(char c : str.toCharArray()){
                if(node.child[c-'a'] == null){
                    node.child[c-'a'] = new Trie();
                }
                node = node.child[c-'a'];
            }
            node.isWord = true;
        }

        StringBuilder res = new StringBuilder();
        // check all words starts with trie
        for(String word : words){
            boolean isFound = false;
            StringBuilder sb = new StringBuilder();
            Trie node = root;
            for(char c : word.toCharArray()){
                if(node.child[c-'a'] != null){
                    sb.append(c);
                    node = node.child[c-'a'];
                    if(node.isWord){
                        isFound = true;
                        break;
                    }
                }else{
                    break;
                }
            }
            if(isFound){
                res.append(sb);
            }else{
                res.append(word);
            }
            res.append(" ");
        }
        return res.toString().substring(0, res.length()-1);
    }
}