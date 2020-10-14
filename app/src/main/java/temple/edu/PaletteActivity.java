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
        getSupportActionBar().setTitle(getApplicationContext().getResources().getString(R.string.title2));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> colors2 = new ArrayList<>();
        colors2.add("WHITE");
        colors2.add("RED");
        colors2.add("BLUE");
        colors2.add("YELLOW");
        colors2.add("GREEN");
        colors2.add("MAGENTA");
        colors2.add("BLACK");
        colors2.add("CYAN");
        colors2.add("GRAY");
        colors.add(getApplicationContext().getResources().getString(R.string.White));
        colors.add(getApplicationContext().getResources().getString(R.string.Red));
        colors.add(getApplicationContext().getResources().getString(R.string.Blue));
        colors.add(getApplicationContext().getResources().getString(R.string.Yellow));
        colors.add(getApplicationContext().getResources().getString(R.string.Green));
        colors.add(getApplicationContext().getResources().getString(R.string.Magenta));
        colors.add(getApplicationContext().getResources().getString(R.string.Black));
        colors.add(getApplicationContext().getResources().getString(R.string.Cyan));
        colors.add(getApplicationContext().getResources().getString(R.string.Gray));
        simpleGrid = (GridView)findViewById(R.id.simpleGrid);
        BaseAdapter adapter = new ColorAdapter(this, colors, colors2);
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