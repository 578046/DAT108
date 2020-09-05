package sendermottaker;

public class Melding {
	
	private String tekst;
	private boolean motatt = true;

	public boolean erMottatt() {
		return motatt;
	}

	public void send(String nyMelding) {
		tekst = nyMelding;
		motatt = false;
	}

	public String motta() {
		motatt = true;
		return tekst;
	}

}
