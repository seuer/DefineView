package com.wondertek.defineview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.wondertek.defineview.Topbar.TopbarOnclickListener;

public class MainActivity extends Activity {

	private Topbar topbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		topbar = (Topbar) findViewById(R.id.topbar);
		topbar.setOnclickTopbarListener(new TopbarOnclickListener() {

			@Override
			public void rightOnclick() {

				Toast.makeText(MainActivity.this, "right", Toast.LENGTH_LONG)
						.show();

			}

			@Override
			public void leftOnclick() {

				Toast.makeText(MainActivity.this, "left", Toast.LENGTH_LONG)
						.show();
			}
		});

	}

}
