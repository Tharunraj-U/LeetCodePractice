package org.example.Heap;

public class maxHeap {
     int arr[]=new int[10];
     int i=0;
     int parent(int index){
         return (index-1)/2;
     }
     int lefChild(int index){
         return (index*2)+1;
     }
     int rightChild(int index){
         return (index*2)+2;
     }

     void add(int val){
         if(i==0){
             arr[i]=val;
             i++;
             return;
         }
         arr[i]=val;
         upHeap(i);
         i++;
         }

       int poll(){
         if(i<=0)return -1;
         int val=arr[0];
         arr[0]=arr[i-1];
         downHeap(0);
         i--;
         return val;
       }
     void downHeap(int index){

         int leftChild=lefChild(index);
         int rightChild=rightChild(index);

         if(leftChild < i &&  arr[index] < arr[leftChild] ){
             swap(leftChild,index,arr);

             downHeap(leftChild);

         }if(rightChild < i &&  arr[index] < arr[rightChild]){
             swap(rightChild,index,arr);
             downHeap(rightChild);
         }
     }
     void upHeap(int index){
         if(index<=0)return;
         int parIndex=parent(index);
         if(parIndex > -1  &&  arr[parIndex] < arr[index]){
             swap(parIndex,index,arr);
              upHeap(parIndex);
         }
     }

     void swap(int index1,int index2,int arr[]){
         int temp=arr[index1];
         arr[index1]=arr[index2];
         arr[index2]=temp;
     }

    public static void main(String[] args) {
        maxHeap maxHeap=new maxHeap();
        maxHeap.add(9);
        maxHeap.add(6);
        maxHeap.add(100);
        maxHeap.add(7);
        maxHeap.add(1);
        maxHeap.add(0);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }


}
