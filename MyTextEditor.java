import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;

class MyTextEditor extends JFrame implements ActionListener {
    private JPanel pnlBrowse,pnlTextEditor,pnlButtons;
    private JButton btnload,btnSave,btnSaveExit,btnCancel,btnExplore;
    private JTextField txtName;  
    private JTextArea txtEditor;
    private JLabel lblname;
    private JScrollPane scrollpane;
    private File f;
 
    public MyTextEditor(String title){
	super(title);
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,500);
	setVisible(true);
	addComponent();
    }
 
    public void addComponent(){
	panelBrowse();
	panelTextEditor();
	panelButtons();    
    }
 
    public void panelBrowse(){
	pnlBrowse=new JPanel();
	add(pnlBrowse,BorderLayout.NORTH);
	pnlBrowse.setLayout(new FlowLayout());
	lblname=new JLabel("Choose File Name: ");
	pnlBrowse.add(lblname);
	txtName=new JTextField(" ",30);
	pnlBrowse.add(txtName);
	btnExplore=new JButton("...");
	pnlBrowse.add(btnExplore);
	pnlBrowse.setBorder(BorderFactory.createEmptyBorder());
	btnExplore.addActionListener(this);
    }
 
    public void panelTextEditor(){
	pnlTextEditor=new JPanel();
	add(pnlTextEditor,BorderLayout.CENTER);
	pnlTextEditor.setLayout(new BorderLayout());
	txtEditor=new JTextArea(200,200);
	scrollpane = new JScrollPane(txtEditor);
	pnlTextEditor.add(scrollpane,BorderLayout.CENTER);
	pnlTextEditor.setBorder(BorderFactory.createEmptyBorder());
    }
 
    public void panelButtons(){
	pnlButtons=new JPanel();
	add(pnlButtons,BorderLayout.SOUTH);
	pnlButtons.setLayout(new FlowLayout());
	btnSave=new JButton("Save");
	pnlButtons.add(btnSave);
	btnSaveExit=new JButton("Save & Exit");
	pnlButtons.add(btnSaveExit);
	btnload=new JButton("Load");
	pnlButtons.add(btnload);
	btnCancel= new JButton("Cancel");
	pnlButtons.add(btnCancel);  
	pnlButtons.setBorder(BorderFactory.createEmptyBorder());
	btnload.addActionListener(this);
	btnSave.addActionListener(this);
	btnSaveExit.addActionListener(this);
	btnCancel.addActionListener(this);
    }
 
    public void fileLoad(){
	String filename = txtName.getText().trim();    
	Scanner input;
	txtEditor.setText(""); 
	try{
	    input = new Scanner(new File(filename));
	    while(input.hasNext()){
		txtEditor.append(input.nextLine());
		txtEditor.append("\n");  
	    }
	    input.close();
	}
	catch(Exception e){}  
    }
 
    public void fileSave(){
	String filename=txtName.getText().trim();  
	Formatter output;  
	try{
	    output=new Formatter(filename);    
	    output.format(txtEditor.getText());
	    output.close();    
	}
	catch(Exception e){}    
    }

    public void actionPerformed(ActionEvent ae){
	String cmd=ae.getActionCommand();  
	switch(cmd){
	case "Load":
	    fileLoad();
	    break;
   
	case "Save":
	    fileSave();    
	    break;
    
	case "Save & Exit":
	    fileSave();
	    setVisible(false);
	    System.exit(0);
	    break;
    
	case "Cancel":
	    System.exit(0);
	    break;
    
	case "...":
	    JFileChooser browse;
	    browse = new JFileChooser();
	    browse.setFileFilter(new FileNameExtensionFilter("txt Files","txt"));
	    browse.showOpenDialog(this);
	    f = browse.getSelectedFile();
	    txtName.setText(f.getAbsolutePath());      
	} 
    }
 
    public static void main (String[] args) {
	MyTextEditor textEditor = new MyTextEditor("Text Editor");
    }
}
