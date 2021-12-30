package com.single.blog.system.dict.repository;


import com.single.blog.base.bean.SearchData;
import com.single.blog.system.dict.model.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface DictionaryRepositoryCustom {
    Page<Dictionary> pageableSearch(SearchData searchData, Pageable pageable);

    void modifyEnabled(Dictionary model);

    List<Dictionary> conditionSearch(SearchData searchData);
}
