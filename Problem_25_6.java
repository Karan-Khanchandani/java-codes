import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Rotate array without using extra space
*/

public class Problem_25_6{

    public static void rotate_list(List<Integer> list, int n, int num_rot){
        if(num_rot >= n){
            num_rot = num_rot%n;
        }

        for(int i = 0; i < num_rot; i++){
            int last_elem = list.get(n-1);
            int temp = list.get(0);
           
            for(int j = 1 ; j < n; j++){
                int temp1 = list.get(j);
                list.set(j, temp);
                temp = temp1;
            }

            list.set(0, last_elem);
        }
    }

    public static void printList(List<Integer> list){
        for(Integer i: list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));

        rotate_list(list, list.size(), 100);

        printList(list);

    }
}