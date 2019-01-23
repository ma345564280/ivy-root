package com.ivy.root.service;

import com.ivy.root.dto.CropImage;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface MongoDbService {

    List<String> savePicture(MultipartHttpServletRequest request) throws IOException;
    void getPicture(String fileId, HttpServletResponse response) throws IOException;
    void removeFile(String fileId);

    void getPicture(String fileId, HttpServletResponse response, float v) throws IOException;

    String saveCropPicture(CropImage request) throws IOException;
}
