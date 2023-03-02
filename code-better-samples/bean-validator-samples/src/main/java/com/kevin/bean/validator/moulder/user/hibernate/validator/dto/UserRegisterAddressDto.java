package com.kevin.bean.validator.moulder.user.hibernate.validator.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * TODO 用一句话描述这个类的作用
 *
 * @author wangyong
 */
@Data
public class UserRegisterAddressDto {

    /**
     * 省份编码
     */
    @NotBlank(message = "省份编码不能为空")
    private String provinceCode;

    /**
     * 省份名称
     */
    @NotBlank(message = "省份名称不能为空")
    private String province;

    /**
     * 城市编码
     */
    @NotBlank(message = "城市编码不能为空")
    private String cityCode;

    /**
     * 城市名称
     */
    @NotBlank(message = "城市名称不能为空")
    private String city;

    /**
     * 区域编码
     */
    @NotBlank(message = "区域编码不能为空")
    private String districtCode;

    /**
     * 区域名称
     */
    @NotBlank(message = "区域名称不能为空")
    private String district;

    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
    private String address;


    @Override
    public String toString() {
        return "{" +
                "\"provinceCode\":\"" +
                provinceCode + '\"' +
                ",\"province\":\"" +
                province + '\"' +
                ",\"cityCode\":\"" +
                cityCode + '\"' +
                ",\"city\":\"" +
                city + '\"' +
                ",\"districtCode\":\"" +
                districtCode + '\"' +
                ",\"district\":\"" +
                district + '\"' +
                ",\"address\":\"" +
                address + '\"' +
                "}";
    }
}
