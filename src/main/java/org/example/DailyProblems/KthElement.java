package org.example.DailyProblems;

class  KthElement {
    public int kthElement(int a[], int b[], int k) {
        int j1=0,j2=0,ans=0;
    for(int i=0;i<k;i++){
        if( j1 < a.length && ( j2 >= b.length ||  a[j1] <= b[j2])){
            ans=a[j1];
            j1++;
        }
        else if( j2 < b.length ){
            ans=b[j2];
            j2++;
           
        }
    }
    return ans;
    }
}