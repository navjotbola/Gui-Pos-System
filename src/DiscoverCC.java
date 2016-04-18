public class DiscoverCC extends CreditCard {

	public DiscoverCC(String number) {
		super(number);
		assignCardNumber(number);
	}

	void assignCardNumber(String number) {
		creditCardNumber = number;
	}

	boolean verifyCreditCard(String ccNumber) {
		int length = ccNumber.length();
		if (length == 16) {
			String firstDigit = ccNumber.substring(0, 1);
			String secondDigit = ccNumber.substring(1, 2);
			String thirdDigit = ccNumber.substring(2, 3);
			String fourthDigit = ccNumber.substring(3, 4);

			if (firstDigit.equals("6") && secondDigit.equals("0")
					&& thirdDigit.equals("1") && fourthDigit.equals("1")) {
				return true;
			}
		}
		return false;
	}
}
