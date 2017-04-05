package problem01;

import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * 查询类
 * @author iszhanggc@163.com
 *
 */
public class Search {
	
	/**
	 * 错误思路1
	 * @param result
	 * @param node
	 * @param valueA
	 */
	public static void ErrorSearchValue(Stack<Integer> result, Node node, int valueA) {

		// System.out.println("栈顶元素"+ result.peek());
		if (!result.isEmpty())
			if (result.peek() == valueA) {
				return;
			}
		// 遍历node.

		result.push(node.getValue());

		List<Node> list = node.getList();
		for (Node node2 : list) {
			if (node2.getValue() == valueA) {
				result.push(node2.getValue());
				return;
			} else if (node2.getList() != null) {
				// System.out.println(JSON.toJSONString(node2.getList()));
				ErrorSearchValue(result, node2, valueA);
			} else {
				result.pop();
			}
		}
		result.pop();

	}

	
	/**
	 * 错误思路2 
	 * @param result
	 * @param node
	 * @param valueA
	 */
	public static void ErrorSearchValue1(Stack<Integer> result, Node node, int valueA) {
		if (node.getValue() == valueA) {
			return;
		}
		result.push(node.getValue());
		System.out.println("push->" + node.getValue());
		for (Node node2 : node.getList()) {
			if (node2.getValue() == valueA) {
				System.out.println("push->" + node.getValue());
				result.push(node2.getValue());
				return;
			} else if (node2.getList() != null) {
				ErrorSearchValue1(result, node2, valueA);
			} else {
				System.out.println("list=" + JSON.toJSONString(node2.getList()));
				System.out.println("pop->" + node.getValue());
				result.pop();
			}
		}
		result.pop();

	}

	/**
	 * 查找单个节点路径
	 * @param result
	 *            用来存储路径的栈
	 * @param node
	 *            根节点
	 * @param valueA
	 *            要查找的值
	 */
	public static void SearchValue(Stack<Integer> result, Node node, int valueA) {

		// 递归停止条件
		if (!result.isEmpty())
			if (result.peek() == valueA) {
				return;
			}

		if (node.getValue() == valueA) {
			return;
		}

		// 遍历
		if (node.getList() != null) {
			// System.out.println("push->" + node.getValue());
			result.push(node.getValue());
			for (Node node2 : node.getList()) {
				if (node2.getValue() == valueA) {
					// push 父节点结果
					// System.out.println("push->" + node.getValue());
					result.push(node2.getValue());
					return;
				} else if (node2.getList() != null) {
					SearchValue(result, node2, valueA);
				}

			}

			if (result.peek() == valueA) {
				return;
			}
			// System.out.println("pop->" + node.getValue());
			result.pop();

		}

	}

	/**
	 * 查找路径
	 * 
	 * @param node
	 *            根节点
	 * @param valueA
	 *            要查找的A值
	 * @param valueB
	 *            要查找的B值
	 * @return 结果（栈存储）
	 */
	public static Stack<Integer> searchPath(Node node, int valueA, int valueB) {
		// 用栈来存储路径
		Stack<Integer> resultA = new Stack<Integer>();
		Stack<Integer> resultB = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();

		// 步骤1：找到A->G路径。
		SearchValue(resultA, node, valueA);
		// 步骤2：找到A->R路径。
		SearchValue(resultB, node, valueB);

		// 倒序栈里面的元素
		// 此时三个栈里面的元素状态
		// result -> resultA的倒序;
		// resultA -> resultB的倒序;
		// resultB ->

		int resultASize = resultA.size();
		for (int i = 0; i < resultASize; i++) {
			result.push(resultA.peek());
			resultA.pop();
		}
		int resultBSize = resultB.size();
		for (int i = 0; i < resultBSize; i++) {
			resultA.push(resultB.peek());
			resultB.pop();
		}

		// 步骤3：排除重复路径 A
		int resultsize;
		if (resultASize >= resultBSize)
			resultsize = resultASize;
		else
			resultsize = resultBSize;

		int repeat = 0;
		for (int i = 0; i < resultsize; i++) {
			// 如果A B顶端元素相同记录这个元素 如果下一个元素也相同 这抛弃这个元素，
			if (resultA.peek() == result.peek()) {
				repeat = resultA.peek();
				resultA.pop();
				result.pop();
			} else {
				resultA.push(repeat);
				break;
			}
		}
		// 并将G节点倒序
		resultBSize = resultA.size();
		for (int i = 0; i < resultBSize; i++) {
			result.push(resultA.peek());
			resultA.pop();
		}

		return result;
	}

	public static void main(String[] args) {


		// 要查找的值
		int valueA = 20;
		int valueB = 3;

		// 生成个node.
		CreateData.setLayersMax(5);
		CreateData.setNodeSumMin(2);
		CreateData.setNodeSumMax(5);
		Node node = CreateData.CreateNode(1);
		// System.out.println(JSON.toJSONString(node));

		Stack<Integer> result = searchPath(node, valueA, valueB);
		System.out.println(JSON.toJSONString(result));
	}
}
