package com.mobile.movies.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mobile.movies.model.vo.Country;

/**
 * Created by Cristiane on 28/04/2017.
 */

public class CountryDAO {
    private SQLiteDatabase db;
    private BaseDAO baseDao;

    private String[] columns = {
            BaseDAO.COUNTRY_ID,
            BaseDAO.COUNTRY_NAME
    };

    public CountryDAO(Context context) {
        baseDao = new BaseDAO(context);
    }

    public void open() throws SQLException {
        baseDao.openDatabase();
        db = baseDao.getWritableDatabase();
    }

    public void close() {
        baseDao.close();
    }

    public Country searchById(int id) {
        String where = BaseDAO.COUNTRY_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };

        open();

        Cursor c = db.query(BaseDAO.COUNTRY_TABLE_NAME, columns, where,
                whereArgs, null, null, null);

        c.moveToFirst();

        int idFound = c.getInt(c.getColumnIndex(BaseDAO.COUNTRY_ID));
        Log.i(BaseDAO.DB_LOG, "" + idFound);

        Country category = new Country(
                c.getInt(c.getColumnIndex(BaseDAO.COUNTRY_ID)),
                c.getString(c.getColumnIndex(BaseDAO.COUNTRY_NAME)));

        c.close();
        close();
        return category;
    }
}
