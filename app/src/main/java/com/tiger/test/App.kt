package com.tiger.test

import android.app.Application
import android.util.Log
import com.github.gzuliyujiang.oaid.DeviceIdentifier
import com.jakewharton.processphoenix.ProcessPhoenix
import com.tiger.test.roomwordssample.WordRepository
import com.tiger.test.roomwordssample.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


public class App : Application() {

    val TAG = "Tiger"

    val applicationScope = CoroutineScope(SupervisorJob())

    val wordRoomDatabase by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }

    val wordRepository by lazy { WordRepository(wordRoomDatabase.wordDao()) }

    override fun onCreate() {
        super.onCreate()
        if (ProcessPhoenix.isPhoenixProcess(this)) {
            return;
        }

        DeviceIdentifier.register(this);
    }
}