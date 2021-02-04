package test.crypto;

import java.security.SecureRandom;

final class RandoBytes {

	public static void main(String[] a)
	throws Exception {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] b = new byte[255];
		sr.nextBytes(b);

		for(int i = 0; i < b.length; i++){
			System.out.print( Integer.toString( (b[i] & 0xff) + 0x100, 16).substring(1) );
		}

		System.out.println();
	}

}

