package com.rddz.demo.math.sort;

import java.util.Arrays;

/**
 * 归并排序演示类
 * 特点：稳定排序，时间复杂度 O(n log n)，空间复杂度 O(n)
 *
 * 思路：
 * 分解：将待排序数组递归地分成两个长度相等的子数组，直到每个子数组只包含一个元素或为空
 * 合并：将两个已排序的子数组合并成一个有序数组。合并时，比较两个子数组的第一个元素，选择较小的元素放入结果数组，并继续比较下一个元素，直到所有元素都被合并
 * 递归：对子数组递归地执行分解和合并操作，直到整个数组有序
 */
public class MergeSort implements BaseSort{

    @Override
    public void execute(int[] arr) {
        mergeSort(arr);
    }

    /**
     * 递归实现归并排序
     */
    private static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        //将arr分成两个子数组
        int mid = arr.length / 2;
        int[] tempLeftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] tempRightArr = Arrays.copyOfRange(arr, mid, arr.length);

        //递归处理
        mergeSort(tempLeftArr);
        mergeSort(tempRightArr);

        // 合并两个有序数组
        int tempLeftArrIndex = 0;
        int tempRightArrIndex = 0;
        for (int i = 0; i < arr.length; i++){
            if (tempLeftArrIndex >= tempLeftArr.length){
                arr[i] = tempRightArr[tempRightArrIndex++];
            } else if (tempRightArrIndex >= tempRightArr.length){
                arr[i] = tempLeftArr[tempLeftArrIndex++];
            } else if (tempLeftArr[tempLeftArrIndex] < tempRightArr[tempRightArrIndex]){
                arr[i] = tempLeftArr[tempLeftArrIndex++];
            } else {
                arr[i] = tempRightArr[tempRightArrIndex++];
            }
        }
    }

}
