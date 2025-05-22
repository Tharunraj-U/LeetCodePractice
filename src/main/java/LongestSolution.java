import java.util.*;

class LongestSolution {
    static List<String> ans=new ArrayList<>();
    public  static List<String> getLongestSubsequence(String[] words, int[] groups) {
      hel(words, groups,0,-1,new ArrayList<>());  
      return ans;
    }
    public static void hel(String[] word,int[] groups,int i,int prev,List<String> list){
        if(i>word.length){

            return;
        }
        if(list.size() > ans.size()){
            ans=new ArrayList<>(list);
        }
        if(prev == -1 || groups[i] != prev){
            list.add(word[i]);
            hel(word,groups,i+1,groups[i],list);
            list.remove(list.size()-1);
        }else if(prev == -1 || groups[i] != prev ){
             list.add(word[i]);
             hel(word,groups,i+1,groups[i],list);
              list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
          getLongestSubsequence(new String[]{"e","a"},new int[]{0,0});
    }
}