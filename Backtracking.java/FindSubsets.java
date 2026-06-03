public class FindSubsets {
    public static void fs(String str, String ans, int i){
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }   
            return;
        }
        fs(str, ans + str.charAt(i), i+1);
        fs(str, ans, i+1);
    }

    public static void main(String args[]) {
        String str = "abc";
        String ans = "";
        fs(str, ans, 0);
    }
}
