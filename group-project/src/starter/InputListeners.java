package starter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;
import java.util.HashMap;
import javax.swing.*;

import acm.graphics.GImage;

import java.awt.event.*;
import java.awt.*;

public class InputListeners extends JFrame implements KeyListener{

	public static void main(String[] args) {
		   
		  new InputListeners();
		  }
	
		 JLabel label;
		 GImage icon;
		 
		 InputListeners(){  
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setSize(500,500);
		  this.setLayout(null);
		  this.addKeyListener(this);
		  
		  icon = new GImage("rock.png");
		  
		  label = new JLabel();
		  label.setBounds(0, 0, 100, 100);
		  this.add(label);
		  this.setVisible(true);
		 }

		 @Override
		 public void keyTyped(KeyEvent e) {
		  switch(e.getKeyChar()) {
		   case 'a': label.setLocation(label.getX()-10, label.getY());
		    break;
		   case 'w': label.setLocation(label.getX(), label.getY()-10);
		    break;
		   case 's': label.setLocation(label.getX(), label.getY()+10);
		    break;
		   case 'd': label.setLocation(label.getX()+10, label.getY());
		    break;
		  }
		  
		 }

		 @Override
		 public void keyPressed(KeyEvent e) {
		  switch(e.getKeyCode()) {
		  case 37: label.setLocation(label.getX()-10, label.getY());
		   break;
		  case 38: label.setLocation(label.getX(), label.getY()-10);
		   break;
		  case 39: label.setLocation(label.getX()+10, label.getY());
		   break;
		  case 40: label.setLocation(label.getX(), label.getY()+10);
		   break;
		 }
		 }

		 @Override
		 public void keyReleased(KeyEvent e) {
		  System.out.println("You released key char: " + e.getKeyChar());
		  System.out.println("You released key code: " + e.getKeyCode());
		 }
		
//	   private static final int ANIMATION_DELAY = 15;
//	   private final int HEIGHT = 400;
//	   private final int WIDTH = 600;
//	   private Square square;
//	   private EnumMap<Direction, Boolean> dirMap = new EnumMap<>(Direction.class);
//	   private Map<Integer, Direction> keyToDir = new HashMap<>();
//	   private Timer animationTimer;
//
//	   public InputListeners() {
//	      for (Direction dir : Direction.values()) {
//	         dirMap.put(dir, Boolean.FALSE);
//	      }
//	      keyToDir.put(KeyEvent.VK_UP, Direction.UP);
//	      keyToDir.put(KeyEvent.VK_DOWN, Direction.DOWN);
//	      keyToDir.put(KeyEvent.VK_LEFT, Direction.LEFT);
//	      keyToDir.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
//	      setKeyBindings();
//	      setBackground(Color.white);
//	      setPreferredSize(new Dimension(WIDTH, HEIGHT));
//	      setFocusable(true);
//	      square = new Square();
//	      animationTimer = new Timer(ANIMATION_DELAY, new AnimationListener());
//	      animationTimer.start();
//	   }
//
//	   private void setKeyBindings() {
//	      int condition = WHEN_IN_FOCUSED_WINDOW;
//	      final InputMap inputMap = getInputMap(condition);
//	      final ActionMap actionMap = getActionMap();
//	      boolean[] keyPressed = { true, false };
//	      for (Integer keyCode : keyToDir.keySet()) {
//	         Direction dir = keyToDir.get(keyCode);
//	         for (boolean onKeyPress : keyPressed) {
//	            boolean onKeyRelease = !onKeyPress; // to make it clear how bindings work
//	            KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0,
//	                  onKeyRelease);
//	            Object key = keyStroke.toString();
//	            inputMap.put(keyStroke, key);
//	            actionMap.put(key, new KeyBindingsAction(dir, onKeyPress));
//	         }
//	      }
//	   }
//
//	   public void paintComponent(Graphics g) {
//	      super.paintComponent(g);
//	      square.display(g);
//	   }
//
//	  
//
//	   private class AnimationListener implements ActionListener {
//	      @Override
//	      public void actionPerformed(ActionEvent evt) {
//	         boolean repaint = false;
//	         for (Direction dir : Direction.values()) {
//	            if (dirMap.get(dir)) {
//	               square.move(dir);
//	               repaint = true;
//	            }
//	         }
//	         if (repaint) {
//	            repaint();
//	         }
//	      }
//	   }
//
//	   private class KeyBindingsAction extends AbstractAction {
//	      private Direction dir;
//	      boolean pressed;
//
//	      public KeyBindingsAction(Direction dir, boolean pressed) {
//	         this.dir = dir;
//	         this.pressed = pressed;
//	      }
//
//	      @Override
//	      public void actionPerformed(ActionEvent evt) {
//	         dirMap.put(dir, pressed);
//	      }
//	   }
//
//	   private static void createAndShowGUI() {
//	      InputListeners gamePanel = new InputListeners();
//	      JFrame frame = new JFrame("GamePanel");
//	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	      frame.getContentPane().add(gamePanel);
//	      frame.pack();
//	      frame.setLocationRelativeTo(null);
//	      frame.setVisible(true);
//	      gamePanel.requestFocusInWindow();
//	   }
//
//	   public static void main(String[] args) {
//	      SwingUtilities.invokeLater(new Runnable() {
//	         public void run() {
//	            createAndShowGUI();
//	         }
//	      });
//	   }
//	}
//
//	enum Direction {
//	   UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);
//	   private int incrX;
//	   private int incrY;
//
//	   private Direction(int incrX, int incrY) {
//	      this.incrX = incrX;
//	      this.incrY = incrY;
//	   }
//
//	   public int getIncrX() {
//	      return incrX;
//	   }
//
//	   public int getIncrY() {
//	      return incrY;
//	   }
//	}
//
//	class Square {
//	   private int x = 0;
//	   private int y = 0;
//	   private int w = 20;
//	   private int h = w;
//	   private int step = 1;
//	   private Color color = Color.red;
//	   private Color fillColor = new Color(255, 150, 150);
//	   private Stroke stroke = new BasicStroke(3f, BasicStroke.CAP_ROUND,
//	         BasicStroke.JOIN_ROUND);
//
//	   public void display(Graphics g) {
//	      Graphics2D g2d = (Graphics2D) g.create();
//	      g2d.setColor(fillColor);
//	      g2d.fillRect(x, y, w, h);
//	      g2d.setStroke(stroke);
//	      g2d.setColor(color);
//	      g2d.drawRect(x, y, w, h);
//	      g2d.dispose();
//	   }
//
//	   public void setStep(int step) {
//	      this.step = step;
//	   }
//
//	   public void move(Direction dir) {
//	      x += step * dir.getIncrX();
//	      y += step * dir.getIncrY();
//	   }


}