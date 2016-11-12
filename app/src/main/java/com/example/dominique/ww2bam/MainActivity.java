package com.example.dominique.ww2bam;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.os.Build.ID;


public class MainActivity extends AppCompatActivity {

    TextView view;
    DatabaseHelper myDb;
    SQLiteDatabase db;
    ArrayList<Question> questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        view = (TextView)findViewById(R.id.view);
        db=myDb.getWritableDatabase();
        questionList=new ArrayList<Question>();
    }



    public void mgaTanong (View v){

        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
           // Question Q=new Question();
            String id = res.getString(res.getColumnIndex(myDb.COL_id));
            String question = res.getString(res.getColumnIndex(myDb.COL_question));
            String level = res.getString(res.getColumnIndex(myDb.COL_level));
            String answer1 = res.getString(res.getColumnIndex(myDb.COL_ANSWER1));
            String answer2 = res.getString(res.getColumnIndex(myDb.COL_ANSWER2));
            String answer3 = res.getString(res.getColumnIndex(myDb.COL_ANSWER3));
            String answer4 = res.getString(res.getColumnIndex(myDb.COL_ANSWER4));
            String correct = res.getString(res.getColumnIndex(myDb.COL_CORRECT));
            String flag = res.getString(res.getColumnIndex(myDb.COL_flag));


            // Set
            Question q = new Question();
            q.setID(Integer.valueOf(id));
            q.setQuestion(question);
            q.setLevel(Integer.valueOf(level));
            q.setAnswer1(answer1);
            q.setAnswer2(answer2);
            q.setAnswer3(answer3);
            q.setAnswer4(answer4);
            q.setCorrect(Integer.valueOf(correct));
            q.setFlag(Integer.valueOf(flag));

            // ArrayList
            questionList.add(q);

        }


        //Display Questions
       for(int i = 0; i <questionList.size(); i++){
            //System.out.println(questionList.get(i));
            buffer.append("Id :"+questionList.get(i).getID() +"\n");
            buffer.append("Question :"+ questionList.get(i).getQuestion()+"\n");
            buffer.append("A. :"+ questionList.get(i).getAnswer1()+"\n");
            buffer.append("B. :"+ questionList.get(i).getAnswer2()+"\n");
            buffer.append("C. :"+ questionList.get(i).getAnswer3()+"\n");
            buffer.append("D. :"+ questionList.get(i).getAnswer4()+"\n");
            buffer.append("Correct :"+ questionList.get(i).getCorrect()+"\n");
            buffer.append("Flag :"+ questionList.get(i).getFlag()+"\n");

        }

        showMessage("Data",buffer.toString());
        // Show all data

   }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
       // view.setText(Message);
        builder.show();
    }
}
