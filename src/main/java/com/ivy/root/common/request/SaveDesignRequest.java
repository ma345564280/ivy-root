package com.ivy.root.common.request;

import com.ivy.root.dto.PictureDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaveDesignRequest extends BaseRequest {
    private String brief;
    private List<String> residence;
    private Byte type;
    private String priceRange;
    private String designStyle;
    private List<String>  coverPictureUrl;
    private List<String> normalPictureUrls;
    private Long designerId;
    private String name;

}
