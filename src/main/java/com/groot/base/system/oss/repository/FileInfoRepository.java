package com.groot.base.system.oss.repository;

import com.groot.base.system.oss.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileInfoRepository extends JpaRepository<FileInfo, String> ,FileInfoRepositoryCustom{

    FileInfo findFirstById(String id);

    List<FileInfo> findAllByFilesId(String filesId);

    void deleteAllByFilesId(String filesId);

}
