package org.tsrj.api.controller.amap;

import org.apache.http.protocol.HTTP;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.common.amp.enums.CoordsysTypeEnum;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.service.map.MapService;
import org.tsrj.service.map.vo.GeoFenceVO;
import org.tsrj.service.map.vo.GeocodeVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/8
 */
@RestController
@RequestMapping(value = "/mapApi", method = RequestMethod.POST)
public class MapController {

    @Resource
    private MapService mapService;

    /**
     * 地理编码
     *
     * @param request
     * @return
     */
    @RequestMapping("/geoCode")
    public ResultBody geoCode(HttpServletRequest request, GeocodeVO vo) throws Exception {
        return mapService.getGeoCodeByAmap(vo);
    }

    /**
     * 逆地理编码
     *
     * @param request
     * @return
     */
    @RequestMapping("/regeoCode")
    public ResultBody regeoCode(HttpServletRequest request) {
        return mapService.regeoCode();
    }


    /**
     * 搜索地址
     *
     * @param request
     * @return
     */
    @RequestMapping("/placeSearch")
    public ResultBody placeSearch(HttpServletRequest request) {
        return mapService.placeSearch();
    }

    /**
     * 搜索天气
     *
     * @param request
     * @return
     */
    @RequestMapping("/searchWeather")
    public ResultBody searchWeather(HttpServletRequest request) throws Exception {
        String city = ServletRequestUtils.getStringParameter(request, "city", "");
        //默认为实况天气
        String extensions = ServletRequestUtils.getStringParameter(request, "extensions", "base");
        return mapService.searchWeather(city, extensions);
    }

    /**
     * ip定位
     *
     * @param request
     * @return
     */
    @RequestMapping("/findAddressByIP")
    public ResultBody findAddressByIP(HttpServletRequest request) {
        String ip = ServletRequestUtils.getStringParameter(request, "ip", "");
        return mapService.findAddressByIP(ip);
    }

    /**
     * 输入框提示功能
     *
     * @param request
     * @return
     */
    @RequestMapping("/inputTips")
    public ResultBody inputTips(HttpServletRequest request) {
        String keywords = ServletRequestUtils.getStringParameter(request, "keywords", "");
        String city = ServletRequestUtils.getStringParameter(request, "city", "");
        return mapService.inputTips(keywords, city);
    }

    /**
     * 坐标转换
     *
     * @param request
     * @return
     */
    @RequestMapping("/coordinateConvert")
    public ResultBody coordinateConvert(HttpServletRequest request) {
        ResultBody resultBody = new ResultBody();
        String locations = ServletRequestUtils.getStringParameter(request, "locations", "");
        String coordsys = ServletRequestUtils.getStringParameter(request, "coordsys", "autonavi");
        if (!CoordsysTypeEnum.AUTONAVI.isSuccess(coordsys)) {
            resultBody.setResMsg("原坐标系参数错误，请检查后重试。");
            return resultBody;
        }
        return mapService.coordinateConvert(locations, coordsys);
    }

    /**
     * 创建地理围栏
     *
     * @param request
     * @param vo
     * @return
     */
    @RequestMapping("/createGeofence")
    public ResultBody createGeofence(HttpServletRequest request, GeoFenceVO vo) {
        String center = ServletRequestUtils.getStringParameter(request, "center", "");
        return mapService.createGeofence(vo);
    }

    /**
     * 查看地理围栏
     *
     * @param request
     * @return
     */
    @RequestMapping("/getGeofence")
    public ResultBody getGeofence(HttpServletRequest request) {
        return mapService.getGeofence();
    }

    /**
     * 更新围栏
     *
     * @param request
     * @return
     */
    @RequestMapping("/updateGeofence")
    public ResultBody updateGeofence(HttpServletRequest request) {
        return mapService.updateGeofence();
    }

    /**
     * 删除围栏
     *
     * @param request
     * @return
     */
    @RequestMapping("/deleteGeofence")
    public ResultBody deleteGeofence(HttpServletRequest request) {
        return mapService.deleteGeofence();
    }

    /**
     * 开启/关闭围栏
     *
     * @param request
     * @return
     */
    @RequestMapping("/startGeofence")
    public ResultBody startGeofence(HttpServletRequest request) {
        return mapService.startGeofence();
    }

    /**
     * 监控围栏
     *
     * @param request
     * @return
     */
    @RequestMapping("/monitoringGeoFence")
    public ResultBody monitoringGeoFence(HttpServletRequest request) {
        return mapService.monitoringGeoFence();
    }
}
