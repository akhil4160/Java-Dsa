public class lastOccurence {
    public static int lo(int arr[], int key, int i) {
        if(i==arr.length) {
            return -1;
        }
        int isFound = lo(arr, key, i+1);
        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound;

    }
    public static void main(String args[]){
        int arr[] = {2,4,6,2,5,3,7,4};
        System.out.println(lo(arr, 2, 0));
    }
}
