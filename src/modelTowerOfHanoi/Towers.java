package modelTowerOfHanoi;

import java.util.Stack;

public class Towers {

	private Stack<Integer> towerOne, towerTwo, towerThree;

	public Towers() {
		towerOne = new Stack<Integer>();
		towerTwo = new Stack<Integer>();
		towerThree = new Stack<Integer>();
		towerOneDisks();
	}

	public void towerOneDisks() {
		towerOne.push(3);
		towerOne.push(2);
		towerOne.push(1);
	}

	public int compareDisks(int selectedDisk, int numberTower) {
		int signal = 0;
		switch (numberTower) {
		case 1:
			signal = analyzeTowerOne(selectedDisk, numberTower) ? 1 : -1;
			break;
		case 2:
			signal = analyzeTowerTwo(selectedDisk, numberTower) ? 1 : -1;
			break;
		case 3:
			signal = analyzeTowerThree(selectedDisk, numberTower) ? 1 : -1;
			break;
		}
		return signal;
	}

	public boolean analyzeTowerOne(int selectedDisk, int numberTower) {
		if (towerOne.empty()) {
			towerOne.push(selectedDisk);
			if (towerTwo.contains(selectedDisk)) {
				towerTwo.pop();
			} else {
				towerThree.pop();
			}
			return true;
		} else {
			if (selectedDisk < towerOne.peek()) {
				towerOne.push(selectedDisk);
				if (towerTwo.contains(selectedDisk)) {
					towerTwo.pop();
				} else {
					towerThree.pop();
				}
				return true;
			}
		}
		return false;
	}

	public boolean analyzeTowerTwo(int selectedDisk, int numberTower) {
		if (towerTwo.empty()) {
			towerTwo.push(selectedDisk);
			if (towerOne.contains(selectedDisk)) {
				towerOne.pop();
			} else {
				towerThree.pop();
			}
			return true;
		} else {
			if (selectedDisk < towerTwo.peek()) {
				towerTwo.push(selectedDisk);
				if (towerOne.contains(selectedDisk)) {
					towerOne.pop();
				} else {
					towerThree.pop();
				}
				return true;
			}
		}
		return false;
	}

	public boolean analyzeTowerThree(int selectedDisk, int numberTower) {
		if (towerThree.empty()) {
			towerThree.push(selectedDisk);
			if (towerTwo.contains(selectedDisk)) {
				towerTwo.pop();
			} else {
				towerOne.pop();
			}
			return true;
		} else {
			if (selectedDisk < towerThree.peek()) {
				towerThree.push(selectedDisk);
				if (towerTwo.contains(selectedDisk)) {
					towerTwo.pop();
				} else {
					towerOne.pop();
				}
				return true;
			}
		}
		return false;
	}

	public Stack<Integer> getTowerOne() {
		return towerOne;
	}

	public Stack<Integer> getTowerTwo() {
		return towerTwo;
	}

	public Stack<Integer> getTowerThree() {
		return towerThree;
	}
	
	

}
