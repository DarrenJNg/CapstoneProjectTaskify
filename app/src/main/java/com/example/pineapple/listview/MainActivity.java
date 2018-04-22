package com.example.pineapple.listview;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<String> editTasks = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // String[] tasks = {"Homework", "Homework2","No", "Yes", "Why isn't this working?"};

        editTasks.add("Pineapple");
        editTasks.add("Bigger Pineapple");
        editTasks.add("Biggest Pineapple");
        String[] tasks = new String[editTasks.size()];
        for(int x=0; x<editTasks.size(); x++){
            tasks[x] = editTasks.get(x);
        }
        //needs an adapter to transfer String[] to ListView
        ListAdapter adapter = new CustomAdapter(this, assignments);
        //initializes the ListView
        ListView ListyViewy = (ListView) findViewById(R.id.ListyViewy);
        //sets the adapter
        ListyViewy.setAdapter(adapter);

        //allows user to click on each element in ListView
        ListyViewy.setOnItemClickListener(
                //listen for user click
                new AdapterView.OnItemClickListener(){
                    @Override
                    //when any element is clicked
                    public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                        //name of element clicked will be stored in 'assignment'
                        String assignment = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, assignment, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
