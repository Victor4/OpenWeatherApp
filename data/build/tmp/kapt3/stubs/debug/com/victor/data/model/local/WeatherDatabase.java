package com.victor.data.model.local;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.victor.data.model.Util.DataConverter.class})
@androidx.room.Database(entities = {com.victor.data.model.WeatherDTO.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/victor/data/model/local/WeatherDatabase;", "Landroidx/room/RoomDatabase;", "()V", "weatherDao", "Lcom/victor/data/model/local/WeatherDao;", "Companion", "data_debug"})
public abstract class WeatherDatabase extends androidx.room.RoomDatabase {
    private static final java.lang.String NAME_DATABASE = "weather_database";
    private static volatile com.victor.data.model.local.WeatherDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.victor.data.model.local.WeatherDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.victor.data.model.local.WeatherDao weatherDao();
    
    public WeatherDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/victor/data/model/local/WeatherDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/victor/data/model/local/WeatherDatabase;", "NAME_DATABASE", "", "getDatabase", "context", "Landroid/content/Context;", "data_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.victor.data.model.local.WeatherDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}