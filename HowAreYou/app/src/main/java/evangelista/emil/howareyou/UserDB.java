package evangelista.emil.howareyou;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDB extends SQLiteOpenHelper {

   /** Database name */
   private static String DBNAME = "UserInfo";

   /** Version number of the database */
   private static int VERSION = 1;

   /** Field 1 of the table locations, which is the primary key */
   public static final String FIELD_ROW_ID = "_id";

   /** Field 2 of the table locations, stores the title*/
   public static final String FIELD_TITLE = "title";

   /** Field 3 of the table locations, stores the longitude*/
   public static final String FIELD_DESCRIPTION = "descr";

   /** Field 4 of the table locations, stores the zoom level of map*/
   public static final String FIELD_RATING = "rating";

   /** A constant, stores the the table name */
   private static final String DATABASE_TABLE = "uInfo";

   /** An instance variable for SQLiteDatabase */
   private SQLiteDatabase mDB;

   /** Constructor */
   public UserDB(Context context) {
      super(context, DBNAME, null, VERSION);
      this.mDB = getWritableDatabase();
   }

   /** This is a callback method, invoked when the method getReadableDatabase() / getWritableDatabase() is called
    * provided the database does not exists
    * */
   @Override
   public void onCreate(SQLiteDatabase db) {
      String sql =     "create table " + DATABASE_TABLE + " ( " +
              FIELD_ROW_ID + " integer primary key autoincrement , " +
              FIELD_TITLE + " double , " +
              FIELD_DESCRIPTION + " double , " +
              FIELD_RATING + " text " +
              " ) ";

      db.execSQL(sql);
   }

   /** Inserts a new location to the table locations */
   public long insert(ContentValues contentValues){
      long rowID = mDB.insert(DATABASE_TABLE, null, contentValues);
      return rowID;
   }

   /** Deletes all locations from the table */
   public int del(){
      int cnt = mDB.delete(DATABASE_TABLE, null , null);
      return cnt;
   }

   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   }

}
