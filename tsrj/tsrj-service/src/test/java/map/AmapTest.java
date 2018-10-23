package map;

import com.alibaba.fastjson.JSONObject;
import org.tsrj.common.amp.MapConfig;
import org.tsrj.common.amp.enums.MapUrlEnums;
import org.tsrj.common.amp.Md5ForAMap;
import org.tsrj.common.httpclient.HttpClientUtil;
import org.tsrj.common.httpclient.httpclient.builder.HCB;
import org.tsrj.common.httpclient.httpclient.common.HttpConfig;
import org.tsrj.common.utils.BeanCopyUtil;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
public class AmapTest {

    String cityZhongCai = "120.213842,30.209403";
    String home = "120.076811,30.326518";

    public static void main(String[] args) throws  Exception{
        TreeMap<String, Object> paramsMap = new TreeMap<>();
        paramsMap.put("key", MapConfig.KEY);
        //地理编码
//        paramsMap.put("address", "同仁家园");
//        paramsMap.put("city", "杭州市");
//        String wholeUrl = Md5ForAMap.initUrlWithGet(paramsMap, MapUrlEnums.GEOCODE_GEO);

        //逆地理编码
//        paramsMap.put("location", "120.079248,30.326664");
//        String wholeUrlUrl = Md5ForAMap.initUrl(paramsMap, MapUrlEnums.GEOCODE_REGEO);

        //搜索位置
//        paramsMap.put("keywords", "美食");
//        paramsMap.put("city", "330100");
//        String wholeUrl = Md5ForAMap.initUrl(paramsMap, MapUrlEnums.PLACE_SEARCH);



        //创建地理围栏


        Map json = new TreeMap();
        json.put("key", MapConfig.KEY);
        json.put("name", "first_rail");
        json.put("center", "115.672126,38.817129");
        json.put("radius", "1000");
        String sig = Md5ForAMap.getMd5StandardString(json, MapConfig.SIG_KEY);
        json.put("sig", sig);
        System.out.println(sig);
        System.out.println(JSONObject.toJSONString(json));


        String wholeUrl = MapUrlEnums.CREATE_GEOFENCE.getUrl() +"?key="+MapConfig.KEY;
        System.out.println(wholeUrl);
        String result = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom().timeout(20000).build()).url(wholeUrl).json(JSONObject.toJSONString(json)));
        System.out.println(result);

    }
}
