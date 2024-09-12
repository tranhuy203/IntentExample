package com.example.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView txt_hello;
    private Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
    }

    private void initViews() {
        txt_hello = findViewById(R.id.txt_hello);
        btn_click = findViewById(R.id.btn_click);
        Intent intent = getIntent();
        Bundle bun = intent.getExtras();
        if(bun!=null){
            Toast.makeText(this, bun.getString("data"), Toast.LENGTH_SHORT).show();
        }
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Demo_Contrain.class);
                // truyền dữ liệu qua Bundle
                Bundle bundle = new Bundle();
                bundle.putString("data","Hello Child");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

}