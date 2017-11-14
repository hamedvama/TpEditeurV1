package Receiver;

public class Bufer {
	
	private StringBuffer lestringbuffer;

	
	public StringBuffer getLestringbuffer() {
		return lestringbuffer;
	}

	public void setLestringbuffer(StringBuffer lestringbuffer) {
		this.lestringbuffer = lestringbuffer;
	}
	
	public StringBuffer couper (int deb, int fin) {
		return this.lestringbuffer.delete(deb, fin);
	}
	
	public String copier (int deb, int fin) {
		return this.lestringbuffer.substring(deb, fin);
	}
}
