package com.groot.base.system.oss.repository;

import java.util.List;

public interface FileInfoRepositoryCustom {
    List<String> getFileIdListByFilesId(String filesId);
}
