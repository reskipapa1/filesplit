package passenger;


    // Kelas untuk merepresentasikan satu penumpang
class Passenger {
    String name;
    Passenger next;

    // Konstruktor untuk menginisialisasi nama penumpang
    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

// Kelas untuk merepresentasikan penerbangan
class Flight {
    private Passenger head;

    // Konstruktor untuk menginisialisasi daftar penumpang kosong
    public Flight() {
        this.head = null;
    }

    // Metode untuk menambah penumpang di akhir daftar
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;  // Jika daftar kosong, jadikan penumpang pertama
        } else {
            Passenger temp = head;
            while (temp.next != null) {
                temp = temp.next;  // Menelusuri sampai penumpang terakhir
            }
            temp.next = newPassenger;  // Menambahkan penumpang baru di akhir daftar
        }
    }

    // Metode untuk menghapus penumpang berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("No passengers to remove.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;  // Jika penumpang yang dihapus adalah yang pertama
            System.out.println("Passenger " + name + " removed.");
            return;
        }

        Passenger current = head;
        Passenger prev = null;

        // Mencari penumpang yang sesuai
        while (current != null && !current.name.equals(name)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Passenger " + name + " not found.");
            return;
        }

        prev.next = current.next;  // Memutuskan hubungan dengan penumpang yang dihapus
        System.out.println("Passenger " + name + " removed.");
    }

    // Metode untuk menampilkan daftar penumpang
    public void displayPassengers() {
        if (head == null) {
            System.out.println("No passengers.");
            return;
        }

        Passenger temp = head;
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;  // Menelusuri setiap penumpang
        }
        System.out.println("End");
    }


// Main class untuk menjalankan program
    public static void main(String[] args) {
        Flight flight = new Flight();

        // Menambahkan penumpang ke daftar
        flight.addPassenger("John");
        flight.addPassenger("Alice");
        flight.addPassenger("Bob");

        // Menampilkan daftar penumpang
        System.out.println("Passenger list:");
        flight.displayPassengers();

        // Menghapus penumpang "Alice"
        flight.removePassenger("Alice");
        System.out.println("Passenger list after removal:");
        flight.displayPassengers();
    }
}


