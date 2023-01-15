package com.atguigu.timeapi;
import org.junit.Test;
import java.util.Arrays;

/**
 * @author liweiliang
 * @create 2022-10-01 23:02
 */
public class StringDemoTest {
    /**
     * @description: 获取两个字符串中最大相同子串
     * @author: liweiliang
     * @date: 2022/10/4 9:36
     * @param: [str1, str2]
     * @return: java.lang.String[]
     * @details: str1 = "abcwerthello1yuiodefabcdef";str2 = "cvhellobnmabcdef";
     * @reminder： 将短的那个串进行长度依次递减的子串与较长的串比较。
     **/
    public String[] getMaxSameString(String str1,String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() <= str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {  //进行length大轮的检查
                for (int x = 0, y = length - i; y <= length; x++, y++) {//将str2长度为length-i的所有子串进行比较
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        stringBuffer.append(subStr + ",");
                    }
                }
                if(stringBuffer.length() != 0){
                    break;
                }
            }
            String[] split = stringBuffer.toString().replaceAll(",$","").split("\\,");
            return split;
        }
        return null;
    }
    @Test
    public void getMaxSameStringTest(){
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        String[] maxSameString = getMaxSameString(str1,str2);
        System.out.println(Arrays.toString(maxSameString));
    }
}