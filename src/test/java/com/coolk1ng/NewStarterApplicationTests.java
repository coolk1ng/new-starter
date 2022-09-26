package com.coolk1ng;

import com.coolk1ng.mapper.StoreHouseMapper;
import com.coolk1ng.pojo.entity.Product;
import com.coolk1ng.pojo.vo.OrderVo;
import com.coolk1ng.pojo.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NewStarterApplicationTests {

    @Autowired
    private StoreHouseMapper storeHouseMapper;
    @Test
    void getProductList() {
        List<ProductVO> productList = storeHouseMapper.getProductBaseList();
        for (ProductVO productVO : productList) {
            System.out.println(productVO);
        }
    }

    @Test
    void getRemainTotalList() {
        List<ProductVO> remainTotalList = storeHouseMapper.getRemainTotalList();
        for (ProductVO item : remainTotalList) {
            System.out.println(item);
        }
    }

    @Test
    void getDefTotal() {
        List<OrderVo> defectiveList = storeHouseMapper.getDefectiveList();
        for (OrderVo item : defectiveList) {
            System.out.println(item);
        }
    }

    @Test
    void getOrderBaseList() {
        for (OrderVo item : storeHouseMapper.getOrderBaseList()) {
            System.out.println(item);
        }
    }
    @Test
    void getProduct () {
        Product productById = storeHouseMapper.getProductById(1);
        System.out.println(productById);
    }
}
