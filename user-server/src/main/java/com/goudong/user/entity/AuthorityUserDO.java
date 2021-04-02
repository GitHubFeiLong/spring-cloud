package com.goudong.user.entity;

import lombok.Data;

import java.util.List;

/**
 *
 * @Author msi
 * @Date 2021-04-02 13:10
 * @Version 1.0
 */
@Data
public class AuthorityUserDO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String validTime;
    private String updateTime;
    private String remark;
    private String nickname;
    private List<AuthorityRoleDO> authorityRoleDOS;
}
