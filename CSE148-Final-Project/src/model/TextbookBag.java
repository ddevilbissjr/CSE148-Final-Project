package model;

public class TextbookBag {
	private Textbook[] textbookArray = new Textbook[50];
	private int nElems;
	public Textbook[] getTextbookArray() {
		return textbookArray;
	}
	public void setTextbookArray(Textbook[] textbookArray) {
		this.textbookArray = textbookArray;
	}
	public int getnElems() {
		return nElems;
	}
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
}
