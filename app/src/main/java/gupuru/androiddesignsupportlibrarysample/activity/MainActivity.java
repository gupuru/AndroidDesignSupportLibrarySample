package gupuru.androiddesignsupportlibrarysample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import gupuru.androiddesignsupportlibrarysample.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.base);
        button.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.custom_behavior);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.app_bar_layout);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.collapsing);
        button3.setOnClickListener(this);

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
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.base:
                intent = new Intent(MainActivity.this, BaseAndroidDesignsLibraryActivity.class);
                startActivity(intent);
                break;
            case R.id.custom_behavior:
                intent = new Intent(MainActivity.this, CustomBehaviorActivity.class);
                startActivity(intent);
                break;
            case R.id.app_bar_layout:
                intent = new Intent(MainActivity.this, AppBarLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.collapsing:
                intent = new Intent(MainActivity.this, CollapsingToolbarLayoutActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
