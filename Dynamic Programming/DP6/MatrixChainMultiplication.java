public class MatrixChainMultiplication {
    public static int mcm(int i, int j, int arr[]){
        if(i == j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int cost1 = mcm(i, k, arr);
            int cost2 = mcm(k+1, j, arr);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int FinalCost = cost1 + cost2 +cost3;
            ans = Math.min(FinalCost, ans);
        } 
        return ans;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        System.out.println(mcm(1, n-1, arr));
    }
}