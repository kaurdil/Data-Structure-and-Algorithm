import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
         int sum=0;int neg_sum=0;
      int new_j;
      int result=-1;
      int neg_res=0;
      for(int i=0;i<4;i++)
     {
        for(int j=0;j<4;j++)
      {
        
           sum+=arr[i][j]+arr[i+2][j]+arr[i][j+2]+arr[i+2][j+2];
           new_j=(j+(j+2))/2;
           sum+=arr[i][new_j]+arr[i+1][new_j]+arr[i+2][new_j];
           if(sum>result){
                result=sum;
              }
           else{
               if(sum<0)
                {
                  if(sum>neg_res || neg_res==0)
                    {neg_res=sum;}
                }
           }
            sum=0;
        
      }

    }
    if(result>0)
      { return result;}
    else if(neg_res<0 && result!=0)
    {
        return neg_res;
    }
    else
       {
         return result;
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
