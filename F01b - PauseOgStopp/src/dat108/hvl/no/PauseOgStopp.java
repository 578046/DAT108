package dat108.hvl.no;
public class PauseOgStopp {

	public static void main(String[] args) {
		
		MinTraad t = new MinTraad("Tr�d1");
		t.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		t.stopp();
	}

}
