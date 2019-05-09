package com.eshop.domain.repository;

import com.eshop.domain.model.SalesVolume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesVolumeRepository {
    /**
     * 查找销售量
     *
     * @param orderId
     * @return
     */
    List<SalesVolume> queryByOrderId(@Param("orderId") int orderId);

    List<SalesVolume> findSalesVolumes(@Param("orderIds") List<Integer> orderIds);
}
