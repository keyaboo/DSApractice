package com.leetcode.accepted;

public class RotatingBox_1861 {
    /*
    this is like snowball problem. that was fast & slow pointer iirc
    I didn't really think through the k term or how the rotation was happening
     */
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (char[] row : box) {
            int j = 0; // this can be for white spaces, default dropoff point reassigned to whenever we hit a wall
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '.') {
                    swap(row, i, j++);
                } else if (row[i] == '*') {
                    j = i + 1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                res[j][i] = box[m - i - 1][j];
            }
        }
        return res;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
