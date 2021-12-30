package com.single.blog.system.account.convertor;


import com.single.blog.base.convertor.BaseConvertor;
import com.single.blog.system.account.dto.MenuDTO;
import com.single.blog.system.account.model.Menu;
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
