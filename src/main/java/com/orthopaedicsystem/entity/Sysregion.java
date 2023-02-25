package com.orthopaedicsystem.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sysregion
 */
@Data
public class Sysregion implements Serializable {
    /**
     * 区域主键
     */
    private Integer id;

    /**
     * 区域编码
     */
    private String name;

    /**
     * 区域上级标识
     */
    private Integer parentId;

    /**
     * 地名简称
     */
    private String simplename;

    /**
     * 区域等级
     */
    private Integer level;

    /**
     * 城市编码
     */
    private String citycode;

    /**
     * 邮政编码
     */
    private String zipcode;

    /**
     * 组合名称
     */
    private String mername;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 拼音
     */
    private String pinyin;

    private static final long serialVersionUID = 1L;
}