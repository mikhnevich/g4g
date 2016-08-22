package hackerrank;

import java.util.*;

/*

*/
public class LongestStringChain {

    private static class Tuple {
        public final int level;
        public final String word;

        Tuple(int level, String word) {
            this.level = level;
            this.word = word;
        }
    }

    static int longestChainIterative(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        int result = 0;
        Map<String, Integer> cache = new HashMap<>();
        List<Tuple> toProcess = new LinkedList<>();

        int wordIndex = 1;
        toProcess.add(new Tuple(1, words[0]));

        while (!toProcess.isEmpty()) {
            Tuple current = toProcess.remove(0);
            String word = current.word;
            // skip short words. no need to process them - we won't get any better result than we already have
            // we'll process them only if current.level > 1, i.e. they are part of another longer word.
            if ((current.level == 1 && word.length() > result) || (current.level > 1)) {

                if (current.level > result) {
                    result = current.level;
                }
                if (!cache.containsKey(word)) {
                    for (int i = 0; i < word.length(); i++) {
                        String newWord = word.substring(0, i) + word.substring(i + 1);
                        if (wordsSet.contains(newWord)) {
                            toProcess.add(new Tuple(current.level + 1, newWord));
                        }
                    }
                } else {
                    int cached = cache.get(word);
                    if (cached > result) {
                        result = cached;
                    }
                }
            }
            // adding next word from the list to process
            if (toProcess.isEmpty() && (wordIndex < words.length)) {
                toProcess.add(new Tuple(1, words[wordIndex]));
                wordIndex++;
            }
        }

        return result;
    }


    static int longestChain(String[] words) {
        // assuming words[] doesn't contain null elements
        if (words == null || words.length == 0) {
            return 0;
        }
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        int result = 1;
        Map<String, Integer> cache = new HashMap<>();
        for (String w : words) {
            // no need to process shorter words - we won't get any better result than we already have
            if (w.length() > result) {
                int x = longestChain(w, wordsSet, cache);
                if (x > result) {
                    result = x;
                }
            }
        }
        return result;
    }

    private static int longestChain(String word, Set<String> words, Map<String, Integer> cache) {
        int result = 1;
        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);
            if (words.contains(newWord)) {
                int x = 1 + longestChain(newWord, words, cache);
                if (x > result) {
                    result = x;
                }
            }
        }
        cache.put(word, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestChainIterative(new String[]{"bca", "a", "b", "ba", "bca", "bda", "bdca"}));
    }

}
