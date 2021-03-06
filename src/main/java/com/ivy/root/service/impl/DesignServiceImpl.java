package com.ivy.root.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivy.root.dto.PictureDto;
import com.ivy.root.service.DesignService;
import com.ivy.root.common.exception.BusinessException;
import com.ivy.root.common.request.DesignsParamRequest;
import com.ivy.root.common.request.SaveDesignRequest;
import com.ivy.root.common.rootenum.DesignPictureTypeEnum;
import com.ivy.root.common.rootenum.ResponseCodeEnum;
import com.ivy.root.dao.DesignImgMapper;
import com.ivy.root.dao.DesignMapper;
import com.ivy.root.domain.Design;
import com.ivy.root.domain.DesignImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignServiceImpl implements DesignService {

    @Autowired
    DesignMapper designMapper;

    @Autowired
    DesignImgMapper designImgMapper;

    @Override
    public PageInfo<Design> queryDesigns(DesignsParamRequest param) {
        PageHelper.startPage(param.getPageNo(), param.getPageSize());
        List<Design> designs = designMapper.queryDesignsByCondition(param);
        PageInfo<Design> pageInfo = new PageInfo<>(designs);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveDesign(SaveDesignRequest param) {
        if(param == null || param.getDesignerId() == null) {
            throw new BusinessException(ResponseCodeEnum.WRONG_OR_EMPTY_PARAM);
        }
        Design design = new Design(param);
        Integer countSave = designMapper.saveDesign(design);

        Long designId = design.getId();
        List<PictureDto> coverPicture = param.getCoverPictureUrl();
        List<PictureDto> normalPicture = param.getNormalPictureUrls();

        List<DesignImg> designImgs = new ArrayList<>();
        if(coverPicture != null && coverPicture.size() > 0) {
            for(PictureDto pic : coverPicture) {
                DesignImg var = new DesignImg(designId, pic, DesignPictureTypeEnum.COVER_PICTURE.getCode());
                designImgs.add(var);
            }
        }

        if(normalPicture != null && normalPicture.size() > 0) {
            for(PictureDto pic : normalPicture) {
                DesignImg var = new DesignImg(designId, pic, DesignPictureTypeEnum.NORMAL_PICTURE.getCode());

                //新增修改
                designImgs.add(var);
            }
        }

        int count = 0;
        if(designImgs.size() > 0) {
            count = designImgMapper.saveDesignImgs(designImgs);
        }

        return "success with " + countSave + " design and " + count + " pictures";
    }
}
