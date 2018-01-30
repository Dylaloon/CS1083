import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void testMessageEncrypterP() {
		String input = "encrypt";
		MessageEncrypter t = new MessageEncrypter(input, false);
		System.out.println(t.decrypt());
		System.out.println(t.decrypt());
		
	}

	@Test
	public void testMessageEncrypterB() {
		String input = "encrypt";
		MessageEncrypter t = new MessageEncrypter(input, false);
		String encrypted = t.toString();
		t.decrypt();
		assertTrue(t.toString().equals(encrypted));
	}
	
	@Test
	public void testMessageEncrypterC() {
		String input = "encrypt";
		MessageEncrypter t = new MessageEncrypter(input, false);
		assertTrue(t.decrypt().equals(t.decrypt()));
	}
	
	
	@Test
	public void testMessageEncrypterA() {
		String input = "{}";
		String expectedOutput = "  ";
		MessageEncrypter t = new MessageEncrypter(input, false);
		assertTrue("Encrypt '" + input + "' : Expected Output '" + expectedOutput + "' Incorrect output: '" + t.toString() + "'", t.toString().equals(expectedOutput));
		System.out.println(t.toString());
	}
	
	@Test
	public void testMessageEncrypter1() {
		
		String input = "Hello {World!}?";
		String expectedOutput = "Idmkp  Uqpnb  A";
		MessageEncrypter t = new MessageEncrypter(input, false);
		assertTrue("Encrypt '" + input + "' : Expected Output '" + expectedOutput + "' Incorrect output: '" + t.toString() + "'", t.toString().equals(expectedOutput));
		System.out.println(t.toString());
	}
	
	@Test
	public void testMessageEncrypter2() {
		String input = "Idmkp  Uqpnb  A";
		String expectedOutput = "Hello  World  ?";
		MessageEncrypter t = new MessageEncrypter(input, true);
		assertTrue("Encrypt '" + input + "' : Expected Output '" + expectedOutput + "' Incorrect output: '" + t.decrypt() + "'", t.decrypt().equals(expectedOutput));
		System.out.println(t.decrypt());
	}
	
	@Test
	public void testMessageEncrypter3() {
		MessageEncrypter t = new MessageEncrypter("ABCDEF", false);
		assertTrue(t.toString().equals("BADBGD"));
		System.out.println(t.toString());
	}

	@Test
	public void testMessageEncrypter5() {
		String input = "BADBGD";
		String expectedOutput = "ABCDEF";
		MessageEncrypter t = new MessageEncrypter(input, true);
		assertTrue("Encrypt '" + input + "' : Expected Output '" + expectedOutput + "' Incorrect output: '" + t.decrypt() + "'", t.decrypt().equals(expectedOutput));
		System.out.println(t.decrypt());
	}
	
	@Test
	public void testMessageEncrypter6() {
		MessageEncrypter t = new MessageEncrypter("Java is (super) great...right?", false);
		assertTrue(t.toString().equals("K`w` ht )rvofq* ipg_v,0,tgifv="));
		System.out.println(t.toString());
	}

	@Test
	public void testMessageEncrypter7() {
		
		String input = "K`w` ht )rvofq* ipg_v,0,tgifv=";
		String expectedOutput = "Java is (super) great...right?";
		MessageEncrypter t = new MessageEncrypter(input, true);
		assertTrue("Encrypt '" + input + "' : Expected Output '" + expectedOutput + "' Incorrect output: '" + t.decrypt() + "'", t.decrypt().equals(expectedOutput));
		System.out.println(t.decrypt());
	}
	
	@Test
	public void testMessageEncrypter8() {
		MessageEncrypter t = new MessageEncrypter("abcd ef", false);
		assertTrue(t.toString().equals("badb ch"));
		System.out.println(t.toString());
	}
	
	@Test
	public void testMessageEncrypter9() {
		String input = "badb ch";
		String expectedOutput = "abcd ef";
		MessageEncrypter t = new MessageEncrypter(input, true);
		assertTrue("Encrypt '" + input + "' : Expected Output '" + expectedOutput + "' Incorrect output: '" + t.decrypt() + "'", t.decrypt().equals(expectedOutput));
		System.out.println(t.decrypt());
	}
}
