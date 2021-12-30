package com.single.blog.system.oss.repository;

import java.util.List;

public interface FileInfoRepositoryCustom {
    List<Long> getFileIdListByFilesId(String filesId);
}
