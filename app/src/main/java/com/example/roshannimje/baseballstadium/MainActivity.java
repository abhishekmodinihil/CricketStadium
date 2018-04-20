package com.example.roshannimje.baseballstadium;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    int outerColors[];
    int innerColors[];

    //    private String outerColor = "#1A237E";
    private String outerDefaultColor = "#E0E0E0";
    private String innerDefaultColor = "#F5F5F5";

    private String outerDarkColor = "#3F51B5";
    private String outerLightColor = "#7986CB";
    private String outerExtraLightColor = "#C5CAE9";
    private String innerDarkColor = "#9FA8DA";
    private String innerLightColor = "#C5CAE9";
    private String innerExtraLigthColor = "#E8EAF6";

    PieChart pieChart1;

    PieChart pieChart;
    ArrayList<PieEntry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSetOuter;
    PieDataSet pieDataSetInner;
    PieData pieDataOuter;
    PieData pieDataInner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Description description = new Description();
        description.setText("");

        pieChart = findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(30f);
        pieChart.setHoleRadius(73f);
        pieChart.setDescription(description);
        pieChart.setRotationEnabled(false);
        pieChart.setTransparentCircleAlpha(0);

        pieChart1 = findViewById(R.id.piechart1);
        pieChart1.setUsePercentValues(true);
        pieChart1.setDrawHoleEnabled(true);
        pieChart1.setTransparentCircleRadius(60f);
        pieChart1.setHoleRadius(60f);
        pieChart1.setDescription(description);
        pieChart1.setRotationEnabled(false);
        pieChart1.setTransparentCircleAlpha(0);
        pieChart1.setHoleColor(Color.parseColor("#9CCC65"));
//        pieChart1.setVisibility(View.GONE);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSetOuter = new PieDataSet(entries, "");
        pieDataSetInner = new PieDataSet(entries, "");

        pieDataOuter = new PieData(pieDataSetOuter);
        pieDataOuter.setValueTextSize(0f);
        pieDataInner = new PieData(pieDataSetInner);
        pieDataInner.setValueTextSize(0f);

        pieDataSetOuter.setColors(new int[]{Color.parseColor("#80DEEA")});
        pieDataSetOuter.setSliceSpace(1);
        pieDataSetInner.setColors(new int[]{Color.parseColor("#B2EBF2")});
        pieDataSetInner.setSliceSpace(1);

        pieChart.setData(pieDataOuter);

        pieChart.animateY(1500);

//        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
//                Toast.makeText(MainActivity.this, "" + dataSetIndex, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });

        pieChart1.setData(pieDataInner);

        pieChart1.animateY(2000);

//        pieChart1.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
//                Toast.makeText(MainActivity.this, "" + h, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });
        final int[] count = {0};
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (count[0] == 30)
//                    count[0] = 0;
//
        outerColors = new int[]{Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor),
                Color.parseColor(outerDefaultColor), Color.parseColor(outerDefaultColor)};

        innerColors = new int[]{Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor),
                Color.parseColor(innerDefaultColor), Color.parseColor(innerDefaultColor)};
//
        setSectinColor(1, Color.parseColor("#E91E63"), Color.parseColor("#F06292"));
//
//                int outerColor = outerColors[count[0]];
//                outerColors[count[0]] = Color.parseColor(outerDarkColor);
//                int innerColor = innerColors[count[0]];
//                innerColors[count[0]] = Color.parseColor(innerDarkColor);
//
//                if (count[0] == 0) {
//                    outerColors[outerColors.length - 1] = Color.parseColor(outerLightColor);
//                    innerColors[innerColors.length - 1] = Color.parseColor(innerLightColor);
//                } else {
//                    outerColors[count[0] - 1] = Color.parseColor(outerLightColor);
//                    innerColors[count[0] - 1] = Color.parseColor(innerLightColor);
//                }
//
//                if (count[0] == outerColors.length - 1) {
//                    outerColors[0] = Color.parseColor(outerLightColor);
//                    innerColors[0] = Color.parseColor(innerLightColor);
//                } else {
//                    outerColors[count[0] + 1] = Color.parseColor(outerLightColor);
//                    innerColors[count[0] + 1] = Color.parseColor(innerLightColor);
//                }
//
//                if (count[0] == 0) {
//                    outerColors[outerColors.length - 2] = Color.parseColor(outerExtraLightColor);
//                    innerColors[innerColors.length - 2] = Color.parseColor(innerExtraLigthColor);
//                } else if (count[0] == 1) {
//                    outerColors[outerColors.length - 1] = Color.parseColor(outerExtraLightColor);
//                    innerColors[innerColors.length - 1] = Color.parseColor(innerExtraLigthColor);
//                } else {
//                    outerColors[count[0] - 2] = Color.parseColor(outerExtraLightColor);
//                    innerColors[count[0] - 2] = Color.parseColor(innerExtraLigthColor);
//                }
//
//                if (count[0] == outerColors.length - 2) {
//                    outerColors[0] = Color.parseColor(outerExtraLightColor);
//                    innerColors[0] = Color.parseColor(innerExtraLigthColor);
//                } else if (count[0] == outerColors.length - 1) {
//                    outerColors[0 + 1] = Color.parseColor(outerExtraLightColor);
//                    innerColors[0 + 1] = Color.parseColor(innerExtraLigthColor);
//                } else {
//                    outerColors[count[0] + 2] = Color.parseColor(outerExtraLightColor);
//                    innerColors[count[0] + 2] = Color.parseColor(innerExtraLigthColor);
//                }
//
//                pieDataSetOuter.setColors(outerColors);
//                outerColors[count[0]] = outerColor;
//                pieDataSetInner.setColors(innerColors);
//                innerColors[count[0]] = innerColor;
//
//                pieChart.highlightValue(new Highlight(count[0], 0, 0));
//                pieChart1.highlightValue(new Highlight(count[0], 0, 0));
//                count[0]++;
//            }
//        }, 0, 500);
    }


    public void AddValuesToPIEENTRY() {
//        entries.add(new PieEntry(1f, 0));
//        entries.add(new PieEntry(1f, 1));
//        entries.add(new PieEntry(1f, 2));
//        entries.add(new PieEntry(1f, 3));
//        entries.add(new PieEntry(1f, 4));
//        entries.add(new PieEntry(1f, 5));
//        entries.add(new PieEntry(1f, 6));
//        entries.add(new PieEntry(1f, 7));
//        entries.add(new PieEntry(1f, 8));
//        entries.add(new PieEntry(1f, 9));
//        entries.add(new PieEntry(1f, 10));
//        entries.add(new PieEntry(1f, 11));
//        entries.add(new PieEntry(1f, 12));
//        entries.add(new PieEntry(1f, 13));
//        entries.add(new PieEntry(1f, 14));
//        entries.add(new PieEntry(1f, 15));
//        entries.add(new PieEntry(1f, 16));
//        entries.add(new PieEntry(1f, 17));
//        entries.add(new PieEntry(1f, 18));
//        entries.add(new PieEntry(1f, 19));
//        entries.add(new PieEntry(1f, 20));
//        entries.add(new PieEntry(1f, 21));
//        entries.add(new PieEntry(1f, 22));
//        entries.add(new PieEntry(1f, 23));
//        entries.add(new PieEntry(1f, 24));
//        entries.add(new PieEntry(1f, 25));
//        entries.add(new PieEntry(1f, 26));
//        entries.add(new PieEntry(1f, 27));
//        entries.add(new PieEntry(1f, 28));
//        entries.add(new PieEntry(1f, 29));
        for (int i = 0; i < 30; i++) {
            entries.add(new PieEntry(1f));
        }
    }

    public void AddValuesToPieEntryLabels() {
        PieEntryLabels.add("A");
        PieEntryLabels.add("B");
        PieEntryLabels.add("C");
        PieEntryLabels.add("D");
        PieEntryLabels.add("E");
        PieEntryLabels.add("F");
    }

    public void setSectinColor(int sectionNo, int outerColor, int innerColor) {
        for (int i = (sectionNo * 5) - 5; i < sectionNo * 5; i++) {
            outerColors[i] = outerColor;
            innerColors[i] = innerColor;
        }
    }
}
