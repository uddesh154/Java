class PrintTextThread extends Thread{
	private String msg;
	private int n;

	public PrintTextThread(String msg, int n){
		this.msg = msg;
		this.n = n;
	}

	public void run(){
		for(int i=0;i<n;i++){
			System.out.println(msg);
			try{
				Thread.sleep((int)(Math.random()*1000));
			}catch(Exception e){}
		}
	}
}

class PrintTextThreadDemo{
	public static void main(String args[]){
		new PrintTextThread("I am in FY",10).start();
		new PrintTextThread("I am in SY",20).start();
		new PrintTextThread("I am in TY",30).start();
	}
}
