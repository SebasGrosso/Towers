package viewTowerOfHanoi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllerTowerOfHanoi.Controller;

public class View {
	private JFrame frame;
	private JPanel towerPanel1;
	private JPanel towerPanel2;
	private JPanel towerPanel3;
	private Stack<Integer>[] towers;
	private int selectedTowerIndex;
	private int selectedDiscValue;
	private int numberDisk;
	private int numberTower;
	private Controller controller;

	public View(Stack<Integer>[] towers) {
		controller = new Controller();
		this.towers = towers;
		frame = new JFrame("Torres de Hanoi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		towerPanel1 = createTowerPanel(0);
		towerPanel2 = createTowerPanel(1);
		towerPanel3 = createTowerPanel(2);
		frame.setLayout(new GridLayout(1, 3));
		frame.add(towerPanel1);
		frame.add(towerPanel2);
		frame.add(towerPanel3);
		frame.pack();
		frame.setVisible(true);
		selectedTowerIndex = -1;
		selectedDiscValue = -1;
		frame.setLocationRelativeTo(null);
	}

	private JPanel createTowerPanel(int towerIndex) {
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				int towerX = getWidth() / 2 - 5;
				int towerY = 40;
				int towerHeight = getHeight() - 40;

				g.setColor(Color.BLACK);
				g.fillRect(towerX, towerY, 10, towerHeight);

				Stack<Integer> tower = towers[towerIndex];
				int discWidthFactor = 20;
				int discHeight = 20;
				int discY = getHeight() - discHeight;
				for (Integer discSize : tower) {
					int discWidth = discSize * discWidthFactor;
					int discX = getWidth() / 2 - discWidth / 2;
					g.setColor(Color.BLUE);
					g.fillRect(discX, discY, discWidth, discHeight);
					discY -= discHeight + 2;
				}
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int clickedTower = towerIndex;
				if (e.getSource() == towerPanel1) {
					clickedTower = 0;
				} else if (e.getSource() == towerPanel2) {
					clickedTower = 1;
				} else if (e.getSource() == towerPanel3) {
					clickedTower = 2;
				}
				if (selectedTowerIndex == -1) {
					if (!towers[clickedTower].isEmpty()) {
						selectedTowerIndex = clickedTower;
						numberDisk = towers[clickedTower].peek();
						
					}
				} else {
					if (clickedTower != selectedTowerIndex
							&& (towers[clickedTower].isEmpty() || selectedDiscValue < towers[clickedTower].peek())) {
						numberTower = clickedTower +1;
						ejecutarLogica();
					} else {
					}
					selectedTowerIndex = -1;
					selectedDiscValue = -1;
				}
			}
		});
		panel.setPreferredSize(new Dimension(200, 300));
		return panel;
	}
	
	public void ejecutarLogica() {
		if(controller.compareDisks(numberDisk, numberTower) == 1) {
			newStacks();
			frame.repaint();
		}
		
	}
	
	public void newStacks() {
		towers[0] = controller.getTowerOneController();
		towers[1] = controller.getTowerTwoController();
		towers[2] = controller.getTowerThreeController();
	}


}


