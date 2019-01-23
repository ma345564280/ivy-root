package com.ivy.root.service.impl;

import com.ivy.root.service.MongoDbService;
import com.ivy.root.common.exception.BusinessException;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import com.ivy.root.controller.DesignsController;
import com.ivy.root.dto.CropImage;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import net.coobird.thumbnailator.Thumbnails;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MongoDbServiceImp implements MongoDbService {
    private static Map<String, String> imageContentType = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(DesignsController.class);
    static {
        imageContentType.put("jpg", "image/jpeg");
        imageContentType.put("jpeg", "image/jpeg");
        imageContentType.put("png", "image/png");
        imageContentType.put("tif", "image/tiff");
        imageContentType.put("tiff", "image/tiff");
        imageContentType.put("ico", "image/x-icon");
        imageContentType.put("bmp", "image/bmp");
        imageContentType.put("gif", "image/gif");
    }


    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    private GridFSBucket gridFSBucket;

    public List<String> savePicture(MultipartHttpServletRequest request) throws IOException {

        List<String> fileNames = new ArrayList<>();

        MultiValueMap<String, MultipartFile> map1 = request.getMultiFileMap();
        List<MultipartFile> multipartFiles = map1.get("file");

        if (multipartFiles == null || multipartFiles.size() == 0)
            throw new BusinessException(ResponseCodeEnum.NONE_PICTURE_RECEIVED);

        for (MultipartFile multipartFile : multipartFiles) {
            String contentType = "";
            String originalFilename = multipartFile.getOriginalFilename();
            String[] splits = originalFilename.split("\\.");
            if (splits != null && splits.length >= 2) {
                contentType = splits[splits.length - 1];
            }
            // 获得文件输入流
            InputStream ins = multipartFile.getInputStream();
            // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息
            String fileName = multipartFile.getOriginalFilename();
            ObjectId gridFSFile = gridFsTemplate.store(ins, fileName, contentType);
            fileNames.add(gridFSFile.toString());
        }

        return fileNames;
    }

    public void getPicture(String fileId, HttpServletResponse response) throws IOException {
        getPicture(fileId, response, 1f);
    }

    /**
     * 根据文件ID删除文件
     *
     * @param fileId
     * @throws Exception
     * @author
     */
    public void removeFile(String fileId) {
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(fileId)));
    }

    @Override
    public void getPicture(String fileId, HttpServletResponse response, float proportion) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        if (file != null) {
            GridFSDownloadStream in = gridFSBucket.openDownloadStream(file.getObjectId());
            GridFsResource resource = new GridFsResource(file, in);
            InputStream inputStream = resource.getInputStream();
            String contentType = (String) file.getMetadata().get("_contentType");
            response.setContentType(imageContentType.get(contentType.toLowerCase()));
            OutputStream out = response.getOutputStream();
            Thumbnails.of(inputStream).scale(proportion).outputQuality(1f).toOutputStream(out);
            out.flush();
            out.close();
        }
    }

    @Override
    public String saveCropPicture(CropImage request) throws IOException {
        if (request.getFile() == null) //图像数据为空
            return null;
        int index = request.getFile().indexOf("base64,");
        byte[] bytes = new BASE64Decoder().decodeBuffer(request.getFile().substring(index + 7));
        //转化为输入流
        ByteArrayInputStream ins = new ByteArrayInputStream(bytes);
        ObjectId gridFSFile = gridFsTemplate.store(ins, request.getFileName(), request.getSuffix());
        logger.debug(gridFSFile.toString());
        return gridFSFile.toString();
    }

}
