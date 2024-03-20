import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("trump")
    public Politician trump() {
        return new Trump();
    }

    @Bean("biden")
    public Politician biden() {
        return new Biden();
    }

    @Bean("merkel")
    public Politician merkel() {
        return new Merkel();
    }
}
