package org.tsrj.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EarningUtil {

	private static final BigDecimal year365 = new BigDecimal(365);
	
	/**
	 * 稳赚总收益
	 * @param totalAmount
	 * @param days
	 * @param yearRate
	 * @return
	 */
	public static BigDecimal getWenZhuanDailyEarning(BigDecimal totalAmount, int days, BigDecimal yearRate){
		return (getDailyEarning(totalAmount, yearRate).multiply(new BigDecimal(days))).setScale(2, RoundingMode.DOWN);
	}
	
	
	/**
	 * 稳赚日收益
	 * @param totalAmount
	 * @param yearRate
	 * @return
	 */
	public static BigDecimal getDailyEarning(BigDecimal totalAmount,BigDecimal yearRate){
		return totalAmount.multiply(yearRate.divide(new BigDecimal("100")).divide(year365, 10, BigDecimal.ROUND_DOWN));
	}
	
	public static void main(String[] args) {
//		630.60+203.05
//		203.05
		Long tableNo = Tools.generateTableNoByMemberId(1000008L);
		System.out.println(tableNo);
		System.out.println(getDailyEarning(new BigDecimal(4603451.35), new BigDecimal(5)).setScale(2,RoundingMode.DOWN));
	}
}
