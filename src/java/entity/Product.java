/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Product {

    private int ProductID;
    private String ProductName, QuantityPerUnit;
    private double UnitPrice;
    private short UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued;
    private Category category;

    public Product() {
    }

    public Product(int ProductID, String ProductName, String QuantityPerUnit, double UnitPrice, short UnitsInStock, short UnitsOnOrder, short ReorderLevel, short Discontinued, Category category) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
        this.category = category;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public short getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(short UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public short getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(short UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }

    public short getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(short ReorderLevel) {
        this.ReorderLevel = ReorderLevel;
    }

    public short getDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(short Discontinued) {
        this.Discontinued = Discontinued;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
