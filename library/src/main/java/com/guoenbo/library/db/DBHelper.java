package com.guoenbo.library.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{

	public static String DATABASE_NAME = "download.db";
	public static String TABLE_DOWNLOAD_INFO = "download_info";
	public static String TABLE_LOCALDOWN_INFO = "localdown_info";
	private static int version = 1;

	public DBHelper(Context context)
	{
		super(context, DATABASE_NAME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		/*db.execSQL("create table "+TABLE_DOWNLOAD_INFO+"(" +
				"_id integer PRIMARY KEY AUTOINCREMENT," +
				"thread_id integer," +
				"start_pos integer," +
				"end_pos integer," +
				"compelete_size integer," +
				"url varchar(50))");
		
		db.execSQL("create table "+TABLE_LOCALDOWN_INFO+"(" +
				"_id integer PRIMARY KEY AUTOINCREMENT," +
				"name varchar(30)," +
				"url varchar(50)," +
				"completeSize integer," +
				"fileSize integer," +
				"status integer)");*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		/*String sql = "drop table if exists "+TABLE_DOWNLOAD_INFO+"";
		String sqlOne = "drop table if exists "+TABLE_LOCALDOWN_INFO+"";
		db.execSQL(sql);
		db.execSQL(sqlOne);
		onCreate(db);*/
	}

}
