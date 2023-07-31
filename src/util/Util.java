package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public static void readFileOp(){
        try {
            FileReader fr = new FileReader("C:\\Users\\Hp\\Documents\\test\\monteCristo.txt");
            BufferedReader br = new BufferedReader(fr);
            String str=br.readLine();

            while(str!=null){
                //System.out.println(str);
                str=br.readLine();
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int squaresum(int n)
    {
        // Iterate i from 1 and n
        // finding square of i and add to sum.
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += (i * i);
        return sum;
    }
}
