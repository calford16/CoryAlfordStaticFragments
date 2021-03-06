package edu.westga.coryalfordstaticfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener, DataDisplayFragment.DataAddListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataEntry(double numberOne, double numberTwo){
        DataDisplayFragment displayFragment = (DataDisplayFragment) getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);
        displayFragment.setNumber1(numberOne);
        displayFragment.setNumber2(numberTwo);
        displayFragment.multiply();
        displayFragment.displayProduct();

    }

    @Override
    public void onDataAdd(double numberOne, double numberTwo) {
        DataDisplayFragmentTwo displayFragmentTwo = (DataDisplayFragmentTwo) getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragmentTwo);
        displayFragmentTwo.setNumber1(numberOne);
        displayFragmentTwo.setNumber2(numberTwo);
        displayFragmentTwo.add();
        displayFragmentTwo.displaySum();
    }
}
