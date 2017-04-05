#问题1描述
单个节点Node数据结构，大概如下：
</br>![图](https://github.com/Qoiuy/Record-Interview-Question/blob/master/zingfront/01.png)
struct Node{//注：只有儿子节点，没有父亲节点
	int value;
	List<Node> child_list;
	};
</br>函数输入：多叉树的两个节点 nodeA，nodeB
函数输出：找到nodeA和nodeB最短路径，打印输出。
举例：G节点到R节点的最短路径为红线所示，输出结果为"G->B->F->N->R"
注意节点顺序

###解决：多叉树遍历求最短路径。
###猜测：该问题主要考察会不会多叉树遍历。
###广度优先搜索或深度优先搜索。

###难度上升：节点数据结构里面没有父节点。
###解决思路：从根节点找到两个节点  排除多余的节点。（暂时没有想到更好的算法。）
###例题解决  ：
	步骤1：找到A->G路径。 	A->B->G
	步骤2：找到A->R路径。A->B->F->N->R
	步骤3：排除重复路径 A 并将G节点倒序
	
###答案 ：为了解决这个问题 我写了三个类
	Node 节点类定义
	CreateData 生成多叉树类
	Search 查找路径类
	Search.searchPath 查找路径方法
	Search.main 测试查找路径方法
		
#问题2描述
对Cache进行程序模拟操作，Cache最多容纳100个Item,进行较特别的新增和淘汰的处理逻辑。
Item：Cache item 为单向链表结构；每秒钟所有的Item的age加1；
新增：每秒钟在队列的随机位置新增一个Item;
淘汰：每秒钟只能淘汰一个item。淘汰的条件是要么item的age大于10；要么Cache已满又无{age>10}的item,则淘汰第一个item.
程序需求：Cache单向链表中已有50个Item,写简单程序模拟新增和淘汰的过程。至少需模拟200个item的新增或淘汰。

###模拟缓存处理操作。
###答案：
	Item 模拟item实体；
	CreateData 生成一个长度为50的数据
	Cache 模拟Cache
	Cache.add 模拟添加操作
	Cache.del 模拟删除操作
	Cache.main 测试模拟数据

