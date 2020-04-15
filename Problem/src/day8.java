import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class day8 {
	static class BlockChain{
		BlockChain preChain = null;
		BlockChain nextChain = null;
		BlockChain lastChain = null;
		
		BigInteger nonce;
		String data;
		String prevhash;
		String hash;
		
		void start(String data) throws NoSuchAlgorithmException {
			lastChain = this;
			nonce = BigInteger.ZERO;
			this.data = data;
			prevhash = "";
			hash = sha256(nonce.toString() + data + prevhash);
		}
		
		void addBlock(String data) throws NoSuchAlgorithmException {
			BlockChain bc = new BlockChain();
			bc.preChain = lastChain;
			bc.data = data;
			bc.prevhash = lastChain.prevhash;
			bc.nonce = BigInteger.ZERO;
			bc.nextChain = null;
			
			lastChain.nextChain = bc;
			lastChain = bc;
			
			bc.hash = sha256(bc.nonce.toString() + data + prevhash);
			long time = System.currentTimeMillis();
			while(true) {
				if(bc.hash.charAt(0) == '0' && bc.hash.charAt(1) == '0' &&
						bc.hash.charAt(2) == '0' && bc.hash.charAt(3) == '0' &&
						bc.hash.charAt(4) == '0' && bc.hash.charAt(5) == '0') break;
//				if(bc.hash.charAt(0) == '0' && bc.hash.charAt(1) == '0' &&
//						bc.hash.charAt(2) == '0' && bc.hash.charAt(3) == '0' ) break;
				
				
				bc.nonce = bc.nonce.add(BigInteger.TWO);
				//System.out.println(bc.nonce.toString());
				bc.hash = sha256(bc.nonce.toString() + data + prevhash);
				
			}
			System.out.println(bc.data + " time :" + (System.currentTimeMillis()-time)/1000.0);
			
		}
		
		void lookBlock() {
			System.out.println("nonce : " + nonce.toString());
			System.out.println("data : " + data);
			System.out.println("prevhash : " + prevhash);
			System.out.println("hash : " + hash);
			System.out.println();
			
			BlockChain next = nextChain;
			while(next != null) {
				System.out.println("nonce : " + next.nonce.toString());
				System.out.println("data : " + next.data);
				System.out.println("prevhash : " + next.prevhash);
				System.out.println("hash : " + next.hash);
				System.out.println();
				next = next.nextChain;
			}
		}
		
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		BlockChain bc = new BlockChain();
		bc.start("Genesis Block");
		
		bc.lookBlock();
		
		bc.addBlock("2nd");
		bc.addBlock("3rd");
		bc.addBlock("4th");
		bc.addBlock("5th");
		bc.lookBlock();
		
		


	}
	
	public static String sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(msg.getBytes());
	    
	    return bytesToHex1(md.digest());
	}
	public static String bytesToHex1(byte[] bytes) {
	    StringBuilder builder = new StringBuilder();
	    for (byte b: bytes) {
	      builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}
}
