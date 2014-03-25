/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1001095 PEREIRA Julien
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatrice extends JFrame implements ActionListener
{
  JLabel txt1 = new JLabel("Opérande 1 :"); // on définit ici tous les boutons et champs textes qui seront utilisés
  JLabel txt2 = new JLabel("+ Opérande 2 :");
  JLabel txt3 = new JLabel("Résultat :");
  JTextField Op1 = new JTextField("0",20);
  JTextField Op2 = new JTextField("0",20);
  JTextField Resultat = new JTextField("0",20);
  JButton Addition = new JButton("Addition");
  JButton Soustraction = new JButton("Soustraction");
  JButton Multiplication = new JButton("Multiplication");
  JButton Division = new JButton("Division");
  JButton Quitter = new JButton("Quitter");
  JButton Carrer = new JButton("Au carré ²");
 

  public Calculatrice() // constructeur de la calculette
  {
    super("Calculatrice");
    setSize(550,200); //  setSize(1024, 740);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = (JPanel)getContentPane();
    BorderLayout flow = new BorderLayout( );
    pane.setLayout(flow);

    JPanel nord=new JPanel( ); // définition de tous les éléments qui seront en haut de la calculatrice
    nord.add(txt1); // ainsi que leur couleur de fond.
    txt1.setBackground(Color.BLUE);
    nord.add(Op1);
    Op1.setBackground(Color.YELLOW);// JAUNE
    nord.add(txt2);
    txt2.setBackground(Color.BLUE);
    nord.add(Op2);
    Op2.setBackground(Color.YELLOW);
    nord.setBackground( new Color( 30, 220, 255 ) );
    pane.add(nord,BorderLayout.NORTH);

    JPanel centre = new JPanel();// Définition des éléments qui seront au centre.
    centre.add(txt3);
    centre.add(Resultat);
    Resultat.setBackground(Color.WHITE);
    centre.setBackground(Color.WHITE);
    pane.add(centre,BorderLayout.CENTER);

    JPanel sud = new JPanel();// Définition des éléments qui seront en bas.
    sud.add(Addition);
    Addition.addActionListener(this);
    sud.add(Soustraction);
    Soustraction.addActionListener(this);
    sud.add(Multiplication);
    Multiplication.addActionListener(this);
    sud.add(Division);
    Division.addActionListener(this);
    sud.add(Quitter);
    Quitter.addActionListener(this);
    sud.add(Carrer);
    Carrer.addActionListener(this);
    sud.setBackground(Color.BLUE);
    pane.add(sud,BorderLayout.SOUTH);

  }

  public void actionPerformed(ActionEvent evenement) //action à éxécuter pour chaque bouton.
  {
    if ( evenement.getSource()== Addition )
    {
        Resultat.setText(String.valueOf(Double.parseDouble(Op1.getText().replace(",",".")) + Double.parseDouble(Op2.getText().replace(",","."))).replace(".",","));
        txt2.setText("+ Opérande 2 :");
    }
    else if ( evenement.getSource() == Soustraction)
    {
        Resultat.setText(String.valueOf(Double.parseDouble(Op1.getText().replace(",",".")) - Double.parseDouble(Op2.getText().replace(",","."))).replace(".",","));
        txt2.setText("- Opérande 2 :");
    }
    else if ( evenement.getSource() == Multiplication)
    {
        Resultat.setText(String.valueOf(Double.parseDouble(Op1.getText().replace(",",".")) * Double.parseDouble(Op2.getText().replace(",","."))).replace(".",","));
        txt2.setText("* Opérande 2 :");
    }
    else if ( evenement.getSource() == Division)
    {
        Resultat.setText(String.valueOf(Double.parseDouble(Op1.getText().replace(",",".")) / Double.parseDouble(Op2.getText().replace(",","."))).replace(".",","));
        txt2.setText("/ Opérande 2 :");
    }
    else if( evenement.getSource() == Quitter)
    {
	  dispose( );
	  System.exit(0);
    }
    else if ( evenement.getSource() == Carrer)
    {
        double tmp = Double.parseDouble(Op1.getText().replace(",","."));
        tmp *= tmp;
        Resultat.setText(String.valueOf(tmp));
    }
  }

  public static void main(String[] args) //définition de la fenêtre de la calcultatrice, la position de départ et l'apparence.
  {
   try
   {
	  UIManager.setLookAndFeel
	    ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
   // ou("com.sun.java.swing.plaf.classic.WindowsLookAndFeel");
   // ou ("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
   // ou ("com.sun.java.swing.plaf.metal.MetalLookAndFeel");// par défaut

      Calculatrice form = new Calculatrice();
      form.setLocation( 300, 150 ); // position initiale de la fenêtre
      form.setVisible(true);
   }catch ( Exception e) { }

  }// fin main
}
