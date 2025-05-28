package com.rddz.demo.math.sort;

import java.util.Arrays;

/**
 * 排序演示
 */
public class SortExample {


    /** 冒泡排序 */
    static BaseSort  bubbleSort = new BubbleSort();
    /** 快速排序 */
    static BaseSort quickSort = new QuickSort();
    /** 归并排序 */
    static BaseSort mergeSort = new MergeSort();


    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5, 3, 6, 2};
        if (arr == null || arr.length < 2) return;

        System.out.println("原始数组: " + Arrays.toString(arr));
        long startTime = System.nanoTime();

        // 执行排序
        mergeSort.execute(arr);

        long endTime = System.nanoTime();
        System.out.println("排序后数组: " + Arrays.toString(arr));
        System.out.println("排序耗时: " + (endTime - startTime) + " 纳秒");

    }


    /*

冒泡排序	BubbleSort	直观体现“冒泡”和“演示”用途
快速排序	QuickSort	强调“快速”特性，适合教学示例
归并排序	MergeSort	Impl 表明是具体实现
插入排序	InsertionSort	若需可视化步骤，可用 Visualizer
选择排序	SelectionSort	强调“算法”本身
堆排序	HeapSort	若需性能测试，用 Benchmark
希尔排序	ShellSort	简洁标注基础实现
基数排序	RadixSort	若为并行实现，标注优化方向


     */


}
