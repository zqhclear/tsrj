package org.tsrj.service.map;

import com.alibaba.fastjson.JSONObject;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.service.map.vo.GeoFenceVO;
import org.tsrj.service.map.vo.GeocodeVO;

import java.util.Map;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
public interface MapService {

    ResultBody getGeoCodeByAmap(GeocodeVO vo) throws Exception;

    ResultBody regeoCode();

    ResultBody placeSearch();

    ResultBody searchWeather(String city, String extensions)throws Exception;

    ResultBody findAddressByIP(String ip);

    ResultBody inputTips(String keywords, String city);

    ResultBody coordinateConvert(String locations, String coordsys);

    ResultBody createGeofence(GeoFenceVO vo);

    ResultBody getGeofence();

    ResultBody updateGeofence();

    ResultBody deleteGeofence();

    ResultBody startGeofence();

    ResultBody monitoringGeoFence();
}
