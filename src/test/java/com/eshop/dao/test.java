package com.eshop.dao;

public class test {
    public void test(int s1, int s2, int s3, int s4, int s5, int s6, int k){
        double t1 = s1;
        double t2 = s1+s2;
        double t3 = s1+s2+s3;
        double t4 = s1+s2+s3+s4;
        double t5 = s1+s2+s3+s4+s5;
        double t6 = s1+s2+s3+s4+s5+s6;
/*
double[][] BT =  { {-(t1+t2)/2, -(t2+t3)/2, -(t3+t4)/2, -(t4+t5)/2, -(t5+t6)/2},
				   {1, 1, 1, 1, 1} };

double[][] B = { {-(t1+t2)/2, 1},
			 	 {-(t2+t3)/2, 1},
				 {-(t3+t4)/2, 1},
				 {-(t4+t5)/2, 1},
				 {-(t5+t6)/2, 1} };

double[][] K={ ( (Math.pow(t1+t2) + Math.pow(t2+t3) + Math.pow(t3+t4) + Math.pow(t4+t5) + Math.pow(t5+t6))/4), -((t1)/2 + t2 +t3 + t4 + t5 + (t6)/2)},
			   { -((t1)/2 + t2 +t3 + t4 + t5 + (t6)/2), 5} };
*/
//5/4 = 1.25   ad-bc
        double d = 1.25 * (Math.pow(t1+t2,2) + Math.pow(t2+t3,2) + Math.pow(t3+t4,2) + Math.pow(t4+t5,2) + Math.pow(t5+t6,2)) - (t1/2 +t2+t3+t4+t5+t6/2);
/*
//(BT*B)-1
double[][] KN = { {5/d, ((t1)/2 + t2 +t3 + t4 + t5 + (t6)/2) / d},
        {((t1)/2 + t2 +t3 + t4 + t5 + (t6)/2) / d, (Math.pow(t1+t2) + Math.pow(t2+t3) + Math.pow(t3+t4) + Math.pow(t4+t5) + Math.pow(t5+t6))/(4*d)} };
*/
        double w = 5 / d;
        double x = ((t1)/2 + t2 + t3 + t4 + t5 + (t6)/2) / d;
        double y = ((t1)/2 + t2 + t3 + t4 + t5 + (t6)/2) / d;
        double z = (Math.pow(t1+t2,2) + Math.pow(t2+t3,2) + Math.pow(t3+t4,2) + Math.pow(t4+t5,2) + Math.pow(t5+t6,2)) / (4*d);
/*
double[][] TEMP1 ={ { w * (-(t1+t2)/2) + x, w * (-(t2+t3)/2) + x, w * (-(t3+t4)/2) + x, w * (-(t4+t5)/2) + x, w * (-(t5+t6)/2) + x },
                    { y * (-(t1+t2)/2) + z, y * (-(t2+t3)/2) + z, y * (-(t3+t4)/2) + z, y * (-(t4+t5)/2) + z, y * (-(t5+t6)/2) + z } };
*/
        double a=(w * (-(t1+t2)/2) + x) * s2 + (w * (-(t2+t3)/2) + x) * s3 + (w * (-(t3+t4)/2) + x) * s4 + (w * (-(t4+t5)/2) + x) * s5 + (w * (-(t5+t6)/2) + x) * s6;
        double b=(y * (-(t1+t2)/2) + z) * s2 + (y * (-(t2+t3)/2) + z) * s3 + (y * (-(t3+t4)/2) + z) * s4 + (y * (-(t4+t5)/2) + z) * s5 + (y * (-(t5+t6)/2) + z) * s6;

        double pred = (s1 - b/a) * Math.pow(Math.E, -(a * k)) + b/a;

    }
}