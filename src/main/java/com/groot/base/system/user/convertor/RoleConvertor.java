package com.groot.base.system.user.convertor;

import com.groot.base.system.user.dto.RoleDTO;
import com.groot.base.system.user.model.Role;
import com.groot.base.web.convertor.BaseConvertor;
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
