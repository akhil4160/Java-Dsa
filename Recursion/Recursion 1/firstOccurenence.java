public class firstOccurenence {
    public static int fo(int arr[], int i, int key) {
        if(arr[i] == key) {
            return i;
        }
        if(i == arr.length) {
            return -1;
        }
        return fo(arr, i+1, key);
    }
    public static void main(String args[]){
        int arr[] = {2,4,6,7,3,5,2,3,6};
        System.out.println(fo(arr, 0, 3));
    }
}