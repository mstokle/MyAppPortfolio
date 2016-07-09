package ar.com.stokle.myappportfolio;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MyAppPortfolioFragment())
                    .commit();
        }
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    public static class MyAppPortfolioFragment extends Fragment {

        public MyAppPortfolioFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    public void sendMessage(View view) {
        String button_pressed = new String();
        int position = 0;
        switch (view.getId()) {
            case R.id.popmoviesbtn:
                button_pressed = "Popular Movies";
                position = 250;
                break;
            case R.id.stockhawkbtn:
                button_pressed = "Stock Hawk";
                position = 410;
                break;
            case R.id.builditbiggerbtn:
                button_pressed = "Build it Bigger";
                position = 570;
                break;
            case R.id.makeyourappmaterialbtn:
                button_pressed = "Make your App Material";
                position = 730;
                break;
            case R.id.goubiquitousbtn:
                button_pressed = "Go Ubiquitous";
                position = 890;
                break;
            case R.id.capstonebtn:
                button_pressed = "Capstone";
                position = 1050;
                break;
        }
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        String text = "This button will launch my " + button_pressed + " app!";
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, position);
        toast.show();
        }
    }
