package com.ervein.service;
import javax.swing.*;
import java.util.*;
import java.io.*;
import org.apache.commons.lang3.StringUtils;

public class AsciiUtility{
    public int countAppearance(String compare, String searchValue) {
        int compareLength = compare.length();
        int searchLength = searchValue.length();
        int cellAppearance = 0;
    	for (int a = 0; a < compareLength; a++) {
    	    if (searchLength > compareLength) {
    	        break;
    	    }
            String compareChar = compare.substring(a, searchLength);
            if (StringUtils.equals(searchValue, compareChar)) {
	            cellAppearance = cellAppearance + 1;
            }
            searchLength++;
        }
        return cellAppearance;
    }
    
    public List<Set<String>> createTempRow (List<Map<String, String>> row) {
        List<Set<String>> tempRow = new ArrayList<Set<String>>();
        Set<String> tempSet;
        for (int rowIndex = 0; rowIndex < row.size(); rowIndex++) {
            Map<String, String> currentMap = row.get(rowIndex);
            tempSet = new TreeSet<String>();
            for (Map.Entry<String, String> map : currentMap.entrySet()) {
                String keyAndValue = map.getKey() + map.getValue();
                tempSet.add(keyAndValue);
            }
            tempRow.add(tempSet);
        }
        
        return tempRow;
    }
    
    public int displayAppearance (String type, int incrementType, String searchValue, int rowIndex, int columnIndex, int times) {
        System.out.println("Character "+searchValue+" appeared " + times + "X in cell "+(rowIndex+1)+"-"+columnIndex + " [" + type + "]");
		incrementType = incrementType + 1;
		return incrementType;
    }
}


