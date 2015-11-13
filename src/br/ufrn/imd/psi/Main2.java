package br.ufrn.imd.psi;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.text.EditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Main2 {
  public static void main(String[] argv) throws Exception {
    URL url = new URI("http://www.bing.com/").toURL();
    URLConnection conn = url.openConnection();
    Reader rd = new InputStreamReader(conn.getInputStream());

    EditorKit kit = new HTMLEditorKit();
    HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
    kit.read(rd, doc, 0);

    HTMLDocument.Iterator it = doc.getIterator(HTML.Tag.A);
    while (it.isValid()) {
      SimpleAttributeSet s = (SimpleAttributeSet) it.getAttributes();

      String link = (String) s.getAttribute(HTML.Attribute.HREF);
      if (link != null) {
        System.out.println(link);
      }
      it.next();
    }
  }
}