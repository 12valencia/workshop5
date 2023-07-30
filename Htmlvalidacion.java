import java.util.Queue;
import java.util.Stack;

public class Htmlvalidacion {
    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> htmltagsQueue) {
        Stack<HtmlTag> htmlTagStack = new Stack<>();
        //llamdano del html
        for(HtmlTag htmlTag:htmltagsQueue){

            //aqui validad si se abrio el html
            if(htmlTag.isOpenTag()){
                htmlTagStack.push(htmlTag);//aqui lo almacena en la ultima posicion de la pila
            }else{
                if(!htmlTag.isSelfClosing()){//si esta vacion
                    if(htmlTagStack.empty()){//si esta vacion retonne nulo
                        return null;
                    }
                    HtmlTag tophtmltag = htmlTagStack.peek();
                    if(htmlTag.matches(tophtmltag)){
                        htmlTagStack.pop();
                    }else{
                        return htmlTagStack;
                    }
                }
            }
        }

        return htmlTagStack;
    }
}
