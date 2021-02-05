import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Cat extends Thread{
	private JProgressBar progressBar;
	private String path,to;
	private JLabel time;
	Cat(JProgressBar progressBar,JLabel time,String path,String to){
		this.progressBar=progressBar;
		this.path=path;
		this.to=to;
		this.time=time;
	}
	public void run() {
		InputStream inputStream=null;
		OutputStream outputStream=null;
		progressBar.setValue(0);
		try {
			File originalFile=new File(path);
			File newFile=new File(to);
			inputStream=new FileInputStream(originalFile);
			double size=inputStream.available();
			outputStream=new FileOutputStream(newFile);
			int sizeToBeComplete=0;
			long timeCurr=System.currentTimeMillis();
			int length;
			byte[] buffer=new byte[1024];
			while((length=inputStream.read(buffer))>0) {
				sizeToBeComplete+=length;
				long timeNow=System.currentTimeMillis();
				time.setText("Time : "+(((timeNow-timeCurr)/1000)/60)+" - "+(((timeNow-timeCurr)/1000))%60);
				progressBar.setValue((int)((sizeToBeComplete/size)*100));
				outputStream.write(buffer,0,length);
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,"Error Happened!");
		} finally {
			try {
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch(Exception fi) {
				
			}
		}
	}
}
