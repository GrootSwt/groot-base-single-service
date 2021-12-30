package com.blog.system.user.bean;

import com.blog.system.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBean {

    private String token;

    private User userInfo;

    private String accountName;
}
