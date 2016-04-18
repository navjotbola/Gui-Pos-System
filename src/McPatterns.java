public class McPatterns {
	public static void main(String[] args) {
		String filename = args[0];
		McPatternsGUI gui = new McPatternsGUI(new McPatternsPresenter(filename));
	}
}