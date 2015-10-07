/**
 * Created by ColinForage on 9/21/15.
 */
import java.io.*;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ReadDocx
{
    public static void main(String[] args)
    {
        File file = null;
        XWPFWordExtractor extractor;
        FileInputStream fis;
        try
        {

            file = new File("/Users/ColinForage/Play Framework/Blucite/src/Cite Example One.docx");
            fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            extractor = new XWPFWordExtractor(document);
            System.out.println("Extracting text...");
            String fileData = extractor.getText();
            System.out.println("Printing text...\n");
            System.out.println(fileData);

            // fileData contains one continuous string that we will now begin parsing out the footnotes
            FootnoteExtractor fe = new FootnoteExtractor(fileData);
            String[] footnotes = fe.getFootnotes();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            fis.close();
        }

    }
}
