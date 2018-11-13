package exercise.base1;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2018/11/9 13:16
 * @version 1.0
 * @apiNote
 */
public class Test {
    public static void main(String[] args){
//        Solution solution=new Solution();
//        solution.myAtoi("20000000000000000000");
//        print(Integer.parseInt("1"));
        Solution2 solution=new Solution2();
        print(solution.isMatch("abbabaaaaaaacaa","a*.*b.a.*c*b*a*"));
    }
}
