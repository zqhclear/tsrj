package org.tsrj.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.Random;

public class OrderNoUtil
{
    /**************************************字母区**************************************/

    /**
     * 余额充值订单前缀
     */
    public static final String C = "C";
    /**
     * 现金贷款
     */
    public static final String LOAN_CASH = "D";
    /**
     * 分期贷款
     */
    public static final String LOAN_INSTALLMENT = "F";
    /**
     * 还款
     */
    public static final String LOAN_REPAYMENT = "H";
    /**
     * 余额付
     */
    public static final String PAY_MAIN = "P";
    /**
     * 乐投订单前缀
     */
    public static final String L = "L";
    /**
     * 稳赚订单前缀
     */
    public static final String W = "W";
    /**
     * 信用付(分期)
     */
    public static final String LOAN_CREDIT = "Y";
    /**
     * 资金流水
     */
    public static final String CAPITA_FLOW = "Z";
    /**
     * 夺宝币充值
     */
    public static final String TREASURE_RECHARGE = "B";
    /**
     * 夺宝
     **/
    public static final String TREASURE = "A";

    public static final String CHANGE_CARD = "CHCA";



    /**************************************数字区**************************************/

    /**
     * 交易充值
     */
    public static final String TRADE_RECHARGE = "7";

    /**
     * 提现订单
     */
    public static final String WITHDRAW = "9";

    /**
     * 爱家宝订单前缀
     */
    public static final String AI_JIA_BAO = "8";   

    /**
     * 稳赚订单号
     */
    public static String generateWenZhuanOrderNo(Long memberId)
    {
        return W + getOrderRandomNumber(3) + getMemberId(memberId);
    }

    /**
     * 乐投订单号
     */
    public static String generateLeTouOrderNo(Long memberId)
    {
        return L + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 余额充值订单号
     */
    public static String generateRechargeOrderNo(Long memberId)
    {
        return C + getOrderRandomNumber(3) + getMemberId(memberId);
    }

    /**
     * 提现订单
     */
    public static String generateWithdrawOrderNo(Long memberId)
    {
        return WITHDRAW + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 爱家宝
     */
    public static String generateAiJiaBaoOrderNo(Long memberId)
    {
        return AI_JIA_BAO + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 交易充值订单号
     */
    public static String generateRechargeOrderNoFromTrade(Long memberId)
    {
        return TRADE_RECHARGE + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 更换银行卡订单号
     */
    public static String generateChangeCardTxNo(Long memberId) {
        return CHANGE_CARD + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 现金借款订单号
     */
    public static String generateLoanCashOrderNoFromTrade(Long memberId)
    {
        return LOAN_CASH + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 分期消费订单号
     */
    public static String generateLoanInstallmentOrderNoFromTrade(Long memberId)
    {
        return LOAN_INSTALLMENT + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 信用付(分期)订单号
     */
    public static String generateCreditInstallmentOrderNoFromTrade(Long memberId)
    {
        return LOAN_CREDIT + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 信用还款订单号
     */
    public static String generateLoanRepaymentmentOrderNoFromTrade(Long memberId)
    {
        return LOAN_REPAYMENT + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 余额支付订单号
     */
    public static String generatePayMainOrderNo(Long memberId)
    {
        return PAY_MAIN + getOrderRandomNumber(3) + getMemberId(memberId);
    }


    /**
     * 资金流水订单号
     */
    public static String generateCapitaFlowOrderNo(Long memberId)
    {
        return CAPITA_FLOW + getOrderRandomNumber(2) + getMemberId(memberId);
    }

    /**
     * 夺宝币充值
     */
    public static String generateTreasureRechargeOrderNo(Long memberId)
    {
        return TREASURE_RECHARGE + getOrderRandomNumber(3) + getMemberId(memberId);
    }

    /**
     * 夺宝
     */
    public static String generateTreasureOrderNo(Long memberId)
    {
        return TREASURE + getOrderRandomNumber(3) + getMemberId(memberId);
    }

    /**
     * 生成订单随机数字
     */
    private static String getOrderRandomNumber(int randomNum)
    {
        DateTime time = new DateTime();
        StringBuilder sb = new StringBuilder();
        sb.append(getYmd(time));
        int random = 9;
        if(randomNum == 2)
        {
            random = 99;
        }
        else if(randomNum == 3)
        {
            random = 999;
        }
        else if(randomNum == 4)
        {
            random = 9999;
        }else if(randomNum == 5)
        {
            random = 99999;
        }
        String v = getRandomNumberOnMillisOfDay(time) + StringUtils.leftPad(new Random().nextInt(random) + "",
                randomNum, "0");
        sb.append(StrUtils.shuffle(v));
        return sb.toString();
    }

    private static String getCurrentTimeOfDay()
    {
        DateTime time = new DateTime();
        return getYmd(time) + getCurrentSecondOfDay(time);
    }

    /**
     * 年月日（2020年前年只取一位）
     */
    private static String getYmd(final DateTime time)
    {
        return (time.getYearOfCentury() - 10) + appendZero(time.getMonthOfYear()) + appendZero(time.getDayOfMonth());
    }

    /**
     * 补零
     */
    private static String appendZero(int num)
    {
        if(num < 10)
        {
            return "0" + num;
        }
        return num + "";
    }

    /**
     * 当天的秒数
     */
    private static String getCurrentSecondOfDay(final DateTime time)
    {
        int millis = time.getMillisOfDay() / 10000;
        return StringUtils.leftPad(millis + "", 5, "0");
    }

    /**
     * 当天的秒数+随机数字
     */
    private static String getRandomNumberOnMillisOfDay(final DateTime time)
    {
        int millis = (time.getMillisOfDay() / 10000) + new Random().nextInt(10000);
        return StringUtils.leftPad(millis + "", 5, "0");
    }

    /**
     * 获取用户的后4位
     */
    private static String getMemberId(Long memberId)
    {
        if(memberId == null)
        {
            return "0000";
        }
        String memberIdStr = memberId.toString();
        if(memberId < 1000){
        	memberId = Math.abs(memberId);
        	return StringUtils.leftPad(memberId.toString(), 4, "0");
        }
        return memberIdStr.substring(memberIdStr.length() - 4, memberIdStr.length());
    }

    /**
     * 生成交易号
     *
     * @param str4 订单后四位数字（一般是用户的ID后四位）
     */
    public static String generateTransSerialnorNo(String str4)
    {
        DateTime time = new DateTime();
        String random = time.getMillis() + StringUtils.leftPad(new Random().nextInt(99) + "", 2, "0");
        return StrUtils.shuffle(random) + str4;
    }

    /**
     * 生成爱家宝合同名
     *
     * @param datestr 爱家宝合同的日期标识，如“20160123”
     * @return 爱家宝合同名
     */
    public static String generateAijiabaoContractName(String datestr)
    {
        String random = StringUtils.leftPad(new Random().nextInt(999) + "", 3, "0");
        return "FC" + StrUtils.shuffle(random) + "A" + datestr;
    }

    /**
     * 法大大推送交易ID
     *
     * @param contractId
     * @return
     */
    public static String generateFadadaPushContractTransactionId(String contractId)
    {
        String random = StringUtils.leftPad(new Random().nextInt(10) + "", 3, "0");
        return contractId + "T" + random;
    }
    
    /**
     * 积分
     */
    public static String generatePointsOrderNo(Long memberId)
    {
        return "1" + getOrderRandomNumber(2) + getMemberId(memberId);
    }
    
    /**
     * 存管业务请求订单号
     * @param busId
     * @return      
     * String
     */
    public static String generateRequestOrderNo(int busId){
    	return "S" +StringUtils.leftPad(busId+"", 3, "0") + getOrderRandomNumber(5) ;
    }

	/** 
	 * 
	 * @param memberId
	 * @param orderStartWith 
	 * @return      
	 * String      
	 */  
	public static String generateOrderNo(Long memberId, String orderStartWith) {
		return orderStartWith + getOrderRandomNumber(3) + getMemberId(memberId);
	}
    
    
}
