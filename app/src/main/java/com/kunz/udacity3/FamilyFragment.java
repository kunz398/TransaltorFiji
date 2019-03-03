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
 * Created by kunz on 12/2/2016.
 */

public class FamilyFragment  extends Fragment {
    TextToSpeech textToSpeech;
    int result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
/** Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

            //Creating the arrays
            final ArrayList<Word> family = new ArrayList<Word>();

            //Intilizing
        family.add(new Word("elder brother", "tuakaqu tagane", R.drawable._family_older_brother,"not available"));
        family.add(new Word("younger brother", "taciqu tagane", R.drawable._family_younger_brother,"not available"));
        family.add(new Word("elder sister", "tuakaqu yalewa", R.drawable._family_older_sister,"not available"));
        family.add(new Word("younger sister", "taciqu yalewa", R.drawable._family_younger_sister,"not available"));
        family.add(new Word("father", "tata", R.drawable._family_father,"not available"));
        family.add(new Word("mother", "nana", R.drawable._family_mother,"not available"));
        family.add(new Word("mother's brother" ,"momo", R.drawable._family_older_brother,"not available"));
        family.add(new Word("mother'selder sister", "nana levu", R.drawable._family_older_sister,"not available"));
        family.add(new Word("mother's younger sister", "nana lailai", R.drawable._family_younger_sister,"not available"));
        family.add(new Word("father's elder brother", "tata levu", R.drawable._family_older_brother,"not available"));
        family.add(new Word("father's younger brother", "tata lailai", R.drawable._family_younger_brother,"not available"));
        family.add(new Word("father's sister", "nei", R.drawable._family_younger_sister,"not available"));
        family.add(new Word("father's younger brother's wife", "nana lailai", R.drawable._family_mother,"not available"));
        family.add(new Word("mother's brother's wife", "nei", R.drawable._family_mother,"not available"));
        family.add(new Word("father's sister's husband", "momo", R.drawable._family_older_brother,"not available"));
        family.add(new Word("mother's elder sister's husband", "tata levu", R.drawable._family_older_brother,"not available"));
        family.add(new Word("mother's younger sister's husband", "tata lailai", R.drawable._family_younger_brother,"not available"));
        family.add(new Word("father's father", "bubu tagane", R.drawable._family_grandfather,"not available"));
        family.add(new Word("father's mother", "bubu yalewa", R.drawable._family_grandmother,"not available"));
        family.add(new Word("mother's father", "bubu tagane", R.drawable._family_grandfather,"not available"));
        family.add(new Word("mother's mother", "bubu yalewa", R.drawable._family_grandmother,"not available"));
        family.add(new Word("son", "luvequ tagane", R.drawable._family_son,"not available"));
        family.add(new Word("daughter", "luvequ yalewa", R.drawable._family_daughter,"not available"));
        family.add(new Word("brother's son", "vugoqu tagane", R.drawable._family_son,"not available"));
        family.add(new Word("brother's daughter", "vugoqu yalewa", R.drawable._family_daughter,"not available"));
        family.add(new Word("sister's son", "luvequ tagane", R.drawable._family_daughter,"not available"));
        family.add(new Word("sister's daughter", "luveq u yalewa", R.drawable._family_younger_sister,"not available"));
        family.add(new Word("son's son", "makubuqu taga ne", R.drawable._family_younger_brother,"not available"));
        family.add(new Word("son's daughter", "makubuq u yalewa", R.drawable._family_daughter,"not available"));
        family.add(new Word("daughter's son", "makubuq tagane", R.drawable._family_daughter,"not available"));
        family.add(new Word("daughter's daughter", "mak ubuqu yalewa", R.drawable._family_daughter,"not available"));
        family.add(new Word("wife", "watiqu ", R.drawable._family_mother,"not available"));
        family.add(new Word("husband", "daulomani", R.drawable._family_younger_brother,"not available"));
        family.add(new Word("husband's brother", "noqu daku tagane", R.drawable._family_father,"not available"));
        family.add(new Word("husband's sister", "noqu daku yalewa", R.drawable._family_younger_sister,"not available"));
        family.add(new Word("wife's brother", "tavaleq u tagane", R.drawable._family_younger_brother,"not available"));
        family.add(new Word("wife's sister", "tavalequ yalewa", R.drawable._family_younger_sister,"not available"));
        family.add(new Word("husband's brother's wife", "karua", R.drawable._family_older_sister,"not available"));
        family.add(new Word("wife's sister's husband", "karua", R.drawable._family_older_brother,"not available"));
        family.add(new Word("wife's brother's wife", "noqu veitabuki yalewa", R.drawable._family_older_sister,"not available"));
        family.add(new Word("husband's father", "nabugoqu tagane", R.drawable._family_grandfather,"not available"));
        family.add(new Word("husband's mother", "nabugoqu yalewa", R.drawable._family_grandmother,"not available"));
        family.add(new Word("wife's father", "nabugoqu tagane", R.drawable._family_father,"not available"));
        family.add(new Word("wife's mother", "nabugoqu yalewa", R.drawable._family_mother,"not available"));
        family.add(new Word("husband's father's brother", "momo", R.drawable._family_older_brother,"not available"));
        family.add(new Word("wife's father's brother", "momo", R.drawable._family_father,"not available"));
        family.add(new Word("husband's father's sister", "nei", R.drawable._family_mother,"not available"));
        family.add(new Word("wife's father's sister", "nei", R.drawable._family_older_sister,"not available"));
        family.add(new Word("husband's mother's brother", "momo", R.drawable._family_father,"not available"));
        family.add(new Word("wife's mother's brother", "momo", R.drawable._family_grandfather,"not available"));
        family.add(new Word("husband's mother's sister", "nei", R.drawable._family_grandmother,"not available"));
        family.add(new Word("wife's mother's sister", "nei", R.drawable._family_grandmother,"not available"));

            WordAdapter adapter = new WordAdapter(getActivity(), family, R.color.cat_family);

            ListView listView = (ListView) rootView.findViewById(R.id.listview);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                    textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if (status == TextToSpeech.SUCCESS) {
                                Word num = family.get(position);
                                result = textToSpeech.setLanguage(Locale.ENGLISH.UK);
                                String toSpeak = num.getPronunciation();
                                //If the language is not supported by the phone or there is some missing data then handel error else proceed futher
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
            super.onDestroy();
            if (textToSpeech != null) {
                textToSpeech.stop();
                textToSpeech.shutdown();
            }
        }
    }

