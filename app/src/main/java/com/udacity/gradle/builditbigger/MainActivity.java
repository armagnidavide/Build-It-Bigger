package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.androidlib.DisplayJokeActivity;

public class MainActivity extends AppCompatActivity implements JokeQueryAsyncTask.OnJokeQueryListener{


    private ProgressDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingDialog = new ProgressDialog(this);
        mLoadingDialog.setTitle(R.string.loading_dialog_title);
        mLoadingDialog.setMessage(getString(R.string.loading_dialog_message));
        mLoadingDialog.setCancelable(false);
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mLoadingDialog.show();
        JokeQueryAsyncTask asyncTask = new JokeQueryAsyncTask(this);
        asyncTask.execute();
    }

    @Override
    public void onJokeQueryFinished(String joke) {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }

        if (joke == null) {
            Toast.makeText(this, R.string.no_joke_returned_error, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.JOKE, joke);

        startActivity(intent);
    }



}
