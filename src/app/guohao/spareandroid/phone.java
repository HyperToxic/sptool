package app.guohao.spareandroid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class phone extends Activity {

	String cpuName = phone.getCpuName();
	String[] SYSTEM = phone.getVersion();
	String MIN = phone.getMinCpuFreq();
	String MAX = phone.getMaxCpuFreq();
	long[] ROM = getRomMemroy();
	String DISPLAY = android.os.Build.MODEL;
	String FAC = android.os.Build.MANUFACTURER;

	EditText cname;
	EditText cfreMax;
	EditText cfreMin;
	EditText fac;
	EditText display;
	EditText kernel;
	EditText rel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 禁止输入法自动弹出
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		// 设置全屏
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			//	WindowManager.LayoutParams.FLAG_FULLSCREEN); //
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.phone);

		cname = (EditText) findViewById(R.id.cpuName);
		cfreMax = (EditText) findViewById(R.id.Max);
		cfreMin = (EditText) findViewById(R.id.Min);
		display = (EditText) findViewById(R.id.dis);
		fac = (EditText) findViewById(R.id.fac);

		kernel = (EditText) findViewById(R.id.kernel);
		rel = (EditText) findViewById(R.id.rel);

		cfreMax.setText("*最大频率：" + MAX);
		cfreMin.setText("*最小频率：" + MIN);
		display.setText("*设备型号：" + DISPLAY);
		fac.setText("*制造厂家：" + FAC);

		// rom.setText("*" + ROM.toString());
		kernel.setText("*内核版本：" + SYSTEM[0]);
		rel.setText("*系统版本：" + SYSTEM[1]);
		cname.setText("*处理器：" + cpuName);

		/*
		 * final Button bn = (Button) findViewById(R.id.login);
		 * 
		 * bn.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View source) {
		 * 
		 * Intent intent = new Intent();
		 * 
		 * intent.setClass(myPhone.this, homepage.class); startActivity(intent);
		 * // warning.this.finish();
		 * 
		 * } });
		 */
	}

	public static String getCpuName() {

		try {

			FileReader fr = new FileReader("/proc/cpuinfo");

			BufferedReader br = new BufferedReader(fr);

			String text = br.readLine();

			String[] array = text.split(":\\s+", 2);

			for (int i = 0; i < array.length; i++) {

			}

			return array[1];

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;

	}

	//

	public static String[] getVersion() {

		String[] version = { "null", "null", "null", "null" };

		String str1 = "/proc/version";

		String str2;

		String[] arrayOfString;

		try {

			FileReader localFileReader = new FileReader(str1);

			BufferedReader localBufferedReader = new BufferedReader(

			localFileReader, 8192);

			str2 = localBufferedReader.readLine();

			arrayOfString = str2.split("\\s+");

			version[0] = arrayOfString[2];// KernelVersion

			localBufferedReader.close();

		} catch (IOException e) {

		}

		version[1] = Build.VERSION.RELEASE;// firmware version

		version[2] = Build.MODEL;// model

		version[3] = Build.DISPLAY;// system version

		return version;

	}

	public long[] getRomMemroy() {

		long[] romInfo = new long[2];

		// Total rom memory

		romInfo[0] = getTotalInternalMemorySize();

		// Available rom memory

		File path = Environment.getDataDirectory();

		StatFs stat = new StatFs(path.getPath());

		long blockSize = stat.getBlockSize();

		long availableBlocks = stat.getAvailableBlocks();

		romInfo[1] = blockSize * availableBlocks;

		getVersion();

		return romInfo;

	}

	public long getTotalInternalMemorySize() {

		File path = Environment.getDataDirectory();

		StatFs stat = new StatFs(path.getPath());

		long blockSize = stat.getBlockSize();

		long totalBlocks = stat.getBlockCount();

		return totalBlocks * blockSize;

	}

	public static String getMinCpuFreq() {

		String result = "";

		ProcessBuilder cmd;

		try {

			String[] args = { "/system/bin/cat",

			"/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" };

			cmd = new ProcessBuilder(args);

			Process process = cmd.start();

			InputStream in = process.getInputStream();

			byte[] re = new byte[24];

			while (in.read(re) != -1) {

				result = result + new String(re);

			}

			in.close();

		} catch (IOException ex) {

			ex.printStackTrace();

			result = "N/A";

		}

		return result.trim();

	}

	// 获取CPU最大频率（单位KHZ）

	// "/system/bin/cat" 命令行

	// "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" 存储最大频率的文件的路径

	public static String getMaxCpuFreq() {

		String result = "";

		ProcessBuilder cmd;

		try {

			String[] args = { "/system/bin/cat",

			"/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" };

			cmd = new ProcessBuilder(args);

			Process process = cmd.start();

			InputStream in = process.getInputStream();

			byte[] re = new byte[24];

			while (in.read(re) != -1) {

				result = result + new String(re);

			}

			in.close();

		} catch (IOException ex) {

			ex.printStackTrace();

			result = "N/A";

		}

		return result.trim();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		// MenuItem settings = menu.add("设置"); settings.setIntent(new
		// Intent(this,
		// settingsActivity.class));
		// return super.onCreateOptionsMenu(menu);

		MenuItem about = menu.add("提示");
		about.setIntent(new Intent(this, help3.class));

		return true;
	}

}
