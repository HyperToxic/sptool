package app.guohao.spareandroid;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.app.admin.IDevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import app.guohao.api.AndroidCommand;

public class spare extends Activity {
	private static final String TAG = "Switcher";

	private Button shutdown;
	private Button reboot;
	private Button lock;
	private Button bootloader;
	private Button recovery;
	IDevicePolicyManager service;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��ֹ���뷨�Զ�����
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		// ����ȫ��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); //
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.spare);

		recovery = (Button) findViewById(R.id.recovery);
		bootloader = (Button) findViewById(R.id.bootloader);
		shutdown = (Button) findViewById(R.id.powerOff);
		reboot = (Button) findViewById(R.id.reboot);

		if (shutdown != null) {
			shutdown.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					AndroidCommand.execRooted("reboot -p");
				}
			});
		}
		if (bootloader != null) {
			bootloader.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					AndroidCommand.execRooted("reboot bootloader");
				}
			});
		}

		if (recovery != null) {
			recovery.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					AndroidCommand.execRooted("reboot recovery");
				}
			});
		}
		if (reboot != null) {
			reboot.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					AndroidCommand.execRooted("reboot");
				}
			});
		}

	}

	// ����
	public void lock() {
		try {
			// ͨ�������ȡ��sdk���صķ���
			Method method = Class.forName("android.os.ServiceManager")
					.getMethod("getService", String.class);
			IBinder binder = (IBinder) method.invoke(null,// �������
					new Object[] { Context.DEVICE_POLICY_SERVICE });
			service = IDevicePolicyManager.Stub.asInterface(binder);
			// �������������
			ComponentName mAdminName = new ComponentName(this,
					MainActivity.class);
			// ע��Ȩ��
			if (service != null) {
				// ע���deviceadmin��Ȩ��
				Intent intent = new Intent(
						DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
				intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
						mAdminName);
				startActivity(intent);
				// ���÷���ʵ������
				service.lockNow();
			}
		} catch (Throwable e) {
			Log.e(TAG, "Lock screen failed!", e);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		// MenuItem settings = menu.add("����"); settings.setIntent(new
		// Intent(this,
		// settingsActivity.class));
		// return super.onCreateOptionsMenu(menu);

		MenuItem about = menu.add("����");
		about.setIntent(new Intent(this, help2.class));

		return true;
	}

}
