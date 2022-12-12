/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he170417_phandangtruong_assignment1;

/**
 *
 * @author HE170417
 */
public class Book {
    private String bcode;
    private String title;
    private int quantity;
    private int lended=0;
    private double price;
    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }
    
    
    //getter setter
    public String getBcode() {
        return bcode.toLowerCase();
    }

    @Override
    public String toString() {
        return  bcode + " | " + title + " | " + quantity + " | " + lended + " | " + price;
    }
    public String saveToFileData(){
        return bcode+" | "+title+" | "+quantity+" | "+lended+" | "+price;
    }
    public void setBcode(String bcode) {       
        this.bcode = bcode;
    }

    public String getTitle() {
        return title.toLowerCase();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        if(lended<=quantity)
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
