public class Sedan extends Mobil {

    // Default Constructor
    public Sedan() {
        super();
    }

    // Parameterized Constructor
    public Sedan(String id, String merk, String model,
                 String nomorPlat, int tahun, double hargaSewa) {

        super(id, merk, model, nomorPlat, tahun, hargaSewa);
    }

    // Overriding
    @Override
    public double hitungBiayaSewa(int jumlahHari) {

        if (jumlahHari <= 0) {
            throw new IllegalArgumentException(
                "Jumlah hari harus lebih dari 0."
            );
        }

        // Sedan mendapatkan diskon 5%
        double biaya = getHargaSewa() * jumlahHari;

        return biaya * 0.95;
    }

    @Override
    public String getJenis() {
        return "Sedan";
    }
}