package problem;/*
Problem Description:
find first occurence of k in sorted array
*/

public class Problem_12_1{

    public static int binary_search(int arr[], int low, int high, int key){
        int result  = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == key){
                result = mid;
                high = mid - 1;
            }
            else if(arr[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-14, -10, 2 ,108 ,108 ,243 ,285 ,285 ,285 ,401, 500};

        int key = 108;
        int index = binary_search(arr, 0, arr.length-1 , key);
        if(index != -1)
        System.out.println(key + " -> " + index);

        key = 401;
        index = binary_search(arr, 0, arr.length-1 , key);
        if(index != -1)
        System.out.println(key + " -> " + index);

        key = -14;
        index = binary_search(arr, 0, arr.length-1 , key);
        if(index != -1)
        System.out.println(key + " -> " + index);

        key = 285;
        index = binary_search(arr, 0, arr.length-1 , key);
        if(index != -1)
        System.out.println(key + " -> " + index);

        key = -100;
        index = binary_search(arr, 0, arr.length-1 , key);
        System.out.println(key + " -> " + index);

        key = 243;
        index = binary_search(arr, 0, arr.length-1 , key);
        System.out.println(key + " -> " + index);
    }
}