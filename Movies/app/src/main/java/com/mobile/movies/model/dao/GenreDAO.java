package com.mobile.movies.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mobile.movies.model.vo.Genre;

/**
 * Created by Cristiane on 28/04/2017.
 */

public class GenreDAO {
    private SQLiteDatabase db;
    private BaseDAO baseDao;

    private String[] columns = {
            BaseDAO.GENRE_ID,
            BaseDAO.GENRE_NAME
    };

    public GenreDAO(Context context) {
        baseDao = new BaseDAO(context);
    }

    public void open() throws SQLException {
        baseDao.openDatabase();
        db = baseDao.getWritableDatabase();
    }

    public void close() {
        baseDao.close();
    }

    public Genre getGenreById(int id) {
        String where = BaseDAO.GENRE_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };

        open();

        Cursor c = db.query(BaseDAO.GENRE_TABLE_NAME, columns, where,
                whereArgs, null, null, null);

        c.moveToFirst();

        int idFound = c.getInt(c.getColumnIndex(BaseDAO.GENRE_ID));
        Log.i(BaseDAO.DB_LOG, "" + idFound);

        Genre genre = new Genre(
                c.getInt(c.getColumnIndex(BaseDAO.GENRE_ID)),
                c.getString(c.getColumnIndex(BaseDAO.GENRE_NAME)));

        c.close();
        close();
        return genre;
    }
}
