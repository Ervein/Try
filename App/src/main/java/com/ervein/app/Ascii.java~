package com.ervein.app;
import com.ervein.app.AsciiValidation;
import com.ervein.service.AsciiService;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Ascii extends AsciiService{
    static AsciiValidation val = new AsciiValidation();
    static AsciiService ascii = new AsciiService();
    public static void main(String args[]) {
        final String MESSAGE = "Choose an action to perform:";
        final String DEFAULT_VAL = "Print table";
        final String EXIT_MESSAGE = "No action chosen. \nProgram terminates now.";
        final String EXIT_TITLE = "Exit Program";
        
        String[] options = {"Print table", "Edit Cell", "Search character", "Add Row/s", "Sort Row/s", "Reset Table", "Exit"};
        boolean repeat = true;
        
        String filePath = checkPath (args);
        ascii.setFilePath(filePath);
        ascii.setTable();
        do {
            String action = (String) JOptionPane.showInputDialog(null, MESSAGE, "OPTIONS", JOptionPane.PLAIN_MESSAGE, null, options, DEFAULT_VAL);
            if (action == "Print table") {
                ascii.displayTable();
            }
            else if (action == "Edit Cell") {
                inputForEditCell();
            }
            else if (action == "Search character") {
                inputForSearchTable();
            }
            else if (action == "Add Row/s") {
                inputForAddRow();
            }
            else if (action == "Sort Row/s") {
                ascii.sortRows();
            }
            else if (action == "Reset Table") {
                new Ascii().resetTable();
            }
            else if (action == "Exit") {
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, EXIT_MESSAGE, EXIT_TITLE, JOptionPane.PLAIN_MESSAGE);
                break;
            }
        } while (getAnswer());
        
        System.exit(0);
    }
    
    static String checkPath (String path[]) {
        int length = 0;
        try {
            length = path.length;
            if (length > 1){
                JOptionPane.showMessageDialog(null, "Please include one file only.", "Multiple Files", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
            
            File file = new File(path[0]);
            if(!file.exists()) { 
                JOptionPane.showMessageDialog(null, "File does not exist or invalid.", "Invalid File", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please include a file.", "No File", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        
        return path[0];
    }
    
    static boolean getAnswer() {
        final String MESSAGE = "Would you like to perform another action?";
        final String MESSAGE_TITLE = "Another Action";
        int n = JOptionPane.showConfirmDialog(null, MESSAGE, MESSAGE_TITLE, JOptionPane.YES_NO_OPTION);
        if (n == 1) {
            return false;
        }
        return true;
    }
    
    static void inputForEditCell(){
        final int PRESSED_OK = 0;
    	String tempRowIndex = "";
		String tempColumnIndex = "";
    	String key = "";
		String value = "";
		int rowIndexFromUser = 0;
		int columnIndexFromUser = 0;
		int result;
		int result2;
		boolean repeat = false;
    	JTextField rowField = new JTextField(5);
    	JTextField columnField = new JTextField(5);
    	JPanel cellPanel = new JPanel();
    	cellPanel.add(new JLabel("Row:"));
    	cellPanel.add(rowField);
    	cellPanel.add(new JLabel("Column:"));
    	cellPanel.add(columnField);
    	JTextField keyField = new JTextField(5);
    	JTextField valueField = new JTextField(5);
    	JPanel keyPanel=new JPanel();
    	keyPanel.add(new JLabel("New Key:"));
    	keyPanel.add(keyField);
    	keyPanel.add(new JLabel("New Value:"));
    	keyPanel.add(valueField);
    	
    	do{
	    	result = JOptionPane.showConfirmDialog(null, cellPanel, "Enter Row and Column Reference", JOptionPane.OK_CANCEL_OPTION);
	    	if (result == PRESSED_OK) {
		    	tempRowIndex = rowField.getText();
		    	tempColumnIndex = columnField.getText();
	    	}
	    	else if (result != PRESSED_OK) {
    	        System.exit(0);
    	    }
	    	
    	} while (checkRowAndColumn(tempRowIndex, tempColumnIndex));
    	
    	
    	
    	do{
	    	result2 = JOptionPane.showConfirmDialog(null, keyPanel, "Enter Key and Value", JOptionPane.OK_CANCEL_OPTION);
	    	if (result2 == PRESSED_OK) {
		    	key = keyField.getText();
		    	value = valueField.getText();
		    	repeat = false;
	    	}
	    	else if (result2 != 0) {
    	        System.exit(0);
    	    }
	        
	        rowIndexFromUser = Integer.parseInt(tempRowIndex);
		    columnIndexFromUser = Integer.parseInt(tempColumnIndex);
	    	if (val.checkKey(key, rowIndexFromUser, columnIndexFromUser, table, column)){
	    	    repeat = true;
	    	}
	    	else if (val.checkValue(value)) {	
	    		repeat = true;
	    	}
	    } while (repeat);

        ascii.editCell(rowIndexFromUser, columnIndexFromUser, key, value);
    }
    
    static boolean checkRowAndColumn(String tempRowIndex, String tempColumnIndex) {
    	if (val.checkRow(tempRowIndex, table) || val.checkColumn(tempColumnIndex, column)) {	
    		return true;
    	}
    	return false;
    }
    
    static void inputForSearchTable(){
        String searchValue = "";
        boolean repeat;
        do{
            repeat = false;
	    	searchValue = JOptionPane.showInputDialog(null, "Type one to three ASCII characters to search:", "Enter Character/s");
	    	try {
            	if (val.checkSearchValue(searchValue) == true) {	
            		repeat = true;
                }
            }
            catch (NullPointerException e) {
                System.exit(0);
            }
	    } while (repeat);
        ascii.searchTable(searchValue);
    }
    
    static void inputForAddRow(){
        boolean repeat =  false;
    	String tempRowNumber = "";
    	do{
	    	tempRowNumber = JOptionPane.showInputDialog(null, "Input number of rows to add:");
	    	try {
            	if (val.checkRowNumber(tempRowNumber) == true) {	
            		repeat = true;
            	}
            	else {
            		repeat = false;
            	}
            }
            catch (NullPointerException e) {
                System.exit(0);
            }
            
	    } while (repeat);
	    int rowNumber = Integer.parseInt(tempRowNumber);
	    ascii.addRow(rowNumber);
    }
}
