package com.example.rebierrequentin.lapetitehistoire.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MaBaseSQL extends SQLiteOpenHelper {

        private static final String TABLE_HISTOIRE = "table_histoire";
        private static final String COL_ID_HISTOIRE = "id_histoire";
        private static final String COL_NOM_HISTOIRE ="nom_histoire";
        private static final String COL_TXT_HISTOIRE = "txt_histoire";
        private static final String COL_DUREE_HISTOIRE = "duree_histoire";
        private static final String COL_FAV_HISTOIRE = "fav_histoire";


        private static final String CREATE_BDD_HISTOIRE = "CREATE TABLE " + TABLE_HISTOIRE + " ("
                + COL_ID_HISTOIRE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM_HISTOIRE + " TEXT NOT NULL, "
                + COL_TXT_HISTOIRE + " TEXT NOT NULL, " + COL_DUREE_HISTOIRE + " INTEGER, " + COL_FAV_HISTOIRE + " BOOLEAN);";


        public MaBaseSQL(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
            db.execSQL(CREATE_BDD_HISTOIRE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
            //comme ça lorsque je change la version les id repartent de 0
            db.execSQL("DROP TABLE " + TABLE_HISTOIRE + ";");
            onCreate(db);
        }
    }
