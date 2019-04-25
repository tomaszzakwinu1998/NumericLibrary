import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;


public class Interpolation {
    int n;//     number of node
    double x; //argument
    double xtab[]; // coordinates of nodes
    double ytab[]; // coordinates of nodes

    float result;

    public Interpolation() throws IOException {

        List<String> a = java.nio.file.Files.readAllLines(Paths.get("interdane.txt"));
        n = Integer.parseInt(a.get(0));
        x = Double.parseDouble(a.get(1));
        xtab = Arrays.stream(a.get(2).split("\\s")).mapToDouble(Double::parseDouble).toArray();
        ytab = Arrays.stream(a.get(3).split("\\s")).mapToDouble(Double::parseDouble).toArray();
    }
    float algorithm(){
        for (int i=0; i<n; i++)
        {
            // Compute individual terms of above formula
            double term = ytab[i];
            for (int j=0;j<n;j++)
            {
                if (j!=i)
                    term = term*(x - xtab[j])/(xtab[i] - xtab[j]);
            }

            // Add current term to result
            result += term;
        }

        System.out.println(result);
        return result;
    }
}

