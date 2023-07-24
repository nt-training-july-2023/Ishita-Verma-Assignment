package oops;

public class program01 {

	private int num;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public void display() {
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		program01 res = new program01();
		res.setNum(26);
		int ans = res.getNum();
		res.display();
	}

}
