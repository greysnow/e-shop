package com.eshop.Service;

import com.eshop.application.SalesVolumeAppService;
import com.eshop.application.SellerSalesAppService;
import com.eshop.utils.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesVolumeServiceTest extends BaseTest {
    @Autowired
    SalesVolumeAppService salesVolumeAppService;

    @Autowired
    SellerSalesAppService sellerSalesAppService;

    @Test
    public void testGetVolume() {
        salesVolumeAppService.getVolume();
    }

    @Test
    public void testGetSellerVolume(){
        salesVolumeAppService.getSellerVolume();
    }
}