package kst.mesko.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class SendingService extends Service {

	private boolean _threadCanRun = true;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		// Notify of service start
		Toast.makeText(getApplicationContext(), "Sending starts", Toast.LENGTH_SHORT).show();
		
		// Setup thread bool
		set_threadCanRun(true);
		
		// Create thread
		Thread theSender = new Thread(){
			public void run(){				
				
				while (is_threadCanRun()){
					//create new intent
					Intent intent = new Intent(RecievingService.messageLabel);
					//put in some data
					intent.putExtra("message", "the value");		
					//send the intent
					sendBroadcast(intent);
					//try to make thread sleep
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
				
					}
				}
			}
		};		
		//start thread threading
		theSender.start();
		
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		set_threadCanRun(false);
		Toast.makeText(getApplicationContext(), "Sending ends", Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean is_threadCanRun() {
		return _threadCanRun;
	}

	private void set_threadCanRun(boolean _threadCanRun) {
		this._threadCanRun = _threadCanRun;
	}

}
