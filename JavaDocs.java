import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaDocs extends JFrame{ //implements ActionListener{
    private Container pane;

    
    public JavaDocs(){
	this.setTitle("JavaDocs");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane=this.getContentPane();
    }

}
