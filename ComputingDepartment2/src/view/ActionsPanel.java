package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ActionsPanel extends JPanel implements ActionListener
{
	
	public final static String ADDLab = "to add lab";
	public final static String ADDResearcher = "to add researcher";
	public final static String FINDYoungResearch = "find youngest researcher";
	public final static String FINDResearchAverage = "find researcher average age";
	public final static String FINDLargestLab = "find the largest Lab";
	public final static String FindOlderResearch = "find the researchers older then an age";
	
	
	private JButton btnAddLab;
	private JButton btnADDResearcher;
	private JButton btnFINDYoungResearch;
	private JButton btnFINDResearchAverage;
	private JButton btnFINDLargestLab;
	private JButton btnFindOlderResearch;
	
	private Frame frame;
	
	public ActionsPanel(Frame pFrame)
	{
		frame = pFrame;
		setLayout(new GridLayout(3,2));
		
		btnAddLab = new JButton("Add Lab");
		btnAddLab.setActionCommand(ADDLab);
		btnAddLab.addActionListener(this);
		
		btnADDResearcher = new JButton("Add Researcher to Lab");
		btnADDResearcher.setActionCommand(ADDResearcher);
		btnADDResearcher.addActionListener(this);
		
		btnFINDYoungResearch = new JButton("Find the Youngest Researcher");
		btnFINDYoungResearch.setActionCommand(FINDYoungResearch);
		btnFINDYoungResearch.addActionListener(this);
		
		btnFINDResearchAverage = new JButton("Find the Average Age of the Researchers");
		btnFINDResearchAverage.setActionCommand(FINDResearchAverage);
		btnFINDResearchAverage.addActionListener(this);
		
		btnFINDLargestLab = new JButton("Find the Largest Lab");
		btnFINDLargestLab.setActionCommand(FINDLargestLab);
		btnFINDLargestLab.addActionListener(this);
		
		btnFindOlderResearch = new JButton("Find Older Researcher");
		btnFindOlderResearch.setActionCommand(FindOlderResearch);
		btnFindOlderResearch.addActionListener(this);
		
		add(btnAddLab);
		add(btnADDResearcher);
		add(btnFINDYoungResearch);
		add(btnFINDResearchAverage);
		add(btnFINDLargestLab);
		add(btnFindOlderResearch);
		
		TitledBorder title = new TitledBorder("Actions");
		setBorder(title);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();
		
		if(command.equals(ADDLab))
		{
			frame.requestAddLab();
		}
		if(command.equals(ADDResearcher))
		{
			frame.requestAddResearcher();
		}
		if(command.equals(FINDYoungResearch))
		{
			frame.requestYoungResearch();
		}
		if(command.equals(FINDResearchAverage))
		{
			frame.requestResearchAverage();
		}
		if(command.equals(FINDLargestLab))
		{
			frame.requestLargestLab();
		}
		if(command.equals(FindOlderResearch))
		{
			frame.requestOlderResearch();
		}
		
		
	}
	
	
	
	
	
	
	
}
