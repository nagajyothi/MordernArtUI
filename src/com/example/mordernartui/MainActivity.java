package com.example.mordernartui;


import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends ActionBarActivity {
private static final int MENU_INFORMATION =Menu.FIRST;
static private final String URL = "http://www.moma.org";
private SeekBar seekBar;
private DialogFragment mDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		seekBar = (SeekBar)findViewById(R.id.seekBar1);
		seekBar.setMax(100);
		final ImageView image2 = (ImageView)findViewById(R.id.imageView2);
		final ImageView image3 = (ImageView)findViewById(R.id.imageView3);
		final ImageView image4 = (ImageView)findViewById(R.id.imageView4);
		final ImageView image5 = (ImageView)findViewById(R.id.imageView5);
		final ImageView image6 = (ImageView)findViewById(R.id.imageView6);
		final ImageView image7 = (ImageView)findViewById(R.id.imageView7);
		final ImageView image8 = (ImageView)findViewById(R.id.imageView8);
		
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (progress >= 25 && progress < 50) {
	                image3.setColorFilter(Color.BLUE);
	                image5.setColorFilter(Color.GRAY);
	                image7.setColorFilter(Color.CYAN);
	                
	            }
				else if (progress >= 50 && progress < 75) {
	                image2.setColorFilter(Color.GREEN);
	                image4.setColorFilter(Color.MAGENTA);
	                image8.setColorFilter(Color.LTGRAY);
	            } 
	            else if (progress >= 75 && progress <= 100) {
	                image3.setColorFilter(Color.YELLOW);
	                image5.setColorFilter(Color.RED);
	                image7.setColorFilter(Color.BLUE);
	            }
	            else {
	                image2.setColorFilter(Color.RED);
	                image4.setColorFilter(Color.BLACK);
	                image8.setColorFilter(Color.GREEN);
	            }
			}
		});
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE,MENU_INFORMATION, Menu.NONE,"More Information");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == MENU_INFORMATION) {
			//Create an Alert Dialog
			showDialogFragment(MENU_INFORMATION);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//Show Desired Dialog.
	void showDialogFragment(int dialogID) {
		mDialog = AlertDialogFragment.newInstance();
		mDialog.show(getFragmentManager(), "Alert");
	}
	
	private void visitWebPage(boolean shouldVisit) {
		if(shouldVisit) {
			//code to visit webpage
			Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(URL));
			startActivity(intent);
		}
		else {
			mDialog.dismiss();
		}
	}
	
	// Class that creates the AlertDialog
	public static class AlertDialogFragment extends DialogFragment {

		public static AlertDialogFragment newInstance() {
			return new AlertDialogFragment();
		}

		// Build AlertDialog using AlertDialog.Builder
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			return new AlertDialog.Builder(getActivity())
					.setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicolson. Click Below to learn more!")
					
					// User cannot dismiss dialog by hitting back button
					.setCancelable(false)
					
					// Set up Yes Button
					.setPositiveButton("Visit MOMA",
							new DialogInterface.OnClickListener() {
								public void onClick(
										final DialogInterface dialog, int id) {
									((MainActivity) getActivity())
											.visitWebPage(true);
								}
							})
							
					// Set up No Button
					.setNegativeButton("Not Now",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									((MainActivity) getActivity())
											.visitWebPage(false);
								}
							}).create();
		}
	}
	
	
}


