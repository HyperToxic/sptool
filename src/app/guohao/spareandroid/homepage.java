package app.guohao.spareandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class homepage extends Activity {

	// Button bn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 禁止输入法自动弹出
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		// 设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); //
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.homepage);
		// 下一步按钮
		final Button bn = (Button) findViewById(R.id.gettingStart);
		final Button bn2 = (Button) findViewById(R.id.aboutRom);
		final Button bn3 = (Button) findViewById(R.id.aboutApk);

		final Button bn4 = (Button) findViewById(R.id.spareParts);
		final Button bn5 = (Button) findViewById(R.id.help);

		bn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, spare.class);
				startActivity(intent);

			}
		});

		bn5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(homepage.this, help.class);
				startActivity(intent);

			}
		});
	}

	/*
	 * public boolean onCreateOptionsMenu(Menu menu) {
	 * 
	 * super.onCreateOptionsMenu(menu);
	 * 
	 * MenuItem settings = menu.add("设置"); settings.setIntent(new Intent(this,
	 * settingsActivity.class)); // return super.onCreateOptionsMenu(menu);
	 * 
	 * MenuItem about = menu.add("关于"); about.setIntent(new Intent(this,
	 * aboutActivity.class));
	 * 
	 * 
	 * 
	 * MenuItem quit = menu.add("退出"); quit.setIntent(new Intent(this,
	 * aboutActivity.class));
	 * 
	 * return true; }
	 */

}
