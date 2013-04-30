package app.guohao.spareandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class flashfail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

<<<<<<< HEAD
	//	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	//			WindowManager.LayoutParams.FLAG_FULLSCREEN); //
=======
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); //
>>>>>>> 6577b7355655d50f19bcdfff9aeea512498d68b9
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.flashfail);
	}

}
