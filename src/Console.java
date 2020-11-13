import java.io.BufferedReader;
import java.io.InputStreamReader;

class Console {
	private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

	public String inString() {
		String input = null;
		try {
			input = b.readLine();
		} catch (Exception e) {
			this.exit();
		}
		return input;
	}

	public int inInt() {
		int input = 0;
		try {
			input = Integer.parseInt(this.inString());
		} catch (Exception e) {
			this.exit();
		}
		return input;
	}

	public void out(String output) {
		System.out.print(output);
	}

	public void outln(String output) {
		System.out.println(output);
	}

	private void exit() {
		System.out.println("ERROR I/O");
		System.exit(0);
	}
}