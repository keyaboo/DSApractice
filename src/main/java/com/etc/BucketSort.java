package com.etc;

import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;

        System.out.println("Creating " + n + " buckets.");
        List<List<Float>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new LinkedList<>()); // Or new ArrayList<>()
        }

        System.out.println("Scattering elements into buckets:");
        for (int i = 0; i < n; i++) {
            float num = arr[i];
            int bucketIndex = (int) (n * num);
            buckets.get(bucketIndex).add(num);
            System.out.println("Element " + num + " added to bucket " + bucketIndex);
        }

        System.out.println("\nSorting each bucket:");
        for (int i = 0; i < n; i++) {
            if (!buckets.get(i).isEmpty()) {
                System.out.println("Sorting bucket " + i + ": " + buckets.get(i));
                Collections.sort(buckets.get(i));
                System.out.println("Sorted bucket " + i + ": " + buckets.get(i));
            }
        }

        System.out.println("\nGathering elements from buckets:");
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets.get(i)) {
                arr[index++] = num;
                System.out.println("Element " + num + " placed in the output array.");
            }
        }

    }

    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        System.out.println("Original array: " + Arrays.toString(arr));
        bucketSort(arr);
        System.out.println("\nFinal sorted array: " + Arrays.toString(arr));
    }

}
