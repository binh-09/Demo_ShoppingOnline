/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Category;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAO extends DBContext {

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"),
                        rs.getString("Description"),
                        rs.getString("Picture"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println("errorl list: " + e);
        }
        return list;
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM Categories where CategoryID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"),
                        rs.getString("Description"),
                        rs.getString("Picture"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductsByCid(int cid) {
        List<Product> list = new ArrayList<>();
//        String sql = "Select ProductID, ProductName, QuantityPerUnit, UnitPrice, UnitsInStock,"
//                + "UnitsOnOrder, ReorderLevel, Discontinued"
//                + " from Products where CategoryID=?";

        String sql = "Select * "
                + "from Products where 1=1";
        if (cid != 0) {
            sql += " and CategoryID=" + cid;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setQuantityPerUnit(rs.getString("quantityPerUnit"));
                p.setUnitPrice(rs.getDouble("unitPrice"));
                p.setUnitsInStock(rs.getShort("unitsInStock"));
                p.setUnitsOnOrder(rs.getShort("unitsOnOrder"));
                p.setReorderLevel(rs.getShort("reorderLevel"));
                p.setDiscontinued(rs.getShort("discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("error dao: " + e);
        }
        return list;
    }

    public List<Product> searchByKey(String key) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1 ";
        if (key != null && !key.equals("")) {
            sql += "and productName like '%" + key + "%'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setQuantityPerUnit(rs.getString("quantityPerUnit"));
                p.setUnitPrice(rs.getDouble("unitPrice"));
                p.setUnitsInStock(rs.getShort("unitsInStock"));
                p.setUnitsOnOrder(rs.getShort("unitsOnOrder"));
                p.setReorderLevel(rs.getShort("reorderLevel"));
                p.setDiscontinued(rs.getShort("discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> searchByCheck(int[] cidd) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1 ";
        if (cidd != null && cidd[0] != 0) {
            sql += " and CategoryID IN(";
            for (int i = 0; i < cidd.length; i++) {
                sql += cidd[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setQuantityPerUnit(rs.getString("quantityPerUnit"));
                p.setUnitPrice(rs.getDouble("unitPrice"));
                p.setUnitsInStock(rs.getShort("unitsInStock"));
                p.setUnitsOnOrder(rs.getShort("unitsOnOrder"));
                p.setReorderLevel(rs.getShort("reorderLevel"));
                p.setDiscontinued(rs.getShort("discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getProductsByPrice(double from, double to) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where UnitPrice between ? AND ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, from);
            st.setDouble(2, to);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setQuantityPerUnit(rs.getString("quantityPerUnit"));
                p.setUnitPrice(rs.getDouble("unitPrice"));
                p.setUnitsInStock(rs.getShort("unitsInStock"));
                p.setUnitsOnOrder(rs.getShort("unitsOnOrder"));
                p.setReorderLevel(rs.getShort("reorderLevel"));
                p.setDiscontinued(rs.getShort("discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> search(String key, Double price1, Double price2, int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from products where 1=1 ";
        if (key != null && !key.equals("")) {
            sql += " and productName like '%" + key + "%'";
        }
        if (price1 != null) {
            sql += " and UnitPrice>=" + price1;
        }
        if (price2 != null) {
            sql += " and UnitPrice<=" + price2;
        }
        if (cid != 0) {
            sql += " and CategoryID=" + cid;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setQuantityPerUnit(rs.getString("quantityPerUnit"));
                p.setUnitPrice(rs.getDouble("unitPrice"));
                p.setUnitsInStock(rs.getShort("unitsInStock"));
                p.setUnitsOnOrder(rs.getShort("unitsOnOrder"));
                p.setReorderLevel(rs.getShort("reorderLevel"));
                p.setDiscontinued(rs.getShort("discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("error search: " + e);
        }
        return list;
    }

    public List<Product> getNewProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "select TOP 3 * "
                + "from Products where UnitsInStock!=0"
                + " ORDER BY UnitsInStock";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getShort("UnitsInStock"));
                p.setUnitsOnOrder(rs.getShort("UnitsOnOrder"));
                p.setReorderLevel(rs.getShort("ReorderLevel"));
                p.setDiscontinued(rs.getShort("Discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getOldproducts() {
        List<Product> list = new ArrayList<>();
        String sql = "select TOP 3 * from Products ORDER BY UnitsInStock DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getShort("UnitsInStock"));
                p.setUnitsOnOrder(rs.getShort("UnitsOnOrder"));
                p.setReorderLevel(rs.getShort("ReorderLevel"));
                p.setDiscontinued(rs.getShort("Discontinued"));
                Category c = getCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

}
