package com.rddz.demo.math.sort;

/**
 * 快速排序演示类
 * 特点：平均时间复杂度 O(n log n)，采用分治策略
 *
 * 思路：
 * 1、从待排序数组中选择一个元素作为基准（pivot），通常选择第一个或最后一个元素，也可以随机选择
 * 2、通过一趟排序将数组分为左右两部分，使得左边所有元素小于等于基准元素，右边所有元素大于等于基准元素
 * 3、对左右两部分分别递归地进行快速排序，直到子数组长度为0或1，此时数组已有序
 */
public class QuickSort implements BaseSort {

    @Override
    public void execute(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序递归实现
     * @param arr  待排序数组
     * @param lowIndex  起始索引
     * @param highIndex 结束索引
     */
    public static void quickSort(int[] arr,int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        // 获取分区点索引
        int pivotIndex = partition(arr, lowIndex, highIndex);

        // 递归排序左右子数组
        quickSort(arr, lowIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, highIndex);
    }

    /**
     * 分区操作（核心逻辑）
     * @return 基准值的正确位置索引
     */
    private static int partition(int[] arr, int lowIndex, int highIndex) {
        // 取最后的值作为基准(pivot)，示例：{10, 7, 8, 9, 1, 5, 3, 2, 6}
        int pivot = arr[highIndex]; // 6

        int pivotIndex = lowIndex; // 记录基准值最终该放置的位置，默认为起始下标

        /*
            第1次遍历，1与10换位置：{1, 7, 8, 9, 10, 5, 3, 2, 6}，下标=1
            第2次遍历，5与7换位置：{1, 5, 8, 9, 10, 7, 3, 2, 6}，下标=2
            第3次遍历，3与8换位置：{1, 5, 3, 9, 10, 7, 8, 2, 6}，下标=3
            第4次遍历，2与9换位置：{1, 5, 3, 2, 10, 7, 8, 9, 6}，下标=4
         */
        for (int j = lowIndex; j < highIndex; j++) {
            if (arr[j] <= pivot) {
                swap(arr, pivotIndex, j);
                pivotIndex++;
            }
        }

        // 将基准值6放到正确位置，6与10换位置：{1, 5, 3, 2, 6, 7, 8, 9, 10}，并返回基准值6的索引4
        swap(arr, pivotIndex, highIndex);
        return pivotIndex;
    }

    /**
     * 交换数组元素
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
