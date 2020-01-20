package com.intcore.statefullayoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.intcore.statefullayout.StatefulLayout;

public class MainActivity extends AppCompatActivity implements StatefulLayout.ClickListener{

    private StatefulLayout statefulLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        statefulLayout = findViewById(R.id.stateful);
        statefulLayout.setClickListener(this);
    }

    public void content(View view) {
        statefulLayout.setState(StatefulLayout.STATE.HAS_CONTENT);
    }

    public void loading(View view) {
        statefulLayout.setState(StatefulLayout.STATE.IN_PROGRESS);
    }

    public void empty(View view) {
        statefulLayout.setState(StatefulLayout.STATE.EMPTY_CONTENT);
    }

    public void error(View view) {
        statefulLayout.setState(StatefulLayout.STATE.UNKNOWN_ERROR);
    }

    public void offline(View view) {
        statefulLayout.setState(StatefulLayout.STATE.CONNECTION_ERROR);
    }

    // StateLayout Callbacks
    @Override
    public void onRetryRefreshClicked() {
        Toast.makeText(this,"Retry Clicked",Toast.LENGTH_LONG).show();
    }
}
