public class CatlanRecursion {
    public static int cr(int n){
        if(n==0 || n == 1){
            return 1;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += cr(i) * cr(n-i-1);
        }
        return ans;
    }
    public static void main(String args[]){
        int n = 3;
        System.out.println(cr(n));
    }
}
