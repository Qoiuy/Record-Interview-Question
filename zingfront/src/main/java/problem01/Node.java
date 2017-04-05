package problem01;

import java.util.List;

/**
 * 编写node类
 * 该node只有子节点 没有父节点
 * @author iszhanggc@163.com
 *
 */
public class Node {
	
	int layers;	//节点层数
	int value; //节点的值
	List <Node> list;//子节点list
	public List<Node> getList() {
		return list;
	}
	public void setList(List<Node> list) {
		this.list = list;
	}
	public int getLayers() {
		return layers;
	}
	public void setLayers(int layers) {
		this.layers = layers;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	
}
