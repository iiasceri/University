
public class Camera
{
	String tipul;
	double aria;

	Camera()
	{
		MyHelperClass helper = new MyHelperClass();
		String tipuri[] = {"dormitor", "baie", "veceu", "bucatarie"};
		int randomTip = helper.getRandomInt(0, 4);

		this.setTipul(tipuri[randomTip]);
		this.setAria((double) helper.getRandomFloat((float) 10, (float) 3000));
	}

	Camera(String tipul, double aria, boolean sex)
	{
		this.setTipul(tipul);
		this.setAria(aria);
	}

	public void setTipul(String tipul)
	{
		this.tipul = tipul;
	}

	public String getTipul()
	{
		return this.tipul;
	}

	public void setAria(double aria)
	{
		this.aria = aria;
	}

	public double getAria()
	{
		return this.aria;
	}

	public void afisare()
	{
		MyHelperClass helper = new MyHelperClass();
                System.out.println("Camera: ");
		System.out.println(helper.getWhiteSpace(10) + this.getTipul());
		System.out.println(helper.getWhiteSpace(10) + this.getAria());
	}
}