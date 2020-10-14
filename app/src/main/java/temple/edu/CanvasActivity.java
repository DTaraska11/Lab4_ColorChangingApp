package temple.edu;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle(getApplicationContext().getResources().getString(R.string.title3));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Bundle b = getIntent().getExtras();
        int value = Color.WHITE;; // or other values
        if(b != null)
            value = b.getInt("id");

        LinearLayout currentLayout = findViewById(R.id.Layout);
        String[] colorLabels = getResources().getStringArray(R.array.colors_array);
        String[] colorLabels2 = getResources().getStringArray(R.array.colors_array2);
        currentLayout.setBackgroundColor(Color.parseColor(colorLabels[value]));
        TextView textView = findViewById(R.id.textView);
        textView.setText(colorLabels2[value]);
    }


}
