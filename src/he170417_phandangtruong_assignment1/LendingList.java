/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he170417_phandangtruong_assignment1;
import java.util.Scanner;
/**
 *
 * @author HE170417
 */
public class LendingList {
    BookList bookls;
    ReaderList readerls;
    public LendingList(BookList bookls, ReaderList readerls){
        this.bookls = bookls;
        this.readerls = readerls;
    }
    Node<Lending> head, tail;
    Scanner sc3 = new Scanner(System.in);
    //===============================Miscellaneous==============================
    boolean isEmpty(){
        return head == null;
    }
    //===============================Traverse===================================
    public void traverse(){
        if(isEmpty())return;
        Node<Lending> p = head;
        while(p!=null){
            System.out.println(p.info.toString());
            p=p.next;
        }
    }
    //====================================Add====================================
    public Lending inputData(){
        String tempRcode, tempBcode;
        int tempState=2;
            
        while(true){
            System.out.println("input Bcode");
            tempBcode = sc3.nextLine().toLowerCase();
            if(!tempBcode.isEmpty())break;
            System.out.println("Bcode must not be empty");
        }
        while(true){
            System.out.println("Rcode");
            tempRcode = sc3.nextLine().toLowerCase();
            if(!tempRcode.isEmpty())break;
            System.out.println("Rcode must not be empty");
        }

        //check state valid 
        //if bcode are found and rcode are found
        if(bookls.searchInfoByValue(tempBcode)!=null&&readerls.searchInfoByValue(tempRcode)!=null){
            System.out.println("Found!");
            //if state is not 1 
            if(tempState !=1){
                //if(lended = quantity 
                System.out.println("State is not equal to 1");
                if(bookls.searchInfoByValue(tempBcode).getLended() == bookls.searchInfoByValue(tempBcode).getQuantity()){
                    tempState = 0;
                    System.out.println("lended == value");
                }
                //if lended < quantity
                else if(bookls.searchInfoByValue(tempBcode).getLended() < bookls.searchInfoByValue(tempBcode).getQuantity()){
                    tempState = 1;
                    System.out.println("Lend<quantity");
                    bookls.searchInfoByValue(tempBcode).setLended(bookls.searchInfoByValue(tempBcode).getLended()+1);
                    }
                }
        }else{
            System.out.println("Value not accepted");
            return null;
        }
        //save section;
        bookls.addToFile();
        readerls.addToFile();
        return new Lending(tempBcode,tempRcode,tempState);
    }
    public void addToHead(Lending add){
        Node p = new Node(add,head);
        head = p;
        if(tail==null){
            tail = head;
        }
    }
    //===================================sort===================================
    public void sort(){
        Node<Lending> current = head;
        Node<Lending> index;
        Lending tmp;
        while(current!=null){
            index = current.next;
            while(index!= null){
                if(current.info.getBcode().compareTo(index.info.getBcode())>0){
                    tmp= current.info;
                    current.info = index.info;
                    index.info = tmp;
                }
                if(current.info.getBcode().compareTo(index.info.getBcode())==0){
                    if(current.info.getRcode().compareTo(index.info.getRcode())>0){
                        tmp = current.info;
                        current.info  = index.info;
                        index.info = tmp;
                    }
                }
                index =index.next;
            }
            current = current.next;
        }
    }
}
