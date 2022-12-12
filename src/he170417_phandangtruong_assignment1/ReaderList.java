/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he170417_phandangtruong_assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HE170417
 */
public class ReaderList {
    Node<Reader> head, tail;
    Scanner sc2 = new Scanner(System.in);
    
    //===========================IO File Section===========================
    public void loadData(){
        String temp[], tempRcode, tempName;
        int tempByear;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Reader_Data.txt"));
            String line;
            while((line = reader.readLine())!= null){
                temp = line.split(" \\| ");
                tempRcode = temp[0];
                tempName = temp[1];
                tempByear = Integer.parseInt(temp[2]);
                if(!tempRcode.isEmpty()&&!tempName.isEmpty()&&tempByear>0){
                    addToTail(new Reader(tempRcode,tempName,tempByear));
                }
            }
            reader.close();
            System.out.println("Success");
        }catch(IOException ex){
            System.out.println("Error Occur");
            System.out.println(ex);
        }
    }
    public void addToFile(){
        Node<Reader> p = head;
        try{
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("Reader_Data.txt"));
            while(p!= null){
                writer.write(p.info.toString()+"\n");
                p=p.next;
            }
            writer.close();
            System.out.println("Success");
        }catch(IOException ex){
            System.out.println("Error occurs");
            System.out.println(ex);
        }
    }
    //==============================Search&Display==============================
    public Reader searchInfoByValue(String x){
        Node<Reader> p = head;
        while(p!=null){
            if(p.info.getRcode().compareTo(x.toLowerCase())==0){
                return p.info;
            }
            p=p.next;
        }
        return null;
    }
    public void traverse(){
        Node<Reader> p = head;
        if(isEmpty())return;
        while(p!= null){
            System.out.println(p.info.toString());
            p=p.next;
        }
    }
    //=================================Add======================================
    public Reader inputData(){
        String tmpRcode, tmpName;
        int tmpByear;
        while(true){
            System.out.println("Rcode: ");
            tmpRcode = sc2.nextLine();
            if(!tmpRcode.isEmpty()&&isUnique(tmpRcode))break;
            System.out.println("The Rcode is empty or has been taken");
        }
        while(true){
            System.out.println("Name:");
            tmpName = sc2.nextLine();
            if(!tmpName.isEmpty())break;
            System.out.println("Name must not be empty");
        }
        while(true){
            System.out.println("Byear:");
            tmpByear = Integer.parseInt(sc2.nextLine());
            if(tmpByear >1899 && tmpByear <2011 )break;
            System.out.println("Byear must be between 1900 and 2010");
        }
        return new Reader(tmpRcode,tmpName,tmpByear);
    }
    public void addToTail(Reader add){
        if(!isEmpty()){
            tail.next = new Node(add);
            tail = tail.next;
        }else{
            head = tail = new Node(add);
        }
    }
    //==============================Delete======================================
    public void deleByCode(String x){
        Node<Reader> p = head;
        String targetString = x.toLowerCase();
        if(p.info.getRcode().compareTo(targetString)==0){
            head = head.next;
            return;
        }
        while(p.next!=null){
            if(p.next.info.getRcode().compareTo(targetString)==0){
                break;
            }
            p=p.next;
        }
        if(p.next.next == null){
            p.next = null;
        }else{
            p.next = p.next.next;
        }
    }
    //================================Miscellaneous===============================
    boolean isEmpty(){
        return head == null;
    }
    boolean isUnique(String x){
        Node<Reader> p = head;
        while(p!=null){
            if(p.info.getRcode().compareTo(x.toLowerCase())==0){
                return false;
            }
            p=p.next;
        }
        return true;
    }
}

