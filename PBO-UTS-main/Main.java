import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            RentalSystem rental = new RentalSystem();

            boolean berjalan = true;

            while (berjalan) {

                System.out.println("\n==============================");
                System.out.println("     SISTEM RENTAL MOBIL");
                System.out.println("==============================");
                System.out.println("1. Tambah Mobil");
                System.out.println("2. Tampilkan Semua Mobil");
                System.out.println("3. Cari Mobil");
                System.out.println("4. Sewa Mobil");
                System.out.println("5. Kembalikan Mobil");
                System.out.println("6. Hitung Biaya Rental");
                System.out.println("7. Keluar");
                System.out.print("Pilih menu: ");

                String pilihan = input.nextLine().trim();

                try {

                    switch (pilihan) {
                        case "1" -> tambahMobil(input, rental);
                        case "2" -> rental.tampilkanSemuaMobil();
                        case "3" -> cariMobil(input, rental);
                        case "4" -> {
                            System.out.print("Masukkan ID mobil: ");
                            String idSewa = input.nextLine();

                            rental.sewaMobil(idSewa);
                        }
                        case "5" -> {
                            System.out.print("Masukkan ID mobil: ");
                            String idKembali = input.nextLine();

                            rental.kembalikanMobil(idKembali);
                        }
                        case "6" -> {
                            System.out.print("Masukkan ID mobil: ");
                            String idBiaya = input.nextLine();

                            int hari = readInt(input, "Jumlah hari");
                            rental.hitungBiaya(idBiaya, hari);
                        }
                        case "7" -> {
                            berjalan = false;
                            System.out.println("Program selesai.");
                        }
                        default -> System.out.println("Menu tidak tersedia.");
                    }

                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    // TAMBAH MOBIL

    public static void tambahMobil(
            Scanner input,
            RentalSystem rental) {

        System.out.println("\n===== TAMBAH MOBIL =====");
        String jenis;
            while (true) {
            System.out.print("Jenis mobil (1 = Mobil, 2 = SUV): ");
            jenis = input.nextLine().trim();

            if (jenis.equals("1") || jenis.equals("2")) {
            break;
        }

    System.out.println("Jenis mobil tidak valid. Masukkan 1 atau 2.");
}
        System.out.print("ID: ");
        String id = input.nextLine();

        System.out.print("Merk: ");
        String merk = input.nextLine();

        System.out.print("Model: ");
        String model = input.nextLine();

        System.out.print("Nomor Plat: ");
        String nomorPlat = input.nextLine();

        int tahun = readInt(input, "Tahun");
        double hargaSewa = readDouble(input, "Harga Sewa per Hari");

        Mobil mobil;

        switch (jenis) {
            case "1" -> mobil = new Mobil(
                id,
                merk,
                model,
                nomorPlat,
                tahun,
                hargaSewa
            );
            case "2" -> mobil = new SUV(
                id,
                merk,
                model,
                nomorPlat,
                tahun,
                hargaSewa
            );
            default -> {
                System.out.println("Jenis mobil tidak valid.");
                return;
            }
        }

        rental.tambahMobil(mobil);

        System.out.println("Mobil berhasil ditambahkan.");
    }

    // CARI MOBIL

    public static void cariMobil(
            Scanner input,
            RentalSystem rental) {

        System.out.println("\n===== CARI MOBIL =====");
        System.out.println("1. Berdasarkan ID");
        System.out.println("2. Berdasarkan Merk dan Model");
        System.out.print("Pilih: ");

        String pilihan = input.nextLine().trim();

        Mobil mobil;

        switch (pilihan) {
            case "1" -> {
                System.out.print("Masukkan ID: ");
                String id = input.nextLine();
                mobil = rental.cariMobil(id);
            }
            case "2" -> {
                System.out.print("Masukkan Merk: ");
                String merk = input.nextLine();

                System.out.print("Masukkan Model: ");
                String model = input.nextLine();

                mobil = rental.cariMobil(
                    merk,
                    model
                );
            }
            default -> {
                System.out.println("Pilihan tidak valid.");
                return;
            }
        }

        if (mobil != null) {

            System.out.println("\nMobil ditemukan:");
            mobil.tampilkanInfo();

        } else {

            System.out.println("Mobil tidak ditemukan.");
        }
    }

    private static int readInt(Scanner input, String label) {
        while (true) {
            try {
                System.out.print(label + ": ");
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka bulat.");
            }
        }
    }

    private static double readDouble(Scanner input, String label) {
        while (true) {
            try {
                System.out.print(label + ": ");
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }
    }
}