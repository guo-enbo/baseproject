package com.guoenbo.library.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.guoenbo.library.db.DBAccess;


/**
 * @author guoenbo
 * @date:2015-8-20
 * @Desc:
 * @version :
 * 
 */

public class BaseDao {

	protected DBAccess mDBAccess;
	protected SQLiteDatabase db = null;
	protected Cursor cursor = null;
	protected String TableName = null;

	public BaseDao(Context context){
		mDBAccess = new DBAccess(context);
	}

	protected String CursorToString(String key){
		String value = cursor.getString(cursor.getColumnIndex(key));
		return value;
	}

	protected int CursorToInt(String key){
		int value = cursor.getInt(cursor.getColumnIndex(key));
		return value;
	}

	protected long CursorToLong(String key){
		long value = cursor.getLong(cursor.getColumnIndex(key));
		return value;
	}

	protected double CursorToDouble(String key){
		double value = cursor.getDouble(cursor.getColumnIndex(key));
		return value;
	}

	protected float CursorToFloat(String key){
		float value = cursor.getFloat(cursor.getColumnIndex(key));
		return value;
	}

	protected byte[] CursorToBlob(String key){
		byte[] value = cursor.getBlob(cursor.getColumnIndex(key));
		return value;
	}

	
	
}
