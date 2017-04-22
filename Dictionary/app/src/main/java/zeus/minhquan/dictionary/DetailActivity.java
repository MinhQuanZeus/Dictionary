package zeus.minhquan.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import zeus.minhquan.dictionary.databases.DictionaryDB;
import zeus.minhquan.dictionary.model.Word;

public class DetailActivity extends AppCompatActivity {
    ImageView view;
    TextView word,type,meaning,example;
    List<Word> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DictionaryDB dictionaryDB = DictionaryApplication.getInstance().getDictionaryDB();
        words = dictionaryDB.loadAllWords();

        view = (ImageView)findViewById(R.id.iv_image);
        word = (TextView)findViewById(R.id.tv_word);
        type = (TextView)findViewById(R.id.tv_type);
        meaning = (TextView)findViewById(R.id.tv_meaning);
        example = (TextView)findViewById(R.id.tv_example);


        String s="1";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s = extras.getString("position");
        }

        Word w = searchWord(Integer.parseInt(s));
        if(w!=null) {
            Picasso.with(this).load(w.getImage()).into(view);
            word.setText(w.getWord());
            type.setText("Type: " + w.getType());
            meaning.setText("Meaning: " + w.getMeaning());
            example.setText("Example: " + w.getExample());
        }
    }

    public Word searchWord(int id){
        for(Word word :words){
            if(word.getId()==id){
                return word;
            }
        }
        return null;
    }
}
