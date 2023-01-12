package com.any.array;

/**
 * 有效的数独
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class IsValidSudoku {

    public static void main(String[] args) {

        char a = '5';
        int num = a - '0';
        System.out.println(num);

        char board[][] = new char[][] {
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'5','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        boolean result = isValidSudoku(board);

        System.out.println("result = " + result);


    }


    public static boolean isValidSudoku(char board[][]){

        int length = board.length;

        // 二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]表示的是第0行（实际上是第1行，
        // 因为数组的下标是从0开始的）是否有数字3.
        int line[][] = new int[length][length];
        // 二维数组column表示的是对应的列中是否有对应的数字
        int column[][] = new int[length][length];
        // 二维数组cell表示的是对应的第几个单元格中是否有对应的数字
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 如果该格子中没有填数字，直接跳过。
                if (board[i][j] == '.') {
                    continue;
                }
                // num是当前格子中的数字
                int num = board[i][j] - '0' - 1;
                // k是第几个单元格，9宫格数独中横着和竖着都是3个单元格，先横着数，再竖着数。
                // 从0开始计数。0-代表第一个单元格，3代表第四个单元格。
                int k = i / 3 * 3 + j / 3;

                // 如果当前数字对应的行和列以及单元格，只有一个有数字，说明冲突了，直接返回false
                // 如：line[i][num]不等于0，说明第i行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0) {
                    return false;
                }
                // 表示第i行有num这个数字，第j列有num这个数字，对应的单元格也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }

    // 如果都没有冲突，返回true。
        return true;
    }

    public static boolean isValidSudoku1(char board[][]) {
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i)
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                //num是当前格子的数字
                int num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        return true;
    }
}
