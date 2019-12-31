package com.gpfreetech.scratchview.demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.gpfreetech.views.ScratchTextView;

import java.util.Calendar;

public class TodayActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    String[] permissionArrays = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    int REQUEST_CODE = 101;
    public Util objArray;
    public Calendar cal;
    private ImageView imgShare;
    private ScratchTextView thought;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        TextView txtView = (TextView) findViewById(R.id.date);
        thought = (ScratchTextView) findViewById(R.id.thought);
        thought.setScratchImage(R.drawable.scratch_image);
        thought.setStrokeWidth(20);
        TextView imgShare = (TextView) findViewById(R.id.img_share);
        cal = Calendar.getInstance();
        String date = cal.get(Calendar.DATE) + " " +
                objArray.get_currentMonth(cal.get(Calendar.MONTH)) + ", " + cal.get(Calendar.YEAR);
        String thoughtString = "" + objArray.get_todayThought(cal.get(Calendar.DAY_OF_YEAR));

        txtView.setText(date);
        thought.setText(thoughtString);

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionAndShare();
            }
        });
    }

    private void shareDay() {
        thought.reveal();
        Util.shareCard(this, ((CardView) findViewById(R.id.card)));
    }

    private void checkPermissionAndShare() {
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissionArrays, REQUEST_CODE);
            }
        } else {
            shareDay();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean openActivityOnce = true;
        boolean openDialogOnce = true;
        if (requestCode == REQUEST_CODE) {
            for (int i = 0; i < grantResults.length; i++) {
                String permission = permissions[i];
                //isPermitted = grantResults[i] == PackageManager.PERMISSION_GRANTED;

                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    // user rejected the permission
                } else {
                    //  user grant the permission
                    // you can perfome your action
                }
            }
        }
    }
}
