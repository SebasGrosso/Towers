package controllerTowerOfHanoi;

import java.util.Stack;

import modelTowerOfHanoi.Towers;

public class Controller {

	private Stack<Integer> towerOneController, towerTwoController, towerThreeController;
	private Towers towers;

	public Controller() {
		towers = new Towers();
		towerOneController = towers.getTowerOne();
		towerTwoController = towers.getTowerTwo();
		towerThreeController = towers.getTowerThree();
	}

	public int compareDisks(int selectedDisk, int numberTower) {
		return towers.compareDisks(selectedDisk, numberTower);
	}

	public Stack<Integer> getTowerOneController() {
		return towerOneController;
	}

	public Stack<Integer> getTowerTwoController() {
		return towerTwoController;
	}

	public Stack<Integer> getTowerThreeController() {
		return towerThreeController;
	}

}
