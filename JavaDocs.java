import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class JavaDocs extends JFrame implements ActionListener{
    private Container pane;
    private JTextArea t;
    private JButton loadButton, saveButton, graphs;
    final JFileChooser fc = new JFileChooser();
    private String text;

    
    public JavaDocs(){
	this.setTitle("JavaDocs");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane=this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	//load button
	loadButton = new JButton("Load File");
	loadButton.addActionListener(this);

	//save button
	saveButton = new JButton("Save File");
	saveButton.addActionListener(this);

	graphs = new JButton("Show me graphy stuffs");

	//TextArea where you type things
	t = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(t);
	t.setEditable(true);

	JPanel buttons = new JPanel();
	buttons.add(loadButton);
	buttons.add(saveButton);

	pane.add (buttons);
	pane.add (t);
	pane.add (graphs);
    }

    public void actionPerformed (ActionEvent e){
	if (e.getSource() == loadButton){
	    int returnVal = 0;
	    if (e.getSource() == loadButton) {
		returnVal = fc.showOpenDialog(JavaDocs.this);
	    }

	    File file = null;
	    if (returnVal == JFileChooser.APPROVE_OPTION){
		file = fc.getSelectedFile();
	    } else {
		System.out.println("dingus");
	    }

	    text="";
	    try{
		Scanner s = new Scanner(file);
		while (s.hasNext()){
		    text+=s.next();
		}
	        t.append(text);
	    }catch(FileNotFoundException error){
		System.out.println("File '"+file+"' not found, try again!");
		//Pretty sure this will never happen
	    }
	}

	if (e.getSource() == saveButton){
	    FileWriter w = new FileWriter();
	    String text = t.getText();

	    w.write(text);
	    w.close();
	    
	}
    }

}
