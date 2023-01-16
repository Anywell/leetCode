package com.any.string;


/**
 * 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnpvdm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 */
public class CountAnsSay {

    public static void main(String[] args) {

        String str = countAndSay(7);
        System.out.println(str);

    }

    /**
     * 先确立递归出口 n = 1时 为1
     * 对上一个结果进行遍历获取值
     * 设定计数器，计算同一个数字出现的次数
     * 如果数字相同，计数器加一
     * 若当前不满足，则将上次的值记录下，并重置计数器，重置需要判断是否重复的字符
     * 将最后的结果也追加到字符串上
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n){

        // 递归出口
        if (n == 1){
            return "1";
        }

        // 假设我们获得上一次的结果为 s1 == 112213
        String s1 = countAndSay(n - 1);
        // 定义结果
        StringBuilder result = new StringBuilder();
        // 对s1遍历处理获取值
        char local = s1.charAt(0);
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            // 设定计数器，计算同一个数字出现的次数 count
            if (s1.charAt(i) == local){
                count++;
            }else{
                // 不符合，记录下
                result.append(count);
                result.append(local);
                count = 1;
                local = s1.charAt(i);
            }
        }
        result.append(count);
        result.append(local);

        return result.toString();
    }

    /**
     *
     * @param n
     * @return
     */
    public static String countAndSay1(int n){

        StringBuilder res = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;

        for (int i = 0; i < n; i++) {
            prev = res;
            res = new StringBuilder();
            count = 1;
            // 遇到新的字符
            say = prev.charAt(0);
            for (int j = 1, len= prev.length(); j < len; j++) {
                if (prev.charAt(j) != say){
                    // 如果遇到新的字符，把他的数量和字符都加入到res中，然后count置为1，再把say赋予遇到的新的字符
                    res.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }else {
                    // 如果不是新的字符，计算当前字符的数量
                    count++;
                }
            }
            res.append(count).append(say);
        }
        return res.toString();

    }

    /**
     *递归和循环的逻辑就是，前者从后往前写，但是需要定义好递归出口，循环就是从头开始，容易理解一些！
     *
     * 按照正常的逻辑进行读写就可以了，比如输入一个 4 输出 1211 计算机应该模仿人的方式去进行
     *
     * String s2 = product(String s1); 其中 s1 为一个字符串，s2为读出的字符串，即 s1 = "21"的时候，s2应得到 "1211"
     *
     * 于是，countAndSay(4)中的参数4，就变成了循环的次数了。product()函数的原理就是看连续的数据是否跳变，跳变的时候记录连续的最大个数即可！！！
     *
     * @param n
     * @return
     */
    public static String countAndSay2(int n){

        StringBuilder s1 = new StringBuilder();
        s1.append("1");

        for (int i = 1; i < n; i++) {
            StringBuilder s2 = product(s1);
            s1 = s2;
        }

        return s1.toString();

    }

    private static StringBuilder product(StringBuilder s1) {

        StringBuilder s2 = new StringBuilder();

        int count = 0;
        char local = s1.charAt(0);
        for (int i = 0; i < s1.length(); ) {
            if (local == s1.charAt(i)){
                // 没有出现新字符，计数器递增，指针递增
                count++;
                i++;
            }else{
                // 出现了新字符，将原先的字符的个数和字符添加到s2中
                s2.append(count).append(local);
                // 更新local
                local = s1.charAt(i);
                count = 0; // 重新计数
            }
        }

        // 循环结束后最后一个字符还没有加入
        return s2.append(count).append(local);

    }
}
