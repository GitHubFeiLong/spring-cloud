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
    private String role_name;
    private String role_name_CN;
    private String update_time;
    private String remark;

}
