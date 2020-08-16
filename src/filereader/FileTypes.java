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
# � 2020 GitHub, Inc.                                                            #
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
	private static final String _root = Messages.getString("FileTypes.0"); //$NON-NLS-1$
	private static final String applicationsFile = _root + Messages.getString("FileTypes.1"); //$NON-NLS-1$
	private static final String applicationsSyntaxFile = _root + Messages.getString("FileTypes.2"); //$NON-NLS-1$
	private static final String defaultApplicationsFile = _root + Messages.getString("FileTypes.3"); //$NON-NLS-1$
	private static final String editorListFile = Messages.getString("FileTypes.4"); //$NON-NLS-1$
	private static final File fileTypePropertiesFile = new File(Messages.getString("FileTypes.5")); //$NON-NLS-1$

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
		octetstream.put(Messages.getString("FileTypes.6"), Messages.getString("FileTypes.7")); //$NON-NLS-1$ //$NON-NLS-2$
		octetstream.put(Messages.getString("FileTypes.8"), new String[] {}); //$NON-NLS-1$
		octetstream.put(Messages.getString("FileTypes.9"), Messages.getString("FileTypes.10")); //$NON-NLS-1$ //$NON-NLS-2$
		octetstream.put(Messages.getString("FileTypes.11"), new Octetstream()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.12")); //$NON-NLS-1$
		properties.add(octetstream);
		octetstream = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.13")));
		applications.putIfAbsent(Messages.getString("FileTypes.14"), new String[] {}); //$NON-NLS-1$

		Properties plain = new Properties();
		plain.put(Messages.getString("FileTypes.15"), Messages.getString("FileTypes.16")); //$NON-NLS-1$ //$NON-NLS-2$
		plain.put(Messages.getString("FileTypes.17"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.18"), Messages.getString("FileTypes.19") }); //$NON-NLS-1$ //$NON-NLS-2$
		plain.put(Messages.getString("FileTypes.20"), Messages.getString("FileTypes.21")); //$NON-NLS-1$ //$NON-NLS-2$
		plain.put(Messages.getString("FileTypes.22"), new PlainText()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.23")); //$NON-NLS-1$
		properties.add(plain);
		plain = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.24")));
		applications.putIfAbsent(Messages.getString("FileTypes.25"), new String[] {}); //$NON-NLS-1$

		Properties java = new Properties();
		java.put(Messages.getString("FileTypes.26"), Messages.getString("FileTypes.27")); //$NON-NLS-1$ //$NON-NLS-2$
		java.put(Messages.getString("FileTypes.28"), new String[] { Messages.getString("FileTypes.29") }); //$NON-NLS-1$ //$NON-NLS-2$
		java.put(Messages.getString("FileTypes.30"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.31"), Messages.getString("FileTypes.32"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.33"), Messages.getString("FileTypes.34"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.35"), Messages.getString("FileTypes.36"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.37"), Messages.getString("FileTypes.38") }); // "package //$NON-NLS-1$ //$NON-NLS-2$
																									// ", "import ",
																									// "public ",
																									// "abstract ",
		// "final ", "class ", "/*", "//"
		java.put(Messages.getString("FileTypes.39"), Messages.getString("FileTypes.40")); //$NON-NLS-1$ //$NON-NLS-2$
		java.put(Messages.getString("FileTypes.41"), new Java()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.42")); //$NON-NLS-1$
		properties.add(java);
		java = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.43")));
		applications.putIfAbsent(Messages.getString("FileTypes.44"), new String[] {}); //$NON-NLS-1$

		Properties nb = new Properties();
		nb.put(Messages.getString("FileTypes.45"), Messages.getString("FileTypes.46")); //$NON-NLS-1$ //$NON-NLS-2$
		nb.put(Messages.getString("FileTypes.47"), new String[] { Messages.getString("FileTypes.48") }); //$NON-NLS-1$ //$NON-NLS-2$
		nb.put(Messages.getString("FileTypes.49"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.50"), Messages.getString("FileTypes.51") }); // "(*", //$NON-NLS-1$ //$NON-NLS-2$
																											// "Notebook["
		nb.put(Messages.getString("FileTypes.52"), Messages.getString("FileTypes.53")); //$NON-NLS-1$ //$NON-NLS-2$
		nb.put(Messages.getString("FileTypes.54"), new MathematicaNotebook()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.55")); //$NON-NLS-1$
		properties.add(nb);
		nb = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.56")));
		applications.putIfAbsent(Messages.getString("FileTypes.57"), new String[] {}); //$NON-NLS-1$

		Properties msword = new Properties();
		msword.put(Messages.getString("FileTypes.58"), Messages.getString("FileTypes.59")); //$NON-NLS-1$ //$NON-NLS-2$
		msword.put(Messages.getString("FileTypes.60"), new String[] { Messages.getString("FileTypes.61") }); //$NON-NLS-1$ //$NON-NLS-2$
		msword.put(Messages.getString("FileTypes.62"), new String[] { Messages.getString("FileTypes.63"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.64"), Messages.getString("FileTypes.65") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																							// "PK", "PK"
		msword.put(Messages.getString("FileTypes.66"), Messages.getString("FileTypes.67")); //$NON-NLS-1$ //$NON-NLS-2$
		msword.put(Messages.getString("FileTypes.68"), new MicrosoftWordDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.69")); //$NON-NLS-1$
		properties.add(msword);
		msword = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.70")));
		applications.putIfAbsent(Messages.getString("FileTypes.71"), new String[] {}); //$NON-NLS-1$

		Properties msexcel = new Properties();
		msexcel.put(Messages.getString("FileTypes.72"), Messages.getString("FileTypes.73")); //$NON-NLS-1$ //$NON-NLS-2$
		msexcel.put(Messages.getString("FileTypes.74"), new String[] { Messages.getString("FileTypes.75") }); //$NON-NLS-1$ //$NON-NLS-2$
		msexcel.put(Messages.getString("FileTypes.76"), new String[] { Messages.getString("FileTypes.77"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.78"), Messages.getString("FileTypes.79") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																							// "PK", "PK"
		msexcel.put(Messages.getString("FileTypes.80"), Messages.getString("FileTypes.81")); //$NON-NLS-1$ //$NON-NLS-2$
		msexcel.put(Messages.getString("FileTypes.82"), new MicrosoftExcelSpreadsheet()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.83")); //$NON-NLS-1$
		properties.add(msexcel);
		msexcel = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.84")));
		applications.putIfAbsent(Messages.getString("FileTypes.85"), new String[] {}); //$NON-NLS-1$

		Properties mspowerpoint = new Properties();
		mspowerpoint.put(Messages.getString("FileTypes.86"), Messages.getString("FileTypes.87")); //$NON-NLS-1$ //$NON-NLS-2$
		mspowerpoint.put(Messages.getString("FileTypes.88"), new String[] { Messages.getString("FileTypes.89") }); //$NON-NLS-1$ //$NON-NLS-2$
		mspowerpoint.put(Messages.getString("FileTypes.90"), new String[] { Messages.getString("FileTypes.91"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.92"), Messages.getString("FileTypes.93") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																							// "PK", "PK"
		mspowerpoint.put(Messages.getString("FileTypes.94"), Messages.getString("FileTypes.95")); //$NON-NLS-1$ //$NON-NLS-2$
		mspowerpoint.put(Messages.getString("FileTypes.96"), new MicrosoftPowerPointPresentation()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.97")); //$NON-NLS-1$
		properties.add(mspowerpoint);
		mspowerpoint = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.98")));
		applications.putIfAbsent(Messages.getString("FileTypes.99"), new String[] {}); //$NON-NLS-1$

		Properties msaccess = new Properties();
		msaccess.put(Messages.getString("FileTypes.100"), Messages.getString("FileTypes.101")); //$NON-NLS-1$ //$NON-NLS-2$
		msaccess.put(Messages.getString("FileTypes.102"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.103"), Messages.getString("FileTypes.104") }); //$NON-NLS-1$ //$NON-NLS-2$
		msaccess.put(Messages.getString("FileTypes.105"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.106"), Messages.getString("FileTypes.107"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.108"), Messages.getString("FileTypes.109") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																										// "PK",
		// "PK", "   "
		msaccess.put(Messages.getString("FileTypes.110"), Messages.getString("FileTypes.111")); //$NON-NLS-1$ //$NON-NLS-2$
		msaccess.put(Messages.getString("FileTypes.112"), new MicrosoftAccessDatabase()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.113")); //$NON-NLS-1$
		properties.add(msaccess);
		msaccess = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.114")));
		applications.putIfAbsent(Messages.getString("FileTypes.115"), new String[] {}); //$NON-NLS-1$

		Properties msonenote = new Properties();
		msonenote.put(Messages.getString("FileTypes.116"), Messages.getString("FileTypes.117")); //$NON-NLS-1$ //$NON-NLS-2$
		msonenote.put(Messages.getString("FileTypes.118"), new String[] { Messages.getString("FileTypes.119") }); //$NON-NLS-1$ //$NON-NLS-2$
		msonenote.put(Messages.getString("FileTypes.120"), new String[] { Messages.getString("FileTypes.121"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.122"), Messages.getString("FileTypes.123") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																								// "PK", "PK"
		msonenote.put(Messages.getString("FileTypes.124"), Messages.getString("FileTypes.125")); //$NON-NLS-1$ //$NON-NLS-2$
		msonenote.put(Messages.getString("FileTypes.126"), new MicrosoftOneNoteDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.127")); //$NON-NLS-1$
		properties.add(msonenote);
		msonenote = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.128")));
		applications.putIfAbsent(Messages.getString("FileTypes.129"), new String[] {}); //$NON-NLS-1$

		Properties sqlite = new Properties();
		sqlite.put(Messages.getString("FileTypes.130"), Messages.getString("FileTypes.131")); //$NON-NLS-1$ //$NON-NLS-2$
		sqlite.put(Messages.getString("FileTypes.132"), new String[] { Messages.getString("FileTypes.133"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.134"), Messages.getString("FileTypes.135") }); //$NON-NLS-1$ //$NON-NLS-2$
		sqlite.put(Messages.getString("FileTypes.136"), new String[] { Messages.getString("FileTypes.137") }); // "SQLite //$NON-NLS-1$ //$NON-NLS-2$
																												// format
																												// 3 "
		sqlite.put(Messages.getString("FileTypes.138"), Messages.getString("FileTypes.139")); //$NON-NLS-1$ //$NON-NLS-2$
		sqlite.put(Messages.getString("FileTypes.140"), new SqliteDatabase()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.141")); //$NON-NLS-1$
		properties.add(sqlite);
		sqlite = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.142")));
		applications.putIfAbsent(Messages.getString("FileTypes.143"), new String[] {}); //$NON-NLS-1$

		Properties icon = new Properties();
		icon.put(Messages.getString("FileTypes.144"), Messages.getString("FileTypes.145")); //$NON-NLS-1$ //$NON-NLS-2$
		icon.put(Messages.getString("FileTypes.146"), new String[] { Messages.getString("FileTypes.147") }); //$NON-NLS-1$ //$NON-NLS-2$
		icon.put(Messages.getString("FileTypes.148"), new String[] { Messages.getString("FileTypes.149") }); // "   " //$NON-NLS-1$ //$NON-NLS-2$
		icon.put(Messages.getString("FileTypes.150"), Messages.getString("FileTypes.151")); //$NON-NLS-1$ //$NON-NLS-2$
		icon.put(Messages.getString("FileTypes.152"), new Icon()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.153")); //$NON-NLS-1$
		properties.add(icon);
		icon = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.154")));
		applications.putIfAbsent(Messages.getString("FileTypes.155"), new String[] {}); //$NON-NLS-1$

		Properties tarzlzw = new Properties();
		tarzlzw.put(Messages.getString("FileTypes.156"), Messages.getString("FileTypes.157")); //$NON-NLS-1$ //$NON-NLS-2$
		tarzlzw.put(Messages.getString("FileTypes.158"), new String[] { Messages.getString("FileTypes.159") }); //$NON-NLS-1$ //$NON-NLS-2$
		tarzlzw.put(Messages.getString("FileTypes.160"), new String[] { Messages.getString("FileTypes.161") }); // " //$NON-NLS-1$ //$NON-NLS-2$
																												// �"
		tarzlzw.put(Messages.getString("FileTypes.162"), Messages.getString("FileTypes.163")); //$NON-NLS-1$ //$NON-NLS-2$
		tarzlzw.put(Messages.getString("FileTypes.164"), new ZLZWCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.165")); //$NON-NLS-1$
		properties.add(tarzlzw);
		tarzlzw = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.166")));
		applications.putIfAbsent(Messages.getString("FileTypes.167"), new String[] {}); //$NON-NLS-1$

		Properties tarzlzh = new Properties();
		tarzlzh.put(Messages.getString("FileTypes.168"), Messages.getString("FileTypes.169")); //$NON-NLS-1$ //$NON-NLS-2$
		tarzlzh.put(Messages.getString("FileTypes.170"), new String[] { Messages.getString("FileTypes.171") }); //$NON-NLS-1$ //$NON-NLS-2$
		tarzlzh.put(Messages.getString("FileTypes.172"), new String[] { Messages.getString("FileTypes.173") }); // " //$NON-NLS-1$ //$NON-NLS-2$
																												// �"
		tarzlzh.put(Messages.getString("FileTypes.174"), Messages.getString("FileTypes.175")); //$NON-NLS-1$ //$NON-NLS-2$
		tarzlzh.put(Messages.getString("FileTypes.176"), new ZLZHCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.177")); //$NON-NLS-1$
		properties.add(tarzlzh);
		tarzlzh = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.178")));
		applications.putIfAbsent(Messages.getString("FileTypes.179"), new String[] {}); //$NON-NLS-1$

		Properties bzip = new Properties();
		bzip.put(Messages.getString("FileTypes.180"), Messages.getString("FileTypes.181")); //$NON-NLS-1$ //$NON-NLS-2$
		bzip.put(Messages.getString("FileTypes.182"), new String[] { Messages.getString("FileTypes.183") }); //$NON-NLS-1$ //$NON-NLS-2$
		bzip.put(Messages.getString("FileTypes.184"), new String[] { Messages.getString("FileTypes.185") }); // "BZh" //$NON-NLS-1$ //$NON-NLS-2$
		bzip.put(Messages.getString("FileTypes.186"), Messages.getString("FileTypes.187")); //$NON-NLS-1$ //$NON-NLS-2$
		bzip.put(Messages.getString("FileTypes.188"), new Bzip2CompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.189")); //$NON-NLS-1$
		properties.add(bzip);
		bzip = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.190")));
		applications.putIfAbsent(Messages.getString("FileTypes.191"), new String[] {}); //$NON-NLS-1$

		Properties gif = new Properties();
		gif.put(Messages.getString("FileTypes.192"), Messages.getString("FileTypes.193")); //$NON-NLS-1$ //$NON-NLS-2$
		gif.put(Messages.getString("FileTypes.194"), new String[] { Messages.getString("FileTypes.195") }); //$NON-NLS-1$ //$NON-NLS-2$
		gif.put(Messages.getString("FileTypes.196"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.197"), Messages.getString("FileTypes.198") }); // "GIF87a", //$NON-NLS-1$ //$NON-NLS-2$
																											// "GIF89a"
		gif.put(Messages.getString("FileTypes.199"), Messages.getString("FileTypes.200")); //$NON-NLS-1$ //$NON-NLS-2$
		gif.put(Messages.getString("FileTypes.201"), new GifImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.202")); //$NON-NLS-1$
		properties.add(gif);
		gif = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.203")));
		applications.putIfAbsent(Messages.getString("FileTypes.204"), new String[] {}); //$NON-NLS-1$

		Properties tiff = new Properties();
		tiff.put(Messages.getString("FileTypes.205"), Messages.getString("FileTypes.206")); //$NON-NLS-1$ //$NON-NLS-2$
		tiff.put(Messages.getString("FileTypes.207"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.208"), Messages.getString("FileTypes.209") }); //$NON-NLS-1$ //$NON-NLS-2$
		tiff.put(Messages.getString("FileTypes.210"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.211"), Messages.getString("FileTypes.212") }); // "II* ", //$NON-NLS-1$ //$NON-NLS-2$
																											// "MM *"
		tiff.put(Messages.getString("FileTypes.213"), Messages.getString("FileTypes.214")); //$NON-NLS-1$ //$NON-NLS-2$
		tiff.put(Messages.getString("FileTypes.215"), new TiffImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.216")); //$NON-NLS-1$
		properties.add(tiff);
		tiff = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.217")));
		applications.putIfAbsent(Messages.getString("FileTypes.218"), new String[] {}); //$NON-NLS-1$

		Properties jpeg = new Properties();
		jpeg.put(Messages.getString("FileTypes.219"), Messages.getString("FileTypes.220")); //$NON-NLS-1$ //$NON-NLS-2$
		jpeg.put(Messages.getString("FileTypes.221"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.222"), Messages.getString("FileTypes.223") }); //$NON-NLS-1$ //$NON-NLS-2$
		jpeg.put(Messages.getString("FileTypes.224"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.225"), Messages.getString("FileTypes.226"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.227"), //$NON-NLS-1$
						Messages.getString("FileTypes.228") }); // "����", "���� JFIF ", //$NON-NLS-1$
																// "����",
																// "����----Exif  "
		jpeg.put(Messages.getString("FileTypes.229"), Messages.getString("FileTypes.230")); //$NON-NLS-1$ //$NON-NLS-2$
		jpeg.put(Messages.getString("FileTypes.231"), new JpegImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.232")); //$NON-NLS-1$
		properties.add(jpeg);
		jpeg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.233")));
		applications.putIfAbsent(Messages.getString("FileTypes.234"), new String[] {}); //$NON-NLS-1$

		Properties lzip = new Properties();
		lzip.put(Messages.getString("FileTypes.235"), Messages.getString("FileTypes.236")); //$NON-NLS-1$ //$NON-NLS-2$
		lzip.put(Messages.getString("FileTypes.237"), new String[] { Messages.getString("FileTypes.238") }); //$NON-NLS-1$ //$NON-NLS-2$
		lzip.put(Messages.getString("FileTypes.239"), new String[] { Messages.getString("FileTypes.240") }); // "LZIP" //$NON-NLS-1$ //$NON-NLS-2$
		lzip.put(Messages.getString("FileTypes.241"), Messages.getString("FileTypes.242")); //$NON-NLS-1$ //$NON-NLS-2$
		lzip.put(Messages.getString("FileTypes.243"), new LzipCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.244")); //$NON-NLS-1$
		properties.add(lzip);
		lzip = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.245")));
		applications.putIfAbsent(Messages.getString("FileTypes.246"), new String[] {}); //$NON-NLS-1$

		Properties mzexecutable = new Properties();
		mzexecutable.put(Messages.getString("FileTypes.247"), Messages.getString("FileTypes.248")); //$NON-NLS-1$ //$NON-NLS-2$
		mzexecutable.put(Messages.getString("FileTypes.249"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.250"), Messages.getString("FileTypes.251") }); //$NON-NLS-1$ //$NON-NLS-2$
		mzexecutable.put(Messages.getString("FileTypes.252"), new String[] { Messages.getString("FileTypes.253") }); // "MZ" //$NON-NLS-1$ //$NON-NLS-2$
		mzexecutable.put(Messages.getString("FileTypes.254"), Messages.getString("FileTypes.255")); //$NON-NLS-1$ //$NON-NLS-2$
		mzexecutable.put(Messages.getString("FileTypes.256"), new WindowsMZDOSExecutable()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.257")); //$NON-NLS-1$
		properties.add(mzexecutable);
		mzexecutable = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.258")));
		applications.putIfAbsent(Messages.getString("FileTypes.259"), new String[] {}); //$NON-NLS-1$

		Properties zip = new Properties();
		zip.put(Messages.getString("FileTypes.260"), Messages.getString("FileTypes.261")); //$NON-NLS-1$ //$NON-NLS-2$
		zip.put(Messages.getString("FileTypes.262"), new String[] { Messages.getString("FileTypes.263") }); //$NON-NLS-1$ //$NON-NLS-2$
		zip.put(Messages.getString("FileTypes.264"), new String[] { Messages.getString("FileTypes.265"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.266"), Messages.getString("FileTypes.267") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																								// "PK", "PK"
		zip.put(Messages.getString("FileTypes.268"), Messages.getString("FileTypes.269")); //$NON-NLS-1$ //$NON-NLS-2$
		zip.put(Messages.getString("FileTypes.270"), new ZipCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.271")); //$NON-NLS-1$
		properties.add(zip);
		zip = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.272")));
		applications.putIfAbsent(Messages.getString("FileTypes.273"), new String[] {}); //$NON-NLS-1$

		Properties odt = new Properties();
		odt.put(Messages.getString("FileTypes.274"), Messages.getString("FileTypes.275")); //$NON-NLS-1$ //$NON-NLS-2$
		odt.put(Messages.getString("FileTypes.276"), new String[] { Messages.getString("FileTypes.277") }); //$NON-NLS-1$ //$NON-NLS-2$
		odt.put(Messages.getString("FileTypes.278"), new String[] { Messages.getString("FileTypes.279"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.280"), Messages.getString("FileTypes.281") }); // "PK", //$NON-NLS-1$ //$NON-NLS-2$
																								// "PK", "PK"
		odt.put(Messages.getString("FileTypes.282"), Messages.getString("FileTypes.283")); //$NON-NLS-1$ //$NON-NLS-2$
		odt.put(Messages.getString("FileTypes.284"), new OpenDocumentTextDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.285")); //$NON-NLS-1$
		properties.add(odt);
		odt = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.286")));
		applications.putIfAbsent(Messages.getString("FileTypes.287"), new String[] {}); //$NON-NLS-1$

		Properties zmexecutable = new Properties();
		zmexecutable.put(Messages.getString("FileTypes.288"), Messages.getString("FileTypes.289")); //$NON-NLS-1$ //$NON-NLS-2$
		zmexecutable.put(Messages.getString("FileTypes.290"), new String[] { Messages.getString("FileTypes.291") }); //$NON-NLS-1$ //$NON-NLS-2$
		zmexecutable.put(Messages.getString("FileTypes.292"), new String[] { Messages.getString("FileTypes.293") }); // "ZM" //$NON-NLS-1$ //$NON-NLS-2$
		zmexecutable.put(Messages.getString("FileTypes.294"), Messages.getString("FileTypes.295")); //$NON-NLS-1$ //$NON-NLS-2$
		zmexecutable.put(Messages.getString("FileTypes.296"), new WindowsZMDOSExecutable()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.297")); //$NON-NLS-1$
		properties.add(zmexecutable);
		zmexecutable = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.298")));
		applications.putIfAbsent(Messages.getString("FileTypes.299"), new String[] {}); //$NON-NLS-1$

		Properties png = new Properties();
		png.put(Messages.getString("FileTypes.300"), Messages.getString("FileTypes.301")); //$NON-NLS-1$ //$NON-NLS-2$
		png.put(Messages.getString("FileTypes.302"), new String[] { Messages.getString("FileTypes.303") }); //$NON-NLS-1$ //$NON-NLS-2$
		png.put(Messages.getString("FileTypes.304"), new String[] { Messages.getString("FileTypes.305") }); // "�PNG //$NON-NLS-1$ //$NON-NLS-2$
		// 
		// "
		png.put(Messages.getString("FileTypes.306"), Messages.getString("FileTypes.307")); //$NON-NLS-1$ //$NON-NLS-2$
		png.put(Messages.getString("FileTypes.308"), new PngImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.309")); //$NON-NLS-1$
		properties.add(png);
		png = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.310")));
		applications.putIfAbsent(Messages.getString("FileTypes.311"), new String[] {}); //$NON-NLS-1$

		Properties com = new Properties();
		com.put(Messages.getString("FileTypes.312"), Messages.getString("FileTypes.313")); //$NON-NLS-1$ //$NON-NLS-2$
		com.put(Messages.getString("FileTypes.314"), new String[] { Messages.getString("FileTypes.315") }); //$NON-NLS-1$ //$NON-NLS-2$
		com.put(Messages.getString("FileTypes.316"), new String[] { Messages.getString("FileTypes.317") }); // "�" //$NON-NLS-1$ //$NON-NLS-2$
		com.put(Messages.getString("FileTypes.318"), Messages.getString("FileTypes.319")); //$NON-NLS-1$ //$NON-NLS-2$
		com.put(Messages.getString("FileTypes.320"), new ComDOSExecutable()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.321")); //$NON-NLS-1$
		properties.add(com);
		com = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.322")));
		applications.putIfAbsent(Messages.getString("FileTypes.323"), new String[] {}); //$NON-NLS-1$

		Properties classfile = new Properties();
		classfile.put(Messages.getString("FileTypes.324"), Messages.getString("FileTypes.325")); //$NON-NLS-1$ //$NON-NLS-2$
		classfile.put(Messages.getString("FileTypes.326"), new String[] { Messages.getString("FileTypes.327") }); //$NON-NLS-1$ //$NON-NLS-2$
		classfile.put(Messages.getString("FileTypes.328"), new String[] { Messages.getString("FileTypes.329") }); // "����" //$NON-NLS-1$ //$NON-NLS-2$
		classfile.put(Messages.getString("FileTypes.330"), Messages.getString("FileTypes.331")); //$NON-NLS-1$ //$NON-NLS-2$
		classfile.put(Messages.getString("FileTypes.332"), new JavaClassFile()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.333")); //$NON-NLS-1$
		properties.add(classfile);
		classfile = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.334")));
		applications.putIfAbsent(Messages.getString("FileTypes.335"), new String[] {}); //$NON-NLS-1$

		Properties ps = new Properties();
		ps.put(Messages.getString("FileTypes.336"), Messages.getString("FileTypes.337")); //$NON-NLS-1$ //$NON-NLS-2$
		ps.put(Messages.getString("FileTypes.338"), new String[] { Messages.getString("FileTypes.339") }); //$NON-NLS-1$ //$NON-NLS-2$
		ps.put(Messages.getString("FileTypes.340"), new String[] { Messages.getString("FileTypes.341") }); // "%!PS" //$NON-NLS-1$ //$NON-NLS-2$
		ps.put(Messages.getString("FileTypes.342"), Messages.getString("FileTypes.343")); //$NON-NLS-1$ //$NON-NLS-2$
		ps.put(Messages.getString("FileTypes.344"), new PostScriptDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.345")); //$NON-NLS-1$
		properties.add(ps);
		ps = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.346")));
		applications.putIfAbsent(Messages.getString("FileTypes.347"), new String[] {}); //$NON-NLS-1$

		Properties chm = new Properties();
		chm.put(Messages.getString("FileTypes.348"), Messages.getString("FileTypes.349")); //$NON-NLS-1$ //$NON-NLS-2$
		chm.put(Messages.getString("FileTypes.350"), new String[] { Messages.getString("FileTypes.351") }); //$NON-NLS-1$ //$NON-NLS-2$
		chm.put(Messages.getString("FileTypes.352"), new String[] { Messages.getString("FileTypes.353") }); // "ITSF   `   " //$NON-NLS-1$ //$NON-NLS-2$
		chm.put(Messages.getString("FileTypes.354"), Messages.getString("FileTypes.355")); //$NON-NLS-1$ //$NON-NLS-2$
		chm.put(Messages.getString("FileTypes.356"), new CompiledHTMLHelp()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.357")); //$NON-NLS-1$
		properties.add(chm);
		chm = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.358")));
		applications.putIfAbsent(Messages.getString("FileTypes.359"), new String[] {}); //$NON-NLS-1$

		Properties pdf = new Properties();
		pdf.put(Messages.getString("FileTypes.360"), Messages.getString("FileTypes.361")); //$NON-NLS-1$ //$NON-NLS-2$
		pdf.put(Messages.getString("FileTypes.362"), new String[] { Messages.getString("FileTypes.363") }); //$NON-NLS-1$ //$NON-NLS-2$
		pdf.put(Messages.getString("FileTypes.364"), new String[] { Messages.getString("FileTypes.365") }); // "%PDF-" //$NON-NLS-1$ //$NON-NLS-2$
		pdf.put(Messages.getString("FileTypes.366"), Messages.getString("FileTypes.367")); //$NON-NLS-1$ //$NON-NLS-2$
		pdf.put(Messages.getString("FileTypes.368"), new PdfDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.369")); //$NON-NLS-1$
		properties.add(pdf);
		pdf = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.370")));
		applications.putIfAbsent(Messages.getString("FileTypes.371"), new String[] {}); //$NON-NLS-1$

		Properties wma = new Properties();
		wma.put(Messages.getString("FileTypes.372"), Messages.getString("FileTypes.373")); //$NON-NLS-1$ //$NON-NLS-2$
		wma.put(Messages.getString("FileTypes.374"), new String[] { Messages.getString("FileTypes.375") }); //$NON-NLS-1$ //$NON-NLS-2$
		wma.put(Messages.getString("FileTypes.376"), new String[] { Messages.getString("FileTypes.377") }); // "0&�u�f��� � b�l" //$NON-NLS-1$ //$NON-NLS-2$
		wma.put(Messages.getString("FileTypes.378"), Messages.getString("FileTypes.379")); //$NON-NLS-1$ //$NON-NLS-2$
		wma.put(Messages.getString("FileTypes.380"), new WindowsMediaAudio()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.381")); //$NON-NLS-1$
		properties.add(wma);
		wma = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.382")));
		applications.putIfAbsent(Messages.getString("FileTypes.383"), new String[] {}); //$NON-NLS-1$

		Properties asf = new Properties();
		asf.put(Messages.getString("FileTypes.384"), Messages.getString("FileTypes.385")); //$NON-NLS-1$ //$NON-NLS-2$
		asf.put(Messages.getString("FileTypes.386"), new String[] { Messages.getString("FileTypes.387") }); //$NON-NLS-1$ //$NON-NLS-2$
		asf.put(Messages.getString("FileTypes.388"), new String[] { Messages.getString("FileTypes.389") }); // "0&�u�f��� � b�l" //$NON-NLS-1$ //$NON-NLS-2$
		asf.put(Messages.getString("FileTypes.390"), Messages.getString("FileTypes.391")); //$NON-NLS-1$ //$NON-NLS-2$
		asf.put(Messages.getString("FileTypes.392"), new AdvancedSystemsFile()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.393")); //$NON-NLS-1$
		properties.add(asf);
		asf = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.394")));
		applications.putIfAbsent(Messages.getString("FileTypes.395"), new String[] {}); //$NON-NLS-1$

		Properties wmv = new Properties();
		wmv.put(Messages.getString("FileTypes.396"), Messages.getString("FileTypes.397")); //$NON-NLS-1$ //$NON-NLS-2$
		wmv.put(Messages.getString("FileTypes.398"), new String[] { Messages.getString("FileTypes.399") }); //$NON-NLS-1$ //$NON-NLS-2$
		wmv.put(Messages.getString("FileTypes.400"), new String[] { Messages.getString("FileTypes.401") }); // "0&�u�f��� � b�l" //$NON-NLS-1$ //$NON-NLS-2$
		wmv.put(Messages.getString("FileTypes.402"), Messages.getString("FileTypes.403")); //$NON-NLS-1$ //$NON-NLS-2$
		wmv.put(Messages.getString("FileTypes.404"), new WindowsMediaVideo()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.405")); //$NON-NLS-1$
		properties.add(wmv);
		wmv = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.406")));
		applications.putIfAbsent(Messages.getString("FileTypes.407"), new String[] {}); //$NON-NLS-1$

		Properties ogg = new Properties();
		ogg.put(Messages.getString("FileTypes.408"), Messages.getString("FileTypes.409")); //$NON-NLS-1$ //$NON-NLS-2$
		ogg.put(Messages.getString("FileTypes.410"), new String[] { Messages.getString("FileTypes.411") }); //$NON-NLS-1$ //$NON-NLS-2$
		ogg.put(Messages.getString("FileTypes.412"), new String[] { Messages.getString("FileTypes.413") }); // "OggS" //$NON-NLS-1$ //$NON-NLS-2$
		ogg.put(Messages.getString("FileTypes.414"), Messages.getString("FileTypes.415")); //$NON-NLS-1$ //$NON-NLS-2$
		ogg.put(Messages.getString("FileTypes.416"), new OggVorbisCompressedAudio()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.417")); //$NON-NLS-1$
		properties.add(ogg);
		ogg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.418")));
		applications.putIfAbsent(Messages.getString("FileTypes.419"), new String[] {}); //$NON-NLS-1$

		Properties oga = new Properties();
		oga.put(Messages.getString("FileTypes.420"), Messages.getString("FileTypes.421")); //$NON-NLS-1$ //$NON-NLS-2$
		oga.put(Messages.getString("FileTypes.422"), new String[] { Messages.getString("FileTypes.423") }); //$NON-NLS-1$ //$NON-NLS-2$
		oga.put(Messages.getString("FileTypes.424"), new String[] { Messages.getString("FileTypes.425") }); // "OggS" //$NON-NLS-1$ //$NON-NLS-2$
		oga.put(Messages.getString("FileTypes.426"), Messages.getString("FileTypes.427")); //$NON-NLS-1$ //$NON-NLS-2$
		oga.put(Messages.getString("FileTypes.428"), new OggVorbisAudio()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.429")); //$NON-NLS-1$
		properties.add(oga);
		oga = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.430")));
		applications.putIfAbsent(Messages.getString("FileTypes.431"), new String[] {}); //$NON-NLS-1$

		Properties ogv = new Properties();
		ogv.put(Messages.getString("FileTypes.432"), Messages.getString("FileTypes.433")); //$NON-NLS-1$ //$NON-NLS-2$
		ogv.put(Messages.getString("FileTypes.434"), new String[] { Messages.getString("FileTypes.435") }); //$NON-NLS-1$ //$NON-NLS-2$
		ogv.put(Messages.getString("FileTypes.436"), new String[] { Messages.getString("FileTypes.437") }); // "OggS" //$NON-NLS-1$ //$NON-NLS-2$
		ogv.put(Messages.getString("FileTypes.438"), Messages.getString("FileTypes.439")); //$NON-NLS-1$ //$NON-NLS-2$
		ogv.put(Messages.getString("FileTypes.440"), new OggVorbisVideo()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.441")); //$NON-NLS-1$
		properties.add(ogv);
		ogv = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.442")));
		applications.putIfAbsent(Messages.getString("FileTypes.443"), new String[] {}); //$NON-NLS-1$

		Properties psd = new Properties();
		psd.put(Messages.getString("FileTypes.444"), Messages.getString("FileTypes.445")); //$NON-NLS-1$ //$NON-NLS-2$
		psd.put(Messages.getString("FileTypes.446"), new String[] { Messages.getString("FileTypes.447") }); //$NON-NLS-1$ //$NON-NLS-2$
		psd.put(Messages.getString("FileTypes.448"), new String[] { Messages.getString("FileTypes.449") }); // "8BPS" //$NON-NLS-1$ //$NON-NLS-2$
		psd.put(Messages.getString("FileTypes.450"), Messages.getString("FileTypes.451")); //$NON-NLS-1$ //$NON-NLS-2$
		psd.put(Messages.getString("FileTypes.452"), new AdobePhotoshopDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.453")); //$NON-NLS-1$
		properties.add(psd);
		psd = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.454")));
		applications.putIfAbsent(Messages.getString("FileTypes.455"), new String[] {}); //$NON-NLS-1$

		Properties wav = new Properties();
		wav.put(Messages.getString("FileTypes.456"), Messages.getString("FileTypes.457")); //$NON-NLS-1$ //$NON-NLS-2$
		wav.put(Messages.getString("FileTypes.458"), new String[] { Messages.getString("FileTypes.459") }); //$NON-NLS-1$ //$NON-NLS-2$
		wav.put(Messages.getString("FileTypes.460"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.461") }); // "RIFF----WAVE" //$NON-NLS-1$
		wav.put(Messages.getString("FileTypes.462"), Messages.getString("FileTypes.463")); //$NON-NLS-1$ //$NON-NLS-2$
		wav.put(Messages.getString("FileTypes.464"), new WaveAudio()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.465")); //$NON-NLS-1$
		properties.add(wav);
		wav = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.466")));
		applications.putIfAbsent(Messages.getString("FileTypes.467"), new String[] {}); //$NON-NLS-1$

		Properties avi = new Properties();
		avi.put(Messages.getString("FileTypes.468"), Messages.getString("FileTypes.469")); //$NON-NLS-1$ //$NON-NLS-2$
		avi.put(Messages.getString("FileTypes.470"), new String[] { Messages.getString("FileTypes.471") }); //$NON-NLS-1$ //$NON-NLS-2$
		avi.put(Messages.getString("FileTypes.472"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.473") }); // "RIFF----AVI //$NON-NLS-1$
																		// "
		avi.put(Messages.getString("FileTypes.474"), Messages.getString("FileTypes.475")); //$NON-NLS-1$ //$NON-NLS-2$
		avi.put(Messages.getString("FileTypes.476"), new AudioVideoInterleave()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.477")); //$NON-NLS-1$
		properties.add(avi);
		avi = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.478")));
		applications.putIfAbsent(Messages.getString("FileTypes.479"), new String[] {}); //$NON-NLS-1$

		Properties mp3 = new Properties();
		mp3.put(Messages.getString("FileTypes.480"), Messages.getString("FileTypes.481")); //$NON-NLS-1$ //$NON-NLS-2$
		mp3.put(Messages.getString("FileTypes.482"), new String[] { Messages.getString("FileTypes.483") }); //$NON-NLS-1$ //$NON-NLS-2$
		mp3.put(Messages.getString("FileTypes.484"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.485"), Messages.getString("FileTypes.486"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.487"), Messages.getString("FileTypes.488") }); // "��", //$NON-NLS-1$ //$NON-NLS-2$
																										// "��",
																										// "��",
																										// "ID3"
		mp3.put(Messages.getString("FileTypes.489"), Messages.getString("FileTypes.490")); //$NON-NLS-1$ //$NON-NLS-2$
		mp3.put(Messages.getString("FileTypes.491"), new Mp3Audio()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.492")); //$NON-NLS-1$
		properties.add(mp3);
		mp3 = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.493")));
		applications.putIfAbsent(Messages.getString("FileTypes.494"), new String[] {}); //$NON-NLS-1$

		Properties bmp = new Properties();
		bmp.put(Messages.getString("FileTypes.495"), Messages.getString("FileTypes.496")); //$NON-NLS-1$ //$NON-NLS-2$
		bmp.put(Messages.getString("FileTypes.497"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.498"), Messages.getString("FileTypes.499") }); //$NON-NLS-1$ //$NON-NLS-2$
		bmp.put(Messages.getString("FileTypes.500"), new String[] { Messages.getString("FileTypes.501") }); // "BM" //$NON-NLS-1$ //$NON-NLS-2$
		bmp.put(Messages.getString("FileTypes.502"), Messages.getString("FileTypes.503")); //$NON-NLS-1$ //$NON-NLS-2$
		bmp.put(Messages.getString("FileTypes.504"), new BitmapImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.505")); //$NON-NLS-1$
		properties.add(bmp);
		bmp = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.506")));
		applications.putIfAbsent(Messages.getString("FileTypes.507"), new String[] {}); //$NON-NLS-1$

		Properties iso = new Properties();
		iso.put(Messages.getString("FileTypes.508"), Messages.getString("FileTypes.509")); //$NON-NLS-1$ //$NON-NLS-2$
		iso.put(Messages.getString("FileTypes.510"), new String[] { Messages.getString("FileTypes.511") }); //$NON-NLS-1$ //$NON-NLS-2$
		iso.put(Messages.getString("FileTypes.512"), new String[] { Messages.getString("FileTypes.513") }); // "CD001" //$NON-NLS-1$ //$NON-NLS-2$
		iso.put(Messages.getString("FileTypes.514"), Messages.getString("FileTypes.515")); //$NON-NLS-1$ //$NON-NLS-2$
		iso.put(Messages.getString("FileTypes.516"), new DiscImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.517")); //$NON-NLS-1$
		properties.add(iso);
		iso = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.518")));
		applications.putIfAbsent(Messages.getString("FileTypes.519"), new String[] {}); //$NON-NLS-1$

		Properties flac = new Properties();
		flac.put(Messages.getString("FileTypes.520"), Messages.getString("FileTypes.521")); //$NON-NLS-1$ //$NON-NLS-2$
		flac.put(Messages.getString("FileTypes.522"), new String[] { Messages.getString("FileTypes.523") }); //$NON-NLS-1$ //$NON-NLS-2$
		flac.put(Messages.getString("FileTypes.524"), new String[] { Messages.getString("FileTypes.525") }); // "fLaC" //$NON-NLS-1$ //$NON-NLS-2$
		flac.put(Messages.getString("FileTypes.526"), Messages.getString("FileTypes.527")); //$NON-NLS-1$ //$NON-NLS-2$
		flac.put(Messages.getString("FileTypes.528"), new FreeLosslessAudioCodec()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.529")); //$NON-NLS-1$
		properties.add(flac);
		flac = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.530")));
		applications.putIfAbsent(Messages.getString("FileTypes.531"), new String[] {}); //$NON-NLS-1$

		Properties midi = new Properties();
		midi.put(Messages.getString("FileTypes.532"), Messages.getString("FileTypes.533")); //$NON-NLS-1$ //$NON-NLS-2$
		midi.put(Messages.getString("FileTypes.534"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.535"), Messages.getString("FileTypes.536") }); //$NON-NLS-1$ //$NON-NLS-2$
		midi.put(Messages.getString("FileTypes.537"), new String[] { Messages.getString("FileTypes.538") }); // "MThd" //$NON-NLS-1$ //$NON-NLS-2$
		midi.put(Messages.getString("FileTypes.539"), Messages.getString("FileTypes.540")); //$NON-NLS-1$ //$NON-NLS-2$
		midi.put(Messages.getString("FileTypes.541"), new MidiAudio()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.542")); //$NON-NLS-1$
		properties.add(midi);
		midi = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.543")));
		applications.putIfAbsent(Messages.getString("FileTypes.544"), new String[] {}); //$NON-NLS-1$

		Properties doc = new Properties();
		doc.put(Messages.getString("FileTypes.545"), Messages.getString("FileTypes.546")); //$NON-NLS-1$ //$NON-NLS-2$
		doc.put(Messages.getString("FileTypes.547"), new String[] { Messages.getString("FileTypes.548") }); //$NON-NLS-1$ //$NON-NLS-2$
		doc.put(Messages.getString("FileTypes.549"), new String[] { Messages.getString("FileTypes.550") }); // "��ࡱ�" //$NON-NLS-1$ //$NON-NLS-2$
		doc.put(Messages.getString("FileTypes.551"), Messages.getString("FileTypes.552")); //$NON-NLS-1$ //$NON-NLS-2$
		doc.put(Messages.getString("FileTypes.553"), new MicrosoftWord972003Document()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.554")); //$NON-NLS-1$
		properties.add(doc);
		doc = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.555")));
		applications.putIfAbsent(Messages.getString("FileTypes.556"), new String[] {}); //$NON-NLS-1$

		Properties xls = new Properties();
		xls.put(Messages.getString("FileTypes.557"), Messages.getString("FileTypes.558")); //$NON-NLS-1$ //$NON-NLS-2$
		xls.put(Messages.getString("FileTypes.559"), new String[] { Messages.getString("FileTypes.560"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.561"), Messages.getString("FileTypes.562") }); //$NON-NLS-1$ //$NON-NLS-2$
		xls.put(Messages.getString("FileTypes.563"), new String[] { Messages.getString("FileTypes.564") }); // "��ࡱ�" //$NON-NLS-1$ //$NON-NLS-2$
		xls.put(Messages.getString("FileTypes.565"), Messages.getString("FileTypes.566")); //$NON-NLS-1$ //$NON-NLS-2$
		xls.put(Messages.getString("FileTypes.567"), new MicrosoftExcel972003Spreadsheet()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.568")); //$NON-NLS-1$
		properties.add(xls);
		xls = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.569")));
		applications.putIfAbsent(Messages.getString("FileTypes.570"), new String[] {}); //$NON-NLS-1$

		Properties ppt = new Properties();
		ppt.put(Messages.getString("FileTypes.571"), Messages.getString("FileTypes.572")); //$NON-NLS-1$ //$NON-NLS-2$
		ppt.put(Messages.getString("FileTypes.573"), new String[] { Messages.getString("FileTypes.574") }); //$NON-NLS-1$ //$NON-NLS-2$
		ppt.put(Messages.getString("FileTypes.575"), new String[] { Messages.getString("FileTypes.576") }); // "��ࡱ�" //$NON-NLS-1$ //$NON-NLS-2$
		ppt.put(Messages.getString("FileTypes.577"), Messages.getString("FileTypes.578")); //$NON-NLS-1$ //$NON-NLS-2$
		ppt.put(Messages.getString("FileTypes.579"), new MicrosoftPowerPoint972003Presentation()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.580")); //$NON-NLS-1$
		properties.add(ppt);
		ppt = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.581")));
		applications.putIfAbsent(Messages.getString("FileTypes.582"), new String[] {}); //$NON-NLS-1$

		Properties msg = new Properties();
		msg.put(Messages.getString("FileTypes.583"), Messages.getString("FileTypes.584")); //$NON-NLS-1$ //$NON-NLS-2$
		msg.put(Messages.getString("FileTypes.585"), new String[] { Messages.getString("FileTypes.586") }); //$NON-NLS-1$ //$NON-NLS-2$
		msg.put(Messages.getString("FileTypes.587"), new String[] { Messages.getString("FileTypes.588") }); // "��ࡱ�" //$NON-NLS-1$ //$NON-NLS-2$
		msg.put(Messages.getString("FileTypes.589"), Messages.getString("FileTypes.590")); //$NON-NLS-1$ //$NON-NLS-2$
		msg.put(Messages.getString("FileTypes.591"), new MicrosoftOutlookMailMessage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.592")); //$NON-NLS-1$
		properties.add(msg);
		msg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.593")));
		applications.putIfAbsent(Messages.getString("FileTypes.594"), new String[] {}); //$NON-NLS-1$

		Properties dex = new Properties();
		dex.put(Messages.getString("FileTypes.595"), Messages.getString("FileTypes.596")); //$NON-NLS-1$ //$NON-NLS-2$
		dex.put(Messages.getString("FileTypes.597"), new String[] { Messages.getString("FileTypes.598") }); //$NON-NLS-1$ //$NON-NLS-2$
		dex.put(Messages.getString("FileTypes.599"), new String[] { Messages.getString("FileTypes.600") }); // "dex //$NON-NLS-1$ //$NON-NLS-2$
		// 035 "
		dex.put(Messages.getString("FileTypes.601"), Messages.getString("FileTypes.602")); //$NON-NLS-1$ //$NON-NLS-2$
		dex.put(Messages.getString("FileTypes.603"), new DalvikExecutable()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.604")); //$NON-NLS-1$
		properties.add(dex);
		dex = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.605")));
		applications.putIfAbsent(Messages.getString("FileTypes.606"), new String[] {}); //$NON-NLS-1$

		Properties crx = new Properties();
		crx.put(Messages.getString("FileTypes.607"), Messages.getString("FileTypes.608")); //$NON-NLS-1$ //$NON-NLS-2$
		crx.put(Messages.getString("FileTypes.609"), new String[] { Messages.getString("FileTypes.610") }); //$NON-NLS-1$ //$NON-NLS-2$
		crx.put(Messages.getString("FileTypes.611"), new String[] { Messages.getString("FileTypes.612") }); // "Cr24" //$NON-NLS-1$ //$NON-NLS-2$
		crx.put(Messages.getString("FileTypes.613"), Messages.getString("FileTypes.614")); //$NON-NLS-1$ //$NON-NLS-2$
		crx.put(Messages.getString("FileTypes.615"), new GoogleChromeExtension()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.616")); //$NON-NLS-1$
		properties.add(crx);
		crx = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.617")));
		applications.putIfAbsent(Messages.getString("FileTypes.618"), new String[] {}); //$NON-NLS-1$

		Properties dmg = new Properties();
		dmg.put(Messages.getString("FileTypes.619"), Messages.getString("FileTypes.620")); //$NON-NLS-1$ //$NON-NLS-2$
		dmg.put(Messages.getString("FileTypes.621"), new String[] { Messages.getString("FileTypes.622") }); //$NON-NLS-1$ //$NON-NLS-2$
		dmg.put(Messages.getString("FileTypes.623"), new String[] { Messages.getString("FileTypes.624") }); // "xs //$NON-NLS-1$ //$NON-NLS-2$
		// bb`"
		dmg.put(Messages.getString("FileTypes.625"), Messages.getString("FileTypes.626")); //$NON-NLS-1$ //$NON-NLS-2$
		dmg.put(Messages.getString("FileTypes.627"), new AppleDiscImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.628")); //$NON-NLS-1$
		properties.add(dmg);
		dmg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.629")));
		applications.putIfAbsent(Messages.getString("FileTypes.630"), new String[] {}); //$NON-NLS-1$

		Properties sevenz = new Properties();
		sevenz.put(Messages.getString("FileTypes.631"), Messages.getString("FileTypes.632")); //$NON-NLS-1$ //$NON-NLS-2$
		sevenz.put(Messages.getString("FileTypes.633"), new String[] { Messages.getString("FileTypes.634") }); //$NON-NLS-1$ //$NON-NLS-2$
		sevenz.put(Messages.getString("FileTypes.635"), new String[] { Messages.getString("FileTypes.636") }); // "7z��' //$NON-NLS-1$ //$NON-NLS-2$
																												// "
		sevenz.put(Messages.getString("FileTypes.637"), Messages.getString("FileTypes.638")); //$NON-NLS-1$ //$NON-NLS-2$
		sevenz.put(Messages.getString("FileTypes.639"), new SevenZipCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.640")); //$NON-NLS-1$
		properties.add(sevenz);
		sevenz = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.641")));
		applications.putIfAbsent(Messages.getString("FileTypes.642"), new String[] {}); //$NON-NLS-1$

		Properties targz = new Properties();
		targz.put(Messages.getString("FileTypes.643"), Messages.getString("FileTypes.644")); //$NON-NLS-1$ //$NON-NLS-2$
		targz.put(Messages.getString("FileTypes.645"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.646"), Messages.getString("FileTypes.647") }); //$NON-NLS-1$ //$NON-NLS-2$
		targz.put(Messages.getString("FileTypes.648"), new String[] { Messages.getString("FileTypes.649") }); // " //$NON-NLS-1$ //$NON-NLS-2$
																												// �"
		targz.put(Messages.getString("FileTypes.650"), Messages.getString("FileTypes.651")); //$NON-NLS-1$ //$NON-NLS-2$
		targz.put(Messages.getString("FileTypes.652"), new GzipCompressedFile()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.653")); //$NON-NLS-1$
		properties.add(targz);
		targz = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.654")));
		applications.putIfAbsent(Messages.getString("FileTypes.655"), new String[] {}); //$NON-NLS-1$

		Properties tarxz = new Properties();
		tarxz.put(Messages.getString("FileTypes.656"), Messages.getString("FileTypes.657")); //$NON-NLS-1$ //$NON-NLS-2$
		tarxz.put(Messages.getString("FileTypes.658"), new String[] { Messages.getString("FileTypes.659") }); //$NON-NLS-1$ //$NON-NLS-2$
		tarxz.put(Messages.getString("FileTypes.660"), new String[] { Messages.getString("FileTypes.661") }); // "�7zXZ " //$NON-NLS-1$ //$NON-NLS-2$
		tarxz.put(Messages.getString("FileTypes.662"), Messages.getString("FileTypes.663")); //$NON-NLS-1$ //$NON-NLS-2$
		tarxz.put(Messages.getString("FileTypes.664"), new XzCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.665")); //$NON-NLS-1$
		properties.add(tarxz);
		tarxz = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.666")));
		applications.putIfAbsent(Messages.getString("FileTypes.667"), new String[] {}); //$NON-NLS-1$

		Properties cab = new Properties();
		cab.put(Messages.getString("FileTypes.668"), Messages.getString("FileTypes.669")); //$NON-NLS-1$ //$NON-NLS-2$
		cab.put(Messages.getString("FileTypes.670"), new String[] { Messages.getString("FileTypes.671") }); //$NON-NLS-1$ //$NON-NLS-2$
		cab.put(Messages.getString("FileTypes.672"), new String[] { Messages.getString("FileTypes.673") }); // "MSCF" //$NON-NLS-1$ //$NON-NLS-2$
		cab.put(Messages.getString("FileTypes.674"), Messages.getString("FileTypes.675")); //$NON-NLS-1$ //$NON-NLS-2$
		cab.put(Messages.getString("FileTypes.676"), new WindowsCabinet()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.677")); //$NON-NLS-1$
		properties.add(cab);
		cab = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.678")));
		applications.putIfAbsent(Messages.getString("FileTypes.679"), new String[] {}); //$NON-NLS-1$

		Properties dicom = new Properties();
		dicom.put(Messages.getString("FileTypes.680"), Messages.getString("FileTypes.681")); //$NON-NLS-1$ //$NON-NLS-2$
		dicom.put(Messages.getString("FileTypes.682"), new String[] { Messages.getString("FileTypes.683"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.684"), Messages.getString("FileTypes.685") }); //$NON-NLS-1$ //$NON-NLS-2$
		dicom.put(Messages.getString("FileTypes.686"), new String[] { Messages.getString("FileTypes.687") }); // "DICM" //$NON-NLS-1$ //$NON-NLS-2$
		dicom.put(Messages.getString("FileTypes.688"), Messages.getString("FileTypes.689")); //$NON-NLS-1$ //$NON-NLS-2$
		dicom.put(Messages.getString("FileTypes.690"), new DicomImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.691")); //$NON-NLS-1$
		properties.add(dicom);
		dicom = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.692")));
		applications.putIfAbsent(Messages.getString("FileTypes.693"), new String[] {}); //$NON-NLS-1$

		Properties woff = new Properties();
		woff.put(Messages.getString("FileTypes.694"), Messages.getString("FileTypes.695")); //$NON-NLS-1$ //$NON-NLS-2$
		woff.put(Messages.getString("FileTypes.696"), new String[] { Messages.getString("FileTypes.697") }); //$NON-NLS-1$ //$NON-NLS-2$
		woff.put(Messages.getString("FileTypes.698"), new String[] { Messages.getString("FileTypes.699") }); // "wOFF" //$NON-NLS-1$ //$NON-NLS-2$
		woff.put(Messages.getString("FileTypes.700"), Messages.getString("FileTypes.701")); //$NON-NLS-1$ //$NON-NLS-2$
		woff.put(Messages.getString("FileTypes.702"), new WebOpenFontFormat()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.703")); //$NON-NLS-1$
		properties.add(woff);
		woff = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.704")));
		applications.putIfAbsent(Messages.getString("FileTypes.705"), new String[] {}); //$NON-NLS-1$

		Properties woff2 = new Properties();
		woff2.put(Messages.getString("FileTypes.706"), Messages.getString("FileTypes.707")); //$NON-NLS-1$ //$NON-NLS-2$
		woff2.put(Messages.getString("FileTypes.708"), new String[] { Messages.getString("FileTypes.709") }); //$NON-NLS-1$ //$NON-NLS-2$
		woff2.put(Messages.getString("FileTypes.710"), new String[] { Messages.getString("FileTypes.711") }); // "wOF2" //$NON-NLS-1$ //$NON-NLS-2$
		woff2.put(Messages.getString("FileTypes.712"), Messages.getString("FileTypes.713")); //$NON-NLS-1$ //$NON-NLS-2$
		woff2.put(Messages.getString("FileTypes.714"), new WebOpenFontFormat2()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.715")); //$NON-NLS-1$
		properties.add(woff2);
		woff2 = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.716")));
		applications.putIfAbsent(Messages.getString("FileTypes.717"), new String[] {}); //$NON-NLS-1$

		Properties xml = new Properties();
		xml.put(Messages.getString("FileTypes.718"), Messages.getString("FileTypes.719")); //$NON-NLS-1$ //$NON-NLS-2$
		xml.put(Messages.getString("FileTypes.720"), new String[] { Messages.getString("FileTypes.721") }); //$NON-NLS-1$ //$NON-NLS-2$
		xml.put(Messages.getString("FileTypes.722"), new String[] { Messages.getString("FileTypes.723") }); // "<?xml //$NON-NLS-1$ //$NON-NLS-2$
																											// "
		xml.put(Messages.getString("FileTypes.724"), Messages.getString("FileTypes.725")); //$NON-NLS-1$ //$NON-NLS-2$
		xml.put(Messages.getString("FileTypes.726"), new XmleXtensibleMarkupLanguage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.727")); //$NON-NLS-1$
		properties.add(xml);
		xml = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.728")));
		applications.putIfAbsent(Messages.getString("FileTypes.729"), new String[] {}); //$NON-NLS-1$

		Properties webp = new Properties();
		webp.put(Messages.getString("FileTypes.730"), Messages.getString("FileTypes.731")); //$NON-NLS-1$ //$NON-NLS-2$
		webp.put(Messages.getString("FileTypes.732"), new String[] { Messages.getString("FileTypes.733") }); //$NON-NLS-1$ //$NON-NLS-2$
		webp.put(Messages.getString("FileTypes.734"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.735") }); // "RIFF----WEBP" //$NON-NLS-1$
		webp.put(Messages.getString("FileTypes.736"), Messages.getString("FileTypes.737")); //$NON-NLS-1$ //$NON-NLS-2$
		webp.put(Messages.getString("FileTypes.738"), new WebPImage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.739")); //$NON-NLS-1$
		properties.add(webp);
		webp = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.740")));
		applications.putIfAbsent(Messages.getString("FileTypes.741"), new String[] {}); //$NON-NLS-1$

		Properties rtf = new Properties();
		rtf.put(Messages.getString("FileTypes.742"), Messages.getString("FileTypes.743")); //$NON-NLS-1$ //$NON-NLS-2$
		rtf.put(Messages.getString("FileTypes.744"), new String[] { Messages.getString("FileTypes.745") }); //$NON-NLS-1$ //$NON-NLS-2$
		rtf.put(Messages.getString("FileTypes.746"), new String[] { Messages.getString("FileTypes.747") }); // "{\rtf1" //$NON-NLS-1$ //$NON-NLS-2$
		rtf.put(Messages.getString("FileTypes.748"), Messages.getString("FileTypes.749")); //$NON-NLS-1$ //$NON-NLS-2$
		rtf.put(Messages.getString("FileTypes.750"), new RichTextFormatDocument()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.751")); //$NON-NLS-1$
		properties.add(rtf);
		rtf = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.752")));
		applications.putIfAbsent(Messages.getString("FileTypes.753"), new String[] {}); //$NON-NLS-1$

		Properties tsv = new Properties();
		tsv.put(Messages.getString("FileTypes.754"), Messages.getString("FileTypes.755")); //$NON-NLS-1$ //$NON-NLS-2$
		tsv.put(Messages.getString("FileTypes.756"), new String[] { Messages.getString("FileTypes.757"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.758"), Messages.getString("FileTypes.759") }); //$NON-NLS-1$ //$NON-NLS-2$
		tsv.put(Messages.getString("FileTypes.760"), new String[] { Messages.getString("FileTypes.761") }); // "G" //$NON-NLS-1$ //$NON-NLS-2$
		tsv.put(Messages.getString("FileTypes.762"), Messages.getString("FileTypes.763")); //$NON-NLS-1$ //$NON-NLS-2$
		tsv.put(Messages.getString("FileTypes.764"), new MpegTransportStream()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.765")); //$NON-NLS-1$
		properties.add(tsv);
		tsv = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.766")));
		applications.putIfAbsent(Messages.getString("FileTypes.767"), new String[] {}); //$NON-NLS-1$

		Properties mpeg = new Properties();
		mpeg.put(Messages.getString("FileTypes.768"), Messages.getString("FileTypes.769")); //$NON-NLS-1$ //$NON-NLS-2$
		mpeg.put(Messages.getString("FileTypes.770"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.771"), Messages.getString("FileTypes.772"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.773"), Messages.getString("FileTypes.774") }); //$NON-NLS-1$ //$NON-NLS-2$
		mpeg.put(Messages.getString("FileTypes.775"), new String[] { Messages.getString("FileTypes.776"), //$NON-NLS-1$ //$NON-NLS-2$
				Messages.getString("FileTypes.777"), Messages.getString("FileTypes.778") }); // "  �", //$NON-NLS-1$ //$NON-NLS-2$
																								// "G", "  �"
		mpeg.put(Messages.getString("FileTypes.779"), Messages.getString("FileTypes.780")); //$NON-NLS-1$ //$NON-NLS-2$
		mpeg.put(Messages.getString("FileTypes.781"), new MpegVideo()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.782")); //$NON-NLS-1$
		properties.add(mpeg);
		mpeg = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.783")));
		applications.putIfAbsent(Messages.getString("FileTypes.784"), new String[] {}); //$NON-NLS-1$

		Properties zlib = new Properties();
		zlib.put(Messages.getString("FileTypes.785"), Messages.getString("FileTypes.786")); //$NON-NLS-1$ //$NON-NLS-2$
		zlib.put(Messages.getString("FileTypes.787"), new String[] { Messages.getString("FileTypes.788") }); //$NON-NLS-1$ //$NON-NLS-2$
		zlib.put(Messages.getString("FileTypes.789"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.790"), Messages.getString("FileTypes.791"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.792"), Messages.getString("FileTypes.793"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.794"), Messages.getString("FileTypes.795"), //$NON-NLS-1$ //$NON-NLS-2$
						Messages.getString("FileTypes.796"), Messages.getString("FileTypes.797") }); // "x", //$NON-NLS-1$ //$NON-NLS-2$
		// "x^",
		// "x�",
		// "x�",
		// "x ",
		// "x}",
		// "x�",
		// "x�"
		zlib.put(Messages.getString("FileTypes.798"), Messages.getString("FileTypes.799")); //$NON-NLS-1$ //$NON-NLS-2$
		zlib.put(Messages.getString("FileTypes.800"), new ZlibCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.801")); //$NON-NLS-1$
		properties.add(zlib);
		zlib = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.802")));
		applications.putIfAbsent(Messages.getString("FileTypes.803"), new String[] {}); //$NON-NLS-1$

		Properties eml = new Properties();
		eml.put(Messages.getString("FileTypes.804"), Messages.getString("FileTypes.805")); //$NON-NLS-1$ //$NON-NLS-2$
		eml.put(Messages.getString("FileTypes.806"), new String[] { Messages.getString("FileTypes.807") }); //$NON-NLS-1$ //$NON-NLS-2$
		eml.put(Messages.getString("FileTypes.808"), new String[] { Messages.getString("FileTypes.809") }); // "Received" //$NON-NLS-1$ //$NON-NLS-2$
		eml.put(Messages.getString("FileTypes.810"), Messages.getString("FileTypes.811")); //$NON-NLS-1$ //$NON-NLS-2$
		eml.put(Messages.getString("FileTypes.812"), new EmailMessage()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.813")); //$NON-NLS-1$
		properties.add(eml);
		eml = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.814")));
		applications.putIfAbsent(Messages.getString("FileTypes.815"), new String[] {}); //$NON-NLS-1$

		Properties tde = new Properties();
		tde.put(Messages.getString("FileTypes.816"), Messages.getString("FileTypes.817")); //$NON-NLS-1$ //$NON-NLS-2$
		tde.put(Messages.getString("FileTypes.818"), new String[] { Messages.getString("FileTypes.819") }); //$NON-NLS-1$ //$NON-NLS-2$
		tde.put(Messages.getString("FileTypes.820"), new String[] { Messages.getString("FileTypes.821") }); // " //$NON-NLS-1$ //$NON-NLS-2$
																											// b�
																											// �   "
		tde.put(Messages.getString("FileTypes.822"), Messages.getString("FileTypes.823")); //$NON-NLS-1$ //$NON-NLS-2$
		tde.put(Messages.getString("FileTypes.824"), new TableauDataExtract()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.825")); //$NON-NLS-1$
		properties.add(tde);
		tde = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.826")));
		applications.putIfAbsent(Messages.getString("FileTypes.827"), new String[] {}); //$NON-NLS-1$

		Properties zst = new Properties();
		zst.put(Messages.getString("FileTypes.828"), Messages.getString("FileTypes.829")); //$NON-NLS-1$ //$NON-NLS-2$
		zst.put(Messages.getString("FileTypes.830"), //$NON-NLS-1$
				new String[] { Messages.getString("FileTypes.831"), Messages.getString("FileTypes.832") }); //$NON-NLS-1$ //$NON-NLS-2$
		zst.put(Messages.getString("FileTypes.833"), new String[] { Messages.getString("FileTypes.834") }); // "(�/�" //$NON-NLS-1$ //$NON-NLS-2$
		zst.put(Messages.getString("FileTypes.835"), Messages.getString("FileTypes.836")); //$NON-NLS-1$ //$NON-NLS-2$
		zst.put(Messages.getString("FileTypes.837"), new ZStandardCompressedArchive()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.838")); //$NON-NLS-1$
		properties.add(zst);
		zst = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.839")));
		applications.putIfAbsent(Messages.getString("FileTypes.840"), new String[] {}); //$NON-NLS-1$

		Properties vpk = new Properties();
		vpk.put(Messages.getString("FileTypes.841"), Messages.getString("FileTypes.842")); //$NON-NLS-1$ //$NON-NLS-2$
		vpk.put(Messages.getString("FileTypes.843"), new String[] { Messages.getString("FileTypes.844") }); //$NON-NLS-1$ //$NON-NLS-2$
		vpk.put(Messages.getString("FileTypes.845"), new String[] { Messages.getString("FileTypes.846") }); // "4�U" //$NON-NLS-1$ //$NON-NLS-2$
		vpk.put(Messages.getString("FileTypes.847"), Messages.getString("FileTypes.848")); //$NON-NLS-1$ //$NON-NLS-2$
		vpk.put(Messages.getString("FileTypes.849"), new ValvePak()); //$NON-NLS-1$
		mime.add(Messages.getString("FileTypes.850")); //$NON-NLS-1$
		properties.add(vpk);
		vpk = null;
		new File(_root + ((Properties) properties.get(mime.size() - 1)).get(Messages.getString("FileTypes.851")));
		applications.putIfAbsent(Messages.getString("FileTypes.852"), new String[] {}); //$NON-NLS-1$

		fileTypes.add(mime);
		fileTypes.add(properties);
		out.writeObject(fileTypes);
		out.close();

		out = new ObjectOutputStream(new FileOutputStream(applicationsFile));
		out.writeObject(applications);
		out.close();

		if (!new File(defaultApplicationsFile).isFile()) {
			Properties defaultApplications = new Properties();
			defaultApplications.storeToXML(new FileOutputStream(defaultApplicationsFile),
					Messages.getString("FileTypes.853")); //$NON-NLS-1$
		}

		Properties applicationsSyntax = new Properties();
		applicationsSyntax.store(new FileOutputStream(applicationsSyntaxFile), Messages.getString("FileTypes.854")); //$NON-NLS-1$

		createEditorList();
	}

	/**
	 * @throws IOException
	 */
	private static void createEditorList() throws IOException {
		String[] editors = new String[] { Messages.getString("FileTypes.855"), Messages.getString("FileTypes.856") }; //$NON-NLS-1$ //$NON-NLS-2$
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
