package com.blog.system.oss.repository;

import java.util.List;

public interface FileInfoRepositoryCustom {
    List<Long> getFileIdListByFilesId(String filesId);
}
