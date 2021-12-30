package com.single.blog.system.dict.service;


import com.single.blog.base.bean.SearchData;
import com.single.blog.system.dict.model.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DictionaryService {
    Page<Dictionary> pageableSearch(SearchData searchData, Pageable pageable);

    void save(Dictionary model);

    void modifyEnabled(Dictionary toModel);

    void batchDelete(Long[] ids);

    List<Dictionary> conditionSearch(SearchData searchData);
}
