package com.ivy.root.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CropImage {
    private Long userId;
    private String file;
    private String fileName;
    private String size;
    private String description;
    private String suffix;

}
