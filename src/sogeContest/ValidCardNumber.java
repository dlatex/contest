package sogeContest;

import static org.junit.Assert.*;


/**
 * In this challenge, you need to determine if a card number is valid. A card
 * number includes 16 digits: - The first 6 correspond to the issuing bank, - 9
 * digits are taken randomly, - the last digit is the Luhne key
 * 
 * The Luhne key is based on the first 15 digits. One digit out of two is
 * multiplied by 2 starting with the first one. If the result is greater than 9
 * then 9 is deduced from the result. This provides a new series of digits. The
 * Luhne key is the value that needs to be added to this sum to get a number
 * that can be divided by 10. Example: 5295 4648 5201 3672
 * 
 * 
 * 
 * By adding the Luhne Key (last digit of the card number), which is 2, to this
 * sum 68, you get the number 70, which is a multiple of 10. Therefore, this is
 * a valid card.
 * 
 * Data
 * 
 * Input Row 1 : an integer N between 1 and 1000 indicating the number of credit
 * card numbers in the file. Row 2 to N + 1 : a string of 16 digits representing
 * a credit card number.
 * 
 * Output An integer representing the number of valid credit cards numbers in
 * the input.
 * 
 * @author _DELEX
 *
 */
public class ValidCardNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assertEquals(true, validCardNumber("5295 4648 5201 3672"));
		assertEquals(true, validCardNumber("5295-4648-5201-3672"));
		assertEquals(false, validCardNumber("5295-8658-5701-3672"));
	}

	public static boolean validCardNumber(String s) {
		s = s.replaceAll(" ", "");
		s = s.replaceAll("\\W ", "");
		s = s.replaceAll("-", "");
		int somme = 0;
		int u = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (i % 2 == 0) {
				u = Integer.parseInt("" + s.charAt(i)) * 2;
				if (u > 9)
					u -= 9;
			} else {
				u = Integer.parseInt("" + s.charAt(i));
			}
			somme += u;
			u = 0;
		}
		return ((somme + Integer.parseInt("" + s.charAt(15))) % 10 != 0) ? false : true;
	}

}
