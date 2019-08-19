package com.kuycoding.rumahadat.model;

import java.util.ArrayList;

public class RumahData {
    public static String[][] data = new String[][]{
            {
                "Rumah Adat Joglo",
                    "Jawa Tengah",
                    "Bentuk arsitektur rumah ini sangat unik dan sarat akan nilai-nilai kebudayaan masyarakat Jawa. Dibangun dari kayu jati, menjadikan struktur rumah ini tahan lama dan juga kuat. Bangunan ini juga memiliki arsitektur unik yaitu berbentuk persegi panjang dengan atap rumah dibuat tinggi.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_joglo.jpg"
            },
            {
                "Rumah Adat Gadang",
                    "Sumatra Barat",
                    "Rumah tradisional Minangkabau ini memiliki ciri khas unik, yaitu atap berbentuk melengkung dengan ujung lancip. Disebut rumah Gadang karena memang rumah ini berukuran besar. Jumlah kamar di rumah ini tergantung dari jumlah perempuan yang tinggal di dalamnya.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_gadang.jpg"
            },
            {
                "Rumah Adat Kebaya",
                    "DKI Jakarta",
                    "Rumah adat Suku Betawi ini memiliki ciri khas tersendiri yaitu bentuknya seperti kubus serta teras luas yang berfungsi untuk menjamu tamu dan sekaligus tempat berkumpul keluarga. Secara arsitektur, bangunan ini memiliki makna filosofis yakni karakter suku Betawi yang selalu mengedepankan prinsip kekeluargaan, keterbukaan, keramahan dan keharmonisan.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_kebaya_(.jpg"
            },
            {
                "Rumah Adat Limas",
                    "Sumatera Selatan",
                    "Sesuai namanya, rumah ini berbentuk limas dengan bangunan bertingkat-tingkat di mana masing-masing tingkat memiliki filosofi budaya tersendiri. Tingkatan di rumah ini memiliki lima ruangan yang menjadi simbol dari lima jenjang kehidupan masyarakat yaitu usia, jenis, bakat, pangkat dan martabat.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_limas.jpg"
            },
            {
                "Rumah Adat Tongkonan",
                    "Sulawesi Selatan",
                    "Atap dari rumah ini berbentuk melengkung seperti perahu dengan struktur rumah panggung yang memiliki tiang penyangga bulat berdiri berjajar menopang bangunan. Rumah ini juga dicirikan melalui adanya susunan tanduk kerbau di depan rumah sebagai hiasan yang menunjukkan tingkat strata sosial dari pemilik rumah.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_tongkonan.jpg"

            },
            {
                "Rumah Adat Baduy",
                    "Batam",
                    "Rumah adat Baduy adalah rumah panggung yang hampir seluruh bagian rumahnya menggunakan bahan dari bambu. Sifat kekeluargaan Suku Baduy yang sangat kental sangat berpengaruh terhadap proses pembangunan rumah adat ini.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_baduy.jpg"
            },
            {
                "Rumah Adat Mandar",
                    "Sulawesi Barat",
                    "Rumah adat Mandar merupakan rumah adat khas Mamuju, Sulawesi Barat. Rumah ini berstruktur panggung yang disusun dengan tiang-tiang dari kayu balok berukuran setinggi dua meter. Dinding rumah ini menggunakan material papan yang pada umumnya merupakan papan ukir sesuai motif khas dari Suku Mandar.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_mandar.jpg"
            },
            {
                "Rumah Adat Honai",
                    "Papua",
                    "Bentuk rumah ini sangat unik yakni berbentuk seperti kerucut dan dibangun dari material alam. Rumah honai dibedakan menjadi tiga kategori yaitu rumah untuk pria (Honai), wanita (Ebei), dan kandang hewan atau babi (wamai). Rumah honai bagi masyarakat Papua bukan saja menjadi tempat tinggal semata, melainkan juga sebagai tempat pengajaran kehidupan untuk mendidik para pria maupun wanita.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_honai.jpg"
            },
            {
                "Rumah Panggung Minahasa",
                    "Sulawesi Utara",
                    "Rumah adat ini dikenal dengan sebutan \"wale\" atau \"bale\". Rumah ini ditopang oleh beberapa kayu agar dapat berdiri kokoh dan memiliki dua tangga di serambi bagian depannya. Sesuai dengan filosofi masyarakat Minahasa, dua tangga tersebut bermakna khusus pada saat peminangan. Rumah panggung ini bisa dihuni oleh enam hingga delapan keluarga.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_panggung_minahasa.jpg"
            },
            {
                "Rumah Adat Bolon",
                    "Sumatera Utara",
                    "Zaman dahulu, rumah adat Suku Batak ini merupakan tempat tinggal 13 raja di Sumatera Utara. Rumah ini memiliki beberapa kekhasan, di antaranya berbentuk persegi empat dan atapnya seperti pelana kuda. Ruangan dalam rumah ini terbagi menjadi beberapa ruangan khusus, yaitu ruang tamu dan ruangan tempat para istri tamu yang datang.",
                    "https://cdn.sindonews.net/dyn/620/atmaja/rumah_adat_bolon.jpg"
            },
    };
    public static ArrayList<RumahModel> getListData(){
        ArrayList<RumahModel> list = new ArrayList<>();
        for (String[] aData : data) {
            RumahModel rumah = new RumahModel();
            rumah.setName(aData[0]);
            rumah.setFrom(aData[1]);
            rumah.setKeterangan(aData[2]);
            rumah.setPhoto(aData[3]);

            list.add(rumah);
        }
        return list;
    }
}
