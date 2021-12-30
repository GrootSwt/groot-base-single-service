package com.single.blog.system.account.bean;

import com.single.blog.system.account.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBean {

    private String token;

    private User userInfo;

    private String accountName;
}
