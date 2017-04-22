package zeus.minhquan.dictionary;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

import zeus.minhquan.dictionary.model.Word;

/**
 * Created by QuanT on 4/22/2017.
 */

public class CustomListViewAdapter extends ArrayAdapter<Word> {

    Context context;

    public CustomListViewAdapter(Context context, int resourceId,
                                 List<Word> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Word rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtDesc = (TextView) convertView.findViewById(R.id.mean);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.word);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtDesc.setText(rowItem.getMeaning());
        holder.txtTitle.setText(rowItem.getWord());
        Picasso.with(context).load(rowItem.getImage()).into(holder.imageView);


        return convertView;
    }
}
