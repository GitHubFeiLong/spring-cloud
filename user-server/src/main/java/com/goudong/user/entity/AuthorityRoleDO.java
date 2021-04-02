package com.goudong.user.entity;

import lombok.Data;

/**
 * @Author msi
 * @Date 2021-04-02 13:49
 * @Version 1.0
 */
@Data
public class AuthorityRoleDO {
    private Integer id;
    private String roleName;
    private String roleNameCN;
    private String updateTime;
    private String remark;

}
