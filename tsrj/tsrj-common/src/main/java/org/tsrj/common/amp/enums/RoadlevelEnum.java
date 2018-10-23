package org.tsrj.common.amp.enums;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/9
 */
public enum RoadlevelEnum {
    EXPRESSWAY(41000, "高速公路"),
    NATIONAL_HIGHWAY(42000, "国道"),
    THRUWAY(43000, "主要大街，快速公路"),
    PROVINCIAL_ROAD(51000, "省道"),
    IMPORTANT_ROAD(44000, "主要道路"),
    SECONDARY_ROAD(45000, "次要道路"),
    COUNTRYSIDE_ROAD(52000, "乡公路"),
    FOOTPATH_ROAD(53000, "县乡村内部道路"),
    FOOTPATH_OTHER_ROAD(54000, "县乡村内部道路"),
    GENERAL_ROAD(47000, "普通道路"),
    NO_GPS(49, "非导航道路")
    ;
    private Integer level;
    private String desc;

    RoadlevelEnum(Integer level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
