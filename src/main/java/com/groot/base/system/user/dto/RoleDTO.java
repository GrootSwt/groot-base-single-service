package com.groot.base.system.user.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {

    private String id;

    private String name;

    private String description;

    private String enabled;

    private String[] menuIdArr;
}
