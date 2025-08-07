public class Array_L1 {
    public static void main(String[] args) {
        int a[] = {-128, 65, -235, 99, 0, 26};
        int minIndex = findMinIndex(a);
        int maxIndex = findMaxIndex(a);
        System.out.println("Min value is a["+minIndex+"] = " + a[minIndex]);
        System.out.println("Max value is a["+maxIndex+"] = " + a[maxIndex]);
    }

    public static int findMinIndex(int[] a) {
        int k, minIdx = 0;
        for (k = 1; k < a.length; k++) {
            if (a[k] < a[minIdx]) {
                minIdx = k;
            }
        }
        return minIdx;
    }
    public static int findMaxIndex(int[] a) {
        int k, maxIdx = 0;
        for (k = 1; k < a.length; k++) {
            if (a[k] > a[maxIdx]) {
                maxIdx = k;
            }
        }
        return maxIdx;
    }
}