package pl.edu.pjwstk.s8267.GUI.Lab5;

import java.io.File;
import java.io.FilenameFilter;

import pl.edu.pjwstk.s8267.GUI.Lab4.FormattedInt;
import pl.edu.pjwstk.s8267.GUI.Lab4.FormattedString;
import pl.edu.pjwstk.s8267.GUI.Lab4.Justification;

public class Ls {
	public static void main(String[] args) {
		File dir = new File("."); // katalog bieżący

		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory() || name.endsWith(".html");
			}
		};

		String[] fnames = dir.list(filter);

		for (int i = 0; i < fnames.length; i++) {
			File tmpFile = new File(dir, fnames[i]);
			if (tmpFile.isDirectory()) { // metoda zwraca true, jeśli
				System.out.println(new FormattedString(tmpFile.getName(), 15).justify(Justification.LEFT) + new FormattedString("katalog", 15).justify(Justification.CENTER));
			} else {
				long size = tmpFile.length(); // metoda zwraca wielkość pliku
				System.out.println(new FormattedString(tmpFile.getName(), 15).justify(Justification.LEFT) + new FormattedString("plik", 15).justify(Justification.CENTER) + new FormattedInt((int) size, 15).justify(Justification.RIGHT));
			}
		}
	}
}
