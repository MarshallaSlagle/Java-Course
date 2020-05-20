package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel
{
	private JLabel lblNumberOfLabs;
	
	/**
	 * Constructor method used to initialize an object of the class InfoPanel
	 * <b>pre: </b> NA.<b>
	 * <b>post: </b>The Properties have been initialized.<b>
	 */
	public InfoPanel()
	{
		setLayout(new BorderLayout());
		lblNumberOfLabs = new JLabel("Laboratories: ");
		
		add(lblNumberOfLabs, BorderLayout.CENTER);
		
		TitledBorder title = new TitledBorder("Information");
		setBorder(title);
		
		setSize(new Dimension(50,10));
		
	}
	/**
	 * Method used to update the displayed numberOfFriends within the info panel of the GUI.
	 * <b>pre: </b>The object of type Agenda has been initialized.<b>
	 * <b>post: </b>The integer value displayed will be update to the value found within the object of type agenda.<b>
	 * @param pNumber of type integer will be used to display the current number of Friends in the object Agenda.<br>
	 */
	public void updateNumber(int pNumber)
	{
		lblNumberOfLabs.setText("Labs: " + pNumber);
		validate();
	}
	
}
