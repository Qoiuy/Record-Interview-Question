package problem01;

/**
 * 面试题01
 * 给定一个只含有A-Z的字符串，去除掉字符串中的重复字母，比如”AACCCFF”，则返回”ACF”，请写出完整的函数
 * 
 * 坑：字符串有可能是ACAFCFC
 * 解决思路：
 * 用枚举来存储重复的字符
 * @author iszhanggc@163.com
 *
 */
public class Answer {
	
	/**
	 * 处理字符串
	 * @param deal 要处理的字符
	 * @return 处理好的字符
	 */
	public static String stringhandle (String deal){
		
		String result = "";
		
		for (int i = 0; i < deal.length(); i ++) {
			//如果该字符出现过 返回true
			if(Az.getAz(deal.substring(i, i+1))){
			}else{
				result = result + deal.substring(i, i+1);
				Az.setAz(deal.substring(i, i+1));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {

		String deal = "ACNSIFBAKFSMPMASKFNAUFBABOVASJNXJOSVTYWKMDAS";
		
		System.out.println(stringhandle(deal));
		
	}
	
}

/**
 * 用枚举类型存储字母是否被重复
 * Az.A.isuse
 * @author iszhanggc@163.com
 *
 */
enum Az{
	A(false),B(false),C(false),D(false),E(false),F(false),G(false),
	H(false),I(false),J(false),K(false),L(false),M(false),N(false),
	O(false),P(false),Q(false),R(false),S(false),T(false),
	U(false),V(false),W(false),X(false),Y(false),Z(false);

	private boolean isuse;
    private Az(boolean isuse){
    	this.isuse = isuse;
    }
	public boolean isIsuse() {
		return isuse;
	}
	public void setIsuse(boolean isuse) {
		this.isuse = isuse;
	}
	
	/**
	 * 获取Az是否使用
	 * @param string
	 * @return
	 */
	public static boolean getAz(String string){
		boolean re = false ;
		switch (string) {
		case "A":
			re = Az.A.isuse;
			break;
		case "B":
			re = Az.B.isuse;
			break;
		case "C":
			re = Az.C.isuse;
			break;
		case "D":
			re = Az.D.isuse;
			break;
		case "E":
			re = Az.E.isuse;
			break;
		case "F":
			re = Az.F.isuse;
			break;
		case "G":
			re = Az.G.isuse;
			break;
		case "H":
			re = Az.H.isuse;
			break;
		case "I":
			re = Az.I.isuse;
			break;
		case "J":
			re = Az.J.isuse;
			break;
		case "K":
			re = Az.K.isuse;
			break;
		case "L":
			re = Az.L.isuse;
			break;
		case "M":
			re = Az.M.isuse;
			break;
		case "N":
			re = Az.N.isuse;
			break;
		case "O":
			re = Az.O.isuse;
			break;
		case "P":
			re = Az.P.isuse;
			break;
		case "Q":
			re = Az.Q.isuse;
			break;
		case "R":
			re = Az.R.isuse;
			break;
		case "S":
			re = Az.S.isuse;
			break;
		case "T":
			re = Az.T.isuse;
			break;
		case "U":
			re = Az.U.isuse;
			break;
		case "V":
			re = Az.V.isuse;
			break;
		case "W":
			re = Az.W.isuse;
			break;
		case "X":
			re = Az.X.isuse;
			break;
		case "Y":
			re = Az.Y.isuse;
			break;
		case "Z":
			re = Az.Z.isuse;
			break;
		}
		return re;
	}

	/**
	 * 使Az状态变成true
	 * @param string
	 */
	public static void setAz(String string){
		switch (string) {
		case "A":
			Az.A.setIsuse(true);
			break;
		case "B":
			Az.B.setIsuse(true);
			break;
		case "C":
			Az.C.setIsuse(true);
			break;
		case "D":
			Az.D.setIsuse(true);
			break;
		case "E":
			Az.E.setIsuse(true);
			break;
		case "F":
			Az.F.setIsuse(true);
			break;
		case "G":
			Az.G.setIsuse(true);
			break;
		case "H":
			Az.H.setIsuse(true);
			break;
		case "I":
			Az.I.setIsuse(true);
			break;
		case "J":
			Az.J.setIsuse(true);
			break;
		case "K":
			Az.K.setIsuse(true);
			break;
		case "L":
			Az.L.setIsuse(true);
			break;
		case "M":
			Az.M.setIsuse(true);
			break;
		case "N":
			Az.N.setIsuse(true);
			break;
		case "O":
			Az.O.setIsuse(true);
			break;
		case "P":
			Az.P.setIsuse(true);
			break;
		case "Q":
			Az.Q.setIsuse(true);
			break;
		case "R":
			Az.R.setIsuse(true);
			break;
		case "S":
			Az.S.setIsuse(true);
			break;
		case "T":
			Az.T.setIsuse(true);
			break;
		case "U":
			Az.U.setIsuse(true);
			break;
		case "V":
			Az.V.setIsuse(true);
			break;
		case "W":
			Az.W.setIsuse(true);
			break;
		case "X":
			Az.X.setIsuse(true);
			break;
		case "Y":
			Az.Y.setIsuse(true);
			break;
		case "Z":
			Az.Z.setIsuse(true);
			break;
		}
	}
}
