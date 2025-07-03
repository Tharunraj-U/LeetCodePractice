class KthCharacter {
    public char kthCharacter(int k) {
        String s="a";
        while(s.length() < k){
           StringBuilder sb=new StringBuilder();
           sb.append(s);
           for(int i=0;i<s.length();i++){
               sb.append((char)(((s.charAt(i)-'a'+1)%26)+'a'));
           }
           s=sb.toString();
        }
        return s.charAt(k-1);

    }
}