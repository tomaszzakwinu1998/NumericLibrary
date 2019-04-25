import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class InterpolationNewton {
    int n;


    double xtab[] = null;
    double ytab[] = null;


    public InterpolationNewton() throws IOException {

        List<String> a = java.nio.file.Files.readAllLines(Paths.get("internewtondane.txt"));
        n = Integer.parseInt(a.get(0));
        xtab = Arrays.stream(a.get(1).split("\\s")).mapToDouble(Double::parseDouble).toArray();
        ytab = Arrays.stream(a.get(2).split("\\s")).mapToDouble(Double::parseDouble).toArray();
    }

    double functionValueNewton(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) return (ytab[start]);
        if (start + 1 == end) return ((ytab[end] - ytab[start]) / (xtab[end] - xtab[start]));
        else
            return ((functionValueNewton(start + 1, end) - functionValueNewton(start, end - 1)) / (xtab[end] - xtab[start]));
    }

    double calculateNewton(double x)
    {
        if (n < 2) return 0;
        double result = ytab[0];
        for (int i = 1; i < n; ++i)
        {
            double temp = 1;
            for (int j = 0; j < i; ++j)
            {
                temp = temp * (x - xtab[j]);
            }
            result = result + functionValueNewton(0, i)*temp;
        }
        return result;
    }
    String interpolateNewton()
    {
        if (n < 2) return null;
        String result = String.valueOf(ytab[0]);
        for (int i = 1; i < n; ++i)
        {
            String temp = (" + ") + String.valueOf(functionValueNewton(0, i));
            result = result + temp;
            result = result + "0";
            for (int j = 0; j < i; ++j)
            {
                result = result + "(x - ";
                result = result + String.valueOf(xtab[j]);
                result = result + ")";
            }
        }
        return result;
    }
}