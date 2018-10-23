package org.tsrj.service.map.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.tsrj.common.amp.MapClient;
import org.tsrj.common.amp.MapConfig;
import org.tsrj.common.amp.enums.MapUrlEnums;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.utils.StringUtil;
import org.tsrj.service.map.MapService;
import org.tsrj.service.map.vo.GeoFenceVO;
import org.tsrj.service.map.vo.GeocodeVO;

import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
@Service
public class MapServiceImpl implements MapService {

    @Override
    public ResultBody getGeoCodeByAmap(GeocodeVO vo) throws Exception {
        ResultBody resultBody = new ResultBody();
        TreeMap<String, Object> paramsMap = new TreeMap<>();
        //地址,eg:同仁家园西区
        paramsMap.put("address", StringUtil.isEmpty(vo.getAddress()) ? "" : vo.getAddress());
        //所属城市，默认全国查找
        paramsMap.put("city", StringUtil.isEmpty(vo.getCity()) ? "" : vo.getCity());
        //对应开发者key
        paramsMap.put("key", MapConfig.KEY);
        String result = MapClient.buildRequest(paramsMap, MapUrlEnums.GEOCODE_GEO);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody regeoCode() {
        ResultBody resultBody = new ResultBody();
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);
        /*经纬度坐标:必填
        传入内容规则：经度在前，纬度在后，经纬度间以“,”分割，经纬度小数点后不要超过 6 位。
        如果需要解析多个经纬度的话，请用"|"进行间隔，并且将 batch 参数设置为 true，
        最多支持传入 20 对坐标点。每对点坐标之间用"|"分割。
         */
        paramMap.put("location", "");
        /*
        以下内容需要 extensions 参数为 all 时才生效。逆地理编码在进行坐标解析之后不仅可以返回地址描述，
        也可以返回经纬度附近符合限定要求的POI内容（在 extensions 字段值为 all 时才会返回POI内容）。
        设置 POI 类型参数相当于为上述操作限定要求。参数仅支持传入POI TYPECODE，可以传入多个POI TYPECODE，
        相互之间用“|”分隔。该参数在 batch 取值为 true 时不生效。获取 POI TYPECODE 可以参考POI分类码表
         */
        paramMap.put("poitype", "");   //返回附近POI类型
        paramMap.put("radius", "");  //搜索半径
        /*返回结果控制
        extensions 参数默认取值是 base，也就是返回基本地址信息；
        extensions 参数取值为 all 时会返回基本地址信息、附近 POI 内容、道路信息以及道路交叉口信息。
         */
        paramMap.put("extensions", "");
        /*
        batch 参数设置为 true 时进行批量查询操作，最多支持 20 个经纬度点进行批量地址查询操作。
        batch 参数设置为 false 时进行单点查询，此时即使传入多个经纬度也只返回第一个经纬度的地址解析查询结果。
         */
        paramMap.put("batch","");
        /*
        以下内容需要 extensions 参数为 all 时才生效。
        可选值：0，1
        当roadlevel=0时，显示所有道路
        当roadlevel=1时，过滤非主干道路，仅输出主干道路数据
         */
        paramMap.put("roadlevel", "");
        paramMap.put("output", ""); //  返回数据格式，默认json
        paramMap.put("homeorcorp", ""); //是否优化POI返回顺序
        String result = MapClient.buildRequest(paramMap, MapUrlEnums.GEOCODE_REGEO);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody placeSearch() {
        ResultBody resultBody = new ResultBody();
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);
        paramMap.put("keywords", "关键字");
        paramMap.put("types", ""); //POI类型，与关键字最少填写一个
        paramMap.put("city", "城市"); //城市中文、中文全拼、citycode、adcode如：北京/beijing/010/110000
        paramMap.put("citylimit", "");  //仅返回指定城市数据 默认false
        paramMap.put("children", "");   //是否按照层级展示子POI数据
        paramMap.put("offset", ""); //每页记录数据,强烈建议不超过25，若超过25可能造成访问报错
        paramMap.put("page", "");   //页码,最大翻页数100
        paramMap.put("building", "");   //建筑物的POI编号,传入建筑物POI编号之后，则只在该建筑物之内进行搜索
        paramMap.put("floor", "");  //搜索楼层
        paramMap.put("extensions", ""); //返回结果控制，此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。
        paramMap.put("output", ""); //  返回数据类型 默认json
        paramMap.put("callback", "");   //回调函数
        String result = MapClient.buildRequest(paramMap, MapUrlEnums.PLACE_SEARCH);
        resultBody.setData(JSONObject.toJSON(result));
        return null;
    }

    @Override
    public ResultBody searchWeather(String city, String extensions) throws Exception {
        ResultBody resultBody = new ResultBody();
        if(StringUtil.isEmpty(city) || StringUtil.isEmpty(extensions)){
            resultBody.setResMsg("参数有误，请检查参数后重试");
            return resultBody;
        }
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);
        paramMap.put("city", URLEncoder.encode(city, "UTF-8"));   //城市
        paramMap.put("extensions", extensions); //气象类型 base:返回实况天气/all:返回预报天气
        paramMap.put("output", "JSON"); //返回信息格式
        String result = MapClient.buildRequest(paramMap, MapUrlEnums.WEATHER);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody findAddressByIP(String ip) {
        ResultBody resultBody = new ResultBody();
        if(StringUtil.isEmpty(ip)){
            resultBody.setResMsg("参数有误，请检查参数后重试");
            return resultBody;
        }
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);
        paramMap.put("ip", ip);
        paramMap.put("output", "JSON");
        String result = MapClient.buildRequest(paramMap, MapUrlEnums.FIND_BY_IP);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody inputTips(String keywords, String city) {
        ResultBody resultBody = new ResultBody();
        if(StringUtil.isEmpty(keywords)){
            resultBody.setResMsg("请输入关键字");
            return resultBody;
        }
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);
        paramMap.put("keywords", keywords);
        if(StringUtil.isNotEmpty(city)){
            paramMap.put("city", city);
        }
        String result = MapClient.buildRequest(paramMap, MapUrlEnums.INPUT_TIPS);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody coordinateConvert(String locations, String coordsys) {
        ResultBody resultBody = new ResultBody();
        if(StringUtil.isEmpty(locations)){
            resultBody.setResMsg("请输入要转换的坐标点");
            return resultBody;
        }
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);
        paramMap.put("locations", locations);
        paramMap.put("coordsys", coordsys);
        paramMap.put("output", "JSON");
        String result = MapClient.buildRequest(paramMap, MapUrlEnums.COORDINATE_CONVERT);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody createGeofence(GeoFenceVO vo) {
        ResultBody resultBody = new ResultBody();
        if(StringUtil.isEmpty(vo.getName())){
            resultBody.setResMsg("请输入围栏名称");
            return resultBody;
        }
        Map<String, Object> paramMap = new TreeMap<>();
        paramMap.put("key", MapConfig.KEY);

        String result = MapClient.buildRequest(paramMap, MapUrlEnums.COORDINATE_CONVERT);
        resultBody.setData(JSONObject.toJSON(result));
        return resultBody;
    }

    @Override
    public ResultBody getGeofence() {
        return null;
    }

    @Override
    public ResultBody updateGeofence() {
        return null;
    }

    @Override
    public ResultBody deleteGeofence() {
        return null;
    }

    @Override
    public ResultBody startGeofence() {
        return null;
    }

    @Override
    public ResultBody monitoringGeoFence() {
        return null;
    }
}
