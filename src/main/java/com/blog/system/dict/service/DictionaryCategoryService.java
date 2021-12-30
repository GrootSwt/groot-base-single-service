package com.blog.system.dict.service;

import com.blog.base.bean.SearchData;
import com.blog.system.dict.model.DictionaryCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DictionaryCategoryService {
    void save(DictionaryCategory model);

    void batchDelete(Long[] idArr);

    Page<DictionaryCategory> pageableSearch(SearchData searchData, Pageable pageable);

    void modifyEnabled(DictionaryCategory model);
}
