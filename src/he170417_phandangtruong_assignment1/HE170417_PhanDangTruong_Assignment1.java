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
public class HE170417_PhanDangTruong_Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //3main list
        BookList bookLs = new BookList();
        ReaderList readerLs = new ReaderList();
        LendingList lendinglist = new LendingList(bookLs,readerLs);
        //General
        while(true){
            int outerInput;
            int input, indexTarget;
            Scanner sc = new Scanner(System.in);
            boolean isRunning = true;
            System.out.println("=========Book management system=========");
            System.out.println("1. Book Management");
            System.out.println("2. Reader Management");
            System.out.println("3. Lending List");
            System.out.println("0. Exit");
            System.out.println("your input: ");
            outerInput = Integer.parseInt(sc.nextLine());
            if(outerInput == 0)break;
            switch(outerInput){
                case 1:
                    //=====================Book Section=========================
                    String searchTarget;
                    while(isRunning){
                        MenuConsole(1);
                        System.out.println("Your input: ");
                        input = Integer.parseInt(sc.nextLine());
                        switch(input){
                            case 1:
                                bookLs.addToTail(bookLs.inputData());
                                System.out.println();
                                System.out.flush();
                                break;
                            case 2:
                                System.out.println("================List================");
                                System.out.println("code | Title    | Quantity  | lended | Price | Value");
                                System.out.println("----------------------------------------------------");
                                bookLs.traverse();
                                System.out.println("====================================");
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Input bcode:");
                                searchTarget = sc.nextLine();
                                System.out.println(bookLs.searchInfoByValue(searchTarget).toString());
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Input bcode:");
                                searchTarget = sc.nextLine();
                                bookLs.deleByCode(searchTarget);
                                System.out.println("Complete!");
                                System.out.println();
                                break;
                            case 5:
                                bookLs.sort();
                                System.out.println("====");
                                bookLs.traverse();
                                System.out.println();
                                break;
                            case 6:
                                bookLs.addToHead(bookLs.inputData());
                                break;
                            case 7:
                                System.out.println("Please enter the position:");
                                indexTarget = Integer.parseInt(sc.nextLine());
                                bookLs.addAfterPosition(indexTarget, bookLs.inputData());
                                break;
                            case 8:
                                System.out.println("Please enter the position:");
                                indexTarget = Integer.parseInt(sc.nextLine());
                                bookLs.deleByPosition(indexTarget);
                                System.out.println("Complete!");
                                break;
                            case 9:
                                System.out.println("Processing to save to file...");
                                bookLs.addToFile();
                                System.out.println();
                                break;
                            case 10:
                                System.out.println("Processing to read data from file");
                                bookLs.LoadData();
                                System.out.println();
                                break;
                            default:
                                isRunning = false;
                        }
                    }
                    break;
                case 2: 
                    //==================Reader Management Section===================
                    String searchTarger;
                    while(isRunning){
                        MenuConsole(2);
                        System.out.println("Your input");
                        input = Integer.parseInt(sc.nextLine());
                        switch(input){
                            case 1:
                                System.out.println("Processing to read data from file");
                                readerLs.loadData();
                                System.out.println();
                                break;
                            case 2:
                                readerLs.addToTail(readerLs.inputData());
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("=================List=================");
                                System.out.println("Rcode | Name | Byear");
                                readerLs.traverse();
                                System.out.println("======================================");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Processing to save data to file");
                                readerLs.addToFile();
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("Input Rcode");
                                searchTarget = sc.nextLine();
                                System.out.println("Rcode | Name | Byear");
                                System.out.println(readerLs.searchInfoByValue(searchTarget));
                                System.out.println();
                                break;
                            case 6:
                                System.out.println("Input Rcode");
                                searchTarget = sc.nextLine();
                                readerLs.deleByCode(searchTarget);
                                System.out.println("Complete");
                                System.out.println();
                                break;
                            default:
                                isRunning = false;
                        }
                    }
                    break;
                case 3:
                    //==========================Lending Manager=====================
                    readerLs.loadData();
                    bookLs.LoadData();
                    while(isRunning){
                        MenuConsole(3);
                        System.out.println("Your input:");
                        input = Integer.parseInt(sc.nextLine());
                        switch(input){
                            case 1:
                                lendinglist.addToHead(lendinglist.inputData());
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("===========Lending list===========");
                                System.out.println("Bcode | RCode | state");
                                lendinglist.traverse();
                                System.out.println("==================================");
                                System.out.println();
                                break;
                            case 3:
                                lendinglist.sort();
                                lendinglist.traverse();
                                System.out.println();
                                break;
                            default:
                                isRunning = false;
                                break;
                        }
                    }
                    break;
            }
        }
    }
    public static void MenuConsole(int i ){
        switch(i){
            case 1:
                System.out.println("==============Book Management==============");
                System.out.println("Please choose an option below:");
                System.out.println("1. Input & add new data to the end");
                System.out.println("2. Display Data");
                System.out.println("3. Search by bcode");
                System.out.println("4. Delete by bcode");
                System.out.println("5. Sort by bcode");
                System.out.println("6. Input & add new data to the beginning");
                System.out.println("7. Add after position k");
                System.out.println("8. Delete position k");
                System.out.println("9. Save data to file");
                System.out.println("10 Load data from file");
                System.out.println("0. Exit");
                System.out.println("===========================================");  
                break;
            case 2:
                System.out.println("===========Reader Management===============");
                System.out.println("Please choose an option below:");
                System.out.println("1. Load data from file");
                System.out.println("2. Input & add to the end");
                System.out.println("3. Display data");
                System.out.println("4. Save reader list to file");
                System.out.println("5. Search by Rcode");
                System.out.println("6. Delete by Rcode");
                System.out.println("0. Exit");
                System.out.println("===========================================");
                break;
            case 3:
                System.out.println("===============Lending List===============");
                System.out.println("1. Input data");
                System.out.println("2. Display data");
                System.out.println("3. Sort by bcode+rcode");
                System.out.println("0. Exit");
                System.out.println("===========================================");
                break;
            default:
                break;
        }

    }
}
