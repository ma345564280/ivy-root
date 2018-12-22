package com.ivy.root.controller;

import com.ivy.root.Service.MongoDbService;
import com.ivy.root.common.response.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
@Api(value = "文件管理", description = "文件管理")
public class FileController {

    @Value("${img.location}")
    String filePath;

    @Value("${img.proportion}")
    String compressProportion;

    @Autowired
    MongoDbService mongoDbService;

    @RequestMapping(value = "/design/uploadPicture", method = RequestMethod.POST)
    @ApiOperation(value = "上传文件")
    public ResponseVo<List<String>> uploadPicture(MultipartHttpServletRequest request) throws IOException {
        return ResponseVo.buildSuccessInstance(mongoDbService.savePicture(request));
    }

    @RequestMapping(value = "/design/downloadPicture", method = RequestMethod.GET)
    @ApiOperation(value = "下载图片")
    public void downloadPicture(@RequestParam String fileId, HttpServletResponse response) throws IOException {

        //http://localhost/ivy-root/file/design/downloadFile?fileId=5c0be02ee9a26864fc133d3f
        mongoDbService.getPicture(fileId, response);
    }

    @RequestMapping(value = "/design/downloadCompressPicture", method = RequestMethod.GET)
    @ApiOperation(value = "下载压缩图片")
    public void downloadCompressPicture(@RequestParam String fileId, HttpServletResponse response) throws IOException {

        //http://localhost/ivy-root/file/design/downloadCompressPicture?fileId=5c0be02ee9a26864fc133d3f
        mongoDbService.getPicture(fileId, response, Float.parseFloat(compressProportion));
    }

}
