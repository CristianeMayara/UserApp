package com.mobile.movies.model.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Cristiane on 28/04/2017.
 */

public class BaseDAO extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    private final Context context;
    private static String DB_PATH = "";
    private static final String DB_NAME = "movies.db";
    private static final int DB_VERSION = 1;
    protected static final String DB_LOG = "DB";

    protected static final String MOVIE_TABLE_NAME = "movie";
    protected static final String MOVIE_ID = "id";
    protected static final String MOVIE_NAME = "name";
    protected static final String MOVIE_GENRE = "genre";
    protected static final String MOVIE_SYNOPSIS = "synopsis";
    protected static final String MOVIE_DIRECTOR = "director";
    protected static final String MOVIE_CAST = "cast";
    protected static final String MOVIE_COUNTRY = "country";
    protected static final String MOVIE_YEAR = "year";
    protected static final String MOVIE_ISFAVORITE = "isFavorite";

    protected static final String GENRE_TABLE_NAME = "genre";
    protected static final String GENRE_ID = "id";
    protected static final String GENRE_NAME = "name";

    protected static final String COUNTRY_TABLE_NAME = "country";
    protected static final String COUNTRY_ID = "id";
    protected static final String COUNTRY_NAME = "name";

    /*@SuppressLint("SdCardPath")*/
    public BaseDAO(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        Log.v(DB_LOG, " " + DB_PATH);
        this.context = context;
        onCreate(database);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // executes create or copy of database
        try {
            this.createDatabase();
        } catch (IOException mIOException) {
            Log.e(DB_LOG, mIOException.toString()
                    + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v(DB_LOG, "Atualizando a versao: " + oldVersion
                + " para " + newVersion
                + ". Todos os registros serao removidos.");
        onCreate(sqLiteDatabase);
    }

    private void createDatabase() throws IOException {
        // If database not exists copy it from the assets
        boolean databaseExist = checkDatabase();
        if (!databaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                // Copy the database from assests
                copyDatabase();
                Log.v(DB_LOG, "Database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");

            }
        }
    }

    // Open the database, so we can query it
    public boolean openDatabase() throws SQLException {
        String path = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.CREATE_IF_NECESSARY);
        return database != null;
    }

    @Override
    public synchronized void close() {
        if (database != null)
            database.close();
        super.close();
    }

    // Check that the database exists here: /data/data/your package/databases/
    private boolean checkDatabase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        Log.v(DB_LOG, dbFile + "   " + dbFile.exists());
        return dbFile.exists();
    }

    // Copy the database from assets
    private void copyDatabase() throws IOException {
        Log.v(DB_LOG, "copying database from assets. Open:" + DB_NAME);
        InputStream input = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        output.flush();
        output.close();
        input.close();
    }
}
