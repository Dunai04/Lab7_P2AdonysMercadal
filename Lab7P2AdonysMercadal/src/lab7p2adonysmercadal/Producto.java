/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adony
 */
public class Producto {
    private int id;
    private String name;
    private int price;
    private int aisle;
    private int bin;

    public Producto() {
    }

    public Producto(int id, String name, int price, int aisle, int bin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.aisle = aisle;
        this.bin = bin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", name=" + name + ", price=" + price + ", aisle=" + aisle + ", bin=" + bin + '}';
    }
    
}
