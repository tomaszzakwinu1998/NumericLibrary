import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class QuadratureGauss {
    int n;
    double [] przedzial =null;
    double []pierw=null;

    public QuadratureGauss() throws IOException{
        List<String> a = java.nio.file.Files.readAllLines(Paths.get("quarGauss.txt"));
        n = Integer.parseInt(a.get(0));
        przedzial = Arrays.stream(a.get(1).split("\\s")).mapToDouble(Double::parseDouble).toArray();
        pierw = Arrays.stream(a.get(2).split("\\s")).mapToDouble(Double::parseDouble).toArray();

    }

    double funkcja(double x)
    {
        return (0.4*x*x*x*x) + (5 * x*x*x) + (-6 * x*x) + (-2 * x) + 55;
    }
    double algorithm()
    {
        double S = 0.0;
        double a = -2, b = 2, c = -1, d = 1;
        double alfa = (b - a) / (d - c);
        double beta = (a*d - b * c) / (d - c);
        for (int i = 0; i < n; i++) {

            S += przedzial[i] * funkcja(alfa*pierw[i] + beta);
        }
        return S * alfa;
    }
}
