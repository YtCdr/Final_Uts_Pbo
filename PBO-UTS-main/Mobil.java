public class Mobil extends Kendaraan {

    // Default Constructor
    public Mobil() {
        super();
    }

    // Parameterized Constructor
    public Mobil(
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

    public String getJenis() {
        return "Mobil";
    }
}