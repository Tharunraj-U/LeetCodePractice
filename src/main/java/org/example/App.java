package org.example;
public class App 
{
    public static void main( String[] args )
    {

        MyCircularDeque obj = new MyCircularDeque(5);

        boolean param_1 = obj.insertFront(7);
        boolean param_2 = obj.insertLast(0);
        int param_5 = obj.getFront();
        boolean param_ = obj.insertLast(3);
        param_5 = obj.getFront();
        boolean pa = obj.insertFront(9);

        boolean param_4 = obj.deleteLast();

        int param_6 = obj.getRear();

    }
}
