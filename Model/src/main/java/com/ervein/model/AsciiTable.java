package com.ervein.model;
import java.util.List;
import java.util.Map;
import java.io.*;   
                 
public class AsciiTable{
    private List<Map<String, String>> table;
    private Map<String, String> column;
    BufferedReader in;
    
    public void setTable(List<Map<String, String>> table) {
        this.table = table;
    }
    
    public void setColumn(Map<String, String> column) {
        this.column = column;
    }
    
    public List<Map<String, String>> getTable() {
        return table;   
    }
    
    public Map<String, String> getColumn() {
        return column;   
    }
}
