package app.guohao.spareandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class help extends Activity {
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		layout = (LinearLayout) findViewById(R.id.help);
		layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "�ף���������ⲿ�رմ��ڣ�",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

}
