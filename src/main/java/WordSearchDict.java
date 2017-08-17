/**
 * date 17/8/17
 *
 * @author 柏霜
 */
public class WordSearchDict {

    public static class DictNode {

        public char c;
        public DictNode[] children;

        public DictNode() {

            children = new DictNode[26];
        }

        public boolean hasChildren() {

            for (DictNode node : children) {
                if (node != null) {
                    return true;
                }
            }
            return false;
        }

    }

    public static class WordDictionary {

        private DictNode root = new DictNode();

        // Adds a word into the data structure.
        public void addWord(String word) {

            char[] charArray = word.toCharArray();
            DictNode current = root;
            for (int i = 0; i < charArray.length; i++) {

                char c = charArray[i];
                int index = c - 'a';
                if (current.children[index] == null) {
                    DictNode node = new DictNode();
                    node.c = c;
                    current.children[index] = node;
                }
                current = current.children[index];
            }
        }

        /**
         * 从fromNode开始，匹配charArray从fromIndex开始的字符串
         */
        private boolean searchWord(DictNode fromNode, char[] charArray, int fromIndex) {

            if (fromIndex >= charArray.length) {
                return false;
            }
            char c = charArray[fromIndex];
            if (c != '.' && c != fromNode.c) {
                return false;
            }

            fromIndex++;
            if (!fromNode.hasChildren() && fromIndex >= charArray.length) {
                return true;
            }
            for (DictNode node : fromNode.children) {
                if (node == null) {
                    continue;
                }
                if (searchWord(node, charArray, fromIndex)) {
                    return true;
                }
            }
            return false;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {

            char[] charArray = word.toCharArray();
            for (DictNode node : this.root.children) {
                if(node == null) {
                    continue;
                }
                if (searchWord(node, charArray, 0)) {
                    return true;
                }
            }
            return false;
        }
    }



    public static void main(String[] args) {

        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));

    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
}
