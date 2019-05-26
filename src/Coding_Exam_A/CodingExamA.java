package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	int robots;
	int sides;
	int sideLength;
	int turnDegrees;
	Color color;
	String RGBs;
	Thread[] threads;
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		CodingExamA runner = new CodingExamA();
		runner.run();

	}
	
	public void run()
	{
		robots = Integer.parseInt(JOptionPane.showInputDialog("Number of Robots: "));
		RGBs = JOptionPane.showInputDialog("Color of Robots: (Red, Green or Blue)");
		switch(RGBs) {
		case("Red"):
		color = Color.RED;
			break;
		
		case("Green"):
			color = Color.GREEN;	
			break;
		
		case("Blue"):
			color = Color.BLUE;
			break;
		}
		
		sides = Integer.parseInt(JOptionPane.showInputDialog("Number of Sides in Shape: "));
		sideLength = 200/sides;
		turnDegrees = 360/sides;
		threads = new Thread[robots];
		for (int i = 0; i < robots; i++) {
			Robot robo = new Robot(((i * 200) + 40) - ((i / 5) * 1000),((i / 5) * 80) + 80);
			threads[i] = new Thread(()->
			{
				robo.penDown();
				robo.setPenColor(color);
				robo.setSpeed(200);
				
				for(int x = 0; x < sides;x++) {
				robo.move(sideLength);
				robo.turn(turnDegrees);
				}
				robo.hide();
			});
			threads[i].start();
		}
		
		
				
		
	}
}
