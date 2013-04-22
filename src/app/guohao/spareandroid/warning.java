package app.guohao.spareandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class warning extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// …Ë÷√»´∆¡
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); //
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.warning);

		final Button bn = (Button) findViewById(R.id.login);

		bn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View source) {

				Intent intent = new Intent();

				intent.setClass(warning.this, homepage.class);
				startActivity(intent);
				// warning.this.finish();

			}
		});
	}
}
