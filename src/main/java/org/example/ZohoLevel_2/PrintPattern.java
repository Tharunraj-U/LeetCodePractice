package org.example.ZohoLevel_2;

class PrintPattern
{
/*method prints the given pattern in a single line */
	void printPattern(String s)
	{
	    int n=s.length();
	    int n1=n/2;
	    String s1="";
	    for(int i=n1;i<n+(n1);i++){
	         int i1=i%n;
	        char c=s.charAt(i1);
	        s1+=c;
	        System.out.print(s1+"$ ");
	    }
	    
	}
}