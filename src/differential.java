public class differential {

        public static double funkcja(double x, double y) {
            return x * x + y;
        }

        public void eulerMethod(double a, double b, double h, double y0) {

            double y;
            double x = a;
            int i = 0;
            y = y0;
            System.out.println("Iter\tyi\txi\t");
            do {
                System.out.println(i + "\t" + y + "\t" + x + "\t");
                y += h * funkcja(x, y);
                x += h;
                i++;
            } while (x <= b);
        }
        public void heunMethod(double a, double b, double h, double y0) {

            double y;
            double x = a;
            int i = 0;
            y = y0;
            //System.out.println("Iter\tyi\txi\t");
            do {
                //System.out.println(i + "\t" + y + "\t" + x + "\t");
                y += 0.5*h * (funkcja(x, y) + funkcja(x+h,y+h*funkcja(x,y)));
                x += h;
                i++;
            } while (x <= b);
        }

        public void modEulerMethod(double a, double b, double h, double y0) {

            double y;
            double x = a;
            int i = 0;
            y = y0;
            System.out.println("Iter\tyi\txi\t");
            do {
                System.out.println(i + "\t" + y + "\t" + x + "\t");
                y += h*funkcja(x+0.5*h,y+0.5*h*funkcja(x,y));
                x += h;
                i++;
            } while (x <= b);
        }
    }

