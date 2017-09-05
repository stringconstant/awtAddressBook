package addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AddBook extends JFrame implements ActionListener{

    /**
	 * 
	 */
	
	ArrayList<String[]> storage = new ArrayList<String[]>();
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        AddBook window = new AddBook();
    }
	private String storeName = "";


    
	TextField name = new TextField();
	TextField ssn = new TextField();
	TextField phone = new TextField();
	TextField country = new TextField();
	TextField state = new TextField();
	Button find = new Button();
	Button submit = new Button();
	Button random = new Button();
	Label namePrompt = new Label();
	Label ssnPrompt = new Label();
	Label phonePrompt = new Label();
	Label countryPrompt = new Label();
	Label statePrompt = new Label();
	
	

    public AddBook() {
    	
    	

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout g = new GridLayout(7,2,10,10);
        setTitle("Address Book");

        setSize(400, 350);
        
        namePrompt.setText("Enter your name:");
        ssnPrompt.setText("Enter your ssn");
        phonePrompt.setText("Enter your phone number");
        countryPrompt.setText("Enter your country");
        statePrompt.setText("Enter your state");
        find.setLabel("Find Contact");
        submit.setLabel("Submit");
        random.setLabel("Generate Random");
        
        setLayout(g);
        add(namePrompt);
        add(name);
        add(ssnPrompt);
        add(ssn);
        add(phonePrompt);
        add(phone);
        add(countryPrompt);
        add(country);
        add(statePrompt);
        add(state);
        add(submit);
        add(find);
        add(random);
        
        find.addActionListener(this);
        submit.addActionListener(this);
        random.addActionListener(this);
    }
    
    public void deepWrite(){
    	try {
            FileWriter fw = new FileWriter("/Users/William/Documents/workspace/addressBook/src/addressbook/"+"store.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("\n"+"Name: "+name.getText()+"\nSSN: "+ssn.getText()+"\nPhone: "+phone.getText()+"\nCountry: "+country.getText()+"\nState: "+state.getText()+"\n");
            
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Sorry, there was an error.");
        }
    }
    
    public void random(){
    	
    	String[] firstName = new String[7];
    	
    	firstName[0] = "Johnny";
    	firstName[1] = "Milo";
    	firstName[2] = "Hewson";
    	firstName[3] = "Kiran";
    	firstName[4] = "Eric";
    	firstName[5] = "William";
    	firstName[6] = "Katherine";
    	
    	String[] lastName = new String[7];
    	
    	lastName[0] = "Lindbergh";
    	lastName[1] = "Last-Yuen";
    	lastName[2] = "Duffy";
    	lastName[3] = "Baucom";
    	lastName[4] = "Liu";
    	lastName[5] = "Du";
    	lastName[6] = "Wolfe";
    	Random ran = new Random();
    	Random ram = new Random();
    	int m = ran.nextInt(6);
    	int n = ram.nextInt(6);
    	try {
            FileWriter fw = new FileWriter("/Users/William/Documents/workspace/addressBook/src/addressbook/"+"store.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("\n"+"\n"+"Name: "+firstName[m]+" "+lastName[n]+"\nSSN: "+"987-90-135"+"\nPhone: "+"434-296-3043"+"\nCountry: "+"US"+"\nState: "+"Virginia"+"\n");
            
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Sorry, there was an error.");
        }
    }
    
    public String deepRead(){
    	String str = "";
    	try {
            FileReader fr = new FileReader("/Users/William/Documents/workspace/addressBook/src/addressbook/"+"store.txt");
            BufferedReader br = new BufferedReader(fr);
            
            while (br.ready()) {    // read while there are still lines to be read
                String thisLine = br.readLine(); // get next line from file
                str += thisLine+"\n";
            }
            
            br.close();
        } catch (IOException e) {
            System.out.println("Sorry, katherine could not be reached for comment.");
        }
    	
    	return str;

    }
    
    public void actionPerformed(ActionEvent e){
    	if (e.getSource() == submit){
    		storeName = name.getText();
//    		String[] informationArray = new String[5];
//    		informationArray[0] = name.getText();
//    		informationArray[1] = ssn.getText();
//    		informationArray[2] = phone.getText();
//    		informationArray[3] = country.getText();
//    		informationArray[4] = state.getText();
//    		storage.add(informationArray);
    		
    		deepWrite();
    		name.setText("");
    		ssn.setText("");
    		phone.setText("");
    		country.setText("");
    		state.setText("");
    		JOptionPane.showMessageDialog(null,storeName+" is added to the list");
//    		System.out.println(storage);
    		
    	}
    	if(e.getSource() == find){
//    		String str = "";
//    		for(int i = 0; i < storage.size();i++){
//    			String[] temp = storage.get(i);	
//    			str += "Name: "+ temp[0] +"\n"+"SSN: "+temp[1]+"\n"+"Phone: "+temp[2]+"\n"+"Country: "+temp[3]+"\n"+"State: "+temp[4]+"\n"+"\n";
//    		}
    		JOptionPane.showMessageDialog(null,deepRead());
    	}
    	
    	if(e.getSource() == random){
    		random();
    		JOptionPane.showMessageDialog(null, "Random Person Added");
    	}
    }
}