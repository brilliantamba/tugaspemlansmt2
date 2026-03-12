class Akun {

    String nama;
    long noRekening;
    String password;
    double saldo;
    int percobaan = 0;

    Akun(String nama, long noRekening, String password, double saldo) {

        if (nama.length() < 4) {
            System.out.println("Nama minimal 4 huruf");
            return;
        }

        if (String.valueOf(noRekening).length() < 8) {
            System.out.println("Nomor rekening minimal 8 digit");
            return;
        }

        if (password.length() < 8 || !adaHurufBesar(password)) {
            System.out.println("Password minimal 8 karakter dan harus ada huruf besar");
            return;
        }

        if (saldo < 0) {
            System.out.println("Saldo tidak boleh minus");
            return;
        }

        this.nama = nama;
        this.noRekening = noRekening;
        this.password = password;
        this.saldo = saldo;
    }

    boolean adaHurufBesar(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    boolean cekPassword(String input) {

        if (percobaan >= 5) {
            System.out.println("Akun terkunci");
            return false;
        }

        if (password.equals(input)) {
            percobaan = 0;
            return true;
        } else {
            percobaan++;
            System.out.println("Password salah (" + percobaan + "/5)");
            return false;
        }
    }

    void cekSaldo(String pass) {
        if (cekPassword(pass)) {
            System.out.println("Saldo: " + saldo);
        } else {
            System.out.println("Transaksi gagal");
        }
    }

    void setor(double jumlah, String pass) {

        if (!cekPassword(pass)) {
            System.out.println("Transaksi gagal");
            return;
        }

        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid");
            return;
        }

        saldo += jumlah;
        System.out.println("Setor berhasil");
        System.out.println("Saldo sekarang: " + saldo);
    }

    void tarik(double jumlah, String pass) {

        if (!cekPassword(pass)) {
            System.out.println("Transaksi gagal");
            return;
        }

        if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup");
            return;
        }

        saldo -= jumlah;
        System.out.println("Penarikan berhasil");
        System.out.println("Saldo sekarang: " + saldo);
    }
}