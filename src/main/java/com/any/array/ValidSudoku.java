package com.any.array;

/**
 * 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 */
public class ValidSudoku {


    /**
     * 我们首先遍历9宫格的所有元素，然后使用3个二维数组遍历，记录对应的行，列以及3*3单元格是否有某个数字，
     * 如果出现冲突，直接返回false。
     */
    public boolean isValidSudoku(char board[][]){

        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        // 表示的是第0行，是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 如果还没有填数字，直接跳过
                if (board[i][j] == '.'){
                    continue;
                }
                // num是当前格子的数字
                int num = board[i][j] - '0' - 1;
                // k是第几个单元格，9宫格熟读横着和竖着都是3个单元格
                int k = i /3 * 3 + j / 3;
                // 如果当前数字对应的行和列以及单元格，只要一个有数字，说明冲突了，直接返回false
                // 举个例子：如果line[i][num]不等于0，说明第i行有num这个数字
                if(line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0){
                    return false;
                }
                // 表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;

            }
        }

        return false;
    }

}


