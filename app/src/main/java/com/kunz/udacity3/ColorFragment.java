package com.kunz.udacity3;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    TextToSpeech textToSpeech;
    int result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
/** Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

        final ArrayList<Word> colours = new ArrayList<Word>();

        //Intilizing
        colours.add(new Word("red","damudamu",R.drawable._red,"damu damu"));
        colours.add(new Word("green","drokadroka",R.drawable._green,"droka droka"));
        colours.add(new Word("grey","davudavu",R.drawable._grey,"davu davu"));
        colours.add(new Word("purple","lokaloka",R.drawable._purple,"locker locker"));
        colours.add(new Word("brown","masikuvui",R.drawable._brown,"maasi koouvouee"));
        colours.add(new Word("orange","sininauanaua",R.drawable._orange,"seeni nauah-nauah'"));
        colours.add(new Word("blue","kerakaraua",R.drawable._blue,"kera karuha"));
        colours.add(new Word("yellow","dromodromo",R.drawable._yellow,"dromo dromo"));
        colours.add(new Word("black","loaloa",R.drawable._black,"lower lower"));
        colours.add(new Word("white","vulavula",R.drawable._white,"vulah vulah"));

        WordAdapter adapter =  new WordAdapter(getActivity(),colours,R.color.cat_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);

        //Text to Speech
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS){
                            Word num = colours.get(position);
                            result = textToSpeech.setLanguage(Locale.ENGLISH.UK);
                            String toSpeak = num.getPronunciation();
                            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                                Toast.makeText(getActivity(), "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                            } else {
                                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                // Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(getActivity(), "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}