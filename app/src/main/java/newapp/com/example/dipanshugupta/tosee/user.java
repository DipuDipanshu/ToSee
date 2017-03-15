package newapp.com.example.dipanshugupta.tosee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user extends AppCompatActivity {
    private static Button button_update;
    private static Button button_check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        onClickButtonListener();

    }
    public void onClickButtonListener(){
        button_update = (Button)findViewById(R.id.button);
        button_check = (Button)findViewById(R.id.button2);
        button_update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Intent = new Intent("newapp.com.example.dipanshugupta.tosee.third");
                        startActivity(Intent);


                    }
                }
        );
        button_check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Intent = new Intent("newapp.com.example.dipanshugupta.tosee.fourth");
                        startActivity(Intent);
                    }
                }
        );


    }
}
