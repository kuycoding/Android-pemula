package com.kuycoding.rumahadat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kuycoding.rumahadat.adapter.CardViewRumahAdapter;
import com.kuycoding.rumahadat.adapter.ListRumahAdapter;
import com.kuycoding.rumahadat.model.RumahData;
import com.kuycoding.rumahadat.model.RumahModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String title = "Ruma Adat";
    private RecyclerView rvRumah;
    private ArrayList<RumahModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRumah = findViewById(R.id.rv_rumah);
        rvRumah.setHasFixedSize(true);

        list.addAll(RumahData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvRumah.setLayoutManager(new LinearLayoutManager(this));
        ListRumahAdapter listRumahAdapter = new ListRumahAdapter(list,this);
        rvRumah.setAdapter(listRumahAdapter);

        listRumahAdapter.setOnItemClickCallback(new ListRumahAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(RumahModel data) {
                showSelectedRumah(data);
            }
        });
    }
    private void showRecyclerCardView(){
        rvRumah.setLayoutManager(new LinearLayoutManager(this));
        CardViewRumahAdapter cardViewRumahAdapter = new CardViewRumahAdapter(list, this);
        rvRumah.setAdapter(cardViewRumahAdapter);

        cardViewRumahAdapter.setOnItemClickCallback(new CardViewRumahAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(RumahModel data) {
                showSelectedRumah(data);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_cardview:
                showRecyclerCardView();
                break;
            case R.id.about:
                title = "Rumah Adat ";
                Intent moveAbout = new Intent(this, AboutActivity.class);
                startActivity(moveAbout);
        }
    }
    private void showSelectedRumah(RumahModel rumah) {
        Toast.makeText(this, "Kamu memilih " + rumah.getName(), Toast.LENGTH_SHORT).show();
    }
}
