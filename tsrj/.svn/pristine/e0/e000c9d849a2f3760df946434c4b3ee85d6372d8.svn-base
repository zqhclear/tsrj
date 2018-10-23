package org.tsrj.common.amp.enums;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
public enum MapUrlEnums {
    /**
     * 地理编码：将详细的结构化地址转换为高德经纬度坐标。且支持对地标性名胜景区、建筑物名称解析为高德经纬度坐标。
     * 结构化地址举例：北京市朝阳区阜通东大街6号转换后经纬度：116.480881,39.989410
     * 地标性建筑举例：天安门转换后经纬度：116.397499,39.908722
     *
     * 逆地理编码：将经纬度转换为详细结构化的地址，且返回附近周边的POI、AOI信息。
     */
    GEOCODE_GEO("http://restapi.amap.com/v3/geocode/geo?", "地理编码API服务地址", MethodType.GET.getType()),
    GEOCODE_REGEO("http://restapi.amap.com/v3/geocode/regeo?", "逆地理编码API服务地址", MethodType.GET.getType()),

    /**
     * 距离/路线规划接口
     */
    DIRECTION_WALK("http://restapi.amap.com/v3/direction/walking?", "步行路线规划", MethodType.GET.getType()),
    DIRECTION_BUS("http://restapi.amap.com/v3/direction/transit/integrated?", "公交/火车路线规划", MethodType.GET.getType()),
    DIRECTION_DRIVE("http://restapi.amap.com/v3/direction/driving?", "驾车路线规划", MethodType.GET.getType()),
    DIRECTION_BIKE("http://restapi.amap.com/v4/direction/bicycling?", "骑行路径规划", MethodType.GET.getType()),
    DIRECTION_TRUCK("http://restapi.amap.com/v4/direction/truck?parameters", "货车路径规划", MethodType.GET.getType()),
    DIRECTION_DISTANCE("http://restapi.amap.com/v3/distance?parameters", "距离测量", MethodType.GET.getType()),

    DISTRICT("http://restapi.amap.com/v3/config/district?", "行政区查询", MethodType.GET.getType()),

    //adcode可以从地理编码接口中获得
    WEATHER("http://restapi.amap.com/v3/weather/weatherInfo?", "天气查询", MethodType.GET.getType()),
    PLACE_SEARCH("http://restapi.amap.com/v3/place/text?", "搜索",MethodType.GET.getType()),
    FIND_BY_IP("http://restapi.amap.com/v3/ip?", "ip定位", MethodType.GET.getType()),
    INPUT_TIPS("http://restapi.amap.com/v3/assistant/inputtips?", "输入提示", MethodType.GET.getType()),
    COORDINATE_CONVERT("http://restapi.amap.com/v3/assistant/coordinate/convert?", "坐标转换，将变得坐标转换成高德坐标", MethodType.GET.getType()),
    //创建围栏:POST;查询围栏:GET;更新围栏:PATCH;围栏启动&停止:PATCH;删除围栏:DELETE;围栏设备监控:GET;
    CREATE_GEOFENCE("http://restapi.amap.com/v4/geofence/meta", "创建地理围栏", MethodType.POST.getType()),
    GET_GEOFENCE("http://restapi.amap.com/v4/geofence/meta?", "查看地理围栏", MethodType.GET.getType()),
    //也可以post请求
    UPDATE_GEOFENCE("http://restapi.amap.com/v4/geofence/meta?", "更新地理围栏", MethodType.PATCH.getType()),
    //也可以是post请求
    START_GEOFENCE("http://restapi.amap.com/v4/geofence/meta", "启动/体质地理围栏", MethodType.PATCH.getType()),
    DELETE_GEOFENCE("http://restapi.amap.com/v4/geofence/meta?", "删除地理围栏", MethodType.DELETE.getType()),
    MONITORING_GEOFENCE("http://restapi.amap.com/v4/geofence/status", "监控地理围栏", MethodType.GET.getType())
    ;



    private String url;
    private String desc;
    private String methodType;
    private boolean isSig;

    MapUrlEnums(String url, String desc, String methodType) {
        this.url = url;
        this.desc = desc;
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
