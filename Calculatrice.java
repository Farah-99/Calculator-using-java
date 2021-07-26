package pack1;


import java.awt.BorderLayout;
import java.lang.Math;
import java.awt.Color;
import java.awt.Composite;
import java.awt.CompositeContext;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import javax.swing.JOptionPane;

import javax.swing.*;

public class Calculatrice extends JFrame implements ActionListener {
	
		private JMenuBar menu;
		private JMenu item1;
		private JMenuItem item_eff;
		private JMenuItem item_quit;
		private JPanel pan;
		private JLabel lbx;
		private JLabel lby;
		private JTextField txtx;
		private JTextField txty;
		private JLabel res;
		private JTextField txtres;
		private JButton btn1, btn2,btn3,btn4, btn5, btn6, btn7, btn8;
		
		public Calculatrice() {
			this.setTitle("Calculatrice");
			this.setSize(300,300);
			this.setLayout(new BorderLayout());
			//pannel
			//entree
			pan = new JPanel();
			pan.setLayout(new GridLayout(7,2,3,3));
			lbx = new JLabel("Entrez x");
			pan.add(lbx);
			txtx = new JTextField(15);
			pan.add(txtx);
			lby = new JLabel("Entrez y");
			pan.add(lby);
			txty = new JTextField(15);
			pan.add(txty);
			res = new JLabel("Resultat");
			res.setForeground(Color.red);
			pan.add(res);
			txtres = new JTextField(15);
			txtres.setBorder(BorderFactory.createLineBorder(Color.red, 5));
			pan.add(txtres);
			//menuu
			menu = new JMenuBar();
			item1 = new JMenu("Fichier");
			menu.add(item1);
			item_eff = new JMenuItem("Effacer");
			item_quit = new JMenuItem("Quitter");
			item1.add(item_eff);
			item_eff.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					txtx.setText("");
					txty.setText("");
					txtres.setText("");
				}
			});
			item1.add(item_quit);
			item_quit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					 System.exit(0);
					
				}
			});
			this.add(menu,BorderLayout.NORTH);
			
			//les boutons
			btn1 = new JButton("+");
			btn1.addActionListener(this);
			btn2 = new JButton("-");
			btn2.addActionListener(this);
			btn3 = new JButton("x");
			btn3.addActionListener(this);
			btn4 = new JButton("/");
			btn4.addActionListener(this);
			btn5 = new JButton("x^y");
			btn5.addActionListener(this);
			btn6 = new JButton("log");
			btn6.addActionListener(this);
			btn7 = new JButton("exp");
			btn7.addActionListener(this);
			btn8 = new JButton("racine carre");
			btn8.addActionListener(this);
			pan.add(btn1);
			pan.add(btn5);
			pan.add(btn2);
			pan.add(btn7);
			pan.add(btn3);
			pan.add(btn6);
			pan.add(btn4);
			pan.add(btn8);
			
			this.add(pan,BorderLayout.CENTER);
				
		
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource()== btn1) {
				double a;
				a = Double.parseDouble(txtx.getText())+ Double.parseDouble(txty.getText());
			
				txtres.setText(" "+ a );
			}
			
			if (e.getSource()== btn2) {
				double a;
				a = Double.parseDouble(txtx.getText())- Double.parseDouble(txty.getText());
			
				txtres.setText(" "+ a );
			}
			
			if (e.getSource()== btn3) {
				double a;
				a = Double.parseDouble(txtx.getText())* Double.parseDouble(txty.getText());
			
				txtres.setText(" "+ a );
			}
			
			if (e.getSource()== btn4) {
				double a;
				a = Double.parseDouble(txtx.getText())/ Double.parseDouble(txty.getText());
			
				txtres.setText(" "+ a );
			}
			
			if (e.getSource()== btn5) {
				double a;
				a = Math.pow(Double.parseDouble(txtx.getText()), Double.parseDouble(txty.getText()));
				txtres.setText(" "+ a );
			}
			
			//btn6
			if ((e.getSource()== btn6) && (txty.getText().isEmpty())) {
				double a;
				a = Math.log(Double.parseDouble(txtx.getText()));
				txtres.setText(" "+ a );
			}
			else if ((e.getSource()== btn6) && (txtx.getText().isEmpty())) {
				double a;
				a = Math.log(Double.parseDouble(txty.getText()));
				txtres.setText(" "+ a );
			}
			else if ( ((e.getSource()== btn6) ) && !((txtx.getText().isEmpty())) && !((txtx.getText().isEmpty()))) {
				JOptionPane.showMessageDialog(Calculatrice.this,"Vous devez entrer un seul entier");
				txtres.setText(" ");
			}
			//btn7
			
			if ((e.getSource()== btn7) && (txty.getText().isEmpty())) {
				double a;
				a = Math.exp(Double.parseDouble(txtx.getText()));
				txtres.setText(" "+ a );
			}
			else if ((e.getSource()== btn7) && (txtx.getText().isEmpty())) {
				double a;
				a = Math.exp(Double.parseDouble(txty.getText()));
				txtres.setText(" "+ a );
			}
			else if (  (e.getSource()== btn7) && !((txtx.getText().isEmpty())) && !((txtx.getText().isEmpty()))) {
				JOptionPane.showMessageDialog(Calculatrice.this,"Vous devez entrer un seul entier");
				txtres.setText(" ");
			}
			//btn8
			if ((e.getSource()== btn8) && (txty.getText().isEmpty())) {
				double a;
				a = Math.sqrt(Double.parseDouble(txtx.getText()));
				txtres.setText(" "+ a );
			}
			else if ((e.getSource()== btn8) && (txtx.getText().isEmpty())) {
				double a;
				a = Math.sqrt(Double.parseDouble(txty.getText()));
				txtres.setText(" "+ a );
			}
			else if (  (e.getSource()== btn8)  && !((txtx.getText().isEmpty())) && !((txtx.getText().isEmpty()))) {
				JOptionPane.showMessageDialog(Calculatrice.this,"Vous devez entrer un seul entier");
				txtres.setText(" ");
			}
			
			
			
		}
	
	public static void main(String[] args) {
		Calculatrice cal = new Calculatrice();
		cal.setVisible(true);
	}

}
