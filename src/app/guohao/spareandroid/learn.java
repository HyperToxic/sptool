package app.guohao.spareandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class learn extends Activity {
	private static final String TAG = "Switcher";

	private Button android;
	private Button flash;
	private Button apk;

	// private Button bootloader;
	// private Button recovery;

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
		setContentView(R.layout.learn);

		android = (Button) findViewById(R.id.android);
		flash = (Button) findViewById(R.id.flash);
		apk = (Button) findViewById(R.id.apk);

	}

	// reboot = (Button) findViewById(R.id.reboot);
	// lock = (Button) findViewById(R.id.lock);

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		// MenuItem settings = menu.add("设置"); settings.setIntent(new
		// Intent(this,
		// settingsActivity.class));
		// return super.onCreateOptionsMenu(menu);

		MenuItem about = menu.add("帮助");
		about.setIntent(new Intent(this, help4.class));

		return true;
	}

}
