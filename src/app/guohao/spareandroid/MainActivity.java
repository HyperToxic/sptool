package app.guohao.spareandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

		//
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.welcome);

		LinearLayout main = (LinearLayout) findViewById(R.id.splash); // ��ȡ���Բ��ֹ�����
		final ImageView image = new ImageView(this); // ����ImageView���
		main.addView(image); // ��ImageView�ӽ����Բ��ֹ�����
		image.setImageResource(images[0]);// ��ʼ��ʱ��ʾ��һ����Ƭ
		image.setOnClickListener(new OnClickListener() { // �½�һ��������������
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();

				intent.setClass(MainActivity.this, warning.class);
				startActivity(intent);
				MainActivity.this.finish();

			}
		});

	}
}
