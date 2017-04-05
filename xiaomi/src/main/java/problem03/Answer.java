package problem03;

/**
 * 给定一个int数组，找出最大的三个数字，比如[1,4,5,3,8]，则返回[8,5,4]，请写出完整的函数
 * 
 * 坑：插入规则比较难写
 * 自定义插入规则： A>B>C
 * 	如果新的数字>=仨个数字，new->A,A->B,B->C
 *  如果新的数字>=后两个             A, new->B, B->C
 *  如果新的数字>=最后一个        A,B, new->C
 * @author iszhanggc@163.com
 *
 */
public class Answer {
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 3, 8, 3, 21, 132, 123, 132, 157};
		
		int length = arr.length;
		int A = 0;
		int B = 0;
		int C = 0;
		for (int i = 0; i < length; i++) {
			if(arr[i] >= A && arr[i] >= B && arr[i] >= C){
				C = B;
				B = A;
				A = arr[i];
			}
			else if(arr[i] >= B && arr[i] >= C){
				C = B;
				B = arr[i];
			}
			else if(arr[i] >= C)
				C = arr[i];
		}
		System.out.println(A +" "+ B +" "+ C);
	}

}
