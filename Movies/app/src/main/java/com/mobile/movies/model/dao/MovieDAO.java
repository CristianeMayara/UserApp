package com.mobile.movies.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mobile.movies.model.vo.Movie;

import java.util.ArrayList;

/**
 * Created by Cristiane on 28/04/2017.
 */

public class MovieDAO {
    private SQLiteDatabase db;
    private BaseDAO baseDao;

    private String[] columns = {
            BaseDAO.MOVIE_ID,
            BaseDAO.MOVIE_NAME,
            BaseDAO.MOVIE_ORIGINALNAME,
            BaseDAO.MOVIE_GENRE,
            BaseDAO.MOVIE_SYNOPSIS,
            BaseDAO.MOVIE_DIRECTOR,
            BaseDAO.MOVIE_CAST,
            BaseDAO.MOVIE_COUNTRY,
            BaseDAO.MOVIE_YEAR,
            BaseDAO.MOVIE_RUNTIME,
            BaseDAO.MOVIE_ISFAVORITE
    };

    public MovieDAO(Context context) {
        baseDao = new BaseDAO(context);
    }

    public void open() throws SQLException {
        baseDao.openDatabase();
        db = baseDao.getWritableDatabase();
    }

    public void close() {
        baseDao.close();
    }

    public void getMovieById(int id) {
        String where = BaseDAO.MOVIE_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };

        open();

        Cursor c = db.query(BaseDAO.MOVIE_TABLE_NAME, columns, where,
                whereArgs, null, null, null);

        c.moveToFirst();

        int idFound = c.getInt(c.getColumnIndex(BaseDAO.MOVIE_ID));

        c.close();
        close();

        Log.i(BaseDAO.DB_LOG, "" + idFound);
    }

    public ArrayList<Movie> getMovieList() {

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        Movie movie;

        open();
        Cursor c = db.query(BaseDAO.MOVIE_TABLE_NAME, columns, null, null,
                null, null, null);

        if (c.moveToFirst()) {
            do {
                Log.d(BaseDAO.DB_LOG,
                        "id: " + c.getString(c.getColumnIndex("id")));

                movie = new Movie(
                        c.getInt(c.getColumnIndex(BaseDAO.MOVIE_ID)),
                        c.getString(c.getColumnIndex(BaseDAO.MOVIE_NAME)),
                        c.getString(c.getColumnIndex(BaseDAO.MOVIE_ORIGINALNAME)),
                        c.getInt(c.getColumnIndex(BaseDAO.MOVIE_GENRE)),
                        c.getString(c.getColumnIndex(BaseDAO.MOVIE_SYNOPSIS)),
                        c.getString(c.getColumnIndex(BaseDAO.MOVIE_DIRECTOR)),
                        c.getString(c.getColumnIndex(BaseDAO.MOVIE_CAST)),
                        c.getInt(c.getColumnIndex(BaseDAO.MOVIE_COUNTRY)),
                        c.getInt(c.getColumnIndex(BaseDAO.MOVIE_YEAR)),
                        c.getInt(c.getColumnIndex(BaseDAO.MOVIE_RUNTIME)),
                        c.getInt(c.getColumnIndex(BaseDAO.MOVIE_ISFAVORITE)) == 1 ? true : false);

                movieList.add(movie);
            } while (c.moveToNext());
        }

        c.close();
        close();
        return movieList;
    }
}
