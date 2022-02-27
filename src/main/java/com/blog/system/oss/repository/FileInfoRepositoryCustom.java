package com.blog.system.oss.repository;

import java.util.List;

public interface FileInfoRepositoryCustom {
    List<String> getFileIdListByFilesId(String filesId);
}
