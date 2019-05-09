package com.eshop.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoodsPageModel extends PageModel {
    private List<GoodsDTO> goodsDTOS;
}
