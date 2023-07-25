package tubesapotek;

import config.koneksi;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    koneksi db = new koneksi();
    static main tk = new main();
    Scanner scanner = new Scanner(System.in);
    boolean isLoggedIn = false;
    boolean isAdmin = false;

    public static void main(String[] args) throws SQLException {
        do {
            tk.login();
        } while (!tk.isLoggedIn);

        if (tk.isAdmin) {
            tk.menuAdmin();
        } else {
            tk.menuKasir();
        }
    }

    public void login() {
        System.out.println("===LOGIN===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (db.authenticateAdmin(username, password)) {
            isAdmin = true;
            isLoggedIn = true;
            System.out.println("Login berhasil sebagai admin!");
        } else if (db.authenticateKasir(username, password)) {
            isAdmin = false;
            isLoggedIn = true;
            System.out.println("Login berhasil sebagai kasir!");
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password Anda.");
        }
    }

    public void menuKasir() throws SQLException {
        System.out.println("===MENU Kasir===");
        System.out.println("1. Penjualan Obat");       
        System.out.println("2. Detail Penjualan Obat");
        System.out.print("Pilih: ");
        int menu = scanner.nextInt();
          switch(menu) {
          case 1:
            System.out.println("==Penjualan Obat==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            penjualanobat ks1 = new penjualanobat();
            if(menu==1){
                ks1.tambahPenjualanObat();
            }else if(menu==2){
                ks1.editPenjualanObat();
            }else if(menu==3){
                ks1.deletePenjualanObat();
            }else if(menu==4){
                ks1.viewAllPenjualanObat();
            }
            
            break;
          case 2:
            System.out.println("==Detail Penjualan Obat==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            penjualanobat ks2 = new penjualanobat();
            
            break;
          default:
            System.out.println("tidur");
        }
      
    }

    public void menuAdmin() {
        System.out.println("===MENU Admin===");
        System.out.println("1. Pembelian Obat");
        System.out.println("2. Detail Pembelian Obat");
        System.out.println("3. Supplier");
        System.out.println("4. Obat");
        System.out.println("5. Kategori");
        System.out.print("Pilih: ");
        
        int menu = scanner.nextInt();
        switch(menu) {
        case 1:
            System.out.println("==Pembelian Obat==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            pembelianobat adm1 = new pembelianobat(menu);
            
            break;
        case 2:
            System.out.println("==Detail Penjualan Obat==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            pembelianobat adm2 = new pembelianobat(menu);
            break;
        case 3:
            System.out.println("==Supplier==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            pembelianobat adm3 = new pembelianobat(menu);
            break;
        case 4:
            System.out.println("==Obat==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            pembelianobat adm4 = new pembelianobat(menu);
            break;
        case 5:
            System.out.println("==Kategori==");
            System.out.println("1. Tambah");
            System.out.println("2. Edit");
            System.out.println("3. Delete");      
            System.out.println("4. View"); 
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            pembelianobat adm5 = new pembelianobat(menu);
            break;
        default:
            System.out.println("tidur");
        
        }
    }

}