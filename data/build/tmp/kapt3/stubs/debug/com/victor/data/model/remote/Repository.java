package com.victor.data.model.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/victor/data/model/remote/Repository;", "", "()V", "Local", "Remote", "data_debug"})
public final class Repository {
    
    public Repository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/victor/data/model/remote/Repository$Remote;", "", "(Lcom/victor/data/model/remote/Repository;)V", "getWeatherFrom", "Lretrofit2/Response;", "Lcom/victor/data/model/remote/model/WeatherResponse;", "city", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
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
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/victor/data/model/remote/Repository$Local;", "", "weatherDao", "Lcom/victor/data/model/local/WeatherDao;", "city", "", "(Lcom/victor/data/model/remote/Repository;Lcom/victor/data/model/local/WeatherDao;Ljava/lang/String;)V", "readAllWeather", "Landroidx/lifecycle/LiveData;", "", "Lcom/victor/data/model/WeatherDTO;", "getReadAllWeather", "()Landroidx/lifecycle/LiveData;", "addWeather", "", "weatherDTO", "(Lcom/victor/data/model/WeatherDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
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
        com.victor.data.model.local.WeatherDao weatherDao, @org.jetbrains.annotations.Nullable()
        java.lang.String city) {
            super();
        }
    }
}