package com.example.ifarm

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class IFarmDB(contex: Context) :
    ManagedSQLiteOpenHelper(ctx = contex, name = "ifarm.db", version = 1) {

    companion object {
        private var instance: IFarmDB? = null

        @Synchronized
        fun getInstance(ctx: Context): IFarmDB {
            if (instance == null) {
                instance = IFarmDB(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("duvida", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "duvida" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}

val Context.database: IFarmDB
    get() = IFarmDB.getInstance(getApplicationContext())