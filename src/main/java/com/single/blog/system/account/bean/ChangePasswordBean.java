package com.single.blog.system.account.bean;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordBean {

    private Long id;

    private String oldPassword;

    private String newPassword;
}
