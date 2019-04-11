package com.example.zenithandroid.linechart;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.db.chart.Tools;
import com.db.chart.animation.Animation;
import com.db.chart.model.LineSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.tooltip.Tooltip;
import com.db.chart.view.LineChartView;
import com.example.zenithandroid.R;


public class LineCardOne extends CardController {


	private final LineChartView mChart;


	private final Context mContext;


	private final String[] mLabels = {"Jan", "Fev", "Mar", "Apr", "Jun", "May", "Jul", "Aug", "Sep"};

	private final float[][] mValues = {{3.05f, 4.07f, 4.93f, 8.0f, 6.05f, 9.09f, 7.0f, 8.83f, 7.90f},
			  {6.45f, 5.5f, 6.5f, 8.00f, 4.05f, 9.05f, 9.5f, 8.33f, 9.18f}, {4.05f, 50.7f, 7.93f, 6.0f, 9.05f, 4.09f, 7.0f, 8.83f, 9.9f},
			{5.5f, 1.07f, 4.93f, 9.0f, 5.05f, 8.09f, 5.5f, 6.63f, 9.70f}};

	private Tooltip mTip;

	private Runnable mBaseAction;


	public LineCardOne(CardView card, Context context) {

		super(card);

		mContext = context;
		mChart = (LineChartView) card.findViewById(R.id.chart1);
	}


	@Override
	public void show(Runnable action) {

		super.show(action);

		// Tooltip
		mTip = new Tooltip(mContext, R.layout.linechart_three_tooltip, R.id.value);

		((TextView) mTip.findViewById(R.id.value)).setTypeface(
				  Typeface.createFromAsset(mContext.getAssets(), "OpenSans-Semibold.ttf"));

		mTip.setVerticalAlignment(Tooltip.Alignment.BOTTOM_TOP);
		mTip.setDimensions((int) Tools.fromDpToPx(58), (int) Tools.fromDpToPx(25));

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {

			mTip.setEnterAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 1),
					  PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f),
					  PropertyValuesHolder.ofFloat(View.SCALE_X, 1f)).setDuration(200);

			mTip.setExitAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 0),
					  PropertyValuesHolder.ofFloat(View.SCALE_Y, 0f),
					  PropertyValuesHolder.ofFloat(View.SCALE_X, 0f)).setDuration(200);

			mTip.setPivotX(Tools.fromDpToPx(65) / 2);
			mTip.setPivotY(Tools.fromDpToPx(25));
		}

		mChart.setTooltips(mTip);

		// Data
		LineSet dataset = new LineSet(mLabels, mValues[0]);
		dataset.setColor(Color.parseColor("#758cbb"))
				  .setFill(Color.parseColor("#2d374c"))
				  .setDotsColor(Color.parseColor("#758cbb"))
				  .setThickness(4)
				  .setDashed(new float[] {10f, 10f})
				  .beginAt(5);
		mChart.addData(dataset);

		dataset = new LineSet(mLabels, mValues[0]);
		dataset.setColor(Color.parseColor("#b3b5bb"))
				  .setFill(Color.parseColor("#2d374c"))
				  .setDotsColor(Color.parseColor("#ffc755"))
				  .setThickness(4)
				  .endAt(6);
		mChart.addData(dataset);

		// Chart
		mChart.setBorderSpacing(Tools.fromDpToPx(15))
				  .setAxisBorderValues(0, 20)
				  .setYLabels(AxisRenderer.LabelPosition.NONE)
				  .setLabelsColor(Color.parseColor("#6a84c3"))
				  .setXAxis(false)
				  .setYAxis(false);

		mBaseAction = action;
		Runnable chartAction = new Runnable() {
			@Override
			public void run() {

				mBaseAction.run();
				mTip.prepare(mChart.getEntriesArea(0).get(3), mValues[0][3]);
				mChart.showTooltip(mTip, true);
			}
		};

		Animation anim = new Animation().setEasing(new BounceInterpolator()).setEndAction(chartAction);

		mChart.show(anim);
	}


	@Override
	public void update() {

		super.update();

		mChart.dismissAllTooltips();
		if (firstStage) {
			mChart.updateValues(0, mValues[1]);
			mChart.updateValues(1, mValues[1]);
		} else {
			mChart.updateValues(0, mValues[0]);
			mChart.updateValues(1, mValues[0]);
		}
		mChart.getChartAnimation().setEndAction(mBaseAction);
		mChart.notifyDataUpdate();
	}


	@Override
	public void dismiss(Runnable action) {

		super.dismiss(action);

		mChart.dismissAllTooltips();
		mChart.dismiss(new Animation().setEasing(new BounceInterpolator()).setEndAction(action));
	}

}
