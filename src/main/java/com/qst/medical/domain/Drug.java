package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug extends SuperDomain {
    private Long drugId;//药品id

    @NotNull(message = "药品名称不能为空")
    private String drugName;//药品名称

    @NotNull(message = "药品成分信息不能为空")
    private String drugInfo;//药品成分信息

    @NotNull(message = "药品功能作用不能为空")
    private String drugEffect;//药品功能作用

    @NotNull(message = "药品图片url不能为空")
    private String drugImg;//药品图片url
    private Date createtime;//药品创建时间
    private Date updatetime;//药品更新时间

    @NotNull(message = "药品发布者不能为空")
    private String drugPublisher;//药品发布者

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugInfo='" + drugInfo + '\'' +
                ", drugEffect='" + drugEffect + '\'' +
                ", drugImg='" + drugImg + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", drugPublisher='" + drugPublisher + '\'' +
                '}';
    }

}