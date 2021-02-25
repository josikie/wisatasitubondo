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
import java.util.SortedMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hotel extends Fragment implements androidx.appcompat.widget.SearchView.OnQueryTextListener, SearchView.OnQueryTextListener{

    private ListView listView;
    private SpotAdapter spotAdapter;
    private SearchView searchView;
    private String[] placeName = new String[]{"Hotel Karisma", "Hotel dan Restoran Bintang", "Kampung Nelayan Resort", "Rosali Hotel Situbondo", "Edhotel Lotus Hotel", "Hotel Sansui Situbondo",
            "SPOT ON 1958 Asembagus Family", "SPOT ON 2422 Hotel Moga Sari",  "Hotel Ramayana","Hotel Baru"};
    private int[] placePicture = new int[]{R.drawable.hotelkarisma, R.drawable.hotelbintang, R.drawable.kampungnelayanresort, R.drawable.rosali, R.drawable.edhotellotus, R.drawable.hotelsansui,
            R.drawable.familyasembagus, R.drawable.hotelmogasari,  R.drawable.hotelramayana, R.drawable.hotelbaru};
    private String[] placeSourcePicture = new String[]{"Sumber gambar : tripadvisor.com", "Sumber gambar : facebook.com", "Sumber gambar : pegipegi.com", "Sumber gambar : foursquare.com",
            "Sumber gambar : edhotul-lotus.com", "Sumber gambar : pegipegi.com", "sumber gambar : booking.com", "Sumber gambar :  a-hotel.com", "Sumber gambar : foursquare.com", "Sumber gambar : google, Adie Phawank"};

    private String[] placeLocation = new String[]{"Jalan Banyuwangi NO.KM.3,7, Karang Malang, Kesambi Rampak, Kapongan, Situbondo, Jawa Timur", "Jalan Raya Banyuglugur RT 1 RW 2, Banyuglugur, Situbondo, Jawa Timur, Indonesia",
            "Jalan Raya Surabaya - Situbondo KM 189, Situbondo, Jawa Timur", "Jl.Pb. Sudirman NO.52, Karangasem, Patokan, Situbondo, Indonesia", "Jalan Gunung Arjuno No.12, Panji, Situbondo, Jawa Timur, Indonesia",
            "Jl. Raya Pasir Putih, Gundit, Klatakan, Kendit, Situbondo, Jawa Timur, Indonesia", "Jl. Raya Asembagus, Krajan, Wringinanom, Asembagus, Situbondo, Jawa Timur, Indonesia","Jl. Seroja No.22 Dawuhan, Situbondo, Jawa Timur, Indonesia",
            "Jl. Sepudi No.11A, Mimbaan, Panji, Situbondo, Jawa Timur, Indonesia", "Jl. Basuki Rahmat No.219, Mimbaan, Situbondo, Jawa Timur, Indonesia"};

    private String[] placeDescription = new String[]{
            "Hotel Karisma adalah hotel yang berjarak 6,16 Km dari terminal Situbondo. Pelayan hotel ini bagus dan harga masih ramah di kantong. Fasilitas cukup lengkap seperti restaurant, resepsionis 24 jam, area parkir, Cafe, Wi-Fi, laundry dan lainnya. Harga sewa kamar tipe biasa hanya Rp250.000 per malam. Namun ada juga kamar VIP yang dapat di sewa, tarifnya mulai dari Rp425.000 per malam.",
            "Hotel ini menyediakan dua tipe kamar yang dapat disewa, yaitu standard room, dan superior room. Biaya sewa permalam untuk standard room sekitar Rp236.000 per malam. sedangkan untuk Superior room memiliki harga sewa Rp368.000 permalam. Fasilitas yang ada di antaranya area parkir, Wi-Fi, Cafe, restaurant, fasilitas rapat, laundry, resepsionis 24 jam, dan layanan kamar.",
            "Memiliki tiga jenis tipe kamar yang bisa di sewa. Di antaranya tipe standar dengan harga Rp400.000 per malam, tipe exekutive dengan harga Rp700.000 per malam, dan terakhir tipe VIP dengan harga Rp1.100.000. Menginap di resort ini seperti tinggal di kampung nelayan. Dinding kamar yang disewakan berbahan kayu memberikan nuansa alami. Fasilitas cukup lengkap dan memadai. ",
            "Rosali Hotel Situbondo adalah hotel di Situbondo yang menawarkan suasana tenang dan nyaman. Hotel ini dikelilingi kebun tropis yang berisi berbagai macam flora. Kelebihan hotel ini adalah setiap kamar hotel memiliki teras dan tempat duduk diluar untuk menikmati kebun tropis yang asri. Rosali Hotel memiliki bangunan yang bergaya modern tradisional. Ada 5 tipe kamar yang dapat kamu sewa yaitu The Orientals dengan harga Rp880.000 per malam, The Superior dengan Harga Rp438.900 per malam, The VIP Bungalows per malam, dan The Wooden House dengan harga sewa Rp1.375.000 per malam. Fasilitas di hotel ini cukup lengkap. ",
            "Berjarak 3,7 km dari terminal Situbondo. Letaknya strategis. Fasilitas yang ditawarkan di antaranya layanan kamar area parkir, restoran, Wi-Fi, area bebas rokok, fasilitas bisnis, layanan organizer konferensi, fasilitas rapat, layanan tamu, resepsionis 24 jam, keamanan 24 jam, internet kamar, dan lainnya. Tipe kamar yang bisa di sewa di antaranya deluxe room, deluxe twin room, and suite room. ",
            "Hotel ini sangat dekat dengan Pantai Pasir Putih di Situbondo. Harga kamar yang di sewa menyesuaikan. Di hotel ini Kamu bisa menikmati pemandangan pantai dan gunung suasana sangat tenang dan nyaman. fasilitas di antaranya area parkir gratis kolam renang resepsionis 24 jam layanan kamar ruangan ber-ac dan lainnya. Hotel ini mengijinkan pengunjung membawa binatang peliharaan.",
            "SPOT ON 1958 Asembagus Family adalah hotel yang sangat dekat dengan tempat wisata Barokah Park. Fasilitas-fasilitas yang disediakan di antaranya fasilitas untuk penyandang disabilitas, resepsionis 24 jam, staf multibahasa, ruangan ber-ac, area bebas rokok, Wi-Fi dan lainnya. Harga sewa kamar di hotel ini mulai dari Rp86.430 per malam.",
            "SPOT ON 2422 Hotel Moga Sari adalah hotel yang sangat dekat dengan alun-alun Situbondo dan dekat dengan pusat kota. Fasilitas mulai dari ruang keluarga, area bebas rokok, area parkir, layanan kamar 24 jam, Wi-Fi,  resepsionis 24 jam, staf multibahasa, dan lainnya. Harga sewa kamar per malam mulai dari Rp72.972.",
            "Hotel Ramayana adalah hotel yang lokasinya sangat dekat dengan terminal Situbondo. Harga sewa kamar mulai dari Rp65.000. Ada ciri khas dari pelayanannya yaitu, setiap pagi pengunjung mendapatkan welcome drink gratis (minuman dan telur matang). Fasilitasnya cukup lengkap.",
            "Hotel Baru memiliki letak yang sangat strategis. Disamping kirinya ada Conato Bakery sedangkan disamping kanannya ada Masjid. Kota ini dekat dengan pusat kota. Harga sewa menyesuaikan. Fasilitas yang cukup memadai. Didepan hotel ini juga ada tempat cuci mobil dan cuci motor yang memudahkan pengunjung hotel."};




    public Hotel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate view
        View view = inflater.inflate(R.layout.spot_list, container, false);
        view.setBackgroundColor(getResources().getColor(R.color.hotelAllBackground));

        final ArrayList<Spot> spotArrayList = new ArrayList<Spot>();

        // array list to take data with Spot
        for (int i = 0; i < placeName.length; i++){
            Spot spot = new Spot(placePicture[i], placeSourcePicture[i], placeName[i], placeLocation[i], placeDescription[i]);
            spotArrayList.add(spot);
        }

        spotAdapter = new SpotAdapter(getActivity(), spotArrayList, R.color.hotelBackground);


         listView = view.findViewById(R.id.list);

        listView.setAdapter(spotAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Spot getList = spotArrayList.get(i);
                Intent intent = new Intent(getActivity(), HotelActivity.class);
                intent.putExtra("photo", getList.getSpotPicture());
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
