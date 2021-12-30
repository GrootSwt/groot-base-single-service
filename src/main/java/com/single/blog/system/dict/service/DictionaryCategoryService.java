package com.single.blog.system.dict.service;

import com.single.blog.base.bean.SearchData;
import com.single.blog.system.dict.model.DictionaryCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DictionaryCategoryService {
    void save(DictionaryCategory model);

    void batchDelete(Long[] idArr);

    Page<DictionaryCategory> pageableSearch(SearchData searchData, Pageable pageable);

    void modifyEnabled(DictionaryCategory model);
}
