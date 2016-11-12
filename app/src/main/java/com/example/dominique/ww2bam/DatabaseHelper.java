package com.example.dominique.ww2bam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.IntegerRes;

/**
 * Created by Dominique on 09/11/2016.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Questions.db";


    public static final String TABLE_NAME = "question_table";
    public static final String COL_id = "ID";
    public static final String COL_question= "QUESTION";
    public static final String COL_level = "LEVEL";
    public static final String COL_ANSWER1= "ANSWER1";
    public static final String COL_ANSWER2 = "ANSWER2";
    public static final String COL_ANSWER3= "ANSWER3";
    public static final String COL_ANSWER4 = "ANSWER4";
    public static final String COL_CORRECT = "CORRECT";
    public static final String COL_flag = "FLAG"; //SET VALUE TO 1 IF GAMIT NA



    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,QUESTION TEXT,LEVEL INTEGER, ANSWER1 TEXT,ANSWER2 TEXT" +
                ",ANSWER3 TEXT,ANSWER4 TEXT, FLAG INTEGER, CORRECT INTEGER )");
        getQuestions(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void getQuestions(SQLiteDatabase db) {

        // CONTENT VALUES FOR QUESTION NUMBER 1!!!
  /*  ContentValues question= new ContentValues();*/
        ContentValues answer = new ContentValues();
        //QUESTION #1 (FOR LEVEL1)

        answer.put(COL_question,"Maganda ba ako?");
        answer.put(COL_level,1);

        //ANSWERS FOR QUESTION #1

        // answer.put(COL2_type,1); // 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
        answer.put(COL_ANSWER1,"OO");


        // answer.put(COL2_question_id,1);
        // answer.put(COL2_type,0); // 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
        answer.put(COL_ANSWER2,"HINDI");


    /*answer.put(COL2_question_id,1);
    answer.put(COL2_type,0);*/ // 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
        answer.put(COL_ANSWER3,"MAYBE");

/*
    answer.put(COL2_question_id,1);
    answer.put(COL2_type,0);*/ // 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
        answer.put(COL_ANSWER4,"IN GOD'S TIME");



/*
        answer.clear();*/
       ContentValues answer2 = new ContentValues();
        answer2.put(COL_question,"POGI BA SI JOSHUA MACUJA?");
        answer2.put(COL_level,1);
        // CONTENT VALUES FOR QUESTION NUMBER 2!!!
/*    ContentValues question2= new ContentValues();
    ContentValues answer2 = new ContentValues();
    //QUESTION #2 (FOR LEVEL1)

    question2.put(COL_question,"POGI BA SI JOSHUA MACUJA?");
    question2.put(COL_level,1);*/

        //ANSWERS FOR QUESTION #2

   // 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
    answer2.put(COL_ANSWER1,"OO");


 // 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
    answer2.put(COL_ANSWER2,"HINDI");


// 1 FOR CORRECT ANSWER 0 FOR WRONG ANSWER
    answer2.put(COL_ANSWER3,"MAYBE");



    answer2.put(COL_ANSWER4,"IN GOD'S TIME");


     //   long q1 = db.insert(TABLE_NAME, null, answer);
      //  long q2 = db.insert(TABLE_NAME, null, answer2);
        //long q2 = db.insert(TABLE_NAME, null, answer2);
/*    long a1 = db.insert(TABLE_NAME2, null, answer);*/
        //  long q2 = db.insert(TABLE_NAME, null, question2);
    /*long a2 = db.insert(TABLE_NAME2, null, answer2);*/

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

  /*  public Cursor getAllAnswer() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res2 = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res2;
    }*/
}
