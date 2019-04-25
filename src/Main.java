import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;

public class Main {


    public static void main(String[] args) throws FileSystemNotFoundException {
        /*
        try {
            Interpolation x = new Interpolation();
            x.algorithm();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Approximation a = new Approximation();
            System.out.println(a.algorithm(a.xtab,a.ytab,0.4,a.n));

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            InterpolationNewton x=new InterpolationNewton();
            System.out.println("y(x) = " + x.interpolateNewton());
            System.out.println("y(1) = "+x.calculateNewton(0.2));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Quadrature a=new Quadrature();
            System.out.println(a.calculateQ(a.xtab, a.ytab1, a.n));
            System.out.println(a.calculateQ(a.xtab, a.ytab2, a.n));
            System.out.println(a.liczNewtonCotes(a.tabWsp, -2, 2, 50));
            System.out.println(a.liczNewtonCotes(a.tabWsp2, -2, 2, 50));
            System.out.println(a.calculateSimpson(a.tabWsp, -2, 2, 50));
            System.out.println(a.calculateSimpson(a.tabWsp2, -2, 2, 50));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            QuadratureGauss a=new QuadratureGauss();
            System.out.println(a.algorithm());
        } catch (IOException e) {
            e.printStackTrace();
        }*/


            differential a = new differential();
            a.eulerMethod(293,1200,0.1,0.1);
            //a.heunMethod(0,1,0.1,0.1);
            //a.modEulerMethod(0,1,0.1,0.1);

    }




    }

