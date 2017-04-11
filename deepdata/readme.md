## 面试题1 请列举三个你遇到技术问题时 找解决办法常去的站点
### 面试题2 请列举三本读过的技术书籍
#### 面试题3 要求 :1 选择一下几个函数中的其中一个进行实现。2必须写一个完整的包含输入输出的函数，该函数应为静态方法 3由于是工具方法，输入的参数可能是任意值，请处理好异常情况。4 如果有一些具体的函数记不清怎么写，可以用中文代替。
# 可选函数1：将字符串转换为Integer，例如输入字符串为123的字符串，函数处理结果为123的Integer。
# 可选函数2：讲一个字符串按照冒号和分号进行切割，转换成Map。假设字符串为key1:123;key2:234;key3:345,将字符串按照冒号和分号进行切割后，冒号前面的是Map的key，冒号后面的是key的Value。因此字符串切割的结果是一个包含3条记录的Map.
# 面试题4 从浏览器输入一个网址，例如:deepdata.com.cn,到该页面显示完成，都发生了哪些事情，有哪些过程？请试着描述，越清晰越好。
# 面试题5 java的Throwable,Exception,Runtime Exception, Error
# a 是什么概念？有何异同？
# b 这几个类之间是什么关系？如果可以的话，请用UML图将他们的关系画出来。
# 面试题6 从源码到计算机可执行的成语，Java的编译过程是什么样的？
# 面试题7 列举Java中常用的集合类和适用场景，每种集合类请黑出两个具体实现并说明其特征。
# 面试题8 Tomcat的作用是什么？
# 面试题9 JSP和HTML有什么相同点和不同点？
# 面试题10 假设有个数据表Employ（职工号，姓名，部门名，工种，工资），需要查出不同部门中担任'钳工'工种的职工的平均工资：
# a 请用一个SQL语句查询出不同部门中担任'钳工'的职工平均工资。
# b 请用一个SQL语句查询出不同部门中担任'钳工'的职工平均工资高于 2千的部门。
# 面试题11 请写出一下Linux命令
# a 读取机器额基本信息。包括：内核版本，发行版，CPU,内存，硬盘容量；
# b 查看当前服务器的CPU和内存占用情况；
# c 找到占用8080端口的进程，请将其强制杀掉
# 面试题12 代码改错：仔细阅读如下一段Java程序片段，针对 该陈旭片段，找出一些您认为有误或者不妥当的地方，分别列出并加以改正。
	public class Employ {
		private int sex = 0;
		private int age = 0;
		
		//设置年龄或性别
		public void setValue(String _name,int _value){
			if(_name == "sex"){
				this.sex = _value;
				if( this.sex !=0 || this.sex != 1){
					throw new RuntimeErrorException("性别只能设置[男]或[女]!");
				}
				return;
			}
			
			//else
			if(_name == "age") {
				this.age = _value;
				return;
			}
			
			throw new RuntimeErrorException("只能设置年龄(age)或者性别(sex)!");
		}
	
		//获取员工所在部门的女性同事姓名
		public String[] gtwp(){
			List relation = this.getAllDeptGirls();
			if(relation.size() == 0){
				return null;
			}
			
			String[] result = new String[relation.size()];
			
			for(int i = 0; i < relation.size(); i++){
				relation[i] = ((Employ)relation.get(i)).getName());
				if(((Employ) relation.get(i)).getSex() != 0){
					continue;
				}
			}
			
			return result;
		}
		
		private List getAllDeptGirls(){
			//获取连接对象
			try{
				this.coon = Connection;
			} catch( SQLException ex){
				return null;
			}
		}
	}
# 面试题13 试着编写一下题目要求实现的方法
# Gaven a number x ,we can define p(x) as the product of the digits of x ,We can then from a sequene x,p(x),p(p(x))....The persistence of x is then defined as the index(0-based) of the first single digit number in the sequence. For example, using 99, we get the sequence 99, 9*9 = 81,8*1 = 8.Thus. the persistence of 99 is 2. You will be given n, and you must return its persistence.
# Definition
# Class:PersistentNumber
# Method:getPersistence
# Parameter:int 
# Returns: int
# Method signtrue: int getPerdistence(int n)
# (be sure your method is public)
# Constraints
# -n will be between 0 and 2,000,000,000 inclusive
# Examples
# 0) 99 
# Returns :2
# The example from the problem statement.
# 1) 268
# Returns :4
# The sequeue here is 268,96,54,20,0
# 2) 6
# Returns :0
# 6 is already a single-digit number
# 3) 68889789
# Returns :3
# 4) 86898
# Returns :7