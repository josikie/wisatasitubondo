package com.example.android.wisatasitubondo;


import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.SortedMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaterBoomFragment extends Fragment implements androidx.appcompat.widget.SearchView.OnQueryTextListener, SearchView.OnQueryTextListener{

    private ListView listView;
    private SpotAdapter spotAdapter;
    private SearchView searchView;
    private String[] placeName = new String[]{"Tirta Pandawa ", "Barokah Park", "Waterboom Situbondo", "Swimming Pool Happy", "Swimming Tirta Willis", "Kolam Renang Asri", "Kolam Renang Tirta Diva", "Kolam Renang Tirta Mandiri",
            "Kolam Renang Pelangi ", "Kolam Renang Dian Group", "Cottok Innovation Park"};
    private String[] placePhotoSource = new String[]{"Sumber Gambar : trepelin.com", "Sumber Gambar : pegipegi.com", "Sumber Gambar : pegipegi.com", "Sumber Gambar : youtube.com", "Sumber Gambar : facebook.com",
            "Sumber gambar : google.com", "Sumber Gambar : google.com", "Sumber Gambar : facebook.com", "Sumber gambar : google.com", "Sumber gambar : id.foursquare.com", "Sumber gambar : youtube.com"};

    private int[] placePhoto = new int[]{R.drawable.tirtapandawa, R.drawable.barokahpark, R.drawable.waterboomsitubondo, R.drawable.happyswimmingpool, R.drawable.swimmingpooltirtawillis, R.drawable.kolamrenangasri,
            R.drawable.kolamrenangtirtadiva, R.drawable.tirtamandiri, R.drawable.pelangi, R.drawable.diangroup, R.drawable.wisatacip};
    private String[] placeLocation = new String[]{"Jalan Sudirman Rt 003, Situbondo, Jawa Timur, Indonesia", "Jalan Raya Asembagus, krajan, Wringinanom, Asembagus, Situbondo, Jawa Timur, Indonesia",
            "Langai, Sumberkolak, Panarukan, Situbondo, Jawa Timur, Indonesia", "Jalan Plaosan, Krajan Timur, Sumberkolak, Situbondo, Jawa Timur, Indonesia", "Jalan Raya Mangaran, Curahjeru Tengah, Curahjeru, Panji, Situbondo, Jawa Timur, Indonesia",
            "Bligeran, Wringinanom, Panarukan, Situbondo, Jawa Timur, Indonesia", "Klantong, Langkap, Besuki, Situbondo, Jawa Timur, Indonesia", "Jalan Pelabuhan, Palangan Timur, Jangkar, Situbondo, Jawa Timur, Indonesia",
            "Mangaran, Situbondo, Jawa Timur, Indonesia", "Jalan Basuki Rahmat No. 18, Situbondo, Jawa Timur, Indonesia", "Curah Cottok, Kapongan, Situbondo, Jawa Timur, Indonesia"};

    private String[] placeDescription = new String[]{
            "Tirta Pandawa adalah salah satu kolam renang di Situbondo yang memiliki fasilitas lengkap. Kolam renang Tirta Pandawa memiliki air kolam yang bersih dan jernih. Terdapat dua kolam, yaitu satu kolam renang untuk dewasa, dan satu kolam renang untuk anak – anak. Harga tiket masuk kolam renang Tirta Pandawa hanya Rp 10.000 per orang namun harga tetap menyesuaikan. Kamu bisa menikmati seluncuran di kolam renang anak dan melompat ke kolam renang dewasa. Tirta Pandawa buka dari jam 08.00 pagi sampai jam 17.00 sore.",
            "Barokah Park adalah waterboom dengan fasilitas terlengkap di Situbondo dengan banyak permainan air. Wahana permainan air di Barokah Park seperti seluncuran air, ember tumpah, dan masih banyak lainnya. Harga tiket masuk Rp 15000 per orang untuk setap hari senin sampai jumat, sedangkan untuk hari sabtu dan minggu harga tiketnya Rp 20000. Namun harga tiket menyesuaikan. Jam operasional mulai dari jam 08.00 pagi sampai 17.00 sore (WIB).",
            "Waterboom ini didirikan pada tahun 2016. Waterboom Situbondo sering disebut WBS oleh warga Situbondo. Keunikan dari WBS adalah payung – payung yang bergelantung di sepanjang jalan menuju kolam renang yang bisa dijadikan tempat berselfie ria. WBS merupakan salah satu water boom yang memiliki fasilitas terlengkap di Situbondo. Harga tiket sangat murah sekitar Rp 15000 per orang. Sewaktu – waktu harga dapat menyesuaikan. Jam operasional mulai dari jam 08.00 pagi sampai jam 16.00 sore (WIB).",
            "Swimming Pool Happy adalah salah satu kolam renang di Situbondo. Kolam renang ini cocok untuk anak – anak. Harga tiket masuk sekitar Rp 7000 namun harga tetap menyesuaikan. Jam operasional dari jam 08.00 pagi sampai jam 17.00 sore (WIB). Puaskan anak anda untuk berenang di Swimming Pool Happy.",
            "Swimming Pool Tirta Willis adalah kolam renang yang menyediakan papan melompat untuk pengunjung agar bisa melompat dari papan lompat. Air kolam renang sangat jernih. Terdapat tiga kolam renang, kolam renang baita, kolam renang anak – anak, dan kolam renang dewasa. Di kolam renang ini juga tersedia seluncuran dan tempat beli makanan seperti kantin. Harga tiket masuk menyesuaikan. Jam operasional dari jam 08.00 pagi sampai jam 18.00 sore (WIB).",
            "Kolam Renang Asri adalah salah satu kolam renang di Situbondo. Disini kamu bisa menikmati jernihnya air kolam bersama keluarga. Cocok untuk anak – anak dan tidak bahaya untuk anak - anak. Air kolam tidak menyebabkan mata perih dan airnya asli air tanpa kaporit. Harga tiket masuk juga cukup murah dan terjangkau. Harga tiket masuk menyesuaikan. Jam operasional mulai dari jam 07.30 pagi sampai jam 4.30 sore (WIB).",
            "Kolam Renang Tirta Diva adalah kolam renang yang terletak di bagian barat Situbondo. Air dari kolam renang jernih dan tanpa kaporit. Fasilitasnya cukup lengkap. Juga terdapat dua kolam utama untuk orang dewasa dan satu kolam untuk anak – anak. Kolam renang ini mulai buka dari jam 8.00 pagi sampai 18.00 sore (WIB). Harga tiket cukup murah dan menyesuaikan. ",
            "Tirta Mandiri adalah kolam renang yang terletak di daerah Jangkar, Situbondo. Kolam renang ini memiliki fasilitas yang cukup lengkap. Airnya jernih dan segar. Harga tiket masuk menyesuaikan. Jam operasional dari jam 08.00 pagi sampai jam 12.00 siang (WIB) dan jam 14.00 siang sampai 17.00 sore (WIB). ",
            "Pelangi adalah salah satu kolam renang yang didirikan di daerah Mangaran, Situbondo. Beberapa permainan air yang ada di kolam renang ini diantaranya ember tumpah dan seluncuran. Fasilitas lumayan lengkap . Harga tiket masuk menyesuaikan. Jam operasional mulai dari jam 07.00 pagi sampai jam 17.00 sore (WIB).",
            "Kolam Renang Dian Group adalah kolam renang yang memiliki fasilitas lengkap. Air jernih dan kolam terawat. Cocok untuk anak – anak maupun dewasa. Harga tiket cukup murah dan menyesuaikan. Jam operasional pada hari minggu sampai hari jumat dari jam 06.45 pagi sampai jam 18.00 sore (WIB), kecuali hari Kamis hanya buka sampai jam 17.00 sore (WIB) dan pada hari sabtu jam 09.00 pagi sampai jam 18.00 sore (WIB).",
            "Cottok Innovation Park adalah destinasi wisata yang berada di wilayah perbukitan. Tempat wisata ini memilik beberapa wahana yang bisa kamu nikmati termasuk kolam renang dan kuliner. Spot foto di Cottok Innovation Park sangat indah. Di tempat wisata ini kamu bisa menikmati udara segar. Harga tiket masuk termasuk sangat murah sekali. Dengan Rp6.000 kamu sudah mendapatkan tempat untuk parkir dan boleh masuk ke tempat wisata ini. Namun harga bisa saja sewaktu - waktu meyesuaikan. Jam operasional mulai dari pukul 09.00 siang sampai 17.00 sore (WIB)"};



    public WaterBoomFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewContainer = inflater.inflate(R.layout.spot_list, container, false);
        viewContainer.setBackgroundColor(getResources().getColor(R.color.waterBoomBackgrundAll));

        final ArrayList<Spot> spotArrayList = new ArrayList<Spot>();
        for (int i = 0; i <placeName.length; i ++){
            Spot spot = new Spot(placePhoto[i], placePhotoSource[i], placeName[i], placeLocation[i], placeDescription[i]);
            spotArrayList.add(spot);
        }

        spotAdapter = new SpotAdapter(getActivity(), spotArrayList, R.color.waterBoomBackground);

        listView = viewContainer.findViewById(R.id.list);

        listView.setAdapter(spotAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Spot getList = spotArrayList.get(i);
                Intent intent = new Intent(getActivity(), WaterBoomDescription.class);
                intent.putExtra("photo", getList.getSpotPicture());
                intent.putExtra("photoSource", getList.getSourcePicture());
                intent.putExtra("spotTitle", getList.getSpotName());
                intent.putExtra("spotLocation", getList.getSpotLocation());
                intent.putExtra("spotDescription", getList.getSpotDescription());
                startActivity(intent);
            }
        });

        searchView = viewContainer.findViewById(R.id.searchForFragment);
        searchView.setOnQueryTextListener(this);
        return viewContainer;



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

