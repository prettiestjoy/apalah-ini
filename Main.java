import java.util.ArrayList;
import java.util.Scanner;

class Kendaraan {
    private String nomorPlat;
    private String jenis;
    private String pemilik;

    public Kendaraan(String nomorPlat, String jenis, String pemilik) {
        this.nomorPlat = nomorPlat;
        this.jenis = jenis;
        this.pemilik = pemilik;
    }

    public String getNomorPlat() { return nomorPlat; }
    public String getJenis() { return jenis; }
    public String getPemilik() { return pemilik; }

    public void displayInfo() {
        System.out.println("Nomor Plat: " + nomorPlat);
        System.out.println("Jenis: " + jenis);
        System.out.println("Pemilik: " + pemilik);
    }
}

class Mobil extends Kendaraan {
    public Mobil(String nomorPlat, String pemilik) {
        super(nomorPlat, "Mobil", pemilik);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Informasi Mobil ===");
        super.displayInfo();
    }
}

class Motor extends Kendaraan {
    public Motor(String nomorPlat, String pemilik) {
        super(nomorPlat, "Motor", pemilik);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Informasi Motor ===");
        super.displayInfo();
    }
}

class Pelanggan {
    private String nama;
    private String kontak;

    public Pelanggan(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() { return nama; }
    public String getKontak() { return kontak; }
}

class Servis {
    private String jenisServis;
    private double biaya;

    public Servis(String jenisServis, double biaya) {
        this.jenisServis = jenisServis;
        this.biaya = biaya;
    }

    public String getJenisServis() { return jenisServis; }
    public double getBiaya() { return biaya; }

    public void displayInfo() {
        System.out.println("Jenis Servis: " + jenisServis);
        System.out.println("Biaya: " + biaya);
    }
}

class Perbaikan extends Servis {
    private String deskripsiPerbaikan;

    public Perbaikan(String jenisServis, double biaya, String deskripsiPerbaikan) {
        super(jenisServis, biaya);
        this.deskripsiPerbaikan = deskripsiPerbaikan;
    }

    public String getDeskripsiPerbaikan() { return deskripsiPerbaikan; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Deskripsi Perbaikan: " + deskripsiPerbaikan);
    }
}

class Bengkel {
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private ArrayList<Servis> riwayatServis = new ArrayList<>();
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
        System.out.println("Kendaraan berhasil ditambahkan.");
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    public void catatServis(Servis servis) {
        riwayatServis.add(servis);
        System.out.println("Servis berhasil dicatat.");
    }

    public void tampilkanRiwayatServis() {
        System.out.println("\n=== Riwayat Servis ===");
        for (Servis servis : riwayatServis) {
            servis.displayInfo();
            System.out.println();
        }
    }

    public void tampilkanKendaraan() {
        System.out.println("\n=== Daftar Kendaraan ===");
        for (Kendaraan kendaraan : daftarKendaraan) {
            kendaraan.displayInfo();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bengkel bengkel = new Bengkel();
        int pilihan;

        do {
            System.out.println("\n=== Menu Bengkel ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tambah Pelanggan");
            System.out.println("3. Catat Servis");
            System.out.println("4. Tampilkan Daftar Kendaraan");
            System.out.println("5. Tampilkan Riwayat Servis");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nomor plat: ");
                    String nomorPlat = scanner.nextLine();
                    System.out.print("Jenis kendaraan (1. Mobil, 2. Motor): ");
                    int jenisKendaraan = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama pemilik: ");
                    String pemilik = scanner.nextLine();

                    if (jenisKendaraan == 1) {
                        bengkel.tambahKendaraan(new Mobil(nomorPlat, pemilik));
                    } else if (jenisKendaraan == 2) {
                        bengkel.tambahKendaraan(new Motor(nomorPlat, pemilik));
                    } else {
                        System.out.println("Jenis kendaraan tidak valid.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan kontak pelanggan: ");
                    String kontak = scanner.nextLine();
                    bengkel.tambahPelanggan(new Pelanggan(nama, kontak));
                    break;

                case 3:
                    System.out.print("Jenis servis (1. Servis Umum, 2. Perbaikan): ");
                    int jenisServis = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama servis: ");
                    String namaServis = scanner.nextLine();
                    System.out.print("Masukkan biaya: ");
                    double biaya = scanner.nextDouble();
                    scanner.nextLine();

                    if (jenisServis == 1) {
                        bengkel.catatServis(new Servis(namaServis, biaya));
                    } else if (jenisServis == 2) {
                        System.out.print("Masukkan deskripsi perbaikan: ");
                        String deskripsi = scanner.nextLine();
                        bengkel.catatServis(new Perbaikan(namaServis, biaya, deskripsi));
                    } else {
                        System.out.println("Jenis servis tidak valid.");
                    }
                    break;

                case 4:
                    bengkel.tampilkanKendaraan();
                    break;

                case 5:
                    bengkel.tampilkanRiwayatServis();
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);

        scanner.close();
    }
}