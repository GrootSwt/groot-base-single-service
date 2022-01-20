package com.blog.system.dict.repository;


import com.blog.base.bean.SearchData;
import com.blog.system.dict.model.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface DictionaryRepositoryCustom {
    Page<Dictionary> pageableSearch(SearchData searchData, Pageable pageable);

    void modifyEnabled(Dictionary model);

    List<Dictionary> conditionSearch(SearchData searchData);
}