package problem01;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 随机生成数据类
 * @author iszhanggc@163.com
 *
 */
public class CreateData {
	
	private static int layersMax = 3;//多叉树层数
	private static int NodeSumMax = 5;//多叉树子节点最大值
	private static int NodeSumMin = 2;//多叉树子节点最小值
	private static int value = 0;
	
	public static int getLayersMax() {
		return layersMax;
	}

	public static void setLayersMax(int layersMax) {
		CreateData.layersMax = layersMax;
	}

	public static int getNodeSumMax() {
		return NodeSumMax;
	}

	public static void setNodeSumMax(int nodeSumMax) {
		NodeSumMax = nodeSumMax;
	}

	public static int getNodeSumMin() {
		return NodeSumMin;
	}

	public static void setNodeSumMin(int nodeSumMin) {
		NodeSumMin = nodeSumMin;
	}

	/**
	 * @param layers 父节点所在层数
	 * @param NodeSum 子节点个数
	 * @return
	 */
	public static List<Node> CreateNodeList(int layers, int NodeSum){
		if(layers > getLayersMax())
			return null;
		List <Node> list = new ArrayList<Node>();
		for( int i = 0; i < NodeSum; i++){
			Node node = CreateNode(layers);
			list.add(node);
		}
		return list;
	}
	
	/**
	 * @param layers 该节点所在层数
	 * @return
	 */
	public static Node CreateNode(int layers){
		
		//如果是最后一层则不进行添加树的操作
		if(layers >getLayersMax())
		{
			Node node = new Node();
			node.setLayers(layers);
			node.setValue(value);
			node.setList(null);
			return node;
		}
		
		Node node = new Node();
		node.setLayers(layers);
		node.setValue(++value);
		int NodeSum = new java.util.Random().nextInt(NodeSumMax-NodeSumMin) + NodeSumMin ;
		//显示多叉树的数据
		//System.out.println("layers =" +layers +"  NodeSum="+ NodeSum+"value="  +value );
		List <Node> list = CreateNodeList(++layers, NodeSum);
		node.setList(list);
		return node;
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		//测试
		//设置多叉树层数
		setLayersMax(3);
		//设置多叉树最小节点数
		setNodeSumMin(2);
		//设置多叉树最大节点数
		setNodeSumMax(5);
		Node node = CreateNode(1);
		System.out.println(JSON.toJSONString(node));
	}
}
