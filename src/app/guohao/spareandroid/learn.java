package app.guohao.spareandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class learn extends Activity {
	private static final String TAG = "Switcher";

	private Button flashfail;
	private Button battery;
	private Button delinner;
	private Button beauty;
	private Button innerapk;
	private Button makerec;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		//		WindowManager.LayoutParams.FLAG_FULLSCREEN); //
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.learn);

		flashfail = (Button) findViewById(R.id.flashfail);
		battery = (Button) findViewById(R.id.battery);
		delinner = (Button) findViewById(R.id.delinner);
		beauty = (Button) findViewById(R.id.beauty);
		innerapk = (Button) findViewById(R.id.innerapk);
		makerec = (Button) findViewById(R.id.makerec);

		flashfail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(learn.this, flashfail.class);
				startActivity(intent);

			}
		});
		battery.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(learn.this, battery.class);
				startActivity(intent);

			}
		});
		beauty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(learn.this, beauty.class);
				startActivity(intent);

			}
		});
		innerapk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(learn.this, innerapk.class);
				startActivity(intent);

			}
		});
		delinner.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(learn.this, delinner.class);
				startActivity(intent);

			}
		});
		makerec.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(learn.this, makerec.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);
		MenuItem about = menu.add("°ïÖú");
		about.setIntent(new Intent(this, help4.class));

		return true;
	}

}
