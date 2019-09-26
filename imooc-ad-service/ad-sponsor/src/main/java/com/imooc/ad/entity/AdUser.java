package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Qinyi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")
public class AdUser {

    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //设置策略
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic      //不指定也默认是
    @Column(name = "username", nullable = false)
    private String username;

    @Basic //@Transient不是数据表的字段定义
    @Column(name = "token", nullable = false)
    private String token;

    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdUser(String username, String token) {

        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
