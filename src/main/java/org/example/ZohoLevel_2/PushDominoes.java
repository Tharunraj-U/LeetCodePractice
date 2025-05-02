package org.example.ZohoLevel_2;

class PushDominoes {
    public String pushDominoes(String db) {
        char arr[]=db.toCharArray();
        int lastSeen=0,lastChar='.';

        for(int i=0;i<db.length();i++){
            if(arr[i] != '.'){
                if(lastChar=='.' && arr[i] =='L' || lastChar=='L' && arr[i] =='L' ){
                    left(lastSeen,i,arr);
                }else  if(lastChar=='R' && arr[i] =='L'){
                    rightAndLeft(lastSeen,i,arr);
                }else if(lastChar=='R' && arr[i] =='R'){
                    right(lastSeen,i,arr);
                }
                lastSeen=i;
                lastChar=arr[i];
            }
        }
        if(lastChar=='R'){
              right(lastSeen,arr.length-1,arr);
        }
        return new String(arr);
    }
    public void right(int i,int j,char arr[]){
        while(i<=j){
            arr[i++]='R';
            arr[j--]='R';
        }
    }
    public void left(int i,int j,char arr[]){
        while(i<=j){
            arr[i++]='L';
            arr[j--]='L';
        }
    }
    public void rightAndLeft(int i,int j,char arr[]){
        while(i<j){
            arr[i++]='R';
            arr[j--]='L';
        }
    }
}