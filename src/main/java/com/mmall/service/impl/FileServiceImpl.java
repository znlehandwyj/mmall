package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Steven.Lu on 2018/7/15.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger= LoggerFactory.getLogger(FileServiceImpl.class);

   public String upload(MultipartFile file,String path){
       String fileName=file.getOriginalFilename();
       //扩展名 abc.jpg
       String fileExtensionName=fileName.substring(fileName.lastIndexOf(".")+1);
       String uploadFileName= UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传的文件名为:{},上传的路径:{},新文件名为:{}",fileName,path,uploadFileName);

       File fileDir=new File(path);
       if(!fileDir.exists()){
           fileDir.setWritable(true);
           fileDir.mkdirs();
       }
       File targetFile=new File(path,uploadFileName);

       try {
           file.transferTo(targetFile);
           //文件上传成功
           FTPUtil.uploadFile(Lists.<File>newArrayList(targetFile));
           //todo 将targetfile上传到我们的ftp服务器

           targetFile.delete();
           //todo 上传完之后，删除upload下面的文件
       } catch (IOException e) {
           logger.error("上传文件异常",e);
           return null;
       }

       return targetFile.getName();
   }
}
