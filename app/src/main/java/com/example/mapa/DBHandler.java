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
    public static final String COLUMN_LOCATION = "locate";

    public DBHandler(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " +
                TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CATEGORY + " INTEGER, " +
                COLUMN_LOCATION + " TEXT)";

        db.execSQL(CREATE_TABLE);
        addStore("Cinnabon", "1", "T1 PB A-89", db);
        addStore("El Globo", "1", "T2 PA TS12", db);
        addStore("Garabatos", "1","T1 PB NA-144",  db);
        addStore("Cafe Punta del Cielo", "1", "T1 PB A-17", db);
        addStore("DotCom", "1","T1 PA 13 Y 14", db);
        addStore("Gloria Jean's Coffees", "1", "T1 PA SUES SN-03",db);
        addStore("Krispy Kreme", "1","T1 PA F-03 y T1 PB A-57", db);
        addStore("La Charamusquita Aeropuerto", "1","T1 PB A-95",db);
        addStore("La Vieja Molienda", "1","T2 PA TS11", db);
        addStore("Starbucks Coffee", "1","T1 PA S/N", db);

        addStore("Kdepor", "2","T1 PA NB32A", db);
        addStore("Boleria", "2", "T1 PB NA-134",db);
        addStore("Mucd", "2","T2 PB 10", db);
        addStore("La Riviera", "2", "T2 PA DUTY02",db);
        addStore("Mac", "2","T2 PA SUESIS15", db);
        addStore("Michael Kors", "2","T2 PA SUIES-IS-16", db);
        addStore("Farmacias Benavides", "2","T2 PB ALL03", db);
        addStore("Farmacias Similares", "2","T1 PA NB24", db);
        addStore("Daniel Espinosa", "2", "T1 PA 01.G-02",db);
        addStore("Joyeria Cielito Lindo", "2","T1 PA 13", db);

        addStore("Correos de Mexico", "3","T1 PB A-23", db);
        addStore("Redpack", "3","T2 PB ALL14", db);
        addStore("IpodMania", "3", "T1 PA 19",db);
        addStore("MOBO", "3","T1 PB E-1", db);
        addStore("Motorola", "3","T1 PB A-101", db);
        addStore("Na", "3","T1 PA NB42", db);
        addStore("Servicel", "3","T1 PA NB15", db);
        addStore("Telcel", "3","T1 PA CF7", db);

        addStore("Banamex", "4","T1 PA 2", db);
        addStore("Bancomer", "4","T1 PB E-11", db);
        addStore("Banorte", "4","T1 PB NA6", db);
        addStore("BBVA Bancomer", "4", "T2 PB ALL34",db);
        addStore("City Bank", "4","T1 PB S/N", db);
        addStore("HSBC", "4","T1 PB ALL08", db);
        addStore("Intercam", "4","T1 PA 1", db);
        addStore("Santander", "4","T1 PA 3", db);
        addStore("Scotiabank", "4","T1 PB F-6A", db);
        addStore("IXE", "4","T1 PA N-24", db);

        addStore("Aeromexico", "5", "PB",db);
        addStore("Air Canada", "5","T1 PB 153 a 159", db);
        addStore("Air France", "5", "T1 PB 124 a 137",db);
        addStore("Alaska", "5","T1 PB 147 a 151", db);
        addStore("American Airlines", "5","T1 PB 359 a 372", db);
        addStore("British Airways", "5","T1 PB 341 a 348", db);
        addStore("Iberia", "5", "T1 PB 334 a 342",db);
        addStore("Interjet", "5", "T1 PB 210 a 227",db);
        addStore("Lufthansa", "5","T1 PB 160 a 170", db);
        addStore("Volaris", "5","T1 PB B-1", db);

        addStore("Century XXI", "6","T1 PB E-01-02", db);
        addStore("Go Mexico", "6","T1 PA NB46", db);
        addStore("Mundo Joven", "6","T1 PB E-27", db);
        addStore("Viajes Kokai", "6", "T1 PB NA-149",db);
        addStore("SRE", "6","T1 PB AN134A", db);
        addStore("Camino Real", "6", "T2 PB ALL-37",db);
        addStore("Hotel Courtyard", "6", "T1 PA S/N",db);
        addStore("Hotel Geneve", "6","T2 PB ALL-44", db);
        addStore("Hotel Hilton", "6","T1 PB Hotel", db);
        addStore("Hotel Riazor", "6","T2 PB ALL49", db);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }



    public void addStore(String name, String category, String ubicacion, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_CATEGORY, category);
        contentValues.put(COLUMN_LOCATION, ubicacion);
        db.insert(TABLE, null, contentValues);

    }

    public Cursor retrieveStore(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
}
