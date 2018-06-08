import java.util.ArrayList;

class Apartament
{
	String nrApart;
	public ArrayList<Camera> camera = new ArrayList<Camera>();
	public ArrayList<Locuitor> locuitor = new ArrayList<Locuitor>();

	Apartament()
	{
		MyHelperClass helper = new MyHelperClass();

		this.setNrApart(helper.getRandomString(3, 5, true) + " - " + helper.getRandomInt(1, 100));

		int NOFCamera = helper.getRandomInt(2, 5);
		for (int i = 0; i < NOFCamera; i++) {
			camera.add(new Camera());
		}

		int NOFLocuitor = helper.getRandomInt(2, 5);
		for (int i = 0; i < NOFLocuitor; i++) {
			locuitor.add(new Locuitor());
		}
	}

	Apartament(String nrApart)
	{
		this.setNrApart(nrApart);
	}

	public void setNrApart(String nrApart)
	{
		this.nrApart = nrApart;
	}

	public String getNrApart()
	{
		return this.nrApart;
	}

	public void afisare()
	{
		MyHelperClass helper = new MyHelperClass();

		System.out.println(helper.getWhiteSpace(8) + this.getNrApart());

		for (int i = 0; i < this.camera.size(); i++) {
			this.camera.get(i).afisare();
		}

		for (int i = 0; i < this.locuitor.size(); i++) {
			this.locuitor.get(i).afisare();
		}
	}
}