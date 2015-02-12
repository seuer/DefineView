package com.wondertek.defineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Topbar extends RelativeLayout {

	private Button leftButton;
	private TextView titleText;
	private Button rightButton;

	// �������button������
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	// �����ұ�button������
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	// ������������
	private float titleTextSize;
	private int titleTextColor;
	private String title;

	private LayoutParams leftParams;
	private LayoutParams rightParams;
	private LayoutParams titleParams;

	private TopbarOnclickListener listener;

	public interface TopbarOnclickListener {
		public void leftOnclick();

		public void rightOnclick();
	}

	public void setOnclickTopbarListener(TopbarOnclickListener listener) {
		this.listener = listener;
	}

	public Topbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.Topbar);
		leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText = ta.getString(R.styleable.Topbar_leftText);

		rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText = ta.getString(R.styleable.Topbar_rightText);

		titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		title = ta.getString(R.styleable.Topbar_title);
		ta.recycle();
         //ʵ�����ؼ�
		leftButton = new Button(context);
		rightButton = new Button(context);
		titleText = new TextView(context);

		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);

		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);

		titleText.setTextColor(titleTextColor);
		titleText.setTextSize(titleTextSize);
		titleText.setText(title);
		titleText.setGravity(Gravity.CENTER);

		setBackgroundColor(0xFFF59563);
       //����button���ص�������
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		addView(leftButton, leftParams);
		//����button���ص�������
 		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		addView(rightButton, rightParams);
       //�ѱ�����ص�������
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		addView(titleText, titleParams);

		//����button���Ӽ����¼�
		leftButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.leftOnclick();

			}
		});
       //����button���Ӽ����¼�
		rightButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.rightOnclick();

			}
		});

	}

}
