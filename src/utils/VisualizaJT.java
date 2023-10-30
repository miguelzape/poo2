package utils;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VisualizaJT extends JFrame{
	
	public void visualizaDBJtable(String[] cabecera, String[][] tabla) {
		this.setSize(480, 200);

		JPanel panel = new JPanel();
		JLabel label = new JLabel("Tabla:");
		//ConList conlist =new ConList();
		//JScrollPane scroller = new JScrollPane(conList);
		label.setAlignmentX(1);
		label.setAlignmentY(1);

		JTable table = new JTable(tabla,cabecera);
		
		JScrollPane scrollpane = new JScrollPane(table);
		panel.add(scrollpane);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label);
		//panel.add(scroller);
		this.add(panel);
		this.setVisible(true);

	}

}
