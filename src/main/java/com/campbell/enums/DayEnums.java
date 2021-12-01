package com.campbell.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author Campbell
 * @date 2020/7/1
 */
public enum DayEnums {

    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");

    private Integer code;
    private String desc;

    DayEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(Integer code){
        return Arrays.stream(DayEnums.values()).filter(dayEnums -> dayEnums.getCode().equals(code)).map(DayEnums::getDesc).findFirst().orElse(StringUtils.EMPTY);
    }
}
