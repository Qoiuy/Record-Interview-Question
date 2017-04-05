package problem02;

import java.util.ArrayList;

/**
 * 面试题02
 * 给定两个int数组，计算相加的和，比如[1,2,3]和[4,5,6]，则返回[5,7,9]，请写出完整的函数
 * 
 * 坑：数组长度可能不一致。
 * 解决思路：
 * 先建立一个ArrayList<Integer>
 * 然后解决短的数组，然后再解决长数组。避免出现数组越界
 * 
 * @author iszhanggc@163.com
 *
 */
public class Answer {
	public static void main(String[] args) {
		int[] arr01 = { 1, 2, 3 };
		int[] arr02 = { 4, 5, 6 };
		
		System.out.println(dealArr(arr01, arr02).toString());
	}
	
	/**
	 * 处理数组的入口
	 * 处理数组长度 
	 * @param arr01 数组01
	 * @param arr02 数组02
	 * @return 处理好的结果
	 */
	public static ArrayList<Integer> dealArr(int[] arr01, int[] arr02){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(arr01.length > arr02.length)
			result = deal(arr02, arr01);
		else
			result = deal(arr01, arr02);
		return result;
	}
	
	/**
	 * 处理数组
	 * @param shortArr 先传入短数组
	 * @param longArr 再传入长数组
	 * @return 处理好的结果
	 */
	public static ArrayList<Integer> deal(int[] shortArr, int[] longArr){
		ArrayList<Integer> result  = new ArrayList<Integer>();

		//处理短数组
		int arrlength = shortArr.length;
		for(int i = 0; i < arrlength; i++)
			result.add(shortArr[i] + longArr[i]);
		
		//处理剩下的数组
		arrlength = longArr.length - shortArr.length;
		for(int i = 0; i < arrlength; i++)
			result.add(longArr[i + shortArr.length]);
		
		return result;
	}

}
