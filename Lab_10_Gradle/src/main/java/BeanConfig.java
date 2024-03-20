import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Politician trump() {
        return new Trump();
    }

    @Bean
    public Politician biden() {
        return new Biden();
    }

    @Bean
    public Politician merkel() {
        return new Merkel();
    }
}
