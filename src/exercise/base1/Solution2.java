package exercise.base1;


import static exercise.common.Assist.print;

/**
 * @author sunLei on 2018/11/12 20:15
 * @version 1.0
 * @apiNote
 */
public class Solution2 {
    /**
     * 10.实现正则匹配
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int currentIndex = 0;
        for (int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            //.号
            if (c == '.') {
                if (i + 1 < pLen && p.charAt(i + 1) == '*') {
                    //不做处理,交由后面*字符处理
                } else {
                    if (currentIndex < sLen) {
                        //任意匹配
                        currentIndex++;
                    } else {
                        print("false1");
                        return false;
                    }
                }
            } else if (c == '*') {
                if (i - 1 >= 0) {
                    char last = p.charAt(i - 1);
                    //一个都没有就跳过
                    if (currentIndex < sLen && s.charAt(currentIndex) != last && last!='.') {
                        //继续匹配，不做处理
                    } else {
                        if (i + 1 < pLen) {
                            //后面还有字符
                            String temp_p = p.substring(i + 1);
                            //*匹配个的时候
                            if(isMatch(s.substring(currentIndex),temp_p)){
                                return true;
                            }
                            for (int j = currentIndex; j < sLen; j++) {
                                String temp_s = s.substring(j);
                                //存在匹配，向后判断
                                if(last=='.' || (j>currentIndex && last==s.charAt(j-1))){
                                    if (isMatch(temp_s, temp_p)) {
                                        return true;
                                    }
                                }else if(j>currentIndex){
                                    break;
                                }
                            }
                            print("false2");
                            return false;
                        } else {
                            //后面没有
                            //前一个是"."
                            if(last=='.'){
                                return true;
                            }
                            //前一个是其他
                            while(currentIndex<sLen && s.charAt(currentIndex)==last){
                                currentIndex++;
                            }
                            if(currentIndex>=sLen){
                                return true;
                            }
                        }
                    }
                }
            } else {
                if (i + 1 < pLen && p.charAt(i + 1) == '*') {
                    //后面是*,交由后面处理
                    continue;
                }
                if (currentIndex < sLen && c == s.charAt(currentIndex)) {
                    currentIndex++;
                } else {
                    print("false4");
                    return false;
                }
            }
        }
        if (currentIndex >= sLen) {
            return true;
        } else {
            return false;
        }
    }
}
