package app.guohao.spareandroid;

import android.app.Activity;
import android.app.admin.IDevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class nutter extends Activity {
	private static final String TAG = "Switcher";

	/*
	 * private Button root; private Button audio; private Button mod; private
	 * Button button; private Button uninstall;
	 */
	IDevicePolicyManager service;

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
		setContentView(R.layout.nutter);
		// 弹出提问窗口
		Intent intent = new Intent();
		intent.setClass(nutter.this, help5.class);// 4
		startActivity(intent);

		Button root = (Button) findViewById(R.id.root);
		Button audio = (Button) findViewById(R.id.audio);
		Button mod = (Button) findViewById(R.id.mod);
		Button button = (Button) findViewById(R.id.button);
		Button uninstall = (Button) findViewById(R.id.uninstall);

		root.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {
				Intent intent = new Intent();

				intent.setClass(nutter.this, root.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		// MenuItem settings = menu.add("设置"); settings.setIntent(new
		// Intent(this,
		// settingsActivity.class));
		// return super.onCreateOptionsMenu(menu);

		MenuItem about = menu.add("帮助");
		about.setIntent(new Intent(this, help2.class));

		return true;
	}

}
