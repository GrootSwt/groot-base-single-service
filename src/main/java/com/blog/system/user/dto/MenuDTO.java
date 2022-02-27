package com.blog.system.user.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO implements Serializable {

    private String id;

    private String title;

    private String location;

    private String icon;

    private String sort;

    private String enabled;

    private String parentId;

    private String type;

    private List<MenuDTO> children;
}
