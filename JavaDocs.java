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
    private JLabel fileName;
    private String text;
    private String path;

    
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

	//File location
	fileName = new JLabel("File Name");

	graphs = new JButton("Show me graphy stuffs");

	//TextArea where you type things
	t = new JTextArea();
			  /*"This is your workspace!\n\n" +
			  "If you would like to open a text file, use the 'Load File' button above!\n\n" +
			  "Otherwise, make a new file by deleting this text and pressing the 'Save File' button when needed!\n"
			  );*/

	JPanel buttons = new JPanel();
	buttons.add(loadButton);
	buttons.add(saveButton);
	buttons.add(fileName);

	pane.add (buttons);
	pane.add (t);
	pane.add (graphs);
    }

    public void actionPerformed (ActionEvent e){
	if (e.getSource() == loadButton){
	    int returnVal = 0;
	    
	    returnVal = fc.showOpenDialog(JavaDocs.this);
	    

	    File file = null;
	    if (returnVal == JFileChooser.APPROVE_OPTION){
		file = fc.getSelectedFile();
		fileName.setText(file.getName());
	    } else {
		System.out.println("dingus");
	    }

	    /*//Clears the text in the TextArea
	    t.replaceRange("",0,197);The last number is the exact end of the 
				       default text in the text area. We can 
				       change both whenever.*/
	    text="";
	    try{
		Scanner s = new Scanner(file);
		while (s.hasNext()){
		    text+=s.next();
		}
	        t.setText(text+"\n");
	    }catch(FileNotFoundException error){
		System.out.println("File '"+file+"' not found, try again!");
		//Pretty sure this will never happen
	    }
	}

	if (e.getSource() == saveButton){
	    try{	
		FileWriter w = new FileWriter(fileName.getText());
		System.out.println("FileWriter constructed.");
		text = t.getText();
		System.out.println("Text added.");
		w.write(text);
		System.out.println("Text written.");
		w.close();
		System.out.println("FileWriter closed.");
	    }catch(IOException error){
		System.out.println(error);
	    }

	}
    }

}
