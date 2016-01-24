import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class JavaDocs extends JFrame implements ActionListener{
    private Container pane;
    private JEditorPane t;
    private JButton newFileButton, loadButton, saveButton, fonts, format, wordCount, color, fontSize;
    final JFileChooser fc = new JFileChooser();
    private JLabel fileName;
    private String text;
    private String path;
    private JScrollPane scroll;


    //Constructor of the GUI
    public JavaDocs(){
	this.setTitle("JavaDocs");
	this.setSize(800,600);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane=this.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	//Load button
	loadButton = new JButton("Load File");
	loadButton.addActionListener(this);

	//Save button
	saveButton = new JButton("Save File");
	saveButton.addActionListener(this);

	//New File Button
	newFileButton = new JButton("New File");
	newFileButton.addActionListener(this);

	//File Name label
	fileName = new JLabel("File Name");

	//Fonts button
	fonts = new JButton("Fonts");
	fonts.addActionListener(this);

	//Format the text
	format = new JButton("Format");
	format.addActionListener(this);

	//Word Count
	wordCount = new JButton("Word Count");
	wordCount.addActionListener(this);

	//Color the text
	color = new JButton("Color");
	color.addActionListener(this);

	//Font Size
	fontSize = new JButton("Font Size");
	fontSize.addActionListener(this);

	//Text area where you type things
	t = new JEditorPane("",
	       "This is your workspace!\n\n" +
	       "If you would like to open a text file, use the 'Load File' button!\n\n" +
	       "Otherwise, make a new file by pressing the 'New File' button.\n\n"+
	       "Please remember to save your work before exiting, we are not responsible for any lost text!\n");
	
	//Scrollpane for text area
	scroll = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	
	//JPanel for the upper buttons
        JPanel buttons = new JPanel();
	buttons.add(newFileButton);
        buttons.add(Box.createRigidArea(new Dimension(10,0)));
	buttons.add(loadButton);
	buttons.add(Box.createRigidArea(new Dimension(10,0)));
	buttons.add(saveButton);
	buttons.add(Box.createRigidArea(new Dimension(10,0)));
	buttons.add(fileName);
	buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

	//JPanel for the lower buttons
	JPanel bottomButtons = new JPanel();
	bottomButtons.add(fonts);
	bottomButtons.add(Box.createRigidArea(new Dimension(10,0)));
	bottomButtons.add(format);
	bottomButtons.add(Box.createRigidArea(new Dimension(10,0)));
	bottomButtons.add(wordCount);
	bottomButtons.add(Box.createRigidArea(new Dimension(10,0)));
	bottomButtons.add(color);
	bottomButtons.add(Box.createRigidArea(new Dimension(10,0)));
	bottomButtons.add(fontSize);
	bottomButtons.setLayout(new BoxLayout(bottomButtons, BoxLayout.LINE_AXIS));

	//Put everything together
	pane.add(Box.createRigidArea(new Dimension(0,10)));
	pane.add(buttons);
	pane.add(Box.createRigidArea(new Dimension(0,10)));
	pane.add(scroll);
	pane.add(Box.createRigidArea(new Dimension(0,10)));
	pane.add(bottomButtons);
	pane.add(Box.createRigidArea(new Dimension(0,10)));
    }


    //What to do when a button is pressed
    public void actionPerformed (ActionEvent e){

	//If New File button is pressed
	if (e.getSource() == newFileButton){
	    String newFileName = JOptionPane.showInputDialog ("Please type in your new file's name.");
	    
	    if(!(newFileName == null) && !(newFileName == "")){
		fileName.setText(newFileName+".txt");
		t.setText("");
	    }else{}
	    //If Cancel or X is pressed, nothing happens
	}
	    

	//If Load button is pressed
	if (e.getSource() == loadButton){
	    int returnVal = 0;
	    returnVal = fc.showOpenDialog(JavaDocs.this);

	    File file = null;
	    if (returnVal == JFileChooser.APPROVE_OPTION){
		file = fc.getSelectedFile();
		
		//Check if file selected ends in .txt, prints error if so
		if (!(file.getName()).endsWith(".txt")){
		    JOptionPane.showMessageDialog (null, "File not loaded. Please only load files that end in '.txt'.", "Loading Failed",JOptionPane.PLAIN_MESSAGE);
		}else{	
		    text="";
		    fileName.setText(file.getName());
		    
		    //Load the text from file into the text area
		    try{
			Scanner s = new Scanner(file);
			while (s.hasNextLine()){
			    text+=s.nextLine()+"\n";
			}
			t.setText(text+"\n");
		    }catch(FileNotFoundException error){
			System.out.println("File '"+file+"' not found!");
			//This should NEVER happen
		    }
		}
	    }else {}
	    //If Cancel or X is pressed, nothing happens
	}
	

	//If Save button is pressed
	if (e.getSource() == saveButton){
	    
	    //Write the text from text area into the file
	    try{
		FileWriter w = new FileWriter(fileName.getText());
		text = t.getText();
		w.write(text);
		w.close();
		JOptionPane.showMessageDialog (null, "Your file has been saved!", "File Saved",JOptionPane.PLAIN_MESSAGE);
	    }catch(IOException error){
		System.out.println("File was not saved, please try again!");
		//This should NEVER happen
	    }
	}


	//If Fonts button is pressed
	if (e.getSource() == fonts){
	    String[] choices = {"Times New Roman", "Comic Sans MS", "Serif", "SansSerif", "Monospaced"};
	    Object s = JOptionPane.showInputDialog(null, "Choose your preferred font", "Fonts", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
	    
	    if (s!=null){
		Font newFont = new Font(s.toString(), Font.PLAIN, t.getFont().getSize());
		t.setFont(newFont);
	    }else{}
	    //If Cancel or X is pressed, nothing happens
	}


	//If Format button is pressed
	if (e.getSource() == format){
	    String[] choices = {"Plain", "Bold", "Italic"};
	    Object s = JOptionPane.showInputDialog(null, "", "Format", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
	    
	    if (s!=null){
		
		if (s.toString().equals("Plain")){
		    Font newFont = new Font(t.getFont().getName(), Font.PLAIN, t.getFont().getSize());
		    t.setFont(newFont);
		}
		
		if (s.toString().equals("Bold")){
		    Font newFont = new Font(t.getFont().getName(), Font.BOLD, t.getFont().getSize());
		    t.setFont(newFont);
		}
		
		if (s.toString().equals("Italic")){
		    Font newFont = new Font(t.getFont().getName(), Font.ITALIC, t.getFont().getSize());
		    t.setFont(newFont);
		}
	    }	
	}


	//If Word Count button is pressed
	if (e.getSource() == wordCount){
	    ArrayList<String> test = splitString(t.getText());
	    Object[] testary = test.toArray();
	    
	    for (int i = 0; i < testary.length; i++){
		System.out.println(testary[i]);
	    }   
	    JOptionPane.showMessageDialog(null, "Word Count: " + countWords(splitString(t.getText()))  + " words", "Word Count", JOptionPane.PLAIN_MESSAGE);
	}


	//If Colors button is pressed
	if (e.getSource() == color){
	    String[] choices = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red",  "Yellow"};
	    Object s = JOptionPane.showInputDialog(null, "Choose your preferred color", "Colors", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

	    if (s!=null){
	    /*I apologize for this terrible coding, but due to the nature of Java Colors, I was unable to utilize user inputs in such a way that I could take what the user typed and translate it into a Java.Color.*/
		if (s.toString().equals("Black")){
		    t.setForeground(Color.black);
		}
		if (s.toString().equals("Blue")){
		    t.setForeground(Color.blue);
		}
		if (s.toString().equals("Cyan")){
		    t.setForeground(Color.cyan);
		}
		if (s.toString().equals("Dark Gray")){
		    t.setForeground(Color.darkGray);
		}
		if (s.toString().equals("Gray")){
		    t.setForeground(Color.gray);
		}
		if (s.toString().equals("Green")){
		    t.setForeground(Color.green);
		}
		if (s.toString().equals("Light Gray")){
		    t.setForeground(Color.lightGray);
		}
		if (s.toString().equals("Magenta")){
		    t.setForeground(Color.magenta);
		}
		if (s.toString().equals("Orange")){
		    t.setForeground(Color.orange);
		}
		if (s.toString().equals("Pink")){
		    t.setForeground(Color.pink);
		}
		if (s.toString().equals("Red")){
		    t.setForeground(Color.red);
		}
		if (s.toString().equals("Yellow")){
		    t.setForeground(Color.yellow);
		}
	    }
	}


	//If Font Size button is pressed
	if (e.getSource() == fontSize){
	    String num = JOptionPane.showInputDialog ("Please input a number greater than 0 and less than 65.", 12);

	    if (num!=null&&num!=""){
		try{
		    int nums = Integer.parseInt(num);
		    
		    if (nums<1){
			JOptionPane.showMessageDialog (null, "You cannot have a font size of less than 1! Fonts don't work that way. Settle for a larger font please!", "Font Resize Failed",JOptionPane.PLAIN_MESSAGE);
		    }
		    
		    if (nums>64){
			JOptionPane.showMessageDialog (null, "I don't care how much you can't see, 64 is big enough! Settle for a smaller font please!", "Font Resize Failed",JOptionPane.PLAIN_MESSAGE);
		    }
		    
		    if (nums<65 && nums>0){
			Font newFont = new Font(t.getFont().getName(), t.getFont().getStyle(), nums);
			t.setFont(newFont);
		    }
		    
		}catch (NumberFormatException error){
		    JOptionPane.showMessageDialog (null, "Please input an actual number!", "Font Resize Failed",JOptionPane.PLAIN_MESSAGE);
		}
	    }else{}
	}
	
    }

    
    //Function for Count Words, not associated with any button presses
    public ArrayList<String> splitString(String str){
	ArrayList<String> strAryLst = new ArrayList();
	String[] splitted = str.split("\n");
	
	for (int i = 0; i < splitted.length; i++){
	    String[] newstuff = splitted[i].split(" ");
	    
	    for (int j = 0; j < newstuff.length; j++){
		strAryLst.add(newstuff[j]);
	    }
	}
	return strAryLst;
    }


    //Function for Count Words, not associated with any button presses
    public int countWords(ArrayList<String> str){return str.size();}
    
}
