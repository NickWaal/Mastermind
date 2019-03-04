import java.util.Random;

public class codeGenerator {
	String code = "";

	codeGenerator() {
		for (int i = 0; i < 4; i++) {
			Random rdm = new Random();
			char c = (char) (rdm.nextInt(6) + 'a');
			code += c;
		}
		//System.out.println(code);
	}
}