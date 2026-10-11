import java.util.ArrayList;

public class RentalSystem {

    // Menyimpan semua data mobil
    private final ArrayList<Mobil> daftarMobil;

    // Constructor
    public RentalSystem() {
        daftarMobil = new ArrayList<>();
    }

    // TAMBAH MOBIL

    public void tambahMobil(Mobil mobil) {

        if (mobil == null) {
            throw new IllegalArgumentException(
                "Data mobil tidak boleh kosong."
            );
        }

        // Cek apakah ID sudah digunakan
        if (cariMobil(mobil.getId()) != null) {
            throw new IllegalArgumentException(
                "ID mobil sudah digunakan."
            );
        }
        // Cek apakah nomor plat sudah digunakan
for (Mobil m : daftarMobil) {
    if (m.getNomorPlat().trim().equalsIgnoreCase(mobil.getNomorPlat().trim())) {
        throw new IllegalArgumentException(
            "Nomor plat sudah digunakan."
        );
    }
}

        daftarMobil.add(mobil);
    }

    // CARI MOBIL BERDASARKAN ID

    public Mobil cariMobil(String id) {

        for (Mobil mobil : daftarMobil) {

            if (mobil.getId().equalsIgnoreCase(id)) {
                return mobil;
            }
        }

        return null;
    }

    // METHOD OVERLOADING
    // CARI BERDASARKAN MERK DAN MODEL

    public Mobil cariMobil(String merk, String model) {

        for (Mobil mobil : daftarMobil) {

            if (mobil.getMerk().equalsIgnoreCase(merk)
                    && mobil.getModel().equalsIgnoreCase(model)) {

                return mobil;
            }
        }

        return null;
    }

    // TAMPILKAN SEMUA MOBIL

    public void tampilkanSemuaMobil() {

        if (daftarMobil.isEmpty()) {

            System.out.println(
                "Belum ada data mobil."
            );

            return;
        }

        System.out.println("\n===== DAFTAR MOBIL =====");

        for (Mobil mobil : daftarMobil) {

            System.out.println("----------------------------");

            System.out.println(
                "Jenis : " + mobil.getJenis()
            );

            mobil.tampilkanInfo();
        }
    }

    // SEWA MOBIL

    public void sewaMobil(String id) {

        Mobil mobil = cariMobil(id);

        if (mobil == null) {

            throw new IllegalArgumentException(
                "Mobil dengan ID tersebut tidak ditemukan."
            );
        }

        // Method sewa() berasal dari Kendaraan
        mobil.sewa();

        System.out.println(
            "Mobil " + id + " berhasil disewa."
        );
    }

    // KEMBALIKAN MOBIL

    public void kembalikanMobil(String id) {

        Mobil mobil = cariMobil(id);

        if (mobil == null) {

            throw new IllegalArgumentException(
                "Mobil dengan ID tersebut tidak ditemukan."
            );
        }

        // Method kembalikan() berasal dari Kendaraan
        mobil.kembalikan();

        System.out.println(
            "Mobil " + id + " berhasil dikembalikan."
        );
    }

    // HITUNG BIAYA RENTAL

    public void hitungBiaya(
            String id,
            int jumlahHari) {

        Mobil mobil = cariMobil(id);

        if (mobil == null) {

            throw new IllegalArgumentException(
                "Mobil dengan ID tersebut tidak ditemukan."
            );
        }

        double biaya =
            mobil.hitungBiayaSewa(jumlahHari);

        System.out.println(
            "Jenis mobil : " + mobil.getJenis()
        );

        System.out.println(
            "Lama rental : " + jumlahHari + " hari"
        );

        System.out.printf(
            "Total biaya : Rp %.0f%n", biaya
        );
    }
}