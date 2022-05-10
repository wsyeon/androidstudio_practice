package com.yeon.practice_instagram_search_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SearchDarkActivity extends AppCompatActivity {

    private List<String> items = Arrays.asList("인스타그램", "페이스북", "카카오톡", "DM", "인기스타", "인별여신");
    SearchView sv_search;
    TextView tv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dark);

        sv_search = findViewById(R.id.sv_search);
        tv_list = findViewById(R.id.tv_list);
        tv_list.setText(getList());

        sv_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tv_list.setText(search(newText ));
                return true;
            }
        });
    }

    private String search(String query) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            if (item.toLowerCase().trim().contains(query.toLowerCase().trim())) {
                sb.append(item);
                if (i != items.size()) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private String getList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            sb.append(item);
            if (i != items.size()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
