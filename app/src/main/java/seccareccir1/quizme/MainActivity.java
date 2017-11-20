package seccareccir1.quizme;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity  implements QuizMenuFrag.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("DEBUG", getResources().getConfiguration().orientation + "");

        if (savedInstanceState == null) {
            QuizMenuFrag firstFragment = new QuizMenuFrag();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.flContainer, firstFragment);
            ft.commit();
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            QuizDetailFrag secondFragment = new QuizDetailFrag();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            secondFragment.setArguments(args);
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.flContainer, secondFragment);
            ft2.commit();
        }
    }

    @Override
    public void onQuizItemSelected(int position) {

        QuizDetailFrag secondFragment = new QuizDetailFrag();

        Bundle args = new Bundle();
        args.putInt("position", position);
        secondFragment.setArguments(args);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}