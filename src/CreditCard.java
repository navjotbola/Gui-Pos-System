public class CreditCard {

	public String creditCardNumber;

	public CreditCard(String number) {
		assignCardNumber(number);
	}

	void assignCardNumber(String number) {
		creditCardNumber = number;
	}

	boolean verifyCreditCard() {
		int length = creditCardNumber.length();
		if (length <= 19) {
			return true;
		}
		return false;
	}
}
