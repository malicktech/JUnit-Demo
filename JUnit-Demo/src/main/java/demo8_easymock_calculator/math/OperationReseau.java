package demo8_easymock_calculator.math;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class OperationReseau implements Operation {
	protected static String baseurl = "http://localhost:8080/ServletDeCalcul/servletdecalcul";
	protected IInputStreamFactory isf;

	protected interface IInputStreamFactory {
		public InputStream recupereIS(URL url) throws Exception;
	}

	protected static class InputStreamFactoryReseau implements IInputStreamFactory {
		public InputStream recupereIS(URL url) throws Exception {
			return url.openConnection().getInputStream();
		}
	}

	public OperationReseau(IInputStreamFactory isf) {
		this.isf = isf;
	}

	@Override
	public Long calculer(Long a, Long b) throws Exception {
		String resultat = lireDonnees(isf.recupereIS(construireURL(a, b)));
		return analyseResultat(resultat);
	}

	public abstract Character lireSymbole();

	protected URL construireURL(Long a, Long b) throws Exception {
		return new URL(baseurl + "?operation=" + getNomReseau() + "&a=" + a.toString() + "&b=" + b.toString());
	}

	public abstract String getNomReseau();

	protected Long analyseResultat(String resultat) {
		Pattern p = Pattern.compile("\\{\"resultat\":(.*)\\}");
		Matcher m = p.matcher(resultat);
		m.find();
		return new Long(m.group(1));
	}

	protected String lireDonnees(InputStream is) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String resultat = "";

		String inputLine = in.readLine();
		while (inputLine != null) {
			resultat += inputLine;
			inputLine = in.readLine();
		}

		in.close();
		return resultat;
	}
}
