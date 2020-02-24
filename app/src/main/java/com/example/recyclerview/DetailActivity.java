package com.example.recyclerview;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView imageview;
    TextView textnama, textdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textnama = findViewById(R.id.tvNama);
        textdetail = findViewById(R.id.tvDetail);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String detail = bundle.getString("detail");

        textnama.setText(nama);
        textdetail.setText(detail);
        textdetail.setMovementMethod(new ScrollingMovementMethod());
    }
}
