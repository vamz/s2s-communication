package kst.mesko.servicetest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 //Set content view to fragment_main !!
		 setContentView(R.layout.fragment_main);

		 
		 // do the hooks
		 final Button startButton = (Button) findViewById(R.id.buttonStart);
		 startButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	startService(new Intent(MainActivity.this, SendingService.class));
            	startService(new Intent(MainActivity.this, RecievingService.class));
             }
         });
		
         final Button stopButton = (Button) findViewById(R.id.buttonStop);
         stopButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                stopService(new Intent(MainActivity.this, SendingService.class));
                stopService(new Intent(MainActivity.this, RecievingService.class));
             }
         });

		
//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
//
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
