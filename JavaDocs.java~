import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaDocs extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JButton loadButton, saveButton, graphs;
    final JFileChooser fc = new JFileChooser();

    
    public JavaDocs(){
	this.setTitle("JavaDocs");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane=this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	loadButton = new JButton("Load File");
	loadButton.addActionListener(this);

	saveButton = new JButton("Save File");
	saveButton.addActionListener(this);

	graphs = new JButton("Show me graphy stuffs");

	t = new JTextField();

	JPanel buttons = new JPanel();
	buttons.add(loadButton);
	buttons.add(saveButton);

	pane.add (buttons);
	pane.add (t);
	pane.add (graphs);
    }

    public void actionPerformed (ActionEvent e){
	if (e.getSource() == loadButton){
	    if (e.getSource() == loadButton) {
		int returnVal = fc.showOpenDialog(JavaDocs.this);
	    }
	}
    }

}
