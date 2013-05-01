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

public class website extends Activity {
	private static final String TAG = "Switcher";

	/*private Button question;
	private Button beauty;
	private Button diy;
	private Button compile;
	private Button website;
	private Button others;
	*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.website);

	/*	question = (Button) findViewById(R.id.question);
		compile = (Button) findViewById(R.id.compile);
		diy = (Button) findViewById(R.id.diy);
		beauty = (Button) findViewById(R.id.beauty);
		others = (Button) findViewById(R.id.others);
		website = (Button) findViewById(R.id.website);

		beauty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(website.this, beauty.class);
				startActivity(intent);

			}
		});
		diy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(website.this, diy.class);
				startActivity(intent);

			}
		});
		question.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(website.this, question.class);
				startActivity(intent);

			}
		});
		compile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(website.this, compile.class);
				startActivity(intent);

			}
		});
		website.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(website.this, website.class);
				startActivity(intent);

			}
		});
		others.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(website.this, others.class);
				startActivity(intent);

			}
		});
		*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);
		MenuItem about = menu.add("帮助");
		about.setIntent(new Intent(this, help4.class));

		return true;
	}

}
