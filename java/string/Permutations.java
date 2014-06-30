package string;

import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static List<String> getPermutations(String s) {
        if (s.length() == 1) {
            return Arrays.asList(s);
        }
        List<String> soFar = getPermutations(s.substring(1));
        List<String> result = new LinkedList<>();
        char ch = s.charAt(0);
        for (String s1 : soFar) {
            for (int i = 0; i <= s1.length(); i++) {
                result.add(s1.substring(0, i) + ch + s1.substring(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = getPermutations("астчлоак");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println(result.size());
    }
}
