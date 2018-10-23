package org.tsrj.service.wxchat.enums;

/**
 * Created by zhongqionghua on 2018/02/08.
 *
 */
public enum WXChatUrlEnum {

    APPID("wx175113ecba466e06"),

    APP_SECRET("d0ef711f258efdc741dbdbcc89feeb36"),

    GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx175113ecba466e06&secret=d0ef711f258efdc741dbdbcc89feeb36"),
//    GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx175113ecba466e06&secret=d0ef711f258efdc741dbdbcc89feeb36"),

    SEND_TEMPLATE_MESSAGE("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN"),

    //授权用的accessToken 区别基础功能accessToken
    GET_OAUTH_ACCESS_TOKEN("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxff9a5e4eeafb35dd&secret=982aa47e9f02c50c17974445a594d8c0&code=CODE&grant_type=authorization_code"),

    GET_USER_INFO_WITH_OPEN_ID("https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN"),


    /**
     * 客服相关
     */
    CREATE_CUSTOMER_SERVICE("https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN"),

    MODIFY_CUSTOMER_SERVICE("https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN"),

    DELETE_CUSTOMER_SERVICE("https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN"),

    SET_CUSTOMER_SERVICE_HEAD_IMAGE("http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT"),

    LIST_CUSTOMER_SERVICE("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN"),

    SEND_MESSAGE_FROM_CUSTOMER_SERVICE("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN"),

    /**
     * 菜单相关
     */

    CREATE_MENU("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN"),

    QUERY_MENU("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN"),

    DELETE_MENU("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN"),





    ;

    private String url;

    public String getUrl() {
        return url;
    }

    WXChatUrlEnum(String url) {
        this.url = url;
    }
}
