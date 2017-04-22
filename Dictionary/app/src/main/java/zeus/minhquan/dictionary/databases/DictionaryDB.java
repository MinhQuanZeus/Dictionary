package zeus.minhquan.dictionary.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import zeus.minhquan.dictionary.model.Word;

/**
 * Created by QuanT on 4/22/2017.
 */

public class DictionaryDB extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "dictionary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DICTIONARY_ID = "ID";
    private static final String DICTIONARY_WORD = "word";
    private static final String DICTIONARY_TYPE= "type";
    private static final String DICTIONARY_MEANING= "meaning";
    private static final String DICTIONARY_IMAGE= "image";
    private static final String DICTIONARY_EXAMPLE= "example";
    private static final String DICTIONARY_IS_FAVORITE= "example";
    private static final String[] DICTIONARY_ALL_COLLUMS= new String[]{DICTIONARY_ID,DICTIONARY_WORD,DICTIONARY_TYPE
            ,DICTIONARY_MEANING,DICTIONARY_IMAGE,DICTIONARY_EXAMPLE,DICTIONARY_IS_FAVORITE};



    public DictionaryDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<Word> loadAllWords() {
        List<Word> words = new ArrayList<>();
        //Get readable database
        SQLiteDatabase db = getReadableDatabase();
        //Query => cursor
        Cursor cursor = db.query("words",DICTIONARY_ALL_COLLUMS,null,null,null,null,null);
        //Go through rows
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID));
            String word = cursor.getString(cursor.getColumnIndex(DICTIONARY_WORD));
            String type = cursor.getString(cursor.getColumnIndex(DICTIONARY_TYPE));
            String meaning = cursor.getString(cursor.getColumnIndex(DICTIONARY_MEANING));
            String image = cursor.getString(cursor.getColumnIndex(DICTIONARY_IMAGE));
            String example = cursor.getString(cursor.getColumnIndex(DICTIONARY_EXAMPLE));
            boolean isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE))==1;
            Word w = new Word(id,word,type,meaning,image,example,isFavorite);
            words.add(w);

        }
        cursor.close();
        db.close();
        return words;
    }
}
