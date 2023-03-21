import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("hello");
		f.setVisible(true);
		f.setSize(650, 800);
		f.setLayout(new FlowLayout());
		JLabel l1=new JLabel("user :");
		f.add(l1);
		JTextField l2=new JTextField(20);
		f.add(l2);
		
		JLabel l3=new JLabel("user :");
		f.add(l3);
		
		JTextField l4=new JTextField(20);
		f.add(l4);
		
		JButton jb=new JButton("submit");
		f.add(jb);
	}

}
