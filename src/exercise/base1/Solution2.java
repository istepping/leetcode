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
        print("比较"+s+","+p);
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
                        return false;
                    }
                }
            } else if (c == '*') {
                //总条件,左边有值
                if (i - 1 >= 0) {
                    //上一个字符
                    char last = p.charAt(i - 1);
                    //一个都没有匹配到就跳过
                    if (currentIndex < sLen && s.charAt(currentIndex) != last && last!='.') {
                        //继续匹配，不做处理
                        print("一个都没有匹配到");
                    } else {
                        //存在匹配字符，解决匹配个数问题
                        print("存在匹配字符，解决匹配个数问题");
                        if (i + 1 < pLen) {
                            print("*后面还有字符,递归调用");
                            String temp_p = p.substring(i + 1);
                            print("获取temp_p="+temp_p);
                            //这里是j<=sLen,边缘问题，仔细考虑
                            for (int j = currentIndex; j <= sLen; j++) {
                                String temp_s = s.substring(j);
                                //存在匹配，向后判断1. 匹配0个 2.遇到.号 3. 字符匹配上
                                if(j==currentIndex || last=='.' || last==s.charAt(j-1)){
                                    print("第"+(j-currentIndex+1)+"次");
                                    if (isMatch(temp_s, temp_p)) {
                                        return true;
                                    }
                                }
                                //不存在匹配了
                                else{
                                    break;
                                }
                            }
                            print("false2");
                            return false;
                        } else {
                            //后面没有
                            print("*后面没有");
                            if(last=='.'){
                                return true;
                            }
                            //前一个是其他,依次匹配
                            while(currentIndex<sLen && s.charAt(currentIndex)==last){
                                currentIndex++;
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
                    return false;
                }
            }
        }
        //s串匹配完成
        if (currentIndex >= sLen) {
            return true;
        } else {
            return false;
        }
    }
}
