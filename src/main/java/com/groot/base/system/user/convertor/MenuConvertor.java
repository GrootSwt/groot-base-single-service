package com.groot.base.system.user.convertor;


import com.groot.base.system.user.dto.MenuDTO;
import com.groot.base.system.user.model.Menu;
import com.groot.base.web.convertor.BaseConvertor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MenuConvertor extends BaseConvertor<Menu, MenuDTO> {

    @Override
    public Menu toModel(MenuDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        return menu;
    }

    @Override
    public MenuDTO toDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        BeanUtils.copyProperties(menu, menuDTO);
        return menuDTO;
    }
}
