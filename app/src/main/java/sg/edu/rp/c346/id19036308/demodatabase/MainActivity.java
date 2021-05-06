package sg.edu.rp.c346.id19036308.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ArrayAdapter aa;
    ArrayList<Task> task;
    ListView lv;

    //Inserting Data into database (Saving data in SQL Lite Database)
    DBHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        lv = this.findViewById(R.id.lv);
        databaseHelper = new DBHelper(MainActivity.this);

        task = databaseHelper.getTasks();
        aa = new TaskAdapter(MainActivity.this, R.layout.row, task);
        lv.setAdapter(aa);






        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the DBHelper object, passing in the activity's
                // Context
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();

            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> data = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";

                }
                tvResults.setText(txt);

            }
        });

    }

}