package com.guoenbo.library.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author guoenbo
 * @date:2015-8-20 
 * @Desc: 数据库操作类
 * @version :
 * 
 */
public class DBAccess {

	private DBHelper dbHelper;

	private Context _context;

	public DBAccess(Context context) {
		_context = context;
		dbHelper = new DBHelper(_context);
	}
	
	public void beginTrans(SQLiteDatabase db){
		db.beginTransaction();
	}
	
	public void commitTrans(SQLiteDatabase db){
		db.setTransactionSuccessful();
	}
	
	public void endTrans(SQLiteDatabase db){
		db.endTransaction();
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public void execSql(SQLiteDatabase db, String sql, Object[] params) throws SQLException {
		Log.d(" execSql sql => ", sql);
		db.execSQL(sql, params);
	}

	/**
	 * 查询sql
	 * 
	 * @param sql
	 * @return Cursor
	 * @throws SQLException
	 */
	public Cursor queryBysql(SQLiteDatabase db, String sql, String[] params) throws SQLException {
		Cursor c = null;
		c = db.rawQuery(sql, params);
		Log.d(" queryBysql sql => ", sql);
		return c;
	}

	/**
	 * 查询全部
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public Cursor queryAll(SQLiteDatabase db, String tableName) throws SQLException {
		Cursor cursor = null;
		cursor = db.query(tableName, null, null, null, null, null, null);
		return cursor;
	}
	
	/**
	 * 复杂查询
	 * @param tableName
	 * @param columns
	 * @param selection
	 * @param selectionArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @param limit
	 * @return
	 * @throws SQLException
	 */
	public Cursor query(SQLiteDatabase db, String tableName, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy, String limit) throws SQLException{
		Cursor cursor = null;
		cursor = db.query(tableName, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		return cursor;
	}

	/**
	 * 插入操作
	 * 
	 * @param tableName
	 * @param values
	 * @throws SQLException
	 */
	public void insert(SQLiteDatabase db, String tableName, ContentValues values) throws SQLException {
		db.insert(tableName, null, values);
		Log.d(" insert sql => ", tableName);
	}

	/**
	 * 插入操作
	 * 
	 * @param tableName
	 * @param values
	 * @throws SQLException
	 */
	public long insertResult(SQLiteDatabase db, String tableName, ContentValues values) throws SQLException {
		return db.insert(tableName, null, values);
	}
	
	/**
	 * 删除操作
	 * 
	 * @param tableName
	 * @param whereParam
	 * @param whereValue
	 */
	public void delete(SQLiteDatabase db, String tableName, String whereParam, String[] whereValue) throws SQLException {
		db.delete(tableName, whereParam, whereValue);
		Log.d(" delete sql => ", tableName);
	}
	
	/**
	 * 删除操作
	 * 
	 * @param tableName
	 * @param whereParam
	 * @param whereValue
	 */
	public long deleteResult(SQLiteDatabase db, String tableName, String whereParam, String[] whereValue) throws SQLException {
		Log.d(" delete sql => ", tableName);
		return db.delete(tableName, whereParam, whereValue);
		
	}
	
	/**
	 * 更新操作
	 * 
	 * @param tableName
	 * @param values
	 * @param whereParam
	 * @param whereValue
	 * @throws SQLException
	 */
	public void update(SQLiteDatabase db, String tableName, ContentValues values, String whereParam, String[] whereValue)
			throws SQLException {
		db.update(tableName, values, whereParam, whereValue);
	}
	
	public SQLiteDatabase open(){
		return dbHelper.getWritableDatabase();
	}
	
	public SQLiteDatabase openRead(){
		return dbHelper.getReadableDatabase();
	}
	/**
	 * 关闭数据库
	 */
	public void close(SQLiteDatabase db){
		if(db != null){
			db.close();
			db = null;
		}
	}

}
