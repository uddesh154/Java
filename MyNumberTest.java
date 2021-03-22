import java.io.*;

class MyNumber{
	private int n;

	public MyNumber(){
		n = 0;
	}

	public MyNumber(int n){
		this.n = n;
	}

	public boolean isPositive(){
		return n>=0;
	}

	public boolean isNegative(){
		return n<0;
	}

	public boolean isOdd(){
		return n%2==1;
	}

	public boolean isEven(){
		return n%2==0;
	}

	public boolean isZero(){
		return n==0;
	}
}

class MyNumberTest{
	public static void main(String args[]){
		int n = Integer.parseInt(args[0]);

		MyNumber o = new MyNumber(n);

		System.out.println("Positive ?:"+o.isPositive());
		System.out.println("Negative ?:"+o.isNegative());
		System.out.println("Zero ?:"+o.isZero());
		System.out.println("Odd ?:"+o.isOdd());
		System.out.println("Even ?:"+o.isEven());
	}
}

