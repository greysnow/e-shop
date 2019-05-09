package com.eshop.application.dto;

import lombok.Data;

@Data
public abstract class PageModel {
    private int pageNum;
    private int size;
}
