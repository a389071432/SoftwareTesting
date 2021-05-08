package com.sse.software_testing.service;

/**
 * @author hq
 */
public class Triangle {
    private static final double MinV=0;
    private static final double MaxV=100;
    private static boolean comp(double a,double b){
        return Math.abs(a-b)<1e-6;
    }
    public static String getTriangleType(double a,double b,double c){
        double tmp;
        if(a>b){
            tmp=a;
            a=b;
            b=tmp;
        }
        if(b>c){
            tmp=b;
            b=c;
            c=tmp;
        }
        if(a>b){
            tmp=a;
            a=b;
            b=tmp;
        }
        if(a<=MinV||c>MaxV){
            return "数值越界";
        }
        if(a+b<c||comp(a+b,c)){
            return "不构成三角形";
        }
        if(comp(a,b)&&comp(b,c)){
            return "等边三角形";
        }
        if(comp(a,b)||comp(a,c)||comp(b,c)){
            return "等腰三角形";
        }
        return "一般三角形";
    }
}
