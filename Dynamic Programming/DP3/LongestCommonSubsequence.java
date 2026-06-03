public class LongestCommonSubsequence {
    public static int LCS(String str1, String str2, int n, int m){
        if(n==0 || m ==0){
            return 0;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return LCS(str1, str2, n-1, m-1) + 1;
        }else{
            int a1 = LCS(str1, str2, n-1, m);
            int a2 = LCS(str1, str2, n, m-1);
            return Math.max(a1, a2);
        }
    }
    public static void main(String args[]){
        String str1 = "abcdge";
        String str2 = "abde";
        System.out.println(LCS(str1, str2, str1.length(), str2.length()));
    }
}