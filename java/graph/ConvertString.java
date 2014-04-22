package graph;

/**
 * Given 2 strings str1 and str2. What is the efficient way to navigate from str1 to str2?
 *
 * The constraints are
 * i) a string can be changed to another string by changing only one character.
 * ii) all the intermediate strings must be present in dictionary.
 * If not possible, return “not possible to navigate from str1 to str2″.
 * (pre-processing is allowed and enough memory is available).
 *
 * for example: str1 = feel and str2 = pelt,
 * then the navigation is feel -> fell -> felt -> pelt (Hint: Graph)
 *
 */
public class ConvertString {
    // build map word -> graph node
    // iterate through all words and build graph connections
    // O(n^2)
    // find shortest path in the graph between 2 words.
}
