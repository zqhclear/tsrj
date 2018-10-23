package org.tsrj.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * 公式计算工具类
 * 
 * @author Administrator
 * 
 */
public class FormulaUtil {

	private static final BigDecimal OVERDUE_RATE = new BigDecimal(0.01); // 分期逾期费率

	private static final BigDecimal WEDDING_OVERDUE_RATE = new BigDecimal(0.001); // 婚宴垫付逾期费率

	private static final BigDecimal WEDDING_SERVICE_FEE_RATE = new BigDecimal(0.0005); // 婚宴垫付平台服务费率

	/**
	 * 格式化年化利率
	 * 
	 * @param rate
	 * @return
	 */
	public static String formatAnnualizedRate(BigDecimal rate) {
		if (rate == null) {
			return "";
		}
		String rateFormat = new DecimalFormat("###.00").format(rate);
		return rateFormat + "%";
	}

	/**
	 * 预期收益
	 * 
	 * @param availableAmount
	 * @return
	 */
	public static String formatAvailableAmount(BigDecimal availableAmount) {
		if (availableAmount == null) {
			return "";
		}
		return new DecimalFormat("###.##").format(availableAmount);
	}

	/**
	 * 格式化BigDecimal
	 * 
	 * @param format
	 *            格式
	 * @param value
	 *            值
	 * @return
	 */
	public static String formatBigDecimal(String format, Object value) {
		if (value == null) {
			return "";
		}
		return new DecimalFormat(format).format(value);
	}

	/**
	 * 设置小数位数
	 * 
	 * @param scale
	 *            小数位数
	 * @param value
	 * @return
	 */
	public static BigDecimal setBigDecimalScale(int scale, Object value) {
		if (value == null || value instanceof BigDecimal == false) {
			return BigDecimal.ZERO;
		}
		return ((BigDecimal) value).setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 计算逾期金额 当期剩余应还金额*1%*逾期天数
	 * 
	 * @param amount
	 *            总金额
	 * @param payTime
	 * @return
	 */
	public static BigDecimal getOverdueAmount(BigDecimal amount, Date payTime) {
		if (payTime == null) {
			return BigDecimal.ZERO;
		}
		int day = 0;
		Date currentDate = DateUtils.getCurrentDate();
		if (currentDate.after(payTime)) {
			day = DateUtils.daysBetween(DateUtils.formatDate(payTime, DateUtils.YYYY_MM_DD), DateUtils.formatDate(currentDate, DateUtils.YYYY_MM_DD));
		}
		if (day <= 0) {
			return BigDecimal.ZERO;
		}
		return (amount.multiply(OVERDUE_RATE).multiply(new BigDecimal(day))).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 计算婚宴垫付逾期金额 本金*日息千分之一
	 * 
	 * @param amount
	 *            总金额
	 * @param payTime
	 * @return
	 */
	public static BigDecimal getWeddingOverdueAmount(BigDecimal amount, Date payTime) {
		if (payTime == null) {
			return BigDecimal.ZERO;
		}
		int day = 0;
		Date currentDate = DateUtils.getCurrentDate();
		if (currentDate.after(payTime)) {
			day = DateUtils.daysBetween(DateUtils.formatDate(payTime, DateUtils.YYYY_MM_DD), DateUtils.formatDate(currentDate, DateUtils.YYYY_MM_DD));
		}
		if (day <= 0) {
			return BigDecimal.ZERO;
		}
		return (amount.multiply(WEDDING_OVERDUE_RATE).multiply(new BigDecimal(day))).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 计算婚宴垫付平台服务费 800元 + 本金 * 日息万分之五
	 * 
	 * @param amount
	 *            总金额
	 * @param payTime
	 * @return
	 */
	public static BigDecimal getWeddingServiceFee(BigDecimal serviceFee, BigDecimal amount, Date payTime) {
		if (payTime == null) {
			return BigDecimal.ZERO;
		}
		int day = 0;
		Date currentDate = DateUtils.getCurrentDate();
		if (currentDate.after(payTime)) {
			day = DateUtils.daysBetween(DateUtils.formatDate(payTime, DateUtils.YYYY_MM_DD), DateUtils.formatDate(currentDate, DateUtils.YYYY_MM_DD));
		}
		if (day <= 0) {
			day = 1;// 当日算
		} else if (day > 15) {// 15日后，只按15计息
			day = 15;
		}
		return serviceFee.add(amount.multiply(WEDDING_SERVICE_FEE_RATE).multiply(new BigDecimal(day))).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * 计算分期每期应还金额
	 * 
	 * @param totalAmount
	 *            总金额
	 * @param period
	 *            期数
	 * @param rate
	 *            费率
	 * @return BigDecimal[] 每期金额，每期费用，每期总金额
	 */
	public static BigDecimal[] getPeroidAmount(BigDecimal totalAmount, int period, BigDecimal rate) {
		BigDecimal perAmount = totalAmount.divide(new BigDecimal(period), 2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal perFeeAmount = totalAmount.multiply(rate).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal[] rs = new BigDecimal[3];
		rs[0] = perAmount;
		rs[1] = perFeeAmount;
		rs[2] = perAmount.add(perFeeAmount).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return rs;
	}

	/**
	 * 年利率转秒利率,单利
	 * 
	 * @param rateOfYear
	 * @return
	 */
	public static BigDecimal getRateOfSecond(BigDecimal rateOfYear) {
		BigDecimal rateOfSecond = rateOfYear.divide(new BigDecimal(100)).divide(new BigDecimal(365 * 24 * 60 * 60), 12, RoundingMode.DOWN);
		return rateOfSecond;
	}

	/**
	 * @param principal
	 *            本金
	 * 
	 * @param rateOfYear
	 *            年利率
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 */
	/**
	 * @param principal
	 * @param rateOfYear
	 * @param start
	 * @param end
	 * @return
	 */
	public static BigDecimal getEarnings(BigDecimal principal, BigDecimal rateOfYear, Date start, Date end) {
		BigDecimal rateOfSecond = principal.multiply(getRateOfSecond(rateOfYear).multiply(new BigDecimal(Seconds.secondsBetween(new DateTime(start), new DateTime(end)).getSeconds())));
		return rateOfSecond;
	}

	/**
	 * 
	 * @return
	 */
	public static BigDecimal getBriberyMoney(int base) {
		int data = 0;
		int max = base <= 0 ? 2 : 100;
//		int max =100;

		int next = new Random().nextInt(max);
		int[] amount = {};
		int[] probability = {};
		List<Integer> list = new ArrayList<>();
		if(base <= 0){
			amount = new int[] { 123, 218};
			probability = new int[] { 80,20};
//			return new BigDecimal("11.11");
		}else if (base >= 0 && base <= 3) {
//			amount = new int[] { 1111, 1314 };
//			data = amount[next];
			amount = new int[] { 365, 520, 666, 888,1111};
			probability = new int[] { 20,20,20,20,20};
		} else if (base > 3 && base <= 10) {
			amount = new int[] { 666, 888, 999, 1111,1314};
			probability = new int[] { 20,20,20,20,20};
		} else if (base > 10 && base <= 20) {
			amount = new int[] { 1111, 1588, 1818, 2016};
			probability = new int[] { 30, 30, 30, 10};
		} else if (base >= 21) {
			amount = new int[] { 1818,1588, 2016, 2588,10000 };
			probability = new int[] { 25, 25, 25, 24,1 };
		}

		for (int i = 0; i < probability.length; i++) {
			for (int j = 0; j < probability[i]; j++) {
				list.add(amount[i]);
			}
		}

		if (list.size() > 0) {
			data = list.get(next);
		}

		return new BigDecimal(data).divide(new BigDecimal(100));
	}

	/**
	 * 婚宴服务费用
	 * @param serviceFee
	 * @param amount
	 * @param payTime
	 * @return
	 */
	public static BigDecimal getWeddingServiceFeeAmount(BigDecimal serviceFee, BigDecimal amount, Date payTime) {
		if (payTime == null) {
			return BigDecimal.ZERO;
		}
		int day = 0;
		Date currentDate = DateUtils.getCurrentDate();
		if (currentDate.after(payTime)) {
			day = DateUtils.daysBetween(DateUtils.formatDate(payTime, DateUtils.YYYY_MM_DD), DateUtils.formatDate(currentDate, DateUtils.YYYY_MM_DD));
		}
		if (day <= 0) {
			day = 1;// 当日算
		}
		return serviceFee.add(amount.multiply(WEDDING_SERVICE_FEE_RATE).multiply(new BigDecimal(day))).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	
	public static void main(String[] args) {
		/*
		 * BigDecimal rateOfSecond = getRateOfSecond(new BigDecimal(8.18));
		 * String dateStr = "2015-11-08 10:42:39"; String memberId =
		 * "1000000001"; double yesAmount = 2.24; double accAmount = 3.39;
		 * DateTime begin = DateTime.parse(dateStr,
		 * DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")); DateTime end =
		 * begin.millisOfDay().withMaximumValue(); int second =
		 * Seconds.secondsBetween(begin, end).getSeconds(); double amount =
		 * rateOfSecond.doubleValue() * 9000 * second;
		 * System.out.println(memberId); System.out.println("昨日收益：" + (yesAmount
		 * - amount));
		 */
		// System.out.println("累计收益：" + (accAmount - amount));
//		for(int i=0;i<100;i++){
////			System.out.println(getBriberyMoney(22));
//		}
//		BigDecimal totalAmount = new BigDecimal("1000");
//		BigDecimal rate = new BigDecimal("0.85");
//		BigDecimal a[] = getPeroidAmount(totalAmount, 1, rate);
//		System.out.println(a[0]+" "+a[1]+" "+a[2]);
		
//		本金*年化利率*分期月数/12
//		本金*分期月利率*分期月数-应还利息
//		BigDecimal yearRate = new BigDecimal("0.0818");
//		BigDecimal rate = new BigDecimal("0.990");
//		BigDecimal v = totalAmount.multiply(yearRate).divide(new BigDecimal(12),2, RoundingMode.DOWN);
//		BigDecimal v1 = totalAmount.multiply(rate).divide(new BigDecimal(100)).subtract(v);
//		System.out.println(v+"  "+v1);
		
//		BigDecimal v = totalAmount.multiply(yearRate).divide(new BigDecimal(365),2, RoundingMode.DOWN);
//		BigDecimal v1 = totalAmount.multiply(new BigDecimal("0.0005")).subtract(v).setScale(2, RoundingMode.DOWN);
//		int day = 30;
//		BigDecimal rate = new BigDecimal("0.9");
//		BigDecimal v = totalAmount.multiply(yearRate).divide(new BigDecimal(365),6, RoundingMode.DOWN).multiply(new BigDecimal(day));
//		BigDecimal v1 = totalAmount.multiply(new BigDecimal("0.0005")).multiply(new BigDecimal(day)).subtract(v).setScale(2, RoundingMode.DOWN);
//		System.out.println(v+"  "+v1);
		
//		BigDecimal rate1 = new BigDecimal("0.82");
//		BigDecimal a[] = FormulaUtil.getPeroidAmount(new BigDecimal("864"), 12, rate1);
//		System.out.println(a[0]+"  "+a[1]+"  "+a[2]);
		
		Date start = DateUtils.getDateWithDateStr("2016-07-21 00:00:00", "yyyy-MM-dd HH:mm:ss");
//		Date end = DateUtils.getDateFromString("2016-07-21 06:46:47", "yyyy-MM-dd HH:mm:ss");
		Date end = DateUtils.getDateWithDateStr("2016-07-21 23:59:59", "yyyy-MM-dd HH:mm:ss");
		System.out.println(getEarnings(new BigDecimal(45), new BigDecimal(7.08), start, end));
	}
}
