import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Karyawan> karyawanList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Insert Data Karyawan");
            System.out.println("2. View Data Karyawan");
            System.out.println("3. Update Data Karyawan");
            System.out.println("4. Delete Data Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    insertDataKaryawan();
                    break;
                case 2:
                    viewDataKaryawan();
                    break;
                case 3:
                    updateDataKaryawan();
                    break;
                case 4:
                    deleteDataKaryawan();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan masukkan pilihan yang benar.");
            }
        } while (pilihan != 0);
    }

    private static void insertDataKaryawan() {
        System.out.print("Masukkan nama karyawan: ");
        String nama = input.next();
        System.out.print("Masukkan jenis kelamin (Laki-Laki / Perempuan): ");
        String jenisKelamin = input.next();
        System.out.print("Masukkan jabatan (Manager / Supervisor / Admin): ");
        String jabatan = input.next();

        int gaji = 0;
        switch (jabatan) {
            case "Manager":
                gaji = 8000000;
                break;
            case "Supervisor":
                gaji = 6000000;
                break;
            case "Admin":
                gaji = 4000000;
                break;
        }

        int jumlahJabatan = 0;
        for (Karyawan karyawan : karyawanList) {
            if (karyawan.getJabatan().equals(jabatan)) {
                jumlahJabatan++;
            }
        }

        if (jumlahJabatan % 3 == 0) {
            double bonus = 0;
            switch (jabatan) {
                case "Manager":
                    bonus = gaji * 0.1;
                    break;
                case "Supervisor":
                    bonus = gaji * 0.075;
                    break;
                case "Admin":
                    bonus = gaji * 0;
            }
        }
    }

    public static void viewDataKaryawan(ArrayList<Karyawan> listKaryawan) {
        System.out.println("Data Karyawan PT Meksiko");
        System.out.println("---------------------------------");
        System.out.println("No.\tKode\tNama\tJenis Kelamin\tJabatan\tGaji");
        Collections.sort(listKaryawan, new Comparator<Karyawan>() {
            @Override
            public int compare(Karyawan karyawan1, Karyawan karyawan2) {
                return karyawan1.getNama().compareTo(karyawan2.getNama());
            }
        });
        int i = 1;
        for (Karyawan karyawan : listKaryawan) {
            System.out.println(i + "\t" + karyawan.getKode() + "\t" + karyawan.getNama() + "\t" + karyawan.getJenisKelamin() + "\t\t" + karyawan.getJabatan() + "\t" + karyawan.getGaji());
            i++;
        }
    }

    private static void updateDataKaryawan() {
    System.out.println("Update Data Karyawan");
    System.out.println("====================");
    System.out.println();
    
    // Menampilkan data karyawan yang tersedia
    System.out.println("Daftar Karyawan: ");
    sortDataKaryawan();
    for (int i = 0; i < daftarKaryawan.size(); i++) {
        Karyawan k = daftarKaryawan.get(i);
        System.out.println((i + 1) + ". " + k.getKodeKaryawan() + " - " + k.getNamaKaryawan());
    }
    
    // Meminta user memilih data karyawan yang akan diupdate
    System.out.print("Masukkan nomor data yang akan diupdate: ");
    int pilihan = input.nextInt();
    if (pilihan <= 0 || pilihan > daftarKaryawan.size()) {
        System.out.println("Data tidak ditemukan.");
        return;
    }
    
    // Meminta user memasukkan data karyawan yang baru
    Karyawan k = daftarKaryawan.get(pilihan - 1);
    System.out.println("Data saat ini:");
    System.out.println("Kode Karyawan: " + k.getKodeKaryawan());
    System.out.print("Masukkan kode karyawan baru (0 jika tidak ingin diupdate): ");
    String kodeKaryawanBaru = input.nextLine().trim();
    if (!kodeKaryawanBaru.equals("0")) {
        k.setKodeKaryawan(kodeKaryawanBaru);
    }
    
    System.out.println("Nama Karyawan: " + k.getNamaKaryawan());
    System.out.print("Masukkan nama karyawan baru (0 jika tidak ingin diupdate): ");
    String namaKaryawanBaru = input.nextLine().trim();
    if (!namaKaryawanBaru.equals("0")) {
        k.setNamaKaryawan(namaKaryawanBaru);
    }
    
    System.out.println("Jenis Kelamin: " + k.getJenisKelamin());
    System.out.print("Masukkan jenis kelamin baru (0 jika tidak ingin diupdate): ");
    String jenisKelaminBaru = input.nextLine().trim();
    if (!jenisKelaminBaru.equals("0")) {
        k.setJenisKelamin(jenisKelaminBaru);
    }
    
    System.out.println("Jabatan: " + k.getJabatan());
    System.out.print("Masukkan jabatan baru (0 jika tidak ingin diupdate): ");
    String jabatanKaryawanBaru = input.nextLine().trim();
    if (!jabatanKaryawanBaru.equals("0")) {
        k.setJenisKelamin(jabatanKaryawanBaru);
        }
    }
    
    public static void showDataKaryawan() {
    // sorting array karyawan by namaKaryawan
    Arrays.sort(karyawan, (Karyawan a, Karyawan b) -> a.namaKaryawan.compareTo(b.namaKaryawan));
    
    System.out.println("Data Karyawan:");
    System.out.println("No.\tKode Karyawan\tNama Karyawan\tJenis Kelamin\tJabatan\tGaji");
    
    int i = 1;
    for (Karyawan k : karyawan) {
        if (k == null) {
        continue;
        }
        System.out.println(i + "\t" + k.kodeKaryawan + "\t\t" + k.namaKaryawan + "\t\t" + k.jenisKelamin + "\t\t" + k.jabatan + "\t\t" + k.gaji);
        i++;
    }
    }

    private static void deleteDataKaryawan() {
    System.out.println("Menghapus data karyawan");
    System.out.println("Daftar data karyawan:");

    // Menampilkan daftar karyawan
    showDataKaryawan();

    System.out.print("Masukkan nomor karyawan yang ingin dihapus: ");
    int deleteIndex = scanner.nextInt() - 1;
    scanner.nextLine();

    // Menghapus data karyawan dari list
    karyawanList.remove(deleteIndex);

    System.out.println("Data karyawan berhasil dihapus");
    }
}
