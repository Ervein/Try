package com.ervein.app;
import java.util.*;

interface Validation{
    public boolean checkRow(String string, List<Map<String, String>> list);
    public boolean checkRowNumber(String string);
}
