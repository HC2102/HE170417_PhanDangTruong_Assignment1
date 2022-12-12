/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he170417_phandangtruong_assignment1;

/**
 *
 * @author HE170417
 * @param <T>
 */
public class Node <T>{
    T info;
    Node<T> next;

    public Node() {
    }

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this(info,null);
    }
    
    
}
