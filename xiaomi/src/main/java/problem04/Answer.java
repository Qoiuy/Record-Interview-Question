package problem04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 给定一个含有若干int的字符串，数字之间以空格或者字母间隔，找出其中最大的数值，比如”123  56aa789bb  890”，则返回890，请写出完整的函数
 * 
 * 使用正则找到String里面的数字 正则  [0-9]+
 * 
 * @author iszhanggc@163.com
 *
 */
public class Answer {

	public static void main(String[] args) {
		String str = "123  56aa789bb  890";
		
		int Max = 0;
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			if(Integer.valueOf(matcher.group()) >= Max)
				Max = Integer.valueOf(matcher.group());
		}
		System.out.println(Max);
	}
}
