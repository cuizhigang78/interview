package com.cui._99_common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryEnum {
    QI(0, "齐"),
    CHU(1, "楚"),
    YAN(2, "燕"),
    ZHAO(3, "赵"),
    HAN(4, "韩"),
    WEI(5, "魏");

    private Integer code;
    private String name;

    public static CountryEnum getCountryEnum(Integer code) {
        for (CountryEnum anEnum : CountryEnum.values()) {
            if(anEnum.getCode().equals(code)) {
                return anEnum;
            }
        }
        return null;
    }
}
