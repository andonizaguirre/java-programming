
import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        MainProgram.sort(numbers);
    }

    public static int smallest(int[] array) {
        int smallest = array[0];
//        int smallest = Integer.MAX_VALUE;
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        return indexOfSmallestFrom(array, 0);
//        return MainProgram.indexOfSmallestFrom(array, 0);
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        int index = startIndex;
        int smallest = table[startIndex];
        for (int i = startIndex; i < table.length; i++) {
            if (table[i] < smallest) {
                smallest = table[i];
                index = i;
            }
        }
        return index;
//        int placeOfSmallest = startIndex; 
//        int index = startIndex;
//        while (index < array.length) {
//            if (array[index] < array[placeOfSmallest]) {
//                placeOfSmallest = index;
//            } 
//            index = index + 1;
//        } 
//        return placeOfSmallest;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = 0;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
//            System.out.println(Arrays.toString(array));
            int indexOfSmallest = indexOfSmallestFrom(array, i);
            swap(array, i, indexOfSmallest);
        }
    }
}
