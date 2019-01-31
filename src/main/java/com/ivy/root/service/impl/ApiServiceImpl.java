package com.ivy.root.service.impl;

import com.ivy.root.dto.PictureDto;
import com.ivy.root.service.ApiService;
import com.ivy.root.common.request.ShareInfoRequest;
import com.ivy.root.common.rootenum.DesignPictureTypeEnum;
import com.ivy.root.common.rootenum.ProfilePictureTypeEnum;
import com.ivy.root.dao.DesignImgMapper;
import com.ivy.root.dao.DesignMapper;
import com.ivy.root.dao.ProfileImgMapper;
import com.ivy.root.dao.ProfileMapper;
import com.ivy.root.domain.Design;
import com.ivy.root.domain.DesignImg;
import com.ivy.root.domain.Profile;
import com.ivy.root.domain.ProfileImg;
import com.ivy.root.vo.DesignVo;
import com.ivy.root.vo.ProfileVo;
import com.ivy.root.vo.ShareInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author matao
 */
@Service
public class ApiServiceImpl implements ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Autowired
    ProfileMapper profileMapper;

    @Autowired
    ProfileImgMapper profileImgMapper;

    @Autowired
    DesignMapper designMapper;

    @Autowired
    DesignImgMapper designImgMapper;

    @Override
    public ShareInfoVo getShareInfo(ShareInfoRequest param) {
        Long userId = param.getUserId();

        ProfileVo profileVo = getProfileVo(userId);
        List<DesignVo> designVos = getDesignVo(userId);
        ShareInfoVo shareInfoVo = new ShareInfoVo(profileVo, designVos);
        return shareInfoVo;
    }

    private List<DesignVo> getDesignVo(Long userId) {
        List<DesignVo> designVos = new ArrayList<>();

        Map<String, Object> param = new HashMap<>(16);
        param.put("userId", userId);
        List<Design> designs = designMapper.queryDesignForShare(param);
        if(designs != null && designs.size() > 0) {
            Set<Long> designIds = designs.stream().map(Design::getId).collect(Collectors.toSet());
            Map<String, Object> paramForImg = new HashMap<>(5);
            paramForImg.put("designIds", designIds);
            List<DesignImg> designImgs = designImgMapper.queryDesignImgsByConditions(paramForImg);

            designs.stream().forEach(d -> {
                DesignImg headImg = designImgs.stream().filter(i ->
                                i.getDesignId().equals(d.getId()) &&
                                i.getImgType().equals(DesignPictureTypeEnum.COVER_PICTURE.getCode()))
                        .findFirst().get();

                List<DesignImg> imgs = designImgs.stream().filter(i -> i.getDesignId().equals(d.getId()) &&
                                i.getImgType().equals(DesignPictureTypeEnum.NORMAL_PICTURE.getCode())).collect(Collectors.toList());
                designVos.add(new DesignVo(d, headImg, imgs));
            });
        }

        return designVos;
    }

    private ProfileVo getProfileVo(Long userId) {
        Profile profile = profileMapper.queryProfileByUserId(userId, 1);
        Map<String, Object> queryProfileImgsParam = new HashMap<>(4);
        queryProfileImgsParam.put("userId", userId);
        queryProfileImgsParam.put("profileId", profile.getId());
        List<ProfileImg> profileImgsAll = profileImgMapper.queryProfileImgsForShare(queryProfileImgsParam);
        Optional<ProfileImg> shareBackgroundImgOptional = profileImgsAll.stream().filter(p -> p.getImgType().equals(ProfilePictureTypeEnum.COMPANY_SHARE_BACKGROUND_PICTURE.getCode())).findAny();
        List<ProfileImg> profileImgs = profileImgsAll.stream().filter(p -> p.getImgType().equals(ProfilePictureTypeEnum.COMPANY_PICTURE.getCode())).collect(Collectors.toList());
        return new ProfileVo(profile, shareBackgroundImgOptional.get(), profileImgs);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveProfile(ShareInfoRequest request) {
        Profile profile = getProfileByShareInfoRequest(request);
        Long userId = request.getUserId();
        profileMapper.updateStatusByUserId(userId, 0);
        profileMapper.insertSelective(profile);

        List<ProfileImg> profileImgs = getProfileImgsByShareInfoRequest(request, profile.getId());
        profileImgMapper.batchInsertProfileImgs(profileImgs);
    }

    private List<ProfileImg> getProfileImgsByShareInfoRequest(ShareInfoRequest request, Long profileId) {
        Long userId = request.getUserId();
        List<PictureDto> sharePageBackground = request.getSharePageBackground();
        List<PictureDto> enterpriseImgs = request.getEnterpriseImgs();

        List<ProfileImg> profileImgs = new ArrayList<>();

        if(sharePageBackground != null && sharePageBackground.size() > 0) {
            for(PictureDto var : sharePageBackground) {
                ProfileImg profileImg = new ProfileImg();
                profileImg.setUserId(userId);
                profileImg.setImgUrl(var.getFileUrl());
                profileImg.setDescription(var.getDescription());
                profileImg.setImgType(ProfilePictureTypeEnum.COMPANY_SHARE_BACKGROUND_PICTURE.getCode());
                profileImg.setCreateTime(new Date());
                profileImg.setProfileId(profileId);

                profileImgs.add(profileImg);
            }
        }



        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
        if(enterpriseImgs != null && enterpriseImgs.size() > 0) {
            for(PictureDto var : enterpriseImgs) {
                ProfileImg profileImg = new ProfileImg();
                profileImg.setUserId(userId);
                profileImg.setImgUrl(var.getFileUrl());
                profileImg.setDescription(var.getDescription());
                profileImg.setImgType(ProfilePictureTypeEnum.COMPANY_PICTURE.getCode());
                profileImg.setCreateTime(new Date());
                profileImg.setProfileId(profileId);

                profileImgs.add(profileImg);
            }

        }

        return profileImgs;
    }

    private Profile getProfileByShareInfoRequest(ShareInfoRequest request) {
        Profile profile = new Profile(request);
        return profile;
    }
}
