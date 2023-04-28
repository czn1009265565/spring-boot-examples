package com.example.springbootfile.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileVO {
    private String fileName;
    private String fileUri;
    private String fileType;
    private Long fileSize;
}