package zeus.minhquan.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zeus.minhquan.dictionary.databases.DictionaryDB;
import zeus.minhquan.dictionary.model.Word;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    private final String TAG = "MainActivity";
    ListView listView;
    List<Word> words;
    List<Word> searchList;
    EditText et_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DictionaryDB dictionaryDB = DictionaryApplication.getInstance().getDictionaryDB();

        words = dictionaryDB.loadAllWords();
        listView = (ListView)findViewById(R.id.list);
        et_search = (EditText)findViewById(R.id.et_search);
        searchWord();
        displayList(searchList);
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchWord();
                displayList(searchList);
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("position", searchList.get(position).getId()+"");
        startActivity(intent);
    }
    public void displayList(List<Word> words){
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, words);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    public void searchWord(){
        String text = "";
        searchList = new ArrayList<>();
        if(et_search.getText()!=null){
            text = et_search.getText().toString();
        }
        for(Word word : words){
            if(word.getWord().toLowerCase().contains(text.toLowerCase())){
                searchList.add(word);
            }
        }

    }

}
