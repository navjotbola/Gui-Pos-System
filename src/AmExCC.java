public class AmExCC extends CreditCard {


	public AmExCC(String number) {
		super(number);
		assignCardNumber(number);
	}

	void assignCardNumber(String number) {
		creditCardNumber = number;
	}

	boolean verifyCreditCard(String ccNumber) {
		int length = ccNumber.length();
		if (length == 15) {
			String firstDigit = ccNumber.substring(0, 1);
			String secondDigit = ccNumber.substring(1, 2);

			if (firstDigit.equals("3")) {

				if (secondDigit.equals("4") || secondDigit.equals("7")) {
					return true;
				}
			}

		}
		return false;
	}
}
