package com.alexastudillo.validate;

import com.alexastudillo.enumeration.Country;

public class IdentityDocument {

	public IdentityDocument() {
	}

	private boolean isEcuadorianDocumentValid(String document) {
		try {
			if (document.trim().length() != 10)
				return false;
			String[] data = document.split("");
			byte verifier = Byte.parseByte(data[0] + data[1]);
			if (verifier < 1 || verifier > 24)
				return false;
			byte[] digits = new byte[data.length];
			for (byte i = 0; i < digits.length; i++)
				digits[i] = Byte.parseByte(data[i]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isValid(String document, Country country) {
		switch (country) {
		case ECUADOR:
			return isEcuadorianDocumentValid(document);
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
