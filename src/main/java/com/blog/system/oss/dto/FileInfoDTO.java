package com.blog.system.oss.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileInfoDTO implements Serializable {

    private String id;

    private String fileName;

    private String fileType;

    private String filePath;

    private String fileSize;

    private String filesId;
}
