import java.util.ArrayList;

public class StarterClass
{
	public static void main(String args[])
	{
		MyHelperClass helper = new MyHelperClass();
		ArrayList<Strada> strazi = new ArrayList<Strada>();

		int NOFStrada = helper.getRandomInt(2, 5);
		for (int i = 0; i < NOFStrada; i++) {
			strazi.add(new Strada());
			strazi.get(i).afisare();
		}

		//1) -de afisat la ecran adresa blocului locativ(strada,casa) care are nr maxim de femei in Chisinau si de utilizat numai cicluri for each.

		int topBloc[] = {0, 0, 0};
		int nrStrada = -1;

		for (Strada strada:strazi) {
			int nrBloc = -1;
			nrStrada++;

			for (BlocLocativ bloc:strada.blocLocativ) {
				int nrFemei = 0;
				nrBloc++;

				for (Etaj etaj:bloc.etaj) {
					for (Apartament apartament:etaj.apartament) {
						for (Locuitor locuitor:apartament.locuitor) {
							if (!locuitor.getSex()) {
								nrFemei++;
							}
						}
					}
				}

				if (nrFemei > topBloc[0]) {
					topBloc[0] = nrFemei;
					topBloc[1] = nrBloc;
					topBloc[2] = nrStrada;
				}
			}
		}

		System.out.println(strazi.get(topBloc[2]).getDenumire() + " - " + strazi.get(topBloc[2]).blocLocativ.get(topBloc[1]).getNrCasei());
		System.out.println("Femei: " + topBloc[0]);

		System.out.println();

		//2) de afisat la ecran adresa si datele personale ale locuitorului cel mai batran in Chisinau utilizand for-ul obisnuit.

		Locuitor oldestMan = new Locuitor("N-a fost gasit niciun om", 0, true);

		for (int i = 0; i < strazi.size(); i++) {
			for (int j = 0; j < strazi.get(i).blocLocativ.size(); j++) {
				for (int a = 0; a < strazi.get(i).blocLocativ.get(j).etaj.size(); a++) {
					for (int b = 0; b < strazi.get(i).blocLocativ.get(j).etaj.get(a).apartament.size(); b++) {
						for (int c = 0; c < strazi.get(i).blocLocativ.get(j).etaj.get(a).apartament.get(b).locuitor.size(); c++) {
							if (oldestMan.getVarsta() < strazi.get(i).blocLocativ.get(j).etaj.get(a).apartament.get(b).locuitor.get(c).getVarsta()) {
								oldestMan = strazi.get(i).blocLocativ.get(j).etaj.get(a).apartament.get(b).locuitor.get(c);
							}
						}
					}
				}
			}
		}

		oldestMan.afisare();

		//3)de afisat denumirea strazii cu valoarea maxima a coeficientului densitatii( nrtotal de locuitor pe strada /suprafata sumara pe strada.

		double maxCoef[] = {0, 0};
		nrStrada = -1;
		double coef = 0;

		for (Strada strada:strazi) {
			int nrTotalLocuitori = 0;
			double totalSuprafata = 0;
			nrStrada++;

			for (BlocLocativ bloc:strada.blocLocativ) {
				for (Etaj etaj:bloc.etaj) {
					for (Apartament apartament:etaj.apartament) {
						for (Locuitor locuitor:apartament.locuitor) {
							nrTotalLocuitori++;
						}
						for (Camera camera:apartament.camera) {
							totalSuprafata += camera.getAria();
						}
					}
				}
			}

			coef = nrTotalLocuitori / totalSuprafata;
			if (coef > maxCoef[1]) {
				maxCoef[1] = coef;
				maxCoef[0] = nrStrada;
			}
		}

		System.out.println("\n" + strazi.get((int) maxCoef[0]).getDenumire() + " : " + coef);
	}
}