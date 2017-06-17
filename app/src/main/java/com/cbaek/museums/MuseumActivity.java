package com.cbaek.museums;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MuseumActivity extends AppCompatActivity {

    private final List<Museum> museums = new ArrayList<>();
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        initializeMuseums();
    }

    private void initializeMuseums() {
        museums.add(Museum.create("Annenberg Space For Photography", "annenberg_space_for_photography.jpg"));
        museums.add(Museum.create("California Science Center", "california_science_center.jpg"));
        museums.add(Museum.create("Getty Center", "getty_center.jpg"));
        museums.add(Museum.create("Griffith Observatory", "griffith_observatory.jpg"));
        museums.add(Museum.create("Hammer Museum", "hammer_museum.jpg"));
        museums.add(Museum.create("Huntington Library Art Collections And Botanical Gardens", "huntington_library_art_collections_and_botanical_gardens.jpg"));
        museums.add(Museum.create("Japanese American National Museum", "japanese_american_national_museum.jpg"));
        museums.add(Museum.create("La Brea Tar Pits And Museum", "la_brea_tar_pits_and_museum.jpg"));
        museums.add(Museum.create("Los Angeles County Museum Of Art", "los_angeles_county_museum_of_art.jpg"));
        museums.add(Museum.create("Museum Of Contemporary Art", "museum_of_contemporary_art.jpg"));
        museums.add(Museum.create("Natural History Museum", "natural_history_museum.jpg"));
        museums.add(Museum.create("Norton Simon Museum", "norton_simon_museum.jpg"));
        museums.add(Museum.create("Pasadena Museum Of California Art", "pasadena_museum_of_california_art.jpg"));
        museums.add(Museum.create("Peterson Automotive Museum", "petersen_automotive_museum.jpg"));
        museums.add(Museum.create("The Broad", "the_broad.jpg"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateWithRandomMuseum();
    }

    /**
     * Called when user clicks "Next" button
     *
     * @param view
     */
    public void updateActivityWithRandomMuseum(final View view) {
        updateWithRandomMuseum();
    }

    private void updateWithRandomMuseum() {
        final Museum museum = museums.get(random.nextInt(museums.size()));
        updateMuseumName(museum);
        updateMuseumImage(museum);
    }

    private void updateMuseumName(final Museum museum) {
        final TextView museumNameTextView = (TextView) findViewById(R.id.museum_name);
        museumNameTextView.setText(museum.name());
    }

    private void updateMuseumImage(final Museum museum) {
        final ImageView imageView = (ImageView) findViewById(R.id.museum_image);
        imageView.setImageDrawable(museumImageToDrawable(museum));
    }

    private Drawable museumImageToDrawable(final Museum museum) {
        try (final InputStream inputStream = getAssets().open(museum.imageUrl())) {
            return Drawable.createFromStream(inputStream, museum.imageUrl());
        } catch (final IOException e) {
            Toast.makeText(this, "Exception loading image for " + museum.name(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

}
