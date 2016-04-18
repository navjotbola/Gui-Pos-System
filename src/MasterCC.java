public class MasterCC extends CreditCard {

	public MasterCC(String number) {
		super(number);
		assignCardNumber(number);
	}

	void assignCardNumber(String number) {
		creditCardNumber = number;
	}

	boolean verifyCreditCard(String ccNumber) {
		int length = ccNumber.length();
		if (length == 16) {
			//System.out.println("mastercheck");
			String firstDigit = ccNumber.substring(0, 1);
			String secondDigit = ccNumber.substring(1, 2);

			if (firstDigit.equals("5")) {
				if (secondDigit.compareTo("1") >= 0
						&& secondDigit.compareTo("5") <= 0) {
					return true;
				}
			}
		}

		return false;
	}
}
