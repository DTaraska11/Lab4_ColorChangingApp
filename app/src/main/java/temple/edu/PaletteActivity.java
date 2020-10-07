package temple.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {
    GridView simpleGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> colors = new ArrayList<>();

        colors.add("WHITE");
        colors.add("RED");
        colors.add("BLUE");
        colors.add("YELLOW");
        colors.add("GREEN");
        colors.add("MAGENTA");
        colors.add("BLACK");
        colors.add("CYAN");
        colors.add("GRAY");
        simpleGrid = (GridView)findViewById(R.id.simpleGrid);
        BaseAdapter adapter = new ColorAdapter(this, colors);
        simpleGrid.setAdapter(adapter);
        simpleGrid.setSelection(0);
        simpleGrid.setBackgroundColor(808080);
        simpleGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                LinearLayout currentLayout =
                        (LinearLayout) findViewById(R.id.Layout);

                Intent x = new Intent(view.getContext(), CanvasActivity.class);
                x.putExtra("id", item);
                startActivity(x);
                adapterView.getSelectedView().setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}