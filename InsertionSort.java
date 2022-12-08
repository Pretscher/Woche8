public class InsertionSort {
    private static int[] insertionSort(int[] numbers) {
        int[] copy = copyArray(numbers);

        for(int currentIndex = 1; currentIndex < copy.length; currentIndex++) {
            int currentNumber = copy[currentIndex];
            int newPosition = currentIndex;
            while(newPosition > 0 && copy[newPosition - 1] > currentNumber) {
                copy[newPosition] = copy[newPosition - 1];
                newPosition--;
            }
            copy[newPosition] = currentNumber;
        }
        return copy;
    }

    public static void main(String[] args) {
        int[] toSort = new int[]{1,-5,9,10,12,0,4,2};
        printArray(insertionSort(toSort));
        printArray(toSort);
    }

    private static void printArray(int[] toPrint) {
        System.out.print("[");
        for(int i = 0; i < toPrint.length - 1; i++) {
            System.out.print(toPrint[i] + ", ");
        }
        System.out.println(toPrint[toPrint.length - 1] + "]");
    }

    private static int[] copyArray(int[] toCopy) {
        int[] copy = new int[toCopy.length];
        for(int i = 0; i < toCopy.length; i++) {
            copy[i] = toCopy[i];
        }
        return copy;
    }
}
