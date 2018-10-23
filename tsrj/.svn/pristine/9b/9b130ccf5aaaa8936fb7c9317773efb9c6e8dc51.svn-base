package org.tsrj.common.amp.enums;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/9
 * 坐标转换
 */
public enum CoordsysTypeEnum {
    GPS("gps", "gps格式"),
    MAPBAR("mapbar", "mapbar格式"),
    BAIDU("baidu", "baidu格式"),
    AUTONAVI("autonavi", "autonavi格式")
    ;
    private String type;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    CoordsysTypeEnum(String type, String desc) {

        this.type = type;
        this.desc = desc;
    }

    public boolean isSuccess(String type){
        if(type == null){
            return false;
        }
        if(!type.equals(GPS.getType()) && !type.equals(MAPBAR.getType())
                && !type.equals(BAIDU.getType()) && !type.equals(AUTONAVI.getType())){
            return false;
        }
        return true;
    }
}
