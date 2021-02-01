package com.victor.data.model.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/victor/data/model/local/WeatherDao;", "", "addWeather", "", "weatherDTO", "Lcom/victor/data/model/WeatherDTO;", "(Lcom/victor/data/model/WeatherDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAllWeather", "Landroidx/lifecycle/LiveData;", "", "readWeatherFromCity", "citySearch", "", "data_debug"})
public abstract interface WeatherDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object addWeather(@org.jetbrains.annotations.NotNull()
    com.victor.data.model.WeatherDTO weatherDTO, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_table ORDER BY city ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.victor.data.model.WeatherDTO>> readAllWeather();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_table WHERE city LIKE :citySearch")
    public abstract androidx.lifecycle.LiveData<com.victor.data.model.WeatherDTO> readWeatherFromCity(@org.jetbrains.annotations.Nullable()
    java.lang.String citySearch);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}