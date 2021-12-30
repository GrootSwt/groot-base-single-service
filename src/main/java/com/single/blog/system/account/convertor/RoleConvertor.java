package com.single.blog.system.account.convertor;

import com.single.blog.base.convertor.BaseConvertor;
import com.single.blog.system.account.dto.RoleDTO;
import com.single.blog.system.account.model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleConvertor extends BaseConvertor<Role, RoleDTO> {
    @Override
    public Role toModel(RoleDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return role;
    }

    @Override
    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(role, roleDTO);
        return roleDTO;
    }
}
