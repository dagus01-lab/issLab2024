package src.main.resources.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class ButtonAsGui extends Observable implements  ActionListener{

//Factory method
public static ButtonAsGui createButtons(  String logo, String[] cmd  ){
	Frame fr = GuiUtils.initFrame(600,300);
	fr.add( new Label( logo ), BorderLayout.NORTH );
 	Panel p = new Panel();
 	p.setLayout(new GridLayout(2,3));
 	fr.add( p, BorderLayout.CENTER) ;
	 
	ButtonAsGui button = new ButtonAsGui();
	for( int i=0; i<cmd.length;i++)
		new ButtonBasic(p, cmd[i], button);	//button is the listener
	return button;
}

	@Override  //from ActionListener
	public void actionPerformed(ActionEvent e) {
		this.setChanged();
		this.notifyObservers(e.getActionCommand());
	}
}
