import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Politician politician = null;
        if (args.length != 0) {
            switch (args[0].toLowerCase()) {
                case "trump":
                    politician = context.getBean(Trump.class);
                    break;
                case "biden":
                    politician = context.getBean(Biden.class);
                    break;
                case "merkel":
                    politician = context.getBean(Merkel.class);
                    break;
            }
        }
        if (politician == null) {
            System.out.println("Incorrect argument");
        }
        else {
            politician.doPolitic();
        }
    }
}