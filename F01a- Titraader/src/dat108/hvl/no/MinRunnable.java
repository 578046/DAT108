package dat108.hvl.no;

public class MinRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}
