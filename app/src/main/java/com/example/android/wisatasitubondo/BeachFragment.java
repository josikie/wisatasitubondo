package com.example.android.wisatasitubondo;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeachFragment extends Fragment implements androidx.appcompat.widget.SearchView.OnQueryTextListener, SearchView.OnQueryTextListener {

    private ListView listView;
    private SpotAdapter spotAdapter;
    private SearchView searchView;
    private String[] placeName = new String[]{"Pasir putih", "Pathek", "Tampora", "Balanan", "Lempuyang", "Tangsi", "Bama", "Jangkar"};
    private int[] placePicture = new int[]{R.drawable.pasirputih, R.drawable.pathek, R.drawable.tampora, R.drawable.balanan, R.drawable.lempuyang, R.drawable.tangsi, R.drawable.bama, R.drawable.jangkar};
    private String[] placeLocation = new String[]{"Jln. Raya Pasir Putih No.87, Selomukti, Mlandingan, Pandansari, Bungatan, Situbondo, Jawa Timur, Indonesia", "Jalan Pantai Pathek, Gelung Selatan, Gelung, Kecamatan Situbondo, Kabupaten Situbondo, Jawa Timur, Indonesia",
            "Jalan Tampora, Besuki, Situbondo, Jawa Timur, Indonesia", "Desa Wonorejo, Kecamatan Banyu Putih, Kabupaten Situbondo, Jawa Timur", "Pintu masuk Karangtekok, Situbondo, Jawa Timur, Indonesia",
            "Desa Pecinan/Semiring, Mangaran, Situbondo, Jawa Timur, Indonesia", "Banyuputih, Kabupaten Situbondo, Jawa Timur, Indonesia", "Desa Jangkar, Situbondo, Jawa Timur, Indonesia",};
    private String[]  placeDescription = new String[]{
            "Pantai Pasir Putih adalah salah satu pantai di kota Situbondo yang memiliki keistimewaan pasir yang putih. Pantai ini memiliki pasir putih halus yang memanjang, air laut bening membiru, ombak yang landai, dan pemandangan selat Madura. Fasilitas yang ada pada pantai ini cukup memadai, diantaranya penginapan, rumah makan, mushola, kamar mandi, area parker dan lainnya. Untuk menikmati pantai ini tidak terlalu mahal dan terbilang cukup murah. Tarif Rp.10000 per orang, untuk parkir mobil Rp.5000 dan parkir sepeda motor Rp.3000. Di pantai ini kamu dapat menyewa perahu untuk berkeliling pantai dengan tarif Rp.75000 per perahu yang dapat diisi sekitar 5 orang. Harga yang dicantumkan adalah harga yang berlaku pada tahun 2020.",
            "Pathek adalah objek wisata berupa pantai yang dikelola Badan Usaha Milik Desa (BUMDes) dan nelayan setempat. Biaya masuk dan biaya parkir pantai Pathek gratis tidak dipungut biaya. Pantai ini cocok dijadikan tempat bersantai menikmati suasana pantai. Dekat pantai Pathek ada tempat wisata Grand Pathek yang juga bisa kamu nikmati",
            "Tampora adalah sebuah pantai di Situbondo untuk berwisata. Keunikan dari pantai ini adalah pemandangan batu karang yang kokoh. Suasana yang tenang bisa kamu dapatkan di pantai ini. Biaya tiket masuk pantai ini harga Rp 5000. Pantai ini buka dari jam tujuh pagi sampai jam 5 sore. Harga yang dicantumkan sewaktu - waktu dapat menyesuaikan.",
            "Balanan adalah salah satu pantai di Situbondo yang dekat dengan Taman Nasional Baluran. Pantai Balanan mempunyai pasir berwarna putih sehingga air lautnya terlihat sangat jernih. Harga tiket masuk pantai Balanan hanya Rp 10.000 per orang. Jam operasional pantai ini dimulai dari jam tujuh pagi sampai jam enam sore. Harga yang dicantumkan sewaktu - waktu dapat menyesuaikan.",
            "Pantai Lempuyang menawarkan pesona keindahan pantai. Pantai ini masuk ke dalam wilayah konservasi TNI - Baluran. Karang laut dipantai ini bagus dan pasirnya bersih. Tempatnya cocok untuk digunakan berwisata. Fasilitas yang ada di pantai ini antara lain tempat parkir dan tempat istirahat. Untuk tarif masuk tidak dikenakan biaya alias gratis.",
            "Keindahan pantai Tangsi tidak usah ditanya lagi. Pantai ini adalah pantai yang terletak di Mangaran, Situbondo. Air lautnya sangat jernih. Harga tiket masuk pantai Tangsi Rp 20.000 untuk tahun 2020. Terdapat mercusuar di pantai ini yang membuat pantai ini memiliki kekhasan sendiri. Banyak yang bisa kamu dapatkan dipantai ini, kamu bisa menikmati pantai yang bersih dan lebar, birunya air ombak, bermain voli di pantai, pohon – pohon bakau dan lainnya.",
            "Bama dikenal sebagai pantai yang airnya jernih dan memiliki pasir yang putih. Untuk masuk pantai, kamu harus melewati Taman Nasional Baluran. Fasilitas pantai Bama lengkap. Untuk tiket masuk hanya Rp.20.000 per orang.  Harga yang dicantumkan adalah harga yang berlaku pada tahun 2020.",
            "Pantai ini merupakan pantai pelabuhan sehingga selalu ramai. Biaya masuk pantai jangkar gratis. Pantai ini buka 24 jam. Keindahan pantai tentu bisa kamu dapatkan di pantai ini. Apalagi ada jasa sewa kuda untuk mengelilingi pantai Jangkar ditemani pemandu kuda, harga sewa kuda hanya Rp.10.000 saja. Harga yang dicantumkan adalah harga yang berlaku pada tahun 2020. Pantai ini akan lebih ramai jika tahun baru. "};

    private String[] placeSourcePicture = new String[]{"Sumber Gambar : pegipegi.com", "Sumber Gambar : indonesiakarya.com", "Sumber Gambar : tripadvisor.com",
            "Sumber Gambar : ksmtour.com", "Sumber Gambar : ihategreenjello.com", "Sumber Gambar : wisatapro.com (foto dari @arniza.uun)",
            "Sumber Gambar : travel.tempo.png", "Sumber Gambar : tripadvisor.com"};


    public BeachFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spot_list, container, false);
        view.setBackgroundColor(getResources().getColor(R.color.pantaiBackgroundAll));

        final ArrayList<Spot> spotArrayList = new ArrayList<Spot>();
        for (int i = 0; i < placeName.length; i++){
            Spot spot = new Spot(placePicture[i], placeSourcePicture[i], placeName[i], placeLocation[i], placeDescription[i]);
            spotArrayList.add(spot);
        }

        listView = view.findViewById(R.id.list);

        spotAdapter = new SpotAdapter(getContext(), spotArrayList, R.color.pantaiBackgroundColor);

        listView.setAdapter(spotAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), BeachDescription.class);
                    Spot spot = spotArrayList.get(i);
                    intent.putExtra("Photo", spot.getSpotPicture());
                    intent.putExtra("spotDescription", spot.getSpotDescription());
                    intent.putExtra("photoSource", spot.getSourcePicture());
                    intent.putExtra("spotLocation", spot.getSpotLocation());
                    intent.putExtra("spotTitle", spot.getSpotName());
                    startActivity(intent);
                }

        });

        searchView = view.findViewById(R.id.searchForFragment);
        searchView.setOnQueryTextListener(this);
        return view;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        spotAdapter.filter(newText);
        return false;
    }
}
