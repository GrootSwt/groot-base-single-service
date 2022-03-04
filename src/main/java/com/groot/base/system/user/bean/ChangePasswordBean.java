package com.groot.base.system.user.bean;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordBean {

    private String id;

    private String oldPassword;

    private String newPassword;
}
