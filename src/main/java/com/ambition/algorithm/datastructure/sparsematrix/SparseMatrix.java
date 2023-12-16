package com.ambition.algorithm.datastructure.sparsematrix;

/**
 * @author Ambition
 * @date 2023/10/23 16:21
 * 稀疏矩阵
 * 将普通的二维数组转成稀疏数组
 * 原始的二维数组 第二行第三列有值 值为1 第三行第四列有值 值为2 其他的都是0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 1 0 0 0 0 0 0 0
 * 0 0 0 2 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 稀疏数组 记录原始数组的行数 列数 有效值的个数
 * row low value
 * 10   10  2   记录原始数组的行数 列数 有效值的个数
 * 3    2   1
 * 4    3   2
 */
public class SparseMatrix {


    /**
     * 将二维数组转成稀疏数组
     * 二维数组的行数和列数是固定的
     * 稀疏数组的行数是二维数组的有效值个数+1
     * 稀疏数组的列数是固定的3列
     * 稀疏数组的第一行记录二维数组的行数 列数 有效值的个数
     * 稀疏数组的其他行记录二维数组的有效值的行数 列数 值
     * 二维数组的有效值的个数 = 二维数组的行数*二维数组的列数
     * 二维数组的有效值的行数 = 二维数组的行数*二维数组的列数
     * 二维数组的有效值的列数 = 3
     *
     * @param twoArray 二维数组
     * @return 稀疏数组
     */
    private static int[][] twoArrayToSparseArray(int[][] twoArray) {
        int sum = 0;
        for (int[] ints : twoArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效值的个数" + sum);
//        新建新的稀疏数组
//        创建一个index 用来记录是第几个有效值
        int index = 1;
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = twoArray.length;
        sparseArray[0][1] = twoArray[0].length;
        sparseArray[0][2] = sum;
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                if (twoArray[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = twoArray[i][j];
                    index++;
                }
            }
        }
        return sparseArray;
    }


    /**
     * 将稀疏数组转成二维数组
     * 1.读取稀疏数组的第一行 创建二维数组
     * 2.读取稀疏数组的第二行开始的数据 赋值给二维数组
     * 3.返回二维数组
     *
     * @param sparseArray 稀疏数组
     * @return 二维数组
     */
    private static int[][] sparseArrayToTwoArray(int[][] sparseArray) {
//        判断稀疏数组是否为空
        if (sparseArray == null || sparseArray.length == 0) {
            return new int[0][];
        }
//        判断稀疏数组的第一行是否为空
        if (sparseArray[0] == null || sparseArray[0].length == 0) {
            return new int[0][];
        }
//        创建二维数组
        int[][] twoArray = new int[sparseArray[0][0]][sparseArray[0][1]];
//        遍历稀疏数组
        for (int i = 1; i < sparseArray.length; i++) {
            int rowIndex = sparseArray[i][0];
            int colIndex = sparseArray[i][1];
            int value = sparseArray[i][2];
            twoArray[rowIndex][colIndex] = value;
        }
        return twoArray;
    }


    /**
     * 打印二维数组
     *
     * @param twoArray
     */
    private static void printTwoArray(int[][] twoArray) {
        for (int[] ints : twoArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] twoArray = new int[10][10];
        twoArray[1][2] = 1;
        twoArray[5][3] = 2;
        twoArray[4][3] = 2;

//        定义一个方法 打印二维数组
        printTwoArray(twoArray);
//        将二维数组转成稀疏数组
        int[][] sparseArray = twoArrayToSparseArray(twoArray);
        System.out.println("稀疏数组");
        printTwoArray(sparseArray);
//         将稀疏数组转成二维数组
        int[][] twoArray1 = sparseArrayToTwoArray(sparseArray);
        System.out.println("二维数组");
        printTwoArray(twoArray1);


    }

}
