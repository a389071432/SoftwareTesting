package com.sse.software_testing.service;

/**
 * @author hq
 */
public class Computer {
        private static int max_main=70;
	private static int max_monitor=80;
	private static int max_external=90;
	private static int price_main=25;
	private static int price_monitor=30;
	private static int price_external=45;
	
	public static double calcu_commission(int cnt_main,int cnt_monitor,int cnt_external){
		if(cnt_main<0||cnt_main>max_main||cnt_monitor<0||cnt_monitor>max_monitor||cnt_external<0||cnt_external>max_external)
			return -1;
		double saled=cnt_main*price_main+cnt_price*price_monitor+cnt_external*price_external;
		double ans=-1;
		if(saled<=1000)
			ans=saled*0.1;
		else if(saled>1000&&saled<=1800)
			ans=saled*0.15;
		else if(saled>1800)
			ans=saled*0.2;
		return ans;
	}
}
