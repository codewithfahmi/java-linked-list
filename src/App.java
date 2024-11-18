import core.DoubleLinkedList;
import model.Mahasiswa;

public class App {
	public static void main(String[] args) throws Exception {
		DoubleLinkedList<Mahasiswa> mahasiswaList = new DoubleLinkedList<>();
		mahasiswaList
				.addFirst(new Mahasiswa("AgungBP", "Jakarta", 28, 'L', new String[] { "Musik", "Mancing", "Touring" }, 3.5f));
		mahasiswaList
				.addFirst(new Mahasiswa("Rulieta", "Kualakapuas", 17, 'P', new String[] { "Nari", "Rajut", "Jahit" }, 3.0f));
		mahasiswaList
				.addLast(new Mahasiswa("Karti", "Palangkaraya", 18, 'P', new String[] { "Renang", "FB-an", "Masak" }, 2.5f));
		mahasiswaList
				.add(new Mahasiswa("Hermon", "Banjarmasin", 25, 'L', new String[] { "Kasti", "Bola", "Mancing" }, 3.4f), 2);
		mahasiswaList
				.add(new Mahasiswa("Anis", "Surakarta", 30, 'P', new String[] { "Jualan", "Drama", "Nonton" }, 0.3f), 3);
		mahasiswaList.removeFirst();
		mahasiswaList.removeLast();
		mahasiswaList.remove(1);
		mahasiswaList.remove(1);
		mahasiswaList.remove(0);
		mahasiswaList.remove(12);
		System.out.println(mahasiswaList.size());
		System.out.println("SHOW FORWARD");
		mahasiswaList.showForward();
		System.out.println("SHOW BACKWARD");
		mahasiswaList.showBackward();
	}
}
