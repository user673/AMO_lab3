package com.natalia.lab3;

/**
 * Created by Наталя on 18.03.2018.
 */
import java.util.ArrayList;
public class lagrange {

    public static double  lagrange (double x1, int param, int n){
        double  n1 = 13.0;
        ArrayList<Double> x = new ArrayList<>();
        double b = 2/n1;
        for (int i = 0; i<=n1; i++){
            x.add(b*i);
        }
        ArrayList<Double> y1 = new ArrayList<>();
        ArrayList<Double> y2 = new ArrayList<>();
        for (int i = 0; i<=n1; i++){
            y1.add(Math.sin(x.get(i)));
            y2.add((Math.exp(Math.cos(x.get(i))))*(Math.cos(x.get(i))));
        }

        double result = 0.0;

        for (int i = 0; i <= n; i++){
            double P = 1.0;

            for (int j = 0; j <= n; j++) {
                if (j != i) {
                    P = P * (x1 - x.get(j)) / (x.get(i) - x.get(j));
                }
            }
            if (param==1){
                result =result+  P * y1.get(i);
            }
            else{
                result =result+  P * y2.get(i);
            }
        }

    return result;
    }
}








