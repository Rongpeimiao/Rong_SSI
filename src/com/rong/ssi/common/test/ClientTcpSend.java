package com.rong.ssi.common.test;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpSend {

    public static void main(String[] args) {
    	
    	
    	ClientTcpSend.synchronous("144.214.54.122","D:\\recovery1\\");
    }

    
    public static boolean synchronous(String ip, String ph) {
    	
    	 int length = 0;
         byte[] sendByte = null;
         Socket socket = null;
         DataOutputStream dout = null;
         FileInputStream fin = null;
         try {
        	 
        	 File file = new File(ph);//"D:\\recovery1\\"
        	 File[] files = file.listFiles();
        	 //
        	 for(File a:files){
		           try {
		             socket = new Socket();
		             socket.connect(new InetSocketAddress(ip, 33456),10 * 1000);//"192.168.1.117"
		             dout = new DataOutputStream(socket.getOutputStream());
		            	 fin = new FileInputStream(a);
		                 sendByte = new byte[1024];
		                 dout.writeUTF(a.getName());
		                 while((length = fin.read(sendByte, 0, sendByte.length))>0){
		                     dout.write(sendByte,0,length);
		                     dout.flush();
		                 }
		                 System.out.println("发�?�成功！");
		         	  
		            
		             
		             
		             } catch (Exception e) {
		
		             } finally{
		                 if (dout != null)
		                     dout.close();
		                 if (fin != null)
		                     fin.close();
		                 if (socket != null)
		                     socket.close();
		         }
        	 }
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
    	
		return true;
	}
    
   /* public  files showDirectoryptNUM(File file){
        File[] files = file.listFiles();
        String getAbsolutePath="/disk1/atispt/2222/acc+/333.jsp";//a.getAbsolutePath()
    	 boolean frag=true;
    	 if(null!=files){
    	    for(File a:files){
    	   	getAbsolutePath=a.getAbsolutePath();
    	       if(a.isDirectory()){
    	    	   showDirectoryptNUM(a);
    	       }
    	   }
    	 }
    	 return 
     }*/
}