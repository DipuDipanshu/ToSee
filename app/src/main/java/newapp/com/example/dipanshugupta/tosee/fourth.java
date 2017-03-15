package newapp.com.example.dipanshugupta.tosee;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fourth extends AppCompatActivity {
    DatabaseHelper mydb;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        mydb = new DatabaseHelper(this);
        btnviewAll = (Button) findViewById(R.id.button4);
        viewAll();
    }
    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mydb.getAllData();
                        if(res.getCount()==0){
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id :"+res.getString(0)+"\n");
                            buffer.append("Name :"+res.getString(1)+"\n");
                            buffer.append("Age :"+res.getString(2)+"\n");
                            buffer.append("Udai :"+res.getString(3)+"\n");
                            buffer.append("Symptoms :"+res.getString(4)+"\n");
                            buffer.append("Diagnosis :"+res.getString(5)+"\n");
                            buffer.append("Medicine :"+res.getString(6)+"\n\n");


                        }
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
