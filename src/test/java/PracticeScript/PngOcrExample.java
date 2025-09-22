package PracticeScript;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//
//import javax.imageio.ImageIO;
//
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//
//public class PngOcrExample {
//    public static void main(String[] args) throws Exception {
//        File imageFile = new File("C:\\Users\\SQA_TESTING_PC\\eclipse-workspace\\cemr.automation\\ErrorShot\\Captch.png"); // your PNG file
//        BufferedImage img = ImageIO.read(imageFile);
//
//        ITesseract tesseract = new Tesseract();
//
//        // Set path to tessdata (only needed if TESSDATA_PREFIX env var is not set)
//        tesseract.setDatapath("C:\\\\Users\\\\SQA_TESTING_PC\\\\eclipse-workspace\\\\cemr.automation\\\\ErrorShot\\\\Captch.png");
//
//        // Set language (English). You can add more like "eng+hin"
//        tesseract.setLanguage("eng");
//
//        try {
//            String text = tesseract.doOCR(img);
//            System.out.println("Extracted text:\n" + text);
//        } catch (TesseractException e) {
//            e.printStackTrace();
//        }
//    }
//}