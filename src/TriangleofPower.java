import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
class ToP extends JPanel{

public class XListener implements ActionListener{
   public void actionPerformed(ActionEvent e){
	     double y = Double.parseDouble(yTF.getText());
	     double z = Double.parseDouble(zTF.getText());
	     double sol = Math.pow(z, 1.0 / y);
	     solLB.setText(" X is "+sol);
   }
}





public class YListener implements ActionListener{
   public void actionPerformed(ActionEvent e){ 	
	   	 double x = Double.parseDouble(xTF.getText());
	     double z = Double.parseDouble(zTF.getText());
	     double sol = Math.log(z) / Math.log(x); 
	     solLB.setText(" Y is "+sol);

   }
}




public class ZListener implements ActionListener{
   public void actionPerformed(ActionEvent e){ 	
	   	 double x = Double.parseDouble(xTF.getText());
	     double y = Double.parseDouble(yTF.getText());
	     double sol = Math.pow(x, y);
	     solLB.setText(" Z is "+sol);

   }
}

		Button xLB = new Button("Click here: X = Yroot(Z)");
		TextField  xTF = new TextField("FILL Y & Z");
		Button yLB = new Button("Click here: Y = logX(Z)");
		TextField  yTF = new TextField("FILL X & Z");
		Button zLB = new Button("Click here: Z = X ^ Y");
		TextField  zTF = new TextField("FILL X & Y");
		Label solLB = new Label("Solution goes here");
		double x, y, z;
	
	  public ToP(){
	      setLayout(null);
	      
	      add(xLB, 10, 250, 200, 20);
	      add(xTF, 10, 270, 200, 20);
	      add(yLB, 225, 10, 200, 20);
	      add(yTF, 225, 30, 200, 20);
	      add(zLB, 250, 250, 200, 20);
	      add(zTF, 250, 270, 200, 20);
	      add(solLB, 200, 300, 200, 30);
	      
	      xLB.addActionListener(new XListener());
	      yLB.addActionListener(new YListener());
	      zLB.addActionListener(new ZListener());
}

public void paintComponent(Graphics g) {
	super.paintComponent(g);
	setBackground(Color.black);
	g.setColor(Color.BLUE);
    int[] X = {50,250,450};
    int[] Y = {250,50,250};
    g.fillPolygon(X, Y, 3);
	g.setColor(Color.red);
	g.setFont(new Font("Times New Roman",1,20));
    g.drawString("X", 75, 240);
    g.drawString("Y", 240, 80);
    g.drawString("Z", 415, 240);

}


public void add(Component c, int x, int y, int w, int h){
   add(c);
   c.setLocation(x, y);
   c.setSize(w, h);
}




}

@SuppressWarnings("serial")
public class TriangleofPower extends JFrame{

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			new TriangleofPower();
		}
	});
}
	



public TriangleofPower(){	
		setSize(600, 525);
		setTitle("Triangle of Power");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new ToP());
	}

}
