package com.eshop.Service;

import com.eshop.application.SalesAppService;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesServiceTest extends BaseTest {
    @Autowired
    SalesAppService salesAppService;

    @Test
    public void testQueryAll() {
        salesAppService.queryAll();
    }

    @Test
    public void testQueryGoodsBrand(){
        String goodsBrand = "Adidas";
        salesAppService.queryByGoodsBrand(goodsBrand);
    }

    @Test
    public void test(){
        double s1 = 485;
        double s2 = 513;
        double s3 = 549;
        double s4 = 577;
        double s5 = 598;
        double s6 = 618;
        double k = 6;

        double t1 = s1;
        double t2 = s1+s2;
        double t3 = s1+s2+s3;
        double t4 = s1+s2+s3+s4;
        double t5 = s1+s2+s3+s4+s5;
        double t6 = s1+s2+s3+s4+s5+s6;
//5/4 = 1.25   ad-bc
        double d = 1.25 * (Math.pow(t1+t2,2) + Math.pow(t2+t3,2) + Math.pow(t3+t4,2) + Math.pow(t4+t5,2) + Math.pow(t5+t6,2)) - Math.pow(t1/2 +t2+t3+t4+t5+t6/2,2);

        double w = 5 / d;
        double x = ((t1)/2 + t2 + t3 + t4 + t5 + (t6)/2) / d;
        double y = ((t1)/2 + t2 + t3 + t4 + t5 + (t6)/2) / d;
        double z = (Math.pow(t1+t2,2) + Math.pow(t2+t3,2) + Math.pow(t3+t4,2) + Math.pow(t4+t5,2) + Math.pow(t5+t6,2)) / (4*d);

        double a=(w * (-(t1+t2)/2) + x) * s2 + (w * (-(t2+t3)/2) + x) * s3 + (w * (-(t3+t4)/2) + x) * s4 + (w * (-(t4+t5)/2) + x) * s5 + (w * (-(t5+t6)/2) + x) * s6;
        double b=(y * (-(t1+t2)/2) + z) * s2 + (y * (-(t2+t3)/2) + z) * s3 + (y * (-(t3+t4)/2) + z) * s4 + (y * (-(t4+t5)/2) + z) * s5 + (y * (-(t5+t6)/2) + z) * s6;

        double pred = (s1 - b/a) * Math.pow(Math.E, -(a * 6)) + b/a - t6;
        System.out.println(a);
        System.out.println(b);
        System.out.println(pred);
    }
}