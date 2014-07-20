/*
TopCoder
Single Round Match: 149
Division: 1
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1331.
 */

import java.util.HashSet;
import java.util.Set;

public class MessageMess2 {

    public String restore(String[] dictionary, String message) {

        LetterNode dictionaryRoot = createDictionaryTree(dictionary);

        Set<String> wordsFound = findWords(dictionaryRoot, message);

        if ((wordsFound == null) || (wordsFound.size() < 1)) {
            return "IMPOSSIBLE!";
        } else if (wordsFound.size() > 1) {
            return "AMBIGUOUS!";
        } else {
            for (String s : wordsFound) {
                return s;
            }
        }

        return null;
    }

    /*
     * Creates a tree of Letter Nodes.  Each node contains a Map of letters
     * with pointers to additional LetterNodes.  Each word in the dictionary
     * can be created by following a path from the root to a leaf.
     */
    private LetterNode createDictionaryTree(String[] words) {

        LetterNode root = new LetterNode();

        for (String s : words) {

            // Start each new word from the root.
            LetterNode n = root;

            /*
             * If the current letter node does not yet have any followers of
             * the letter 'c', then create a new node below here,
             * and add it to the followers map with 'c' as the key.
             */
            for (Character c : s.toCharArray()) {
                if (n.getFollower(c) == null) {
                    n.setFollower(c, new LetterNode());
                }

                // Otherwise, just following the existing node.
                n = n.getFollower(c);
            }

            // If we're at the end of a word, mark it.
            n.isEndPoint = true;
        }

        return root;
    }

    /*
     * Attemps to find words in the dictionary by following their path
     * through the dictionary tree.
     */
    private Set<String> findWords(LetterNode root, String message) {

        Set<String> wordsFound = new HashSet<>();
        LetterNode n = root;

        char[] characters = message.toCharArray();

        for (int i = 0; i < characters.length; i++) {

            /*
             * If the LetterNode is designated as an EndPoint then we've
             * reached the end of a word.  Recursively call findWords with
             * the remainder of the message.  Also, continue down the tree at
             * we may be able to match a longer word instead.
             */
            if (n.isEndPoint) {
                String newMessage = message.substring(i);

                /*
                 * Get all the words that could be formed by the remainder of
                 * the message, and add them on to the end of this message.
                 */
                Set<String> s2 = findWords(root, newMessage);

                if (s2 != null) {
                    for (String s : s2) {
                        wordsFound.add(message.substring(0, i) + " " + s);
                    }
                }
            }

            // If we're able to follow the dictionary tree deeper, than do so.
            if (n.getFollower(characters[i]) == null) {
                return wordsFound;
            }

            n = n.getFollower(characters[i]);
        }

        if (n.isEndPoint) {
            wordsFound.add(message);
            return wordsFound;
        }

        return null;
    }

    /*
     * A node in the dictionary tree.  Notes wehter it marks the end of a
     * word, and also contains all the letters that follow to form longer
     * words.
     */
    class LetterNode {

        boolean isEndPoint = false;

        LetterNode[] followers = new LetterNode[26];

        void setFollower(Character c, LetterNode n) {
            followers[c - 'A'] = n;
        }

        LetterNode getFollower(Character c) {
            return followers[c - 'A'];
        }
    }
}
