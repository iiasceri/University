import java.util.ArrayList;

class BlocLocativ
{
	String nrCasei;
	public ArrayList<Etaj> etaj = new ArrayList<Etaj>();

	BlocLocativ()
	{
		MyHelperClass helper = new MyHelperClass();

		this.setNrCasei(helper.getRandomInt(1, 100) + "/" + helper.getRandomString(1, 2, false));

		int NOFEtaj = helper.getRandomInt(2, 5);
		for (int i = 0; i < NOFEtaj; i++) {
			etaj.add(new Etaj());
		}
	}

	BlocLocativ(String nrCasei)
	{
		this.setNrCasei(nrCasei);
	}

	public void setNrCasei(String nrCasei)
	{
		this.nrCasei = nrCasei;
	}

	public String getNrCasei()
	{
		return this.nrCasei;
	}

	public void afisare()
	{
		MyHelperClass helper = new MyHelperClass();

		System.out.println("Bloc: " + helper.getWhiteSpace(4) + this.getNrCasei());

		for (int i = 0; i < this.etaj.size(); i++) {
			this.etaj.get(i).afisare();
		}
	}
}