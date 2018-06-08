import java.util.Random;

class MyHelperClass
{
	String getRandomString(int min, int max, boolean makeName)
	{
		Random rand = new Random();
		String str = "";
		int randomLetter;
		String lett = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		int randomNum = rand.nextInt(max - min) + min;
		for (int i = 0; i < randomNum; i++) {
			randomLetter = rand.nextInt(lett.length());
			str += lett.charAt(randomLetter);
		}

		if (makeName) {
			str = str.toLowerCase();
			str =  str.substring(0,1).toUpperCase() + str.substring(1, str.length());

			return str;
		} else {
			return str;
		}
	}

	float getRandomFloat(float min, float max)
	{
		Random rand = new Random();

		return (min + rand.nextFloat() * (max - min));
	}

	int getRandomInt(int min, int max)
	{
		Random rand = new Random();

		return rand.nextInt(max - min) + min;
	}

	boolean getRandomBoolean()
	{
		Random rand = new Random();
		
		return rand.nextBoolean();
	}

	String getWhiteSpace(int number)
	{
		String str = "";

		for (int i = 0; i < number; i++) {
			str += " ";
		}

		return str;
	}
}