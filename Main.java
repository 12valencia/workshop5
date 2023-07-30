import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue <HtmlTag> queuehtml = null;
        try {
            queuehtml = HtmlReader.getTagsFromHtmlFile("ejemplo1.html");//se pone el archivo html que desea buscar
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        Stack <HtmlTag> stackhtml = Htmlvalidacion.isValidHtml(queuehtml);

        if(stackhtml == null){
            System.out.println("html nullo");
        } else if (stackhtml.empty()) {
            System.out.println("Esta bien formateado");
        }else {
            System.out.println("No se formateo");

            for(HtmlTag h:stackhtml){
                System.out.println(h);
            }
        }

    }
}
