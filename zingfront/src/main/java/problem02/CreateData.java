package problem02;

import java.util.Random;


/**
 * 生成数据类
 * @author iszhanggc@163.com
 *
 */
public class CreateData {

	/**
	 * 建立单项链表Item
	 * @return
	 */
	public static Item createData() {
		// 建立第一个Item;
		Item top = new Item();
		top.setId(0);
		top.setAge(5);
		Item temp = new Item();
		temp.setId(1);
		temp.setAge(3);
		top.setNext(temp);

		for (int i = 2; i < 50; i++) {
			Item newitem = new Item();
			temp.setNext(newitem);
			newitem.setId(i);
			newitem.setAge(new Random().nextInt(5));
			temp = newitem;
			//System.out.println(JSON.toJSONString(temp));
		}

		//System.out.println(JSON.toJSONString(top));
		return top;
	}

	public static void main(String[] args) {
		Item data = createData();
		System.out.println(data);
	}

}
