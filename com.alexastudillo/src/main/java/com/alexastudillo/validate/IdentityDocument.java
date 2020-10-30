package com.alexastudillo.validate;

import com.alexastudillo.enumeration.Country;

public class IdentityDocument {

	public IdentityDocument() {
	}

	private boolean isEcuadorianDocumentValid(String document) {
		byte sum = 0;
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
			if (digits[2] > 6)
				return false;
			for (byte i = 0; i < digits.length - 1; i++) {
				if (i % 2 == 0) {
					verifier = (byte) (digits[i] * 2);
					if (verifier > 9)
						verifier = (byte) (verifier - 9);
				} else
					verifier = (byte) (digits[i] * 1);
				sum = (byte) (sum + verifier);
			}
			if ((sum - (sum % 10) + 10 - sum) == digits[9])
				return true;
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
}