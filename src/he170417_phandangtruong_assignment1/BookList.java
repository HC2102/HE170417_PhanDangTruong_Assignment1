/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he170417_phandangtruong_assignment1;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author HE170417
 */
public class BookList{
    Node<Book> head,tail;
    Scanner sc1 = new Scanner(System.in);
    //===========================FILE IO SECTION================================
    public void addToFile(){
        Node<Book> p =head;
        try{
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("Book_Data.txt"));
            while(p!=null){
                writer.write(p.info.saveToFileData()+"\n");
                p = p.next;
            }
            writer.close();
            System.out.println("Success");
        }catch(IOException ex){
            System.out.println("Error occurs");
            System.out.println(ex);
        }
    }
    public void LoadData(){
        Node<Book> p = head;
        String temp[], tempBcode,tempTitle;
        int tempQuantity,tempLended;
        double tempPrice;
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("Book_Data.txt"));
            String line;
            while((line = reader.readLine())!=null){
                temp = line.split(" \\| ");
                tempBcode = temp[0];
                tempTitle = temp[1];
                tempQuantity = Integer.parseInt(temp[2]);
                tempLended = Integer.parseInt(temp[3]);
                tempPrice = Double.parseDouble(temp[4]);
                addToTail(new Book(tempBcode,tempTitle,tempQuantity,tempLended,tempPrice));
            }
            reader.close();
            System.out.println("Success");
            
        }catch(IOException ex){
            System.out.println("Error occurs");
            System.out.println(ex);
        }
    }
    //=======================Add section========================================
    public Book inputData(){
        String bcodeTmp, titleTmp;
        int quantityTmp,lendedTmp;
        String tmp;
        double priceTmp;
        while(true){
            System.out.println("Please enter bcode of the new book:");
            bcodeTmp = sc1.nextLine();
            if(isUnique(bcodeTmp))break;
            System.out.println("the bcode has been taken!");
        }
        System.out.println("title name:");
        titleTmp  = sc1.nextLine();
        while(true){
            System.out.println("Quantity:");
            quantityTmp  = Integer.parseInt(sc1.nextLine());
            if(quantityTmp > 0)break;
            System.out.println("The quantity must be greater than 0");
        }
        
        while(true){
           System.out.println("Lended:");
           tmp  = sc1.nextLine();
           if(tmp.isEmpty()){
               lendedTmp = 0;
               break;
           }
           lendedTmp = Integer.parseInt(tmp);
           if(!(lendedTmp > quantityTmp))break;
            System.out.println("The lended amount must not be greater than quantity!");
        }
        while(true){
            System.out.println("Price:");
            priceTmp  = Double.parseDouble(sc1.nextLine()); 
            if(priceTmp>0)break;
            System.out.println("The value must be greater than 0 ");
        }
        return new Book(bcodeTmp,titleTmp,quantityTmp,lendedTmp,priceTmp);
    }
    public void addToHead(Book add){
        Node p = new Node(add,head);
        head = p;
        if(tail == null){
            tail = head;
        }
    }
    public void addToTail(Book add){
        if(!isEmpty()){
            tail.next = new Node(add);
            tail = tail.next;
        }else{
            head = tail = new Node(add);
        }
        
    }
    public void addAfterPosition(int pos,Book add) {
        Node<Book> prev = head,tmp;
        if(pos<1)return;
        if(pos == 1){
            tmp = head.next;
            head.next = new Node(add,tmp);
        }
        else{
            for(int i =1; pos>=i; i++){
                if(prev.next != null){
                    prev = prev.next;
                }
            }
            
            if(prev.next == null){
                prev.next = new Node(add);
            }
            else{
                tmp = prev.next;
                prev.next = new Node(add,tmp);
            }
        }
    }
    //=====================Search&Traverse======================================
    public Book searchInfoByValue(String x) {
        Node<Book> p = head;
        while(p!=null){
            if(p.info.getBcode().toLowerCase().compareTo(x.toLowerCase())==0){
                return p.info;
            }
            p=p.next;
        }
        return null;
    }
    public void traverse(){
        Node<Book> p =head;
        double value;
        if(isEmpty())return;
        while(p!=null){
            value = p.info.getQuantity()*p.info.getPrice();
            System.out.println(p.info.toString()+" | "+value);
            p=p.next;
        }
    }
    //=========================Delete===========================================
    public void deleByCode(String x) {
        Node<Book> p = head;
        String targetString = x.toLowerCase();
        if(p.info.getBcode().compareTo(targetString)==0){
            head = head.next;
            return;
        }
        while(p.next!=null){
            if(p.next.info.getBcode().compareTo(targetString)==0){
                    break;
            }
                p = p.next;
        }  
        if(p.next.next == null){
            p.next = null;
        }else{
            p.next = p.next.next;
        }
    }
    public void deleByPosition(int x){
        if(head == null)return;
        Node<Book> p = head;
        if(x ==0){
            head = p.next;
            return;
        }
        for(int i = 0; p!=null&&i<x-1;i++){
            p = p.next;
        }
        if(p == null || p.next ==null){
            return;
        }
        Node<Book> after = p.next.next;
        p.next = after;
    }
    //===========================Sort===========================================
    void sort(){
        //bubble
        Node<Book> current = head,index;
        Book temp; //swap info only
        while(current!=null){
            index = current.next;
            while(index!=null){
                if(current.info.getBcode().compareTo(index.info.getBcode())>0){
                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
                index = index.next;
            }
            current=current.next;
        }
    }
    //==========================Miscellaneous===================================
    boolean isUnique(String x){
        Node<Book> p = head;
        while(p!= null){
            if(p.info.getBcode().compareTo(x.toLowerCase())==0){
                return false;
            }
            p = p.next;
        }
        return true;
    }
    boolean isEmpty(){
        return head == null;
    }
    public int count(){
        Node<Book> p = head;
        int count=0;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
}