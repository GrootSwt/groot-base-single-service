package com.blog.system.dict.repository;


import com.blog.base.bean.SearchData;
import com.blog.system.dict.model.DictionaryCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DictionaryCategoryRepositoryCustom {
    Page<DictionaryCategory> pageableSearch(SearchData searchData, Pageable pageable);

    void modifyEnable(DictionaryCategory model);
}
