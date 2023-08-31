package controllerTowerOfHanoi;


import java.util.Stack;

import javax.swing.SwingUtilities;
import viewTowerOfHanoi.View;

public class Main {
	
	public static void main(String[] args) {
		Stack<Integer>[] towers = new Stack[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Stack<>();
		}

		towers[0].push(3);
		towers[0].push(2);
		towers[0].push(1);
		SwingUtilities.invokeLater(() -> new View(towers));
	}

}