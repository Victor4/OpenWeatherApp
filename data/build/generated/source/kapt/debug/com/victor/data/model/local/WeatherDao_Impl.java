package com.victor.data.model.local;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.victor.data.model.Util.DataConverter;
import com.victor.data.model.WeatherDTO;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherDTO> __insertionAdapterOfWeatherDTO;

  public WeatherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherDTO = new EntityInsertionAdapter<WeatherDTO>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather_table` (`city`,`weather`,`temp`,`minTemp`,`maxTemp`,`humidity`,`pressure`,`wind`,`sunrise`,`sunset`,`dayTime`,`cityCountry`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherDTO value) {
        if (value.getCity() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCity());
        }
        if (value.getWeather() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWeather());
        }
        if (value.getTemp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTemp());
        }
        if (value.getMinTemp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMinTemp());
        }
        if (value.getMaxTemp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMaxTemp());
        }
        if (value.getHumidity() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHumidity());
        }
        if (value.getPressure() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPressure());
        }
        if (value.getWind() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getWind());
        }
        final Long _tmp;
        _tmp = DataConverter.dateToTimestamp(value.getSunrise());
        if (_tmp == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = DataConverter.dateToTimestamp(value.getSunset());
        if (_tmp_1 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = DataConverter.dateToTimestamp(value.getDayTime());
        if (_tmp_2 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp_2);
        }
        if (value.getCityCountry() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCityCountry());
        }
      }
    };
  }

  @Override
  public Object addWeather(final WeatherDTO weatherDTO, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeatherDTO.insert(weatherDTO);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<WeatherDTO>> readAllWeather() {
    final String _sql = "SELECT * FROM weather_table ORDER BY city ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather_table"}, false, new Callable<List<WeatherDTO>>() {
      @Override
      public List<WeatherDTO> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfWeather = CursorUtil.getColumnIndexOrThrow(_cursor, "weather");
          final int _cursorIndexOfTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "temp");
          final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "minTemp");
          final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "maxTemp");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dayTime");
          final int _cursorIndexOfCityCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "cityCountry");
          final List<WeatherDTO> _result = new ArrayList<WeatherDTO>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WeatherDTO _item;
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpWeather;
            _tmpWeather = _cursor.getString(_cursorIndexOfWeather);
            final String _tmpTemp;
            _tmpTemp = _cursor.getString(_cursorIndexOfTemp);
            final String _tmpMinTemp;
            _tmpMinTemp = _cursor.getString(_cursorIndexOfMinTemp);
            final String _tmpMaxTemp;
            _tmpMaxTemp = _cursor.getString(_cursorIndexOfMaxTemp);
            final String _tmpHumidity;
            _tmpHumidity = _cursor.getString(_cursorIndexOfHumidity);
            final String _tmpPressure;
            _tmpPressure = _cursor.getString(_cursorIndexOfPressure);
            final String _tmpWind;
            _tmpWind = _cursor.getString(_cursorIndexOfWind);
            final Date _tmpSunrise;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = DataConverter.fromTimestamp(_tmp);
            final Date _tmpSunset;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = DataConverter.fromTimestamp(_tmp_1);
            final Date _tmpDayTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDayTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDayTime);
            }
            _tmpDayTime = DataConverter.fromTimestamp(_tmp_2);
            final String _tmpCityCountry;
            _tmpCityCountry = _cursor.getString(_cursorIndexOfCityCountry);
            _item = new WeatherDTO(_tmpCity,_tmpWeather,_tmpTemp,_tmpMinTemp,_tmpMaxTemp,_tmpHumidity,_tmpPressure,_tmpWind,_tmpSunrise,_tmpSunset,_tmpDayTime,_tmpCityCountry);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<WeatherDTO> readWeatherFromCity(final String citySearch) {
    final String _sql = "SELECT * FROM weather_table WHERE city LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (citySearch == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, citySearch);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather_table"}, false, new Callable<WeatherDTO>() {
      @Override
      public WeatherDTO call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfWeather = CursorUtil.getColumnIndexOrThrow(_cursor, "weather");
          final int _cursorIndexOfTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "temp");
          final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "minTemp");
          final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "maxTemp");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfDayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "dayTime");
          final int _cursorIndexOfCityCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "cityCountry");
          final WeatherDTO _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpWeather;
            _tmpWeather = _cursor.getString(_cursorIndexOfWeather);
            final String _tmpTemp;
            _tmpTemp = _cursor.getString(_cursorIndexOfTemp);
            final String _tmpMinTemp;
            _tmpMinTemp = _cursor.getString(_cursorIndexOfMinTemp);
            final String _tmpMaxTemp;
            _tmpMaxTemp = _cursor.getString(_cursorIndexOfMaxTemp);
            final String _tmpHumidity;
            _tmpHumidity = _cursor.getString(_cursorIndexOfHumidity);
            final String _tmpPressure;
            _tmpPressure = _cursor.getString(_cursorIndexOfPressure);
            final String _tmpWind;
            _tmpWind = _cursor.getString(_cursorIndexOfWind);
            final Date _tmpSunrise;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfSunrise)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfSunrise);
            }
            _tmpSunrise = DataConverter.fromTimestamp(_tmp);
            final Date _tmpSunset;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfSunset)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfSunset);
            }
            _tmpSunset = DataConverter.fromTimestamp(_tmp_1);
            final Date _tmpDayTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDayTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDayTime);
            }
            _tmpDayTime = DataConverter.fromTimestamp(_tmp_2);
            final String _tmpCityCountry;
            _tmpCityCountry = _cursor.getString(_cursorIndexOfCityCountry);
            _result = new WeatherDTO(_tmpCity,_tmpWeather,_tmpTemp,_tmpMinTemp,_tmpMaxTemp,_tmpHumidity,_tmpPressure,_tmpWind,_tmpSunrise,_tmpSunset,_tmpDayTime,_tmpCityCountry);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
