package com.eshop.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderPageModel extends PageModel {
    private List<OrderDTO> orderDTOS;
}
