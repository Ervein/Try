package com.ervein.service;
import com.ervein.model.AsciiTable;
import com.ervein.service.AsciiUtility;
import com.ervein.service.TableService;
import javax.swing.*;
import java.util.*;
import java.io.*;
import org.apache.commons.lang3.StringUtils;

public class AsciiService implements TableService{
    public static List<Map<String, String>> table;
    public static Map<String, String> column;
    static BufferedReader in;
    static BufferedWriter writer;
    private final int MIN = 32;
    private final int MAX = 126;
    static AsciiTable asciiTable = new AsciiTable();
    AsciiUtility utility = new AsciiUtility();
    static String filePath = "";
    
    public void setTable() {
        List<Map<String, String>> row = new ArrayList<Map<String, String>>();
        Map<String, String> col = new LinkedHashMap<String, String>();
        try {
            //String home = System.getProperty("user.home");
            in = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = in.readLine()) != null) {
                String parts[] = line.split("¦¦");
                col = new LinkedHashMap<String, String>();
                for (int a = 0; a < parts.length; a++) {
                    String value[] = parts[a].split("—");
                    col.put(value[0], value[1]);
                }
                row.add(col);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Text file does not match", "Incompatible", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException e) {
            }
        }
        asciiTable.setTable(row);
        asciiTable.setColumn(col);
        
        table = asciiTable.getTable();
        column = asciiTable.getColumn();
    }
    
    public void resetTable() {
        table = new ArrayList<Map<String, String>>();
        Random random = new Random();
        int rowNumber = 0;
        int columnNumber = 0;
        boolean rowError = false;
        boolean columnError = false;
        do{
            try{
                rowError = false;
                rowNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of row/s: ", "Enter Row"));
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid row number!");
                rowError = true;
                rowNumber = 1;
            }
            if (rowNumber == 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid row number!");
                rowError = true;
            }
        } while (rowError);
		
        do{
            try {
                columnError=false;
                columnNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of column/s: ", "Enter Column"));
            }
            catch (NumberFormatException f) {
                JOptionPane.showMessageDialog(null, "Please enter a valid column number!");
                columnError=true;
                columnNumber=1;
            }
            if (columnNumber==0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid column number!");
                columnError=true;
            }
        } while (columnError);
        
        String key;
        String value;
        char tempChar;
        int randomChar;
        
        for (int rowln = 1; rowln <= rowNumber; rowln++) {
            column = new LinkedHashMap<String, String>();
	        for (int columnln = 1; columnln <= columnNumber; columnln++) {
	            //generate key
	            key = "";
		        for (int a = 1; a <= 3; a++) {
			        randomChar = random.nextInt(MAX - MIN + 1) + MIN;
			        if (a == 1) {
				        tempChar = (char) randomChar;
				        key = String.valueOf(tempChar);
			        }
			        else {
				        key += (char) randomChar;
			        }
		        }
		        
		        //generate value
	            value = "";
		        for (int a = 1; a <= 3; a++) {
			        randomChar = random.nextInt(MAX - MIN + 1) + MIN;
			        if (a == 1) {
				        tempChar = (char) randomChar;
				        value = String.valueOf(tempChar);
			        }
			        else {
				        value += (char) randomChar;
			        }
		        }
		        column.put(key, value);
	        }
	        table.add(column);
        }
        
        System.out.println("NEW TABLE:");
        writeFile(table);
        setTable();
        displayTable();
    }
    
    static void writeFile(List<Map<String, String>> table) {
        try{
            String line = "";
            //String home = System.getProperty("user.home");
            writer = new BufferedWriter (new FileWriter(filePath));
            Map<String, String> currentMap;
            for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
                currentMap = table.get(rowIndex);
                int columnIndex = 0;
                for (Map.Entry<String, String> map : currentMap.entrySet()) {
                    if (columnIndex < (currentMap.size()-1)) {
                        line = (map.getKey() + "—" + map.getValue() + "¦¦");
                    }
                    else {
                        line = (map.getKey() + "—" + map.getValue());
                    }
                    writer.write(line);
                    columnIndex++;
                }
                writer.write("\n");
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                writer.close();
            } 
            catch (Exception ex) {
            }
        }
    }
    
    public void displayTable() {
        this.filePath = filePath;
        setTable();
        String tempNumberOfRowDigits = new Integer(table.size()).toString();
        String tempNumberOfRowDigits2;
        int NumberOfRowDigits2;
        for (int NumberOfRowDigits = tempNumberOfRowDigits.length(); NumberOfRowDigits > 1; NumberOfRowDigits--) {
            System.out.print(" ");
        }
        for (int colNumber = 1; colNumber <= column.size(); colNumber++) {
            if (colNumber == 1) {
                System.out.print("       "+colNumber);
                colNumber++;
            }
            System.out.print("         "+colNumber);
        }
        
        System.out.print("\n\n");
        
        Map<String, String> currentMap;
        for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
            tempNumberOfRowDigits2 = new Integer(rowIndex+1).toString();
            NumberOfRowDigits2 = tempNumberOfRowDigits2.length();
            for (int NumberOfRowDigits = tempNumberOfRowDigits.length(); NumberOfRowDigits>0; NumberOfRowDigits--) {
                if (NumberOfRowDigits2 < NumberOfRowDigits) {
                    System.out.print(" ");
                }
            }
            System.out.print(rowIndex+1);
            
            currentMap = table.get(rowIndex);
            for (Map.Entry<String, String> map : currentMap.entrySet())
            {
                System.out.print("   " + map.getKey() + "—" + map.getValue());
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void editCell(int rowIndexFromUser, int columnIndexFromUser, String key, String value) {
        Map<String, String> currentMap;
        String originalMapKey = "";
	    String originalMapValue = "";
	    Map<String, String> newMap;
    	for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
    	    if (rowIndex == (rowIndexFromUser-1)) {
                currentMap = table.get(rowIndex);
                int columnIndex = 1;
                newMap = new LinkedHashMap<String, String>();
                for (Map.Entry<String, String> map : currentMap.entrySet()) {
                    if (columnIndex == (columnIndexFromUser)) {
                        originalMapKey = map.getKey();
                        originalMapValue = map.getValue();
                        newMap.put(key, value);
                    }
                    else {
                        newMap.put(map.getKey(), map.getValue());
                    }
                    table.set(rowIndex, newMap);
                    columnIndex++;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Key is modified from " + originalMapKey + " to " + key + 
            " while its Value is modified from " + originalMapValue + " to " + value);
        System.out.println("New TABLE:");
        writeFile(table);
        setTable();
        displayTable();
    }
    
    public void searchTable(String searchValue) {
        int tableAppearance = 0;
        int cellKeys = 0;
        int cellValues = 0;
	    Map<String, String> currentMap;
        String compareKey = "";
	    String compareValue = "";
	    int keyCellAppearance = 0;
	    int valueCellAppearance = 0;
	    System.out.println("SEARCH RESULT:");
	    
    	for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
            currentMap=table.get(rowIndex);
            int columnIndex = 1;
            
            for (Map.Entry<String, String> map : currentMap.entrySet()) {
                compareKey = map.getKey();
                compareValue = map.getValue();

                keyCellAppearance = utility.countAppearance(compareKey, searchValue);
                valueCellAppearance = utility.countAppearance(compareValue, searchValue);
                if (keyCellAppearance > 0) {
                    cellKeys = utility.displayAppearance("KEY", cellKeys, searchValue, rowIndex, columnIndex, keyCellAppearance);
                    tableAppearance = tableAppearance + 1;
				}
				if (valueCellAppearance > 0) {
                    cellKeys = utility.displayAppearance("VALUE", cellKeys, searchValue, rowIndex, columnIndex, valueCellAppearance);
                    tableAppearance = tableAppearance + 1;
				}
                columnIndex++;
            }
        }
        
		if (tableAppearance > 0) {
			System.out.println("SUMMARY: Character/s "+searchValue+" appeared in the table "+tableAppearance+"X." );
			System.out.println("       : from "+cellKeys+" different KEY/S" );
			System.out.println("       : and from "+cellValues+" different VALUE/S" );
		}
		else {
			System.out.println("Character/s "+searchValue+" didn't appear in any cell of the table.");
		}
		System.out.println("\n");
    }
    
    public void addRow(int rowNumber) {
	    Map<String, String> currentMap;
	    Map<String, String> newMap;
	    int currentRowIndex = 0;
	    int currentColumnIndex = 0;
	    
	    System.out.println("");
	    
    	for (int rowIndex = 0; rowIndex < rowNumber; rowIndex++) {
            newMap = new LinkedHashMap<String, String>();
            for (int columnIndex = 0; columnIndex < column.size(); columnIndex++) {
                if (columnIndex == 0) {
                    currentRowIndex = rowIndex + table.size() + 1;
                }
                else {
            	    currentRowIndex = rowIndex + table.size();
            	}
	    		currentColumnIndex = columnIndex + 1;
                String[] keyAndValue = generateKeyAndValue(currentRowIndex, currentColumnIndex);
                String key = keyAndValue[0];
                String value = keyAndValue[1];
                newMap.put(key, value);
                currentRowIndex = currentRowIndex - 1;
                if (columnIndex == 0) {
                    table.add(currentRowIndex, newMap);
                }
                else {
                    table.set(currentRowIndex, newMap);
                }
            }
            
        }
        System.out.println("WITH " + rowNumber + " NEWLY ADDED ROW/S");
        writeFile(table);
        setTable();
        displayTable();
    }
    
    String[] generateKeyAndValue(int currentRow, int currentColumn) {
    	String key = "";
    	String value = "";
		int result;
		boolean repeat = false;
    	JTextField keyField = new JTextField(5);
    	JTextField valueField = new JTextField(5);
    	JPanel keyPanel = new JPanel();
    	keyPanel.add(new JLabel("Enter Key:"));
    	keyPanel.add(keyField);
    	keyPanel.add(new JLabel("Enter Value:"));
    	keyPanel.add(valueField);
    	do{
    		String tempCurrentRow = Integer.toString(currentRow);
    		String tempCurrentColumn = Integer.toString(currentColumn);
    		String message="Enter Key and Value for cell: " + tempCurrentRow + "-" + tempCurrentColumn;
	    	result = JOptionPane.showConfirmDialog(null, keyPanel, message, JOptionPane.OK_CANCEL_OPTION);
	    	if (result == 0) {
                key = keyField.getText();
                value = valueField.getText();
                repeat = false;
	    	}
	    	else {
	    		break;
	    	}
	    		    
	    	if (checkKey(key, currentRow, currentColumn, table, column)  == true) {	
	    		repeat = true;
	    	}
	    	
	    	if (checkValue(value) == true) {
	    		repeat = true;
	    	}
	    } while (repeat);
		
	    if (result != 0) {
    	    System.exit(0);
    	}
    	String[] keyAndValue = {key, value};
    	return keyAndValue;
    }
    
    public void sortRows() {
        List<Set<String>> tempRow = new ArrayList<Set<String>>();
        Map<String, String> currentMap;
	    Map<String, String> newMap;
        Set<String> tempSet;
	    String[] options = {"Sort by Ascending", "Sort by Descending"};
	    
        String sortAction = (String) JOptionPane.showInputDialog(null, "Choose type of Sort:", "OPTIONS",
            JOptionPane.PLAIN_MESSAGE, null, options, "Sort table");
        if (sortAction == "Sort by Ascending") {
            tempRow = utility.createTempRow(table);
	        
        	for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
                tempSet = tempRow.get(rowIndex);
                newMap = new TreeMap<String, String>();
                for (String keyAndValue : tempSet) {
                    String key = keyAndValue.substring(0, 3);
                    String value = keyAndValue.substring(3, 6);
                    newMap.put(key, value);
                }
                table.set(rowIndex, newMap);
            }
        }
        else if (sortAction == "Sort by Descending") {
	        tempRow = utility.createTempRow(table);
	        
	        for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
                List<String> tempList = new ArrayList<>(tempRow.get(rowIndex));
                newMap = new LinkedHashMap<String, String>();
                for (int setIndex = (tempList.size()-1); setIndex >= 0; setIndex--) {
                    String keyAndValue = tempList.get(setIndex);
                    String key = keyAndValue.substring(0, 3);
                    String value = keyAndValue.substring(3, 6);
                    newMap.put(key, value);
                }
                table.set(rowIndex, newMap);
            }
	    }
	    else {
            JOptionPane.showMessageDialog(null, "No action chosen. \nProgram terminates now.", "Exit Program", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        
        
        System.out.println("SORTED ROW/S:");
        writeFile(table);
        setTable();
        displayTable();
    }
    
    public static List<Map<String, String>> getRow() {
            return table;
    }
    
    public static Map<String, String> getColumn() {
            return column;
    }
    
    boolean checkKey(String key, int rowIndexFromUser, int columnIndexFromUser, List<Map<String, String>> table, Map<String, String> column) {
        //List<Map<String, String>> row = ascii.getRow();
        //Map<String, String> column = ascii.getColumn();
        if (key.length() != 3) {
	        JOptionPane.showMessageDialog(null,"Invalid number of KEY characters!");
	        return true;
	    }
	    
	    for (int a = 0; a < key.length(); a++) {
	        char[] checkCharacter = key.toCharArray();
	        int checkCharacterInt = (int)checkCharacter[a];
	        if (checkCharacterInt<MIN || checkCharacterInt>MAX) {
	            JOptionPane.showMessageDialog(null,"Invalid Key Character/s!");
	            return true;
	        }
	    }
	    
	    Map<String, String> newMap = new LinkedHashMap<>();
	    Map<String, String> currentMap;
	    String currentMapKey = "";
	    String currentMapValue = "";
        for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
            currentMap = table.get(rowIndex);
            int columnIndex = 1;
            for (Map.Entry<String, String> map : currentMap.entrySet()) {
                currentMapKey = (String) map.getKey();
                currentMapValue = (rowIndex) + "," + columnIndex;
                newMap.put(currentMapValue, currentMapKey);
                columnIndex++;
            }
        }

        for (Map.Entry<String, String> map : newMap.entrySet()) {
            currentMapKey = (String) map.getKey();
            currentMapValue = (String) map.getValue();
            if (key.equals(currentMapValue)) {
                String parts[] = currentMapKey.split(",");
                String strRowIndex = Integer.toString(rowIndexFromUser-1);
                String strColumnIndex = Integer.toString(columnIndexFromUser);
                if (strRowIndex.equals(parts[0])) {
                    if (strColumnIndex.equals(parts[1])) {
                        //retain key in same cell reference
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Key already exists!");
                        return true;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Key already exists!");
                    return true;
                }
            }
        }

        return false;
    }
    
    boolean checkValue(String value) {
        if (value.length() != 3) {
	        JOptionPane.showMessageDialog(null,"Invalid number of VALUE characters!");
	        return true;
	    }
        
        for (int a = 0; a < value.length(); a++) {
	        char[] checkCharacter = value.toCharArray();
	        int checkCharacterInt = (int) checkCharacter[a];
	        if (checkCharacterInt < MIN || checkCharacterInt > MAX) {
	            JOptionPane.showMessageDialog(null,"Invalid Value Character/s!");
	            return true;
	        }
	    }
        return false;
    }
    
    public void setFilePath (String filePath) {
        this.filePath = filePath;
    }
}

