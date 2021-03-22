class SumThread extends Thread{
	private int x[];
  	private int start,end,sum;
  
  	public SumThread(int a[], int i, int j){
    		x = a;
    		start = i;
    		end = j;
  	}

  	public void run(){
    		for(int i=start;i<=end;i++){
      			sum+=x[i];
      			try{
				Thread.sleep((int)(Math.random()*1000));
      			}catch(Exception e){}
    		}
  	}

  	public int getSum(){
    		return sum;
  	}
}

class ArraySum{
	public static void main(String args[]){
		int nos[] = new int[1000];

    		for(int i=0;i<1000;i++)
      			nos[i] = (int)(Math.random()*1000);

    		SumThread t[] = new SumThread[10];

    		for(int i=0;i<10;i++){
      			t[i] = new SumThread(nos,i*100,(i+1)*100-1);
      			t[i].start();
    		}

		for(int i=0;i<10;i++){
      			try{
        			t[i].join();
      			}catch(Exception e){}
    		}

    		float avg=0;
    		for(int i=0;i<5;i++)
      			avg+=t[i].getSum();

    		System.out.println("Sum="+avg+"\nAvg="+(avg/1000));
  	}
}
