package exercise.base1;

import java.util.HashMap;
import java.util.Map;

import static exercise.common.Assist.print;

/**
 * @author sunLei on 2018/12/17 14:29
 * @version 1.0
 * @apiNote
 */
public class Solution3 {
    /**算法正确,相比消耗内存*/
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> subSet = new HashMap<>();//子串保存区域
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (subSet.containsKey(c)) {
                //有重复
                //进行字串递归返回最大值
                int index=subSet.get(c);
                subSet.clear();//释放内存
                return Math.max(i,lengthOfLongestSubstring2(s.substring(index+1)));
            } else {
                //无重复
                subSet.put(c,i);
            }
        }
        return s.length();
    }
    public int lengthOfLongestSubstring(String s) {
        return 0;
    }
    public static void main(String[] args){
        Solution3 solutions=new Solution3();
        print(solutions.lengthOfLongestSubstring2("abcabcbb"));
    }
}
