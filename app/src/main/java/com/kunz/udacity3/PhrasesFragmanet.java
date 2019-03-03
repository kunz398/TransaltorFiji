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

public class PhrasesFragmanet  extends Fragment {

    TextToSpeech textToSpeech;
    int result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
/** Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

        final ArrayList<Word> phrases = new ArrayList<Word>();

        //Intilizing
        phrases.add(new Word("welcome", "bula", R.drawable._flag,"boola"));
        phrases.add(new Word("how are you?", "vacava tiko?", R.drawable._flag,"vah da'vah tee'ko"));
        phrases.add(new Word("reply to 'how are you?", "sa bulabula vinaka tiko", R.drawable._flag,"sah boola boola vee-nahkah tee'ko"));
        phrases.add(new Word("long time no see", "sa dede da sega ni sota", R.drawable._flag,"not available")); ;
        phrases.add(new Word("what's your name?", "o cei na yacamu?", R.drawable._flag,"oh they nah yah daa'mu"));
        phrases.add(new Word("my name is ...", "na yacaqu o ...", R.drawable._flag,"not available"));
        phrases.add(new Word("where are you from?", "o ni lako mai vei?", R.drawable._flag,"not available"));
        phrases.add(new Word("i'm from ...", "o yau mai ...", R.drawable._flag,"not available"));
        phrases.add(new Word("pleased to meet you", "	ia bula", R.drawable._flag,"not available"));
        phrases.add(new Word("morning greeting", "yadra", R.drawable._flag,"not available"));
        phrases.add(new Word("good night", "moce", R.drawable._flag,"not available"));
        phrases.add(new Word("goodbye", "moce", R.drawable._flag,"not available"));
        phrases.add(new Word("good luck", "vanuinui vinaka", R.drawable._flag,"not available"));
        phrases.add(new Word("toasts used when drinking", "bula!", R.drawable._flag,"not available"));
        phrases.add(new Word("have a nice day", "vanuinui vinaka ki na siga ni kua", R.drawable._flag,"not available"));
        phrases.add(new Word("have a nice meal", "da kana! ", R.drawable._flag,"not available"));
        phrases.add(new Word("have a good journey", "vanuinui vinaka e nomu volau", R.drawable._flag,"not available"));
        phrases.add(new Word("yes", "io", R.drawable._flag,"not available"));
        phrases.add(new Word("no", "sega", R.drawable._flag,"not available"));
        phrases.add(new Word("maybe", "au sega ni kila", R.drawable._flag,"not available"));
        phrases.add(new Word("i understand", "au kilā", R.drawable._flag,"not available"));
        phrases.add(new Word("i don't understand", "au sa seqa ni kilā", R.drawable._flag,"not available"));
        phrases.add(new Word("please speak more slowly", "vosa mada vakamālua?", R.drawable._flag,"not available"));
        phrases.add(new Word("please say that again	", "tukuna tale mada", R.drawable._flag,"not available"));
        phrases.add(new Word("please write it down", "kerekere, mo ni vola", R.drawable._flag,"not available"));
        phrases.add(new Word("do you speak english?", "o(nī) vosa vakavālagi?", R.drawable._flag,"not available"));
        phrases.add(new Word("do you speak fijian?", "o(nī) kilā na vosa vakaviti?", R.drawable._flag,"not available"));
        phrases.add(new Word("yes, a little", " au kilā vakalailai na vosa vakaviti", R.drawable._flag,"not available"));
        phrases.add(new Word("how do you say ... in fijian?", "na cava na kena vosa vakaviti ni ...?", R.drawable._flag,"not available"));
        phrases.add(new Word("pardon (what did you say?", "ō?", R.drawable._flag,"not available"));
        phrases.add(new Word("excuse me", "au lako mada yani (to get past)", R.drawable._flag,"not available"));
        phrases.add(new Word("how much is this?", "e vica na kena i-sau?", R.drawable._flag,"not available"));
        phrases.add(new Word("sorry", "nī vosota sara (general)", R.drawable._flag,"not available"));
        phrases.add(new Word("excuse me (when invading space)", "jilou", R.drawable._flag,"not available"));
        phrases.add(new Word("please", "kerekere", R.drawable._flag,"not available"));
        phrases.add(new Word("thank you", "vinaka vaka levu", R.drawable._flag,"not available"));
        phrases.add(new Word("where's the toilet?", "e vei na vale-lailai?", R.drawable._flag,"not available"));
        phrases.add(new Word("would you like to dance with me?", "ko via meke kei au?", R.drawable._flag,"not available"));
        phrases.add(new Word("i love you", "au domoni iko", R.drawable._flag,"not available"));
        phrases.add(new Word("get well soon", "nuitaka ni ko na vabulabula totolo", R.drawable._flag,"not available"));
        phrases.add(new Word("leave me alone!", "biuti au tu madaga!", R.drawable._flag,"not available"));
        phrases.add(new Word("help!", "kere veivuke!", R.drawable._flag,"not available"));
        phrases.add(new Word("fire!", "kama!", R.drawable._flag,"not available"));
        phrases.add(new Word("call the police!", "qirita na ovisa!", R.drawable._flag,"not available"));
        phrases.add(new Word("christmas and new year greetings", "me nomuni na marau ni siga ni sucu kei na tawase ni yabaki vou", R.drawable._flag,"not available"));
        phrases.add(new Word("easter greetings", "vanuinui vinaka ni siga ni mate", R.drawable._flag,"not available"));
        phrases.add(new Word("birthday greetings", "vanuinui vinaka ki na nomu siga ni sucu", R.drawable._flag,"not available"));
        phrases.add(new Word("one language is never enough", "dua ga nai vosa e sigi rauta", R.drawable._flag,"not available"));

            //Changes Color
        WordAdapter adapter = new WordAdapter(getActivity(), phrases, R.color.cat_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);


        //Text to Speech
        //Setting a onItenCLick Listener on the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        if (status == TextToSpeech.SUCCESS) { //Validation to check if texttospeech is a sucess
                            //Initiating the Text to speech
                            Word num = phrases.get(position); //geting the postion of the click item
                            result = textToSpeech.setLanguage(Locale.ENGLISH.UK);
                            String toSpeak = num.getPronunciation();
                            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {//Checking to see if the phone-
                                // supports the language if it  doesnt display messgae else continue
                                Toast.makeText(getActivity(), "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                            } else {
                                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                                //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
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
    public void onDestroyView() { //Cleaning up the on speech so that it doesnt take up too much space
        super.onDestroyView();

        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

}