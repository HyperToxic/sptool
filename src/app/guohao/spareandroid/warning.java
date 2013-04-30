package app.guohao.spareandroid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class warning extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置全屏
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		//		WindowManager.LayoutParams.FLAG_FULLSCREEN); //
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.warning);

		// 生成SD卡上的log日志
		String appHome = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/guohow_Soft";
		String subPath = appHome + "/NutterTools";

		createPath(appHome);
		createPath(subPath);

		File saveFile = new File(subPath, "nutter_Log.txt");
		try {
			FileWriter fw = new FileWriter(saveFile);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("---auto generated by NutterTools---" + "\n" + "设备型号："
					+ "\n" + android.os.Build.MODEL + "\n" + "设备厂商：" + "\n"
					+ android.os.Build.MANUFACTURER + "\n"
					+ "--copyright@guohow.app.android--");
			bw.close();
		} catch (Exception e) {
		}

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

	public static void createPath(String path) {

		File file = new

		File(path);

		if

		(!file.exists()) {

			file.mkdir();

		}

	}

}
