package emailProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class Mailer{  
    public static void send(){  
 
    	String from="arshathameen505@gmail.com";
    	String password="Bismi786123";
    	System.out.println("Enter no. of email to send: ");
		Scanner scan=new Scanner(System.in);
		int i=scan.nextInt();
		System.out.println("Enter "+i+" mails....");
		List<String> list=new ArrayList<String>();
		for(int j=0;j<i;j++) {
			list.add(scan.next());
		}
    	scan.close();
    	
    	Iterator<String> iter=list.iterator();
    	while(iter.hasNext()) {
           
    		System.out.println("Preparing to send.....");
    		String User=iter.next();
			int index = User.indexOf('@');
			String UserName = User.substring(0, index);
			
			 //Get properties object 
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465"); 
          
          
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });  
          
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress (User)); 
           message.setSubject("Email Project"); 
           String msg= "Dear Mr, "+UserName+" \n\n \tGreetings to you.....\nWelcome to my GitHub Link:\n\t https://github.com/Ameen-Works\n\n\nThanks&Regards,\nArshath";

           message.setText(msg);

           //send message  
           Transport.send(message);  
           System.out.println("Mail Sent Successfully to: "+UserName);
       
          } catch (MessagingException e) {throw new RuntimeException(e);}    
    	} 
    	 
    } 
}  
public class SendMail{    
 public static void main(String[] args) {    
 
	 Mailer.send();  

 }    
}    