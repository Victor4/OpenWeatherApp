package com.victor.data.model.remote.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0019J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0014H\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\fH\u00c6\u0003J\t\u00104\u001a\u00020\bH\u00c6\u0003J\t\u00105\u001a\u00020\fH\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\bH\u00c6\u0003J\t\u00108\u001a\u00020\nH\u00c6\u0003J\t\u00109\u001a\u00020\fH\u00c6\u0003J\t\u0010:\u001a\u00020\u000eH\u00c6\u0003J\t\u0010;\u001a\u00020\u0010H\u00c6\u0003J\t\u0010<\u001a\u00020\fH\u00c6\u0003J\t\u0010=\u001a\u00020\fH\u00c6\u0003J\u009b\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\fH\u00c6\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010B\u001a\u00020\fH\u00d6\u0001J\t\u0010C\u001a\u00020\bH\u00d6\u0001R\u0016\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0012\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0017\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006D"}, d2 = {"Lcom/victor/data/model/remote/model/WeatherResponse;", "", "coord", "Lcom/victor/data/model/remote/model/CoordInfo;", "weatherInfo", "", "Lcom/victor/data/model/remote/model/WeatherInfo;", "base", "", "main", "Lcom/victor/data/model/remote/model/MainInfo;", "visibility", "", "windInfo", "Lcom/victor/data/model/remote/model/WindInfo;", "cloudsInfo", "Lcom/victor/data/model/remote/model/CloudsInfo;", "all", "dt", "sys", "Lcom/victor/data/model/remote/SysInfo;", "timezone", "id", "name", "cod", "(Lcom/victor/data/model/remote/model/CoordInfo;Ljava/util/List;Ljava/lang/String;Lcom/victor/data/model/remote/model/MainInfo;ILcom/victor/data/model/remote/model/WindInfo;Lcom/victor/data/model/remote/model/CloudsInfo;IILcom/victor/data/model/remote/SysInfo;IILjava/lang/String;I)V", "getAll", "()I", "getBase", "()Ljava/lang/String;", "getCloudsInfo", "()Lcom/victor/data/model/remote/model/CloudsInfo;", "getCod", "getCoord", "()Lcom/victor/data/model/remote/model/CoordInfo;", "getDt", "getId", "getMain", "()Lcom/victor/data/model/remote/model/MainInfo;", "getName", "getSys", "()Lcom/victor/data/model/remote/SysInfo;", "getTimezone", "getVisibility", "getWeatherInfo", "()Ljava/util/List;", "getWindInfo", "()Lcom/victor/data/model/remote/model/WindInfo;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class WeatherResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "coord")
    private final com.victor.data.model.remote.model.CoordInfo coord = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "weather")
    private final java.util.List<com.victor.data.model.remote.model.WeatherInfo> weatherInfo = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "base")
    private final java.lang.String base = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "main")
    private final com.victor.data.model.remote.model.MainInfo main = null;
    @com.google.gson.annotations.SerializedName(value = "visibility")
    private final int visibility = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "wind")
    private final com.victor.data.model.remote.model.WindInfo windInfo = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "clouds")
    private final com.victor.data.model.remote.model.CloudsInfo cloudsInfo = null;
    @com.google.gson.annotations.SerializedName(value = "all")
    private final int all = 0;
    @com.google.gson.annotations.SerializedName(value = "dt")
    private final int dt = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "sys")
    private final com.victor.data.model.remote.SysInfo sys = null;
    @com.google.gson.annotations.SerializedName(value = "timezone")
    private final int timezone = 0;
    @com.google.gson.annotations.SerializedName(value = "id")
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String name = null;
    @com.google.gson.annotations.SerializedName(value = "cod")
    private final int cod = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.CoordInfo getCoord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.victor.data.model.remote.model.WeatherInfo> getWeatherInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.MainInfo getMain() {
        return null;
    }
    
    public final int getVisibility() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.WindInfo getWindInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.CloudsInfo getCloudsInfo() {
        return null;
    }
    
    public final int getAll() {
        return 0;
    }
    
    public final int getDt() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.SysInfo getSys() {
        return null;
    }
    
    public final int getTimezone() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final int getCod() {
        return 0;
    }
    
    public WeatherResponse(@org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.CoordInfo coord, @org.jetbrains.annotations.NotNull()
    java.util.List<com.victor.data.model.remote.model.WeatherInfo> weatherInfo, @org.jetbrains.annotations.NotNull()
    java.lang.String base, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.MainInfo main, int visibility, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.WindInfo windInfo, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.CloudsInfo cloudsInfo, int all, int dt, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.SysInfo sys, int timezone, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int cod) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.CoordInfo component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.victor.data.model.remote.model.WeatherInfo> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.MainInfo component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.WindInfo component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.CloudsInfo component7() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.SysInfo component10() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.victor.data.model.remote.model.WeatherResponse copy(@org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.CoordInfo coord, @org.jetbrains.annotations.NotNull()
    java.util.List<com.victor.data.model.remote.model.WeatherInfo> weatherInfo, @org.jetbrains.annotations.NotNull()
    java.lang.String base, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.MainInfo main, int visibility, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.WindInfo windInfo, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.model.CloudsInfo cloudsInfo, int all, int dt, @org.jetbrains.annotations.NotNull()
    com.victor.data.model.remote.SysInfo sys, int timezone, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int cod) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}