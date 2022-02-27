package com.blog.system.dict.service;

import com.blog.system.dict.model.DictionaryCategory;
import com.groot.base.common.SearchData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DictionaryCategoryService {
    void save(DictionaryCategory model);

    void batchDelete(String[] idArr);

    Page<DictionaryCategory> pageableSearch(SearchData searchData, Pageable pageable);

    void modifyEnabled(DictionaryCategory model);
}
