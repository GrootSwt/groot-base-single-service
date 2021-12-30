package com.single.blog.system.oss.repository.impl;


import com.single.blog.base.repository.BaseRepository;
import com.single.blog.system.oss.model.FileInfo;
import com.single.blog.system.oss.model.QFileInfo;
import com.single.blog.system.oss.repository.FileInfoRepositoryCustom;

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
