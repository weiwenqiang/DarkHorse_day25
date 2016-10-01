package com.example.day25.dialer;

import com.example.day25.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Day25Dialer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day25_dialer);
		Button dial = (Button) findViewById(R.id.day25_dial);
		dial.setOnClickListener(new MyListener());
	}

	class MyListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			EditText edit = (EditText) findViewById(R.id.day25_edit);
			String phone = edit.getText().toString();

			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:" + phone));

			startActivity(intent);
		}

	}
}
