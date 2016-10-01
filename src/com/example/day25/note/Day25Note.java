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

		// 1.��ȡ���Ź�����
		SmsManager sm = SmsManager.getDefault();
		// 2.���Ͷ���
		sm.sendTextMessage(phone, null, content, null, null);

		// 2.�и���ţ�������ų������ȣ��ѳ����ŷֳ����ɸ�С����
		ArrayList<String> smss = sm.divideMessage(content);
		// 3.forѭ���Ѽ����е����ж���ȫ������ȥ
		for (String string : smss) {
			sm.sendTextMessage(phone, null, string, null, null);
		}
	}
}
