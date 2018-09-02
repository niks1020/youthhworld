package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class GeneralCode {
	
	//RETURNS CELL STYLE WITH SPECIFIED BORDER STYLE APPLIED TO ALL FOUR SIDE OF CELL
	public static CellStyle getBorderedCellStyle(Workbook wb, BorderStyle bs) {
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setBorderTop(bs);
		cellStyle.setBorderBottom(bs);
		cellStyle.setBorderLeft(bs);
		cellStyle.setBorderRight(bs);
		return cellStyle;
	}
	
	//RETURN CELLSTYLE WITH SPECIFIED BORDER STYLE AND BACKGROUND FOREGROUND COLOR
	public static CellStyle getBorderedCellStyleWithBackground(Workbook wb, BorderStyle bs, short foreGround, FillPatternType fpt, short fontColor) {
		
		CellStyle cellStyle = getBorderedCellStyle(wb, bs);
		
		cellStyle.setFillForegroundColor(foreGround);
		cellStyle.setFillPattern(fpt);
		
		Font font = wb.createFont();
		font.setColor(fontColor);
		cellStyle.setFont(font);
		
		return cellStyle;
	}
	
	/*THIS METHOD SORTS THE HASHMAP VALUES BY VALUES AND RETURNS A SORTED HASHMAP
  //MAKE SURE TO PASS A LINKED HASHMAP REFERENCE VARIABLE AS ARGUMENT TO THIS METHOD ELSE IT WONT WORK
  */
  public static Map<String, Integer> sortHashMapByValues(Map<String, Integer> passedMap) {
	    List<String> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.reverse(mapValues);
	    Collections.sort(mapKeys);
	    Collections.reverse(mapKeys);

	    Map<String, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<String> keyIt = mapKeys.iterator();
	        System.out.println("ITERATION FOR VALUE : "+val);
	        while (keyIt.hasNext()) {
	            String key = keyIt.next();
	            Integer comp1 = passedMap.get(key);
	            Integer comp2 = val;
	            System.out.println("   .................ITERATION FOR KEY : "+key);
	            if (comp1 == comp2) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
}
