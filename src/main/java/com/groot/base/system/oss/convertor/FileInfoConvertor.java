package com.groot.base.system.oss.convertor;

import com.groot.base.system.oss.dto.FileInfoDTO;
import com.groot.base.system.oss.model.FileInfo;
import com.groot.base.web.convertor.BaseConvertor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FileInfoConvertor extends BaseConvertor<FileInfo, FileInfoDTO> {


    @Override
    public FileInfo toModel(FileInfoDTO fileInfoDTO) {
        FileInfo fileInfo = new FileInfo();
        BeanUtils.copyProperties(fileInfoDTO, fileInfo);
        return fileInfo;
    }

    @Override
    public FileInfoDTO toDTO(FileInfo fileInfo) {
        FileInfoDTO fileInfoDTO = new FileInfoDTO();
        BeanUtils.copyProperties(fileInfo, fileInfoDTO);
        return fileInfoDTO;
    }
}
