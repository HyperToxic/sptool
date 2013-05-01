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

public class homepage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		

		setContentView(R.layout.homepage);
		
		final Button bn2 = (Button) findViewById(R.id.learn);
		final Button bn3 = (Button) findViewById(R.id.nutter);
		final Button bn5 = (Button) findViewById(R.id.myPhone);
		final Button bn4 = (Button) findViewById(R.id.spareParts);
		final Button bn6 = (Button) findViewById(R.id.ROMinfo);

		bn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, learn.class);
				startActivity(intent);

			}
		});

		bn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, nutter.class);
				startActivity(intent);

			}
		});

		bn5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, phone.class);
				startActivity(intent);

			}
		});

		bn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, spare.class);
				startActivity(intent);

			}
		});

		bn6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, ROMinfo.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		

		MenuItem about = menu.add("帮助");
		about.setIntent(new Intent(this, help.class));

		return true;
	}

}
