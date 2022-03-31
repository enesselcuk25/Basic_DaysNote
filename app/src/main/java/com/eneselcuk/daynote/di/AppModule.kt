package com.eneselcuk.daynote.di

import android.app.Application
import com.eneselcuk.daynote.data.NoteDao
import com.eneselcuk.daynote.data.NoteDatabase
import com.eneselcuk.daynote.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(natDao: NoteDao)=NoteRepository(natDao)

    @Singleton
    @Provides
    fun provideDatabase(context: Application):NoteDatabase {
        return NoteDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideDao(noteDatabase: NoteDatabase):NoteDao{
        return noteDatabase.noteDao()
    }
}