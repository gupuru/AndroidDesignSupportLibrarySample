package gupuru.androiddesignsupportlibrarysample.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gupuru.androiddesignsupportlibrarysample.R;

public class BaseAndroidDesignsLibraryActivity extends AppCompatActivity implements View.OnClickListener {

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_android_designs_library);
        // ツールバー
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //エラー表示
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout);
        textInputLayout.setError("えらーだよ");
        //true->表示, false->非表示
        textInputLayout.setErrorEnabled(true);

        Button button = (Button) findViewById(R.id.snack_bar_btn);
        button.setOnClickListener(this);

        snackbar = Snackbar.make(findViewById(R.id.layout), "てすと", Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snackbar_action, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.snack_bar_btn:
                snackbar.show();
                break;
            case R.id.snackbar_action:
                Toast.makeText(BaseAndroidDesignsLibraryActivity.this, "おされたよ", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}