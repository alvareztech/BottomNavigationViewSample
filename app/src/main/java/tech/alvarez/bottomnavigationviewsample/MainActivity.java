package tech.alvarez.bottomnavigationviewsample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = findViewById(R.id.infoTextView);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.inicioItem) {
                infoTextView.setText(R.string.inicio);
            } else if (item.getItemId() == R.id.buscarItem) {
                infoTextView.setText(R.string.buscar);
            } else if (item.getItemId() == R.id.camaraItem) {
                infoTextView.setText(R.string.camara);
            } else if (item.getItemId() == R.id.favoritosItem) {
                infoTextView.setText(R.string.favoritos);
            } else if (item.getItemId() == R.id.perfilItem) {
                infoTextView.setText(R.string.perfil);
            }
            return true;
        });

        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.inicioItem);
        badge.setNumber(7);
        badge.setVisible(true);
    }
}
