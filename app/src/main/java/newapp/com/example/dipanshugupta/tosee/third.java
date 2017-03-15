package newapp.com.example.dipanshugupta.tosee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static newapp.com.example.dipanshugupta.tosee.R.id.editText;

public class third extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText editName, editAge, editUdai, editSymptoms, editDiagnosis, editMedicine;
    Button btnDone;
    Button btnupdate;
    Button btndelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mydb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText2);
        editAge = (EditText) findViewById(R.id.editText3);
        editUdai = (EditText) findViewById(R.id.editText);
        editSymptoms = (EditText) findViewById(R.id.editText4);
        editDiagnosis = (EditText) findViewById(R.id.editText5);
        editMedicine = (EditText) findViewById(R.id.editText6);
        btnDone= (Button) findViewById(R.id.button3);
        btnupdate = (Button) findViewById(R.id.button_update);
        btndelete = (Button) findViewById(R.id.button_delete);
        Done();
        UpdateData();
        DeleteData();

    }
    public void OnDone(View view) {
        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        String udai = editUdai.getText().toString();
        String symptoms = editSymptoms.getText().toString();
        String diagnosis = editDiagnosis.getText().toString();
        String medicine = editMedicine.getText().toString();
        String type = "Done";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, name, age, udai, symptoms, diagnosis, medicine);
    }
    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = mydb.deleteData(editUdai.getText().toString());
                        if(deleteRows > 0)
                            Toast.makeText(third.this, "Data is Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(third.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData(){
        btnupdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isupdate = mydb.updateData(editName.getText().toString(),editAge.getText().toString(),
                                editUdai.getText().toString(),editSymptoms.getText().toString(),editDiagnosis.getText().toString(),
                                editMedicine.getText().toString());
                        if(isupdate == true)
                            Toast.makeText(third.this, "Data is Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(third.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void Done(){
        btnDone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertData(editName.getText().toString(),
                                editAge.getText().toString(),
                                editUdai.getText().toString(),editSymptoms.getText().toString(),editDiagnosis.getText().toString(),
                                editMedicine.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(third.this, "Data Saved", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(third.this, "Data not Saved", Toast.LENGTH_LONG).show();

                    }
                }

        );

    }
}
