package com.blog.system.dict.convertor;

import com.blog.base.convertor.BaseConvertor;
import com.blog.system.dict.dto.DictionaryCategoryDTO;
import com.blog.system.dict.model.DictionaryCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DictionaryCategoryConvertor extends BaseConvertor<DictionaryCategory, DictionaryCategoryDTO> {
    @Override
    public DictionaryCategory toModel(DictionaryCategoryDTO dictionaryCategoryDTO) {
        DictionaryCategory model = new DictionaryCategory();
        BeanUtils.copyProperties(dictionaryCategoryDTO, model);
        return model;
    }

    @Override
    public DictionaryCategoryDTO toDTO(DictionaryCategory dictionaryCategory) {
        DictionaryCategoryDTO dto = new DictionaryCategoryDTO();
        BeanUtils.copyProperties(dictionaryCategory, dto);
        return dto;
    }
}
