package exercise.base1;

/**
 * @author sunLei on 2018/11/9 13:09
 * @version 1.0
 * @apiNote 解答
 */
public class Solution {
    /**8 字符转整数*/
    public int myAtoi(String str){
        //提取的数字字符串
        StringBuilder output=new StringBuilder();
        //返回的结果
        int result=0;
        //遍历输入
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            //空格并且是一直是空格，跳过
            if(c==' ' && (i==0 || str.charAt(i-1)==' ')){
                continue;
            }
            //减号(并且是最左侧出现的"-",其他"-"作为字符处理)或数字
            else if ((c=='-' && (i==0 || str.charAt(i-1)==' ')) || (c>='0' && c <='9')){
                output.append(c);
            }
            //加号(并且是最左侧的加号)
            else if (c=='+' && (i==0 || str.charAt(i-1)==' ')){
                continue;
            }
            //其他符号，结束提取
            else{
                break;
            }
        }
        //转换int过程
        if(output.length()>0 ){
            if(output.charAt(0)=='-'){
                if(output.length()<=1){
                    //只有"-"
                    return 0;
                }
                //保留有效数字比如:-0000001转换-1
                while(output.length()>2 && output.charAt(1)=='0'){
                    output.deleteCharAt(1);
                }
            }else{
                //保留有效数字
                while(output.length()>1 && output.charAt(0)=='0'){
                    output.deleteCharAt(0);
                }
            }
            //比较范围,在int范围内
            if(output.length()<=9){
                return Integer.parseInt(output.toString());
            }
            //可能超过int,但是不会超过long，借助long判断
            else if(output.length()<=11){
                Long temp=Long.valueOf(output.toString());
                if(temp>Integer.MAX_VALUE){
                    result=Integer.MAX_VALUE;
                }
                else if(temp<Integer.MIN_VALUE){
                    result=Integer.MIN_VALUE;
                }else{
                    result=Integer.parseInt(output.toString());
                }
            }
            //直接超过范围
            else{
                if(output.charAt(0)=='-'){
                    result=Integer.MIN_VALUE;
                }else{
                    result=Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }
    public int myAtoi3(String str){
        StringBuilder output=new StringBuilder();
        int result=0;
        for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c==' ' && (i==0 || str.charAt(i-1)==' ')){
                    continue;
                }else if ((c=='-' && (i==0 || str.charAt(i-1)==' ')) || (c>='0' && c <='9')){
                    if(c=='0' && (output.length()==0 || output.length()==1 && output.charAt(0)=='-')){
                        continue;
                    }
                    output.append(c);
                }else if (c=='+' && (i==0 || str.charAt(i-1)==' ')){
                    continue;
                }else{
                    break;
                }
        }
        if(output.length()>0 ){
            if(output.charAt(0)=='-' && output.length()<=1){
                return 0;
            }
            //比较范围
            if(output.length()<=9){
                return Integer.parseInt(output.toString());
            }
            else if(output.length()<=11){
                Long temp=Long.valueOf(output.toString());
                if(temp>Integer.MAX_VALUE){
                    result=Integer.MAX_VALUE;
                }
                else if(temp<Integer.MIN_VALUE){
                    result=Integer.MIN_VALUE;
                }else{
                    result=Integer.parseInt(output.toString());
                }
            }else{
                if(output.charAt(0)=='-'){
                    result=Integer.MIN_VALUE;
                }else{
                    result=Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }
    public int myAtoi2(String str){
        StringBuilder output=new StringBuilder();
        int result=0;
        int len=str.length();
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            if (c!=' '){
              if(c=='+' || c=='-' || (c>='0' && c<='9')) {
                  for (int j = i; j < len; j++) {
                      char mchar = str.charAt(j);
                      if (mchar == '0' && j - 1 >= 0 && str.charAt(j - 1) == '0') {
                          continue;
                      } else if (mchar >= '0' && mchar <= '9') {
                          output.append(mchar);
                      } else {
                          break;
                      }
                  }
                  //获取了值
                  if(c=='-'){

                  }else{
                      if (morethan(output.toString(), String.valueOf(Integer.MAX_VALUE)) > 0) {
                          return Integer.MAX_VALUE;
                      }
                      return Integer.parseInt(output.toString());
                  }
              }else{
                  return 0;
              }
            }
        }
            //比较范围
            if (morethan_withminus(output.toString(),String.valueOf(Integer.MAX_VALUE))>0){
                output=new StringBuilder(String.valueOf(Integer.MAX_VALUE));
            }
            if(morethan_withminus(output.toString(),String.valueOf(Integer.MIN_VALUE))<0){
                output=new StringBuilder(String.valueOf(Integer.MIN_VALUE));
            }
            //转换int
            if(output.charAt(0)=='-'){
                if(output.length()>1){
                    result=Integer.parseInt(output.toString());
                }
            }else{
                result=Integer.parseInt(output.toString());
            }
            return 0;
        }
    private int morethan_withminus(String str1,String str2){
        if (str1.charAt(0)=='-' && str2.charAt(0)!='-'){
            return -1;
        }else if (str1.charAt(0)!='-' && str2.charAt(0)=='-'){
            return 1;
        }else if (str1.charAt(0)=='-' && str2.charAt(0)=='-'){
            return -morethan(str1.substring(1),str2.substring(1));
        }else {
            return morethan(str1,str2);
        }
    }
    private int morethan(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        int result=0;
        if(len1>len2){
            result=1;
        }else if (len1<len2){
            result=-1;
        }else {
            for (int i=0;i<len1;i++){
                char c1=str1.charAt(i);
                char c2=str2.charAt(i);
                if(c1>c2){
                    result=1;
                    break;
                }else if (c1<c2){
                    result=-1;
                    break;
                }else {
                    result=0;
                    continue;
                }
            }
        }
        return result;
    }
}
