import java.util.ArrayList;

public class Strada
{
	String denumire;
 	public ArrayList<BlocLocativ> blocLocativ = new ArrayList<BlocLocativ>();

 	Strada()
	{
		MyHelperClass helper = new MyHelperClass();

		this.setDenumire(helper.getRandomString(3, 15, true));

		int NOFBlocLocativ = helper.getRandomInt(2, 5);
		for (int i = 0; i < NOFBlocLocativ; i++) {
			blocLocativ.add(new BlocLocativ());
		}
	}

	Strada(String denumire)
	{
		this.setDenumire(denumire);
	}

	public void setDenumire(String denumire)
	{
		this.denumire = denumire;
	}

	public String getDenumire()
	{
		return this.denumire;
	}

	public void afisare()
	{
		MyHelperClass helper = new MyHelperClass();

		System.out.println("General: " + helper.getWhiteSpace(2) + this.getDenumire());

		for (int i = 0; i < this.blocLocativ.size(); i++) {
			this.blocLocativ.get(i).afisare();
		}
	}
}