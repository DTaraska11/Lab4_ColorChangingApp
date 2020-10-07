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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Bundle b = getIntent().getExtras();
        String value = "White"; // or other values
        if(b != null)
            value = b.getString("id");

        LinearLayout currentLayout = findViewById(R.id.Layout);

        currentLayout.setBackgroundColor(Color.parseColor(value));
        TextView textView = findViewById(R.id.textView);
        textView.setText(value);
    }


}
