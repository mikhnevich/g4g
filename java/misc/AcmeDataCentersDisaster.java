package misc;

/*
Oh no! Disaster has struck some of ACME's redundant data centers. The administrators have managed to restore backups,
 but some data sets are still missing from some data centers. Fortunately, every data set can be found at least once
 in one or more of the data centers. However, before ACME can resume normal operations, it needs to ensure that each
 data center has a copy of every data set.
Your goal is to help ACME resume normal operations as quickly as possible by writing a program to synchronize data sets
 between data centers using as few copies as possible.

Input:
The first line of input will contain an integer between 0 and 999999 inclusive, representing the number of data
centers. Following that will be one line of input for each data center with a space-separated list of data set ids
 currently present at that data center. Data set ids are each an integer between 1 and 999999, inclusive. Each line
 will be at most 1000 characters long.

A data center with no data sets is represented with a blank line. Data set ids are not necessarily consecutive.
The list of data sets will not be in any particular order.

Output: The program must output an optimal data set copy strategy to ensure that every data center has a copy of
every data set. Output one line for every copy instruction. A copy instruction is of the form
<data-set-id> <from> <to>,
where <data-set-id> is the data set id, <from> is the index of the data center the data set will be copied
from (1 = the first data center), and <to> is the index of the data center to copy the data set to. When there are
no more copy instructions, the program must output the word "done" on a line by itself.

There is often more than one correct output for a given input, and any
output that satisfies the requirements is valid.

Constraints: The code you submit must take input from stdin and produce output to stdout as specified above.
No other output is permitted. You can assume the input will be valid.

Example 1:
Input:
4
1 3 4
1 2 3
1 3
1 4 2

One Possible Correct Output:
2 2 1
4 1 2
2 2 3
4 4 3
3 1 4
done


Example 2:
Input:
2
1 2
2 1

Output:
done

Example 3:
Input:
3
1 3 4 5 7
1 3
2

One Possible Correct Output:
2 3 2
2 3 1
1 1 3
4 1 2
5 1 3
5 3 2
4 2 3
3 1 3
7 1 2
7 1 3
Done


------------
// https://github.com/rajanmalhotra/Code-Samples/blob/master/twosigma/DataCopier.java

package twosigma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DataCopier {

    public static void main(String[] args){

        int i=1;
        int noOfDataCenters=0;

		// Create a map to store the mapping of which data set is present in which data centers.
        // Key = DataSetId
        // Value = List of DataCenters where the DataSetId is present
        //
        Map<Integer, ArrayList<Integer>> dataSets = new HashMap<Integer, ArrayList<Integer>>();

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try{
            noOfDataCenters = Integer.parseInt(bufferRead.readLine());
        }catch(IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }

        while(i <= noOfDataCenters){
            try{
                String s = bufferRead.readLine();
                String delimiters = new String(" ");
                StringTokenizer tokenizer = new StringTokenizer(s, delimiters, false);
                while (tokenizer.hasMoreTokens()) {
                    int num = Integer.parseInt(tokenizer.nextToken());
                    ArrayList<Integer> list = dataSets.get(num);
                    if(list!=null){
                        list.add(i);
                    }else{
                        list = new ArrayList<Integer>();
                        list.add(i);
                    }
                    dataSets.put(num, list);
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.exit(0);
            }
            i++;
        }

		// read from the Map
        System.out.println();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : dataSets.entrySet()){
            int dataSetId = entry.getKey();
            ArrayList<Integer> dataCenterIds = entry.getValue();

            for(int j=1 ; j<=noOfDataCenters; j++){
                if(!dataCenterIds.contains(j)){
					// This means that the data set is not present in the data center and
                    //hence we need to copy the data set
                    //
                    System.out.println(dataSetId + " " + dataCenterIds.get(0) + " " + j);
                }
            }
        }

		// Complete the copying operation
        System.out.println("done");
    }
}
 */
public class AcmeDataCentersDisaster {
}
