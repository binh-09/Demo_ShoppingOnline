/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.asus.shoppingOnline.core;

import dal.DAO;
import entity.Product;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class AdvancedFactorialTest {
    
    @Test
    public void AdvancedFactorialTest() {
        DAO dao = new DAO(); // Đảm bảo DAO được kết nối với database test
        int[] cidd = {1, 2}; // Các ID categories để test
        List<Product> result = dao.searchByCheck(cidd);

        // Kiểm tra danh sách không rỗng
        assertNotNull(result);

        // Kiểm tra số lượng sản phẩm trả về (giả sử bạn biết trước kết quả)
        assertEquals(24, result.size());

        // Kiểm tra thông tin sản phẩm cụ thể
        assertEquals("Chai", result.get(0).getProductName());
    }
    
    @Test
    public void testGetProductsByPrice() {
        DAO dao = new DAO();
        double from = 10.0;
        double to = 50.0;

        List<Product> result = dao.getProductsByPrice(from, to);
        
        // Kiểm tra danh sách trả về không rỗng
        assertNotNull(result);
        
        // Kiểm tra giá của sản phẩm nằm trong khoảng
        for (Product p : result) {
            assertTrue(p.getUnitPrice() >= from && p.getUnitPrice() <= to);
        }
    }

}
