import java.io.FilterReader;

public class MergeSort {
    public static void main(String[] args) {
        printArray(merge(new int[]{1, 5, 7}, new int[]{0, 3, 10}));
        printArray(mergeSort(new int[]{10, 3, 5, 1, 9, 4, 6}));
    }

    private static void printArray(int[] toPrint) {
        System.out.print("[");
        for(int i = 0; i < toPrint.length - 1; i++) {
            System.out.print(toPrint[i] + ", ");
        }
        System.out.println(toPrint[toPrint.length - 1] + "]");
    }

    private static int[] mergeSort(int[] input) {
        if(input.length == 1) {
            return input;
        }
        //the first array might have to be longer than the second array by 1
        int firstLength = input.length / 2;
        if(input.length % 2 != 0) {
            firstLength ++;
        }

        //copy sections of arrays
        int[] first = new int[firstLength];
        for(int i = 0; i < firstLength; i++) {
            first[i] = input[i];
        }
        int[] second = new int[input.length - firstLength];
        int sIndex = 0;
        for(int i = firstLength; i < input.length; i++) {
            second[sIndex++] = input[i];
        }

        //first are copied when split, so nothing happens with the data already on the heap
        //=> we have to reassign
        first = mergeSort(first);
        second = mergeSort(second);
        return merge(first, second);
    }

    public static int[] copy(int[] toCopy) {
        int[] copy = new int[toCopy.length];
        for(int i = 0; i < toCopy.length - 1; i++) {
            copy[i] = toCopy[i];
        }
        return copy;
    }

    private static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int counter = 0;
        int i = 0, j = 0;
        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]) {
                result[counter] = first[i];
                counter++;
                i++;
            } else {
                result[counter] = second[j];
                counter++;
                j++;
            }
        }
        //add the rest
        if(i < first.length) {//first array is bigger, add rest of it
            result[counter] = first[i];
            counter++;
            i++;
        }
        else if(j < second.length) {//second array is bigger, add rest of it
            result[counter] = second[j];
            counter++;
            j++;
        }
        return result;
    }
}