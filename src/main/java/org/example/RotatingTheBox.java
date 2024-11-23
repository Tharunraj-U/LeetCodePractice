package org.example;
public class RotatingTheBox {
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m=box[0].length;
            int n=box.length;

            for(int i=0;i<n;i++){
                int c=m-1;
                for(int j=m-1;j>=0;j--){
                    if(box[i][j] == '#'){
                        box[i][j]='.';
                        box[i][c]='#';
                        c--;
                    }
                    else  if(box[i][j] == '*'){
                        c=j-1;

                    }

                }


            }

            char[][] box2=new char[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    box2[i][j]=box[n-1-j][i];
                }
            }
           // Arrays.stream(box2).forEach(e-> System.out.println(Arrays.toString(e)));
            return box2;
        }
    }
}
