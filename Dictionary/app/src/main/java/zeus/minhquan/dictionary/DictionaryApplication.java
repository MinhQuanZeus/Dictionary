package zeus.minhquan.dictionary;

import android.app.Application;

import zeus.minhquan.dictionary.databases.DictionaryDB;

/**
 * Created by QuanT on 4/22/2017.
 */

public class DictionaryApplication extends Application {
    private String TAG = "DictionaryApplication";
    private DictionaryDB dictionaryDB;
    private static DictionaryApplication instance;



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dictionaryDB = new DictionaryDB(this);
    }
    public DictionaryDB getDictionaryDB() {
        return dictionaryDB;
    }

    public static DictionaryApplication getInstance() {
        return instance;
    }
}
