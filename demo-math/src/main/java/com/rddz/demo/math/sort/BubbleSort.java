package com.rddz.demo.math.sort;

/**
 * 冒泡排序演示类
 * 特点：简单易懂，但时间复杂度为 O(n²)，适合教学演示
 */
public class BubbleSort implements BaseSort {

    /**
     * 优化的冒泡排序实现
     * @param arr 待排序数组
     */
    @Override
    public void execute(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // 外层循环控制遍历次数
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // 内层循环进行相邻元素比较
            // 优化点：每次遍历后，最大的元素已经沉底，可以减少比较次数
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                //可在内层循环中添加打印语句，实时显示排序过程
//                System.out.println("第 " + (i+1) + " 轮，第 " + (j+1) + " 次比较: " + Arrays.toString(arr));
            }

            // 如果本轮没有交换，说明数组已有序，提前终止
            if (!swapped) break;
        }
    }

}
