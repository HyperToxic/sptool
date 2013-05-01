package app.guohao.spareandroid;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	int[] images = new int[] { R.drawable.splash };
	int currentImage = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.welcome);
		
		String appHome = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/guohow_Soft";
		final String subPath = appHome + "/NutterTools";
		final File file = new File(subPath);

		
		LinearLayout main = (LinearLayout) findViewById(R.id.splash);
		final ImageView image = new ImageView(this);
		main.addView(image);
		image.setImageResource(images[0]);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});

		if (file.exists()) {
			final Intent intent = new Intent();

			intent.setClass(MainActivity.this, homepage.class);
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					startActivity(intent); 
					MainActivity.this.finish();

				}
			};
			timer.schedule(task, 1000 * 1); 

		} else {

			final Intent intent = new Intent();

			intent.setClass(MainActivity.this, warning.class);

			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					startActivity(intent); 
					MainActivity.this.finish();

				}
			};
			timer.schedule(task, 1000 * 2); 

		}
	}

}
