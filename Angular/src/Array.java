import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array {

	public static List<Integer> highestSumList(int[][] input) {
        if (input == null || input.length == 0)
        {
            return null;
        }
        int len = input.length;
        ArrayList<ArrayList<Integer>> paths= new  ArrayList<>();
        int[] sum = new int[len];
        // initial = 0
        for (int i = 0; i < len; ++i)
        {
            paths.add(new ArrayList<Integer>());
        }
        paths.get(0).add(input[0][0]);
        for (int r = 1; r < len; ++r)
        {
            ArrayList<ArrayList<Integer>> tempPaths= new  ArrayList<>();
            // for the last element for each row, only from input[r - 1][r - 1].
            sum[r] += sum[r - 1] + input[r][r];
            ArrayList<Integer> curPath = new ArrayList<>(paths.get(r - 1));
            curPath.add(input[r][r]);
            tempPaths.add(curPath);
 
            for (int c = r - 1; c > 0; --c)
            {
                // we can use maxSum(c-1, c)
                if (sum[c - 1]> sum[c])
                {
                    // max sum so far from input[r - 1][c - 1]
                    sum[c] = sum[c - 1] + input[r][c];
                    curPath = new ArrayList<>(paths.get(c - 1));
                }
                else
                {
                    sum[c] = sum[c] + input[r][c];
                    curPath = new ArrayList<>(paths.get(c));
                }
                curPath.add(input[r][c]);
                tempPaths.add(curPath);
            }
 
            // column = 0, no choice just use above element
            sum[0] += input[r][0];
            curPath = new ArrayList<>(paths.get(0));
            curPath.add(input[r][0]);
            tempPaths.add(curPath);
 
            // reverse because we process from right to left
            Collections.reverse(tempPaths);
            printPathSoFar(tempPaths);
            paths = tempPaths;
        }
        // get the max
        int max = input[len - 1][0];
        int maxIndex = 0;
        for (int i = 1; i < len; ++i)
        {
            if (max < input[len - 1][i])
            {
                max = input[len - 1][i];
                maxIndex = i;
            }
        }
        return paths.get(maxIndex);
    }
 
    public static void  printPathSoFar(ArrayList<ArrayList<Integer>> paths)
    {
        for (ArrayList<Integer> path : paths)
        {
            System.out.println(path);
        }
        System.out.println("-------------");
 
    }
 
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 0},
                {2, 5, 0, 0},
                {3, 2, 1, 0},
                {1, 3, 2, 1}};
 
        List<Integer> result = highestSumList(input);
        System.out.println(result);
        
        String a="";
        System.out.println(a+"abcd");
    }
	
}
