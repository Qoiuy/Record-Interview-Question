package problem02;

/**
 * 实体类
 * @author iszhanggc@163.com
 *
 */
public class Item {
	int id;
	int age;
	Item next; //因为java里面没有指针的定义，所以只能用类来代替了。
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Item getNext() {
		return next;
	}
	public void setNext(Item next) {
		this.next = next;
	}
	
}
