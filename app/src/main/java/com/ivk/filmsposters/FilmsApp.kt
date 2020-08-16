package com.ivk.filmsposters

import android.app.Application
import com.ivk.filmsposters.db.DataBaseModule
import com.ivk.filmsposters.db.FilmsDb

class FilmsApp : Application() {
    private lateinit var db : FilmsDb

    companion object {

        @JvmField
        var appInstance: FilmsApp? = null



        @JvmStatic fun getAppInstance(): FilmsApp {
            return appInstance as FilmsApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        createDb()
    }

    private fun createDb(){
        db = DataBaseModule().provideDb(this)
    }

    fun getDbInstance() : FilmsDb {
        return if(::db.isInitialized){
            db
        } else {
            createDb()
            db
        }
    }
}