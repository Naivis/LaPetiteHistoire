package com.example.rebierrequentin.lapetitehistoire.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MaBaseSQL extends SQLiteOpenHelper {

        private static final String TABLE_VEHICULE = "table_vehicule";
        private static final String COL_ID_VEHICULE = "id_vehicule";
        private static final String COL_NOM_VEHICULE ="nom_vehicule";
        private static final String COL_NIV_VEHICULE = "niveau_vehicule";
        private static final String COL_NIV_ROUES = "niveau_roues";
        private static final String COL_NIV_CARROSSERIE = "niveau_carrosserie";
        private static final String COL_NIV_MOTEUR = "niveau_moteur";
        private static final String COL_NIV_FREINS = "niveau_freins";
        private static final String COL_NIV_BOITE = "niveau_boite";

        private static final String TABLE_PRIXLEVELUP = "table_prix";
        private static final String COL_LEVEL_PLU = "plu_level";
        private static final String COL_PRIX_PLU ="plu_prix";
        private static final String COL_POINTS_PLU = "plu_points";

        private static final String TABLE_JOUEUR = "table_joueur";
        private static final String COL_ID_JOUEUR ="id_joueur";
        private static final String COL_NOM_JOUEUR = "nom_joueur";
        private static final String COL_NB_POINTS = "nombre_points";
        private static final String COL_NB_CLICS = "nombre_clics";
        private static final String COL_PROGRESS_BAR = "progress_bar";

        private static final String CREATE_BDD_VEHICULE = "CREATE TABLE " + TABLE_VEHICULE + " ("
                + COL_ID_VEHICULE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM_VEHICULE + " TEXT NOT NULL, "
                + COL_NIV_VEHICULE + " INTEGER, " + COL_NIV_ROUES + " INTEGER, " + COL_NIV_CARROSSERIE + " INTEGER, " + COL_NIV_MOTEUR
                + " INTEGER, " + COL_NIV_FREINS + " INTEGER, " + COL_NIV_BOITE + " INTEGER);";

        private static final String CREATE_BDD_LVLUP ="CREATE TABLE " + TABLE_PRIXLEVELUP + " ("
                + COL_LEVEL_PLU + " INTEGER PRIMARY KEY, " + COL_PRIX_PLU + " INTEGER, " + COL_POINTS_PLU + " INTEGER); ";

        private static final String CREATE_BDD_JOUEUR ="CREATE TABLE " + TABLE_JOUEUR + " ("
                + COL_ID_JOUEUR + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ID_VEHICULE + " INTEGER, "
                + COL_NOM_JOUEUR + " TEXT NOT NULL, " + COL_NB_POINTS + " INTEGER, " + COL_NB_CLICS + " INTEGER, " +  COL_PROGRESS_BAR + " INTEGER); ";

        public MaBaseSQL(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
            db.execSQL(CREATE_BDD_VEHICULE);
            db.execSQL(CREATE_BDD_LVLUP);
            db.execSQL(CREATE_BDD_JOUEUR);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
            //comme ça lorsque je change la version les id repartent de 0
            db.execSQL("DROP TABLE " + TABLE_VEHICULE + ";");
            db.execSQL("DROP TABLE " + TABLE_PRIXLEVELUP + ";");
            onCreate(db);
        }
    }
