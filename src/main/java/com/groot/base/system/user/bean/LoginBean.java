package com.groot.base.system.user.bean;

import com.groot.base.system.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBean {

    private String token;

    private User userInfo;

    private String accountName;
}
