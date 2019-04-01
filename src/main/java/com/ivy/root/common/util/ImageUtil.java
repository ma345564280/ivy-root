package com.ivy.root.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;


/**
* @Description:   图片保存相关工具方法
* @Author:         matao
* @CreateDate:     2019/3/11 14:13

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:13
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public class ImageUtil {
    /**
     * 保存文件，直接以multipartFile形式
     * @param multipartFile
     * @param path 文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = multipartFile.getOriginalFilename();

        String[] pictureFormat = fileName.split("\\.");
        if(pictureFormat != null && pictureFormat.length >= 2) {
            fileName = UUID.randomUUID() + "." + pictureFormat[1];
        } else {
            fileName = UUID.randomUUID() + ".png";
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

}
