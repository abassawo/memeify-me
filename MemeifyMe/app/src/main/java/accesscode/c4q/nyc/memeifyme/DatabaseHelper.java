package accesscode.c4q.nyc.memeifyme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q-Abass on 7/17/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String myDB = "memeDB.db";
    private static final int VERSION = 1;
    private static DatabaseHelper mHelper;



    public DatabaseHelper(Context context)
    {
        super(context, myDB, null, VERSION);
    }


    //Satisfy singleton requirement
    public static synchronized DatabaseHelper getInstance(Context context) {
        if (mHelper == null) {
            mHelper = new DatabaseHelper(context);
        }
        return mHelper;
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Meme.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Meme.class, true);
            onCreate(database, connectionSource);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void insertRow(String caption) throws SQLException {
        Meme meme = new Meme(caption);
        getDao(Meme.class).create(meme);
    }

    public void deleteAll(){
        try {
            getDao(Meme.class).delete(loadData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList loadData() throws SQLException  {
        return (ArrayList) getDao(Meme.class).queryForAll();
    }
}
