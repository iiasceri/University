
public class Locuitor
{
	String nume;
	int varsta;
	boolean sex;

	Locuitor()
	{
		MyHelperClass helper = new MyHelperClass();

		this.setVarsta(helper.getRandomInt(15, 30));
		this.setSex(helper.getRandomBoolean());
		this.setNume(helper.getRandomString(4, 10, true));
	}

	Locuitor(String nume, int varsta, boolean sex)
	{
		this.setNume(nume);
		this.setVarsta(varsta);
		this.setSex(sex);
	}

	public void setNume(String nume)
	{
		this.nume = nume;
	}

	public String getNume()
	{
		return this.nume;
	}

	public void setVarsta(int varsta)
	{
		this.varsta = varsta;
	}

	public int getVarsta()
	{
		return this.varsta;
	}

	public boolean getSex()
	{
		return this.sex;
	}

	public void setSex(boolean sex)
	{
		this.sex = sex;
	}

	public void afisare()
	{
		MyHelperClass helper = new MyHelperClass();

		System.out.println(helper.getWhiteSpace(10) + this.getNume());
		System.out.println(helper.getWhiteSpace(10) + this.getVarsta());
                System.out.println("Locuitor: ");
		String sex[] = {"barbat", "femeie"};
		if (this.getSex()) {
			System.out.println(helper.getWhiteSpace(10) + sex[0]);
		} else {
			System.out.println(helper.getWhiteSpace(10) + sex[1]);
		}
	}
}