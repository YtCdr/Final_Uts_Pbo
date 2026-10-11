public class Kendaraan {

    // Attribute
    private String id;
    private String merk;
    private String model;
    private String nomorPlat;
    private int tahun;
    private double hargaSewa;
    private boolean tersedia;

    // Default Constructor
    public Kendaraan() {
        this.id = "";
        this.merk = "";
        this.model = "";
        this.nomorPlat = "";
        this.tahun = 2026;
        this.hargaSewa = 0;
        this.tersedia = true;
    }

    // Parameterized Constructor
    public Kendaraan(String id, String merk, String model,
                     String nomorPlat, int tahun, double hargaSewa) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID tidak boleh kosong.");
        }
        if (merk == null || merk.trim().isEmpty()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong.");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model tidak boleh kosong.");
        }
        if (nomorPlat == null || nomorPlat.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nomor plat tidak boleh kosong."
            );
        }
        if (tahun < 1980 || tahun > 2026) {
            throw new IllegalArgumentException(
                "Tahun kendaraan harus antara 1980 sampai 2026."
            );
        }
        if (hargaSewa <= 0) {
            throw new IllegalArgumentException(
                "Harga sewa harus lebih dari 0."
            );
        }

        this.id = id;
        this.merk = merk;
        this.model = model;
        this.nomorPlat = nomorPlat;
        this.tahun = tahun;
        this.hargaSewa = hargaSewa;
        this.tersedia = true;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID tidak boleh kosong.");
        }

        this.id = id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if (merk == null || merk.trim().isEmpty()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong.");
        }

        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model tidak boleh kosong.");
        }

        this.model = model;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public void setNomorPlat(String nomorPlat) {
        if (nomorPlat == null || nomorPlat.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nomor plat tidak boleh kosong."
            );
        }

        this.nomorPlat = nomorPlat;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        if (tahun < 1980 || tahun > 2026) {
            throw new IllegalArgumentException(
                "Tahun kendaraan harus antara 1980 sampai 2026."
            );
        }

        this.tahun = tahun;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        if (hargaSewa <= 0) {
            throw new IllegalArgumentException(
                "Harga sewa harus lebih dari 0."
            );
        }

        this.hargaSewa = hargaSewa;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    // Behavior / Method
    public void sewa() {

        if (!tersedia) {
            throw new IllegalStateException(
                "Mobil sedang disewa."
            );
        }

        tersedia = false;
    }

    public void kembalikan() {

        if (tersedia) {
            throw new IllegalStateException(
                "Mobil sudah tersedia."
            );
        }

        tersedia = true;
    }

    // Method yang akan dioverride oleh subclass
    public double hitungBiayaSewa(int jumlahHari) {

        if (jumlahHari <= 0) {
            throw new IllegalArgumentException(
                "Jumlah hari harus lebih dari 0."
            );
        }

        return hargaSewa * jumlahHari;
    }

    public void tampilkanInfo() {

        System.out.println("ID          : " + id);
        System.out.println("Merk        : " + merk);
        System.out.println("Model       : " + model);
        System.out.println("Nomor Plat  : " + nomorPlat);
        System.out.println("Tahun       : " + tahun);
        System.out.printf("Harga/Hari  : Rp %.0f%n", hargaSewa);
        System.out.println(
            "Status      : " +
            (tersedia ? "Tersedia" : "Disewa")
        );
    }
}