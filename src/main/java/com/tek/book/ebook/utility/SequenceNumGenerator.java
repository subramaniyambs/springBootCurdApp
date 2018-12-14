/**
 * 
 */
package com.tek.book.ebook.utility;

/**
 * @author Vinoth
 *
 */

public enum SequenceNumGenerator {
	
	/**
	 * For Oracle 
	 */
	
	
	RFI_NUMBER_EARTHWORK("RFI Number for Earthwork", "RAIL_RFI_GENERATION_EARTHWORK","RFI_NUMBER_RFITYPE",5,"" ), //RVNL MDUTN/YEAR/000001
	RFI_NUMBER_PWAY("RFI Number for PWay", "RAIL_PWAY_DETAILS","RFI_NUMBER_RFITYPE",5,"" ); //RVNL MDUTN/YEAR/000001
	
	
		private String propertyName;
    	private String tableName;
    	private int numberOfZeroPrefix;
    	private String prefix;
    	private String fieldName;
       	
    	private SequenceNumGenerator(String propertyName,String tableName, String fieldName,  int numberOfZeroPrefix, String prefix){
    		this.propertyName = propertyName;
    		this.tableName = tableName;
    		this.numberOfZeroPrefix = numberOfZeroPrefix;
    		this.prefix = prefix;
    		this.fieldName = fieldName;
    	}
    	
public String getQuery(String whereClause,int startPosition){
    	StringBuffer sb = new StringBuffer("Select ");
    	sb.append(" ( coalesce( max( to_number (substr( ");
    	sb.append(fieldName);
    	sb.append(",");
    	sb.append(startPosition);
    	sb.append("),'0000000')), 0 ) +1  ) as NEXT_SEQ from ");
    	sb.append(tableName);
    	if(null != whereClause){
    		sb.append(" where " + whereClause);
    	}
    	return sb.toString();
    }

public String getNextSeqNumber(String number,String optionalPrefix){
	String optPrefix = (optionalPrefix==null ? "" : optionalPrefix);
	return  optPrefix + prefix + addPrefix(number);
}



private String addPrefix(String number){
	
	if(number.length() < numberOfZeroPrefix){
		number = "0" + number;
		return addPrefix(number);
	}
	return number;
}


private static String addPrefix(String number , int no){
	
	if(number.length() < no){
		number = "0" + number;
		return addPrefix(number,no);
	}
	return number;
}
 
}
