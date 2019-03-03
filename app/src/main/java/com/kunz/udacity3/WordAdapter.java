package com.kunz.udacity3;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

    /**
     * Created by kunz on 11/27/2016.
     * ColorsActivity,FamilyActivity,NumberActivity,PhraseActivity All use this class
     */

public class WordAdapter extends ArrayAdapter<Word> {

        /** Resource ID for the Background color for this list of words */
        private int mColorResourceId;

        //Constructor
    public WordAdapter(Activity context, ArrayList<Word> word,int mColorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        this.mColorResourceId = mColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word CurrentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView fijian_text_view = (TextView) listItemView.findViewById(R.id.fijian_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        fijian_text_view.setText(CurrentWord.getFijianWords());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        default_text_view.setText(CurrentWord.getEnglishWords());

        //image
        ImageView icon = (ImageView) listItemView.findViewById(R.id.icon);
        icon.setImageResource(CurrentWord.getImageResourceid());

       /*
       * Setting Colors
       * */

        //Get id of the Linear layout where  u want to Change color for
        View textContainer = listItemView.findViewById(R.id.textContainer);

        //find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);

        //set the Background Color of the text Container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}