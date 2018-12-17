package exercise.daily;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2018/12/16 23:30
 * @version 1.0
 * @apiNote 递归实现字符串的反转
 */
public class Solution1 {
    public static String reverse(String str){
        //退出条件
        if(str==null || str.length()<=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }
    public static void main(String[] args){
        print(reverse("abc"));
    }
}
