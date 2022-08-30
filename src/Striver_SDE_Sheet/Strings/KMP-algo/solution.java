package Striver_SDE_Sheet.Strings.KMP-algo;

public class solution{
    public static void main(String[] args) {
        String haystack="hello"
        String needle="ll"
       int ans= strStr( haystack, needle);
       System.out.println(ans);
    }
    //using kmp algorithm
    public int strStr(String str, String pat) {
        if(str.equals("") && pat.equals("")) return 0;
        if(pat.equals("")) return 0;
        int[] reset = new int[pat.length() + 1];
        int i = 0,j = 0;
        kmpPreprocess(reset,pat);
        while(i < str.length()){
            while(j >= 0 && str.charAt(i) != pat.charAt(j)){
                j = reset[j];
            }
            i++;j++;
            if(j == pat.length()) return i - j;
        }
        return -1;
    }
    public void kmpPreprocess(int[]reset,String pat){
        int i = 0,j = -1;
        reset[0] = -1;
        while(i < pat.length()) {
            while(j >= 0 && pat.charAt(i) != pat.charAt(j)) {
                j = reset[j];
            }
            i++; j++;
            reset[i] = j;
        }
    }
}