package test.window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import java.util.Random;

class DemoWindow {

	private static Canvas canvas;
	private static JButton button;
	private static JFrame frame;
	private static JPanel panel;
	private static Random rand;
	private static BufferStrategy buffStrat;

	public static void main(String[] args){
		rand   = new Random();
		panel  = new JPanel();
		canvas = new Canvas();
		frame  = new JFrame("Test Title");
		button = new JButton("It's A Button!");

		JPanel buttonPanel = new JPanel(new BorderLayout());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button.setPreferredSize(new Dimension(255, 125));
		button.addActionListener(new ActionListener(){
			private String previousText = "It's Been Clicked!";
			public void actionPerformed(ActionEvent e){
				String tmp = button.getText();
				button.setText(previousText);
				previousText = tmp;

				Graphics g = buffStrat.getDrawGraphics();
				canvas.paint(g);

				g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

				for(int i = 0; i < 10; i++){
					g.drawRect(rand.nextInt(205), rand.nextInt(205), rand.nextInt(50), rand.nextInt(50));
				}

				g.dispose();
				buffStrat.show();
			}
		});

		JButton clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(255, 125));
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Graphics g = canvas.getGraphics();
				canvas.paint(g);
				g.dispose();
			}
		});

		canvas.setPreferredSize(new Dimension(255, 255));

		buttonPanel.add(button, BorderLayout.NORTH);
		buttonPanel.add(clearButton, BorderLayout.SOUTH);
		frame.add(panel);
		panel.add(buttonPanel);
		panel.add(canvas);
		frame.pack();

		canvas.createBufferStrategy(2);
		buffStrat = canvas.getBufferStrategy();

		frame.setVisible(true);
	}
}

