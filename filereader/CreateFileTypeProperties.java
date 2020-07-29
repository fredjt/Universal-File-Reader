package filereader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class CreateFileTypeProperties {
	private static final File fileTypePropertiesFile = new File("FileTypes.dat");

	public static File getFileTypePropertiesFile() {
		return CreateFileTypeProperties.fileTypePropertiesFile;
	}

	public static void main(String[] args) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileTypePropertiesFile));
		ArrayList<ArrayList<Object>> fileTypes = new ArrayList<>();
		ArrayList<Object> mime = new ArrayList<Object>();
		ArrayList<Object> properties = new ArrayList<Object>();

		Properties plain = new Properties();
		plain.put("description", "Plain Text");
		plain.put("extensions", new String[] { ".txt" });
		mime.add("text/plain");
		properties.add(plain);
		plain = null;

		Properties msword = new Properties();
		msword.put("description", "Microsoft Word Document");
		msword.put("extensions", new String[] { ".docx" });
		msword.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/msword");
		properties.add(msword);
		msword = null;

		Properties msexcel = new Properties();
		msexcel.put("description", "Microsoft Excel Spreadsheet");
		msexcel.put("extensers", new String[] { ".xlsx" });
		msexcel.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/msexcel");
		properties.add(msexcel);
		msexcel = null;

		Properties mspowerpoint = new Properties();
		mspowerpoint.put("description", "Microsoft Power Point Presentation");
		mspowerpoint.put("extensions", new String[] { ".pptx" });
		mspowerpoint.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/mspowerpoint");
		properties.add(mspowerpoint);
		mspowerpoint = null;

		Properties msaccess = new Properties();
		msaccess.put("description", "Microsoft Access Database");
		msaccess.put("extensions", new String[] { ".accdb", "accdr" });
		msaccess.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/msaccess");
		properties.add(msaccess);
		msaccess = null;

		Properties msonenote = new Properties();
		msonenote.put("description", "Microsoft OneNote Document");
		msonenote.put("extensions", new String[] { ".one" });
		msonenote.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/msonenote");
		properties.add(msonenote);
		msonenote = null;

		Properties sqlite = new Properties();
		sqlite.put("description", "SQLite Database");
		sqlite.put("extensions", new String[] { ".sqlitedb", ".sqlite", ".db" });
		sqlite.put("magic", new String[] { "53514C69746520666F726D6174203300" });
		mime.add("application/sqlite");
		properties.add(sqlite);
		sqlite = null;

		Properties icon = new Properties();
		icon.put("description", "Icon");
		icon.put("extensions", new String[] { ".ico" });
		icon.put("magic", new String[] { "00000100" });
		mime.add("image/icon");
		properties.add(icon);
		icon = null;

		Properties tarzlzw = new Properties();
		tarzlzw.put("description", "Z Compressed Archive");
		tarzlzw.put("extensions", new String[] { ".z" });
		tarzlzw.put("magic", new String[] { "1F9D90" });
		mime.add("application/tarziplzw");
		properties.add(tarzlzw);
		tarzlzw = null;

		Properties tarzlzh = new Properties();
		tarzlzh.put("description", "Z Compressed Archive");
		tarzlzh.put("extensions", new String[] { ".z" });
		tarzlzh.put("magic", new String[] { "1FA0" });
		mime.add("application/tarziplzh");
		properties.add(tarzlzh);
		tarzlzh = null;

		Properties bzip = new Properties();
		bzip.put("description", "Bzip2 Compressed Archive");
		bzip.put("extensions", new String[] { ".bz2" });
		bzip.put("magic", new String[] { "425A68" });
		mime.add("application/bzip2");
		properties.add(bzip);
		bzip = null;

		Properties gif = new Properties();
		gif.put("description", "GIF Image");
		gif.put("extensions", new String[] { ".gif" });
		gif.put("magic", new String[] { "474946383761", "474946383961" });
		mime.add("image/gif");
		properties.add(gif);
		gif = null;

		Properties tiff = new Properties();
		tiff.put("description", "TIFF Image");
		tiff.put("extensions", new String[] { ".tif", ".tiff" });
		tiff.put("magic", new String[] { "49492A00", "4D4D002A" });
		mime.add("image/tiff");
		properties.add(tiff);
		tiff = null;

		Properties jpeg = new Properties();
		jpeg.put("description", "JPEG Image");
		jpeg.put("extensions", new String[] { ".jpg", ".jpeg" });
		jpeg.put("magic", new String[] { "FFD8FFDB", "FFD8FFE000104A4649460001", "FFD8FFEE",
				"FFD8FFE1[0-9A-F][0-9A-F][0-9A-F][0-9A-F]457869660000" });
		mime.add("image/jpeg");
		properties.add(jpeg);
		jpeg = null;

		Properties lzip = new Properties();
		lzip.put("description", "LZIP Compressed Archive");
		lzip.put("extensions", new String[] { ".lzip" });
		lzip.put("magic", new String[] { "4C5A4950" });
		mime.add("application/lzip");
		properties.add(lzip);
		lzip = null;

		Properties mzexecutable = new Properties();
		mzexecutable.put("description", "Windows DOS Executable");
		mzexecutable.put("extensions", new String[] { ".exe", ".dll" });
		mzexecutable.put("magic", new String[] { "4D5A" });
		mime.add("application/mzexe");
		properties.add(mzexecutable);
		mzexecutable = null;

		Properties zip = new Properties();
		zip.put("description", "ZIP Compressed Archive");
		zip.put("extensions", new String[] { ".zip" });
		zip.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/zip");
		properties.add(zip);
		zip = null;

		Properties odt = new Properties();
		odt.put("description", "OpenDocument Text Document");
		odt.put("extensions", new String[] { ".odt" });
		odt.put("magic", new String[] { "504B0304", "504B0506", "504B0708" });
		mime.add("application/odt");
		properties.add(odt);
		odt = null;

		Properties zmexecutable = new Properties();
		zmexecutable.put("description", "Windows ZM DOS Executable");
		zmexecutable.put("extensions", new String[] { ".exe" });
		zmexecutable.put("magic", new String[] { "5A4D" });
		mime.add("application/zmexe");
		properties.add(zmexecutable);
		zmexecutable = null;

		Properties png = new Properties();
		png.put("description", "PNG Image");
		png.put("extensions", new String[] { ".png" });
		png.put("magic", new String[] { "89504E470D0A1A0A" });
		mime.add("image/png");
		properties.add(png);
		png = null;

		Properties com = new Properties();
		com.put("description", "COM DOS Executable");
		com.put("extensions", new String[] { ".com" });
		com.put("magic", new String[] { "C9" });
		mime.add("application/com");
		properties.add(com);
		com = null;

		Properties classfile = new Properties();
		classfile.put("description", "Java Class File");
		classfile.put("extensions", new String[] { ".class" });
		classfile.put("magic", new String[] { "CAFEBABE" });
		mime.add("application/class");
		properties.add(classfile);
		classfile = null;

		Properties ps = new Properties();
		ps.put("description", "PostScript Document");
		ps.put("extensions", new String[] { ".ps" });
		ps.put("magic", new String[] { "25215053" });
		mime.add("application/postscript");
		properties.add(ps);
		ps = null;

		Properties chm = new Properties();
		chm.put("description", "Compiled HTML Help");
		chm.put("extensions", new String[] { ".chm" });
		chm.put("magic", new String[] { "495453460300000060000000" });
		mime.add("application/chm");
		properties.add(chm);
		chm = null;

		Properties pdf = new Properties();
		pdf.put("description", "PDF Document");
		pdf.put("extensions", new String[] { ".pdf" });
		pdf.put("magic", new String[] { "255044462D" });
		mime.add("application/pdf");
		properties.add(pdf);
		pdf = null;

		Properties wma = new Properties();
		wma.put("description", "Windows Media Audio");
		wma.put("extensions", new String[] { ".wma" });
		wma.put("magic", new String[] { "3026B2758E66CF11A6D900AA0062CE6C" });
		mime.add("audio/wma");
		properties.add(wma);
		wma = null;

		Properties asf = new Properties();
		asf.put("description", "Advanced Systems File");
		asf.put("extensions", new String[] { ".asf" });
		asf.put("magic", new String[] { "3026B2758E66CF11A6D900AA0062CE6C" });
		mime.add("audio/asf");
		properties.add(asf);
		asf = null;

		Properties wmv = new Properties();
		wmv.put("description", "Windows Media Video");
		wmv.put("extensions", new String[] { ".wmv" });
		wmv.put("magic", new String[] { "3026B2758E66CF11A6D900AA0062CE6C" });
		mime.add("video/wmv");
		properties.add(wmv);
		wmv = null;

		Properties ogg = new Properties();
		ogg.put("description", "Ogg Vorbis Compressed Audio");
		ogg.put("extensions", new String[] { ".ogg" });
		ogg.put("magic", new String[] { "4F676753" });
		mime.add("audio/ogg");
		properties.add(ogg);
		ogg = null;

		Properties oga = new Properties();
		oga.put("description", "Ogg Vorbis Audio");
		oga.put("extensions", new String[] { ".oga" });
		oga.put("magic", new String[] { "4F676753" });
		mime.add("audio/oga");
		properties.add(oga);
		oga = null;

		Properties ogv = new Properties();
		ogv.put("description", "Ogg Vorbis Video");
		ogv.put("extensions", new String[] { ".ogv" });
		ogv.put("magic", new String[] { "4F676753" });
		mime.add("video/ogv");
		properties.add(ogv);
		ogv = null;

		Properties psd = new Properties();
		psd.put("description", "Adobe Photoshop Document");
		psd.put("extensions", new String[] { ".psd" });
		psd.put("magic", new String[] { "38425053" });
		mime.add("image/photoshop");
		properties.add(psd);
		psd = null;

		Properties wav = new Properties();
		wav.put("description", "WAVE Audio");
		wav.put("extensions", new String[] { ".wav" });
		wav.put("magic",
				new String[] { "52494646[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]57415645" });
		mime.add("audio/wav");
		properties.add(wav);
		wav = null;

		Properties avi = new Properties();
		avi.put("description", "Audio Video Interleave");
		avi.put("extensions", new String[] { ".avi" });
		avi.put("magic",
				new String[] { "52494646[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]41564920" });
		mime.add("video/avi");
		properties.add(avi);
		avi = null;

		Properties mp3 = new Properties();
		mp3.put("description", "MP3 Audio");
		mp3.put("extensions", new String[] { ".mp3" });
		mp3.put("magic", new String[] { "FFFB", "FFF3", "FFF2", "494433" });
		mime.add("audio/mp3");
		properties.add(mp3);
		mp3 = null;

		Properties bmp = new Properties();
		bmp.put("description", "Bitmap Image");
		bmp.put("extensions", new String[] { ".bmp", ".dib" });
		bmp.put("magic", new String[] { "424D" });
		mime.add("image/bmp");
		properties.add(bmp);
		bmp = null;

		Properties iso = new Properties();
		iso.put("description", "Disc Image");
		iso.put("extensions", new String[] { ".iso" });
		iso.put("magic", new String[] { "4344303031" });
		mime.add("image/iso");
		properties.add(iso);
		iso = null;

		Properties flac = new Properties();
		flac.put("description", "Free Lossless Audio Codec");
		flac.put("extensions", new String[] { ".flac" });
		flac.put("magic", new String[] { "664C6143" });
		mime.add("audio/flac");
		properties.add(flac);
		flac = null;

		Properties midi = new Properties();
		midi.put("description", "MIDI Audio");
		midi.put("extensions", new String[] { ".mid", "midi" });
		midi.put("magic", new String[] { "4D546864" });
		mime.add("audio/midi");
		properties.add(midi);
		midi = null;

		Properties doc = new Properties();
		doc.put("description", "Microsoft Word Document");
		doc.put("extensions", new String[] { ".doc" });
		doc.put("magic", new String[] { "D0CF11E0A1B11AE1" });
		mime.add("application/msword");
		properties.add(doc);
		doc = null;

		Properties xls = new Properties();
		xls.put("description", "Microsoft Excel Spreadsheet");
		xls.put("extensions", new String[] { ".xls", ".xl", ".dex" });
		xls.put("magic", new String[] { "D0CF11E0A1B11AE1" });
		mime.add("application/msexcel");
		properties.add(xls);
		xls = null;

		Properties ppt = new Properties();
		ppt.put("description", "Microsoft PowerPoint Presentation");
		ppt.put("extensions", new String[] { ".ppt" });
		ppt.put("magic", new String[] { "D0CF11E0A1B11AE1" });
		mime.add("application/mspowerpoint");
		properties.add(ppt);
		ppt = null;

		Properties msg = new Properties();
		msg.put("description", "Microsoft Outlook Mail Message");
		msg.put("extensions", new String[] { ".msg" });
		msg.put("magic", new String[] { "D0CF11E0A1B11AE1" });
		mime.add("application/msoutlook");
		properties.add(msg);
		msg = null;

		Properties dex = new Properties();
		dex.put("description", "Dalvik Executable");
		dex.put("extensions", new String[] { ".dex" });
		dex.put("magic", new String[] { "6465780A30333500" });
		mime.add("application/dalvik");
		properties.add(dex);
		dex = null;

		Properties crx = new Properties();
		crx.put("description", "Google Chrome Extension");
		crx.put("extensions", new String[] { ".crx" });
		crx.put("magic", new String[] { "43723234" });
		mime.add("application/chrome");
		properties.add(crx);
		crx = null;

		Properties dmg = new Properties();
		dmg.put("description", "Apple Disc Image");
		dmg.put("extensions", new String[] { ".dmg" });
		dmg.put("magic", new String[] { "7801730D626260" });
		mime.add("image/x-apple-diskimage");
		properties.add(dmg);
		dmg = null;

		Properties sevenz = new Properties();
		sevenz.put("description", "7-Zip Compressed Archive");
		sevenz.put("extensions", new String[] { ".7z" });
		sevenz.put("magic", new String[] { "377ABCAF271C" });
		mime.add("application/x-7z-compressed");
		properties.add(sevenz);
		sevenz = null;

		Properties targz = new Properties();
		targz.put("description", "GZIP Compressed File");
		targz.put("extensions", new String[] { ".gz", "gzip" });
		targz.put("magic", new String[] { "1F8B" });
		mime.add("application/gzip");
		properties.add(targz);
		targz = null;

		Properties tarxz = new Properties();
		tarxz.put("description", "XZ Compressed Archive");
		tarxz.put("extensions", new String[] { ".xz" });
		tarxz.put("magic", new String[] { "FD377A585A00" });
		mime.add("application/x-xz");
		properties.add(tarxz);
		tarxz = null;

		Properties cab = new Properties();
		cab.put("description", "Windows Cabinet");
		cab.put("extensions", new String[] { ".cab" });
		cab.put("magic", new String[] { "4D534346" });
		mime.add("application/vnd.ms-cab-compressed");
		properties.add(cab);
		cab = null;

		Properties dicom = new Properties();
		dicom.put("description", "DICOM Image");
		dicom.put("extensions", new String[] { ".dcm", ".dicom", ".dicm" });
		dicom.put("magic", new String[] { "4449434D" });
		mime.add("image/dicom-rle");
		properties.add(dicom);
		dicom = null;

		Properties woff = new Properties();
		woff.put("description", "Web Open Font Format");
		woff.put("extensions", new String[] { ".woff" });
		woff.put("magic", new String[] { "774F4646" });
		mime.add("font/woff");
		properties.add(woff);
		woff = null;

		Properties woff2 = new Properties();
		woff2.put("description", "Web Open Font Format 2");
		woff2.put("extensions", new String[] { ".woff2" });
		woff2.put("magic", new String[] { "774F4632" });
		mime.add("font/woff2");
		properties.add(woff2);
		woff2 = null;

		Properties xml = new Properties();
		xml.put("description", "XML (eXtensible Markup Language)");
		xml.put("extensions", new String[] { ".xml" });
		xml.put("magic", new String[] { "3C3F786D6C20" });
		mime.add("text/xml");
		properties.add(xml);
		xml = null;

		Properties webp = new Properties();
		webp.put("description", "WebP Image");
		webp.put("extensions", new String[] { ".webp" });
		webp.put("magic",
				new String[] { "52494646[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]57454250" });
		mime.add("image/webp");
		properties.add(webp);
		webp = null;

		Properties rtf = new Properties();
		rtf.put("description", "Rich Text Format Document");
		rtf.put("extensions", new String[] { ".rtf" });
		rtf.put("magic", new String[] { "7B5C72746631" });
		mime.add("text/rtf");
		properties.add(rtf);
		rtf = null;

		Properties tsv = new Properties();
		tsv.put("description", "MPEG Transport Stream");
		tsv.put("extensions", new String[] { ".ts", ".tsa", ".tsv" });
		tsv.put("magic", new String[] { "47" });
		mime.add("video/tsv");
		properties.add(tsv);
		tsv = null;

		Properties mpeg = new Properties();
		mpeg.put("description", "MPEG Video");
		mpeg.put("extensions", new String[] { ".mpeg", ".mpg", ".m15", ".m17" });
		mpeg.put("magic", new String[] { "000001BA", "47", "000001B3" });
		mime.add("video/mpeg");
		properties.add(mpeg);
		mpeg = null;

		Properties zlib = new Properties();
		zlib.put("description", "ZLIB Compressed Archive");
		zlib.put("extensions", new String[] { ".zlib" });
		zlib.put("magic", new String[] { "7801", "785E", "789C", "78DA", "7820", "787D", "78BB", "78F9" });
		mime.add("application/zlib");
		properties.add(zlib);
		zlib = null;

		Properties eml = new Properties();
		eml.put("description", "Email Message");
		eml.put("extensions", new String[] { ".eml" });
		eml.put("magic", new String[] { "5265636569766564" });
		mime.add("text/eml");
		properties.add(eml);
		eml = null;

		Properties tde = new Properties();
		tde.put("description", "Tableau Data Extract");
		tde.put("extensions", new String[] { ".tde" });
		tde.put("magic", new String[] { "20020162A01EAB0702000000" });
		mime.add("application/tde");
		properties.add(tde);
		tde = null;

		Properties zst = new Properties();
		zst.put("description", "ZStandard Compressed Archive");
		zst.put("extensions", new String[] { ".zst", ".zstd" });
		zst.put("magic", new String[] { "28B52FFD" });
		mime.add("application/zstd");
		properties.add(zst);
		zst = null;

		Properties vpk = new Properties();
		vpk.put("description", "Valve Pak");
		vpk.put("extensions", new String[] { ".vpk" });
		vpk.put("magic", new String[] { "3412AA55" });
		mime.add("application/vpk");
		properties.add(vpk);
		vpk = null;

		fileTypes.add(mime);
		fileTypes.add(properties);
		out.writeObject(fileTypes);
		out.close();
	}
}
