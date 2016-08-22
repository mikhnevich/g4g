package misc;

/*
You are to write a program that takes a list of strings containing integers and words and returns a sorted version of
the list.
The goal is to sort this list in such a way that all words are in alphabetical order and all integers are in numerical
 order. Furthermore, if the nth element in the list is an integer it must remain an integer, and if it is a word it
 must remain a word.

Input:
The input will contain a single, possibly empty, line containing a space-separated list of strings to be sorted. Words
 will not contain spaces, will contain only the lower-case letters a-z. Integers will be in the range -999999 to 999999,
  inclusive. The line will be at most 1000 characters long.

Output:
The program must output the list of strings, sorted per the requirements above. Strings must be separated by a single
space, with no leading space at the beginning of the line or trailing space at the end of the line.

Constraints:
The code you submit must take input from stdin and produce output to stdout as specified above. No other output is
 permitted. You can assume the input will be valid. Feel free to use standard libraries to assist in sorting.

Example 1:
Input:
1
Output:
1


Example 2:
Input:
car truck bus

Output:
bus car truck

Example 3:
Input:
8 4 6 1 -2 9 5

Output:
-2 1 4 5 6 8 9

Example 4:
Input:
car truck 8 4 bus 6 1

Output:
bus car 1 4 truck 6 8

-------------------------
http://stackoverflow.com/questions/13462574/sorting-a-list-of-mixed-data
I would use two lists, sort them, but you have to remember the original ordering, a LinkedList<Boolean> is
sufficient for that task.


public String sortStringWithInts(String input){
        String[] parts = input.split("\\s");
        List<String> strings = new ArrayList<String>();
        List<Integer> ints = new ArrayList<Integer>();
        for(String part:parts){
            if(isNumber(part)){
                 ints.add(Integer.valueOf(part));
            }
            else{
                strings.add(part);
            }
        }
        Collections.sort(strings);
        Collections.sort(ints);
        return createResult(strings, ints, parts);
    }

    private String createResult(List<String> strings, List<Integer> ints, String[] parts) {
        StringBuilder result = new StringBuilder();
        for(String part:parts){
            if(isNumber(part)){
                result.append(ints.remove(0)).append(" ");
            }
            else{
                result.append(strings.remove(0)).append(" ");
            }
        }

        return result.toString();
    }

    private boolean isNumber(String part) {
        try{
            Integer.valueOf(part);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
 }
 */
public class JumbleSort {

}
