package problem02;

import java.util.Random;

import com.alibaba.fastjson.JSON;

/**
 * 模拟
 * 
 * @author iszhanggc@163.com
 *
 */
public class Cache {

	/**
	 * 模拟添加操作
	 * 
	 * @param top
	 *            根list
	 * @param add
	 *            添加的list
	 */
	public static void add(Item top, Item add) {
		
		if(add.getId() == 0){//排除边值操作

			Item temptop = new Item();
			temptop.setId(top.getId());
			temptop.setAge(top.getAge());
			temptop.setNext(top.getNext());
			top.setId(add.getId());
			top.setAge(add.getAge());
			top.setNext(temptop);
			
			Item temp = top.getNext();
			while(temp.getNext() != null){
				temp.setId(temp.getId() + 1);
				temp = temp.getNext();
			}
			temp.setId(temp.getId() + 1);
		}
		else if(add.getId() == 1){
			add.setNext(top.getNext());
			top.setNext(add);
			Item temp = top;
			temp = temp.getNext().getNext();
			while(temp.getNext() != null){
				temp.setId(temp.getId() + 1);
				temp = temp.getNext();
			}
			temp.setId(temp.getId() + 1);
		}
		else{//进行添加操作
			Item temp = top;
			int addId = add.getId() - 1;
			// 找到add位置
			while (temp.getNext() != null) {
				if (temp.getId() == addId)
					break;
				temp = temp.getNext();
			}
			// 插入add
			add.setNext(temp.getNext());
			temp.setNext(add);

			if (temp.getNext().getNext() != null)
				temp = temp.getNext().getNext();
			// 剩下的cache依次+1
			while (temp.getNext() != null) {
				temp.setId(temp.getId() + 1);
				temp = temp.getNext();
			}
			temp.setId(temp.getId() + 1);
		}
	}

	/**
	 * 模拟淘汰操作
	 * @param top 根list
	 */
	public static void del(Item top) {
		// 淘汰。
		// 处理age条件
		boolean del = false;// 判断是删除节点。

		// 除了第一个 所有item age +1 如果age大于10 删除节点
		Item temp = top;

		// 操作下一个节点
		while (temp.getNext().getNext() != null) {
			temp.getNext().setAge(temp.getNext().getAge() + 1);
			if (temp.getNext().getAge() > 10) {
				// System.out.println("要删除的节点->" + temp.getNext().getId());
				temp.setNext(temp.getNext().getNext());
				del = true;
				break;
			}
			temp = temp.getNext();
		}
		if (del == true) {// 删除了节点。
			// 删除之后的操作 剩下的item age+1 id-1
			while (temp.getNext().getNext() != null) {
				temp.getNext().setAge(temp.getNext().getAge() + 1);
				temp.getNext().setId(temp.getNext().getId() - 1);
				temp = temp.getNext();
			}
			temp.getNext().setAge(temp.getNext().getAge() + 1);
			temp.getNext().setId(temp.getNext().getId() - 1);
		} else {
			temp.setAge(temp.getAge() + 1);
			temp.getNext().setAge(temp.getNext().getAge() + 1);
		}

		// 处理第一个节点条件
		if (del == false) {// 如果没有删除 ->该动作只会进行不到10次 .可以忽略该操作带来的小号
			// System.out.println("要删除的值->1");
			// 删除第一个节点
			top.setId(top.getNext().getId());
			top.setAge(top.getNext().getAge());
			top.setNext(top.getNext().getNext());
			// 所有节点id减1
			temp = top;
			while (temp.getNext() != null) {
				temp.setId(temp.getId() - 1);
				temp = temp.getNext();
			}
			temp.setId(temp.getId() - 1);
		} else
			top.setAge(top.getAge() + 1);

	}

	public static void main(String[] args) {

		Item top = CreateData.createData();
		System.out.println(JSON.toJSONString(top));

		// 模拟200次操作
		for (int i = 0; i < 200; i++) {
			// 先进性删除操作，在进行添加操作
			del(top);
			System.out.println("删除之后" + JSON.toJSONString(top));
			Item add = new Item();
			add.setId(new Random().nextInt(49));
			add.setAge(new Random().nextInt(10));
			// System.out.println(top + "" + add);
			add(top, add);
			System.out.println("添加之后" + JSON.toJSONString(top));
		}

	}

}
