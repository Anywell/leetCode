package com.any.array;

/**
 *  旋转图像
 *  给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RotateArray {


    public static void main(String[] args) {

        int [][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] arr = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };

        rotate(matrix);

        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + ", ");
                if ((j+1) % length == 0){
                    System.out.println();
                }
            }
        }

    }

    public static void rotate(int[][] matrix){
        
        int length = matrix.length;

//        for (int i = 0; i < length / 2; i++) {
//            for (int j = 0; j < length; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[length-1-i][j];
//                matrix[length-1-i][j] = temp;
//            }
//        }
        // 上下交换只需要一层for循环既可，交换一整行
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;

        }

        // 对角线交换
        for (int i = 0; i < length; i++) {
            // 此处的j应该为i + 1,交换过的不再进行交换
            for (int j = i + 1; j < length; j++) {
                System.out.println("----------------");
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
