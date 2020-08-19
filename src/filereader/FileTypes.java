/*
##################################################################################
# MIT License                                                                    #
#                                                                                #
# Copyright (c) 2020 fredjt                                                      #
#                                                                                #
# Permission is hereby granted, free of charge, to any person obtaining a copy   #
# of this software and associated documentation files (the "Software"), to deal  #
# in the Software without restriction, including without limitation the rights   #
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell      #
# copies of the Software, and to permit persons to whom the Software is          #
# furnished to do so, subject to the following conditions:                       #
#                                                                                #
# The above copyright notice and this permission notice shall be included in all #
# copies or substantial portions of the Software.                                #
#                                                                                #
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR     #
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,       #
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE    #
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER         #
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  #
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  #
# SOFTWARE.                                                                      #
# © 2020 GitHub, Inc.                                                            #
##################################################################################
 */

package filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import filereader.parser.adobePhotoshopDocument.AdobePhotoshopDocument;
import filereader.parser.advancedSystemsFile.AdvancedSystemsFile;
import filereader.parser.appleDiscImage.AppleDiscImage;
import filereader.parser.audioVideoInterleave.AudioVideoInterleave;
import filereader.parser.bitmapImage.BitmapImage;
import filereader.parser.bzip2CompressedArchive.Bzip2CompressedArchive;
import filereader.parser.comDOSExecutable.ComDOSExecutable;
import filereader.parser.compiledHTMLHelp.CompiledHTMLHelp;
import filereader.parser.dalvikExecutable.DalvikExecutable;
import filereader.parser.dicomImage.DicomImage;
import filereader.parser.discImage.DiscImage;
import filereader.parser.emailMessage.EmailMessage;
import filereader.parser.freeLosslessAudioCodec.FreeLosslessAudioCodec;
import filereader.parser.gifImage.GifImage;
import filereader.parser.googleChromeExtension.GoogleChromeExtension;
import filereader.parser.gzipCompressedFile.GzipCompressedFile;
import filereader.parser.icon.Icon;
import filereader.parser.java.Java;
import filereader.parser.javaClassFile.JavaClassFile;
import filereader.parser.jpegImage.JpegImage;
import filereader.parser.lzipCompressedArchive.LzipCompressedArchive;
import filereader.parser.mathematicaNotebook.MathematicaNotebook;
import filereader.parser.microsoftAccessDatabase.MicrosoftAccessDatabase;
import filereader.parser.microsoftExcel972003Spreadsheet.MicrosoftExcel972003Spreadsheet;
import filereader.parser.microsoftExcelSpreadsheet.MicrosoftExcelSpreadsheet;
import filereader.parser.microsoftOneNoteDocument.MicrosoftOneNoteDocument;
import filereader.parser.microsoftOutlookMailMessage.MicrosoftOutlookMailMessage;
import filereader.parser.microsoftPowerPoint972003Presentation.MicrosoftPowerPoint972003Presentation;
import filereader.parser.microsoftPowerPointPresentation.MicrosoftPowerPointPresentation;
import filereader.parser.microsoftWord972003Document.MicrosoftWord972003Document;
import filereader.parser.microsoftWordDocument.MicrosoftWordDocument;
import filereader.parser.midiAudio.MidiAudio;
import filereader.parser.mp3Audio.Mp3Audio;
import filereader.parser.mpegTransportStream.MpegTransportStream;
import filereader.parser.mpegVideo.MpegVideo;
import filereader.parser.octetstream.Octetstream;
import filereader.parser.oggVorbisAudio.OggVorbisAudio;
import filereader.parser.oggVorbisCompressedAudio.OggVorbisCompressedAudio;
import filereader.parser.oggVorbisVideo.OggVorbisVideo;
import filereader.parser.openDocumentTextDocument.OpenDocumentTextDocument;
import filereader.parser.pdfDocument.PdfDocument;
import filereader.parser.plainText.PlainText;
import filereader.parser.pngImage.PngImage;
import filereader.parser.postScriptDocument.PostScriptDocument;
import filereader.parser.richTextFormatDocument.RichTextFormatDocument;
import filereader.parser.sevenZipCompressedArchive.SevenZipCompressedArchive;
import filereader.parser.sqliteDatabase.SqliteDatabase;
import filereader.parser.tableauDataExtract.TableauDataExtract;
import filereader.parser.tiffImage.TiffImage;
import filereader.parser.valvePak.ValvePak;
import filereader.parser.waveAudio.WaveAudio;
import filereader.parser.webOpenFontFormat.WebOpenFontFormat;
import filereader.parser.webOpenFontFormat2.WebOpenFontFormat2;
import filereader.parser.webPImage.WebPImage;
import filereader.parser.windowsCabinet.WindowsCabinet;
import filereader.parser.windowsDOSExecutable.WindowsMZDOSExecutable;
import filereader.parser.windowsMediaAudio.WindowsMediaAudio;
import filereader.parser.windowsMediaVideo.WindowsMediaVideo;
import filereader.parser.windowsZMDOSExecutable.WindowsZMDOSExecutable;
import filereader.parser.xmleXtensibleMarkupLanguage.XmleXtensibleMarkupLanguage;
import filereader.parser.xzCompressedArchive.XzCompressedArchive;
import filereader.parser.zLZHCompressedArchive.ZLZHCompressedArchive;
import filereader.parser.zLZWCompressedArchive.ZLZWCompressedArchive;
import filereader.parser.zStandardCompressedArchive.ZStandardCompressedArchive;
import filereader.parser.zipCompressedArchive.ZipCompressedArchive;
import filereader.parser.zlibCompressedArchive.ZlibCompressedArchive;

/**
 * @author Fred T
 *
 */
public class FileTypes {
	private static final String _root = "src/filereader/parser/";
	private static final String applicationsFile = _root + "applications.dat";
	private static final String applicationsSyntaxFile = _root + "applicationsSyntax.properties";
	private static final String defaultApplicationsFile = _root + "defaultApplications.xml";
	private static final String editorListFile = "editors.dat";
	private static final File fileTypePropertiesFile = new File("FileTypes.dat");

	/**
	 * @return
	 */
	public static File getFileTypePropertiesFile() {
		return FileTypes.fileTypePropertiesFile;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File tempFile = new File(applicationsFile);
		Properties applications = new Properties();
		if (tempFile.isFile()) {
			applications.load(new FileInputStream(applicationsFile));
		}
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileTypePropertiesFile));
		ArrayList<ArrayList<Object>> fileTypes = new ArrayList<>();
		ArrayList<Object> mime = new ArrayList<Object>();
		ArrayList<Object> properties = new ArrayList<Object>();

		Properties octetstream = new Properties();
		octetstream.put("description", "octet-stream");
		octetstream.put("extensions", new String[] {});
		octetstream.put("folder", "octetstream");
		octetstream.put("object", new Octetstream());
		mime.add("application/octet-stream");
		properties.add(octetstream);
		octetstream = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("Octetstream", new String[] {});

		Properties plain = new Properties();
		plain.put("description", "Plain Text");
		plain.put("extensions", new String[] { ".txt", ".log" });
		plain.put("folder", "plainText");
		plain.put("object", new PlainText());
		mime.add("text/plain");
		properties.add(plain);
		plain = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("PlainText", new String[] {});

		Properties java = new Properties();
		java.put("description", "Java");
		java.put("extensions", new String[] { ".java" });
		java.put("magic", new String[] { "7061636B61676520", "696D706F727420", "7075626C696320", "616273747261637420",
				"66696E616C20", "636C61737320", "2F2A", "2F2F" }); // "package ", "import ", "public ", "abstract ", "final ", "class ", "/*", "//"
		java.put("folder", "java");
		java.put("object", new Java());
		mime.add("text/java");
		properties.add(java);
		java = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("Java", new String[] {});

		Properties nb = new Properties();
		nb.put("description", "Mathematica Notebook");
		nb.put("extensions", new String[] { ".nb" });
		nb.put("magic", new String[] { "282A", "4E6F7465626F6F6B5B" }); // "(*", "Notebook["
		nb.put("folder", "mathematicaNotebook");
		nb.put("object", new MathematicaNotebook());
		mime.add("text/mathematica-notebook");
		properties.add(nb);
		nb = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MathematicaNotebook", new String[] {});

		Properties msword = new Properties();
		msword.put("description", "Microsoft Word Document");
		msword.put("extensions", new String[] { ".docx" });
		msword.put("magic", new String[] { "504B0304", "504B0506", "504B0708" }); // "PK", "PK", "PK"
		msword.put("folder", "microsoftWordDocument");
		msword.put("object", new MicrosoftWordDocument());
		mime.add("application/msword");
		properties.add(msword);
		msword = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftWordDocument", new String[] {});

		Properties msexcel = new Properties();
		msexcel.put("description", "Microsoft Excel Spreadsheet");
		msexcel.put("extensions", new String[] { ".xlsx" });
		msexcel.put("magic", new String[] { "504B0304", "504B0506", "504B0708" }); // "PK", "PK", "PK"
		msexcel.put("folder", "microsoftExcelSpreadsheet");
		msexcel.put("object", new MicrosoftExcelSpreadsheet());
		mime.add("application/msexcel");
		properties.add(msexcel);
		msexcel = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftExcelSpreadsheet", new String[] {});

		Properties mspowerpoint = new Properties();
		mspowerpoint.put("description", "Microsoft Power Point Presentation");
		mspowerpoint.put("extensions", new String[] { ".pptx" });
		mspowerpoint.put("magic", new String[] { "504B0304", "504B0506", "504B0708" }); // "PK", "PK", "PK"
		mspowerpoint.put("folder", "microsoftPowerPointPresentation");
		mspowerpoint.put("object", new MicrosoftPowerPointPresentation());
		mime.add("application/mspowerpoint");
		properties.add(mspowerpoint);
		mspowerpoint = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftPowerPointPresentation", new String[] {});

		Properties msaccess = new Properties();
		msaccess.put("description", "Microsoft Access Database");
		msaccess.put("extensions", new String[] { ".accdb", "accdr" });
		msaccess.put("magic", new String[] { "504B0304", "504B0506", "504B0708", "00010000" }); // "PK", "PK",
																								// "PK", "   "
		msaccess.put("folder", "microsoftAccessDatabase");
		msaccess.put("object", new MicrosoftAccessDatabase());
		mime.add("application/msaccess");
		properties.add(msaccess);
		msaccess = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftAccessDatabase", new String[] {});

		Properties msonenote = new Properties();
		msonenote.put("description", "Microsoft OneNote Document");
		msonenote.put("extensions", new String[] { ".one" });
		msonenote.put("magic", new String[] { "504B0304", "504B0506", "504B0708" }); // "PK", "PK", "PK"
		msonenote.put("folder", "microsoftOneNoteDocument");
		msonenote.put("object", new MicrosoftOneNoteDocument());
		mime.add("application/msonenote");
		properties.add(msonenote);
		msonenote = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftOneNoteDocument", new String[] {});

		Properties sqlite = new Properties();
		sqlite.put("description", "SQLite Database");
		sqlite.put("extensions", new String[] { ".sqlitedb", ".sqlite", ".db" });
		sqlite.put("magic", new String[] { "53514C69746520666F726D6174203300" }); // "SQLite format 3 "
		sqlite.put("folder", "sqliteDatabase");
		sqlite.put("object", new SqliteDatabase());
		mime.add("application/sqlite");
		properties.add(sqlite);
		sqlite = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("SqliteDatabase", new String[] {});

		Properties icon = new Properties();
		icon.put("description", "Icon");
		icon.put("extensions", new String[] { ".ico" });
		icon.put("magic", new String[] { "00000100" }); // "   "
		icon.put("folder", "icon");
		icon.put("object", new Icon());
		mime.add("image/icon");
		properties.add(icon);
		icon = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("Icon", new String[] {});

		Properties tarzlzw = new Properties();
		tarzlzw.put("description", "Z Compressed Archive");
		tarzlzw.put("extensions", new String[] { ".z" });
		tarzlzw.put("magic", new String[] { "1F9D" }); // "ù"
		tarzlzw.put("folder", "zLZWCompressedArchive");
		tarzlzw.put("object", new ZLZWCompressedArchive());
		mime.add("application/tarziplzw");
		properties.add(tarzlzw);
		tarzlzw = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ZLZWCompressedArchive", new String[] {});

		Properties tarzlzh = new Properties();
		tarzlzh.put("description", "Z Compressed Archive");
		tarzlzh.put("extensions", new String[] { ".z" });
		tarzlzh.put("magic", new String[] { "1FA0" }); // "†"
		tarzlzh.put("folder", "zLZHCompressedArchive");
		tarzlzh.put("object", new ZLZHCompressedArchive());
		mime.add("application/tarziplzh");
		properties.add(tarzlzh);
		tarzlzh = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ZLZHCompressedArchive", new String[] {});

		Properties bzip = new Properties();
		bzip.put("description", "Bzip2 Compressed Archive");
		bzip.put("extensions", new String[] { ".bz2" });
		bzip.put("magic", new String[] { "425A68" }); // "BZh"
		bzip.put("folder", "bzip2CompressedArchive");
		bzip.put("object", new Bzip2CompressedArchive());
		mime.add("application/bzip2");
		properties.add(bzip);
		bzip = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("Bzip2CompressedArchive", new String[] {});

		Properties gif = new Properties();
		gif.put("description", "GIF Image");
		gif.put("extensions", new String[] { ".gif" });
		gif.put("magic", new String[] { "474946383761", "474946383961" }); // "GIF87a", "GIF89a"
		gif.put("folder", "gifImage");
		gif.put("object", new GifImage());
		mime.add("image/gif");
		properties.add(gif);
		gif = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("GifImage", new String[] {});

		Properties tiff = new Properties();
		tiff.put("description", "TIFF Image");
		tiff.put("extensions", new String[] { ".tif", ".tiff" });
		tiff.put("magic", new String[] { "49492A00", "4D4D002A" }); // "II* ", "MM *"
		tiff.put("folder", "tiffImage");
		tiff.put("object", new TiffImage());
		mime.add("image/tiff");
		properties.add(tiff);
		tiff = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("TiffImage", new String[] {});

		Properties jpeg = new Properties();
		jpeg.put("description", "JPEG Image");
		jpeg.put("extensions", new String[] { ".jpg", ".jpeg" });
		jpeg.put("magic", new String[] { "FFD8FFDB", "FFD8FFE000104A4649460001", "FFD8FFEE",
				"FFD8FFE1[0-9A-F][0-9A-F][0-9A-F][0-9A-F]457869660000" }); // "ˇÿˇ€", "ˇÿˇ‡ JFIF ",
																			// "ˇÿˇÓ", "ˇÿˇ·----Exif  "
		jpeg.put("folder", "jpegImage");
		jpeg.put("object", new JpegImage());
		mime.add("image/jpeg");
		properties.add(jpeg);
		jpeg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("JpegImage", new String[] {});

		Properties lzip = new Properties();
		lzip.put("description", "LZIP Compressed Archive");
		lzip.put("extensions", new String[] { ".lzip" });
		lzip.put("magic", new String[] { "4C5A4950" }); // "LZIP"
		lzip.put("folder", "lzipCompressedArchive");
		lzip.put("object", new LzipCompressedArchive());
		mime.add("application/lzip");
		properties.add(lzip);
		lzip = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("LzipCompressedArchive", new String[] {});

		Properties mzexecutable = new Properties();
		mzexecutable.put("description", "Windows DOS Executable");
		mzexecutable.put("extensions", new String[] { ".exe", ".dll" });
		mzexecutable.put("magic", new String[] { "4D5A" }); // "MZ"
		mzexecutable.put("folder", "windowsDOSExecutable");
		mzexecutable.put("object", new WindowsMZDOSExecutable());
		mime.add("application/mzexe");
		properties.add(mzexecutable);
		mzexecutable = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WindowsMzDOSExecutable", new String[] {});

		Properties zip = new Properties();
		zip.put("description", "ZIP Compressed Archive");
		zip.put("extensions", new String[] { ".zip" });
		zip.put("magic", new String[] { "504B0304", "504B0506", "504B0708" }); // "PK", "PK", "PK"
		zip.put("folder", "zipCompressedArchive");
		zip.put("object", new ZipCompressedArchive());
		mime.add("application/zip");
		properties.add(zip);
		zip = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ZipCompressedArchive", new String[] {});

		Properties odt = new Properties();
		odt.put("description", "OpenDocument Text Document");
		odt.put("extensions", new String[] { ".odt" });
		odt.put("magic", new String[] { "504B0304", "504B0506", "504B0708" }); // "PK", "PK", "PK"
		odt.put("folder", "openDocumentTextDocument");
		odt.put("object", new OpenDocumentTextDocument());
		mime.add("application/odt");
		properties.add(odt);
		odt = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("OpenDocumentTextDocument", new String[] {});

		Properties zmexecutable = new Properties();
		zmexecutable.put("description", "Windows ZM DOS Executable");
		zmexecutable.put("extensions", new String[] { ".exe" });
		zmexecutable.put("magic", new String[] { "5A4D" }); // "ZM"
		zmexecutable.put("folder", "windowsZMDOSExecutable");
		zmexecutable.put("object", new WindowsZMDOSExecutable());
		mime.add("application/zmexe");
		properties.add(zmexecutable);
		zmexecutable = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WindowsZMDOSExecutable", new String[] {});

		Properties png = new Properties();
		png.put("description", "PNG Image");
		png.put("extensions", new String[] { ".png" });
		png.put("magic", new String[] { "89504E470D0A1A0A" }); // "âPNG\n\n\n"
		png.put("folder", "pngImage");
		png.put("object", new PngImage());
		mime.add("image/png");
		properties.add(png);
		png = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("PngImage", new String[] {});

		Properties com = new Properties();
		com.put("description", "COM DOS Executable");
		com.put("extensions", new String[] { ".com" });
		com.put("magic", new String[] { "C9" }); // "…"
		com.put("folder", "comDOSExecutable");
		com.put("object", new ComDOSExecutable());
		mime.add("application/com");
		properties.add(com);
		com = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ComDOSExecutable", new String[] {});

		Properties classfile = new Properties();
		classfile.put("description", "Java Class File");
		classfile.put("extensions", new String[] { ".class" });
		classfile.put("magic", new String[] { "CAFEBABE" }); // " ˛∫æ"
		classfile.put("folder", "javaClassFile");
		classfile.put("object", new JavaClassFile());
		mime.add("application/class");
		properties.add(classfile);
		classfile = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("JavaClassFile", new String[] {});

		Properties ps = new Properties();
		ps.put("description", "PostScript Document");
		ps.put("extensions", new String[] { ".ps" });
		ps.put("magic", new String[] { "25215053" }); // "%!PS"
		ps.put("folder", "postScriptDocument");
		ps.put("object", new PostScriptDocument());
		mime.add("application/postscript");
		properties.add(ps);
		ps = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("PostScriptDocument", new String[] {});

		Properties chm = new Properties();
		chm.put("description", "Compiled HTML Help");
		chm.put("extensions", new String[] { ".chm" });
		chm.put("magic", new String[] { "495453460300000060000000" }); // "ITSF   `   "
		chm.put("folder", "compiledHTMLHelp");
		chm.put("object", new CompiledHTMLHelp());
		mime.add("application/chm");
		properties.add(chm);
		chm = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("CompiledHTMLHelp", new String[] {});

		Properties pdf = new Properties();
		pdf.put("description", "PDF Document");
		pdf.put("extensions", new String[] { ".pdf" });
		pdf.put("magic", new String[] { "255044462D" }); // "%PDF-"
		pdf.put("folder", "pdfDocument");
		pdf.put("object", new PdfDocument());
		mime.add("application/pdf");
		properties.add(pdf);
		pdf = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("PdfDocument", new String[] {});

		Properties wma = new Properties();
		wma.put("description", "Windows Media Audio");
		wma.put("extensions", new String[] { ".wma" });
		wma.put("magic", new String[] { "3026B2758E66CF11A6D900AA0062CE6C" }); // "0&≤uéfœ¶Ÿ ™ bŒl"
		wma.put("folder", "windowsMediaAudio");
		wma.put("object", new WindowsMediaAudio());
		mime.add("audio/wma");
		properties.add(wma);
		wma = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WindowsMediaAudio", new String[] {});

		Properties asf = new Properties();
		asf.put("description", "Advanced Systems File");
		asf.put("extensions", new String[] { ".asf" });
		asf.put("magic", new String[] { "3026B2758E66CF11A6D900AA0062CE6C" }); // "0&≤uéfœ¶Ÿ ™ bŒl"
		asf.put("folder", "advancedSystemsFile");
		asf.put("object", new AdvancedSystemsFile());
		mime.add("audio/asf");
		properties.add(asf);
		asf = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("AdvancedSystemsFile", new String[] {});

		Properties wmv = new Properties();
		wmv.put("description", "Windows Media Video");
		wmv.put("extensions", new String[] { ".wmv" });
		wmv.put("magic", new String[] { "3026B2758E66CF11A6D900AA0062CE6C" }); // "0&≤uéfœ¶Ÿ ™ bŒl"
		wmv.put("folder", "windowsMediaVideo");
		wmv.put("object", new WindowsMediaVideo());
		mime.add("video/wmv");
		properties.add(wmv);
		wmv = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WindowsMediaVideo", new String[] {});

		Properties ogg = new Properties();
		ogg.put("description", "Ogg Vorbis Compressed Audio");
		ogg.put("extensions", new String[] { ".ogg" });
		ogg.put("magic", new String[] { "4F676753" }); // "OggS"
		ogg.put("folder", "oggVorbisCompressedAudio");
		ogg.put("object", new OggVorbisCompressedAudio());
		mime.add("audio/ogg");
		properties.add(ogg);
		ogg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("OggVorbisCompressedAudio", new String[] {});

		Properties oga = new Properties();
		oga.put("description", "Ogg Vorbis Audio");
		oga.put("extensions", new String[] { ".oga" });
		oga.put("magic", new String[] { "4F676753" }); // "OggS"
		oga.put("folder", "oggVorbisAudio");
		oga.put("object", new OggVorbisAudio());
		mime.add("audio/oga");
		properties.add(oga);
		oga = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("OggVorbisAudio", new String[] {});

		Properties ogv = new Properties();
		ogv.put("description", "Ogg Vorbis Video");
		ogv.put("extensions", new String[] { ".ogv" });
		ogv.put("magic", new String[] { "4F676753" }); // "OggS"
		ogv.put("folder", "oggVorbisVideo");
		ogv.put("object", new OggVorbisVideo());
		mime.add("video/ogv");
		properties.add(ogv);
		ogv = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("OggVorbisVideo", new String[] {});

		Properties psd = new Properties();
		psd.put("description", "Adobe Photoshop Document");
		psd.put("extensions", new String[] { ".psd" });
		psd.put("magic", new String[] { "38425053" }); // "8BPS"
		psd.put("folder", "adobePhotoshopDocument");
		psd.put("object", new AdobePhotoshopDocument());
		mime.add("image/photoshop");
		properties.add(psd);
		psd = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("AdobePhotoshopDocument", new String[] {});

		Properties wav = new Properties();
		wav.put("description", "WAVE Audio");
		wav.put("extensions", new String[] { ".wav" });
		wav.put("magic",
				new String[] { "52494646[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]57415645" }); // "RIFF----WAVE"
		wav.put("folder", "waveAudio");
		wav.put("object", new WaveAudio());
		mime.add("audio/wav");
		properties.add(wav);
		wav = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WaveAudio", new String[] {});

		Properties avi = new Properties();
		avi.put("description", "Audio Video Interleave");
		avi.put("extensions", new String[] { ".avi" });
		avi.put("magic", //$NON-NLS-1$
				new String[] { "52494646[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]41564920" }); // "RIFF----AVI
		// "
		avi.put("folder", "audioVideoInterleave");
		avi.put("object", new AudioVideoInterleave());
		mime.add("video/avi");
		properties.add(avi);
		avi = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("AudioVideoInterleave", new String[] {});

		Properties mp3 = new Properties();
		mp3.put("description", "MP3 Audio");
		mp3.put("extensions", new String[] { ".mp3" });
		mp3.put("magic", new String[] { "FFFB", "FFF3", "FFF2", "494433" }); // "ˇ˚", "ˇÛ", "ˇÚ", "ID3"
		mp3.put("folder", "mp3Audio");
		mp3.put("object", new Mp3Audio());
		mime.add("audio/mp3");
		properties.add(mp3);
		mp3 = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("Mp3Audio", new String[] {});

		Properties bmp = new Properties();
		bmp.put("description", "Bitmap Image");
		bmp.put("extensions", new String[] { ".bmp", ".dib" });
		bmp.put("magic", new String[] { "424D" }); // "BM"
		bmp.put("folder", "bitmapImage");
		bmp.put("object", new BitmapImage());
		mime.add("image/bmp");
		properties.add(bmp);
		bmp = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("BitmapImage", new String[] {});

		Properties iso = new Properties();
		iso.put("description", "Disc Image");
		iso.put("extensions", new String[] { ".iso" });
		iso.put("magic", new String[] { "4344303031" }); // "CD001"
		iso.put("folder", "discImage");
		iso.put("object", new DiscImage());
		mime.add("image/iso");
		properties.add(iso);
		iso = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("DiscImage", new String[] {});

		Properties flac = new Properties();
		flac.put("description", "Free Lossless Audio Codec");
		flac.put("extensions", new String[] { ".flac" });
		flac.put("magic", new String[] { "664C6143" }); // "fLaC"
		flac.put("folder", "freeLosslessAudioCodec");
		flac.put("object", new FreeLosslessAudioCodec());
		mime.add("audio/flac");
		properties.add(flac);
		flac = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("FreeLosslessAudioCodec", new String[] {});

		Properties midi = new Properties();
		midi.put("description", "MIDI Audio");
		midi.put("extensions", new String[] { ".mid", "midi" });
		midi.put("magic", new String[] { "4D546864" }); // "MThd"
		midi.put("folder", "midiAudio");
		midi.put("object", new MidiAudio());
		mime.add("audio/midi");
		properties.add(midi);
		midi = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MidiAudio", new String[] {});

		Properties doc = new Properties();
		doc.put("description", "Microsoft Word 97-2003 Document");
		doc.put("extensions", new String[] { ".doc" });
		doc.put("magic", new String[] { "D0CF11E0A1B11AE1" }); // "–œ‡°±·"
		doc.put("folder", "microsoftWord972003Document");
		doc.put("object", new MicrosoftWord972003Document());
		mime.add("application/msword");
		properties.add(doc);
		doc = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftWord972003Document", new String[] {});

		Properties xls = new Properties();
		xls.put("description", "Microsoft Excel 97-2003 Spreadsheet");
		xls.put("extensions", new String[] { ".xls", ".xl", ".dex" });
		xls.put("magic", new String[] { "D0CF11E0A1B11AE1" }); // "–œ‡°±·"
		xls.put("folder", "microsoftExcel972003Spreadsheet");
		xls.put("object", new MicrosoftExcel972003Spreadsheet());
		mime.add("application/msexcel");
		properties.add(xls);
		xls = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftExcel972003Spreadsheet", new String[] {});

		Properties ppt = new Properties();
		ppt.put("description", "Microsoft PowerPoint 97-2003 Presentation");
		ppt.put("extensions", new String[] { ".ppt" });
		ppt.put("magic", new String[] { "D0CF11E0A1B11AE1" }); // "–œ‡°±·"
		ppt.put("folder", "microsoftPowerPoint972003Presentation");
		ppt.put("object", new MicrosoftPowerPoint972003Presentation());
		mime.add("application/mspowerpoint");
		properties.add(ppt);
		ppt = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftPowerPoint972003Presentation", new String[] {});

		Properties msg = new Properties();
		msg.put("description", "Microsoft Outlook Mail Message");
		msg.put("extensions", new String[] { ".msg" });
		msg.put("magic", new String[] { "D0CF11E0A1B11AE1" }); // "–œ‡°±·"
		msg.put("folder", "microsoftOutlookMailMessage");
		msg.put("object", new MicrosoftOutlookMailMessage());
		mime.add("application/msoutlook");
		properties.add(msg);
		msg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MicrosoftOutlookMailMessage", new String[] {});

		Properties dex = new Properties();
		dex.put("description", "Dalvik Executable");
		dex.put("extensions", new String[] { ".dex" });
		dex.put("magic", new String[] { "6465780A30333500" }); // "dex\n035 "
		dex.put("folder", "dalvikExecutable");
		dex.put("object", new DalvikExecutable());
		mime.add("application/dalvik");
		properties.add(dex);
		dex = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("DalvikExecutable", new String[] {});

		Properties crx = new Properties();
		crx.put("description", "Google Chrome Extension");
		crx.put("extensions", new String[] { ".crx" });
		crx.put("magic", new String[] { "43723234" }); // "Cr24"
		crx.put("folder", "googleChromeExtension");
		crx.put("object", new GoogleChromeExtension());
		mime.add("application/chrome");
		properties.add(crx);
		crx = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("GoogleChromeExtension", new String[] {});

		Properties dmg = new Properties();
		dmg.put("description", "Apple Disc Image");
		dmg.put("extensions", new String[] { ".dmg" });
		dmg.put("magic", new String[] { "7801730D626260" }); // "xs\nbb`"
		dmg.put("folder", "appleDiscImage");
		dmg.put("object", new AppleDiscImage());
		mime.add("image/x-apple-diskimage");
		properties.add(dmg);
		dmg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("AppleDiscImage", new String[] {});

		Properties sevenz = new Properties();
		sevenz.put("description", "7-Zip Compressed Archive");
		sevenz.put("extensions", new String[] { ".7z" });
		sevenz.put("magic", new String[] { "377ABCAF271C" }); // "7zºØ'"
		sevenz.put("folder", "sevenZipCompressedArchive");
		sevenz.put("object", new SevenZipCompressedArchive());
		mime.add("application/x-7z-compressed");
		properties.add(sevenz);
		sevenz = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("SevenZipCompressedArchive", new String[] {});

		Properties targz = new Properties();
		targz.put("description", "GZIP Compressed File");
		targz.put("extensions", new String[] { ".gz", "gzip" });
		targz.put("magic", new String[] { "1F8B" }); // "ã"
		targz.put("folder", "gzipCompressedFile");
		targz.put("object", new GzipCompressedFile());
		mime.add("application/gzip");
		properties.add(targz);
		targz = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("GzipCompressedFile", new String[] {});

		Properties tarxz = new Properties();
		tarxz.put("description", "XZ Compressed Archive");
		tarxz.put("extensions", new String[] { ".xz" });
		tarxz.put("magic", new String[] { "FD377A585A00" }); // "˝7zXZ "
		tarxz.put("folder", "xzCompressedArchive");
		tarxz.put("object", new XzCompressedArchive());
		mime.add("application/x-xz");
		properties.add(tarxz);
		tarxz = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("XzCompressedArchive", new String[] {});

		Properties cab = new Properties();
		cab.put("description", "Windows Cabinet");
		cab.put("extensions", new String[] { ".cab" });
		cab.put("magic", new String[] { "4D534346" }); // "MSCF"
		cab.put("folder", "windowsCabinet");
		cab.put("object", new WindowsCabinet());
		mime.add("application/vnd.ms-cab-compressed");
		properties.add(cab);
		cab = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WindowsCabinet", new String[] {});

		Properties dicom = new Properties();
		dicom.put("description", "DICOM Image");
		dicom.put("extensions", new String[] { ".dcm", ".dicom", ".dicm" });
		dicom.put("magic", new String[] { "4449434D" }); // "DICM"
		dicom.put("folder", "dicomImage");
		dicom.put("object", new DicomImage());
		mime.add("image/dicom-rle");
		properties.add(dicom);
		dicom = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("DicomImage", new String[] {});

		Properties woff = new Properties();
		woff.put("description", "Web Open Font Format");
		woff.put("extensions", new String[] { ".woff" });
		woff.put("magic", new String[] { "774F4646" }); // "wOFF"
		woff.put("folder", "webOpenFontFormat");
		woff.put("object", new WebOpenFontFormat());
		mime.add("font/woff");
		properties.add(woff);
		woff = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WebOpenFontFormat", new String[] {});

		Properties woff2 = new Properties();
		woff2.put("description", "Web Open Font Format 2");
		woff2.put("extensions", new String[] { ".woff2" });
		woff2.put("magic", new String[] { "774F4632" }); // "wOF2"
		woff2.put("folder", "webOpenFontFormat2");
		woff2.put("object", new WebOpenFontFormat2());
		mime.add("font/woff2");
		properties.add(woff2);
		woff2 = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WebOpenFontFormat2", new String[] {});

		Properties xml = new Properties();
		xml.put("description", "XML (eXtensible Markup Language)");
		xml.put("extensions", new String[] { ".xml" });
		xml.put("magic", new String[] { "3C3F786D6C20" }); // "<?xml "
		xml.put("folder", "xmleXtensibleMarkupLanguage");
		xml.put("object", new XmleXtensibleMarkupLanguage());
		mime.add("text/xml");
		properties.add(xml);
		xml = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("XmleXtensibleMarkupLanguage", new String[] {});

		Properties webp = new Properties();
		webp.put("description", "WebP Image");
		webp.put("extensions", new String[] { ".webp" });
		webp.put("magic",
				new String[] { "52494646[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]57454250" }); // "RIFF----WEBP"
		webp.put("folder", "webPImage");
		webp.put("object", new WebPImage());
		mime.add("image/webp");
		properties.add(webp);
		webp = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("WebPImage", new String[] {});

		Properties rtf = new Properties();
		rtf.put("description", "Rich Text Format Document");
		rtf.put("extensions", new String[] { ".rtf" });
		rtf.put("magic", new String[] { "7B5C72746631" }); // "{\rtf1"
		rtf.put("folder", "richTextFormatDocument");
		rtf.put("object", new RichTextFormatDocument());
		mime.add("text/rtf");
		properties.add(rtf);
		rtf = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("RichTextFormatDocument", new String[] {});

		Properties tsv = new Properties();
		tsv.put("description", "MPEG Transport Stream");
		tsv.put("extensions", new String[] { ".ts", ".tsa", ".tsv" });
		tsv.put("magic", new String[] { "47" }); // "G"
		tsv.put("folder", "mpegTransportStream");
		tsv.put("object", new MpegTransportStream());
		mime.add("video/tsv");
		properties.add(tsv);
		tsv = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MpegTransportStream", new String[] {});

		Properties mpeg = new Properties();
		mpeg.put("description", "MPEG Video");
		mpeg.put("extensions", new String[] { ".mpeg", ".mpg", ".m15", ".m17" });
		mpeg.put("magic", new String[] { "000001BA", "47", "000001B3" }); // "  ∫", "G", "  ≥"
		mpeg.put("folder", "mpegVideo");
		mpeg.put("object", new MpegVideo());
		mime.add("video/mpeg");
		properties.add(mpeg);
		mpeg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("MpegVideo", new String[] {});

		Properties zlib = new Properties();
		zlib.put("description", "ZLIB Compressed Archive");
		zlib.put("extensions", new String[] { ".zlib" });
		zlib.put("magic", new String[] { "7801", "785E", "789C", "78DA", "7820", "787D", "78BB", "78F9" }); // "x",
																											// "x^",
																											// "xú",
																											// "x⁄",
																											// "x ",
																											// "x}",
																											// "xª",
																											// "x˘"
		zlib.put("folder", "zlibCompressedArchive");
		zlib.put("object", new ZlibCompressedArchive());
		mime.add("application/zlib");
		properties.add(zlib);
		zlib = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ZlibCompressedArchive", new String[] {});

		Properties eml = new Properties();
		eml.put("description", "Email Message");
		eml.put("extensions", new String[] { ".eml" });
		eml.put("magic", new String[] { "5265636569766564" }); // "Received"
		eml.put("folder", "emailMessage");
		eml.put("object", new EmailMessage());
		mime.add("text/eml");
		properties.add(eml);
		eml = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("EmailMessage", new String[] {});

		Properties tde = new Properties();
		tde.put("description", "Tableau Data Extract");
		tde.put("extensions", new String[] { ".tde" });
		tde.put("magic", new String[] { "20020162A01EAB0702000000" }); // " b†´   "
		tde.put("folder", "tableauDataExtract");
		tde.put("object", new TableauDataExtract());
		mime.add("application/tde");
		properties.add(tde);
		tde = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("TableauDataExtract", new String[] {});

		Properties zst = new Properties();
		zst.put("description", "ZStandard Compressed Archive");
		zst.put("extensions", new String[] { ".zst", ".zstd" });
		zst.put("magic", new String[] { "28B52FFD" }); // "(µ/˝"
		zst.put("folder", "zStandardCompressedArchive");
		zst.put("object", new ZStandardCompressedArchive());
		mime.add("application/zstd");
		properties.add(zst);
		zst = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ZStandardCompressedArchive", new String[] {});

		Properties vpk = new Properties();
		vpk.put("description", "Valve Pak");
		vpk.put("extensions", new String[] { ".vpk" });
		vpk.put("magic", new String[] { "3412AA55" }); // "4™U"
		vpk.put("folder", "valvePak");
		vpk.put("object", new ValvePak());
		mime.add("application/vpk");
		properties.add(vpk);
		vpk = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get("folder"));
		applications.putIfAbsent("ValvePak", new String[] {});

		fileTypes.add(mime);
		fileTypes.add(properties);
		out.writeObject(fileTypes);
		out.close();

		out = new ObjectOutputStream(new FileOutputStream(applicationsFile));
		out.writeObject(applications);
		out.close();

		if (!new File(defaultApplicationsFile).isFile()) {
			Properties defaultApplications = new Properties();
			defaultApplications.storeToXML(new FileOutputStream(defaultApplicationsFile), "");
		}

		Properties applicationsSyntax = new Properties();
		applicationsSyntax.store(new FileOutputStream(applicationsSyntaxFile), "");

		createEditorList();
	}

	/**
	 * @throws IOException
	 */
	private static void createEditorList() throws IOException {
		String[] editors = new String[] { "Binary", "Plain Text" };
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(editorListFile));
		out.writeObject(editors);
		out.close();
	}

	/**
	 * @return true
	 */
	@Override
	public boolean equals(Object obj) {
		return true;
	}

	/**
	 * 
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new FileTypes();
	}
}
