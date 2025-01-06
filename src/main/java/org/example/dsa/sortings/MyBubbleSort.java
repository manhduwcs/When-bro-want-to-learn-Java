package org.example.dsa.sortings;

public class MyBubbleSort {
    public static <T extends Comparable<T>> T[] arrayBubbleSortDecreasing(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int comp = arr[i].compareTo(arr[j]);
                if (comp < 0) {
                    T cur = arr[i];
                    arr[i] = arr[j];
                    arr[j] = cur;
                    System.out.print(i + " ");
                }
            }
        }
        return arr;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (left < 0) return false;
            int mid = left + ((right - left) / 2);
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 9, 10};
        int target = 8;
        boolean res = binarySearch(nums, target);
        if (res) System.out.println("target found");
        else System.out.println("cannot find target");
    }
}
