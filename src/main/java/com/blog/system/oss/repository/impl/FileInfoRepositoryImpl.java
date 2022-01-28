package com.blog.system.oss.repository.impl;


import com.blog.system.oss.model.FileInfo;
import com.blog.system.oss.model.QFileInfo;
import com.blog.system.oss.repository.FileInfoRepositoryCustom;
import com.groot.base.web.repository.BaseRepository;

import java.util.List;

public class FileInfoRepositoryImpl extends BaseRepository implements FileInfoRepositoryCustom {
    @Override
    protected Class<?> getModelClass() {
        return FileInfo.class;
    }


    @Override
    public List<Long> getFileIdListByFilesId(String filesId) {
        QFileInfo fileInfo = QFileInfo.fileInfo;
        return queryFactory.select(fileInfo.id).from(fileInfo).where(fileInfo.filesId.eq(filesId)).fetch();
    }
}
