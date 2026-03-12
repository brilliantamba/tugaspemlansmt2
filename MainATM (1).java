import java.util.Scanner;

public class MainATM {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan nomor rekening: ");
        long rek = input.nextLong();
        input.nextLine();

        System.out.print("Masukkan password: ");
        String pass = input.nextLine();

        System.out.print("Masukkan saldo awal: ");
        double saldo = input.nextDouble();
        input.nextLine();

        Akun akun = new Akun(nama, rek, pass, saldo);

        int pilih;

        do {

            System.out.println("\n=== MENU ATM ===");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Uang");
            System.out.println("3. Tarik Uang");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");

            pilih = input.nextInt();
            input.nextLine();

            if (pilih == 4) {
                System.out.println("Terima kasih");
                break;
            }

            System.out.print("Masukkan password: ");
            String p = input.nextLine();

            switch (pilih) {

                case 1:
                    akun.cekSaldo(p);
                    break;

                case 2:
                    System.out.print("Jumlah setor: ");
                    double setor = input.nextDouble();
                    input.nextLine();
                    akun.setor(setor, p);
                    break;

                case 3:
                    System.out.print("Jumlah tarik: ");
                    double tarik = input.nextDouble();
                    input.nextLine();
                    akun.tarik(tarik, p);
                    break;

                default:
                    System.out.println("Menu tidak tersedia");
            }

        } while (true);
    }
}