package com.example.mapa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "storesDB.db";

    public static final String TABLE = "stores";
    public static final String COLUMN_ID = "storeid";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "categeory";

    public DBHandler(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CRATE_TABLE = "CREATE TABLE " +
                TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CATEGORY + " INTEGER)";

        db.execSQL(CRATE_TABLE);
        addStore("Cinnabon", "1", db);
        addStore("El Globo", "1", db);
        addStore("Garabatos", "1", db);
        addStore("Cafe Punta del Cielo", "1", db);
        addStore("DotCom", "1", db);
        addStore("Gloia Jean's Coffees", "1", db);
        addStore("Krispy Kreme", "1", db);
        addStore("La Charamusquita Aeropuerto", "1", db);
        addStore("La Vieja Molienda", "1", db);
        addStore("Starbucks Coffee", "1", db);

        addStore("Kdepor", "2", db);
        addStore("Boleria", "2", db);
        addStore("Mucd", "2", db);
        addStore("La Riviera", "2", db);
        addStore("Mac", "2", db);
        addStore("Michael Kors", "2", db);
        addStore("Farmacias Benavides", "2", db);
        addStore("Farmacias Similares", "2", db);
        addStore("Daniel Espinosa", "2", db);
        addStore("Joyeria Cielito Lindo", "2", db);

        addStore("Correos de Mexico", "3", db);
        addStore("Redpack", "3", db);
        addStore("IpodMania", "3", db);
        addStore("MOBO", "3", db);
        addStore("Motorola", "3", db);
        addStore("Na", "3", db);
        addStore("Servicel", "3", db);
        addStore("Telcel", "3", db);

        addStore("Banamex", "4", db);
        addStore("Bancomer", "4", db);
        addStore("Banorte", "4", db);
        addStore("BBVA Bancomer", "4", db);
        addStore("City Bank", "4", db);
        addStore("HSBC", "4", db);
        addStore("Intercam", "4", db);
        addStore("Santander", "4", db);
        addStore("Scotiabank", "4", db);
        addStore("IXE", "4", db);

        addStore("Aeromexico", "5", db);
        addStore("Air Canada", "5", db);
        addStore("Air France", "5", db);
        addStore("Alaska", "5", db);
        addStore("American Airlines", "5", db);
        addStore("British Airways", "5", db);
        addStore("Iberia", "5", db);
        addStore("Interjet", "5", db);
        addStore("Lufthansa", "5", db);
        addStore("Volaris", "5", db);

        addStore("Century XXI", "6", db);
        addStore("Go Mexico", "6", db);
        addStore("Mundo Joven", "6", db);
        addStore("Viajes Kokai", "6", db);
        addStore("SRE", "6", db);
        addStore("Camino Real", "6", db);
        addStore("Hotel Courtyard", "6", db);
        addStore("Hotel Geneve", "6", db);
        addStore("Hotel Hilton", "6", db);
        addStore("Hotel Riazor", "6", db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }



    public void addStore(String name, String category, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_CATEGORY, category);
        db.insert(TABLE, null, contentValues);

    }

    public Cursor retrieveStore(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}
