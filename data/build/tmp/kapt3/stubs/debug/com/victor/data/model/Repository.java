package com.victor.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/victor/data/model/Repository;", "", "()V", "Local", "Remote", "data_debug"})
public final class Repository {
    
    public Repository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/victor/data/model/Repository$Remote;", "", "(Lcom/victor/data/model/Repository;)V", "getWeatherFrom", "Lretrofit2/Response;", "Lcom/victor/data/model/remote/model/WeatherResponse;", "city", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
    public final class Remote {
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getWeatherFrom(@org.jetbrains.annotations.NotNull()
        java.lang.String city, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super retrofit2.Response<com.victor.data.model.remote.model.WeatherResponse>> p1) {
            return null;
        }
        
        public Remote() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/victor/data/model/Repository$Local;", "", "weatherDao", "Lcom/victor/data/model/local/WeatherDao;", "(Lcom/victor/data/model/Repository;Lcom/victor/data/model/local/WeatherDao;)V", "readAllWeather", "Landroidx/lifecycle/LiveData;", "", "Lcom/victor/data/model/WeatherDTO;", "getReadAllWeather", "()Landroidx/lifecycle/LiveData;", "addWeather", "", "weatherDTO", "(Lcom/victor/data/model/WeatherDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
    public final class Local {
        @org.jetbrains.annotations.NotNull()
        private final androidx.lifecycle.LiveData<java.util.List<com.victor.data.model.WeatherDTO>> readAllWeather = null;
        private final com.victor.data.model.local.WeatherDao weatherDao = null;
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.LiveData<java.util.List<com.victor.data.model.WeatherDTO>> getReadAllWeather() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object addWeather(@org.jetbrains.annotations.NotNull()
        com.victor.data.model.WeatherDTO weatherDTO, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
            return null;
        }
        
        public Local(@org.jetbrains.annotations.NotNull()
        com.victor.data.model.local.WeatherDao weatherDao) {
            super();
        }
    }
}