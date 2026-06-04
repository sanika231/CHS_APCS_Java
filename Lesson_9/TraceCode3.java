import java.util.ArrayList;

public class TraceCode3 {

	public static void main(String[] args) {


		// Once you have a specific test case in mind to debug,
		// uncomment the next line and change the parameters to match
		// the test case you want to debug.  Then use println statements
		// or BlueJ's debugger to run the code line by line.
		// System.out.println(removeString(param1, param2));

		ArrayList<TestCase> arr = new ArrayList<TestCase>();
		arr.add(new TestCase("Hello there", "llo", "He there"));
		arr.add(new TestCase("Hello there", "e", "Hllo thr"));
		arr.add(new TestCase("Hello there", "x", "Hello there"));
		arr.add(new TestCase("This is a FISH", "IS", "Th  a FH"));
		arr.add(new TestCase("THIS is a FISH", "is", "TH  a FH"));
		arr.add(new TestCase("THIS is a FISH", "iS", "TH  a FH"));
		arr.add(new TestCase("abxxxxab", "xx", "abab"));
		arr.add(new TestCase("abxxxab", "xx", "abxab"));
		arr.add(new TestCase("abxxxab", "x", "abab"));
		arr.add(new TestCase("xxx", "x", ""));
		arr.add(new TestCase("xxx", "xx", "x"));
		arr.add(new TestCase("xyzzy", "Y", "xzz"));
		arr.add(new TestCase("", "x", ""));
		arr.add(new TestCase("abcabc", "b", "acac"));
		arr.add(new TestCase("AA22bb", "2", "AAbb"));
		arr.add(new TestCase("1111", "1", ""));
		arr.add(new TestCase("1111", "11", ""));
		arr.add(new TestCase("MkjtMkx", "Mk", "jtx"));
		arr.add(new TestCase("Hi HoHo", "Ho", "Hi "));

		for (int i = 0; i < arr.size(); i++) {
			TestCase t = arr.get(i);
			String result = removeString(t.getParam1(), t.getParam2());
			if (result.equals(t.getCorrectAnswer())) {
				System.out.println("Test " + (i+1) + " passed!");
			}
			else {
				System.out.println("Test " + (i+1) + " failed!");
				System.out.println("Your code returned:   " + result);
				System.out.println("Should have returned: " +
							 t.getCorrectAnswer());
				System.exit(0);
			}
		}
	}

	public static String removeString(String str, String a) {
		String output = "";
		int i = 0;
		while (i < str.length() - a.length()) {
			if (!str.substring(i, i + a.length()).equalsIgnoreCase(a)) {
				output = output + str.substring(i, i + 1);
			} else {
				i = i + a.length();
			}
			i++;
		}
		return output;
	}
}

class TestCase {

	private String param1;
	private String param2;
	private String correctAnswer;
	
	public TestCase(String param1, String param2, String correctAnswer) {
		this.param1 = param1;
		this.param2 = param2;
		this.correctAnswer = correctAnswer;
	}
	
	public String getParam1() {
		return param1;
	}

	public String getParam2() {
		return param2;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}	
}