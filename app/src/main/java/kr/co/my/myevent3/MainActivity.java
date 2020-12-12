package kr.co.my.myevent3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button birthDatePicker, specifiedDatePicker;
    Button showbio;
    EditText txtbirthdate, txtthedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showComponent();
    }

    public void showComponent() {
        //layout에 있는 컴포넌트 객체 생성
        birthDatePicker = findViewById(R.id.birthDatePicker);
        specifiedDatePicker = findViewById(R.id.specifiedDatePicker);
        showbio = findViewById(R.id.showbio);
        txtbirthdate = findViewById(R.id.txtbirthdate);
        txtthedate = findViewById(R.id.txtthedate);

        String temps = "Hello"; // 지역변수
        birthDatePicker.setOnClickListener(new MybioClicks1(temps));
        specifiedDatePicker.setOnClickListener(new MybioClick2());
        showbio.setOnClickListener(new MyBioClicks3());
    }

    class MybioClicks1 implements View.OnClickListener{
        private String hello = "";
        public MybioClicks1(String hello){ // 액티비티의 지역변수는 직접 사용할 수 없다
            this.hello = hello;
        }
        @Override
        public void onClick(View v){
            if(v==birthDatePicker){
                txtbirthdate.setText(hello);
                //MainActivity.this.txtbirthdate.setText(hello);
            }
        }
    }
    class MybioClick2 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v==specifiedDatePicker){
                txtthedate.setText(new Date().toString());
            }
        }
    }
    class MyBioClicks3 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v==showbio){
                String st = String.format("%s! 오늘은 %s다.",txtbirthdate.getText(),txtthedate.getText());
                txtbirthdate.setText("");
                txtthedate.setText("");
                Toast.makeText(getBaseContext(),st,Toast.LENGTH_LONG).show();
            }
        }
    }


}