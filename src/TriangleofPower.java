import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ToP extends JPanel{

public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
		strNum = strNum+d;
    } catch (NumberFormatException nfe) {
        return false;
    }
	
    return true;
}	

public static boolean isInteger(double d) {
	return (d % 1) == 0;
}

public class XListener implements ActionListener{
   public void actionPerformed(ActionEvent e){
		if(isNumeric(yTF.getText()) && isNumeric(zTF.getText())){
 	     double y = Double.parseDouble(yTF.getText());
	     double z = Double.parseDouble(zTF.getText());
	     double sol = Math.pow(z, 1.0 / y);
		if(isInteger(sol)){
		xTF.setText(""+(int)sol);
		if(isInteger(y) && isInteger(z)){
	    solLB.setText(" X is "+(int)sol+", all sides are Integers");
		}else{
	    solLB.setText(" X is "+(int)sol);
		}
		}else{
	    solLB.setText(" X is "+sol);
		xTF.setText(""+sol);
		} 
		}else{
	    solLB.setText("Invalid Input");
		}		 
   }
}





public class YListener implements ActionListener{
   public void actionPerformed(ActionEvent e){
		if(isNumeric(xTF.getText()) && isNumeric(zTF.getText())){
	   	double x = Double.parseDouble(xTF.getText());
	    double z = Double.parseDouble(zTF.getText());
	    double sol = Math.log(z) / Math.log(x);
		if(isInteger(sol)){
		yTF.setText(""+(int)sol);
		if(isInteger(x) && isInteger(z)){
	    solLB.setText(" Y is "+(int)sol+", all sides are Integers");
		}else{
	    solLB.setText(" Y is "+(int)sol);
		}
		}else{
	    solLB.setText(" Y is "+sol);
		yTF.setText(""+sol);
		} 
		}else{
	    solLB.setText("Invalid Input");
		} 	


   }
}




public class ZListener implements ActionListener{
   public void actionPerformed(ActionEvent e){ 	
		if(isNumeric(xTF.getText()) && isNumeric(yTF.getText())){
 	   	 double x = Double.parseDouble(xTF.getText());
	     double y = Double.parseDouble(yTF.getText());
	     double sol = Math.pow(x, y);
		if(isInteger(sol)){
		zTF.setText(""+(int)sol);
		if(isInteger(x) && isInteger(y)){
	    solLB.setText(" Z is "+(int)sol+", all sides are Integers");
		}else{
	    solLB.setText(" Z is "+(int)sol);
		}
		}else{
	    solLB.setText(" Z is "+sol);
		zTF.setText(""+sol);
		} 
		}else{
	    solLB.setText("Invalid Input");
		} 		 

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
