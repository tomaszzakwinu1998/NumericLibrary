import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class Quadrature {
    int n;
    double xtab[]=null;
    double ytab1[]=null;
    double ytab2[]=null;
    double tabWsp[] = { 0.4, 5, -6, -2, 55 };
    double tabWsp2[] = { 0.4, 5, -6, -2, 1 };
    public Quadrature() throws IOException {

        List<String> a = java.nio.file.Files.readAllLines(Paths.get("kwadane.txt"));
        n = Integer.parseInt(a.get(0));
        xtab = Arrays.stream(a.get(1).split("\\s")).mapToDouble(Double::parseDouble).toArray();
        ytab1=new double[n];
        ytab2=new double[n];
        for (int i = 0; i < n; i++) {
            ytab1[i] = naturalneHorner(tabWsp, 4, xtab[i]);
            ytab2[i] = naturalneHorner(tabWsp2, 4, xtab[i]);
        }
    }

    double naturalneHorner(double tab[], int n, double x) {
        if (n == 0) return tab[n];
        return naturalneHorner(tab, n - 1, x) * x + tab[n];
    }

    double calculateQ(double [] xtab, double[] ytab1, int n) {
        double q = 0;
        for (int i = 0; i < n - 1; i++) {
            q += abs((xtab[i + 1] - xtab[i]) / 2 * ytab1[i] + (xtab[i + 1] - xtab[i]) / 2 * ytab1[i + 1]);
        }
        return q;
    }


    double liczNewtonCotes(double []tabWsp,double poczatek, double koniec, int iloscPrzedzialow) {
        double tabx[] = new double[iloscPrzedzialow+1];
        double taby[] = new double[iloscPrzedzialow+1];
        double skok = (koniec - poczatek) / iloscPrzedzialow;
        for (int i = 0; i < iloscPrzedzialow+1; i++) {
            tabx[i] = poczatek + i*skok;
            taby[i] = naturalneHorner(tabWsp, 4, tabx[i]);
        }
        return calculateQ(tabx, taby, iloscPrzedzialow+1);

    }

    double calculateSimpson(double[] tabWsp, double poczatek, double koniec, int iloscPrzedzialow) {
        double tabx[] = new double[iloscPrzedzialow+1];
        double taby[] = new double[iloscPrzedzialow+1];
        double skok = (koniec - poczatek) / iloscPrzedzialow;
        for (int i = 0; i < iloscPrzedzialow+1; i++) {
            tabx[i] = poczatek + i*skok;
            taby[i] = naturalneHorner(tabWsp, 4, tabx[i]);
        }
        double wynik = 0;

        for (int i = 0; i < iloscPrzedzialow - 1; i+=2) {
            wynik += abs((tabx[i + 2] - tabx[i]) / 6 * (taby[i] + 4 * taby[i+1] + taby[i + 2]));
        }
        return wynik;
    }
}
