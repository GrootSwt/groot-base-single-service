package com.single.blog.system.account.convertor;


import com.single.blog.base.convertor.BaseConvertor;
import com.single.blog.system.account.dto.UserDTO;
import com.single.blog.system.account.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor extends BaseConvertor<User, UserDTO> {

    @Override
    public User toModel(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
