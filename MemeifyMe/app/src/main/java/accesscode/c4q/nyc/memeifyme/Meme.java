package accesscode.c4q.nyc.memeifyme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by c4q-Abass on 7/17/15.
 */
@DatabaseTable(tableName = "meme-templates")
public class Meme {
    @DatabaseField(id = true)
    public int _id;

    @DatabaseField
    public String caption;

    public String getTitle() {
        return title;
    }

    @DatabaseField
    public String title;


    public String getCaption() {
        return caption;
    }



    public int get_id() {
        return _id;
    }


    public Meme(String caption){
        this.caption = caption;
    }



    public Meme(){
    this.caption = "";
    }

    @Override
    public String toString() {
        return this.getCaption();
    }


}


