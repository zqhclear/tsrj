package org.tsrj.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RandomUtil {

	/**
	 * 随机生成数字
	 * @param min
	 * @param max
	 * @return
	 */
	public static double random(double min, double max){
		double number = new Random().nextFloat()*max;
		while(number<min || number > max){
			number = new Random().nextFloat()*max;
		}
		return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min, int max){
		int number = new Random().nextInt(max);
		while(number<min || number > max){
			number = new Random().nextInt(max);
		}
		return number;
	}
	
	public static void main(String[] args) {
		for(int i=0; i<10000;i++){
			System.out.println(random(50,88));
		}
	}
}
