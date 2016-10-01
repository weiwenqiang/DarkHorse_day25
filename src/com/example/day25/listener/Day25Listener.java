package com.example.day25.listener;

import com.example.day25.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Day25Listener extends Activity implements OnClickListener {
	Button nm, nb, jk, xml;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day25_listener);
		nm = (Button) findViewById(R.id.day25_nm);
		nb = (Button) findViewById(R.id.day25_nb);
		jk = (Button) findViewById(R.id.day25_jk);
		xml = (Button) findViewById(R.id.day25_xml);

		nm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("Click", "������ķ���ʵ�ֵ���¼�");
			}
		});

		nb.setOnClickListener(new MyOnClick());
		
		jk.setOnClickListener(this);
	}

	class MyOnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			Log.i("Click", "�ڲ���ķ���ʵ�ֵ���¼�");
		}
	}

	@Override
	public void onClick(View v) {
		Log.i("Click", "ʵ�ֽӿڵķ���ʵ�ֵ���¼�");
	}

	public void xmlOnClick(View v) {
		Log.i("Click", "����XML��onClick����ʵ�ֵ���¼�");
	}
}
