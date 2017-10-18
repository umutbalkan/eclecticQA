/*
 * author@ s. umut balkan
 * CS 461 Artifical Intelligence term project - eclecticQA
 * ID: 21401911
 * 
 *********************************
 * Clue.java
 * date: OCT/18/17
 */
package eclecticQA;

public class Clue {
	
	// Properties
	private String c_txt;
	private int	c_index;
	
	// Constructor
	Clue(String clue, int i){
		c_txt = clue;
		c_index = i;
	}
	
	// Getters & Mutators
	public String getClue_txt() {
		return c_txt;
	}
	public void setClue_txt(String clue_txt) {
		this.c_txt = clue_txt;
	}
	
	public int getIndex() {
		return c_index;
	}
	public void setIndex(int index) {
		this.c_index = index;
	};
}
