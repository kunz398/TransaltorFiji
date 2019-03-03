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
public class NumberFragment extends Fragment {

    TextToSpeech textToSpeech;
    int result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
/** Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

        //Creating the arrays
        final ArrayList<Word> numbers = new ArrayList<Word>();

        //Initializing

        numbers.add(new Word("one", "dua", R.drawable._nmbericon, "doohwa"));
        numbers.add(new Word("two", "rua", R.drawable._nmbericon, "ruwah"));
        numbers.add(new Word("three", "tolu", R.drawable._nmbericon, "tolu"));
        numbers.add(new Word("four", "va", R.drawable._nmbericon, "vah"));
        numbers.add(new Word("five", "lima", R.drawable._nmbericon, "lima"));
        numbers.add(new Word("six", "ono", R.drawable._nmbericon, "o'no"));
        numbers.add(new Word("seven", "vitu", R.drawable._nmbericon, "veetu"));
        numbers.add(new Word("eight", "walu", R.drawable._nmbericon, "wahlu"));
        numbers.add(new Word("nine", "ciwa", R.drawable._nmbericon, "thee wah"));
        numbers.add(new Word("ten", "tini", R.drawable._nmbericon, "teeni"));
        numbers.add(new Word("eleven", "tini ka dua", R.drawable._nmbericon, "teeni kah doohwa"));
        numbers.add(new Word("twelve", "tini ka rua", R.drawable._nmbericon, "teeni kah ruwah"));
        numbers.add(new Word("thirteen", "tini ka tolu", R.drawable._nmbericon, "teeni kah tolu"));
        numbers.add(new Word("fourteen", "tini ka va", R.drawable._nmbericon, "teeni ka vah"));
        numbers.add(new Word("fifteen", "tini ka lima", R.drawable._nmbericon, "teeni kah lima"));
        numbers.add(new Word("sixteen", "tini ka ono", R.drawable._nmbericon, "teeni kah o'no"));
        numbers.add(new Word("seventeen", "tini ka vitu", R.drawable._nmbericon, "teeni kah veetu"));
        numbers.add(new Word("eighteen", "tini ka walu", R.drawable._nmbericon, "teeni kah wahlux"));
        numbers.add(new Word("nineteen", "tini ka ciwa", R.drawable._nmbericon, "teeni kah thee wah"));
        numbers.add(new Word("twenty", "rua saga vulu", R.drawable._nmbericon, "ruwah sangah vuluh"));

      //  WordAdapter adapter = new WordAdapter(this, numbers, R.color.cat_numbers); //Activity

        WordAdapter adapter = new WordAdapter(getActivity(), numbers, R.color.cat_numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.listview);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            Word num = numbers.get(position);
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