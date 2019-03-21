package kst.mesko.servicetest;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;


public class RecievingService extends Service {

	public static String messageLabel = "kst.mesko.servicetest.count";
	
	private int _count = 0;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	private BroadcastReceiver _reciever;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "Recieving starts", Toast.LENGTH_SHORT).show();

		// create reciever
		_reciever = new BroadcastReceiver() {			
			@Override
			public void onReceive(Context context, Intent intent) {
				//do something on recieved intent
				Toast.makeText(getApplicationContext(), "Recieved: " + _count, Toast.LENGTH_SHORT).show();
				_count++;			
			}
		};
		
		registerReceiver(_reciever, new IntentFilter(RecievingService.messageLabel));		
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		unregisterReceiver(_reciever);
		Toast.makeText(getApplicationContext(), "Recieving ends", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}
}
