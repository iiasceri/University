import java.util.ArrayList;

public class Etaj
{
	int nrEtaj;
	public ArrayList<Apartament> apartament = new ArrayList<Apartament>();

	Etaj()
	{
		MyHelperClass helper = new MyHelperClass();

		this.setNrEtaj(helper.getRandomInt(-2, 10));

		int NOFApartament = helper.getRandomInt(2, 5);
		for (int i = 0; i < NOFApartament; i++) {
			apartament.add(new Apartament());
		}
	}

	Etaj(int nrEtaj)
	{
		this.setNrEtaj(nrEtaj);
	}

	public void setNrEtaj(int nrEtaj)
	{
		this.nrEtaj = nrEtaj;
	}

	public int getNrEtaj()
	{
		return this.nrEtaj;
	}

	public void afisare()
	{
		MyHelperClass helper = new MyHelperClass();
                System.out.println("Etaj: ");
		System.out.println(helper.getWhiteSpace(6) + this.getNrEtaj());

		for (int i = 0; i < this.apartament.size(); i++) {
			this.apartament.get(i).afisare();
		}
	}
}