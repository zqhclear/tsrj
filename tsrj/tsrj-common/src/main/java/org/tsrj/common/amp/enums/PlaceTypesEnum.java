package org.tsrj.common.amp.enums;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/9
 * 没有用，可能会更新，废弃
 */
public enum PlaceTypesEnum {
    BIG("010000", "大类"),
    MID("", "中类"),
    SMALL("", "小类")
    ;

    private String type;
    private String desc;

    PlaceTypesEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
