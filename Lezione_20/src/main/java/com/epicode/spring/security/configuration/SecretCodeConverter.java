package com.epicode.spring.security.configuration;

import jakarta.persistence.AttributeConverter;

public class SecretCodeConverter implements AttributeConverter<String, String>{
	
	Character[] arrChar = {'&', '?', '1', '3', '£', '$', 'G', '^', '%', '7'};

	@Override
	public String convertToDatabaseColumn(String attribute) {
		
		String code = "";
		
		if(attribute == null) {
			return code;
		}
		
		for(Character c : attribute.toCharArray()) {
			int index = Integer.parseInt(c.toString());
			code += arrChar[index];
		}
		return code;
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		
//		String code = "";
//		
//		if(dbData == null) {
//			return code;
//		}
//		
//		for (Character c : dbData.toCharArray()) {
//			
//			for ( int i = 0; i < arrChar.length; i++) {
//				if(arrChar[i].equals(c)) {
//					code += i;
//				}
//			}
//		}
//		return code;
		return dbData; // se per qualche motivo voglio tornare il codice ma ancora cifrato
	}

}
