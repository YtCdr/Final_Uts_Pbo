public class SUV extends Mobil {

    // Default Constructor
    public SUV() {
        super();
    }

    // Parameterized Constructor
    public SUV(
            String id,
            String merk,
            String model,
            String nomorPlat,
            int tahun,
            double hargaSewa) {

        super(
            id,
            merk,
            model,
            nomorPlat,
            tahun,
            hargaSewa
        );
    }

    // Overriding
    @Override
    public double hitungBiayaSewa(int jumlahHari) {

        if (jumlahHari <= 0) {
            throw new IllegalArgumentException(
                "Jumlah hari harus lebih dari 0."
            );
        }

        double biaya = getHargaSewa() * jumlahHari;

        return biaya * 1.10;
    }

    @Override
    public String getJenis() {
        return "SUV";
    }
}