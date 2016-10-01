package com.example.day25.note;

import java.util.ArrayList;

import com.example.day25.R;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Day25Note extends Activity {
	EditText et_goal, et_content;
	Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day25_note);
	}

	public void noteSend(View v) {
		et_goal = (EditText) findViewById(R.id.day25_goal);
		et_content = (EditText) findViewById(R.id.day25_content);
		send = (Button) findViewById(R.id.day25_send);

		String phone = et_goal.getText().toString();
		String content = et_content.getText().toString();

		// 1.获取短信管理器
		SmsManager sm = SmsManager.getDefault();
		// 2.发送短信
		sm.sendTextMessage(phone, null, content, null, null);

		// 2.切割短信，如果短信超过长度，把长短信分成若干个小短信
		ArrayList<String> smss = sm.divideMessage(content);
		// 3.for循环把集合中的所有短信全部发出去
		for (String string : smss) {
			sm.sendTextMessage(phone, null, string, null, null);
		}
	}
}
