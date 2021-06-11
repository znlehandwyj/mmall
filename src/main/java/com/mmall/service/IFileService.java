package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Steven.Lu on 2018/7/15.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
