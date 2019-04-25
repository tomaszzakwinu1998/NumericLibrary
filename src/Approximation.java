import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Approximation {

    int n;//number of node
    double[] xtab;//coordinates of node
    double[] ytab;//coordinates of node

    public Approximation() throws IOException {


        List<String> a = java.nio.file.Files.readAllLines(Paths.get("approxdane.txt"));
        n = Integer.parseInt(a.get(0));
        xtab = Arrays.stream(a.get(1).split("\\s")).mapToDouble(Double::parseDouble).toArray();
        ytab = Arrays.stream(a.get(2).split("\\s")).mapToDouble(Double::parseDouble).toArray();

    }


    double legendrePolynomial(double k, double x) {
        if (k == 0) return 1;
        if (k == 1) return x;
        return ((2 * k - 1) / k * x * legendrePolynomial(k - 1, x) - (k - 1) / k * legendrePolynomial(k - 2, x));
    }

    double dotProduct(double xtab[], double ytab[], int b) {
        double sum = 0;
        for (int i = 0; i < b; i++) {
            sum += xtab[i] * ytab[i];
        }
        return sum;
    }



    double algorithm(double xtab[], double ytab[], double x, int b) throws FileNotFoundException {
        double h = 0;
        for (int i = 0; i < b; i++) {
            double WL[] = new double[b];
            for (int j = 0; j < b; j++) {
                WL[j] = legendrePolynomial(i, xtab[j]);
            }
            h += dotProduct(ytab, WL, b) / dotProduct(WL, WL, b) * legendrePolynomial(i, x);
        }

        return h;

    }

}
