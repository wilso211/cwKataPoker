import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2071813165089719725L;
	
	private JFrame frame;
	private JLabel p1Cards;
	private JLabel p2Cards;
	private JLabel p1Hand;
	private JLabel p2Hand;
	private JLabel gameResult;
	
	UI(String frameName)
	{
		this.frame = new JFrame(frameName);
		
	}
	
	public void initiateFrame()
	{
		this.frame.setSize(640, 480);
		Container pane = new Container();
		pane.setLayout(new FlowLayout());
		this.frame.setContentPane(pane);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.p1Cards = new JLabel("testp1c");
		this.p2Cards = new JLabel("testp2c");
		
		this.p1Hand = new JLabel("testp1h");
		this.p2Hand = new JLabel("testp2h");
		
		this.gameResult = new JLabel("testgr");
		
		this.frame.getContentPane().add(this.p1Cards);
		this.frame.getContentPane().add(this.p2Cards);
		this.frame.getContentPane().add(this.p1Hand);
		this.frame.getContentPane().add(this.p2Hand);
		this.frame.getContentPane().add(this.gameResult);
		
		
	}

	public void setP1Cards(String text)
	{
		this.p1Cards.setText(text);
	}
	
	public void setP2Cards(String text)
	{
		this.p2Cards.setText(text);
	}
	
	public void setP1HandType(String text)
	{
		this.p1Hand.setText(text);
	}
	
	public void setP2HandType(String text)
	{
		this.p2Hand.setText(text);
	}
	
	public void setResult(String text)
	{
		this.gameResult.setText(text);
	}
	
	public void showUI()
	{
		this.frame.setVisible(true);
	}
}
