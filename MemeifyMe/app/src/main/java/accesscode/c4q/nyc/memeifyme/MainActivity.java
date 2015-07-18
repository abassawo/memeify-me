package accesscode.c4q.nyc.memeifyme;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_camera;
    private Button btn_album;
    private Button btn_template;
    private Button btn_doge;
    private Button btn_exit;
    public static final String TABLE_NAME = "tasks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_camera:
                Intent camera = new Intent(this, Camera.class);
                startActivity(camera);
                break;
            case R.id.btn_album:
                Intent gallery = new Intent(this, Gallery.class);
                startActivity(gallery);
                break;
            case R.id.btn_template:
                Intent template = new Intent(this, Template.class);
                startActivity(template);
                break;
            case R.id.btn_doge:
                Intent doge = new Intent(this, Doge.class);
                startActivity(doge);
                break;
            case R.id.btn_exit:
                finish();
                System.exit(0);
                break;
        }
    }

    private void initializeViews() {
        btn_camera = (Button) findViewById(R.id.btn_camera);
        btn_album = (Button) findViewById(R.id.btn_album);
        btn_template = (Button) findViewById(R.id.btn_template);
        btn_doge = (Button) findViewById(R.id.btn_doge);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        btn_camera.setOnClickListener(this);
        btn_album.setOnClickListener(this);
        btn_template.setOnClickListener(this);
        btn_doge.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }



}