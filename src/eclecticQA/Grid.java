/*
 * author@ s. umut balkan
 * CS 461 Artifical Intelligence term project - eclecticQA
 * ID: 21401911
 * 
 *********************************
 * Grid.java
 * date: OCT/19/17
 */
package eclecticQA;

public class Grid {
	
	private int[][] grid;
	
	Grid(String str){
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < 5; j++)
				grid[i][j] = str.charAt(i);
		}
	}
}
