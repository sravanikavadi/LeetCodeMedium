import java.io.*;
import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DoubleLinkedListNode {
    int data;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;
    DoubleLinkedListNode(){
    }
    DoubleLinkedListNode(int x){
        this.data = x;
        this.next = null;
        this.prev = null
    }
    void setData(int date) {
       this.data = data;
    }
    int getData(DoubleLinkedListNode node) {
        return node.data;
    }
    void setNext(DoubleLinkedListNode node) {
        this.next = node;
    }
    DoubleLinkedListNode getNext(){
        return node.next;
    }
    void setPrev(DoubleLinkedListNode node) {
        this.prev = node;
    }
    DoubleLinkedListNode getPrev(){
        return node.prev;
    }
}
public class LRUCache {
    int capacity = 2;
    public void addNode(DoubleLinkedListNode node){

    }
    public void removeNode(DoubleLinkedListNode node){

    }
    public void moveNodeToFirst(DoubleLinkedListNode node){

    }
    public void getNode(DoubleLinkedListNode node){

    }
    public static void main(String args[]) {

    }
}