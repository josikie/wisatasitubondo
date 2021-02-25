package com.example.android.wisatasitubondo;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourismAndWaterPark extends Fragment implements androidx.appcompat.widget.SearchView.OnQueryTextListener, SearchView.OnQueryTextListener {

    private ListView listView;
    private SpotAdapter spotAdapter;
    private SearchView searchView;
    private String[] placeName = new String[]{"Dermaga Panarukan", "Wisata Kampung Kerapu", "Kampung Blekok", "Dermaga Manggrove", "Dermaga Pasir putih",
            "Wisata Kampung Nelayan Grand Pathek"};
    private String[] placePhotoSource = new String[]{"Sumber gambar : antaranews.com", "Sumber gambar : dakataour.com", "Sumber : GenPI.co","Sumber gambar : phinemo.com", "Sumber gambar : IndonesiaKaya.com", "Sumber gambar : yukpigi.com" };

    private int[] placePhoto = new int[]{R.drawable.dermagapanarukan, R.drawable.kampungkerapu, R.drawable.kampungblekok,R.drawable.dermagamanggrove, R.drawable.dermagapasirputih,
            R.drawable.dermagagrandpathek};
    private String[] placeLocation = new String[]{"Somangkan, Kilensari, Panarukan, Situbondo, Jawa Timur, Indonesia","Kendit, Situbondo, Jawa Timur, Indonesia",
            "Dusun Pesisir, Klatakan, Kendit, Situbondo, Jawa Timur, Indonesia", "Sumberwaru, Banyuputih, Situbondo, Jawa Timur, Indonesia",
            "Pundansari, Pasir Putih, Bungatan, Situbondo, Jawa Timur, Indonesia", "Gelung, Panarukan, Situbondo, Jawa Timur"};

    private String[] placeDescription = new String[]{
            "Dermaga Panarukan adalah dermaga keren yang dijadikan tempat wisata. Biaya masuk dermaga hanya Rp 2000 saja. Dermaga ini memiliki banyak spot bagus untuk berfoto. Pemandangan akan lebih bagus ketika sunset. Selain itu, kamu bisa memancing ikan di Dermaga Panarukan. Tentu saja dermaga ini buka 24 jam sehari.",
            "Dermaga yang indah bisa dinikmati di Wisata Kampung Kerapu. Dermaga apung Wisata Kampung Kerapu berbentuk bulat. Tentunya dermaga ini memiliki banyak spot foto yang bagus dan indah. Kamu akan melihat keunikan Kampung Kerapu, yaitu puluhan keramba ikan yang dikemas cantik dan berbeda. Selain itu, dermaga apung Wisata Kampung Kerapu menyediakan fasilitas perahu wisata yang membuat pengunjung dapat mengunjungi keramba - keramba cantik yang berada di tengah air. Kamu juga bisa memancing di sini. Harga tiket masuk hanya Rp 35000 namun sewaktu - waktu harga bisa menyesuaikan. Jam operasional mulai dari jam 08:00 pagi sampai jam 22:00 malam (WIB). ",
            "Kampung Blekok adalah salah satu wisata air ekowisata yang terletak di Dusun Pesisir. Nama unik ekowisata ini dikarenakan banyaknya burung Blekok sawah (burung air) di sana. Dari Kampung Blekok, kamu bisa menikmati laut yang indah, hijaunya mangrove. Burung Blekok akan terbang dari kampung Blekok pada pukul 05:00 pagi untuk mencari makan bersama kelompoknya, kemudian akan kembali ke Kampung Blekok pukul 17:00 sore WIB. Tiket masuk per orang Rp 5000. Tetapi juga ada paket wisata lainnya yang akan menambah pengalamanmu. Harga sewaktu-waktu dapat menyesuaikan. Tempat wisata ini buka 24 jam sehari.",
            "Dermaga Manggrove berdekatan dengan Pantai Bama yang ada di dalam Hutan Baluran. Di dermaga ini kamu akan melihat banyak hewan yang dilindungi seperti Harimau, Ayam Hutan, Rusa, dan Kumbang. Jam operasional mulai jam 09:00 pagi sampai jam 17:00 sore (WIB). Kamu akan menemukan spot foto cantik di Dermaga Manggrove. Untuk tiket masuk, kamu hanya perlu membayar tiket masuk Hutan Baluran. Harga tiket masuk Hutan Baluran menyesuaikan.",
            "Dermaga Pasir Putih adalah dermaga yang berada di pantai pasir putih. Dermaga ini memiliki banyak spot foto yang cantik. Kamu bisa merasakan sejuknya hawa lautan dari dermaga ini. Untuk baik ke atas dermaga, kamu hanya perlu membayar Rp 2000 saja. Tapi sebelum naik ke atas dermaga, kamu harus masuk ke Pantai Pasir Putih dan membayar tiket masuk Pantai Pasir Putih. Dermaga ini buka mulai dari jam 07:00 pagi sampai 18:00 sore WIB.",
            "Wisata kampung Nelayan Grand Pathek adalah wisata air yang terletak di Situbondo. Wisata yang ditawarkan di Grand Pathek adalah wisata perpustakaan apung, snorkling, kolam berenang, taman bermain, tempat berswafoto, dan ayunan. Benar - benar destinasi wisata yang unik. Harga menyesuaikan."};

    public TourismAndWaterPark() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spot_list, container, false);
        view.setBackgroundColor(getResources().getColor(R.color.tourismandwaterparkbackgroundAll));

        final ArrayList<Spot> spotArrayList = new ArrayList<Spot>();
        for (int i = 0; i < placeName.length;  i++){
            Spot spot = new Spot(placePhoto[i], placePhotoSource[i], placeName[i], placeLocation[i], placeDescription[i]);
            spotArrayList.add(spot);
        }

        spotAdapter = new SpotAdapter(getActivity(), spotArrayList, R.color.tourismandwaterpark);

        listView = view.findViewById(R.id.list);
        listView.setAdapter(spotAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Spot getList = spotArrayList.get(i);
                Intent intent = new Intent(getActivity(), TourismAndWaterParkActivity.class);
                intent.putExtra("Photo", getList.getSpotPicture());
                intent.putExtra("photoSource", getList.getSourcePicture());
                intent.putExtra("spotTitle", getList.getSpotName());
                intent.putExtra("spotLocation", getList.getSpotLocation());
                intent.putExtra("spotDescription", getList.getSpotDescription());
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
