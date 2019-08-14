package com.example.iwantthepojo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnMoveActivity;
    public Button btnMoveData;
    public Button btnMoveObject;
    Button btnDialNumber;
    Button btnMoveResult;

    TextView tvResult;

    private  int REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button) findViewById(R.id.btnMove);
        btnMoveActivity.setOnClickListener(this);

        btnMoveData = (Button) findViewById(R.id.btnMoveActivity);
        btnMoveData.setOnClickListener(this);

        btnMoveObject =  findViewById(R.id.btnMoveObject);
        btnMoveObject.setOnClickListener(this);

        btnDialNumber =  findViewById(R.id.btnDial);
        btnDialNumber.setOnClickListener(this);

        btnMoveResult =  findViewById(R.id.btnMoveRslt);
        btnMoveResult.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.txtRslt);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == activityMoveForResult.RESULT_CODE) {
                int selectedValue =
                        data.getIntExtra(activityMoveForResult.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnMove:
                Intent maju = new Intent(MainActivity.this,ActivityMove.class);
                startActivity(maju);
                break;

            case R.id.btnMoveActivity:
                Intent majuu = new Intent(MainActivity.this,activity_move_with_data.class);
                majuu.putExtra(activity_move_with_data.EXTRA_NAME,"PERSIB");
                majuu.putExtra(activity_move_with_data.EXTRA_AGE,24);

                startActivity(majuu);

                break;

            case R.id.btnMoveObject:
                Person aku = new Person();
                aku.setName("Mochamad Naufal Abdi A");
                aku.setAge(17);
                aku.setCity("London");
                aku.setEmail("myemail@email.com");
                Intent majuuu = new Intent(MainActivity.this,activity_move_with_object.class);

                majuuu.putExtra(activity_move_with_object.EXTRA_PERSON,aku );
                startActivity(majuuu);
                break;

            case R.id.btnDial:
                String NumberPhone = "0123810293801";
                Intent callme = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + NumberPhone));
                startActivity(callme);
                break;

            case R.id.btnMoveRslt:
                Intent majuyuk = new Intent(MainActivity.this,activityMoveForResult.class);
                startActivityForResult(majuyuk,REQUEST_CODE);
                break;
        }







    }
}
