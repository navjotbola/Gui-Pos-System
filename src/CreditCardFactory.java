public class CreditCardFactory {
	AmExCC amex;
	MasterCC master;
	VisaCC visa;
	DiscoverCC discover;
	String ccNumber;
	String ccName = null;

	public CreditCardFactory(String stringCC) {
		ccNumber = stringCC;
		amex = new AmExCC(stringCC);
		master = new MasterCC(stringCC);
		visa = new VisaCC(stringCC);
		discover = new DiscoverCC(stringCC);
	}

	public boolean verifyCC() {
		boolean checker = false;
		if (ccNumber.length() <= 19) {
			if (amex.verifyCreditCard(ccNumber) == true) {
				ccName = "Amex";
				checker = true;
			} else if (master.verifyCreditCard(ccNumber) == true) {
				ccName = "Master";
				checker = true;
			} else if (visa.verifyCreditCard(ccNumber) == true) {
				ccName = "Visa";
				checker = true;
			} else if (discover.verifyCreditCard(ccNumber) == true) {
				ccName = "Discover";
				checker = true;
			}
		}
		return checker;
	}
}
