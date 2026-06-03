public class binaryString {
    public static void bs(int n, int Lastspace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        bs(n-1, 0, str+ "0");
        if(Lastspace==0){
            bs(n-1, 1, str+"1");
        }
    }
    public static void main(String args[]){
        bs(5, 0, "");
    }
}