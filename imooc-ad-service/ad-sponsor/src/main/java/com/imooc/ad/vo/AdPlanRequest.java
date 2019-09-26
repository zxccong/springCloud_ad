package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Qinyi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {

    private Long id;
    private Long userId;
    private String planName;
    //开始日期不使用data类型 ，反序列化，转换为date类型
    private String startDate;
    private String endDate;

    public boolean createValidate() {

        return userId != null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startDate)
                && !StringUtils.isEmpty(endDate);
    }

    public boolean updateValidate() {

        return id != null && userId != null;
    }

    public boolean deleteValidate() {

        return id != null && userId != null;
    }
}
