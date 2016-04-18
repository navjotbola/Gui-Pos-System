public class VisaCC extends CreditCard {

	public VisaCC(String number) {
		super(number);
		assignCardNumber(number);
	}

	void assignCardNumber(String number) {
		creditCardNumber = number;
	}

	boolean verifyCreditCard(String ccNumber) {
		int length = ccNumber.length();
		if (length == 13 || length == 16) {
			String firstDigit = ccNumber.substring(0, 1);

			if (firstDigit.equals("4")) {
				return true;
			}
		}
		return false;
	}
}
