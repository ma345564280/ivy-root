package com.ivy.root.dao;

import com.ivy.root.domain.DesignImg;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DesignImgMapper {

    Integer saveDesignImgs(List<DesignImg> designImgs);

    List<DesignImg> queryDesignImgsByConditions(Map<String, Object> paramForImg);
}